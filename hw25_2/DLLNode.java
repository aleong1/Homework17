/* Alexia Leong
APCS2 pd1
HW24a -- On the DLL
2018-03-26 */   

/*****************************************************
 * class DLLNode
 * Implements a doubly-linked node,
 * for use in lists and other collection classes.
 * Stores data of type String
 *****************************************************/

public class DLLNode 
{
  private Object _cargo;    //cargo may only be of type Object
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

    public DLLNode(Object value, DLLNode next, DLLNode prev){
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }

    //accessors
    public Object getCargo() {return _cargo;}
    public DLLNode getNext() { return _nextNode;}
    public DLLNode getPrev() {return _prevNode;}

    //mutators
    public Object setCargo( Object newCargo ) {  //from hw21
	Object foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode setNext( DLLNode newNext ) {
	DLLNode foo = getNext();
	_nextNode = newNext;
	return foo;
    }

     public DLLNode setPrev( DLLNode newPrev ) {
	DLLNode foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }

     // override inherited toString
    public String toString() { return _cargo.toString(); }

    public static void main( String[] args ){
	DLLNode a = new DLLNode( "a", null, null);
	DLLNode b = new DLLNode("b", null, null);
	DLLNode c = new DLLNode("c", null, null);

	a.setNext(b);
	c.setPrev(b);

	System.out.println("First node: " + a.getCargo()); //a
	System.out.println("Second node: "+ a.getNext()); //b
	
	System.out.println("Node before c: "+ c.getPrev()); //b
    }
    
}//end class DLLNode
