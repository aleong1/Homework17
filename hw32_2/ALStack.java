/* Alexia Leong
APCS2 pd1
HW32 -- Leon Leonwood Stack
2018-04-12 */

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE>{
    private ArrayList<PANCAKE> _wowza;

    public ALStack(){
	_wowza = new ArrayList<PANCAKE>();
    }

    public boolean isEmpty(){
	return _wowza.isEmpty();
    }

    public PANCAKE peek(){
	if(isEmpty()) return null;
	return _wowza.get(_wowza.size()-1);
    }

    public PANCAKE pop(){
	if(isEmpty()) return null;
	return _wowza.remove(_wowza.size()-1);
    }

    public void push(PANCAKE x){
	_wowza.add(x);
    }
    
    

}//end class ALStack
