/* Alexia Leong
APCS2 pd1
HW32 -- Leon Leonwood Stack
2018-04-12 */

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

    //instance var
    private LinkedList<PANCAKE> _wow; 

    //constructor
    public LLStack(){
	_wow = new LinkedList<PANCAKE>();  //instantiate a new LinkedList
    }
    
    public boolean isEmpty(){
        return _wow.size() == 0;  
    }

    public PANCAKE peek(){
	if(isEmpty()) return null;  //can't peek what's not there
	return _wow.getLast();   //last / top of the stack
    }

    public PANCAKE pop(){
	if(isEmpty()) return null;  
	return _wow.removeLast();  //last / top of stack
    }

    public void push(PANCAKE x){
	_wow.addLast(x);  //add to the top of stack
    }

}
