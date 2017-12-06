/*Alexia Leong
  APCS1 pd2
  HW47 -- ascending 
  2017-12-05 */

import java.util.ArrayList;

public class OrderedArrayList{
    private static int _index;

    public static int min(ArrayList<Comparable> a){
	int b = (int) a.get(0);  //to find min to append
	int c = 0;
	for(int i = 0; i < (a.size()); i++ ){
	    c = (int) a.get(i);
	    if (b > c){
		b = c;
	    }
	}
	for(int i = 0; i < (a.size()); i++ ){   //finds index of min
	    if (a.get(i).compareTo(b) == 0){
		_index = i;
	    }
	}
	return b;
    }
    
       
    public static ArrayList<Comparable> orderList(ArrayList<Comparable> a){
	int d = 0;
	int r = a.size();
	ArrayList<Comparable> bye = new ArrayList<Comparable>();
	for(int i = 0; i < r; i++ ){
	    d = min(a);  //appends min every time
	    bye.add(d);
	    a.remove(_index);  
	}
	return bye;
    }
	

   
    public static void main(String[] args){

    }
    
}
	
