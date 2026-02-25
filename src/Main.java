import models.Priority;
import services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MessageService ms = new MessageService();
        EmailManager em = new EmailManager();
        PhoneBook pb = new PhoneBook();

        while (true) {
            // Вызываем нашу красивую красную менюшку
            ConsoleUI.printRedMenu();

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    ms.generateRandom();
                    System.out.println("\u001B[32m✅ Сгенерировано 20 сообщений.\u001B[0m");
                    ms.getAll().forEach(System.out::println);
                    ms.printStatistics();
                    break;

                case "2":
                    System.out.println("\u001B[33mВведите 'add почта' или 'LIST':\u001B[0m");
                    String input = sc.nextLine();
                    if (input.equalsIgnoreCase("LIST")) {
                        em.list();
                    } else if (input.toLowerCase().startsWith("add ")) {
                        em.add(input.substring(4).trim());
                    } else {
                        System.out.println("⚠️ Используйте формат: add [email] или LIST");
                    }
                    break;

                case "3":
                    System.out.println("\u001B[33mВведите Имя, Номер или LIST:\u001B[0m");
                    String pInput = sc.nextLine();
                    if (pInput.equalsIgnoreCase("LIST")) {
                        pb.list();
                    } else {
                        pb.processInput(pInput, sc);
                    }
                    break;

                case "0":
                    System.out.println("\u001B[31mВыход из системы...\u001B[0m");
                    return;

                default:
                    System.out.println("\u001B[31m❌ Неверный пункт.\u001B[0m");
            }
        }
    }
}
