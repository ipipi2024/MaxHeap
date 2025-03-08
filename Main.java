public class Main {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.add(3);
        maxHeap.add(2);
        maxHeap.add(1);
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        maxHeap.remove();
        
        maxHeap.printMaxHeap();
    }
}
