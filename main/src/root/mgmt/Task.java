package root.mgmt;

public class Task {
    public String name;
    public Integer priority; // 0 - min | 5 - max

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status status;

    public Task(String name, Integer priority, Status status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }
    public String getName() {return name;}
    public Integer getPriority() {return priority;}
    public Status getStatus() {return status;}
}
