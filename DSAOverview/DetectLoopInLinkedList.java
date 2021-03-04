package DSAOverview;
// Java class of Loop detection
public class DetectLoopInLinkedList {
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
	// method to add node to the linked list
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
	// method to add loop to the list
	public void addLoopToList(){
		Node tempNode=head;
		while(tempNode.next!=null){
			tempNode=tempNode.next;
		}
		tempNode.next=head;
	}
	// method to find loop in the list
	public boolean findLoop(){
		Node temp1=head;
		Node temp2=head;
		while (temp1.next!=null && temp1!=null) {
			temp2=temp2.next;
			temp1=temp1.next.next;								
			if(temp1==temp2){
				return true;
			}
		}
		return false;
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
		DetectLoopInLinkedList list=new DetectLoopInLinkedList();
		list.addToList(new Node(2));
		list.addToList(new Node(3));
		list.addToList(new Node(4));
		list.addToList(new Node(5));
		list.addToList(new Node(6));
		list.addToList(new Node(7));
		list.printList();
		list.addLoopToList();
		boolean checkloop=list.findLoop();
		if (checkloop==true) {
			System.out.println("Loop exists");
		}else {
			System.out.println("Loop is not exists");
		}
	}
}