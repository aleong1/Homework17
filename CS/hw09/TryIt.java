public class TryIt{
    public static void main( String[] args) {
	String total;
	BankAccount work = new BankAccount();

	work.accountname("Chuck Bass");
	work.passwrd("caesar");
	work.acctnum(123456789);
	work.pinnum(1987);
	work.balance(10.00);
	work.deposit(18.45);
	work.withdraw(.45);
        work.printAll();
        
    }
}
	   
