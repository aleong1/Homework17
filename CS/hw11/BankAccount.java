/* Team It's October 3rd (Team 1) - Alexia Leong, Alan Wang, Jude Grodesky
   APCS1 pd02
   HW11 -- Breaking the Bank
   2017-10-03
*/

//Other group:
/*
  Robin DeBank (Group 0) -- Ryan Kim, Ricky Lin, Maggie Zhao
  APCS1 pd02
  HW10 -- Mo Money Mo Problems ...but we can MAKE MO AWESOME
  2017-10-03 
*/

public class BankAccount
{    
    //instance variables     
    private String name;
    private String password;
    private int pin;
    private int acctNum;
    private double balance;


    /* default constructor: initializes instance vars to default vals
       precondition:  none
       postcondition: instance vars have appropriate default vals
       ````````````````````````````````````````````````````*/
    public BankAccount() {
	name = "Alexia Leong";
	password = "hw11";
	pin = 1234;
	acctNum = 123456789;
	balance = 0.0;
    }


    /* overloaded constructor: allows caller to specify account 
       number and passwd. Assigns defaults
       to other instance vars.
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass ) {
	acctNum = newAcctNum;
	password = newPass;
    }

    /* overloaded constructor: allows caller to specify instance vars
       precondition:  params are passed in specified order
       postcondition: instance vars have values specified by params
       ````````````````````````````````````````````````````*/
    public BankAccount( int newAcctNum, String newPass, 
			double newBal, String newName, int newPin ) {
	acctNum = newAcctNum;
        password = newPass;
	balance = newBal;
	name = newName;
	pin = newPin;
    }

    //mutators
    // This will set the account name 
    public String setName( String newName )
    {
	String oldName = name;
	name = newName;
	return oldName;
    }
    // This will set the password for the account
    public String setPassword( String newPassword )
    {
	String oldPassword = password;
	password = newPassword;
	return oldPassword;
    }
    //To set the pin number
    public int setPin( int newPin )
    {
	int oldPin = pin;
	if( newPin >= 1000 && newPin <= 9998 )    // the pin has to be in the range [1000,9998] and if not...
	    {
		pin = newPin;
		System.out.println( "New pin set to " + newPin + "\n" );  //for if the pin number is valid it will print out the new pin number
	    }
	else
	    {
		pin = 9999;
		System.out.println( "Pin outside of range. Defaulted to 9999. \n" );  //There will be an error message displayed and the pin will be 9999
	    }
	pin = newPin;
	return oldPin;
    }

    public int setAcctNum( int newAcctNum )  //to set the account number
    {
	int oldAcctNum = acctNum;
	if( newAcctNum >= 100000000 && newAcctNum <= 999999998 )  //the account number has to be in the range [100000000,999999998] 
	    {
		acctNum = newAcctNum;
		System.out.println( "New account number set to " + newAcctNum + "\n" );  //sets accountnumber to new one if it is valid
	    }
	else
	    {
		acctNum = 999999999;  //otherwise it will set the number to 999999999 and print the following error message
		System.out.println( "Account number outside of range. Defaulted to 999999999. \n" );
	    }
	return oldAcctNum;
    }

    public double setBalance( double newBalance )  //sets initial balance
    {
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    public void deposit( double depositAmount )  //to deposit money into the account
    {
	balance = balance + depositAmount;
    }

    public boolean withdraw( double withdrawalAmount ) //to withdraw money, this function has conditions...
    {
	double oldBalance = balance;
	if( balance >= withdrawalAmount )  //to check if you're withdrawing more than what you have
            {
		balance = balance - withdrawalAmount;  //if you are withdrawing less then what you have, then the transaction can continue
		System.out.println( "New Balance: $" + balance );
		return true;
	    }
	else  //if you do then it will print this error message:
            {
		System.out.println( "Transaction Denied. Insufficient Money. Current Balance: $" + balance + " Withdrawal Amount: $" + withdrawalAmount + "\n" );
		return false;
	    }
    }

    public boolean authenticate ( int inputtedAcctNum, String inputtedPassword) {  //to authenticate if the acctnum and inputtedpassword match with what is already there
	if( inputtedAcctNum == acctNum && inputtedPassword == password )
	    {
		return true;
	    }
	else
	    {
		return false;
	    }
    }
	
    //overwritten toString()
    public String toString()
    {
	String retStr = "\nAccount info:\n=======================";
	retStr = retStr + "\nName: " + name;
	retStr = retStr + "\nPassword: " + password;
	retStr = retStr + "\nPIN: " + pin;
	retStr = retStr + "\nAccount Number: " + acctNum;
	retStr = retStr + "\nBalance: $" + balance;
	retStr = retStr + "\n=======================";
	return retStr;
    }
	
    //main method for testing
    public static void main( String[] args )
    {
	BankAccount Ricky = new BankAccount();
	Ricky.setName("Ricky Lin");
	Ricky.setPassword("Case Sensitive");
	Ricky.setPin(12345);
	Ricky.setPin(2444);
	Ricky.setAcctNum(1234567890);
	Ricky.setAcctNum(244466666);
	Ricky.setBalance(0.01);
	Ricky.deposit(1.00);
	Ricky.withdraw(1.15);
	Ricky.withdraw(1.00);
	System.out.println(Ricky.toString());
    }//end main()

}//end class BankAccount
