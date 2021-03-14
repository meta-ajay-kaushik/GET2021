package Employee6;
public class EmployeeLinkedList {
	Employee head;
	public EmployeeLinkedList()
	{
		head=new Employee("A",32000,17);
		Employee employee=new Employee("B",22003,23);
		head.next=employee;
		employee.next=new Employee("C",12000,67);
		employee=employee.next;
		employee.next=new Employee("D",20900,35);
		employee=employee.next;
		employee.next=new Employee("E",20900,25);
		employee=employee.next;
	}
	/**
	 * this compare the both of employees on bases of their salary and ages
	 * @param employee1 the first employee to compare
	 * @param employee2 the second employee to compare
	 * @return the comparison result after comparing both the employees
	 */
	public int compareEmployees(Employee employee1,Employee employee2)
	{
		if(employee1.getSalary()>employee2.getSalary())
		{
			return 1;
		}
		else if(employee1.getSalary()<employee2.getSalary())
		{
			return -1;
		}
		else
		{
			if(employee1.getAge()>employee2.getAge())
			{
				return -1;
			}
			else if(employee1.getAge()<employee2.getAge())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		}
	}
	public Employee getLast(Employee head)
	{
		Employee employee=head;
		while(employee!=null && employee.next!=null)
		{
			employee=employee.next;
		}
		return employee;
	}
	/**
	 * this method do partition of the linked list using pivot element
	 * @param head the starting node after partition
	 * @param end the last node of linked list after partition
	 * @return the head ,pivot and end node of linked list in array form
	 */
	public Employee[] doPartition(Employee head,Employee end)
	{
		Employee pivot=end;
		Employee current=head;
		Employee previous=null;
		Employee newHead=null;
		Employee newEnd=null;
		while(current!=pivot)
		{
			int comparisonResult=this.compareEmployees(current,pivot);
			if(comparisonResult==1)
			{
				if(newHead==null)
				{
					newHead=current;
				}
				previous=current;
				current=current.next;
			}
			else
			{
				if(previous!=null)
				{
					previous.next=current.next;
				}
				Employee temp=current.next;
				current.next=null;
				end.next=current;
				end=current;
				current=temp;
			}
		}
		if(newHead==null)
		{
			newHead=pivot;
		}
		newEnd=end;
		Employee employees[]= {newHead,pivot,newEnd};
		return employees;
	}
	/**
	 * this method sort the linked list using quick sort algorithm
	 * @param head the head of the linked list
	 * @param end the end of linked list
	 * @return it return the head of linked list after sorting
	 */
	public Employee QuickSortRecursion(Employee head,Employee end)
	{
		if(head==null || head==end)
		{
			return head;
		}
		Employee employees[]=this.doPartition(head, end);
		Employee newHead=employees[0];
		Employee pivot=employees[1];
		Employee newEnd=employees[2];
		if(newHead!=pivot)
		{
			Employee employee=newHead;
			while(employee.next!=pivot)
			{
				employee=employee.next;
			}
			employee.next=null;
			newHead=this.QuickSortRecursion(newHead, employee);
			employee=this.getLast(newHead);
			employee.next=pivot;
		}
		pivot.next=this.QuickSortRecursion(pivot.next, newEnd);
		return newHead;
	}
	public void printEmployeesLinkedList()
	{
		Employee employee=head;
		System.out.println("List of employees is as");
		System.out.println("name   salary   Age");
		while(employee!=null)
		{
			System.out.println(employee.getName()+"      "+employee.getSalary()+"    "+employee.getAge());
			employee=employee.next;
		}
	}
	public static void main(String []args)
	{
		EmployeeLinkedList employeeLinkedList=new EmployeeLinkedList();
		System.out.println("Before sorting");
		employeeLinkedList.printEmployeesLinkedList();
		employeeLinkedList.head=employeeLinkedList.QuickSortRecursion(employeeLinkedList.head,employeeLinkedList.getLast(employeeLinkedList.head));
		System.out.println("After sorting");
		employeeLinkedList.printEmployeesLinkedList();
	}
}