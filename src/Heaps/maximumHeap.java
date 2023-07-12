package Heaps;

public class maximumHeap<T extends Comparable> extends Heap {

    public maximumHeap(Class<T> heap) {
        super(heap);
    }
    public maximumHeap(Class<T> heap , int size){
        super(heap, size);
    }

    @Override
    protected void shiftDown(int index)//index is here the element that need to be shifted down to the right position.
    {
        int leftIndex= getLeftChild(index);
        int rightIndex= getRightChild(index);
        //get to the left and the right indices o compare values.


        //Find the minimum of the left and right child elements.
        int smallerIndex = -1 ;
        //store the index at which we find the minimum value in smaller index.

        if (leftIndex != -1 && rightIndex != -1) {
            smallerIndex = getElementbyIndex(leftIndex).compareTo(getElementbyIndex(rightIndex)) > 0
                    ? leftIndex : rightIndex;

            // if the expression is true it will assign leftIndex to smallerIndex or else it will assign the rightIndex
            //if the node has both left and right children find the smaller value between them.
        }

        //if the node has only a left child or a right child that child can be considered the one which has the smaller value.
        else if (leftIndex != -1){
            smallerIndex = leftIndex;
        }
        else if (rightIndex != -1){
            smallerIndex = rightIndex;
        }

        // if the left and right child does not exist it will stop shifting down.
        if(smallerIndex == -1){
            return;
        }

        //compare the smaller child with the current index to see if it is a swap.
        //and further shift down is needed or not.
        if(getElementbyIndex(smallerIndex).compareTo(getElementbyIndex(index)) > 0){
            //Compare the smaller of the children with the parent index and wap if needed shift the parent down further.

            swap(smallerIndex , index);
            shiftDown(smallerIndex);
        }

    }

    @Override
    protected void shiftUp(int index){
        int parent= getParent(index);


        //compare the smaller index with the current index to see if it is a swap.
        //and further shift down is needed or not.
        if(parent != -1 && getElementbyIndex(index).compareTo(getElementbyIndex(parent)) > 0){
            swap(parent , index);
            shiftUp(parent);
        }

    }



    public static void main(String[] args) throws HeapFullException , HeapEmptyException {
        maximumHeap<Integer> m1 = new maximumHeap<Integer>(Integer.class);

        m1.insert(9);
        m1.insert(4);
        m1.insert(17);
        m1.printHeapArray();
        m1.insert(6);
        m1.printHeapArray();

        m1.insert(100);
        m1.insert(20);
        m1.insert(2);
        m1.insert(1);
        m1.printHeapArray();
        m1.insert(5);
        m1.insert(3);
        m1.printHeapArray();

        m1.removeHighestPriority();
        m1.printHeapArray();
        m1.removeHighestPriority();
        m1.printHeapArray();


    }
}
