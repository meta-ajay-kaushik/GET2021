package DSAOverview;
// Java class of Linked list rotation
public class RotateLinkedList {
	public Node head;
	// Node class
	public static class Node{
		int value;
		Node next;
		// Node class constructor
		public Node(int val) {
			this.value=val;
		}
	}
	// Method to add node to linked list
	public void addToList(Node node){
		if (head==null) {
			head=node;
		}else {
			Node temp=head;
			while (temp.next!=null) {
				temp=temp.next;
			}
			temp.next=node;
		}
	}
	// Method to shift Sub linked list
	public void shiftSubList(int left, int right, int noOfShift){
		Node start=head;
		Node last = head;
		Node tempNode;
		int count=1;
		int tempvalue;
		while (count<left) {
			start=start.next;
			count++;
		}
		count=1;
		while (count<right) {
			last=last.next;
			count++;
		}
		for (int i = 0; i < noOfShift; i++) {
			tempvalue=start.value;
			tempNode=start;
			for (int j = 0; j < right-left; j++) {
				tempNode.value=tempNode.next.value;
				tempNode=tempNode.next;
			}
			tempNode.value=tempvalue;
		}
	}
	// method to print linked list
	public void printList(){
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.value+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	// main method
	public static void main(String[] args) {
		RotateLinkedList list=new RotateLinkedList();
		list.addToList(new Node(2));
		list.addToList(new Node(3));
		list.addToList(new Node(4));
		list.addToList(new Node(5));
		list.addToList(new Node(6));
		list.addToList(new Node(7));
		list.printList();
		list.shiftSubList(2, 5, 2);
		list.printList();
	}
}
