/*Alexia Leong
  APCS1 pd2
  HW37 -- Be More Rational
  2017-11-20 */

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
	String output = "";
	output += _numerator;
	output += "/";
	output +=  _denominator;
	return output; 
    }
    //returns floating point approximation of number
    public double floatValue(){
	return (double)_numerator/_denominator;
    }
    //modifies this object by multipling it by rational parameter
    public void multiply(Rational a){
	_numerator *= a._numerator;
	_denominator *= a._denominator;
    }
    //same thing as multiply but with division
    public void divide(Rational a){
	if (a._numerator != 0){
	    _numerator /= a._numerator;
	    _denominator /= a._denominator;
	}
	else{
	    System.out.println("Can't divide by 0");
	}
    }
    //from hw19 a static gcd method with 2 int parameters
    public static int gcd ( int a, int b){ //from forum
        if (a % b == 0) return b;
        return gcd( b, a%b);
    }
    //addition method
    public void add(Rational r){ //adds param to current rational number object
	if (_denominator == r._denominator)  _numerator += r._numerator;
	else{
	    int place = _denominator*r._denominator;
	    _numerator = _numerator*(place/_denominator) + r._numerator*(place/r._denominator);
	    _denominator = place;
	}
    }
    public void subtract(Rational r){ //subtracts from current rational number object
	if (_denominator == r._denominator)    _numerator -= r._numerator;
	else{
	    int place = _denominator*r._denominator;
	    _numerator = _numerator*(place/_denominator) - r._numerator*(place/r._denominator);
	    _denominator = place;
	}
    }
    public int gcd(){ //returns gcd of num and den of this rational
	if(_numerator % _denominator == 0)    return _denominator;
	return gcd(_denominator, _numerator%_denominator);
    }
    public void reduce(){ //reduces this rational to lowest terms
	int divisor = gcd(); //need this bc gcd() will change after num changes
	_numerator /= divisor;
	_denominator /= divisor;
    }
    public int compareTo(Rational r){ //compares param and current rational object
	if (this.floatValue() == r.floatValue())  return 0; 
	else if(this.floatValue() > r.floatValue()) return 1;
	else return -1;
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
	//for testing float value
	System.out.println("r as a double is " + r.floatValue()); //2/3 as a double is .6666..
	System.out.println("s as a double is " + s.floatValue()); //1/2 as a double is .5
	//testing gcd
	System.out.println("gcd of 18 and 24 is " + gcd(18,24)); //should be 6
	System.out.println("gcd of 100 and 100 is " + gcd(100,100)); //should be -2
	Rational q = new Rational(2,3); //Stores the rational number 2/3
	Rational w = new Rational(1,2); //Stores the rational number 1/2
	Rational t = new Rational(4,18); //Stores the rational number 4/18
	//testing add
	q.add(w);  //Adds q to w, changes q to 7/6.  w remains 1/2
	System.out.println("After adding q is " + q);
	w.add(t); //changes w to 26/36, t remains
	System.out.println("After adding w is " + w);
	//testing subtract
	w.subtract(t);//changes w back to 1/2 or a multiple of it
	System.out.println("After subtracting w is " + w);
	System.out.println("gcd of w is " + w.gcd());
	//testing reduce
	w.reduce();//reduces w to 1/2 from 324/648
	System.out.println("Reduced w is " + w);
	//testing compareTo
	Rational z = new Rational(4,5);
	System.out.println("Comparing w and 4/5 gives you " + w.compareTo(z)); //-1
	Rational e = new Rational(4,8);
	System.out.println("Comparing w and 4/8 gives you " + w.compareTo(e)); //0
    }
}
