/* Alexia Leong
APCS2 pd1
HW21b -- We Got a Little Ol’ Convoy...
2018-03-20 */   

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String _cargo;
    private LLNode _next;


    // constructor 
    public LLNode(String a){
	_cargo = a;
	_next = null;
    }
    

    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {
	return _cargo;
    }

    public LLNode getNext()
    {
	return _next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String set)
    {
	_cargo = set;
	return _cargo;
    }

    public LLNode setNext(LLNode set)
    {
	_next = set;
	return _next;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    { 
        return "[" + _cargo + "]";
 
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...

	LLNode first = new LLNode("a");
	LLNode second = new LLNode("b");
	LLNode third = new LLNode("c");
	first.setNext(second);
	second.setNext(third);

	System.out.println("The first node is: " + first.getCargo()); //a
	System.out.println("The node after the first is: " + first.getNext()); //[b]

	second.setCargo("hi");
	System.out.println("The second node is: " + second.getCargo()); //hi
	System.out.println("The node after the third is: " + third.getNext());//null
	
    }//end main

}//end class LLNode
