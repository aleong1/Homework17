/* Alexia Leong
   APCS2 pd1
   HW33 -- What a Racket
   2018-04-13 */   

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 * 
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Traversing the split array, check if the element is )
 *         2. If it is, then add if to the stack containing ONLY that expression
             3. While traversing through the stack of the whole problem, determine the next element.
               4. If the element is an operand, assign the right number to the var op
               5. If it's not an operand then it's a number so add it to the stack nums
            6. Since you are done adding to the stack for this (sub)set of (), unload it
 *         7. If not, the expression didn't end yet so continue to add to stack noClose
      8. Return the top element of the stack for the whole problem
 *
 * STACK OF CHOICE: LinkedList by hw32
 * b/c when pushing or popping elements, there isn't a need to copy over a new array to change the size.
 ******************************************************/

public class Scheme
{
    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns the simplified value of the expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
	String[] arr = expr.split("\\s+");
	LLStack<String> nums = new LLStack<String>();
	LLStack<String> noClose = new LLStack<String>();
	int op = 0;

	for(String i : arr){   
	    if(i.equals(")")){  //when you reach the closing parenthesis
		String top = noClose.pop();   //start going through this part of the expression
		nums.push(i); //add ( to stack for unload
		
		while(!top.equals("(")){    //until you reach the (, where the expression ends
			      
		    if(top.equals("+")) op = 1;
		    else if(top.equals("-")) op = 2;
		    else if(top.equals("*")) op = 3;

		    else nums.push(top); //if it's not an operand

		    top = noClose.pop();
		}

		noClose.push(unload(op, nums));
	    }
	    
	    else noClose.push(i);  //pushed into a stack of what's in this ()
        
	}//end of for loop  
      
	return noClose.peek();
    }//end evaluate()


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren is seen thru peek().
     *           Returns the result of operating on sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, Stack<String> numbers ) 
    {
	int total = 0;
	if(op == 1){
	    while(!numbers.peek().equals(")"))
		total += Integer.parseInt(numbers.pop());
	    return "" + total;
	}

	if(op == 2){
	    total = Integer.parseInt(numbers.pop());
	    while(!numbers.peek().equals(")"))
		total -= Integer.parseInt(numbers.pop());
	    return "" + total;
	}

	if(op == 3){
	    total = 1;
	    while(!numbers.peek().equals(")"))
		total *= Integer.parseInt(numbers.pop());
	    return "" + total;
	}

	return "";
 
    }//end unload()


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
    try {
    Integer.parseInt(s);
    return true;
    }
    catch( NumberFormatException e ) {
    return false;
    }
    }
    */


    //main method for testing
    public static void main( String[] args )
    {


	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	  String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	  System.out.println(zoo2);
	  System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	  //...17

	  String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	  System.out.println(zoo3);
	  System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	  //...29

	  String zoo4 = "( - 1 2 3 )";
	  System.out.println(zoo4);
	  System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	  //...-4
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }//main

}//end class Scheme
