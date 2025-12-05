package bankaccount;

import java.util.Scanner;
import java.util.HashMap;
public class BankAccount
{
    private static Scanner x = new Scanner(System.in);
    private static HashMap <String, Account> users = new HashMap <>();
    
    public static void main(String[] args)
    {
        int choice;
        System.out.println("--- Welcome to the Java Bank System ---");
        
        do
        {
            System.out.println("Enter the choice number:\n1- Create New Account\n2- Deposit Money\n3- Withdraw Money\n4- View Account Details\n5- Exit");
            choice = x.nextInt();
            x.nextLine();
            
            switch (choice)
            {
            case 1: // create account
                create();
                break;
            
            case 2:// deposit
                deposit();
                break;
                
            case 3: //withdraw
                withdraw();
                break;
                
            case 4: //view account
                view();
                break;
                
            case 5: //exit
                System.out.println("Goodbye");
                break;
                
            default:
                System.out.println("Invalid Choice. Try again");
            }
            
        }while(choice != 5);
        
    }
    
    public static void create()
    {
        String acNumber, acHolder;
        
        System.out.println("--- Create Account ---");
        System.out.print("Enter Account Number: ");
        acNumber = x.nextLine();
        System.out.print("Enter Account Holder Name: ");
        acHolder = x.nextLine();
        if(users.containsKey(acNumber))
        {
            System.out.println("Account number is already taken. Try again with a different Number");
        }
        else
        {
            users.put(acNumber, new Account(acNumber,acHolder));
            System.out.println("Account created successfully!");
        }
    }
    
    public static void deposit()
    {
        String acNumber;
        double money;
        
        System.out.println("--- Deposit ---");
        System.out.print("Enter Account Number to deposit into: ");
        acNumber = x.nextLine();
        if (users.get(acNumber) != null)
        {
            System.out.print("Enter the amount: ");
            money = x.nextDouble();
            x.nextLine();
            if (money <= 0)
                System.out.println("The deposit must be a positive number");
            else
                users.get(acNumber).deposit(money);
        }else
            System.out.println("Error: Account " + acNumber + " not found!");
    }
    
    public static void withdraw()
    {
        String acNumber;
        double money;
        
        System.out.println("--- Withdraw ---");
        System.out.print("Enter Account Number to withdraw from: ");
        acNumber = x.nextLine();
        if (users.get(acNumber) != null)
        {
            System.out.print("Enter Amount: ");
            money = x.nextDouble();
            x.nextLine();
            if (money <= 0)
                System.out.println("The withdraw must be a positive number");
            else
                users.get(acNumber).withdraw(money);
        }
        else
            System.out.println("Error: Account " + acNumber + " not found!");
    }
    
    public static void view()
    {
        String acNumber;
        
        System.out.println("--- View Account ---");
        System.out.print("Enter the Account Number: ");
        acNumber = x.nextLine();
        if(users.get(acNumber) != null)
        {
            System.out.println(users.get(acNumber).toString());
        }else
            System.out.println("Account not found");   
    }
    
}

