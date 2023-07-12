package Stacks;

import java.util.Scanner;

public class Stck {
    private int  top;
    //represents the index of the topmost element.
    private final int maxSize;
    //represents the max elements that can be stored tin the stack.
    private final int[] arr;


    Stck(int maxSize){
        this.top=-1;//top is initialized to -1 when a stack is crated.
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        if(top>=(maxSize-1)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean push(int data){
        if(isFull()){
            return false;
        }
        else {
            arr[++top]=data;
            return true;
        }
    }

    public int peek(){
        if(top<0){
            return Integer.MIN_VALUE;
            //Integer.MIN_VALUE gives the minimum possible value for an integer variable which is used for indicating that the stack is empty.
        }
        else {
            return arr[top];
        }
    }
    public void display(){
        System.out.println("The stack is being displayed.");
        System.out.print(" [ ");
        for(int index=top;index>=0;index--){
            System.out.print(" "+arr[index]+" ");
        }
        System.out.println(" ] ");
    }
    public int removeLastElem(){
        if(!isFull()){
            System.out.println("Stack is empty.");
        }
        else {
            if(top>0){
                top--;
                System.out.print(" [ ");
                for(int index=top;index>=0;index--){
                    System.out.print(" "+arr[index]+" ");
                }
                System.out.println(" ] ");

            }
            else {
                return arr[top];
            }
        }
        return 0;
    }

    public int pop(){
        if(top<0){
            return Integer.MIN_VALUE;
        }
        else {
            return arr[top--];
        }
    }
    public int orEvenOdd(){
        if(top<0){
            return Integer.MIN_VALUE;
        }
        else{
            if(arr[top]%2==0){
                String s="The top most element is even ";
                System.out.println(s);
            }
            else {
                System.out.println("The top most element is odd ");
            }
        }
        return 0;
    }
    public boolean check(){
        if(arr[top]%2==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int calculate_sum(){
        int sum=0;
        for(int index=0;index<=top;index++){
            sum=sum+arr[index];
        }
        System.out.print(sum);
        return sum;

    }



    public static void main(String[] args){

        Stck st2=new Stck(5);

        Scanner sc=new Scanner(System.in);

        for (int i=0;i<st2.maxSize;i++){

            int data= sc.nextInt();

            st2.push(data);
            System.out.println("The element is added.");

        }
        st2.display();
        System.out.println();
        System.out.println(st2.peek());
        System.out.println();
        System.out.println("The stack after pop method looks like");
        st2.removeLastElem();

        System.out.println();
        System.out.println();


        st2.display();



        System.out.println();

        if(st2.check()){
            System.out.println("The first element is even.");
        }
        else {
            System.out.println("The first element is odd");
        }

        System.out.println();
        System.out.println("The sum of the stack is");
        st2.calculate_sum();


    }
}
//There are many scenarios in real life where stack is being used.
//
//In internet web browsers, the addresses of the recently visited sites are stored in a stack. Every time you visit a new site, the address of that site is pushed to the stack of addresses. With the help of "back" button, the previous site visited is popped out.
//
//Clipboard in Windows uses two stacks to implement undo-redo (ctrl+z, ctrl+y) operations.

