/* Team Pumpkins - Alexia Leong and Daniel Gelfand
   APCS1 pd2
   HW42 -- Array of Grade 316_ 
   2017-11-28 */

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{
    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor – initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = 0;
    }

    //output SuperArray in [a,b,c] format
    public String toString()
    {
    
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }

    //double capacity of SuperArray
    private void expand()
    {
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }

    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }

    //adds an item after the last item
    public void add( int newVal )
    {
	int[] holder = new int[_size+1]; //make a new placeholder array with longer length
	for( int i = 0; i < _size; i++ ){
	    holder[i] = _data[i]; //copy all elements from old array into new one
        
	}
	_data = holder;  //
	_data[holder.length-1] = newVal;  //set last element to newVal
    //modify size: 1 more meaningful element
    _size +=1;
   
    }

    //inserts an item at index
    public void add( int index, int newVal )
    {
      	int[] holder = new int[_size+1];

	for( int i = 0; i < index; i++ ){
	    holder[i] = _data[i];
	}
	//insert value
	holder[index] = newVal;

	//insert rest of items
	for(int i = index; i < _size;i+=1){
	    holder[i+1] = _data[i];
	    
	}

	_data = holder;
	
    //modify _size: 1 more meaningful element
    _size += 1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index )
    { 
    int[] holder = new int[_size-1]; //placeholder array with 1 less element
	for(int i = 0; i < index; i++){  //up until the index, recopy the elements
	    holder[i] =_data[i];
	}
	for(int i = index + 1; i < _size; i++){
	    holder[i-1] = _data[i]; //then skip index and copy the elements, also shifts elements
	}
	_data = holder;
    //modify _size: 1 less meaningful element
    _size -=1;
    }

    //return number of meaningful items in _data
    public int size()
    {
    return _size;
    }

    //main method for testing
    public static void main( String[] args )
    {
 
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
	// System.out.println("Size: " + curtis._size);
 
	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("new length of underlying array: "
			       + curtis._data.length );
	}
 
	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	System.out.println("new length of underlying array: "
			   + mayfield._data.length );
 
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
        System.out.println("new length of underlying array: "
			   + mayfield._data.length );
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
        System.out.println("new length of underlying array: "
			   + mayfield._data.length );

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("new length of underlying array: "
			   + mayfield._data.length );
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("new length of underlying array: "
			   + mayfield._data.length );
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("new length of underlying array: "
			   + mayfield._data.length );
               
    
	/*~~~~~~~~move~me~down~~~~~~~~~~~~~~V~~~~~~~~	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|~~~~~~~~*/
    }//end main()


}//end class
