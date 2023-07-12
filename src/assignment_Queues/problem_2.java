package assignment_Queues;

//Implement a program to update a given queue of alphabets such that the bottom three elements are removed from bottom and placed on top with their order maintained.
// Implement the logic inside updateStack() method.

import java.util.ArrayDeque;
import java.util.Deque;
public class problem_2 {
    public static Deque<Character> updateStack(Deque<Character> inputStack) {
        Deque<Character> z=new ArrayDeque<>();

        if (inputStack.size()<3){
            System.out.println("Add more than 3 elements.");
        }


        // Remove the bottom three elements and enqueue them into the temporary queue
        for (int i = 0; i < 2; i++) {
            z.add(inputStack.poll());
        }

        // Enqueue the elements from the temporary queue back into the original queue while maintaining their order
        while(!z.isEmpty()){
            inputStack.add(z.poll());
        }
        return  inputStack;
    }

    public static void main(String[] args) {

        Deque<Character> inputStack = new ArrayDeque<Character>();
        inputStack.push('E');
        inputStack.push('D');
        inputStack.push('C');
        inputStack.push('B');
        inputStack.push('A');
        inputStack.push('Q');


        System.out.println(inputStack);

        Deque<Character> resultStack = updateStack(inputStack);

        System.out.println("The alphabets in updated stack are:");
        for(Character alphabet: resultStack)
            System.out.println(alphabet);
    }
}
