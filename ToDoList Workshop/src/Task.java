import java.util.*;
import java.time.LocalDate;
import java.time.temporal.*;

public class Task {
	private String description = null;
	private boolean isComplete = false;
	private LocalDate duedate = null;
	private int notification = 0;
	
	
	public Task(String description) {
		super();
		this.description = description;
	}
	
	public Task(String description, boolean isComplete) {
		super();
		this.description = description;
		this.isComplete = isComplete;
	}

	public Task(String description, boolean isComplete, LocalDate duedate, int notification) {
		super();
		this.description = description;
		this.isComplete = isComplete;
		this.duedate = duedate;
		this.notification = notification;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isComplete() {
		return isComplete;
	}
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public LocalDate getDueDate() {
		return duedate;
	}
	
	public void setDueDate(LocalDate duedate) {
		this.duedate = duedate;
	}
	
	public int getNotification() {
		return notification;
	}
	
	public String checkNotification(Task task) {
		String desc;
		boolean status;
		LocalDate currentDate = LocalDate.now();
		desc = task.getDescription();
		duedate = task.getDueDate();
		notification = task.getNotification();
		status = task.isComplete();
		System.out.println(currentDate);
		System.out.println(duedate);
	
		if (duedate.isAfter(currentDate) || duedate.isEqual(currentDate))
		{

			if (duedate.isEqual(currentDate))
			{
				System.out.println(notification);
				if(notification == 0) {
					System.out.println("Task " + desc + ": Due today. ");
					return "Task " + desc + ": Due today. ";  
				}
				else {
					System.out.println("Task " + desc + ": Notification date is invalid! ");
					return "Task " + desc + ": Notification date is invalid! ";  
				}
			}
			else
			{
				long days = currentDate.until(duedate, ChronoUnit.DAYS);
				if (days == notification) {
					int daysBetween = (int)days - notification;
					String daysBetweenStr = Integer.toString(daysBetween);
					
					System.out.println("Task " + desc + ": " + daysBetweenStr + " days left.");
					return "Task " + desc + ": " + daysBetweenStr + " days left.";
				}
				else if (days > notification) {
					System.out.println("Task " + desc + ": Take your time! ");
					return "Task " + desc + ": Take your time! ";   
				}
				
				else {
					System.out.println("Task " + desc + ": System error! :) ");
					return "Task " + desc + ": System error! :) ";   									
				}			
			}
		}
		
		else {
			System.out.println("Task " + desc + ": Already overdue! ");
			return "Task " + desc + ": Already overdue! ";  			
		}
	}
}
