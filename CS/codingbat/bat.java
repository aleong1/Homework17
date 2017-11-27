public class bat{
    /* Given a string, return a string where for every char in the original, there are two chars.
       doubleChar("The") to "TThhee" */
    public static String doubleChar(String str){
	int ctr = 0;
	String neww = "";
	while (ctr < str.length()){
	    neww += str.substring(ctr,ctr+1) + str.substring(ctr,ctr+1);
	    ctr += 1;
	}
	return neww;
    }

    public static int countHi(String str){
	if (str.length() < 2){
	    return 0;
	}
	if (str.substring(0,2).equals("hi")){
	    return 1 + countHi(str.substring(1));
	}
	else{
	    return countHi(str.substring(1));
	}
    }

    public static boolean catDog(String str){
	int length = str.length();
	int cats = 0;
	int dogs = 0;

	for (int ctr = 0; ctr < length-2; ctr += 1){
	    String ani = str.substring(ctr,ctr + 3);
	    if(ani.equals("cat")){
		cats += 1;
	    }
	    if(ani.equals("dog")){
		dogs += 1;
	    }
	}
	if (cats == dogs){
	    return true;
	}
	else{
	    return false;
	}
	
    }

  

    public static int countCode(String str){
	int total = 0;
	String first = "co";
	String end = "e";
	if (str.length() < 4){
	    return 0;
	}
	for (int ctr = 0; ctr < str.length()-3; ctr += 1){
	    String co = str.substring(ctr,ctr+2);
	    String e = str.substring(ctr+3,ctr+4);
	    if (co.equals(first) && e.equals(end)){
		total += 1;
	    }
	}
	return total;
    }

    public static boolean endOther(String a, String b){
	a = a.toLowerCase();
	int lengtha = a.length();
	b = b.toLowerCase();
	int lengthb =  b.length();

	if (lengtha > lengthb){
	    String neww = a.substring(lengtha-lengthb,lengtha);
	    if (neww.equals(b)){
		return true;
	    }
	    else{
		return false;
	    }
	}
	else{
	    String newwb = b.substring(lengthb-lengtha, lengthb);
	    if (newwb.equals(a)){
		return true;
	    }
	    else{
		return false;
	    }
	}
    }
    public static boolean xyzThere(String str){
	int lengths = str.length();
	int ctr = 0;
	String find = "xyz";
	while (ctr < lengths-2){
	    String part = str.substring(ctr, ctr + 3);
	    if(part.equals(find) && ctr == 0){
		return true;
	    }
	    else if(part.equals(find) && str.substring(ctr - 1,ctr) != "."){
		return false;
	    }
	}
	return true;
    }
	    
	
		
	public static void main(String[] args){
	System.out.println(doubleChar("the"));
	System.out.println(countHi("abc hi ho"));
	System.out.println(catDog("catdog"));
    }			   
}
    
