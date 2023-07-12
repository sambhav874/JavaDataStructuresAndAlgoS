package Stacks;

import java.util.Scanner;
import java.util.Stack;

//Stack is a LIFO concept data structure.
//LIFO stands for Last In First Out which basically means that to access the first element we have to go through the last element.
//We can insert the element anytime but only the most recent data can be accessed or removed.
//A simple example is a 3-levelled tiffin box where to access the bottom layer we have to remove the uppermost layers of the tiffin.
public class Stack1 {
    public static void main(String args[]){
        Stack<String> stack = new Stack<String>();
        stack.add("Hi");
        stack.add("Sambhav");
        System.out.println(stack);

        Stack<Integer> stack1=new Stack<Integer>();
        stack1.add(17);
        stack1.add(87);
        stack1.add(24);
        stack1.add(56);
        System.out.println(stack1);

        Stack<Integer> stack3=new Stack<Integer>();
        stack3.push(18);
        stack3.push(82);
        stack3.push(47);
        stack3.push(63);
        System.out.println(stack3);

        Scanner sc=new Scanner(System.in);
        Stack<Integer> stack2=new Stack<Integer>();
        int numInputs=sc.nextInt();
        for(int i=0;i<numInputs;i++){
            int input=sc.nextInt();
            stack2.add(input);
        }
        stack2.add(numInputs,19);
        System.out.println(stack2);



    }





}
