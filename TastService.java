import java.util.HashMap;
import java.util.Map;

public class TaskService {
	 private final Map<String, Task> tasks = new HashMap<>();
   
    //Adding a single task
    public void addTask(Task task) {
    	if(task == null) {
    		throw new IllegalArgumentException("Task cannot be null.");
    	}
    	if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task with ID " + task.getTaskId() + " already exists.");
        }
        tasks.put(task.getTaskId(), task);
    }
    //Adding multiple tasks
    public void addMultiplTasks(Task... newTask) {
        for (Task task : newTask) {
        	addTask(task); // Reuses the single addTask method
        }
    }

    //Handling duplicate task IDs

    //Retrieving a task
    public Task getTask(String taskId) {
        if (taskId == null || taskId.isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        }
        return tasks.get(taskId);
    }

    //Updating a task FIXME
    

    //Deleting a task
    public void deleteTask(String taskId) {
        if (taskId == null || taskId.isEmpty()) {
            throw new IllegalArgumentException("Task ID cannot be null or empty.");
        }//FIXME shows red
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task with ID " + taskId + " not found.");
        }//This is showing red during coverage
        tasks.remove(taskId);
    }
}

