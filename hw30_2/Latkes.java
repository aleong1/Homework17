/* Alexia Leong
APCS2 pd1
HW30 -- Stacks on Stacks on Stacks on Stacks…
2018-04-10 */  

/*****************************************************
 * skeleton for class Latkes
 * Implements a stack of Strings using an encapsulated array
 *****************************************************/

public class Latkes
{
  private String [] _stack;
  private int _stackSize;

  //constructor
  public Latkes( int size )
  {
      _stack = new String[size];
      _stackSize = size;
  }

  //means of insertion
  public void push( String s )
  {
      if(isFull())
	  _stackSize++;  //to fit more strings into the stack bc there isn't enough space     yet
            
      String[] temp = new String[_stackSize];
      temp = _stack;
      _stack = new String[_stackSize + 1];  //increase size of _stack
      _stack[0] = s;    
      for(int i = 1; i < _stackSize; i++){
	  _stack[i] = temp[i-1];
      }
  }
 
  //means of removal
  public String pop( )
  {
      if(isEmpty())
	  return "Empty Stack";
      if(_stackSize == 1)    
	  _stack[0] = null;
      
      String first = _stack[0];
      for(int i = 1; i < _stackSize; i++)
	  _stack[i-1] = _stack[i];   //shift stacks over one
      _stackSize--;
      
      return first;  //returns "The object at the top of this stack " -- from API
  }

  //chk for emptiness
  public boolean isEmpty()
  {
      return _stack == null;

  }

  //chk for fullness
  public boolean isFull()
  {
      return _stack[_stackSize - 1] != null;	  
  }

    public String toString(){
	String stack = "START : ";
	for(int i = 0; i < _stackSize; i++){
	    stack += _stack[i] + " ";
      }
	stack += " : END";
	return stack;
    }

  //main method for testing
  public static void main( String[] args )
  {
  
      Latkes tastyStack = new Latkes(10);

      tastyStack.push("aoo");
      tastyStack.push("boo");
      tastyStack.push("coo");
      tastyStack.push("doo");
      tastyStack.push("eoo");
      tastyStack.push("foo");
      tastyStack.push("goo");
      tastyStack.push("hoo");
      tastyStack.push("ioo");
      tastyStack.push("joo");
      tastyStack.push("coocoo");
      tastyStack.push("cachoo");

      System.out.println(tastyStack);

      //cachoo
      System.out.println( tastyStack.pop() );
      //coocoo
      System.out.println( tastyStack.pop() );
      //joo
      System.out.println( tastyStack.pop() );
      //ioo
      System.out.println( tastyStack.pop() );
      //hoo
      System.out.println( tastyStack.pop() );
      //goo
      System.out.println( tastyStack.pop() );
      //foo
      System.out.println( tastyStack.pop() );
      //eoo
      System.out.println( tastyStack.pop() );
      //doo
      System.out.println( tastyStack.pop() );
      //coo
      System.out.println( tastyStack.pop() );
      //boo
      System.out.println( tastyStack.pop() );
      //aoo
      System.out.println( tastyStack.pop() );
 
      //stack empty by now; SOP(null)
      System.out.println( "Empty Stack: " + tastyStack.pop() );

      System.out.println( tastyStack.pop() );
  /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v     ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main()

}//end class Latkes
