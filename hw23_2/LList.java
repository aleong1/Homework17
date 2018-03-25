//Hasif Ahmed, Alexia Leong (TEAM: It’s almost break)
//APCS2 pd1
//HW #23: Give and Take
//2018-03-23

public class LList implements List{
  private LLNode first; //instance variable, original node

  public LList(LLNode input){ //overloaded constructor
    first = input; //sets the first
  }

  public boolean add(String x){ //adding cargos
    LLNode finals = new LLNode(); //new LLNode
    finals.setCargo(x); //new LLNode takes x as its cargo
    finals.setNext(first); //new LLNode takes first as its CDR
    first = finals; //first copies finals
    return true; //boolean
  }

  public void add(int i, String x){
    if(i == 0){ //base case for adding at index 0
      add(x); //using add method with one parameter

      return; //exits method

    }
    int ctr = 0; //var
    LLNode temp = first; //alias node
    while( ctr < i - 1){ //while loop to get to the node before the index we are adding to
    temp = temp.getNext();
    ctr++;
    }
    LLNode added = new LLNode(x); //new node with String x
    added.setNext(temp.getNext()); //next node for new node are the nodes after the alias
    temp.setNext(added); //alias node next node is now the new node


  }

  public String remove( int index ){
    if(index == 0){ //base
      LLNode base = first; //alias node
      String returned = base.getCargo(); //string to hold the current cargo
      base = base.getNext(); //get rid of current cargo
      first = base; //original equals now "chopped" version
      return returned; //return the string
    }
    int ctr = 0; //var
    LLNode temp = first; //alias node
    while( ctr < index - 1){ //while loop to get to the node before the index we are removing from
    temp = temp.getNext(); //chop up alias node
    ctr++;
    }
    String ret = temp.getNext().getCargo(); //string to hold value of cargo at index we want to remove
    temp.setNext(temp.getNext().getNext()); //avoiding the cargo  at index
    return ret; //returning the string that held the value


  }

  public String get( int i){

    LLNode part = first; //new LLNode to reference first
    for(int x = i; x > 0; x--){ //for loop to get to the cargo we want

      part = part.getNext(); //split up the reference LLNode
    }
    return part.getCargo(); //return the cargo we want
  }

  public String set( int i, String x){

    LLNode part = first; //new LLNode to reference first
    for(int j = i; j > 0; j--){ //for loop to get to the cargo we want

      part = part.getNext();//split up the reference LLNode
    }
    return part.setCargo(x); //change the cargo to x, and return it
  }

  public int size(){
    int x = 1; //starts from one cuz of null
    LLNode part = first; //reference in new LLNode
    while(part.getNext() != null){ //Traverse until u reach the null value
      part = part.getNext(); //splut up the reference LLNode
      x += 1; //increment x
    }
    return x; //returns number of cargos in the LList
  }

  public String toString()
  {
    return first.getCargo() + " ----> " + first.getNext();
  }

  public static void main(String[] args){
    LLNode testcase = new LLNode("Day!"); //only CAR value, CDR is null
    LLNode testcase2 = new LLNode("Good", testcase);
    System.out.println(testcase2); //Return Good, Day!, null

    LList test = new LList(testcase2);
    System.out.println( test.get(1)); //return Day!
    System.out.println( test.size() + ""); //2
    test.set(1,"Night!"); //change Day! to Night!
    System.out.println(test); //Return Good, Night!, null
    test.add("A");
    test.add("Have");
    System.out.println(test);
    test.add(0,"added");
    System.out.println(test);
    test.remove(2);
    System.out.println(test);

  }


}
