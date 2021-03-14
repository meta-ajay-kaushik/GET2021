package CircularQueue;
// circular queue class implements Queue interface
public class CircularQueue implements Queue {
	int maxSize;
	int rear;
	int front;
	int cirQueue[];
	// constructor
	public CircularQueue(int maxSize) {
		this.maxSize = maxSize;
		this.cirQueue = new int[maxSize];
		rear = -1;
		front = -1;
	}
	// method to insert into queue
	public void enqueue(int item) {
		if (isFull()) {
			System.out.println("Queue is Full");
		} else if (front == -1) {
			front = rear = 0;
			cirQueue[rear] = item;
		} else if (rear == maxSize - 1 && front != 0) {
			rear = 0;
			cirQueue[rear] = item;
		} else {
			rear++;
			cirQueue[rear] = item;
		}
	}
	// method to dequeue from queue
	public int dequeue() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return Integer.MIN_VALUE;
		}
		int data = cirQueue[front];
		cirQueue[front] = -1;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else if (front == maxSize - 1)
			front = 0;
		else
			front++;
		return data;
	}
	// method to check queue is full or not
	public boolean isFull() {
		if ((front == 0 && rear == maxSize - 1)
				|| (rear == (front - 1) % (maxSize - 1))) {
			System.out.println("Queue is Full");
			return true;
		}
		return false;
	}
	// method to check queue is empty or not
	public boolean isEmpty() {
		if (front == -1) {
			System.out.println("Queue is Empty");
			return true;
		}
		return false;
	}
	// method to print data of queue
	public void display() {
		if (isEmpty()) {
			return;
		}
		System.out.println("Elements in Circular Queue are: ");
		if (rear >= front) {
			for (int i = front; i <= rear; i++)
				System.out.println(cirQueue[i] + " ");
		} else {
			for (int i = front; i < maxSize; i++)
				System.out.println(cirQueue[i] + " ");

			for (int i = 0; i <= rear; i++)
				System.out.println(cirQueue[i] + " ");
		}
	}
}