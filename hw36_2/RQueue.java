/* Team Kendrick's Pulitzer -- Alexia Leong and Maggie Zhao
APCS2 pd1
HW36 -- Now Let’s Consider You Lot at Fake Terry’s
2018-04-18 */

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private static int _size;


  // default constructor creates an empty queue
  public RQueue()
	{
    _front = null;  //start off as null
    _end = null;
    _size = 0;
	}//end default constructor


  public void enqueue( T enQVal )
  {
    LLNode<T> newNode = new LLNode<T>(enQVal , null);
    if (isEmpty()){  //is empty, both front and end will point to the same node
       _end = newNode;
       _front = newNode;
     }
     else{
       _end.setNext(newNode);  //next node is the new one
       _end = newNode;
     }
   _size++;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue()
  {
    if(isEmpty()) return null;
  LLNode<T> tmp  = _front;  //hold value your gonna remove
  _front = _front.getNext();   //move it down
  _size--;
  sample();  //shuffle here
    return tmp.getValue();  //old front
  }//end dequeue()


  public T peekFront()
  {
    if (isEmpty()) return null;
    return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:  Find a random number in between 0 and the # of nodes but -1
   *Then, while less than the random int, take the front off and move it to the end to shuffleee
   ******************************************/
  public void sample ()
  {
    int index = (int) (Math.random() * _size) - 1;
    for (int i = 0; i < index; i++){
      enqueue(dequeue());  //ty qaf
    }
}


  public boolean isEmpty()
  {
    return _size == 0;
  } //O(1)


    // print each node, separated by spaces
  public String toString()
  {
    String rtn = "";
    LLNode temp = _front;
    while( temp != _end ) {
      rtn += temp.getValue() + "  ";
      temp = temp.getNext();
    }
    rtn += temp.getValue() + "  ";
    temp = temp.getNext();
    return rtn;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {

      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing...");
      PirateQueue.enqueue("Dread");  // front
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");  //end

      System.out.println("\nnow testing toString()...");
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing...");
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      System.out.println("\nnow dequeuing fr empty queue...");
      System.out.println( PirateQueue.dequeue() );

      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/

  }//end main

}//end class RQueue
