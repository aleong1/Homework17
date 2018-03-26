/* Alexia Leong
   APCS2 pd1
   HW26 -- DeIteratour
   2018-03-27 */   

/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork 
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
	for(Integer a: L){
	    if(a == key)
		return true;
	}
	return false;
    }

    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    { 
        Iterator a = L.iterator(); // iterates through L
	while(a.hasNext())
	    if(a.next() == key)
		return true;
	return false;
    }

    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    { 
	List<Integer> odds = new ArrayList<Integer>();
	for(Integer a : L)
	    if(a % 2 == 1)
		odds.add(a);
	return odds;
    }

    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    {   List<Integer> odds = new ArrayList<Integer>();
        Iterator a = L.iterator(); // iterates through L
	while(a.hasNext()){
	    Integer b = (int) a.next();
	    if(b % 2 == 1)
		odds.add(b);
	}
	return odds;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
        Iterator a = L.iterator(); // iterates through L
	while(a.hasNext()){
	    Integer b = (int) a.next();
	    if(b % 2 == 0)
		a.remove();
	}
    }


    public static void main( String [] args ) 
    {
	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);

	// TASK: write code to print the contents of ArrayList L...


	// a) using a FOREACH loop
        
	String print = "Start: ";
	for(Integer a : L)
	    print += a + " ";
	System.out.println("List with FOREACH loop: \n" + print + " :End");
	


	// b) explicitly using an iterator
	String print1 = "Start: ";
	Iterator a = L.iterator();
	while(a.hasNext()){
	    print1 += a.next() + " ";
	}
	System.out.println("\nList with iterator: \n" + print1 + " :End");


	  System.out.println("\nTesting foundA...");
	  System.out.println("9 in L? -> " + foundA(9,L) );
	  System.out.println("13 in L? -> " + foundA(13,L) );
	  System.out.println("0 in L? -> " + foundA(0,L) );

	  System.out.println("\nTesting foundB...");
	  System.out.println("9 in L? -> " + foundB(9,L) );
	  System.out.println("13 in L? -> " + foundB(13,L) );
	  System.out.println("0 in L? -> " + foundA(0,L) );

	  System.out.println("\nTesting oddsA...");
	  List<Integer> A = oddsA(L);
	  for( int n : A ) System.out.println(n);

	  System.out.println("\nTesting oddsB...");
	  List<Integer> B = oddsB(L);
	  for( int n : B ) System.out.println(n);

	  System.out.println("\nTesting removeEvens...");
	  removeEvens(L);
	  for( int n : L ) System.out.println(n);
	/*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class ItrWork

