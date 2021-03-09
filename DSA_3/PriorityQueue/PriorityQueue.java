package PriorityQueue;
// Main Java Class PriorityQueue
public class PriorityQueue {
    int sizeArray;
    int arr[];
    int size = 0;
    // constructor
    PriorityQueue(int element) {
        arr = new int[element];
        this.sizeArray = element;
    }
    // method to insert element in queue
    public void enque(int data) {
        int index;
        if (!isFull()) {
            if (isEmpty()) {
                arr[0] = data;
                size++;
            } else {
                for (index = size - 1; index >= 0; index--) {
                    if (data > arr[index]) {
                        arr[index + 1] = arr[index];
                    } else {
                        break;
                    }
                }
                arr[index + 1] = data;
                size++;
            }
        } else {
            System.out.println("queue is full");
        }
    }
    // method to check if a queue is empty or not
    public boolean isEmpty() {
        return size == 0;
    }
    // method to check queue is full or not
    public boolean isFull() {
        return size == sizeArray;
    }
    // method to delete element from queue
    public void deque() {
        if (!isEmpty()) {
            arr[--size] = 0;
        } else {
            System.out.println("Queue is empty");
        }
    }
    // method to show elements of queue
    public int[] show() {
        return arr;
    }
}
