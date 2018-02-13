/* Team scipmylo  -- Alexia Leong and Kevin Lin
APCS2 pd1
HW07 -- A Man, A Plan, A Canal: Panama!
2018-02-14 */



public class Resrever{

    //O(n) runtime:
    public static String nReverse(String a){
	int last = a.length() - 1;  //starting from the end of the string, keep on adding the last letter to what's being returned
	if(a.length() == 1) return a;
	else return a.substring(last) + nReverse(a.substring(0,last));
    }
    //O(logn) runtime: 
    public static String lgReverse(String b){  //you keep on dividing the string in half and reversing if the half is in the beginning half or the end half
	int mid = b.length()/2;
	if(b.length() == 1) return b;
	else return lgReverse(b.substring(mid)) + lgReverse(b.substring(0,mid));
    }

	public static void main(String[] args){
	    System.out.println("stressed:");
	    System.out.println("O(n) Runtime: " + nReverse("stressed"));
	    System.out.println("O(logn) Runtime: " + lgReverse("stressed"));
	    System.out.println("\nOlympics:");
	    System.out.println("O(n) Runtime: " + nReverse("Olympics"));
	    System.out.println("O(logn) Runtime: " + lgReverse("Olympics"));
	    
	}
	    
   

}
