/* Team GOSING!!!! - Alexia Leong and Stefan Tan
APCS2 pd1
HW17
2018-03-12 */

/*
The function is called Partition because it divides/partitions every element in the array into whether or not it's greater or less than the element at position c/pvtPos which is the partition. A is left because it's the position left boundary in the array and b is right to be the upper boundary. B has to change to match the size of the array you want. Then v is pvtVal because it will take the place of the value of the partition because as the array changes, the value at c/pvtPos will change. Then s is storPos because it's the value that's always being compared to and when the function stops running, it's the position where everything to the left of it is < it and everything to the right is >= it, dividing the array.
 */

public class Mysterion{

    public static int sortDivider(int[] arr, int lowerBound, int upperBound, int halfPos){
	int midVal, divider, holder;
	print(arr); //print arr as given
	midVal = arr[halfPos];  //takes value of element in the center position
	arr[halfPos] = arr[upperBound];  //swap the center value and the last one
	arr[upperBound] = midVal;  
        divider = lowerBound;
	for(int i = lowerBound; i <= upperBound - 1; i++){
	    if(arr[i] < midVal){    //swaps elements so all elements that are less than the midVal is on the left and > is on the right
		holder = arr[divider];  
		arr[divider] = arr[i];
		arr[i] = holder;
		divider += 1;
	    }
	}
	holder = arr[upperBound];  
	arr[upperBound] = arr[divider];
	arr[divider] = holder;
	print(arr);  //print completed array
	//return divider;	    // is the position where elements to the left are < arr[divider] and elements to the right are > arr[divider], numbers that are the same are treated as greater than
	return arr[divider];
    }

    public static  void print(int[] arr){
	String after = "[";
	for(int q = 0; q < arr.length; q++){
	    after += arr[q] + ",";
	}
	after = after.substring(0, after.length() - 1) + "]";	 
	System.out.println("Array: " + after);
    }

    public static void main(String[] args){
	int[] a = {7,1,5,12,3};  //size 5 random
	System.out.println(sortDivider(a, 0, 4, 2)); //returns 3rd smallest #
	System.out.println("--------------------------------");

	System.out.println(sortDivider(a, 0, 4, 3));
	System.out.println("--------------------------------");

	/*
       	int[] b = {1,2,3,4,5};  //size 5 ascending
	System.out.println(sortDivider(b, 0, 4, 2));
	System.out.println("--------------------------------");

	int[] c = {5,4,3,2,1}; //size 5 descending
	System.out.println(sortDivider(c, 0, 4, 2));
	System.out.println("--------------------------------");

	int[] d = {9,4,1,10,3,8}; //size 6 random
	System.out.println(sortDivider(d, 0, 5, 2));
	System.out.println("--------------------------------");

	int[] e = {7,6,9,3,1,10,2};  //size 7 random
	System.out.println(sortDivider(e, 0, 6, 3));
	System.out.println("--------------------------------");

	int[] f = {7,6,9,3,3,3,6};  //size 7 repeating numbers
	System.out.println(sortDivider(f, 0, 6, 3));
	System.out.println("--------------------------------");  */
	    
	

    }

}
