package services;

import java.util.TreeSet;

public class EmailManager {
    // TreeSet хранит данные в памяти, пока программа запущена
    private TreeSet<String> emails = new TreeSet<>();

    public void add(String email) {
        // Регулярка: только латиница, цифры, @ и точка. Никакой кириллицы!
        // [a-zA-Z0-9._-] - разрешенные символы
        if (email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-z]{2,}$")) {
            emails.add(email.toLowerCase());
            System.out.println("✅ Email успешно сохранен в список!");
        } else {
            System.out.println("❌ Ошибка: Неверный формат! Почта должна быть на латинице и содержать @ (например, test@mail.com)");
        }
    }

    public void list() {
        if (emails.isEmpty()) {
            System.out.println("📭 Список адресов пока пуст.");
        } else {
            System.out.println("📋 Список всех сохраненных Email:");
            emails.forEach(System.out::println);
        }
    }
}
