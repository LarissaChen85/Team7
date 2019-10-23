
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

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
		ToDoList result = new ToDoList();
		try {
			BufferedReader bufreader = new BufferedReader(new FileReader(filename));
			bufreader.readLine();
			String row;
			while((row = bufreader.readLine()) != null) {
				String[] data = row.split(",");
				result.addTask(new Task(data[0],Boolean.parseBoolean(data[1])));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return result;
	}
}
