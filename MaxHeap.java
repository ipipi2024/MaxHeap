import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> maxHeap = new ArrayList<>();
    int heapSize = maxHeap.size();

    // method to add elements to heap
    public void add(int num) {
        // check if its empty
        if (heapSize == 0) {
            maxHeap.add(num);
            heapSize++;
            return;
        }
        // add element
        maxHeap.add(num); 
        heapSize++;
        swapUp(heapSize -1);
    }

    //method to swap added element with parent so its in order
    public void swapUp(int index) {
        
        if (index == 0) {
            return;
        }

        Integer childElement = maxHeap.get(index);

        // get parentIndex of the element added
        int parentIndex = (index - 1) / 2;

        // get parentElement
        Integer parentElement = maxHeap.get(parentIndex);

        // base case
        if (parentElement >= childElement) {
            return;
        }

        // compare with parent if needed to swap

        Integer temp = parentElement;
        maxHeap.set(parentIndex, childElement);
        maxHeap.set(index, temp);
        swapUp(parentIndex);
    }

    public void printMaxHeap () {
        for (int num: maxHeap) {
            System.out.print(num + " ");
        }
    }

    //method to remove element from root
    public Integer remove() {
        if(heapSize == 0) {
            System.out.print("Heap is empty, cannot remove!");
            return -1;
        }
        
        Integer top = maxHeap.get(0);
        Integer last = maxHeap.remove(heapSize -1);
        if (heapSize == 1) {
            heapSize--;
            return top;
        }
        heapSize--;
        maxHeap.set(0, last);
       
        swapDown(0);
        return top;

    }

    //helper method to swap down  
    public void swapDown(int index) {
       
        Integer parent = maxHeap.get(index);

        
        int leftChildIndex = 2 * index + 1;
        
        if (leftChildIndex >= heapSize) {
            return;
        }
        int rightChildIndex = 2 * index + 2;
        Integer leftChild = maxHeap.get(leftChildIndex);
        

        if (rightChildIndex >= heapSize) {
            if (leftChild > parent) {
                Integer temp = parent;
                maxHeap.set(index, leftChild);
                maxHeap.set(leftChildIndex, temp);
                swapDown(leftChildIndex);
                return;
            }
        }

        Integer rightChild = maxHeap.get(rightChildIndex);
        
        
        if (leftChild >= rightChild) {
            if (leftChild > parent) {
                Integer temp = parent;
                maxHeap.set(index, leftChild);
                maxHeap.set(leftChildIndex, temp);
                swapDown(leftChildIndex);
            }
        }else{
            if(rightChild > parent) {
                Integer temp = parent;
                maxHeap.set(index, rightChild);
                maxHeap.set(rightChildIndex, temp);
                swapDown(rightChildIndex);
            }
        }

    }
}