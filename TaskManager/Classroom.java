
import java.util.*;

public class Classroom {
    private List<Course>Courses;
    private Map<Student,Course> studentCourseMap;

    public Classroom()
    {
        Courses=new ArrayList<>();
        studentCourseMap=new HashMap<>();

    }

    public void registerAsStudent(Scanner scanner)
    {
        System.out.println("Enter Username: ");
        String username=scanner.nextLine();
        System.out.println("Enter Email");
        String email=scanner.nextLine();
        System.out.println("Set Password: ");
        String password=scanner.nextLine();
        System.out.println("Enter the Course Id you want to enroll in ");
        String courseId=scanner.nextLine();
        Course courseToEnroll=getCourse(courseId);
        if(courseToEnroll!=null)
        {
            Student student=new Student(username,email,password);
            studentCourseMap.put(student, courseToEnroll);
            courseToEnroll.addStudent(student);
            System.out.println("You have successfully enrolled in the course!");
        }
         else {
            System.out.println("Course with ID " + courseId + " not found.");
        }
    }
    private Course getCourse(String courseId)
    {
        for(Course course:Courses)
        {
            if(course.getCourseId().equals(courseId))
            {
                return course;
            }
        }
        return null;
    }

    public void loginAsStudent(Scanner scanner){
        System.out.println("Enter Email:");
        String Email=scanner.nextLine();
        System.out.println("Enter Password:");
        String Password=scanner.nextLine();
        Student authenticatedStudent=null;
        for (Map.Entry<Student, Course> entry : studentCourseMap.entrySet()) {
            Student student = entry.getKey();
             if (student.getEmail().equals(Email) && student.getPassword().equals(Password)) {
                authenticatedStudent=student;
            }
        }
        if (authenticatedStudent != null) {
            System.out.println("Login successful!");
            studentMenu(scanner,authenticatedStudent);
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }

    }
    private void studentMenu(Scanner scanner,Student student)
    {
        int choice;
        do {

            System.out.println("Student Menu: ");
            System.out.println("1.View Tasks");
            System.out.println("2.Hand in Task");
            System.out.println("3.View Pending Tasks");
            System.out.println("4.View Submitted Tasks");
            System.out.println("5.Exit");
            System.out.println("Enter Your choice");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    student.viewTasks();
                    break;
                case 2:
                    student.submitTask(scanner);
                    break;
                case 3:
                    student.viewPendingTasks();
                    break;
                case 4:
                    student.viewSubmittedTasks();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input!!\nEnter Valid Option.");

            }
        }while(choice!=5);
    }
    public void AdminMenu(Scanner scanner)
    {
        int choice;
        do {
            System.out.println("Teacher Menu: ");
            System.out.println("1.Add Course ");
            System.out.println("2.View Courses");
            System.out.println("3.Add Student");
            System.out.println("4.Assign Task");
            System.out.println("5.View Tasks");
            System.out.println("6.Exit");
            choice=scanner.nextInt();
            scanner.nextLine();
            switch (choice)
            {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    showCourses();
                    break;
                case 3:
                    registerAsStudent(scanner);
                    break;
                case 4:
                    assignTask(scanner);
                    break;
                case 5:
                    System.out.println("Enter Course Id");
                    String CourseId=scanner.nextLine();
                    viewTasks(CourseId);
                    break;
                case 6:
                    break;
            }
        }while (choice!=6);

    }
    private void assignTask(Scanner scanner)
    {
        System.out.println("Enter Task Title");
        String title=scanner.nextLine();
        System.out.println("Enter Due Date ");
        String dueDate=scanner.nextLine();
        System.out.println("Description of task");
        String Description=scanner.nextLine();
        System.out.println("Assign to (Course Id)");
        String assignTo=scanner.nextLine();
        Course addToCourse=getCourse(assignTo);
        if(addToCourse!=null)
        {
            Task task=new Task(title,dueDate,Description);

            addToCourse.addTask(task);
            addToCourse.assigntasktostudents(task);
            System.out.println("Task has been successfully assigned to the course!");
        }
        else {
            System.out.println("Course with ID " + assignTo + " not found.");
        }



    }
    private void viewTasks(String CourseId)
    {

        Course course=getCourse(CourseId);
        if(course!=null)
        {
            course.showAllTasks();
        }
        else {
            System.out.println("No  course exists!!");
        }
    }
    public void addCourse(Scanner scanner){
        System.out.println("Enter Course ID:");
        String CourseId=scanner.nextLine();
        System.out.println("Enter Course Name:");
        String CourseName=scanner.nextLine();
        Course addCourse=new Course(CourseId,CourseName);
        Courses.add(addCourse);

    }

    public void showCourses()
    {
        for(Course course: Courses)
        {
            System.out.println(course);
            course.showStudentList();
        }
    }
}
