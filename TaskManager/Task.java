public class Task {
    String title;
    String duedate;
    String Description;
    String Status;

    public Task(String title,String duedate,String Description){
        this.title=title;
        this.duedate=duedate;
        this.Description=Description;
        this.Status="Pending";//Be default it is pending

    }
    @Override
    public String toString()
    {
       return "Title: "+title+" Description: "+Description+"\n"+"Due Date: "+duedate;
    }
}
