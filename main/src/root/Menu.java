package root;
import root.mgmt.TaskManager;

import java.io.IOException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws IOException {
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
                    taskManager.loadFromCsv();
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
    public static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить задачу");
        System.out.println("2. Отметить задачу выполненной");
        System.out.println("3. Показать все задачи");
        System.out.println("4. Показать активные задачи");
        System.out.println("5. Сохранить задачи в CSV");
        System.out.println("6. Загрузить задачи из CSV");
        System.out.println("0. Выйти");
    }
}