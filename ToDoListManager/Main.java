package ToDoListManager;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add user");
            System.out.println("2. Add task");
            System.out.println("3. Mark task as completed");
            System.out.println("4. View tasks");
            System.out.println("5. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();
                    addUser(userName);
                    break;
                case 2:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    addTaskToUser(userName, taskDescription);
                    break;
                case 3:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    System.out.print("Enter task description to mark as completed: ");
                    taskDescription = scanner.nextLine();
                    markTaskAsCompleted(userName, taskDescription);
                    break;
                case 4:
                    System.out.print("Enter user name: ");
                    userName = scanner.nextLine();
                    viewTasks(userName);
                    break;
                case 5:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addUser(String name) {
        users.add(new User(name));
    }

    private static void addTaskToUser(String userName, String description) {
        User user = findUserByName(userName);
        if (user != null) {
            user.addTask(description);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void markTaskAsCompleted(String userName, String description) {
        User user = findUserByName(userName);
        if (user != null) {
            user.markTaskAsCompleted(description);
        } else {
            System.out.println("User not found.");
        }
    }

    private static void viewTasks(String userName) {
        User user = findUserByName(userName);
        if (user != null) {
            user.printTasks();
        } else {
            System.out.println("User not found.");
        }
    }

    private static User findUserByName(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }
}

