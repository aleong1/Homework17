/* Alexia Leong
APCS2 pd1
HW05 -- Step 1: Split, Step 2: ?, Step 3: Sorted!. . .
2018-02-06 */  

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm:
In the merge method it compares the first elements of each array and as it "takes" or copies over the lower element, it moves down that array. Then, if there are no more elements in one array, it adds the "leftover" elements to the merged array. In sort, I recursively broke/divided the array in half until the elements are by themselves in arrays of 1 element and then with those, I merged them until the array with the original size is returned.
  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
    {int[] c = new int[a.length + b.length];  //new array to return
	int elea = 0;  //ctr for a
	int eleb = 0;  //for b
	for(int ctr = 0; ctr < c.length; ctr++){
	    if(elea >= a.length){  //if arr a is shorter than b then add the leftovers of b
		c[ctr] = b[eleb];
		eleb++;
	    }
	    else if(eleb >= b.length){ //same case if length is switched
		c[ctr] = a[elea];
		elea++;
	    }
	    else if(a[elea] <= b[eleb]){  //comparing the first of each element
		c[ctr] = a[elea];
		elea++;
	    }
	    else{
		c[ctr] = b[eleb];
		eleb++;
	    }
	}
      return c;
  }//end merge()

  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
    {   int center = arr.length/2;
	if(arr.length <= 1){
	    return arr;
	}
	int[] temp = new int[arr.length - center];//arr of first half
	int[] temp1 = new int[center];
	for(int i = 0; i < center; i++){
	    temp1[i] = arr[i];
	}
	for(int i = 0; i < temp.length; i++){
	    temp[i] = arr[center+i];
	}
	return merge(sort(temp), sort(temp1));
  }//end sort()

  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
    //A: the elements in the array are replaced with 0 and end with a ,
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {


      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );
  
      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );
      
      System.out.println("\nMerging arr2 and arr4: "); //no longer arr9
      printArray( merge(arr2,arr4) );
 
      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
  /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~     ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
