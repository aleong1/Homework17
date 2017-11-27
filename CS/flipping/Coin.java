/* Alexia Leong
   APCS1 pd2
   HW16 --Get It While You Can
   2017-10-15 */   

public class Coin{
    private double value; //monetary worth
    private String upFace; //what face is up (heads/tails)
    private String name; //what type of coin it is
    private int flipCtr; //# of times coin has been flipped
    private int headsCtr; //# of times heads has been flipped
    private int tailsCtr; //# of times tails has been flipped
    private double bias; //deciding likelihood of heads or tails 

    public Coin() {  //default constructor to set instance vars
	value = 0.10;
	upFace = "heads";
	name = "dime";
	flipCtr = 0;
	headsCtr = 0;
	tailsCtr = 0;
	bias = 0.5;
    }

    public Coin(String newname) { //1st overloaded, just assigns coin as a type
	this();
	name = newname;
	assignvalue();
    }

    public Coin(String newname, String position) { //2nd overloaded, gives string a name and value
        this(newname);
	upFace = position;
    }
    public String flip() { //flip() method to decide if heads or tails
	bias = Math.random(); //uses Math.random() to give a random value to bias that will determing next flip
       	if (bias <= 0.5){
	    upFace = "tails";
	    flipCtr += 1;
	    tailsCtr += 1;
	}
	else {
	    upFace = "heads";
	    flipCtr += 1;
	    headsCtr += 1;
	}
	return upFace;
    }
    public String toString() {   //prints out current denomination and face
	String info;
       	info = "\nDenomination: " + name;
        info += "\nPosition: " +  upFace;
	return info;
    }
    public boolean equals(Coin other) { //overrides equals method to compare 2 coins' faces
	if (upFace == other.upFace) {
	    return true;
	}
	else {
	    return false;
	}
    }
    public void assignvalue() { //assigns corresponding value to coin
	if (upFace == "quarter") {
	    value = 0.25;
	}
	if (upFace == "dime") {
	    value = 0.10;
	}
	if (upFace == "nickel") {
	    value = 0.05;
	}
	if (upFace == "penny") {
	    value = 0.01;
	}
	else {
	    value = 1.0;
	}
    }
}

