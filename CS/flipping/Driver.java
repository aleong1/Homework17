/* Alexia Leong
   APCS1 pd2
   HW16 --Get It While You Can
   2017-10-15 */ 
/***
    driver for class Coin
    ~~~ SUGGESTED WORKFLOW: ~~~
    1. Compile this file and run.
    2. Move the "TOP" line below the first statement. 
    (with cursor at beginning of TOP line, C-k C-k, DOWN, DOWN, C-y)
    3. Compile and run again. 
    4. Resolve errors 1 at a time until it works
    5. Repeat 2-4 until TOP meets BOTTOM
***/

public class Driver
{      
    public static void main( String[] args )
    {
	//build Objects from blueprint specified by class Coin

	//test default constructor
	Coin mine = new Coin();
  
	//test 1st overloaded constructor
	Coin yours = new Coin( "quarter" );
 
	//test 2nd overloaded constructor
	Coin wayne = new Coin( "dollar", "heads" );

	//test toString() methods of each Coin
	System.out.println("mine: " + mine);
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test flip() method
	System.out.println("\nAfter flipping...");
	yours.flip();
	wayne.flip();
	System.out.println("yours: " + yours);
	System.out.println("wayne: " + wayne);

	//test equals() method
	if ( yours.equals(wayne) ) {
	    System.out.println( "Matchee matchee!" );}
	else{
	    System.out.println( "No match. Firestarter you can not be." );}
	
	//testing out while: for hw16
	int ctr = 0; // to keep track of while loop
	int x = 21; //for while loop
	int y = 34;
	int headstracker = 0;
	while (headstracker < x){ //while loop to track # of heads flipped
	    if (yours.flip() == "heads" && wayne.flip() == "heads") {
		headstracker += 2;
	    }
	    else{
		if (yours.flip() == "heads" || wayne.flip() == "heads"){
		    headstracker += 1;
		}
	    } // end of else
	}	
	System.out.println("\nHeads Summary info: \nHeads Has been flipped " + x +" times.");	
	System.out.println("yours: " + yours);
	System.out.println("---------------------------------------");
	System.out.println("wayne: " + wayne);
	
	while (ctr < y){ // to count # of matches
	    if ( yours.equals(wayne) ) {
		ctr += 1;
		yours.flip();
		wayne.flip();
	    }
	    else {
		yours.flip();
		wayne.flip();
	    }
	}	
	System.out.println("---------------------------------------");
	System.out.println("There have been a total of " + y + " matches.");

	while ((ctr % 2001) > 0) {
	    while ((ctr % 2001) != 0) {  //for if the # of matches is over 13000 and is divisible by 2001
		if ( yours.equals(wayne) ) {
		    ctr += 1;
		    yours.flip();
		    wayne.flip();
		}
		else {
		    yours.flip();
		    wayne.flip();
		}
		while (ctr <= 13000) {
		    ctr += 1;
		}
	    }
}    
	    System.out.println("---------------------------------------");
	    System.out.println("There have been " + ctr + " matches and it's divisible by 2001."); 
    /*===================TOP==========================
      ====================BOTTOM======================*/

}//end main()

}//end class
