package implementation_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class deque_changeSmallest {

    public static Deque<Integer> changeSmallest(Deque<Integer> queue) {


        if (queue.isEmpty()){
            System.out.println("Queue is Empty.");
        }
        int minVal = queue.peek(); // Assume the first element as the minimum value

        // finding the smallest element by iterating each element and then comparing it to each of the minimum value.
        for (int num : queue) {
            if (num < minVal) {
                minVal = num;
            }
        }
        int flag=0;// this flag will be used to check and count the total times the minimum element is present.
        for(int n:queue){
            //this loop will work on the flag functionality explained above.
            if(n==minVal){
                queue.remove(n);
                flag++;
            }
        }
        // the minimum value will be added for each time the element is deleted from the queue.
        for(int k=0;k<flag;k++){
            queue.add(minVal);
        }

        return queue;
    }


    public static void main(String[] args){
        Deque<Integer> inputStack=new ArrayDeque<>();

        inputStack.push(10);
        inputStack.push(8);
        inputStack.push(5);
        inputStack.push(12);
        inputStack.push(5);


    Deque<Integer> updatedStack = changeSmallest(inputStack);

        System.out.println("Stack After Modification:");
        for (Integer value : updatedStack)
            System.out.println(value);
    }
}
