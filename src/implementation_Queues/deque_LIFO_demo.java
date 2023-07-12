package implementation_Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class deque_LIFO_demo {
    public static Deque<Integer> queueFunction(Deque<Integer> stack) {
        Deque<Integer> outQueue = new ArrayDeque<Integer>();
        Deque<Integer> tempQueue = new ArrayDeque<Integer>();

        while (stack.peek()!=null) {
            Integer value = stack.pop();
            if (value%2 == 0)
                outQueue.add(value);
            else
                tempQueue.add(value);
        }

        Integer temp = 0;
        while(tempQueue.peek()!=null) {
            temp += tempQueue.poll();
            outQueue.add(temp);
        }
        return outQueue;
    }
    public static int calculate(int n) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        while (n > 0) {
            stack.push(n%10);
            n=n/10;
        }
        int result = 0;
        while (stack.peek()!=null) {
            result += stack.pop();
        }
        return result;
    }
    public static void main(String[] args){
        Deque<Integer> stack=new ArrayDeque<Integer>();
        stack.push(2);
        stack.push(1);
        stack.push(9);
        stack.push(6);
        stack.push(7);

        System.out.println("Numbers in stack - After addition of 5 values");
        for (Integer val : stack) {
            System.out.println(val);
        }



        //Uncomment the below code and observe the output
        //System.out.println("Trying to remove the element from the top of the stack using pop() when stack is empty - "+stack.pop());	// throws NoSuchElementException since stack is empty

        System.out.println(queueFunction(stack));
        System.out.println(stack);
        System.out.println(calculate(1020));
    }
}
