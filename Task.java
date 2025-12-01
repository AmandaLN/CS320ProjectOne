public class Task {
    private final String taskId; // Immutable after creation
    private String name;
    private String description;
    
 // Constructor
    public Task(String taskId, String name, String description) {
        // Validate taskId in the constructor as it's final
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Task ID cannot be null and must be 10 characters or less.");
        }
        this.taskId = taskId;
        setName(name);
        setDescription(description);
    }
 // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

  //No setter for TaskID as is can not be updatable.
    // Setters with validation for length
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Name cannot be null and must be 20 characters or less.");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description cannot be null and must be 50 characters or less.");
        }
        this.description = description;
    }
}