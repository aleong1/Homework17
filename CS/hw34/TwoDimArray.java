/******************************
 * class TwoDimArray
 * (skeleton)
 * practice working with 2D arrays
 ******************************/

// Alexia Leong
// APCS1 pd2
// HW34 -- 2D arrays
// 2017-11-16

public class TwoDimArray
{
    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOR loop
    public static void print1( int[][] a )
    { for(int arr = 0; arr < a.length; arr += 1){  //for each array that's an element in the first array
	    if(arr >= 1) System.out.println(); 
	    for(int ctr = 0; ctr < a[arr].length; ctr += 1){ //for each element in the 2nd layer of array
		System.out.print(a[arr][ctr]);
	    }
	}
	System.out.println(); 
    }

    //postcond: prints each row of 2D int array a on its own line
    //          uses a FOREACH loop
    public static void print2( int[][] a )
    {for(int[] ctr: a){  //for each element of the first layer
	    System.out.println();
	    for(int arr: ctr){ //for each element of the 2nd layer
		System.out.print(arr);
	    }
	}
	System.out.println();
    }

    //postcond: returns sum of all items in 2D int array a
    public static int sum1( int[][] a )
    {int totsum = 0;
	for(int[] ctr: a){
	    for(int arr: ctr){
		totsum += arr; //adds each element to the totsum
	    }
	}
	return totsum;
    }

    //postcond: returns sum of all items in 2D int array a
    //          * uses helper fxn sumRow
    public static int sum2( int [][] m )
    {int sumdos = 0;
	for(int ctr = 0;ctr < m.length; ctr += 1){  //for each row add the sum of the whole row
	    sumdos += sumRow(ctr, m);
	}
	return sumdos;
    }

    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOR loop
    public static int sumRow( int r, int[][] a )
    {int sumrow = 0;
	for(int ctr = 0; ctr < a[r].length; ctr += 1){ //to get each element in the chosen row
	    sumrow += a[r][ctr];
	}
	return sumrow;
    }

    //postcond: returns sum of all items on row r of 2D int array a
    //          uses a FOREACH loop
    public static int sumRow2(int r, int[][] m)
    {int sumrowdos = 0;
	for(int a: m[r]){ 
	    sumrowdos += a;
	}
	return sumrowdos;
    }

    public static void main( String [] args )
    {
	int [][] m1 = new int[4][2];
	int [][] m2 = { {2,4,6}, {3,5,7} };
	int [][] m3 = { {2}, {4,6}, {1,3,5} };
	System.out.println("For m1:"); 
	print1(m1);
	System.out.println("For m2:");
	print1(m2);
	System.out.println("For m3:");
	print1(m3);
	System.out.println("print2 for m1:"); 
	print2(m1);
	System.out.println("print2 for m2:"); 
	print2(m2);
	System.out.println("print2 for m3:"); 
	print2(m3);
	System.out.print("testing sum1...\n");
	System.out.println("sum m1 : " + sum1(m1)); //should be 0
	System.out.println("sum m2 : " + sum1(m2)); //should be 27
	System.out.println("sum m3 : " + sum1(m3)); //should be 21
	System.out.print("testing sum2...\n");
	System.out.println("sum m1 : " + sum2(m1));
	System.out.println("sum m2 : " + sum2(m2));
	System.out.println("sum m3 : " + sum2(m3));
    }
}//end class TwoDimArray
