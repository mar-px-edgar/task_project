package root.mgmt;

import java.io.*;
import java.util.*;


public class TaskManager {
    Scanner scanner = new Scanner(System.in);
    // collection of tasks
    List<Task> tasks = new ArrayList<>();
    public void add() {
        while (true) {
            System.out.print("Название задачи: ");
            String name = scanner.nextLine();
            System.out.print("Приоритет (от 0 до 5): ");
            Integer priority = Integer.parseInt(scanner.nextLine());
            if (!checkPriority(priority)) {
                System.out.println("Приоритет должен быть от 0 до 5. Задача не добавлена.");
                continue; // prompt again if priority is invalid
            }
            System.out.print("Статус задачи (1-not assigned, 2-assigned, 3-done): ");
            int temp_status = Integer.parseInt(scanner.nextLine());
            if  (temp_status == 1) {
                tasks.add(new Task(name, priority, Status.NOT_ASSIGNED));
            } else if (temp_status == 2) {
                tasks.add(new Task(name, priority, Status.ASSIGNED));
            } else if (temp_status == 3) {
                tasks.add(new Task(name, priority, Status.FINISHED));
            } else {
                System.out.println("Неверный статус. Задача не добавлена.");
                continue; // prompt again if status is invalid
            }
            break; // exit loop after successful addition
        }
    }
    public void markDone() {
        System.out.println("Название задачи: ");
        String name = scanner.nextLine();
        boolean found = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)){
                task.setStatus(Status.FINISHED);
                System.out.println("Задача '" + name + "' отмечена как выполненная.");
                found = true;
                break; // assume names are unique; stop after marking
            }
        }
        if (!found) {
            System.out.println("Задача с названием '" + name + "' не найдена.");
        }
    }

    public void showAll() {
        if (tasks.isEmpty()) {
            System.out.println("Нет задач для отображения.");
            return;
        }
        System.out.println("Все задачи:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    public void showActive() {
        boolean hasActive = false;
        System.out.println("Активные задачи:");
        for (Task task : tasks) {
            if (task.getStatus() != Status.FINISHED) {
                System.out.println(task);
                hasActive = true;
            }
        }
        if (!hasActive) {
            System.out.println("Нет активных задач.");
        }
    }

    public void saveToCsv() throws IOException {
        try (PrintWriter writer = new PrintWriter("tasks.csv")){
            for (Task task : tasks) {
                writer.println(task.getName() + "," + task.getPriority() + "," + task.getStatus());
            }
        }
    }

    public void loadFromCsv() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader("tasks.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0];
                    int priority = Integer.parseInt(parts[1]);
                    Status status = Status.valueOf(parts[2]);
                    tasks.add(new Task(name, priority, status));
                }
            }
        }
    }


    public boolean checkPriority(Integer priority) {
        return priority >= 0 && priority <= 5;
    }
}
