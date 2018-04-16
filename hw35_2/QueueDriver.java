//Colin Hosking
//APCS02 pd08
//HW34 -- The English Do Not Wait In Line
//2018-04-16

public class QueueDriver{
    
    public static void main(String args[]){
        ALQueue<String> test = new ALQueue<String>();
        
        System.out.println(test.isEmpty()); //TRUE
        test.enqueue("apple");
        test.enqueue("brick");
        test.enqueue("sky");
        
        System.out.println(test.isEmpty()); //FALSE
        
        System.out.println(test.peekFront()); //apple
        System.out.println(test.dequeue()); //apple
        
        System.out.println(test.peekFront()); //brick
        System.out.println(test.dequeue()); //brick
        
        System.out.println(test.peekFront()); //sky
        System.out.println(test.dequeue()); //sky

        System.out.println(test.isEmpty()); //TRUE
        System.out.println(test.dequeue()); //null

    }
}
