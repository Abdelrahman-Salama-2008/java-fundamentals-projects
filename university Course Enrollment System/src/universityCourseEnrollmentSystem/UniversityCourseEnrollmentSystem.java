package universityCourseEnrollmentSystem;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;

public class UniversityCourseEnrollmentSystem 
{
    private static HashMap <String, Student> students = new HashMap <>(); //students HashMap
    private static ArrayList <Course> courses = new ArrayList <>(); //courses ArrayList
    private static Scanner x = new Scanner(System.in); // Scanner
    
    public static void main(String[] args) 
    {
        //added all the courses
        courses.add(new Course("[CS101] Java Fundamentals", 30));
        courses.add(new Course("[SWE200] Software Architecture", 30));
        courses.add(new Course("[MATH5]  Calculus I", 5));
        
        int choice;
        
        
        do{
            System.out.println("=== UNIVERSITY ENROLLMENT SYSTEM ===");
            System.out.println("1. Register New Student\n2. List Available Courses\n3. Enroll Student in a Course\n4. Search Student Details\n5. Exit");
            System.out.print("CHOICE: ");
            choice = x.nextInt();
            x.nextLine();
            
            switch(choice)
            {
                case 1: //register
                    register();
                    break;
                case 2 : // view all courses
                    viewCourses();
                    break;
                case 3 : // enrollStudent() in courses
                    enrollStudent();
                    break;
                case 4 : // view student info
                    studentInfo();
                    break;
                case 5 :
                    System.out.println("Goodbye");
                    break;
                default :
                    System.out.println("INVALID CHOICE. please try again");
                    break;
            }
          }while(choice != 5);
    }
    
    private static void register() // register method
    {
        String ID, name;
        System.out.print("Enter Student ID: ");
        ID = x.nextLine();
        if(!students.containsKey(ID))
        {
            System.out.print("Enter Student Name: ");
            name = x.nextLine();
            students.put(ID, new Student(ID, name));
            System.out.println("Student Registered Successfully");
        }else
        {
            System.out.println("student ID is already registered");
        }
    }
    
    private static void viewCourses()
    {
        System.out.println("--- CURRENT COURSE OFFERING ---");
        for (int i = 0, n = courses.size(); i < n; i++)
        {
            System.out.printf("%d. %s\n", i+1, courses.get(i).toString());
        }
    }
    
    private static void enrollStudent()
    {
        String ID;
        int courseNum;
        System.out.print("Enter Student ID: ");
        ID = x.nextLine();
        if(students.containsKey(ID))
        {
            System.out.printf("Student found: %s\n", students.get(ID).getName());
        }else
        {
            System.out.println("Student not found");
            return;
        }
                    
        System.out.print("Select Course Number from Catalog: ");
        courseNum = x.nextInt();
        x.nextLine();
                    
        if(courses.size() < courseNum || courseNum < 1)
        {
            System.out.println("course not available. Please try again");
            return;
        }
                    
        if(courses.get(courseNum - 1).isfull())
        {
            System.out.printf("[Error]: Course \" %s \" is FULL. Enrollment failed.\n", courses.get(courseNum - 1).getName());
        }else
        {
            if(students.get(ID).ifRegistered(courses.get(courseNum - 1).getName()))
            {
                System.out.println("Student is already enrolled in this course");
            }else
            {
                courses.get(courseNum - 1).incrementCapacity();
                students.get(ID).addCourse(courses.get(courseNum - 1).getName());
                System.out.printf("[System]: Success! %s enrolled in \"%s\" \n", students.get(ID).getName(), courses.get(courseNum - 1).getName());
            }
        }
    }
    
    private static void studentInfo()
    {
        String ID;
        System.out.print("Enter Student ID: ");
        ID = x.nextLine();
        if(students.get(ID) != null)
        {
            students.get(ID).studentInfo();
        }else
            System.out.println("Student not found");
                        
    }
}
