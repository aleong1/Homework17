/* Alexia Leong
APCS2 pd1
HW34 -- The English Do Not Wait In Line
2018-04-16 */

public class NodeQueue<Quasar> implements Queue<Quasar>{

    //instance vars
    private LLNode<Quasar> _head;
    private LLNode<Quasar> _tail;

    //constructor
    public NodeQueue(){
	_head = new LLNode<Quasar>(null,null); //initiate with these first
	_tail = new LLNode<Quasar>(null,null);
	_head.setNext(_tail);
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public Quasar dequeue(){
        Quasar temp = _head.getValue();    //hold value of first element
	if( isEmpty()) return null;   //if there is nothing to remove from this queue	
	_head = _head.getNext();  //set new pointers
	return temp;
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( Quasar x ){
	LLNode<Quasar> add = new LLNode<Quasar>(x, null); 

	if(isEmpty()){    //if you're adding the only element to this queue
	    _head = add;
	    _head.setNext(_tail);
	}
	else if(_tail.getValue() == null){   //if there's only 1 element in this queue add to the head
	    _head.setNext(add);
	    _tail = add;
	}
	else{    //if there's a head and tail just add to end
	    _tail.setNext(add);
	    _tail = add;
	}

    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return _head.getValue() == null;  //if there's nothing in the head there's nothing else
    }

    //Returns the first element of the queue without dequeuing it.
    public Quasar peekFront(){
	if(isEmpty()) return null;  //can't return what's not there
	return _head.getValue();
    }
    
    public static void main(String[] args){
	NodeQueue<String> sharpay = new NodeQueue<String>();

	System.out.println("---------Testing Queue----------");

	sharpay.enqueue("Now");
	sharpay.enqueue("we're");
	sharpay.enqueue("gonna");
	sharpay.enqueue("bop");
	sharpay.enqueue("bop");
	sharpay.enqueue("bop,");
	sharpay.enqueue("bop");
	sharpay.enqueue("to");
	sharpay.enqueue("the");
	sharpay.enqueue("top");

	System.out.println("Is the queue empty? " + sharpay.isEmpty());  //false

	System.out.println("What's in the front? " + sharpay.peekFront());  //Now
        
	System.out.println("Dequeue-ing: " + sharpay.dequeue()); //Now
	
	System.out.println("What's in the front now? " + sharpay.peekFront()); //we're
	System.out.println("Dequeueing...");
	
	System.out.println(sharpay.dequeue());  //we're
	System.out.println(sharpay.dequeue());  //gonna
	System.out.println(sharpay.dequeue());  //bop
	System.out.println(sharpay.dequeue());  //bop
	System.out.println(sharpay.dequeue());  //bop,
	System.out.println(sharpay.dequeue());  //bop
	System.out.println(sharpay.dequeue());  //to
	System.out.println(sharpay.dequeue());  //the
	System.out.println(sharpay.dequeue());  //top
	
	//System.out.println("Is the queue empty now? " + sharpay.isEmpty());	
    }
}
