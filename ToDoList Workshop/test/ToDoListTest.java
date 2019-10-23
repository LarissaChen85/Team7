import java.util.*;
import org.junit.*;
import org.junit.Test;
import junit.framework.*;
import java.time.LocalDate;



public class ToDoListTest extends TestCase{
	// Define Test Fixtures
	private Task task1;
	private Task task2;
	private Task task3;
	private LocalDate duedate1, duedate2, duedate3;
	private int notification1, notification2, notification3;
	private ToDoList todolist;
	
	public ToDoListTest() {
		super();
	}
	@Before
	 public void setUp() throws Exception{
		//Initialise Test Fixtures
		duedate1 = LocalDate.of(2019,10,22);
		duedate2 = LocalDate.of(2019,10,23);
		duedate3 = LocalDate.of(2019,11,24);
		notification1 = 0;
		notification2 = 0;
		notification3 = 5;
		task1 = new Task("Desc 1", false, duedate1, notification1); //expect fail
		task2 = new Task("Desc 2", false, duedate2, notification2); //expect notification
		task3 = new Task("Desc 3", false, duedate3, notification3); //expect no notification
		todolist = new ToDoList();
	}
	@After
	 public void tearDown() throws Exception{
		// Uninitialise test Fixtures
		task1 = null;
		task2 = null;
		task3 = null;
		duedate1 = null;
		duedate2 = null;
		duedate3 = null;
		todolist = null;
	}

	@Test
	public void testAddTask() {
		String msg1 = "Task " + task1.getDescription() + ": Already overdue! ";
		String msg2 = "Task " + task2.getDescription() + ": Due today. ";
		String msg3 = "Task " + task3.getDescription() + ": Take your time! ";
		
		assertNotNull(todolist);
		todolist.addTask(task1);

		assertEquals(1, todolist.getAllTasks().size());
		assertEquals(task1, todolist.getTask(task1.getDescription()));
		assertEquals(duedate1, todolist.getTask(task1.getDescription()).getDueDate());
		assertEquals(notification1, todolist.getTask(task1.getDescription()).getNotification());

		System.out.println("task1 completed");
		
		assertEquals(msg1, todolist.getTask(task1.getDescription()).checkNotification(todolist.getTask(task1.getDescription())));
		System.out.println("before add task2");

		todolist.addTask(task2);
		todolist.addTask(task3);

		assertEquals(msg2, todolist.getTask(task2.getDescription()).checkNotification(todolist.getTask(task2.getDescription())));
		assertEquals(msg3, todolist.getTask(task3.getDescription()).checkNotification(todolist.getTask(task3.getDescription())));
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
