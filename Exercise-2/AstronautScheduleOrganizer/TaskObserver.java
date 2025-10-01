public interface TaskObserver {
    void notifyConflict(Task existing, Task newTask);
}
