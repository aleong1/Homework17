/*Alexia Leong
   APCS1 pd2
   HW41 -- Array of Steel 
   2017-11-27 */

/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

public class SuperArray
{
    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray

    //default constructor – initializes 10-item array
    public SuperArray()
    {	_data = new int[10];  
	_size = 1;  //just sets _size to 1 so far
    }

    //output SuperArray in [a,b,c] format
    public String toString()
    {   String arr = "[";
	for(int i = 0; i < _data.length-1; i += 1){  //from hw40, the print method but changed
	    arr += _data[i] + ", ";
	}
	arr += _data[_data.length-1] + "]";
	return arr;
    }
	    
    //double capacity of SuperArray
    private void expand()
    {  int[] holder = new int[_data.length];
	holder = _data;
	_data = new int[holder.length*2];  
	for(int i = 0; i < holder.length; i++){ //makes _data longer
	    _data[i] = holder[i];
	}
    }

    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    { int old = _data[index]; //placeholder
	_data[index] = newVal;
	return old;
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

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	}
    }//end main()

}//end class
