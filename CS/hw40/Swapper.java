/* Alexia Leong
   APCS1 pd2
   HW40 -- Make It Better
   2017-11-25 */

/* Operation: The cs1 package had to be imported first and then I hardcoded a 3x4 array. Then I used the print2 method from hw34 as the print method here to display in the terminal but edited a bit to make it work with this code so far. Then for the swap method I would use positions from the main method to swap two elements.*/
/* Version 2 Improvements: So with this version, I changed a lot to make it work, especially in the main method with Keyboard.readInt(). Also, it's more clear for users and that the hardcoded array is now under an instance variable (so you have to make an instance in the main method) so when used in the swap method, it's easier. */

import cs1.Keyboard;

public class Swapper{
    
    private String[][] _anArray;
    public Swapper() { // the arrays will always be set to this
	_anArray = new String[][]{
	    {"dot","zap","jam"},
	    {"nap","vex","wow"},
	    {"mom","joy","cat"},
	    {"dip","zig","zip"}
	};
    }
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public void print()
    {for(String[] sub: _anArray){  //for each element of the first layer
	    //System.out.println();
	    for(String str: sub){ //for each element of the 2nd layer
		System.out.print(str + "\t");
	    }
	    System.out.println();
	}
	System.out.println();
    }

    public void swap(int a, int b, int c, int d){
	String holder = _anArray[a][b]; //place holder bc this position will change later
	_anArray[a][b] = _anArray[c][d];
	_anArray[c][d] = holder;
	} 
	
    public static void main(String[] args){
	Swapper x = new Swapper();
	System.out.println("Current array is:");
	x.print(); //displays array in terminal
	
	System.out.println("Type in a row number from 0-3 then press enter:");
	int a = Keyboard.readInt();   //type in terminal
	System.out.println("Type in a column number from 0-2:");
	int b = Keyboard.readInt();
	System.out.println("Type another row number (also from 0-3) to switch with:");
	int c = Keyboard.readInt();
	System.out.println("Type another column number (also from 0-2) to switch with:");
	int d = Keyboard.readInt();
	
	x.swap(a,b,c,d);
	System.out.println("\nThe swapped array is: ");
	x.print();  //reprints swapped array
    }
}
