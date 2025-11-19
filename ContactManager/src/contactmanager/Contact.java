package contactmanager;

public class Contact 
{
    private String name;
    private String phoneNumber;
    private String email;
    
    Contact(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public String getName()
    {
        return this.name;
    }    
    
    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String toString()
    {
        return String.format("Name: %s , Phone: %s, Email: %s", this.name , this.phoneNumber, this.email);
    }
}
