/* Team RowFour: Alexia Leong, Ryan Kim
   APCS1 pd 02
   HW17 -- Do I repeat myself?
   2017-10-16 */  

public class Repeater{
    private static String fence1 = "";  //variable is up here because if it was in fenceR, everytime the fxn would loop again fence would start over as being an empty string
    //methods that have to be static
    public static String fenceW(int numPosts){
	String fence = "";
	while(numPosts > 1) {  // while numPosts is > 1, then add more to the fence
	    fence += "|--";
	    numPosts -= 1; //continue with one less post
	}
	fence += "|";  //otherwise add the last post
	return fence;
    }
    public static String fenceR(int numPosts){
	if(numPosts > 1){  //same conditional
	    fence1 += "|--";
	    fenceR(numPosts - 1);  //reference the same function that its in with a new parameter
	}
	else {
	    fence1 += "|";  //adds last post
	}
	return fence1;
    }
    public static void main(String[] args){
	System.out.println("FenceW: \n" + fenceW(8)); //should be 8 posts
	System.out.println("FenceR: \n" + fenceR(8));
    }
}
