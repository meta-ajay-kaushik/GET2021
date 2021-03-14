package Employee6;

public class Employee {
	private String name;
	private int salary;
	private int age;
	Employee next;
	public Employee(String name,int salary,int age)
	{
		this.name=name;
		this.salary=salary;
		this.age=age;
		next=null;
	}
	public String getName()
	{
		return name;
	}
	public int getSalary()
	{
		return salary;
	}
	public int getAge()
	{
		return age;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public void setSalary(int salary)
	{
		this.salary=salary;
	}
	public void setAge(int age)
	{
		this.age=age;
	}
}