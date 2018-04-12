/* Alexia Leong
APCS2 pd1
HW32 -- Leon Leonwood Stack
2018-04-12 */

/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr 
{
public static void main( String[] args )
{
    Stack cakes = new LLStack<String>();  //or ALStack, comment out which one 
    
    //Stack cakes = new ALStack<String>();
    
    System.out.println("--------TESTING---------");
    cakes.push("Leon");    //testing push()
    cakes.push("Leonwood");
    cakes.push("or");
    cakes.push("Leong");
    cakes.push("Leongwood");
    cakes.push("haha");
    cakes.push("jokes");

    System.out.println("Is the stack empty?  " + cakes.isEmpty());  //isEmpty()
    System.out.println("Peeking: " + cakes.peek()); //peeking jokes
    System.out.println("Popping: " + cakes.pop()); //bye jokes

    //again for "haha"
    System.out.println("\nPeeking: " + cakes.peek()); //peeking haha
    System.out.println("Popping: " + cakes.pop()); //popping haha

    System.out.println("\nPopping: " + cakes.pop()); //popping Leongwood
    System.out.println("Popping: " + cakes.pop()); //popping Leong
    System.out.println("Popping: " + cakes.pop()); //popping or
    System.out.println("Popping: " + cakes.pop()); //popping Leonwood
    System.out.println("Popping: " + cakes.pop()); //popping Leon

    System.out.println("\nIs the stack empty? " + cakes.isEmpty()); //true now

    System.out.println("\nTesting on an empty stack:");
    System.out.println("Peeking: " + cakes.peek()); 
    System.out.println("Popping: " + cakes.pop()); 
}

}//end class

