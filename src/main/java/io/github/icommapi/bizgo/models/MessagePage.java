package io.github.icommapi.bizgo.models;

import java.util.List;
import java.util.Objects;

/** One page of send history. */
public final class MessagePage {

    private final List<MessageStatus> messages;
    private final Long lastSeq;
    private final boolean hasNext;

    /**
     * Creates a page.
     *
     * @param messages items, may be null
     * @param lastSeq cursor for the next page, may be null
     * @param hasNext whether the server has more pages
     */
    public MessagePage(List<MessageStatus> messages, Long lastSeq, boolean hasNext) {
        this.messages = messages == null ? List.of() : List.copyOf(messages);
        this.lastSeq = lastSeq;
        this.hasNext = hasNext;
    }

    /**
     * Items on this page.
     *
     * @return unmodifiable list
     */
    public List<MessageStatus> getMessages() {
        return messages;
    }

    /**
     * Cursor to pass as {@code lastSeq} for the next page.
     *
     * @return cursor, or null
     */
    public Long getLastSeq() {
        return lastSeq;
    }

    /**
     * Whether another page exists.
     *
     * @return true if there are more pages
     */
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MessagePage)) {
            return false;
        }
        MessagePage other = (MessagePage) o;
        return messages.equals(other.messages) && Objects.equals(lastSeq, other.lastSeq) && hasNext == other.hasNext;
    }

    @Override
    public int hashCode() {
        return Objects.hash(messages, lastSeq, hasNext);
    }

    @Override
    public String toString() {
        return "MessagePage{messages=" + messages.size() + ", lastSeq=" + lastSeq + ", hasNext=" + hasNext + "}";
    }
}
