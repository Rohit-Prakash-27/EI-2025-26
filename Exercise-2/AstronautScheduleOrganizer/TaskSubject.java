import java.util.ArrayList;
import java.util.List;

public class TaskSubject {
    private List<TaskObserver> observers = new ArrayList<>();

    public void addObserver(TaskObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Task existing, Task newTask) {
        for (TaskObserver obs : observers) {
            obs.notifyConflict(existing, newTask);
        }
    }
}
