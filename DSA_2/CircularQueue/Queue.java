package CircularQueue;
public interface Queue {
	boolean isFull();
	boolean isEmpty();
	void enqueue(int data);
	int dequeue();
}