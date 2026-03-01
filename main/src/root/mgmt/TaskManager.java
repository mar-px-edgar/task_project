package root.mgmt;

import java.util.*;


public class TaskManager {
    Scanner scanner = new Scanner(System.in);
    // collection of tasks
    List<Task> tasks = new ArrayList<>();
    public void add() {
        System.out.println("Название задачи: ");
        String name = scanner.nextLine();
        System.out.println("Приоритет (от 0 до 5): ");
        Integer priority = Integer.parseInt(scanner.nextLine());
        System.out.println("Статус задачи (1-not assigned, 2-assigned, 3-done");
        int temp_status = Integer.parseInt(scanner.nextLine());
        Status status = switch (temp_status) {
            case 1 -> Status.NOT_ASSIGNED;
            case 2 -> Status.ASSIGNED;
            case 3 -> Status.FINISHED;
            default ->
                // if input is invalid, default to NOT_ASSIGNED
                    Status.NOT_ASSIGNED;
        };
        tasks.add(new Task(name, priority, status));
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

    public void saveToCsv() {

    }
}
