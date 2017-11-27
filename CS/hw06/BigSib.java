/* Alexia Leong
APCS1 pd2
HW6 -- BigSibs.java Individuality and No More Radio Fuzz
2017-09-25 */

public class BigSib{
    private String helloMsg;
    public void setHelloMsg(String newMsg){
	helloMsg = newMsg;
    }
    public static void main( String[] args){
    }
    public String greet(String nextMsg){
	helloMsg += nextMsg;
        return helloMsg;
    }
    
}

