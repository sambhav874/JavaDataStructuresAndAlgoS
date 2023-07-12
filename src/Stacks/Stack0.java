package Stacks;

import java.util.Stack;

//Stack is a LIFO concept data structure.
//LIFO stands for Last In First Out which basically means that to access the first element we have to go through the last element.
//We can insert the element anytime but only the most recent data can be accessed or removed.
//A simple example is a 3-levelled tiffin box where to access the bottom layer we have to remove the uppermost layers of the tiffin.
public class Stack0 {
    public static void main(String[] args){
        Stack<Integer> st1= new Stack<Integer>();
        st1.add(19);
        st1.push(89);
        st1.push(92);
        st1.add(3,99);
        st1.add(1,1);
        System.out.println(st1);
        System.out.println(st1.indexOf(92));

        System.out.println(st1.peek());
        System.out.println(st1.pop());

        //To insert elements to a stack we use two methods of stacks i.e. .add and .push.
        //Add and push are somehow similar, the only difference is that in add method we could also specify the index at which the element is to be inserted.
        //Remember if we are using push and add in a function, we will see a error when we use add method before push method .
        //So to use add function we must remember to use it after we have called the push method.
        //Peek: returns the top most element of the stack
        //Push: adds an element to the top of the stack
        //Pop: removes an element from the top of the stack
    }


}
