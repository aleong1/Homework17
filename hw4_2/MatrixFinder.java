//Team Cheesy Potatoes -- Alexia Leong, Bing Li, Wenting Li
//APCS2 pd01
//HW03 -- I Am Still Searching
//2018-02-02

/*
 *Consider an n x n 2D array of ints, wherein numbers increase across any row (L->R) and down any column...
 *
 *e.g.,
 *
 *| 1  3  5 |
 *
 *| 3  7  8 |
 *
 *| 5 12 15 |
 *... Given a target number returns the coordinates of the first occurence of the 
 *    target number if found
 *    If not found, (-1, -1) is returned
 *
 *Algorithm: 
 *    1. Start with the top right corner
 *    2. Compare element with target
 *        a. if element == target, return coordinate
 *        b. if element < target, increase row by 1
 *        c  if element > target, decrease column by 1
 *    3. Repeat step 2 until coordinates are returned or element is out of bound
 *       in which case we return (-1, -1)
 */

public class MatrixFinder {
    public static String search(int[][] matrix, int target){
	int col = matrix.length - 1; //starting at upper right corner
	int row = 0;
	while(col >= 0 && row < matrix.length){  //as long as it's in the bounds of the matrix
	    if (matrix[row][col] == target){  //once that target is found, if it's there
		return "(" + row + "," + col + ")";
	    }
	    else if(matrix[row][col] < target){  //either it's less than target so go to greater #s
		row++;
	    }
	    else{  //or less than target so go to lower #s
		col--;
	    }
	}
	return "(-1,-1)";  //if not found, return (-1,-1])
    }

    public static void main(String[] args){
	int[][] x = {{1,3,5},{2,6,9},{7,10,13}};
	int[][] y = {{1}};
	int trial = 1;
	
        String s = "Displaying matrix x:\n";
        for (int r = 0; r < x.length; r++) {
            s += "|  ";
            for (int c = 0; c < x.length; c++) {
                s += x[r][c] + "  ";
            }
            s += "|\n";
        }
        System.out.println(s);

	System.out.println("Position of 6 in x:  " + search(x,6)); //(1,1)
	System.out.println("Position of 5 in x:  " + search(x,5)); //(0,2)
	System.out.println("Position of 7 in x:  " + search(x,7)); //(2,0)
	System.out.println("Position of 14 (not in matrix):  " + search(x,14)); //(-1,-1)

	System.out.println("\nPosition of 1 in y:  " + search(y,1)); //(0,0)
	System.out.println("Position of 0 (not in matrix):  " + search(y,0)); //(-1,-1)

	//testing out runtime
	System.out.println("\n\nPosition of 6 in x:");
	while(trial <= 10){
	    long startTime = System.nanoTime();
	    search(x,6); //code being tested 
	    long estimatedTime = System.nanoTime() - startTime;
	    System.out.println("Run time for trial " + trial + " is " + estimatedTime +" nanoseconds.");
	    trial++;
	}

	trial = 1;
	System.out.println("\n\nNew Target:\nPosition of 7 in x:");
	while(trial <= 10){
	    long startTime = System.nanoTime();
	    search(x,7); //code being tested 
	    long estimatedTime = System.nanoTime() - startTime;
	    System.out.println("Run time for trial " + trial + " is " + estimatedTime +" nanoseconds.");
	    trial++;
	}

	trial = 1;
	System.out.println("\n\nNew Target:\nPosition of 5 in x:");
	while(trial <= 10){
	    long startTime = System.nanoTime();
	    search(x,5); //code being tested 
	    long estimatedTime = System.nanoTime() - startTime;
	    System.out.println("Run time for trial " + trial + " is " + estimatedTime +" nanoseconds.");
	    trial++;
	}
			     
	
    }//end of main

	    
}


