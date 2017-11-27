/* Alexia Leong
   APCS1 pd2
   HW20 -- For the Lulz Love of Strings .
   2017-10-19 */

public class Foresrever{
    //methods:
    public static String fenceF(int posts){
	String fence = "|"; // for if you only have one post, just return this
	for(int numposts = posts; numposts > 1; numposts--){ 
	    fence += "--|"; //adds rest of fence
	}
	return fence;
    } // end of fenceF

    public static String reverseF(String s){
	String reversed = "";  //as the new reversed word
	for(int ctr = s.length(); ctr > 0; ctr--){  //start off w/ ctr asa the length of the string
	    reversed += s.substring(ctr-1, ctr); //so it'll only return the last/next letter (substing() needs 2 parameters, the first letter to the last so -1 to isolate 1 letter
	}
	return reversed;
    } // end of reverse F

    public static String reverseR(String s){
       	int ctr = s.length();
	if (ctr > 0){
	    return s.substring(ctr-1, ctr) + reverseR(s.substring(0, ctr-1));  //recursive loop with s, except for the last letter
	}
	return s;
    }   
    public static void main(String[] args){
	System.out.println("Tests for fenceF:");
	System.out.println("For 1 post:\n " + fenceF(1));
	System.out.println("For 2 posts:\n " + fenceF(2));
	System.out.println("For 3 posts:\n " + fenceF(3));
	System.out.println("---------------------------------- \nTests for reverseF:");
	System.out.println("stressed -> desserts:\n" + reverseF("stressed"));
	System.out.println("onion -> noino:\n" + reverseF("onion"));
	System.out.println("---------------------------------- \nTests for reverseR:");
	System.out.println("stressed -> desserts:\n" + reverseR("stressed"));
	System.out.println("soup -> pous:\n" + reverseR("soup"));
    } //end of main method
}//end of class
