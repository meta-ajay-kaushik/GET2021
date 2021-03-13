package employee5;
class EmpNode {
	String name;
	int age;
	int salary;
	EmpNode nextEmployee;
	/**
	 *Constructor is used to initialize the value of employee   
	 * @param name string type value
	 * @param age integer type value
	 * @param salary integer type value
	 */
	public EmpNode(String name, int age, int salary) {
		this.age = age;
		this.salary = salary;
		this.name = name;
		this.nextEmployee = null;
	}
}
public class Employees {
	public EmpNode headEmloyee = null;
	EmpNode sorted;
	public void insertIntoEmployee(String name, int salary, int age) {
		EmpNode newNode = new EmpNode(name, age, salary);
		if (headEmloyee == null) {
			headEmloyee = newNode;
		} else {
			EmpNode temp = headEmloyee;
			while (temp.nextEmployee != null) {
				temp = temp.nextEmployee;
			}
			temp.nextEmployee = newNode;
		}
	}
	/**
	 * function is used to print the data of employees
	 */
	public String[] printList() {
		if(this.headEmloyee == null){
			throw new AssertionError();
		}
		EmpNode temp = this.headEmloyee;
		String[] nameOfEmp = new String[8];
		int i =0;
		while (temp != null) {
			nameOfEmp[i] = temp.name;
			i = i + 1;
			temp = temp.nextEmployee;
		}
		return nameOfEmp;
	}
	/**
	 * this function is used to call the sorting function
	 * which hold reference of head node and next of head node
	 * @param headref
	 */
	public void insertionSort(EmpNode headref) {
		sorted = null;
		EmpNode current = headref;
		while (current != null) {
			EmpNode next = current.nextEmployee;
			sortedInsert(current);
			current = next;
		}
		this.headEmloyee = sorted;
	}
	/**
	 * function to insert a new_node in a list. Note that this function expects
	 * a pointer to head_ref as this can modify the head of the input linked
	 * list (similar to push())
	 */
	void sortedInsert(EmpNode newnode) {
		if (sorted == null || sorted.salary < newnode.salary) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else if (sorted.salary == newnode.salary && sorted.age > newnode.age) {
			newnode.nextEmployee = sorted;
			sorted = newnode;
		} else {
			EmpNode current = sorted;
			while (current.nextEmployee != null
					&& current.nextEmployee.salary > newnode.salary) {
				current = current.nextEmployee;
			}
			newnode.nextEmployee = current.nextEmployee;
			current.nextEmployee = newnode;
		}
	}
}