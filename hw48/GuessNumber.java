/*Alexia Leong
  APCS1 pd2
  HW48 -- Keep Guessing
  2017-12-06 */

/*==================================================
  class GuessNumber -- fun fun fun!

  eg, sample interaction with end user:
  Guess a # fr 1-100: 50
  Too high
  Guess a # fr 1-49: 25
  Too low
  Guess a # fr 26-49: 38
  Correct! It took 3 guesses
  ==================================================*/

import cs1.Keyboard;

public class GuessNumber 
{
    //instance vars
    private int _lo, _hi, _guessCtr, _target;


    /*==================================================
      constructor -- initializes a guess-a-number game
      pre:  
      post: _lo is lower bound, _hi is upper bound,
      _guessCtr is 1, _target is random int on range [_lo,_hi]
      ==================================================*/
    public GuessNumber( int a, int b ) 
    {
        _lo = 1;
	_hi = 100;
	_guessCtr = 1;
	_target = (int) (Math.random() * 100 + 1);
    }


    /*==================================================
      void playRec() -- Prompts a user to guess until guess is correct.
      Uses recursion.
      pre:  
      post: 
      ==================================================*/
    public void playRec() 
    {System.out.print("\nGuess a number from " + _lo + "-" + _hi + ": ");
	int a = Keyboard.readInt();
        if(a == _target){
	    System.out.println("Correct! It took you " + _guessCtr + " guess(es) :)");
	}			       
	else{
	    if(a < _target){
		System.out.print("Sorry, your number is too low, try again...");
		_lo = a + 1;
	    }
	    else{
		System.out.print("Sorry, your number is too high, try again...");
		_hi = a - 1;
	    }
	    _guessCtr += 1;
	    playRec();
	}
        
    }
    /*==================================================
      void playIter() -- Prompts a user to guess until guess is correct.
      Uses iteration.
      pre:  
      post: 
      ==================================================*/
    public void playIter() 
    {
        System.out.print("\nGuess a number from " + _lo + "-" + _hi + ": ");
	int a = Keyboard.readInt();
	while(a != _target){
	    if(a < _target){
		System.out.print("Sorry, your number is too low, try again...");
		_lo = a + 1;
	    }
	    else{
		System.out.print("Sorry, your number is too high, try again...");
		_hi = a - 1;
	    }
	    System.out.print("\nGuess a number from " + _lo + "-" + _hi + ": ");
	    a = Keyboard.readInt();
	    _guessCtr += 1;
	}
	System.out.println("Correct! It took you " + _guessCtr + " guess(es) :)");
    }
    
	//wrapper for playRec/playIter to simplify calling
	public void play() 
	{ 
	    //use one or the other below:
	    //playRec();
	    playIter();
	}

	//main method to run it all
	public static void main( String[] args ) 
	{
	    //instantiate a new game
	    GuessNumber g = new GuessNumber(1,100);

	    //start the game
	    g.play();
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	}//end main

    }//end class
