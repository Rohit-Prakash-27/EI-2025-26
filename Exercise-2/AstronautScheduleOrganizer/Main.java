import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskOperations operations = new TaskOperations();
        ScheduleManager.getInstance().addObserver(operations);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task Completed");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Start Time (HH:MM): ");
                    String start = sc.nextLine();
                    System.out.print("End Time (HH:MM): ");
                    String end = sc.nextLine();
                    System.out.print("Priority (High/Medium/Low): ");
                    String priority = sc.nextLine();
                    operations.addTask(desc, start, end, priority);
                    break;
                case 2:
                    System.out.print("Enter task description to remove: ");
                    String remove = sc.nextLine();
                    operations.removeTask(remove);
                    break;
                case 3:
                    operations.viewTasks();
                    break;
                case 4:
                    System.out.print("Enter task description to edit: ");
                    String editDesc = sc.nextLine();
                    operations.editTask(editDesc);
                    break;
                case 5:
                    System.out.print("Enter task description to mark completed: ");
                    String complete = sc.nextLine();
                    operations.markCompleted(complete);
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
