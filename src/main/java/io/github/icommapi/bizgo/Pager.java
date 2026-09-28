package io.github.icommapi.bizgo;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

/**
 * Lazily follows {@code lastSeq} across pages. Stops when {@code hasNext} is false, {@code lastSeq} is missing, or
 * the cursor does not move (so a server bug cannot cause an endless loop). Each {@link #iterator()} starts over.
 */
final class Pager<T> implements Iterable<T> {

    record Page<T>(List<T> items, Long lastSeq, boolean hasNext) {
    }

    private final Long start;
    private final Function<Long, Page<T>> fetch;

    Pager(Long start, Function<Long, Page<T>> fetch) {
        this.start = start;
        this.fetch = fetch;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Long cursor = start;
            private Iterator<T> current = Collections.emptyIterator();
            private boolean done;

            @Override
            public boolean hasNext() {
                while (!current.hasNext() && !done) {
                    Page<T> page = fetch.apply(cursor);
                    current = page.items().iterator();
                    if (!page.hasNext() || page.lastSeq() == null || Objects.equals(page.lastSeq(), cursor)) {
                        done = true;
                    } else {
                        cursor = page.lastSeq();
                    }
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
        };
    }
}
