/* Alexia Leong
APCS2 pd1
HW15 -- Thinkers of the Corn
2018-03-07 */   

/***
 * SKEELTON for class 
 * MazeSolver
 * Implements a blind depth-first exit-finding algorithm.
 * Displays probing in terminal.
 * 
 * USAGE: 
 * $ java Maze [mazefile]
 * (mazefile is ASCII representation of maze, using symbols below)
 * 
 * ALGORITHM for finding exit from starting position:
 *  0. Check if you are at the @ symbol then the algorithm ends
    1. Check the 4 paths clockwise recursively
    If there is a blockage (' ' and '.'), backtrack to previous position and start choosing the direction again
    If the hero bumps into the boundary, then he shall backtrack
    If there is no blockage and no boundary, then move in that direction and color the previous position 
    2. End the algorithm when the hero reaches @
 ***/

//enable file I/O
import java.io.*;
import java.util.*;


class MazeSolver 
{
  private char[][] maze;
  private int h, w; //height, width of maze
  private boolean solved;

  //initialize constants for map component symbols
  final private char HERO =         '@';
  final private char PATH =         '#';
  final private char WALL =         ' ';
  final private char EXIT =         '$';
  final private char VISITED_PATH = '.';


  public MazeSolver( String inputFile ) 
  {
    // init 2D array to represent maze 
    // (80x25 is default terminal window size)
    maze = new char[80][25];
    h = 0;
    w = 0;

    //transcribe maze from file into memory
    try {
	    Scanner sc = new Scanner( new File(inputFile) );

	    System.out.println( "reading in file..." );

	    int row = 0;

	    while( sc.hasNext() ) {

        String line = sc.nextLine();

        if ( w < line.length() ) 
          w = line.length();

        for( int i=0; i<line.length(); i++ )
          maze[i][row] = line.charAt( i );

        h++;
        row++;
	    } 

	    for( int i=0; i<w; i++ )
        maze[i][row] = WALL;
	    h++;
	    row++;

    } catch( Exception e ) { System.out.println( "Error reading file" ); }

    //at init time, maze has not been solved:
    solved = false;
  }//end constructor


  public String toString() 
  {
    //send ANSI code "ESC[0;0H" to place cursor in upper left
    String retStr = "[0;0H";  
    //emacs shortcut: C-q, then press ESC
    //emacs shortcut: M-x quoted-insert, then press ESC

    int i, j;
    for( i=0; i<h; i++ ) {
	    for( j=0; j<w; j++ )
        retStr = retStr + maze[j][i];
	    retStr = retStr + "\n";
    }
    return retStr;
  }


  //helper method to keep try/catch clutter out of main flow
  private void delay( int n ) 
  {
    try {
	    Thread.sleep(n);
    } catch( InterruptedException e ) {
	    System.exit(0);
    }
  }


  /*********************************************
   * void solve(int x,int y) -- recursively finds maze exit (depth-first)
   * @param x starting x-coord, measured from left
   * @param y starting y-coord, measured from top
   *********************************************/
  public void solve( int x, int y ) {

    delay(50); //slow it down enough to be followable

    //primary base case
    if (maze[x][y] == '$' ) {
	solved = true;
	return;
    }
    //other base case(s)...
    else if (maze[x][y] == ' ' ) {
	solved = false;
	return;
    }
    else if (maze[x][y] == '.' ) {
	solved = false;
	return;
    }
    else if (maze[x][y] == '@') {
	solved = false;
	return;
    }
    //recursive reduction
    else {
	maze[x][y] = '.';

	solve(x, y+1); //up
	solve(x-1,y); //to the left
	solve(x, y-1); //down
	solve(x+1,y); //to the right

	//if not
	maze[x][y] = '#';
	solved = false;
	return;
	    
	
    }
  }

  //accessor method to help with randomized drop-in location
  public boolean onPath( int x, int y) { return maze[x][y] == PATH; }

}//end class MazeSolver


public class Maze 
{
  public static void main( String[] args ) 
  {
    try {
	    String mazeInputFile = args[0];

	    MazeSolver ms = new MazeSolver( mazeInputFile );
	    //clear screen
	    System.out.println( "[2J" ); 

	    //display maze 
	    System.out.println( ms );

	    //drop hero into the maze (coords must be on path)
	    //comment next line out when ready to randomize startpos
	    ms.solve( 0, 0 ); 

	   
	    //drop our hero into maze at random location on path
	    //the Tim Diep way:
	    Random r = new Random();
	    int startX = r.nextInt( 80 );
	    int startY = r.nextInt( 25 );
	    while ( !ms.onPath(startX,startY) ) {
      startX = r.nextInt( 80 );
      startY = r.nextInt( 25 );
	    }

	    ms.solve( startX, startY );
	 /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    } catch( Exception e ) { 
	    System.out.println( "Error reading input file." );
	    System.out.println( "Usage: java Maze <filename>" ); 
    }
  }

}//end class Maze
