/* Alexia Leong
   APCS1 pd02
   HW13 -- May ah Hahv S'maur, Please?
   2017-10-08 */

public class StatsDriver{
    public static void main(String[] args){  //tests and prints the result of the methods
	Stats data = new Stats();
	System.out.println("\nYour Stats Data: \n===========================");
	System.out.println("Int Mean: " + data.mean(8,10)); //should be 9
	System.out.println("Double Mean: " + data.mean(8.0,10.0)); // should be 9.0
	System.out.println("Int Max: " + data.max(5,10)); //should be 10	
	System.out.println("Int max with three params: " + data.max(2, 45, 5)); //should be 45
	System.out.println("Double Max: " + data.max(5.0,10.0)); //should be 10.0
	System.out.println("Double max with three params: " + data.max(2.0, 45.0, 5.0)); //should be 45.0
	System.out.println("Int geoMean: " + data.geoMean(50,2)); //should be 10
	System.out.println("Int geoMean with three params: " + data.geoMean(5,20,23)); //should be around 13
	System.out.println("Double geoMean: " + data.geoMean(50.0,2.0)); //should be 10.0
	System.out.println("Double geoMean with three params: " + data.geoMean(5.0,18.92,2.3)); //should be 6.014
	//extra test cases:
	System.out.println("|||||| Extra Test Cases ||||||");
	System.out.println("Test Int Mean with negs: " + data.mean(-8,10)); //should be 1
	System.out.println("Test Int geoMean with negs: " + data.geoMean(-50,2)); //should be error bc the negative is in the sqrt but returns 0
	System.out.println("Test Int geoMean #2: " + data.geoMean(-60,2)); //should be 0 bc param is negative
	System.out.println("Test Int geoMean #3: " + data.geoMean(-60,-2)); //should be 10 bc product is positive
	System.out.println("Test Int geoMean #4: " + data.geoMean(-60,-2,-18)); //should be 0 bc param product is negative
	
    } 
}
