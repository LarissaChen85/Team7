import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;

public class StorageTest {

	// Define Test Fixtures
	private Task task1;
	private Task task2;
	private ToDoList todolist;
	private Storage storage;
	private File expected_file = new File("expected.csv");

	@Before
	public void setUp() throws Exception {
		//Initialise Test Fixtures
		task1 = new Task("Desc 1");
		task2 = new Task("Desc 2");
		todolist = new ToDoList();
		todolist.addTask(task1);
		todolist.addTask(task2);
		storage = new Storage();
	}

	@After
	public void tearDown() throws Exception {
		// Uninitialise test Fixtures
		task1 = null;
		task2 = null;
		todolist = null;
	}

	@Test
	public void testWrite() {
		storage.write(todolist);
		File result_file =  new File("task.csv");
		assertEquals("The files differ!", expected_file, result_file);
	}
	@Test
	public void testRead() {
		ToDoList results = storage.read();
		assertEquals("ToDoLists differ!", todolist, results);
	}

}
