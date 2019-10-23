import java.util.Collection;

import org.junit.*;
import org.junit.Test;
import junit.framework.*;


public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task task1;
	private Task task2;
	private Task task3;
	private ToDoList todolist;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		task1 = new Task("Desc 1");
		task2 = new Task("Desc 2");
		task3 = new Task("Desc 3");
		todolist = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		task1 = null;
		task2 = null;
		task3 = null;
		todolist = null;
	}

	@Test
	public void testAddTask() {
		assertNotNull(todolist);
		todolist.addTask(task1);
		assertEquals(1, todolist.getAllTasks().size());
		assertEquals(task1, todolist.getTask(task1.getDescription()));
	}
	@Test
	public void testgetStatus() {
		assertNotNull(todolist);
		todolist.addTask(task1);
		assertEquals(false, todolist.getStatus(task1.getDescription()));
		todolist.completeTask(task1.getDescription());
		assertEquals(true, todolist.getStatus(task1.getDescription()));
	}
	@Test
	public void testRemoveTask() {
		assertNotNull(todolist);
		todolist.addTask(task1);
		todolist.addTask(task2);
		assertEquals(2, todolist.getAllTasks().size());
		todolist.removeTask(task2.getDescription());
		assertEquals(1, todolist.getAllTasks().size());
		assertNull(todolist.getTask(task2.getDescription()));
	}
	@Test
	public void testGetCompletedTasks() {
		assertNotNull(todolist);
		todolist.addTask(task1);
		todolist.addTask(task2);
		todolist.addTask(task3);
		todolist.completeTask(task1.getDescription());
		todolist.completeTask(task2.getDescription());
		assertEquals(2, todolist.getCompletedTasks().size());
	}
}
