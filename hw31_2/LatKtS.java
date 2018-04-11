/* Alexia Leong
   APCS2 pd1
   HW31 -- Stack: What Is It Good For?
   2018-04-11 */   

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s )
    {
	Latkes temp = new Latkes(s.length());
	for(int i = 0; i < s.length(); i++)   //push string into a stack
	    temp.push(s.substring(i,i+1));
	String rtn = "";
	for(int i = 0; i < s.length(); i++)   //then pop it all into a string
	    rtn += temp.pop();
	return rtn;
		    

    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s )
    {
	if(s.length() == 0 || (s.length() % 2) != 0) //if empty or uneven string
	    return false;
	
	Latkes open = new Latkes(s.length());  
	for(int i = 0; i < s.length(); i++){
	    String a = s.substring(i,i+1);   
	    if(a.equals("{") || a.equals("(") || a.equals("["))   //separate open and close characters
		open.push(a);
	    
	    else{
	    	if(a.equals("}") && !(open.pop().equals("{"))) return false;  //if the next char in the string doesn't match the required bracket
	    	else if(a.equals(")") && !(open.pop().equals("("))) return false;
	    	else if(a.equals("]") && !(open.pop().equals("["))) return false;
	    }
	}
	return open.isEmpty();  //true when all matches are used up 
    }//end allMatched()


    //main method to test
    public static void main( String[] args )
    {
 
	System.out.println(flip("stressed"));

	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
