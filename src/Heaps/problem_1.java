package Heaps;

public class problem_1 {

    public static int getMaximum(minimumHeap<Integer> minHeap ){
        int lastIndex = minHeap.getCount() - 1;
        int lastParent = minHeap.getParent(lastIndex);

        int firstIndex = lastParent + 1 ;

        int maxElement = minHeap.getElementbyIndex(firstIndex);
        for(int i = firstIndex ; i <= lastIndex ; i++){
            if(maxElement < minHeap.getElementbyIndex(i)){
                maxElement = minHeap.getElementbyIndex(i);
            }
        }
        return maxElement;
    }

    public static void main(String[] args) throws Heap.HeapFullException , Heap.HeapEmptyException {

        minimumHeap <Integer> m1 = new minimumHeap<>(Integer.class);
        m1.insert(9);
        m1.insert(4);
        m1.insert(17);
        m1.printHeapArray();
        m1.insert(6);
        m1.printHeapArray();

        m1.insert(100);
        m1.insert(20);
        m1.printHeapArray();
        m1.insert(2);
        m1.insert(1);
        m1.insert(5);
        m1.insert(3);
        m1.printHeapArray();

        m1.removeHighestPriority();
        m1.printHeapArray();
        m1.removeHighestPriority();
        m1.printHeapArray();




        int m = getMaximum(m1);
        System.out.println(m);
    }
}
