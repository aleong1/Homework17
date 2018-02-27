/* Alexia Leong
   APCS2 pd1
   HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
   2018-02-28 */   

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
    private int[][] _board;
    
    public QueenBoard( int size ) 
    {
	_board = new int[size][size];
    }
    
    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     */
    public boolean solve()
    {
	if(solveH(0) == false){
	    for( int r = 0; r < _board.length; r++ ) {  //rows
		for( int c = 0; c < _board[0].length; c++ ) {  //columns
		    _board[r][c] = 0;  //fill with 0s bc it's false
		    return false;
		}
	    }
	}
	printSolution();   //show the solution
	return true;
    }
    
    /**
     *Helper method for solve. 
     */
    private boolean solveH( int col ) 
    {
	if(col >= _board.length) return true;  //ran out of queens
	
	for(int a = 0; a < _board.length; a++){  //start at top left corner
	    if(_board[a][col] == 0){  //see if it's an empty position
		addQueen(a,col);  //put queen here
		if(solveH(col + 1)) return true;   //use recursion to place rest of queens
		else removeQueen(a,col);  // if you can't place anymore queens
	    }
	}
	return false;	
    }
   
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {  //rows
	    for( int c = 0; c < _board[0].length; c++ ) {  //columns
		if( _board[r][c] != 1) ans += "_\t";
		else ans += "Q\t";
	    }
	    ans += "\n\n";
	}
	System.out.println(ans);
    }

    //================= YE OLDE SEPARATOR =================

    /***
     * This first finds if the place you want is valid (if it's 0 then it's a valid position. Then it puts 1 in the place inputted. It also subtracts 1 from all the places on the same row. Then it goes to the column to the right of the column inputted and subtracts 1 from the places diagonal to the position inputted. 
     * precondition: a nxn board/array
     * postcondition: a board with 1s as queens and invalid positions as negative numbers. Returns true or false if queens can be placed in position inputted.
     */
    private boolean addQueen(int row, int col){
	if(_board[row][col] != 0){
	    return false;
	}
	_board[row][col] = 1;
	int offset = 1;
	while(col+offset < _board[row].length){
	    _board[row][col+offset]--;  // -1 on the positions to the right in the same row
	    if(row - offset >= 0){  //diagonal upwards  to the right
		_board[row-offset][col+offset]--;
	    }
	    if(row + offset < _board.length){  //diagonal downwards to the right
		_board[row+offset][col+offset]--;
	    }
	    offset++;
	}
	return true;
    }


    /***
     * First find if there's a queen in the position inputted and if it is already empty, return false, if it's occupied, it makes it an empty space. Then it adds 1 to the positions to the right in the same row and also to the positions diagonal on the right side of the position inputted.
     * precondition: A nxn board/array
     * postcondition: A board that removes the queen in the position specified (if possible), returning true or false if the queen was successfully removed. 
     */
    private boolean removeQueen(int row, int col){
	if ( _board[row][col] != 1 ) {  //if it's an unoccupied place
	    return false;
	}
	_board[row][col] = 0;
	int offset = 1;

	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;   // add 1 to position in the same row but to all the columns to the right
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++; //add 1 to the positions diagonally upwards and to the right
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;  //add 1 to the positions diagonally downwards and to the right
	    }
	    offset++;
	}
	return true;
    }


    /***
     * This makes the board into a string by adding each element into ans and it appears like a board.
     * precondition:A nxn board/array. 
     * postcondition: A nxn board displayed as a string.
     */
    public String  toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {  //rows
	    for( int c = 0; c < _board[0].length; c++ ) {  //columns
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	QueenBoard b = new QueenBoard(5);
	System.out.println(b);
	b.addQueen(3,0);
	b.addQueen(0,1);
	System.out.println(b);
	b.removeQueen(3,0);
	System.out.println(b);

	System.out.println("Testing:");
	System.out.println("4x4 array");
	QueenBoard a = new QueenBoard(4);
	System.out.println(a);
	a.solve();

	System.out.println("7x7 array");
	QueenBoard c = new QueenBoard(7);
	System.out.println(c);
	c.solve();
    }
    
}//end class
