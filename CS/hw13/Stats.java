/* Alexia Leong
   APCS1 pd02
   HW13 -- May ah Hahv S'maur, Please?
   2017-10-08 */

public class Stats{
    
    //methods:
    public static int mean(int a, int b) {   //uses the parameters which have to be integers to find and return their mean
        return (a + b) / 2;
    }
    public static double mean(double a, double b) {  //also finds the mean but this time the parameters can be doubles
        return (a + b)/ 2.0;
    }
    public static int max(int a, int b) {  //finds and returns the integer with the higher value
        if (a >= b){  //if they're equal then you can just print any of the parameters, I chose a
	    return a;
	}
	else {
	    return b;
	}
    }
    
    public static int max(int a, int b,int c){  //uses the int max method from before to find the max of the first two parameters and then the max of that will be compared to the last parameter to find the overall max int
	if (Stats.max(a,b) > c){
	    return Stats.max(a,b);
	}
	else {
	    return c;
	}
    }

    public static double max(double a, double b){ //does the same thing as max with integers but this time with doubles
        if (a >= b){
	    return a;
	}
	else {
	    return b;
	}
    }
    public static double max(double a, double b,double c){  // also like the int max method with three parameters but uses double instead of int
	if (Stats.max(a,b) > c){
	    return Stats.max(a,b);
	}
	else {
	    return c;
	}
    }

    public static int geoMean(int a, int b){  //finds the geoMean (the square root of the product of the parameters), if a the number of negative parameters is odd, the result will always be 0
        return (int) Math.sqrt(a * b);  //because java won't let you lose precision, you have to force turning what could be a double into an int
    }
    public static int geoMean(int a, int b, int c){  // an odd number of negative params result in 0
	return (int) Math.pow(a * b * c, .33333);  // from the Java API I found out that with pow, you can use it to take the sqrt of any amount of numbers you want
    }

    public static double geoMean(double a, double b){ //finds geoMean but you don't have to worry about turning the final result into an integer because it will be a double this time
	double geoMeandoub = Math.sqrt(a * b);
	return geoMeandoub;
    }

    public static double geoMean(double a, double b, double c){
	return Math.pow(a * b * c, .33333);  // same thing as int geoMean with three parameters but this time they're doubles
    }
  
	
} //end of class Stats
