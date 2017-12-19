/* Alexia Leong
   APCS1 pd2
   HW56 -- His Toe Grammar
   2017-12-18 */

/*====================================================================
  An AP-style question, for practice:
  Write the StatPrinter class below. The StatPrinter Object receives an
  ArrayList of nonnegative integers, then builds a frequency ArrayList in which
  the index values are the data and the entry at the index is the frequency.
  For example, if the received data is    2,3,2,5,1,3    then the frequency 
  list would be [0,1,2,2,0,1]. This is read as 0 zeroes, 1 one, 2 twos,
  2 threes, 0 fours, 1 five. The size of the frequency list is the equal to
  the maximum value of the data.

  A capability of the class is to calculate local modes from the frequency 
  list. A local mode is a value that is greater than the value at index-1 
  and greater than the value at index+1. A local mode is never at the end
  points of the list. For example, if the frequency list is [1,2,1,4,2,3,5] 
  then the local modes are 2 and 4.

  This class is also capable of printing a histogram of the frequencies, using
  '*'s to indicate a frequency amount. To print a histogram, the user specifies
  the longest sequence of '*'s used and then all other values are printed in 
  proportion to this value. For example, if longest bar is 10 and the frequency
  list is [1,2,1,4,2,3,5] then the histogram printed looks like this:

  0 : **
  1 : ****
  2 : **
  3 : ********
  4 : ****
  5 : ******
  6 : **********

  For each method, state run time efficiency using Big O notation.

  Tips for Awesome:
  * Keys to Success are so named for a reason.
  * Look over all fxns, think a bit, decide which to tackle first.
  ( Simplest?  Prerequisites? . . . )
  * Develop 1 fxn at a time, test it, then move to next.
  * For coding today, what extra code do you need to get past compiler?
  ====================================================================*/

import java.util.ArrayList;


public class StatPrinter {

    // instance variable for frequencies of each integer in input ArrayList
    private ArrayList <Integer> _frequency;


    //*************** QUESTION 02 **************************
    //precond:  data.size() > 0, each entry b/t 0,100 inclusive
    //postcond: _frequency.size() set to max(data) + 1
    //          _frequency.get(i) returns frequency of i in data
    //eg, for data [2,3,2,5,2,3]
    //  _frequency would be [0,0,3,2,0,1]
    // this is O(n^2) because there are n pairs with n original numbers
    public StatPrinter( ArrayList <Integer> data ) 
    {   _frequency = new ArrayList<Integer>();
        for(int i = 0; i < data.size(); i++){
	    int ctr = 0;
	    for(int a = 0; a < data.size(); a++){
		if(data.get(a) == i)  //count how many times a number shows up
		    ctr += 1;
	    }
	    _frequency.add(ctr);  //add it into _frequency
	}
    }

    //*************** QUESTION 01 **************************
    //precond:  data.size() > 0
    //postcond: returns largest integer in data
    //this in O(n)
    public Integer max( ArrayList <Integer> data ) 
    {   int max = 0;
        for(int a = 0; a < data.size(); a++){
	    if(data.get(a) > max)
		max = data.get(a);  //max can always change but will always be current max
	}
	return max;
    }


    //*************** QUESTION 03 **************************
    //postcond: returns true if i > 0 and i < _frequency.size() - 1
    //          and _frequency.get( i - 1 ) < _frequency.get( i )
    //          and _frequency.get( i + 1 ) < _frequency.get( i )
    //          Otherwise, returns false
    //eg, for _frequency [1,2,1,5,5,8,2,4]
    //    2 and 8 are local modes, so
    //    isLocalMode(0) -> false
    //    isLocalMode(1) -> true
    //    isLocalMode(5) -> true
    //this is O(1), it's constant
    public boolean isLocalMode( int i ) 
    {   if((i > 0) && (i < _frequency.size() - 1)
	   &&  (_frequency.get( i - 1 ) < _frequency.get(i))
	   && (_frequency.get( i + 1 ) < _frequency.get( i )))
	    return true;
	return false;
    }


    //*************** QUESTION 04 **************************
    //postcond: returns list of modes in _frequency
    //this is O(n) where n is the number of elements in _frequency
    public ArrayList<Integer> getLocalModes() 
    { ArrayList modes = new ArrayList<Integer>();
	for(int i = 0; i < _frequency.size(); i++){
	    if(isLocalMode(_frequency.get(i))){  //if it is a local mode
		modes.add(_frequency.get(i));  //add it to modes
	    }
	}
	return modes;
    }   
  

    //*************** QUESTION 05 **************************
    //precond:  longestBar > 0
    //this is O(a*b) because there are 2 different numbers that the for loops go up to
    public void printHistogram( int longestBar ) 
    {
        int multiplier = longestBar / max(_frequency);  //to set up proportions
	for(int i = 0; i < _frequency.size(); i++){
	    String stars = "";
	    for(int a = 0; a < _frequency.get(i)*multiplier; a++){
		stars += "*";
	    }
	    System.out.println(i + ": " + stars);
	}
    }
 
}//end class StatPrinter
