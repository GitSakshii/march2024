public class Task {
    String title;
    String duedate;
    String Description;
    String Status;

    public Task(String title,String duedate,String Description){
        this.title=title;
        this.duedate=duedate;
        this.Description=Description;
        this.Status="Pending";//Be default the status is set to pending

    }
    public String getTitle()
    {
        return title;
    }
    public String getStatus()
    {
        return Status;
    }
    public void setStatus(String status)
    {
        Status=status;
    }
    @Override
    public String toString()
    {
       return "Title: "+title+" Description: "+Description+"\n"+"Due Date: "+duedate;
    }
}
