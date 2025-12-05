package universityCourseEnrollmentSystem;
import java.util.HashMap;
public class Course 
{
    private String courseName;
    private  int capacity = 0;
    private  int fullCapacity;
    
    Course(String courseName, int fullCapacity)
    {
        this.courseName = courseName;
        this.fullCapacity = fullCapacity;
    }
    
    public String toString()
    {
        return String.format("%s | Seats: %d/%d", courseName, capacity, fullCapacity);
    }
    
    public boolean isfull()
    {
        if (capacity == fullCapacity)
            return true;
        
        return false;
    }
    
    public String getName()
    {
        return courseName;
    }
    
    public void incrementCapacity()
    {
        capacity++;
    }
            
}
