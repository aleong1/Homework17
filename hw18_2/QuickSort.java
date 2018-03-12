/* Alexia Leong
APCS2 pd1
HW18 -- So So Quick
2018-03-13 */   
  
/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr): 
     1. It checks to see if the array is of size 1 or not, if it is then it returns the array, if not it goes to the helper function...
     2. Called qsorthelp, this method has left and right boundaries as arguments.
              a. This first checks to see if the array boundaries (left and right) don't overlap and stay on their respective side.
              b. If that's true then if stores the index of the pvtPos from partitioning arr and then uses that as a bound when recursively doing qsorthelp on the left and right halves of the array. 
 *
 * 2a. Worst pivot choice and associated runtime: 
 *     When the pivot choice is one of the ends of the array because it divides the array into two arrays of size 1 and the (array size - 1) and continues to do that recursively. The size of the biggest array will only go down by 1 each time it goes back to do quicksort. Runtime is O(n^2). 
       
 * 2b. Best pivot choice and associated runtime:
 *     The best case is when the pivot position is the exact center and the arrays that are split are divided into equal sizes (or maybe off by 1). By doing this, the array is divided into two arrays that are the smallest size they can be without making the other array overly large. Since the array is being divided in half (or as close as possible to it) in addition to the recursive calls, the runtime is O(nlogn).

 * 3. Approach to handling duplicate values in array:
         Duplicates are handled as being greater than the number in the pvtPos.
 *
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array 
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }
  //--------------^  HELPER METHODS  ^--------------



  /*****************************************************
   * void qsort(int[])
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
    { if(d.length <= 1) return;  //if they're single size arrays (sorted within themselves)
      else{
	  qsorthelp(d, 0, d.length-1);  //go to helper method bc that one has bounds (left and right)
      }      
    }

  //you may need a helper method...
    public static void qsorthelp(int[] arr, int left, int right){
	if(left < right){
	    int pvtPos = partition(arr, left, right, left);
	    qsorthelp(arr, left, pvtPos - 1);  //lower half of array w/o pvtPos
	    qsorthelp(arr, pvtPos + 1, right); // upper half of array w/o pvtPos
	}
    }

    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal, storPos;
	pvtVal = arr[pvtPos];  //takes value of element in the center position
	swap(pvtPos, right, arr);  //swap the center value and the last one
        storPos = left;
	for(int i = left; i <= right - 1; i++){
	    if(arr[i] < pvtVal){    //swaps elements so all elements that are less than the pvtVal is on the left and > is on the right
		swap(storPos, i, arr);
		storPos += 1;
	    }
	}
	swap(right, storPos, arr);
	return storPos; //returns final resting pos of pvtPos
    }

  //main method for testing
  public static void main( String[] args )
  {
  
    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );	
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;
       
    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


      //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );	
    System.out.println("arr2 after qsort: " );
    printArr(arr2);

 

    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );
       
    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
  /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
