package CircularQueue;
import java.util.Scanner;
// java class to implement circular queue working
public class CircularQueueImplement {
	// main method
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Size of Circular Queue : ");
		int maxSize = scan.nextInt();
		CircularQueue object = new CircularQueue(maxSize);
		System.out.println("Inserting elements into Queue : ");
		object.enqueue(12);
		object.enqueue(14);
		object.enqueue(17);
		object.enqueue(19);
		object.enqueue(22);
		object.enqueue(3);
		System.out.println("Removing elements from queue : ");
		for(int index=0;index<6;index++) {
			int data = object.dequeue();
			if(data == Integer.MIN_VALUE)
				System.out.println("Queue underflow..");
			else
				System.out.println(data+" is deleted from queue");
		}
		scan.close();
	}
}