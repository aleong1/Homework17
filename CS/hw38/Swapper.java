/* Alexia Leong
   APCS1 pd2
   HW38 -- Put It Together
   2017-11-21 */

import cs1.Keyboard;
public class Swapper{

    //inst var
      private static String[][] anArray;
    //constructor 
    public Swapper(){
      anArray[0][0] = "dot";
      anArray[0][1] = "zap";
      anArray[0][2] = "jam";
      anArray[1][0] = "vex";
      anArray[1][1] = "snap";
      anArray[1][2] = "zap";
      anArray[2][0] = "wow";
      anArray[2][1] = "mom";
      anArray[2][2] = "joy";
      anArray[3][0] = "chip";
      anArray[3][1] = "dip";
      anArray[3][2] = "zig";
      } 
    
    //from hw34
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2()
    {for(String[] ctr: anArray){  //for each element of the first layer
	    System.out.println();
	    for(String arr: ctr){ //for each element of the 2nd layer
		System.out.print(arr + " ");
	    }
	}
	System.out.println();
    }

    public static void swap(int a, int b, int c, int d){
	String holder = anArray[a][b];
	anArray[a][b] = anArray[c][d];
	anArray[c][d] = holder;
	print2();
    }
	
    public static void main(String[] args){
	//Swapper arr = new Swapper();
	print2();
	//arr.swap(1,2,2,1);
    }
}
