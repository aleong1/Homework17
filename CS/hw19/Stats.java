/*Team Now in Row 3 - Alexia Leong and Daniel Gelfand
  APCS1 pd<2>
  HW19 -- gcd 3 ways
  <2017>-<10>-<18>*/   

public class Stats  //at first it's just the stats class we wrote fow hw13
{
    /*
      returns mean of two integers
      pre-condition: two inetgers are given
    
    */
    public static int mean(int a, int b)
    {
	return (a+b)/2;
    }
    /*
      returns mean of two doubles
      pre-condition: two doubles are given
     
    */
    public static double mean(double a, double b)
    {
	return (a+b)/2;
    }   

    /*returns max of two integers
      pre-condition: two integers are given
     
    */
    public static int max(int a, int b)
    {
	if(a > b)
	    {
		return a;
	    }
	else
	    {
		return b;
	    }
    }       
    /*returns max of two doubles
      pre-condition: two doubles are given
     
    */
    public static double max(double a, double b)
    {
	if(a>b)
	    {
		return a;
	    }
	else
	    {
		return b;
	    }
    }    
    
    /*pre-condition: three integers are given
      returns max of the three integers */
    public static int max(int a, int b, int c)
    {
	return max(max(a,b),c);
    }    
    
    /*pre-condition: three doubles are given
      returns max of three doubles*/
    public static double max(double a, double b, double c)
    {
	return max(max(a,b),c);
    }   
    
    /*pre-condition: three inetegers are given
      returns geometric mean of the three integers*/
    public static int geoMean(int a,int b, int c)
    {       
	return (int) Math.pow(a*b*c,(float) 1/3);
    }
        
    /*pre-condition: three doubles are given
      returns geometric mean of the three doubles*/
    public static double geoMean(double a, double b, double c)
    {    
	return Math.pow(a*b*c,(float) 1/3);
    }
    
    /*returns geometric mean of two integers
      pre-condition: two integers are given
     
    */
    public static int geoMean(int a, int b)
    {
	return (int) Math.sqrt(a*b);
    }   
    
    /*returns geometric mean of two doubles
      pre-condition: two doubles are given
        */
    public static double geoMean(double a, double b)
    {
	return Math.sqrt(a*b);
    }
    public static int min(int a, int b){
	if(a< b){
	    return a;
	}
	else{
	    return b;
	}
    }
    
    public static int gcd(int a, int b) {  //brute force approach where we begin with the gcd at one and then add one to the gcd testing until we find the greatest gdc
	int ctr = 1;
	int placeholder = 0;
	while (ctr <= min(a,b)){
	    if (a % ctr == 0 && b % ctr == 0){
		placeholder = ctr;  //placeholder for the most current gcd
		ctr += 1;
	    }
	    else {
		ctr += 1;
		//System.out.println(ctr);
	    }
	}
	return placeholder;
    }

    /* For Euclid's Algorithm is just first, see if the smaller input is the gcd, and if it is the smaller input would be returned. But if that's false then we would continue to subtract the smaller input from that bigger input with different parameters, the difference of the params and the smaller parameter. Continue until the remainder is 0.  */
   
    public static int gcdER( int a, int b ){  //recursive approach
	if (max(a,b) % min(a,b) == 0)
	    {
		return min(a,b);
	    }
	else if (a == 0 || b ==0){
	    return max(a,b);
	}
	else{
	    return gcdER(max(a,b)-min(a,b),min(a,b));  //new arguments is the min and the difference of the greater param - the other param
	}
    }

    public static int gcdEW(int a, int b){ //while loop approach
	int diff = 0;
        int subtractedNum = 0;
	if (max(a,b) % min(a,b) == 0){  //if the smallest int is the gcd
	    return min(a,b );
	}
	else{
	    while(min(a,b) != 0)
		{                 
		    diff = max(a,b) - min(a,b);
		    b = diff;
                    subtractedNum = min(a,b);
		    a = subtractedNum;

		}
	    return max(a,b);  //params for this is also just the difference of the params and the smaller of the params
	}
    }
    public static void main(String[] args){
	System.out.println(gcdER(10,4)); //Expecting 2
	System.out.println(gcdER(45,15)); // Expecting 15
	System.out.println(gcd(10,4)); //Expecting 2
	System.out.println(gcd(45,15)); // Expecting 15
	System.out.println(gcd(10,4)); //Expecting 2
	System.out.println(gcdEW(45,15));//Expecting 15
       }
}
