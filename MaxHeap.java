import java.util.ArrayList;

public class MaxHeap {
    private ArrayList<Integer> heap;
    
    public MaxHeap() {
        heap = new ArrayList<>();
    }
    
    /**
     * Returns the current size of the heap
     */
    public int size() {
        return heap.size();
    }
    
    /**
     * Checks if the heap is empty
     */
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    /**
     * Returns the maximum element without removing it
     */
    public Integer peek() {
        if (isEmpty()) {
            return null;
        }
        return heap.get(0);
    }
    
    /**
     * Adds a new element to the heap
     */
    public void add(int value) {
        // Add the element to the end of the heap
        heap.add(value);
        
        // Fix the max heap property by swapping up
        swapUp(heap.size() - 1);
    }
    
    /**
     * Helper method to maintain heap property after adding an element
     */
    private void swapUp(int index) {
        // Base case: reached the root or parent is already larger
        if (index == 0) {
            return;
        }
        
        int parentIndex = (index - 1) / 2;
        
        // If parent is smaller than current element, swap them
        if (heap.get(parentIndex) < heap.get(index)) {
            swap(parentIndex, index);
            // Recursively check the parent
            swapUp(parentIndex);
        }
    }
    
    /**
     * Removes and returns the maximum element from the heap
     */
    public Integer remove() {
        if (isEmpty()) {
            System.out.println("Heap is empty, cannot remove!");
            return null;
        }
        
        // Store the max element to return later
        Integer max = heap.get(0);
        
        // If there's only one element, just remove it
        if (heap.size() == 1) {
            heap.remove(0);
            return max;
        }
        
        // Replace the root with the last element
        heap.set(0, heap.remove(heap.size() - 1));
        
        // Fix the max heap property by swapping down
        swapDown(0);
        
        return max;
    }
    
    /**
     * Helper method to maintain heap property after removing the root
     */
    private void swapDown(int index) {
        int largest = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        int heapSize = heap.size();
        
        // Check if left child exists and is larger than current largest
        if (leftChildIndex < heapSize && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        }
        
        // Check if right child exists and is larger than current largest
        if (rightChildIndex < heapSize && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        }
        
        // If largest is not the current index, swap and continue down
        if (largest != index) {
            swap(index, largest);
            swapDown(largest);
        }
    }
    
    /**
     * Helper method to swap two elements in the heap
     */
    private void swap(int i, int j) {
        Integer temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    /**
     * Prints all elements in the heap
     */
    public void printHeap() {
        if (isEmpty()) {
            System.out.println("Heap is empty");
            return;
        }
        
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();
    }
    
    /**
     * Creates a heap from an array of integers
     */
    public void buildHeap(int[] array) {
        // First add all elements
        for (int value : array) {
            heap.add(value);
        }
        
        // Heapify from the last non-leaf node up to the root
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            swapDown(i);
        }
    }
}