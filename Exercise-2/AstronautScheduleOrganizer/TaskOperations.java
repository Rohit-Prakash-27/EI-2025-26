import java.util.List;
import java.util.Scanner;

public class TaskOperations implements TaskObserver {
    private ScheduleManager manager = ScheduleManager.getInstance();

    public void addTask(String description, String start, String end, String priority) {
        TaskFactory factory = new TaskFactory();
        Task task = factory.createTask(description, start, end, priority);

        if (!ValidationUtils.isValidTimeFormat(start) || !ValidationUtils.isValidTimeFormat(end)) {
            System.out.println("Error: Invalid time format.");
            return;
        }

        if (manager.addTask(task)) {
            System.out.println("Task added successfully. No conflicts.");
        }
    }

    public void removeTask(String description) {
        if (manager.removeTask(description)) {
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void editTask(String description) {
        List<Task> tasks = manager.getAllTasks();
        Scanner sc = new Scanner(System.in);

        try {
            // Find tasks with the given description
            List<Task> matches = new java.util.ArrayList<>();
            for (Task t : tasks) {
                if (t.getDescription().equalsIgnoreCase(description)) {
                    matches.add(t);
                }
            }

            if (matches.isEmpty()) {
                System.out.println("Error: Task not found.");
                return;
            }

            Task taskToEdit = null;

            if (matches.size() == 1) {
                taskToEdit = matches.get(0);
            } else {
                System.out.println("Multiple tasks found with description \"" + description + "\":");
                for (int i = 0; i < matches.size(); i++) {
                    System.out.println((i + 1) + ". " + matches.get(i));
                }
                System.out.print("Select the task number to edit: ");
                int choice = sc.nextInt();
                sc.nextLine(); // consume newline
                if (choice < 1 || choice > matches.size()) {
                    System.out.println("Invalid choice.");
                    return;
                }
                taskToEdit = matches.get(choice - 1);
            }

            // Ask new timings
            System.out.print("Enter new start time (HH:MM): ");
            String newStart = sc.nextLine();
            System.out.print("Enter new end time (HH:MM): ");
            String newEnd = sc.nextLine();

            if (!ValidationUtils.isValidTimeFormat(newStart) || !ValidationUtils.isValidTimeFormat(newEnd)) {
                System.out.println("Error: Invalid time format.");
                return;
            }

            // Ask new priority
            System.out.print("Enter new priority (High/Medium/Low): ");
            String newPriority = sc.nextLine();

            // Create a "temp updated task"
            Task updatedTask = new Task(taskToEdit.getDescription(), newStart, newEnd, newPriority);

            // Remove old task temporarily for conflict check
            tasks.remove(taskToEdit);
            boolean conflict = false;
            for (Task t : tasks) {
                if (ValidationUtils.isOverlap(t, updatedTask)) {
                    System.out.println("Error: Task conflicts with existing task \"" + t.getDescription() + "\".");
                    conflict = true;
                    break;
                }
            }

            if (!conflict) {
                // Apply new values
                tasks.add(updatedTask);
                tasks.sort(java.util.Comparator.comparing(Task::getStartTime));
                LoggerManager.log("Task edited: " + updatedTask);
                System.out.println("Task updated successfully.");
            } else {
                // Re-add old task if conflict
                tasks.add(taskToEdit);
                tasks.sort(java.util.Comparator.comparing(Task::getStartTime));
            }
        } finally {
            sc.close();
        }
    }

    public void viewTasks() {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("\n--- View Tasks ---");
            System.out.println("1. View All Tasks");
            System.out.println("2. View Tasks by Priority");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 1) {
                List<Task> tasks = manager.getAllTasks();
                if (tasks.isEmpty()) {
                    System.out.println("No tasks scheduled for the day.");
                } else {
                    tasks.forEach(System.out::println);
                }
            } else if (choice == 2) {
                System.out.print("Enter priority (High/Medium/Low): ");
                String priority = sc.nextLine();
                List<Task> tasks = manager.getTasksByPriority(priority);

                if (tasks.isEmpty()) {
                    System.out.println("No tasks found with priority: " + priority);
                } else {
                    tasks.forEach(System.out::println);
                }
            } else {
                System.out.println("Invalid choice.");
            }
        } finally {
            sc.close(); 
        }
    }

    public void markCompleted(String description) {
        for (Task t : manager.getAllTasks()) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                t.markCompleted();
                System.out.println("Task marked as completed.");
                return;
            }
        }
        System.out.println("Error: Task not found.");
    }

    @Override
    public void notifyConflict(Task existing, Task newTask) {
        System.out.println("Error: Task conflicts with existing task \"" + existing.getDescription() + "\".");
    }
}
