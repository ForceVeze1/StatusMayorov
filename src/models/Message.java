package models;

import java.util.Objects;

public class Message {
    private final int code;
    private final String text;
    private final Priority priority;

    public Message(int code, String text, Priority priority) {
        this.code = code;
        this.text = text;
        this.priority = priority;
    }

    public int getCode() { return code; }
    public Priority getPriority() { return priority; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return code == message.code && Objects.equals(text, message.text) && priority == message.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, text, priority);
    }

    @Override
    public String toString() {
        return String.format("Код: %d | Приоритет: %-7s | Текст: %s", code, priority, text);
    }
}
