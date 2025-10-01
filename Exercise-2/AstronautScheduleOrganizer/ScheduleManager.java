import java.util.*;

public class ScheduleManager extends TaskSubject {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public boolean addTask(Task task) {
        for (Task t : tasks) {
            if (ValidationUtils.isOverlap(t, task)) {
                notifyObservers(t, task);
                return false;
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        LoggerManager.log("Task added: " + task);
        return true;
    }

    public boolean removeTask(String description) {
        for (Task t : tasks) {
            if (t.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(t);
                LoggerManager.log("Task removed: " + description);
                return true;
            }
        }
        return false;
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getTasksByPriority(String priority) {
        List<Task> result = new ArrayList<>();
        for (Task t : tasks) {
            if (t.getPriority().equalsIgnoreCase(priority)) {
                result.add(t);
            }
        }
        return result;
    }
}
