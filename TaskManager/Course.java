import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String Subject;
    private List<Student>StudentsEnrolled;
    private List<Task>TasksAssigned;
    public Course(String courseId,String Subject){
            this.courseId=courseId;
            this.Subject= Subject;
            StudentsEnrolled=new ArrayList<>();
            TasksAssigned=new ArrayList<>();
    }
    public String getCourseId()
    {
        return courseId;
    }

    public void addStudent(Student student)
    {
        StudentsEnrolled.add(student);
    }
    public void addTask(Task task)
    {
        TasksAssigned.add(task);
    }
    public void assigntasktostudents(Task task)
    {
        for(Student student:StudentsEnrolled)
        {
            student.addTask(task);
        }
    }
    public void showStudentList()
    {
        for(Student student:StudentsEnrolled)
        {
            System.out.println(student);
        }
    }
    public void showAllTasks()
    {
        for(Task task:TasksAssigned)
        {
            System.out.println(task);
        }
    }

    @Override
    public String toString(){
        return "Course Id: "+courseId+"Subject :"+Subject;
    }
}
