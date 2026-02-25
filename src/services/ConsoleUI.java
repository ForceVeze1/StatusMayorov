package services;

public class ConsoleUI {
    // ANSI коды для цветов
    private static final String RESET = "\u001B[0m";
    private static final String PURPLE = "\u001b[35m";
    private static final String BRIGHT_PURPLE = "\u001b[35m";

    // Метод для эффекта "переливающегося" красного заголовка
    public static void printRedMenu() {
        String title = "=== ГЛАВНОЕ МЕНЮ СИСТЕМЫ ===";
        try {
            // Печатаем заголовок, переливая оттенки красного
            for (char c : title.toCharArray()) {
                // Чередуем обычный красный и ярко-красный для эффекта мерцания
                String color = (Math.random() > 0.5) ? PURPLE : BRIGHT_PURPLE;
                System.out.print(color + c);
                Thread.sleep(30); // Задержка для эффекта "печати"
            }
            System.out.println(RESET);

            // Сами пункты меню просто красным
            System.out.println(PURPLE + "1 - Работа с сообщениями (ArrayList/Set)");
            System.out.println(BRIGHT_PURPLE + "2 - Работа с Email (TreeSet)");
            System.out.println(PURPLE + "3 - Телефонная книга (TreeMap)");
            System.out.println(BRIGHT_PURPLE + "0 - Выход" + RESET);
            System.out.print(PURPLE + "Выберите пункт: " + RESET);

        } catch (InterruptedException e) {
            System.out.println(title);
        }
    }
}
