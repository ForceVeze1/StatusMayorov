package services;

import models.Message;
import models.Priority;
import java.util.*;
import java.util.stream.Collectors;

public class MessageService {
    private List<Message> messages = new ArrayList<>();

    public void generateRandom() {
        Random r = new Random();
        Priority[] p = Priority.values();
        for (int i = 0; i < 20; i++) {
            // Специально создаем повторы (код от 1 до 10)
            messages.add(new Message(r.nextInt(10) + 1, "Текст-" + i, p[r.nextInt(p.length)]));
        }
    }

    public List<Message> getUnique() {
        return new ArrayList<>(new LinkedHashSet<>(messages));
    }

    public void deleteByPriority(Priority p) {
        System.out.println("--- Удаление приоритета " + p + " ---");
        System.out.println("До: " + messages.size());
        messages.removeIf(m -> m.getPriority() == p);
        System.out.println("После: " + messages.size());
    }

    public void retainOnlyPriority(Priority p) {
        System.out.println("--- Оставить только " + p + " ---");
        System.out.println("До: " + messages.size());
        messages.removeIf(m -> m.getPriority() != p);
        System.out.println("После: " + messages.size());
    }

    public void printStatistics() {
        System.out.println("\n--- СТАТИСТИКА ---");
        Map<Priority, Long> countByP = messages.stream().collect(Collectors.groupingBy(Message::getPriority, Collectors.counting()));
        Map<Integer, Long> countByC = messages.stream().collect(Collectors.groupingBy(Message::getCode, Collectors.counting()));

        System.out.println("По приоритетам: " + countByP);
        System.out.println("По кодам: " + countByC);
        System.out.println("Всего уникальных: " + new HashSet<>(messages).size());
    }

    public List<Message> getAll() { return messages; }
}
