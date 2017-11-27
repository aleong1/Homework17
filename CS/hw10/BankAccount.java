// Team It's October 3rd -- Alexia Leong, Alan Wang, Jude Grodesky
// APCS1 pd2
// HW10 -- Mo Money Mo Problems
// 2017-10-03 T

public class BankAccount
{
    //instance variables
    private String name;
    private String passwd;
    private int pin;
    private int acctNum;
    private double balance;


    //mutators
    public String setName( String newName ) //sets account name with first and last name
    {
	String oldName = name;
	name = newName;
	return oldName;
    }

    public String setPasswd( String newPasswd )  
    {
	String oldPasswd = passwd;
	passwd = newPasswd;
	return oldPasswd;
    }

    public int setPin( int newPin ) 
    {
	if (1000 < newPin && newPin < 9998) { 
	    int oldPin = pin;
	    pin = newPin;
	    return oldPin;
	}
	else {
	    System.out.println( "Please Change Your Pin");  //because the Pin is invalid this will print on the screen
	    pin = 9999; //so because the pin is invalid it will set the pin to 9999
	    return pin;
	}
    }

    public int setAcctNum( int newAcctNum )
    {
	if (100000000 < newAcctNum && newAcctNum < 999999998) {  //account number has to be in this range and if it isn't then it will be set to 999999999
	    int oldAcctNum = acctNum;
	    acctNum = newAcctNum;
	    return oldAcctNum;
	}
	else {
	    System.out.println("Fix your account number!"); //error message to fix your accountnumber
	    acctNum = 999999999;
	    return acctNum;
	}
    }
	
    public double setBalance( double newBalance )
    {
	double oldBalance = balance;
	balance = newBalance;
	return oldBalance;
    }

    public void deposit( double depositAmount ) {
	if (depositAmount + balance < 0 ) {
	    System.out.println("Withdraw is greater than balance!"); // error for if account doesn't have enough money to withdraw this much
	}
	else {  
	    balance = balance + depositAmount;
	}
    }

    public Boolean checker( int AcctNum, String passwd) {   //to check credentials to see if they match with what we set it already
	if (AcctNum == 123456789 && passwd == "Hi") {
	    return true;
	}
	else {
	    return false;
	}
    }

    //overwritten toString()
    public String toString() {
	String retStr = "\nAccount info:\n=======================";
	retStr = retStr + "\nName: " + name;
	retStr = retStr + "\nPassword: " + passwd;
	retStr = retStr + "\nPIN: " + pin;
	retStr = retStr + "\nAccount Number: " + acctNum;
	retStr = retStr + "\nBalance: " + balance;
	retStr = retStr + "\n=======================";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args )
    {
	BankAccount Bank = new BankAccount();
	Bank.setName("Alan Wang");
	Bank.setPasswd("Hi");
	Bank.setPin(1234);
	Bank.setAcctNum(123456789);
	Bank.setBalance(8888.88);
	Bank.deposit(88.88);
	System.out.println(Bank);
    }//end main()

}//end class BankAccount





