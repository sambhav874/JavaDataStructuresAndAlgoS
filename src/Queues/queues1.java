package Queues;

class queues1 {
    //All of us would have waited in front of an ATM waiting to withdraw cash.
    //We all maintain a queue in front of the ATM waiting for our turn to withdraw cash.
    //By this example you could observe that queue is just the opposite of stacks as it follows the concept of FIFO.
    //FIFO stands for First In First Out. This means that the element that is inserted first can be accessed first.


    //Can you directly go to the front and withdraw money when there are people in front of you in the queue?
    //No, an order has to be maintained to enter and exit from the queue.
    //The first person in the queue has to withdraw money, followed by the next person and so on. Those who wish to withdraw money have to join the end of the queue.

    //Other examples of queues are:
    //People standing in queue to check-in at airport
    //Queue in front of an amusement park gate

    //A queue is a linear data structure which means that the data is connected to each other sequentially.

    private int rear;
    private int maxSize;
    private int front;

    // rear represents the index position of the last element of the queue.
    // maxSize is the maximum number of elements that can be stored in the queue.
    // front represents the index position of the first element of the queue.
    private Integer[] arr0;

    queues1(int maxSize){
        this.rear=-1;
        //rear have the index -1 when the queue is created and it keeps changing as the elements keep on adding.
        this.front=0;
        // front will always be 0
        this.maxSize=maxSize;
        this.arr0=new Integer[maxSize];
    }
    //En-queue: adds an element to the end of the queue
    //
    //De-queue: removes an element from the front of the queue. The items are removed in the same order as they were added unlike Stack.

    public boolean isFull() {
        if (this.rear == this.maxSize - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        if(front>rear){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean enqueue(Integer name){
        if (isFull()){
            return false;
        }
        else {
            arr0[++rear]=name;
            return true;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int data = arr0[this.front];
            arr0[front++] = Integer.MIN_VALUE;
            return data;
        }
    }

    public void display(){
        System.out.print(" [ ");
        for(int i=front;i<=rear;i++){
            System.out.print(arr0[i]+" ");
        }
        System.out.print(" ] ");
    }

    public int getMaxSize(){
        return maxSize;
    }

    public static queues1[] splitQueue(queues1 queueOne){

        queues1[] allQueue=new queues1[2];

        queues1 evenQueue=new queues1(queueOne.getMaxSize());
        queues1 oddQueue=new queues1(queueOne.getMaxSize());

        while(!queueOne.isEmpty()) {
            int value = queueOne.dequeue();

            if (value % 2 == 0) {
                System.out.println(value + " is even.");
                evenQueue.enqueue(value);
            } else {
                System.out.println(value + " is odd.");
                oddQueue.enqueue(value);
            }
        }
        allQueue[0]=evenQueue;
        allQueue[1]=oddQueue;

            return allQueue;

    }

    public queues1 findEvenlyDivisbleNumber(queues1 queue) {
        queues1 queueForEven=new queues1(queue.getMaxSize());
        for (int i = front; i <= rear; i++) {
            if ((arr0[i] % 2 == 0)&&(arr0[i] % 3 == 0)&&(arr0[i] % 4 == 0)&&(arr0[i] % 5 == 0)&&(arr0[i] % 6 == 0)&&(arr0[i] % 7 == 0)&&(arr0[i] % 8 == 0)&&(arr0[i] % 9 == 0)&&(arr0[i] % 10 == 0)) {

                System.out.println(arr0[i]);
                queueForEven.enqueue(arr0[i]);
            }

        }
        return queueForEven;
    }


static class Tester{
    public static void main(String[] args) {


        queues1 queu2=new queues1(7);
        queu2.enqueue(17);
        queu2.enqueue(91);
        queu2.enqueue(6);
        queu2.enqueue(11);
        queu2.enqueue(23);
        queu2.enqueue(78);
        queu2.enqueue(88);

        queu2.display();
        System.out.println();

        queues1[] queueArray = splitQueue(queu2);

        System.out.println("Elements in the queue of odd numbers");
        queueArray[0].display();

        System.out.println("\nElements in the queue of even numbers");
        queueArray[1].display();
        System.out.println();

        System.out.println("The evenly divisible problem.");
        queues1 q3 = new queues1(7);
        q3.enqueue(13983);
        q3.enqueue(10080);
        q3.enqueue(7113);
        q3.enqueue(2520);
        q3.enqueue(2500);

        queues1 outputQueue = q3.findEvenlyDivisbleNumber(q3);

        System.out.println("Evenly divisible numbers");
        outputQueue.display();

    }

}}
//Queue can be used when elements don’t have to be processed immediately, but on the first come first serve basis.
//
//This property of Queue makes it useful in different kinds of scenarios like:
//
//Network Printer
//
//Shared resource usage (CPU, memory access, etc.)
//
//Handling calls in call centers
