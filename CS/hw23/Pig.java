/*Team There's Two Months Till Winter Break - Daniel Gelfand, Alexia Leong, and Lily Yan
  APCS1 pd2
  HW23 -- Etterbay Odingcay Oughthray Ollaborationcay ...Ippyay.
  2017-10-25  */
/* TO-DO List:
   - What to do with y? We're planning leave it as a consonant, unless we learn that there's a rule for it
   -Capitalizations -> we plan to capitalize the first letter of every word that was already capitalized after it has been pig latined, change VOWELS to "aeiouAEIOU"
   -The leading consonant sound moves to the end -> so each new word starts with a vowel, we can check this with isAVowel
   -Punctiation and capitalization -> if the word already has punctuation at the end (.?!,etc.)
   -Figure out a way to do punctuation for contractions if we want to keep them or not */
public class Pig 
{
    //Q: How does this initialization make your life easier?
    //A: I can search through VOWELS and see if a given string starts with any of the letters of VOWELS.
    private static final String VOWELS = "aeiou";

    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	return w.indexOf(letter) != -1;
        
    }//end hasA()

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	return VOWELS.indexOf(letter.toLowerCase()) != -1;
    }
    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	//variable used to hold # of occurences of a vowel
	int counter = 0;
	for(int i =0;i<w.length();i++){
	    if(isAVowel(w.substring(i,i+1))) counter += 1;
	}
	return counter; 
    }
    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") -> true
      hasAVowel("zzz")       -> false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	//uses countVowels to check if the word has any vowels
	//if there are no vowels (0), return false   
	return countVowels(w) != 0; 
    }
    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	String vowels = "";
	String curr = "";
	for(int i=0;i<w.length();i+=1){
	    curr = w.substring(i,i+1);
	    if(isAVowel(curr)) vowels += curr;
	}    
	return vowels;
    }
    //uses allVowels to return the first letter that string makes, if there even is a string
    public static String firstVowel(String w){
	String wordVowels = allVowels(w);
	if(wordVowels.length() > 0) return wordVowels.substring(0,1);
	else return wordVowels;
    }
    //returns true if w begins with a vowel, false otherwise
    public static boolean beginsWithVowel(String w){
	return isAVowel(w.substring(0,1));
    }
    //capitalizes first letter of string w
    public static String capitalize(String w){
	return w.substring(0,1).toUpperCase() + w.substring(1);
    }    
    //checks to see if first letter of w is capitalized
    public static boolean startCapital(String w){
        return (w.substring(0,1).equals(w.substring(0,1).toUpperCase()));
    }
    //pre-condition: given a string
    //returns piglatined string
    public static String engToPig(String w){
     
	boolean capital = startCapital(w.substring(0,1));
	int length = w.length(); 
    
	//System.out.println(capital); 
	if(beginsWithVowel(w)){
	    return w + "way";
	}
	else {     
	    //loops until the word begins with a vowel
	    for(int i = 0; i < length;i+=1)
		{
		    if(beginsWithVowel(w))
			{  
			    //if the original word started out with a capital letter the pig word should have a starting capital letter
			    if(capital)
				{  
				    w = capitalize(w.toLowerCase()) + "ay";
				    return w;
				}
			    //if the original word was all lowercase just return the pig word
			    else return w+"ay";
			}//closed outer if
         
		    //updating the word until it begins with a vowel
		    else w= w.substring(1) + w.substring(0,1);         
		}
	    return w;
	}    
    }
    public static void main( String[] args ) 
    {
	System.out.println("Now testing hasA(String w, String letter):");
	System.out.println("'cat' has the letter 'a': " + hasA("cat", "a")); //true
	System.out.println("'cat' has the letter 'p': " + hasA("cat", "p")); //false
   
	System.out.println("------------------------------------");
   
	System.out.println("Now testing isAVowel(String letter):");
	System.out.println("'e' is a vowel: "+ isAVowel("e")); //true
	System.out.println("'z' is a vowel: "+ isAVowel("z")); //false
   
	System.out.println("------------------------------------");
   
	System.out.println("Now testing countVowels(String w):");
	System.out.println("Number of vowels in 'meatball': " + countVowels("meatball")); //3
	System.out.println("Number of vowels in 'xdz': " + countVowels("xdz")); //0
   
	System.out.println("------------------------------------");
   
	System.out.println("Now testing hasAVowel(String w):");
	System.out.println("'cat' has a vowel: " + hasAVowel("cat")); //true
	System.out.println("'zzz' has a vowel: " + hasAVowel("zzz")); //false
   
	System.out.println("------------------------------------");
   
	System.out.println("Now testing allVowels(String w):");
	System.out.println("Vowels in 'meatball': " + allVowels("meatball")); //"eaa"
	System.out.println("Vowels in 'hello': " + allVowels("hello")); //"eo"
	System.out.println("Vowels in 'zzz': " + allVowels("zzz")); //""
   
	System.out.println("----------------------------------------------");
   
	System.out.println("Now testing firstVowel(String w):");
	System.out.println("The first vowel in 'zzz' is: " + firstVowel("zzz")); // ""
	System.out.println("The first vowel in 'armor' is: " + firstVowel("armor")); // a
	System.out.println("The first vowel in 'zzz' is: " + firstVowel("meatball")); // e
	System.out.println("The first vowel in 'gmo' is: " + firstVowel("gmo")); // o
   
	System.out.println("----------------------------------------------");
   
	System.out.println("Now testing beginsWithVowel(String w):");
	System.out.println("'zzz' begins with a vowel: " + beginsWithVowel("zzz")); // false
	System.out.println("'adios' begins with a vowel: " + beginsWithVowel("adios")); // true
	System.out.println("'cellar' begins with a vowel: " + beginsWithVowel("cellar")); // false
   
	System.out.println("----------------------------------------------");
   
	System.out.println("Now testing engToPig(String w):");
	System.out.println("'apple' in Pig Latin is: " + engToPig("apple")); //appleway
	System.out.println("'yellow' in Pig Latin is: " + engToPig("yellow")); //ellowyay
	System.out.println("'cat' in Pig Latin is: " + engToPig("cat")); //atcay
	System.out.println("'through' in Pig Latin is: " + engToPig("through")); //should be oughthray
	System.out.println("'true' in Pig Latin is: " + engToPig("true")); //should be uetray
	System.out.println("'Cat' in Pig Latin is: " + engToPig("Cat"));  //Atcay
    }//end main()
}// end class Pig
   
