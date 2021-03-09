package Employee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// employeeSorting class
public class EmployeeSorting {
	Map<Integer, Employee> employees = new HashMap<Integer, Employee>();
	List<Integer> empIdList = new ArrayList<Integer>();
	private int count;
	// method to add employee to list
	public void addToEmployees(Employee emp){
		if(!employees.containsKey(emp.getEmpId())){
			employees.put(emp.getEmpId(), emp);
			empIdList.add(emp.getEmpId());
		}
	}
	// method to sort employees by name
	public String [] sortByName(){
		count = employees.size();
		String str[] = new String[count];
		String temp;
		int indexStr=0;
		for ( Map.Entry<Integer, Employee> entry : employees.entrySet()) {
		    String name = entry.getValue().getName();
		    str[indexStr++]=name;
		}
		for (int index = 0; index < count; index++) 
        {
            for (int j = index + 1; j < count; j++) { 
                if (str[index].compareTo(str[j])>0) 
                {
                    temp = str[index];
                    str[index] = str[j];
                    str[j] = temp;
                }
            }
        }
	return str;
	}
	// main method
	public static void main(String[] args) {
		EmployeeSorting obj = new EmployeeSorting();
		obj.addToEmployees(new Employee("Manoj",1,"abc nagar"));
		obj.addToEmployees(new Employee("Dwarika",5,"abc nagar"));
		obj.addToEmployees(new Employee("Ajay",12,"abc nagar"));
		obj.addToEmployees(new Employee("Dikshant",13,"abc nagar"));
		obj.addToEmployees(new Employee("Ravi",3,"abc nagar"));
		obj.addToEmployees(new Employee("Ajay",5,"abc nagar"));
		String str[] = obj.sortByName();
		for(int index=0;index<str.length;index++){
			System.out.println(str[index]);
		}
	}
}