package services;

import java.util.*;

public class PhoneBook {
    private TreeMap<String, String> contacts = new TreeMap<>();

    public void processInput(String input, Scanner sc) {
        // Проверка: это номер (только цифры) или имя?
        if (input.matches("\\d+")) {
            handlePhone(input, sc);
        } else if (input.matches("^[a-zA-Zа-яА-ЯёЁ ]+$")) {
            handleName(input, sc);
        } else {
            System.out.println("❌ Ошибка: Ввод содержит недопустимые символы!");
        }
    }

    private void handlePhone(String phone, Scanner sc) {
        String name = findNameByPhone(phone);
        if (name != null) {
            System.out.println("🔍 Контакт найден: " + name + " — " + phone);
        } else {
            System.out.print("📞 Новый номер! Введите имя владельца: ");
            String newName = sc.nextLine();
            contacts.put(newName, phone);
            System.out.println("✅ Контакт сохранен.");
        }
    }

    private void handleName(String name, Scanner sc) {
        if (contacts.containsKey(name)) {
            System.out.println("🔍 Контакт найден: " + name + " — " + contacts.get(name));
        } else {
            System.out.print("👤 Новое имя! Введите номер телефона (только цифры): ");
            String newPhone = sc.nextLine();

            // ПРОВЕРКА: если вместо номера ввели текст
            if (newPhone.matches("\\d+")) {
                contacts.put(name, newPhone);
                System.out.println("✅ Контакт сохранен.");
            } else {
                System.out.println("❌ Ошибка: Номер должен состоять только из ЦИФР! Попробуйте снова.");
            }
        }
    }

    private String findNameByPhone(String phone) {
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            if (entry.getValue().equals(phone)) return entry.getKey();
        }
        return null;
    }

    public void list() {
        if (contacts.isEmpty()) {
            System.out.println("📖 Телефонная книга пуста.");
        } else {
            System.out.println("📖 Список контактов (по алфавиту):");
            contacts.forEach((name, phone) -> System.out.println(name + " -> " + phone));
        }
    }
}
