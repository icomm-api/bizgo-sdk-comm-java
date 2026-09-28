package io.github.icommapi.bizgo;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;

/**
 * Lazy iteration over paginated operations ({@code x-sdk-pagination}). Every {@link Iterable#iterator()} starts
 * over. Guards against server bugs: a cursor that does not move, or a page identical to the previous one, stops the
 * iteration instead of looping forever.
 */
final class Paging {

    private Paging() {
    }

    /**
     * Cursor pagination: stops when {@code hasNext} is false or missing, the next cursor is missing, or it does not
     * move.
     */
    static <T> Iterable<T> cursor(String start, Function<String, Transport.Page<T>> fetch, String itemsPath, String cursorPath,
            String hasNextPath, Class<T> type) {
        return () -> new PageIterator<>(type, itemsPath) {
            private String cursor = start;

            @Override
            Transport.Page<T> nextPage() {
                Transport.Page<T> page = fetch.apply(cursor);
                JsonNode body = page.body();
                JsonNode next = at(body, cursorPath);
                String nextCursor = next == null || next.isNull() || next.isMissingNode() ? null : next.asText();
                boolean more = hasNextPath == null || isTrue(at(body, hasNextPath));
                if (!more || nextCursor == null || nextCursor.isEmpty() || Objects.equals(nextCursor, cursor)) {
                    finished();
                } else {
                    cursor = nextCursor;
                }
                return page;
            }
        };
    }

    /**
     * Page or offset pagination: stops at an empty page, a page smaller than the requested size, when the total is
     * reached, or when {@code hasNext} is false. Offsets advance by the number of items received.
     */
    static <T> Iterable<T> numbered(int start, Integer size, boolean offset, IntFunction<Transport.Page<T>> fetch,
            String itemsPath, String totalPath, String hasNextPath, Class<T> type) {
        return () -> new PageIterator<>(type, itemsPath) {
            private int position = start;
            private long seen;

            @Override
            Transport.Page<T> nextPage() {
                Transport.Page<T> page = fetch.apply(position);
                JsonNode body = page.body();
                JsonNode items = at(body, itemsPath);
                int count = items != null && items.isArray() ? items.size() : 0;
                seen += count;
                JsonNode total = totalPath == null ? null : at(body, totalPath);
                JsonNode hasNext = hasNextPath == null ? null : at(body, hasNextPath);
                long reached = offset ? position + (long) count
                        : size != null ? (long) position * size : seen;
                if (count == 0 || (size != null && count < size)
                        || (total != null && total.canConvertToLong() && reached >= total.asLong())
                        || (hasNext != null && hasNext.isBoolean() && !hasNext.asBoolean())) {
                    finished();
                }
                position = offset ? position + count : position + 1;
                return page;
            }
        };
    }

    static Long toLong(String cursor) {
        return cursor == null ? null : Long.valueOf(cursor);
    }

    static Integer toInt(String cursor) {
        return cursor == null ? null : Integer.valueOf(cursor);
    }

    private static boolean isTrue(JsonNode node) {
        return node != null && node.isBoolean() && node.asBoolean();
    }

    /**
     * Follows a dotted path such as {@code data.data.items} or {@code data.data.items[-1].id} (negative indexes count
     * from the end).
     *
     * @return the node, or null if a step is missing
     */
    static JsonNode at(JsonNode root, String path) {
        JsonNode current = root;
        for (String part : path.split("\\.")) {
            if (current == null) {
                return null;
            }
            String name = part;
            Integer index = null;
            int bracket = part.indexOf('[');
            if (bracket >= 0 && part.endsWith("]")) {
                name = part.substring(0, bracket);
                index = Integer.valueOf(part.substring(bracket + 1, part.length() - 1));
            }
            current = current.get(name);
            if (current != null && index != null) {
                if (!current.isArray()) {
                    return null;
                }
                int i = index < 0 ? current.size() + index : index;
                current = i >= 0 && i < current.size() ? current.get(i) : null;
            }
        }
        return current;
    }

    private abstract static class PageIterator<T> implements Iterator<T> {
        private final Class<T> type;
        private final String itemsPath;
        private Iterator<T> current = Collections.emptyIterator();
        private boolean done;
        private JsonNode previousItems;

        PageIterator(Class<T> type, String itemsPath) {
            this.type = type;
            this.itemsPath = itemsPath;
        }

        abstract Transport.Page<T> nextPage();

        final void finished() {
            done = true;
        }

        @Override
        public boolean hasNext() {
            while (!current.hasNext() && !done) {
                Transport.Page<T> page = nextPage();
                JsonNode items = at(page.body(), itemsPath);
                if (items != null && items.size() > 0 && items.equals(previousItems)) {
                    done = true; // the server returned the same page again
                    return false;
                }
                previousItems = items;
                current = page.items().iterator(); // converted inside the call, so hooks see failures
            }
            return current.hasNext();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return current.next();
        }
    }
}
