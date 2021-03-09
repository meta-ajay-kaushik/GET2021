package Employee;
// Employee class
public class Employee {
	private String name;
	private int empId;
	private String address;
	// constructor
	Employee(String name,int empId,String address){
		this.name = name;
		this.empId = empId;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
