import java.util.ArrayList;
import java.util.List;

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
    @Override
    public String toString()
    {
      return "Name: "+Name+"Email: "+Email;
    }

}
