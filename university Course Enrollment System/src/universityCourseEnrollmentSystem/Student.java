package universityCourseEnrollmentSystem;
import java.util.ArrayList;
public class Student 
{
    private String ID;
    private String name;
    private ArrayList <String> courses = new ArrayList<>();
    
    Student (String ID, String name)
    {
        this.ID = ID;
        this.name = name;
    }
    
    public void studentInfo()
    {
        System.out.printf("[System]: Success! %s (%s)\nEnrolled in:\n", this.name, this.ID);
        for(int i = 0, n = courses.size(); i < n; i++)
        {
            System.out.println((i+1) + "- " + courses.get(i));
        }
    }
    
    public void addCourse(String courseName)
    {
        courses.add(courseName);
    }
    
    public boolean isRegistered(String courseName)
    {
        return courses.contains(courseName);
    }
    
    public String getName()
    {
        return name;
    }
}
