package DSAOverview;
// Java class of Multivariate polynomial expression
public class MultivariatePolynomial {
	PolyNode headOfPoly;
	int noOfPolys;
	// Linked list class which store all nodes together
	public static class LinkedList {
		Node head;
		int noOfNodes;
		int coeff;
		// Node class which creates Node element of list
		public static class Node {
			char variable;
			int degree;
			Node next;
			// Node class constructor
			public Node(char variable, int degree) {
				this.variable = variable;
				this.degree = degree;
				next=null;
			}
		}
		// LinkedList class constructor
		public LinkedList(int coeff) {
			this.coeff = coeff;
		}
		// Method to add node to linked list
		public void addToLinkedList(Node node) {
			if (head == null) {
				head = node;
			} else {
				Node temp = head;
				while (temp.next != null)
					temp = temp.next;
				temp.next = node;
			}
			noOfNodes++;
		}
		// Method to print linked list
		public String printList() {
			Node temp = head;
			String list = "";
			while (temp != null) {
				list += temp.variable + "^" + temp.degree;
				temp = temp.next;
			}
			return list;
		}
	}
	// Java class of Polynomial node
	public static class PolyNode {
		LinkedList polyExpression;
		PolyNode nextPolyNode;
		// constructor which takes linked list in params
		public PolyNode(LinkedList polyExpression) {
			this.polyExpression = polyExpression;
		}
	}
	// method to add polynomial node to list
	public void addPolyNode(PolyNode polyNode) {
		if (headOfPoly == null) {
			headOfPoly = polyNode;
		} else {
			PolyNode temp = headOfPoly;
			while (temp.nextPolyNode != null)
				temp = temp.nextPolyNode;
			temp.nextPolyNode = polyNode;
		}
		noOfPolys++;
	}
	// Method to find the degree of the Polynomial expression
	public int degreeOfPolynomial() {
		int degree = 0;
		int i = 0;
		int sum = 0;
		PolyNode poly = headOfPoly;
		while (poly != null) {
			while (i < poly.polyExpression.noOfNodes) {
				sum = 0;
				LinkedList.Node node = poly.polyExpression.head;
				while (node != null) {
					sum += node.degree;
					node = node.next;
				}
				i++;
			}
			if (sum > degree) {
				degree = sum;
			}
			poly = poly.nextPolyNode;
			i = 0;
		}
		return degree;
	}
	// Method to print the polynomial expression
	public void printPolynomial() {
		PolyNode temp = headOfPoly;
		while (temp != null) {
			System.out.print(temp.polyExpression.coeff
					+ temp.polyExpression.printList() + " + ");
			temp = temp.nextPolyNode;
		}
		System.out.println();
	}
	// main method
	public static void main(String[] args) {
		LinkedList list1 = new LinkedList(15);
		list1.addToLinkedList(new LinkedList.Node('x', 2));
		list1.addToLinkedList(new LinkedList.Node('y', 1));
		list1.addToLinkedList(new LinkedList.Node('z', 3));
		PolyNode polyElement1 = new PolyNode(list1);
		LinkedList list2 = new LinkedList(23);
		list2.addToLinkedList(new LinkedList.Node('y', 2));
		list2.addToLinkedList(new LinkedList.Node('z', 2));
		PolyNode polyElement2 = new PolyNode(list2);
		LinkedList list3 = new LinkedList(4);
		list3.addToLinkedList(new LinkedList.Node('x', 3));
		list3.addToLinkedList(new LinkedList.Node('z', 2));
		PolyNode polyElement3 = new PolyNode(list3);
		MultivariatePolynomial polynomial = new MultivariatePolynomial();
		polynomial.addPolyNode(polyElement1);
		polynomial.addPolyNode(polyElement2);
		polynomial.addPolyNode(polyElement3);
		System.out.println("Polynomial expression is-");
		polynomial.printPolynomial();
		System.out.println("Degree of polynomial: "
				+ polynomial.degreeOfPolynomial());
	}
}