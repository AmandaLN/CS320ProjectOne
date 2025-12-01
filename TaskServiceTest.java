import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class TaskServiceTest {
	private TaskService tasks;
	@BeforeEach
    void setUp() {
		tasks = new TaskService();
    }
	//test for adding task
	@Test
	void testForAddTask() {
		Task task1 = new Task("T001", "Task 1", "Description 1");
		tasks.addTask(task1);
		assertNotNull(tasks.getTask("T001"));
		assertEquals("Task 1", tasks.getTask("T001").getName());
	}
	//test for duplicate task Id
	@Test
	void testDuplicateTasksID() {
		Task task1 = new Task("T001", "Task 1", "Description 1");
		tasks.addTask(task1);
		Task task2 = new Task("T001", "Task 2", "Description 2");
		assertThrows(IllegalArgumentException.class, () -> tasks.addTask(task2));
	}
	//test for null task
	@Test
	void testNullTask() {
		assertThrows(IllegalArgumentException.class, () -> tasks.addTask(null));
	}
	//test to add multiple tasks
	@Test
	void testAddMultipleTasks() {
        Task task1 = new Task("T003", "Task 3", "Description 3");
        Task task2 = new Task("T004", "Task 4", "Description 4");
        tasks.addMultiplTasks(task1, task2);
        assertNotNull(tasks.getTask("T003"));
        assertNotNull(tasks.getTask("T004"));
    }
	//test to retrieve task
	@Test
	void testRetrieveTask() {
		Task task3 = new Task("T003", "Task 3", "Description 3");
		tasks.addTask(task3);
		Task retrieveTask = tasks.getTask("T003");
		assertNotNull(retrieveTask);
        assertEquals("T003", retrieveTask.getTaskId());
	}
	//test for null task
	@Test
    void testGetTaskNullId() {
        assertThrows(IllegalArgumentException.class, () -> tasks.getTask(null));
    }
	//test for empty task
	 @Test
	    void testGetTaskEmptyId() {
	        assertThrows(IllegalArgumentException.class, () -> tasks.getTask(""));
	    }
	 //test for updating FIXME
	
	//test for delete task
	@Test
    void testDeleteTask() {
        Task task1 = new Task("T001", "Task 1", "Description 1");
        tasks.addTask(task1);
        assertNotNull(tasks.getTask("T001"));
        tasks.deleteTask("T001");
        assertNull(tasks.getTask("T001"));
    }
	//test for null id for delete
	@Test
    void testDeleteTaskNullId() {
        assertThrows(IllegalArgumentException.class, () -> tasks.deleteTask(null));
    }
	//test for empty id for delete
	@Test
    void testDeleteTaskEmptyId() {
        assertThrows(IllegalArgumentException.class, () -> tasks.deleteTask(""));
    }
	
}