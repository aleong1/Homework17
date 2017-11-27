/* Alexia Leong
   APCS1 pd2
   HW22 -- Otnay Ybay ethay Airhay Onway Ymay Inneechay Inchay Inchay
   2017-10-24 */
/***
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiou"; //it puts all the vowels in one variable instead of having 5 different ones

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter )
    { boolean doesit = false;  //first sets a boolean as false
	for(int ctr = 0; ctr <= w.length()-1; ctr += 1){
	    String check = w.substring(ctr, ctr+1); 
	    if (check.equals(letter)){ //checks if the letter in w matches with letter
		return true;  //if it does, it goes straight to returning true
	    }
	    else{
		doesit = false; } }
	return doesit;	    
    }//end hasA()

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    { return hasA(VOWELS, letter);  //Does the same thing as hasA but w will always be VOWELS
    }

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {   int numvowels = 0;
	for(int ctr = 0; ctr <= w.length()-1; ctr += 1){
	    String check = w.substring(ctr, ctr+1);  
	    if (isAVowel(check)){  //uses isAVowel to see if the letter is a vowel or not but if it is then it will add 1 to the count of vowels
		numvowels += 1; }
	}
	return numvowels;
    }

    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {  if (countVowels(w) > 0){  //if there are more than 0 vowels (from the countVowels method) then it willl return true, there is/are vowel(s)
	    return true; }
	else{
	    return false; }
    }
    
    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {   String theseVowels = "";
	int ctr = 0;
	while (ctr <= w.length()-1){
	    if (isAVowel(w.substring(ctr,ctr+1))){//uses isAVowel to see if the letter is a vowel or not but if it is then it will add the letter to the string
		theseVowels += w.substring(ctr,ctr+1);
		ctr += 1;
	    }
	    else{
		ctr += 1; }
	}
	return theseVowels;
    }
    public static void main( String[] args ) 
    {   System.out.println("hasA: " + hasA("cat","a")); //should be true
	System.out.println("isAVowel: " + isAVowel("c")); //should be false
	System.out.println("countVowels: "+ countVowels("cake")); //should be 2
	System.out.println("hasAVowel: " + hasAVowel("pan")); //should be true
	System.out.println("allVowels: "+ allVowels("caakee")); //should be "aaee"
    }//end main()

}//end class Pig
