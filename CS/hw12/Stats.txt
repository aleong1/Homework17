/* Alexia Leong
   APCS1 pd02
   HW12 -- stAtistically sPeaking
   2017-10-05 */


public class Stats{
    
    //methods:
    public static int mean(int a, int b) {   //uses the parameters which have to be integers to find and return their mean
	int meanint = (a + b) / 2;
	return meanint;
    }
    public static double mean(double a, double b) {  //also finds the mean but this time the parameters can be doubles
	double meandoub = (a + b)/ 2.0;
	return meandoub;
    }
    public static int max(int a, int b) {  //finds and returns the integer with the higher value
	int maxint;
	if (a >= b){  //if they're equal then you can just print any of the parameters, I chose a
	    maxint = a;
	    return maxint;
	}
	else {
	    maxint = b;
	    return maxint;
	}
    }
    public static double max(double a, double b){ //does the same thing as max with integers but this time with doubles
	double maxdoub;
	if (a >= b){
	    maxdoub = a;
	    return maxdoub;
	}
	else {
	    maxdoub = b;
	    return maxdoub;
	}
    }
    public static int geoMean(int a, int b){  //finds the geoMean (the square root of the product of the parameters)
	int geoMeanint = (int) Math.sqrt(a * b);  //because java won't let you lose precision, you have to force turning what could be a double into an int
        return geoMeanint;
    }
    public static double geoMean(double a, double b){ //finds geoMean but you don't have to worry about turning the final result into an integer because it will be a double this time
	double geoMeandoub = Math.sqrt(a * b);
        return geoMeandoub;
    }
    public static void main(String[] args){  //tests and prints the result of the methods
	System.out.println("\nYour Stats Data: \n===========================");
	System.out.println("Int Mean: " + Stats.mean(8,10)); //should be 9
	System.out.println("Double Mean: " + Stats.mean(8.0,10.0)); // should be 9.0
	System.out.println("Int Max: " + Stats.max(5,10)); //should be 10
	System.out.println("Double Max: " + Stats.max(5.0,10.0)); //should be 10.0
	System.out.println("Int geoMean: " + Stats.geoMean(50,2)); //should be 10
	System.out.println("Double geoMean: " + Stats.geoMean(50.0,2.0)); //should be 10.0
    } 
	  
	
} //end of class Stats
