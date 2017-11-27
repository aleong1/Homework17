/*Alexia Leong
   APCS1 pd2
   HW36 -- Be Rational
   2017-11-17 */

public class Rational{
    //instance vars
    private int _numerator;
    private int _denominator;
    //constructors
    public Rational(){
	_numerator = 0;
	_denominator = 1;
    }
    public Rational(int num, int den){
	this(); //set rational num as 0/1 at first
        if (den == 0){
	    System.out.println("Invalid denominator, set it to an integer other than 0.");
	    System.out.println("Setting the rational number to 0/1");
	}
	else{   // otherwise it will be the new rational number
	    _numerator = num;
	    _denominator = den;
	}
    }
    //methods
    //returns string representation of the rational number
    public String toString(){ 
	String output = "Rational Number is: ";
	output += _numerator;
	output += "/";
	output +=  _denominator;
	return output; 
    }
    //returns floating point approximation of number
    public double floatValue(){
	double floated;
	floated = (double) _numerator;
	floated /= (double) _denominator;
	return floated;
    }
    //modifies this object by multipling it by rational parameter
    public void multiply(Rational a){
	_numerator *= a._numerator;
	_denominator *= a._denominator;
    }
    //same thing as multiply but with division
     public void divide(Rational a){
	_numerator /= a._numerator;
	_denominator /= a._denominator;
    }
    
    public static void main(String[] args){
	Rational r = new Rational(2,3); //Stores rational number 2/3
	Rational s = new Rational(1,2); //Stores rational number 1/2
	r.multiply(s); //Multiplies r by s, changes r to 2/6.  s remains 1/2
	System.out.println(r);
	System.out.println(s);
	r.divide(s);//divides r by s, changed r to 2/3. s stays 1/2
	System.out.println(r);
	System.out.println(s);
	System.out.println("r as a double is " + r.floatValue()); //2/3 as a double is .6666..
	System.out.println("s as a double is " + s.floatValue()); //1/2 as a double is .5
    }
}
