/* Alexia Leong
   APCS2 pd1
   HW21c -- Rockin’ Through the Night
   2018-03-20 */   

public class LList implements List{

    private int _size;
    private LLNode _first;  //easier to see the ends of the list
    private LLNode _last;

    public LList(){
	_first = null;
	_last = null;
	_size = 0;
    }

    public boolean add( String x ){
	boolean added = false;
	LLNode next = new LLNode(x);
	_size++;
	if(_first == null){  //for setting the first element
	    _first = next;
	    _last = next;
	    added = true;
	}
	else{
	    _last.setNext(next);  //if it's not he first element
	    _last = next;
	    added = true;
	}
        return added;
    }

    public String get( int i ){
	int ctr = 0;
	LLNode temp = _first;  //starting from the first node in the list
	while(ctr < i){
	    temp = temp.getNext();  //temp becomes the next node in the list 
	    ctr++;
	}
	return temp.getCargo();
    }

    public String set( int i, String x ){
	int ctr = 0;
	LLNode temp = _first;  //starting from the first node in the list
	while(ctr < i){
	    temp = temp.getNext();  //temp becomes the next node in the list 
	    ctr++;
	}
	return temp.setCargo(x);	
    }

    public int size(){
	return _size;
    }

    public String toString(){
	String list = "[";
	LLNode now = _first;
	while(now.getNext() != null){
	    list += now.getCargo() + ", "; 
	    now = now.getNext();
	}
	list += now.getCargo();
	return list.substring(0, list.length()) + "]";
    }

    public static void main(String[] args){
	LList a = new LList();  //creating a new LList
	a.add("a");  //adding 5 nodes
	a.add("b");
	a.add("c");
	a.add("d");
	a.add("e");
	System.out.println("Initial list: " + a);   //prints initial list

	System.out.println("Node at position 1: " + a.get(1));  
	System.out.println("Node at position 4: " + a.get(4));
	//System.out.println("Node at position 5: " + a.get(5));  //should be null

	a.set(3,"changed");  //change d --> changed
	System.out.println("Changed list: " + a);
	System.out.println("Size of the list is: " + a.size());      	 
    }
}
