import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TaskTest {

	//test for validTask
	@Test
	void testConstructorValidTask() {
		String taskId = "ValidId";
		String name = "Task1";
		String description = "Do this taks1 first";
		Task task = new Task(taskId, name, description);
		
		assertNotNull(task);
		assertEquals(taskId, task.getTaskId());
		assertEquals(name, task.getName());
		assertEquals(description, task.getDescription());
	}
	//test for nullTaskId
	@Test
    void testConstructor_nullTaskId_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Task", "Description");
        });
    }
	//test for longTaskId
	@Test
	void testConstrictorLongId() {
		String longTaskId = "thistaskidistoolong";//over 10
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(longTaskId, "Task", "Description");
		});
	}
	//test for valid set name and update
	@Test
	void testSetNameValidUpdate() {
		Task task = new Task("TID2", "Old name", "Description");
		String newName = "New name";
		task.setName(newName);
		assertEquals(newName, task.getName());
	}
	//test for null name
	@Test
	void testNullName() {
		Task task = new Task("TID3", "Name", "Description");
		assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	//test for name being too long
	@Test
	void testNameTooLong() {
		Task task = new Task("TID4", "Name", "Description");
		String nameTooLong = "ThisNameislongerthanthetwentycharacters";
		assertThrows(IllegalArgumentException.class, () -> {
            task.setName(nameTooLong);
        });
	}
	//test for valid and update description
	@Test
	void validDescription() {
		Task task = new Task("Task3", "Name", "Old Description");
		String newDescription = "This description is valid and should pass.";
		task.setDescription(newDescription);
		assertEquals(newDescription, task.getDescription());
	}
	//test for null description
	@Test
	void testNullDescription() {
		Task task = new Task("TID5", "Name", "Description");
		assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
	}
	//test for long description
	@Test
	void testLongDescription() {
		Task task = new Task("TID9", "Name", "Description");
		String tooLongDescription = "thisdescriptionislongerthanfiftycharactersnotvalidandshouldnotpass";
		assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(tooLongDescription);
        });
	}
}