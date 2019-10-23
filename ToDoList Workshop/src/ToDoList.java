import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class ToDoList {
private HashMap<String, Task> tasks = new HashMap<String, Task>();

	public void addTask (Task task) {
		tasks.put(task.getDescription(), task);
		//Add code here
	}
	public void completeTask(String description) {
		// Add code here
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			task.setComplete(true);
		}
		;
	}
	public boolean getStatus(String description) {
		//Add code here
		Task task = null;
		if ((task = tasks.get(description)) != null) {
			return task.isComplete();
		}
		return false;
	}
	public Task getTask(String description) {
		// Add code here
		return tasks.get(description);
	}
	public Task removeTask(String description) {
		// Add code here
		return tasks.remove(description);
	}
	public Collection<Task> getAllTasks() {
		return tasks.values();
		//return null;
	}
	public Collection<Task> getCompletedTasks() {
		// Add code here
		Collection<Task> completedTasks = new ArrayList<Task> ();
		Collection<Task> allTasks = new ArrayList<Task> ();
		
		allTasks = getAllTasks();
		for (Task task: allTasks) 
			if (task.isComplete() == true)
				completedTasks.add(task);
		return completedTasks;
	}
}
