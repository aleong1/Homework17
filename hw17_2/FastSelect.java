/* Team weather forecasters - Alexia Leong and Stefan Tan
   APCS2 pd1
   HW17 -- So So Fast
   2018-03-12 */

/*
  The function is called Partition because it divides/partitions every element in the array into whether or not it's greater or less than the element at position c/pvtPos which is the partition. A is left because it's the position left boundary in the array and b is right to be the upper boundary. B has to change to match the size of the array you want. Then v is pvtVal because it will take the place of the value of the partition because as the array changes, the value at c/pvtPos will change. Then s is storPos because it's the value that's always being compared to and when the function stops running, it's the position where everything to the left of it is < it and everything to the right is >= it, dividing the array.
  
  Big O Runtime: O(n) 
  Best case: O(n) if the partition is the yth smallest number
  Worst case: O(n^2) searching for the smallest or largest number that is at the end of array and at the beginning at the array respectively


*/

public class FastSelect{

    public static int partition(int[] arr, int left, int right, int pvtPos){
	int pvtVal, storPos, holder;
	print(arr); //print arr as given
	pvtVal = arr[pvtPos];  //takes value of element in the center position
	arr[pvtPos] = arr[right];  //swap the center value and the last one
	arr[right] = pvtVal;  
        storPos = left;
	for(int i = left; i <= right - 1; i++){
	    if(arr[i] < pvtVal){    //swaps elements so all elements that are less than the pvtVal is on the left and > is on the right
		holder = arr[storPos];  
		arr[storPos] = arr[i];
		arr[i] = holder;
		storPos += 1;
	    }
	}
	holder = arr[right];  
	arr[right] = arr[storPos];
	arr[storPos] = holder;
	print(arr);  //print completed array
	return storPos;
    }

    public static  void print(int[] arr){  //prints array
	String after = "[";
	for(int q = 0; q < arr.length; q++){
	    after += arr[q] + ",";
	}
	after = after.substring(0, after.length() - 1) + "]";	 
	System.out.println("Array: " + after);
    }

    public static int select(int[] arr, int left, int right, int val){ //val is the (y - 1)th smallest number
	int pos;
	if(left < right){   //keeps arrays separate and not overlap
	    pos = partition(arr, left, right, val);  //current pivPos
	    if(pos == val) return arr[pos];  //if the pivPos is the val (y-1 smallest number you want)
	    if(pos < val) select(arr, pos + 1, right, val);   //if it's too small then go towards the numbers < it
	    else select(arr, left, right - 1, val);  //if it's too big
	}
	return arr[val];  //if nothing else fits
    }
    
    public static void main(String[] args){  // **last argument is y-1**
	int[] a = {7,1,5,12,3};  //size 5 random 
	System.out.println(select(a, 0, 4, 2)); //returns 3rd smallest # (Best Case)
	System.out.println("--------------------------------");

	System.out.println(select(a, 0, 4, 3));  //4th smallest number
	System.out.println("--------------------------------");

       	int[] b = {1,2,3,4,5};  //size 5 ascending, 3rd smallest number
	System.out.println(select(b, 0, 4, 4));
	System.out.println("--------------------------------");

	int[] c = {5,4,3,2,1}; //size 5 descending, smallest number (Worst Case)
	System.out.println(select(c, 0, 4, 0));
	System.out.println("--------------------------------");

	int[] d = {18,10,5,24,13,19,7,0}; //size 8 random with the smallest at the end 
	System.out.println(select(d, 0, 7, 0)); //returns the smallest # (Worst Case)
	System.out.println("--------------------------------");

	int[] e = {124,53,65,32,2,15,16,43}; //size 8 random with largest at the beginning 
	System.out.println(select(e, 0, 7, 7)); //returns the largest # (Worst Case)
	System.out.println("--------------------------------");

    }

}
