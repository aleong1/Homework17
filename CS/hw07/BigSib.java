/* Alexia Leong
APCS1 pd2
HW7 -- The Origins of a BigSib
2017-09-26 */

public class BigSib{
    public String helloMsg;
    public BigSib() {
	helloMsg = "Hey there ";
    }
    public BigSib( String param) {
      	helloMsg = param;
	helloMsg += " ";
    }
    public String greet(String nextMsg){
	helloMsg += nextMsg;
        return helloMsg;
    }
    
}

