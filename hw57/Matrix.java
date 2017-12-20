/* Alexia Leong
   APCS1 pd2
   HW57 -- How Deep Does The Rabbit Hole Go? 
   2017-12-19 */

/***
 * class Matrix -- models a square matrix
 *
 * BACKGROUND:
 * A matrix is a rectangular array.
 * Its dimensions are numRows x numColumns.
 * Each element is indexed as (row,column): 
 *  eg,
 *   for 2 x 3 matrix M:
 *        -       -
 *   M =  | a b c |
 *        | d e f |
 *        -       -
 *   ... d is at position (2,1) or M[2,1] 
 *
 * TASK:
 * Implement methods below, categorize runtime of each. 
 * Test in main method.
 ***/


public class Matrix 
{
    //constant for default matrix size
    private final static int DEFAULT_SIZE = 2;

    private Object[][] matrix;

    //default constructor intializes a DEFAULT_SIZE*DEFAULT_SIZE matrix
    public Matrix( ) 
    {
	Object[][] matrix = new Object[DEFAULT_SIZE][DEFAULT_SIZE];
    }


    //constructor intializes an a*a matrix
    public Matrix( int a ) 
    {
	Object[][] matrix = new Object[a][a];
    }


    //return size of this matrix, where size is 1 dimension
    private int size()
    {
	return matrix.length;
    }


    //return the item at the specified row & column   
    private Object get( int r, int c ) 
    {
	return matrix[r][c];
    }


    //return true if this matrix is empty, false otherwise
    private boolean isEmpty() 
    {
	if(size() == 0)
	    return true;
	return false;
      
    }


    //overwrite item at specified row and column with newVal
    //return old value
    private Object set( int r, int c, Object newVal ) 
    {   Object old = matrix[r][c];
	matrix[r][c] = newVal;
	return old;
    }


    //return String representation of this matrix
    // (make it look like a matrix)
    public String toString() 
    {   String mat = "";
	for(int i = 0; i < matrix.length; i++){
	    String row = "";
	    for(int r = 0; r < matrix[i].length; r++){
		row += matrix[i][r];
	    }
	    mat += row + "\n";
        }
	return mat;
    }


    //override inherited equals method
    //criteria for equality: matrices have identical dimensions,
    // and identical values in each slot
    public boolean equals( Object rightSide )
    {  	boolean same = false;
	int a = 0;
	if(rightSide instanceof Matrix){
	    if(((Matrix)rightSide).size() == size()){
		if(a == matrix[0].length)
		    for(int i = 0; i < matrix.length; i++){
			for(int r = 0; r < matrix[i].length; r++){
			    if (get(i, r) == ((Matrix)rightSide).get(i, r)){
				same = true;
			}}}}}
	return same;
    }


    //swap two columns of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapColumns( int c1, int c2  ) 
    {
	Object[] copy = new Object[matrix[c1].length];
	for(int i = 0; i < matrix[c1].length; i++)
	    copy[i] = get(i,c1);
	for(int i = 0; i < matrix[c1].length; i++)
	    set(i, c1, get(i,c2));
	for(int i = 0; i < matrix[c2].length; i++)
	     set(i, c2, copy[i]);
    }


    //swap two rows of this matrix 
    //(1,1) is top left corner of matrix
    //row values increase going down
    //column value increase L-to-R
    public void swapRows( int r1, int r2  ) 
    {
	Object[] copy = new Object[matrix[r1].length];
	for(int i = 0; i < matrix[r1].length; i++)
	    copy[i] = get(r1,i);
	for(int i = 0; i < matrix[r1].length; i++)
	    set(i, r1, get(r2,i));
	for(int i = 0; i < matrix[r2].length; i++)
	     set(i, r2, copy[i]);
    }


    //main method for testing
    public static void main( String[] args ) 
    {   Matrix arr = new Matrix(3);
	for( int i = 0; i < 3; i++ ) {
	    for( int r = 0; r < 3; r++ ) {
		arr.set(i,r,i * 2);
	    }
	}
	System.out.println("Matrix arr \n" + arr);
	System.out.println("Matrix size: " + arr.size());
	System.out.println("Matrix empty?: " + arr.isEmpty());
	arr.swapRows(1,2);
	System.out.println("Swapping rows 1 and 2: " + arr);
	arr.swapColumns(1,2);
	System.out.println("Swapping columns 1 and 2: " + arr);
	
	
	
    
    }
}//end class Matrix
