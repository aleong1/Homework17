/* Team You Go Glen Coco- Alexia Leong and Jude Grodesky
   APCS1 pd2
   HW 55 -- Never Fear, Big Oh is Here!
   2017-12-15f */

import java.util.ArrayList;

public class MySorts{
    /*From OAL, add() is binary and addBin() is logarithmic
     Best case for add() is if the appropriate index is the first one, the worst case is if its the last index because it uses a linear search.
    For addBin(), the best case would be if it's the first half index. The worst case would be if it's at the position log2(n). This uses binary search.*/
    
    //helper method: populate
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi )
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }
    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    //Best Case: Linear, as it will make n-1 passes, which is a linear function in terms of n, the x axis.
    //Worse Case: Linear, as it will make n-1 passes.    
    public static void bubbleSort( ArrayList<Comparable> data )
    {int ctr = 0;
	//make n-1 passes across collection
	for( int passCtr = 1; passCtr < data.size(); passCtr++ ) {
	    System.out.println( "commencing pass #" + passCtr + "..." );
	    
	    //iterate from first to next-to-last element
	    for( int i = 0; i < data.size()-1; i++ ) {
		//if element at i > element at i+1, swap
		if ( data.get(i).compareTo(data.get(i+1) ) > 0 ) {
		    data.set( i, data.set(i+1,data.get(i)) );
		    ctr += 1;
		}
		//System.out.println(data); //diag: show current state of list
	    }
	}
	System.out.println( "total swaps :" + ctr );
    }

    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    //Best Case: Linear, as it will make n-1 passes, which is a linear function in terms of n, the x axis.
    //Worse Case: Linear, as it will make n-1 passes.    
    public static void selectionSort( ArrayList<Comparable> data ) 
    {
	//note: this version places greatest value at rightmost end,
	//maxPos will point to position of SELECTION (greatest value)
	int maxPos;
	int ctr = 0;
	for( int pass = data.size()-1; pass > 0; pass-- ) {
	    System.out.println( "\nbegin pass " + (data.size()-pass) );//diag
	    maxPos = 0;
	    for( int i = 1; i <= pass; i++ ) {
		System.out.println( "maxPos: " + maxPos );//diag
		System.out.println( data );//diag
		if ( data.get(i).compareTo( data.get(maxPos) ) > 0 ){
		    maxPos = i;
		    ctr += 1;
		}
	    }
	    data.set( maxPos, ( data.set( pass, data.get(maxPos) ) ) );
	    System.out.println( "after swap: " +  data );//diag
	}
	System.out.println( "total swaps :" + ctr );
    }//end selectionSortV

     // VOID version of InsertionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order

    //Best Case: Linear, as it will make n-1 passes, which is a linear function in terms of n, the x axis.
    //Worse Case: Linear, as it will make n-1 passes.    
    public static void insertionSort( ArrayList<Comparable> data )
    {int ctr = 0;
	for(int partition = 1; partition < data.size(); partition++){   //for n-1 passes
	    for(int a = partition; a > 0; a--){  
		if(data.get(a).compareTo(data.get(a-1)) < 0){
		    data.set( a-1, data.set(a,data.get(a-1)) );  //swap values
		    ctr += 1;
		}
	    }
	}
	System.out.println( "total swaps :" + ctr );
    }//end insertionSortV
}
