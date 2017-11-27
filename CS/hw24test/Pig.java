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

import java.util.Scanner;
public class Pig 
{
    //Q: How does this initialization make your life easier?
    //A: I can search through VOWELS and see if a given string starts with any of the letters of VOWELS.
    private static final String VOWELS = "aeiou";
    private static final String PUNCT = ",.?!;:-";
    
    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") -> true
      hasA("cat", "p")       -> false
      =====================================*/
    public static boolean hasA( String w, String letter) {
    return w.indexOf(letter) != -1;
    }//end hasA()

    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) {
    return VOWELS.indexOf(letter.toLowerCase()) != -1;
    }

    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") -> 3
      =====================================*/
    public static int countVowels( String w ) {
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
    public static boolean hasAVowel( String w ) {
    //uses countVowels to check if the word has any vowels
    //if there are no vowels (0), return false   
    return countVowels(w) != 0; 
    }

    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") -> "eaa"
      =====================================*/
    public static String allVowels( String w ) {
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
    
    //returns String before the first space
    public static String beforeSpace(String w){
    if(w.indexOf(" ") != -1) return w.substring(0,w.indexOf(" "));
    else return w;
    }
    
    //pre-condition: given a string
    //returns piglatined string
    public static String engToPig(String w){
    boolean capital = false;
    String lastchar = w.substring(w.length()-1);
    String result = "";
    String spacesResult = "";
    //used to act on each word separately.
        while (hasA(w, " ")) {
        String temp = beforeSpace(w);
        String temppunct = w.substring(w.indexOf(" ") - 1, w.indexOf(" "));
        w = w.substring(w.indexOf(" ") + 1);
        //tests to see if character before space is a punctuation mark
        if (hasA(PUNCT,temppunct)) spacesResult += engToPig(temp.substring(0,temp.length()-1)) + temppunct + " ";
        else spacesResult += engToPig(temp) + " ";
        }
        if (beginsWithVowel(w)) result = w + "way";
        else {
        capital = startCapital(w);

        if (hasA(PUNCT, lastchar)) w = w.substring(0,w.length()-1);
        //loops until the word begins with a vowel
        for (int i = 0; i < w.length(); i+=1) {
            if (beginsWithVowel(w)) {  
            //if the original word started out with a capital letter the pig word should have a starting capital letter
            if(capital) result = capitalize(w.toLowerCase()) + "ay";
            //if the original word was all lowercase just return the pig word
            else result = w + "ay";
            }//closed outer if
         
            //rearranging letters of the word until it begins with a vowel
        else {
            //if w begins with a y and it is not the first letter of the original word
            if (w.substring(0,1).equals("y") && i > 0) {
            if(capital) result = capitalize(w.toLowerCase()) + "ay";
            else result = w + "ay";
            }
            w= w.substring(1) + w.substring(0,1);
        }
        } //closes for loop
    } //closes first else
        if (hasA(PUNCT,lastchar)) return spacesResult + result + lastchar;
    return spacesResult + result;
    }
    
    public static void main( String[] args ) 
    {
    System.out.println(engToPig("Hi, there."));
    System.out.println(engToPig("Fly with me."));
    System.out.println(engToPig("yup hello there?"));
    Scanner sc = new Scanner(System.in);
    while(sc.hasNext()){
        System.out.println(engToPig(sc.next()));
	} 
    }//end main()
}// end class Pig
   
