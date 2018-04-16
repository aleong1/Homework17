//Team VERY COLD - ALexia Leong, Johnny Wong

import java.util.ArrayList; 

public class ALQueue<T> implements Queue<T>{

    //inst vars
    private ArrayList<T> _queue;
    private int _size;

    //constructor
    public ALQueue(){
	_queue = new ArrayList<T>();
	_size = 0;
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue(){
	_size--;
	return _queue.remove(_size);
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue( T x ){
	//find method to add to front and push down
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty(){
	return _size == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront(){
	return _queue.get(_size - 1);
    }

}
