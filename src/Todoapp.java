import java.util.ArrayList;
import java.util.Scanner;

public class Todoapp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nTo-Do List Options:");
            System.out.println("1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. List Tasks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            // Check if the input is an integer
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addTask();
                    case 2 -> editTask();
                    case 3 -> deleteTask();
                    case 4 -> listTasks();
                    case 5 -> running = false;
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }else{
                // If input is not an integer, show an error message
                System.out.println("Invalid input. Please enter a number from 1 to 5.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }

    private static void addTask() {
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();
        tasks.add(new Task(name));
        System.out.println("Task added successfully.");
    }

    private static void editTask() {
        System.out.print("Enter task ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Task task : tasks) {
            if (task.getId() == id) {
                System.out.print("Enter new task name: ");
                task.setName(scanner.nextLine());
                System.out.print("Is the task completed? (yes/no): ");
                String completed = scanner.nextLine().toLowerCase();
                task.setCompleted(completed.equals("yes"));
                System.out.println("Task updated successfully.");
                return;
            }
        }
        System.out.println("Task ID not found.");
    }

    private static void deleteTask() {
        System.out.print("Enter task ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        tasks.removeIf(task -> task.getId() == id);
        System.out.println("Task deleted successfully (if it existed).");
    }

    private static void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("Current Tasks:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}
