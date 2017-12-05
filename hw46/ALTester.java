/*Alexia Leong
  APCS1 pd2
  HW46 -- Al<B> Sorted!
  2017-12-04 */

import java.util.ArrayList;

public class ALTester{
    
    public static ArrayList<Comparable> populate(ArrayList<Comparable> d){ //makes an ArrayList with 23 ints
	for(int i = 0; i < 23; i++){
	    int b = (int) (Math.random() * 100);
	    d.add(b);
	}
	return d;
    }

    public static boolean order(ArrayList<Comparable> z){
	int i = 0;
	boolean c = true;
	while(i < (z.size())-1){ //if the numbers are in ascending order
	    if((z.get(i)).compareTo(z.get(i+1)) > 0 || (z.get(i)).compareTo(z.get(i+1)) == 0  ){
		i += 1;
	    }
	    else{
		c = false;
		break;
	    }
	}
	while(i < (z.size())-1){ //if the integers are in descending order
	    if((z.get(i)).compareTo(z.get(i+1)) < 0 || (z.get(i)).compareTo(z.get(i+1)) == 0 ){
		i += 1;
	    }
	    else{
		c = false;
		break;
	    }
	}
	return c;	      
    }
	
    public static void main(String[] args){
	ArrayList<Comparable> foo = new ArrayList<Comparable>();
	ArrayList<Comparable> w = populate(foo);
	System.out.println("Current array is:\n" + w);
	System.out.println("Is the array sorted in ascending or descending order? " + order(w));

    }

}
