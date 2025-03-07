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
        swap(heapSize -1);
    }

    //method to swap added element with parent so its in order
    public void swap(int index) {
        
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
        swap(parentIndex);
    }

    public void printMaxHeap () {
        for (int num: maxHeap) {
            System.out.print(num + " ");
        }
    }
}