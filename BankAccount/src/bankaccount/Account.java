package bankaccount;

public class Account 
{
    
    private String accountNumber;
    private String accountHolder;
    private double balance;
    
    Account( String accountNumber, String accountHolder)
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        balance = 0.0;
    }
    
    public String toString()
    {
        return String.format("Account: %s | Name: %s | Balanace: $%f", this.accountNumber, this.accountHolder, this.balance);
    }
    
    public void deposit(double moneyin) 
    {
        System.out.println("you are going to deposit $"+moneyin);
        System.out.println("transaction successful");
        balance =  moneyin + balance;
    }
    
    public void withdraw(double moneyout) 
    {
        
        System.out.println("you are going to withdraw $"+moneyout);
        if(moneyout > balance)
        {
            System.out.println("ineffecient fund");
        }else
        {
            System.out.println("withdraw successfull");
            balance = balance - moneyout;
        }
    }
    
    public String getAccountNumber()
    {
       return this.accountNumber; 
    }
        
    
}
