/*Alexia Leong
   APCS1 pd2
   HW49 -- Halving the Halves
   2017-12-07 */

/********************************
 * class OrderedArrayList
 * wrapper class for ArrayList.
 * Imposes the restriction that stored items 
 * must remain sorted in ascending order
 ********************************/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;

public class OrderedArrayList
{
    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;


    // default constructor initializes instance variable _data
    public OrderedArrayList()
    {
	_data = new ArrayList<Comparable>();    
    }


    public String toString()
    {
	return _data.toString(); 
    }


    public Comparable remove( int index )
    {	
	return _data.remove(index); 
    }


    public int size()
    { 
	return _data.size();
    }

    
    public Comparable get( int index )
    { 
	return _data.get(index); 
    }


    /***
     * add takes as input any comparable object 
     * (i.e., any object of a class implementing interface Comparable)
     * inserts newVal at the appropriate index
     * maintains ascending order of elements
     * uses a linear search to find appropriate index
     ***/
    public void add( Comparable newVal )
    { 
	for( int p = 0; p < _data.size(); p++ ) {
	    if ( newVal.compareTo( _data.get(p) ) < 0 ) { 
		//newVal < oal[p]
		_data.add( p, newVal );
		return; //Q:why not break?
	    }
	}
	_data.add( newVal ); //newVal > every item in oal, so add to end 
    }

    /*  addBin employs a binary search to locate the point of insertion for a new element. */
    public void addBin(Comparable newVal){
	int midinit = (_data.size() / 2); //initial middle value to set boundary later on
       int mid = (_data.size() / 2);
	while(newVal.compareTo(_data.get(midinit)) != 0){
	    if(newVal.compareTo(_data.get(mid)) == 0){  //if the newVal is already in the middle
		break;
	    }
	    if(newVal.compareTo(_data.get(mid-1)) > 0 && newVal.compareTo(_data.get(mid+1)) < 0 ){
		break;  //if newVal is not in the ArrayList, checks if it's between values
	    }
	    else{
		if(mid == 1){
		    break;
		}
		if(newVal.compareTo(_data.get(0)) < 0){  //if newVal is going to be the lowest number in ArrayList
		    _data.add(0,newVal);
		    return; //exit out
		}
		else{
		    if(newVal.compareTo(_data.get(mid)) < 0){  //if newVal is below the mid 
			if(mid > midinit){   //but if it's above the initial int
			    mid = (mid - midinit) / 2;
			}
			else{  // in the actual lower bound of the array
			    mid = (mid / 2);
			}
		    }
		    else{ //if newVal is greater than what's in the mid index
			if(newVal.compareTo(_data.get(_data.size()-1)) > 0){
			    _data.add(newVal);
			    return;  //not break bc this gets out of the whole thing, now just while loop
			}
			else{
			    mid = _data.size() - ((_data.size() - mid)/2);	//sets new mid for upper half
			}
		    }
		}
	    }
	}
	_data.add(mid, newVal);  //adds in newVal
    }


    // main method solely for testing purposes
    public static void main( String[] args )
    {
	OrderedArrayList Franz = new OrderedArrayList();

	// testing linear search
	for( int i = 0; i < 15; i++ )
	    Franz.add( (int)( 50 * Math.random() ) );
	Franz.addBin(4);  //testing for the lower half first
	//Franz.addBin(20);
	System.out.println( Franz );

	//check for sorted-ness
	//if msg does not appear, list was sorted
	for( int i=0; i<Franz.size()-1; i++ ) {
	System.out.println("at i: " + Franz.get(i) );
	if ( Franz.get(i).compareTo(Franz.get(i+1)) > 0 ) {
	System.out.println( " *** NOT sorted *** " );
	break;
	}
	}
	/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class OrderedArrayList
