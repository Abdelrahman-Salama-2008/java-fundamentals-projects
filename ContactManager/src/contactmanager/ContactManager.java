package contactmanager;
import java.util.Scanner;
import java.util.ArrayList;
public class ContactManager 
{
    public static Scanner x = new Scanner(System.in);
    public static ArrayList <Contact> contacts = new ArrayList<>();
    public static void main(String[] args)
    {
        
        int input;
        System.out.println("welcome");
        
        do
        {
            System.out.println("1- add a new contact\n2- view all contact\n3- remove a contact\n4- exit");
            System.out.print("enter choice: ");
            input = x.nextInt();
            x.nextLine();
            
            switch (input)
            {
                case 1:
                    add();
                    break;
                case 2:
                    viewall();
                    break;
                case 3:
                    remove();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("INVALID CHOICE. try agian");
                    break;
            }
                        
        }while(input != 4);
    }
    
    public static void add()
    {
        String name, phone, email;
        System.out.print("Name: ");
        name = x.nextLine();
        System.out.print("phone number: ");
        phone = x.nextLine();
        System.out.print("email: ");
        email = x.nextLine();
        
        contacts.add(new Contact(name, phone, email));
    }
    
    public static void viewall()
    {
        if(contacts.isEmpty())
        {
            System.out.println("there are nothing to view here.\nadd something first.");
            return;
        }
   
        int counter = 1;
        System.out.println("here are all the contacts");
        for(Contact every : contacts)
        {
            System.out.println(counter + "- " +every.toString());
            counter++;
        }
    }
    
    public static void remove()
    {
        String name;
        System.out.print("enter Name: ");
        name = x.nextLine();
        boolean isFound = false;
        int index = -1;
        
        for (int i = 0; i < contacts.size(); i++)
        {
            if(name.equals(contacts.get(i).getName()))
            {
                isFound = true;
                index = i;
                break;
            }
        }
        
        if(isFound)
        {
            contacts.remove(index);
            System.out.printf("%s is removed successfully\n", name);
            isFound = false;
        }else
            System.out.printf("%s is not registered here\n", name);
    }
    
    public static void exit()
    {
        System.out.println("thank you for using the app\nGoodbye");
    }
}
