/* Find Design - Alexia Leong and Fiona Cai
APCS2 pd1
HW46 -- Arrr, There Be Priorities Here Matey
2018-05-10 */

import java.util.ArrayList;

public class ArrayPriorityQueue<String> implements PriorityQueue<String> {
  //instance vars
  private ArrayList<String> _arrPQ;

  public ArrayPriorityQueue(){
    _arrPQ = new ArrayList<String>();
  }

  public void add(String x){     //O(1)
    _arrPQ.add(x);   //adds to the end of ArrayList arrPQ
  }
  public boolean isEmpty(){    //O(1)
    return _arrPQ.size() == 0;
  }
  public String peekMin(){    //O(n)
    String min = _arrPQ.get(0);
    for(int i = 1; i < _arrPQ.size();i++){
      String str = _arrPQ.get(i);
      if(str.compareTo(min) < 0 ){
        min = str;
      }
    }
    return min;
  }

  public String removeMin(){     //O(n)
    String min = peekMin();
    _arrPQ.remove(min);
  }

  public static void main(String args[]) {
    //Tests
    ArrayPriorityQueue<String> test = new ArrayPriorityQueue<String>();
    System.out.println(test.isEmpty()); //TRUE
    test.add("hi");
    test.add("ahmed");
    test.add("can't");
    test.add("make");
    test.add("wordsearchpuzzles");

    test.peekMin(); //ahmed
    test.removeMin(); //removes ahmed
    while(!test.isEmpty()){
      test.removeMin();
    }
    System.out.println(test); //null
  }
}
