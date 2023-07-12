package Heaps;

public class problem_2 {

    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};
    public static void printMaxKElements(int k) throws Heap.HeapEmptyException , Heap.HeapFullException {
        minimumHeap<Integer> m1 = new minimumHeap<>(Integer.class ,  k);

        for(int number : randomNumberArray){
            if(m1.isEmpty()){
                m1.insert(number);
            }
            else if (!m1.isFull() || m1.getHighestPriority() < number){
                if (m1.isFull()){
                    m1.removeHighestPriority();
                }
                m1.insert(number);
            }
        }
        m1.printHeapArray();
    }
    public static void main(String[] args) throws Heap.HeapEmptyException, Heap.HeapFullException {


        printMaxKElements(3);
        printMaxKElements(5);
        printMaxKElements(6);


    }
}
