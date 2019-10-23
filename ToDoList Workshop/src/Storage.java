
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;

public class Storage {
	private String filename = "task.csv";
//	ToDoList todo;

	public void write(ToDoList todo) {
		try {
			FileWriter writer = new FileWriter(filename);
			writer.write("description,status\r\n");
			for(Iterator<Task> it = todo.getAllTasks().iterator(); it.hasNext();) {
				Task current = it.next();
				writer.write(current.getDescription()+","+current.isComplete());
				writer.write("\r\n");
			}
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ToDoList read() {
		// Add code here
		//addTask
		return null;
	}
}
