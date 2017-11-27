/* Team It's October 3rd (Team 1) - Alexia Leong, Alan Wang, Jude Grodesky
   APCS1 pd02
   HW11 -- Breaking the Bank
   2017-10-04
*/


public class Teller
{
    public static void main( String[] args) 
    {
  	BankAccount Jude = new BankAccount();  //Test the default Constructor
	System.out.println(Jude);
	System.out.println("--------------------------------------");  //Clean up our print outs
	Jude.setName("Jude");
  	Jude.setPassword("Mr.Woms");
	Jude.setPin(1);
	Jude.setPin(44444);
	Jude.setPin(1234);
	Jude.setAcctNum(1);
	Jude.setAcctNum(1234567890);
	Jude.setAcctNum(123456789);
	Jude.setBalance(0.00);
	Jude.deposit(1.00);
	Jude.withdraw(4.00);
	Jude.withdraw(0.50);
	System.out.println(Jude); 
    
    
    
  	System.out.println(
			   Jude.authenticate( 2 , "fish") );
   	System.out.println(   
			   Jude.authenticate( 123456789, "fish") );
   	System.out.println(   
			   Jude.authenticate( 2 , "Mr.Woms") );
   	System.out.println(   
			   Jude.authenticate( 123456789, "Mr.Woms") );
    
	System.out.println("----------------------------------");  
	BankAccount Woms = new BankAccount(888888888, "I am WOM");   //Test the two overloaded constructors
	System.out.println(Woms);
	BankAccount Womsjr = new BankAccount(222222222, "I am WOMjr", 3.04, "Womjr", 2222);
	System.out.println(Womsjr);

  
    }
}
