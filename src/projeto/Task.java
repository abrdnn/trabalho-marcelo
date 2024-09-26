package projeto;

class Task {
    private final String description;
    private boolean isCompleted;

    public Task(String description){
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription(){
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeTask(){
        this.isCompleted = true;
    }

    @Override
    public String toString(){
        return (isCompleted ? "[X] " : "[] ") + description;
    }
}
