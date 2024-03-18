import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    String Name;

    String Email;
    String Password;
    List<Task>tasks;
    Student(String Name,String Email,String Password)
    {
        this.Name=Name;
        this.Email=Email;
        this.Password=Password;
        tasks=new ArrayList<>();
    }
    public String getEmail()
    {
        return Email;
    }
    public String getPassword()
    {
        return Password;
    }
    public void addTask(Task task)
    {
        tasks.add(task);
    }
    public void viewTasks()
    {
        for(Task task :tasks)
        {
            System.out.println(task);
        }
    }
    public void submitTask(Scanner scanner)
    {
        if(tasks.size()!=0)
        {
            viewTasks();
            System.out.println("Select the Task which you want to submit");
            String title = scanner.next();
            Task taskToSubmit= null;
            for(Task task: tasks)
            {
                if(task.getTitle().equals(title))
                {
                    taskToSubmit= task;
                    break;
                }
            }
            if(taskToSubmit!=null)
            {
                taskToSubmit.setStatus("submitted");
                System.out.println("Task has been Submitted");
            }
            else
            {
                System.out.println(" Enter a valid task");
            }
        }
        else
        {
            System.out.println("No Task has been assigned to this user!!");
        }
    }
    public void viewPendingTasks()
    {
        for(Task task:tasks)
        {
            if(task.getStatus().equals("Pending"))
            {
                System.out.println(task);
            }
        }
    }
    public void viewSubmittedTasks()
    {
        for (Task task:tasks)
        {
            if(task.getStatus().equals("Submitted"))
            {
                System.out.println(task);
            }
        }
    }
    @Override
    public String toString()
    {
      return "Name: "+Name+"Email: "+Email;
    }

}
