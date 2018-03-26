/* Alexia Leong
   APCS2 pd1
   HW24b -- On the DLL
   2018-03-26 */

public class LList implements List{
    //instance vars
    private DLLNode _head;
    private int _size;

    public LList(){  //default
	_head = null;
	_size = 0;
    }
 
    //interface methods:
    public boolean add(Object x){   //adds at the beginning 
	DLLNode temp = new DLLNode(x, _head, null);  
	_head = temp;
	_size++;
	return true;
    }

    public void add(int i, Object x){  //add at index
	if(i < 0 || i >= _size)
	    throw new IndexOutOfBoundsException();
	
	DLLNode newNode = new DLLNode(x, null, null);
	if(i == 0)
	    add(x);
	else{
	    DLLNode temp = _head;  //alias to _head
	    for( int a=0; a < i-1; a++ )
		temp = temp.getNext();  //temp becomes the next node in the list

	    newNode.setNext(temp.getNext());  //pointer from the new node goes to list
	    temp.setNext(newNode);   //temp is before newNode right now so set the pointer from temp to newNode
	    newNode.setPrev(temp);//set pointers both ways
	    _size++;
	}
    }

    public Object remove(int i){
	if(i < 0 || i >= _size)
	    throw new IndexOutOfBoundsException();

	Object old;
	DLLNode temp = _head; //another alias
	if(i==0){
	    old = temp.getCargo();  
	    _head = _head.getNext();  //if the index is already the first one then just set the head to the one infront
	}
	else{
	    for( int a=0; a < i-1; a++ )
		temp = temp.getNext();  //temp becomes the next node in the list
	    old = temp.getNext().getCargo();

	    
	    temp.setNext(temp.getNext().getNext());  //here, the pointer from temp already skips/removes the one infront of it
	    if(temp.getNext() != null){  //getNext() is ALREADY the one you want, don't need two getNext()s
		temp.getNext().setPrev(temp);  //to make the pointers go two ways
	    }
	}
	_size--;
	return old;
    }

    public Object get(int i){
	if(i < 0 || i >= _size)
	    throw new IndexOutOfBoundsException();
	int ctr = 0;
	DLLNode temp = _head;  //starting from the first node in the list
	while(ctr < i){
	    temp = temp.getNext();  //temp becomes the next node in the list 
	    ctr++;
	}
	return temp.getCargo();
    }

    public Object set(int i, Object x){
	if(i < 0 || i >= _size)
	    throw new IndexOutOfBoundsException();
	DLLNode temp = _head; //another alias
	if(i==0) temp.setCargo(x);   //if it's at first node then just set temp
	
	for( int a=0; a < i-1; a++ )
	    temp = temp.getNext();
	Object old = temp.getCargo();
	temp.setCargo(x);

	return old;
    }

    public int size(){
	return _size;
    }

    public String toString(){  //new toString()
	String list = "Head: ";
	DLLNode temp = _head; 
	while( temp != null ) {
	    list += temp.getCargo() + ",";
	    temp = temp.getNext();
	}
	list += "Null";
	return list;
    }
}//end class
