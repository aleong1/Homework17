/* Alexia Leong
   APCS1 pd2
   HW25 -- All Hallow's Eve Getting Real Spooky Out Here
   2017-11-01 */

public class Loopier{
    //A static method to populate an existing array with randomly generated ints
    public static int[] exist(){
        int[] anArray = new int[5]; //create array with length 5
	for (int ctr = 0; ctr < anArray.length; ctr += 1){
	    anArray[ctr] = (int)(Math.random() * 10); 
	}
	return anArray; //can't print this out or else it'll print and address 
    }
    //A static method to return a String version of an array of ints.
    public static String printr (int[] nums){
	String array = "[";
	for (int ctr = 0; ctr < nums.length;ctr += 1){
	    if(ctr < nums.length-1)   array += nums[ctr] + ","; //to not add a comma to the last element of array 
	    else array += nums[ctr] + "]";
	}
	return array;
    }
    //Two public, static implementations of a linear search function that will return the index of the first occurrence of a target in an existing array, or -1 if not found. (First version iterates, second recurses.)

    //iterative version:
    public static int linSearch(int[] a, int target){
	int place = 0;
	for(int ctr = 0; ctr < a.length; ctr += 1){
	    if(a[ctr] == target){
		place = ctr;
		return place;  //if it finds the first index, return it right away
	    }
  	    else place = -1; //if you never reach the target, return -1
	}
	return place;	
    }

    //recursive version
    public static int linSearchR(int[] a, int target){
	int place = 0;
	int result = 0;
	if (a.length == 0){  //for if nothing matches the target
	    place = -1;
	    return place;
	}
	if (a[0] == target){  
	    return place;
	}
	else{
	    int[] anArray = new int[a.length-1];  //make a new array for rescursion
	    for (int ctr = 0; ctr < a.length-1; ctr += 1){
		anArray[ctr] = a[ctr + 1];
	    }
	    result = linSearchR(anArray,target);
	    if (result > -1){  //to not add anything to -1 to make it seem like there's a match
		place += 1;
		place += result;
	    }
	    else{
		place = result;
	    }
	}
	return place;
    }
   
   

    // Two public, static implementations of a frequency function that will return the number of occurrences of a target in an existing array. (First version iterates, second recurses.)

    //iterative version:
    public static int freq(int[] a, int target){
	int freq = 0;
	for(int ctr = 0; ctr < a.length; ctr += 1){
	    if(a[ctr] == target)  freq += 1;
	}
	return freq;	
    }

    //recursive version:
    
    public static int freqRec(int[] a, int target) {
	if (a.length == 0) return 0;
	int[] anArray = new int[a.length - 1];  //make a new array 
	for (int ctr = 0; ctr < a.length-1; ctr ++) {
	    anArray[ctr] = a[ctr + 1];
	}
	if (a[0] == target) return 1 + freqRec(anArray, target); //add 1 to the past occurences
        return freqRec(anArray, target);
    }

    
    public static void main(String[] args){
	System.out.println(printr(exist())); //should return an array of random ints
	int[] a = {1,2,2,3,3,3};
	System.out.println(linSearch(a, 2)); //should return 1
	int[] b = {1,2,3,4};
	System.out.println(linSearch(b, 8)); //should be -1
	System.out.println(linSearchR(a, 3)); //should return 3
	System.out.println(linSearchR(b, 8)); //should be -1
	System.out.println(freq(a,1)); // should be 1
	System.out.println(freq(a,3)); // should be 3
	System.out.println(freqRec(a,3)); // should be 3
	System.out.println(freqRec(a,5)); // should be 0
	
    }
}
