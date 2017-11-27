/* Alexia Leong
   APCS1 pd2
   HW21 -- Karmacomma
   2017-10-23 */

public class Commafier{
    public static String commafyR(int num){
	String value = "";    // String output
	String newint = Integer.toString(num);  //convert int to string to make it easier to manipulate
	int ctr = newint.length();
	if (ctr <= 3){  //if you dont need a comma
	    value += newint;
	}
	else{  //else, w recursion, find the commas you need and add the last 3 ints 
	    value += commafyR(Integer.parseInt(newint.substring(0, ctr - 3)))+ "," + newint.substring(ctr - 3, ctr);
        }
	return value;  // return value, a string
    }
    public static String commafyF(int num){
	String output = "";
	String newint = Integer.toString(num); //change num into a string
	for(int ctr = newint.length() ; ctr > 3; ctr -= 3){  
	    output = "," + newint.substring(ctr - 3, ctr) + output; //don't use += here because it will switch 345 and 678 in test case 6
	}
	if (newint.length() == 3){  //for if there are 3 digit numbers, they wouldn't work with the % in the else
	    output = newint;
	}
	else{
	    output = newint.substring(0, newint.length() % 3) + output;  //also don't use += here
	}
	return output;
    } 
    public static void main(String[] args){
	//foreach loop:
	for(String s : args){
	    System.out.println(commafyF(Integer.parseInt(s)));  //to run in terminal : $ java Commafier 1 1000 -> 1 \n 1,000
	}
	/*System.out.println("||||||||||||| Recursive Version:|||||||||||||||");
	System.out.println(commafyR(1)); //should be 1
	System.out.println(commafyR(10)); //10
	System.out.println(commafyR(101)); //101
	System.out.println(commafyR(1000)); // 1,000
	System.out.println(commafyR(12345)); //12,345
	System.out.println(commafyR(12345678));//12,345,678
	System.out.println("||||||||||||| Iterative Version:|||||||||||||||");
	System.out.println(commafyF(1)); //1
	System.out.println(commafyF(10));//10
	System.out.println(commafyF(101));//101
	System.out.println(commafyF(1000));//1000
	System.out.println(commafyF(12345));//12,345
	System.out.println(commafyF(12345678));//12,345,678*/	    
    }// end of main method
} // end of class
