package root;
import root.mgmt.TaskManager;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Выберите пункт: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Введите число!");
                continue;
            }
            switch (choice) {
                case 1:
                    System.out.println("Добавление задачи...");
                    taskManager.add();
                    break;
                case 2:
                    System.out.println("Отметить задачу выполненной...");
                    taskManager.markDone();
                case 3:
                    System.out.println("Показать все задачи...");
                    taskManager.showAll();
                    break;
                case 4:
                    System.out.println("Показать активные задачи...");
                    taskManager.showActive();
                    break;
                case 5:
                    System.out.println("Сохранение...");
                    taskManager.saveToCsv();
                    break;
                case 6:
                    System.out.println("Загрузка...");
                    taskManager.saveToCsv();
                    break;
                case 0:
                    System.out.println("Выход из программы");
                    running = false;
                    break;
                default:
                    System.out.println("Нет такого пункта!");
            }
            System.out.println(); // пустая строка
        }
        scanner.close();
    }
}