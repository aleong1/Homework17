/* Team Are We There Yet? - Alexia Leong, Bing Li, and Jackie Li
   Alexia Leong
   APCS1 pd2
   HW09 -- CMYM
   2017-10-02 */

public class BankAccount{
    //-> instance variables:  variables that might be changed later on in the code but will have initial value set for them
    private String accountholdername;
    private int  accountnumber;
    private String password;
    private int pinnumber;
    private Double accountbalance;

    //-> constructor:  to set initial values for variables in your Bank Account just in case it isn't going to be set
    public BankAccount() {
	accountholdername = "John Doe";
	password = "Chicken";
	accountnumber = 212312480;
	pinnumber = 4800;
	accountbalance = 0.0;
    }

    //-> methods:   We have separate methods here instead of a constructor to make it easier to change each attribute individually than all at once
    public String accountname(String name) {  
	accountholdername = name;
    }
    public String passwrd(String word){
	password = word;
    }
    public int acctnum(int number) {
	accountnumber = number;    }
    public int pinnum(int pin) {
	pinnumber= pin;
    }
    public Double balance(Double money) {  //next three methods are all about setting and changing the amount of money in the account balance
	accountbalance = money;
    }
    public Double withdraw(Double takingout) {
	accountbalance -= takingout;
    }
    public Double deposit(Double puttingin) {
	accountbalance += puttingin;
    }
    public String printAll(){ //to print out all the info at once, no need to return anything here
	String info;
	info = "Name: " + accountholdername + "\n"; //"\n" are for new lines to appear after each attribute is printed
	info += "Password: " + password + "\n";
	info += "Account Number: " + accountnumber + "\n";
	info += "Pin Number: " + pinnumber + "\n";
	info += "Current Balance: $" + accountbalance.toString();  // toString() makes the account balance a string, since it was a double before
	System.out.println(info);
    }
}
