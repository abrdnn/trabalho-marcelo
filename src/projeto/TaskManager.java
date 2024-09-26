package projeto;

import java.util.ArrayList;

public class TaskManager {
    private final ArrayList<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }


    public void addTask(String description) {
        tasks.add(new Task(description));
    }


    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }


    public void completeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).completeTask();
        }
    }


    public ArrayList<Task> getTasks() {
        return tasks;
    }


    public Task getTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            return tasks.get(index);
        }
        return null;
    }


    public int getTaskCount() {
        return tasks.size();
    }
}