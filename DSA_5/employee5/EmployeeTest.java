package employee5;
import static org.junit.Assert.*;
import org.junit.Test;
public class EmployeeTest {
	@Test
	public void testRotation1() {
		Employees E = new Employees();
		E.insertIntoEmployee("Lokesh", 20000, 30);
		E.insertIntoEmployee("Kamlesh", 20000, 30);
		E.insertIntoEmployee("Vinnu", 30000, 40);
		E.insertIntoEmployee("Rahul", 30000, 25);
		E.insertIntoEmployee("Manoj", 10000, 22);
		E.insertIntoEmployee("Ajay", 30000, 20);
		E.insertIntoEmployee("Bhura", 30000, 10);
		E.insertIntoEmployee("Vinay", 30000, 5);
		E.insertionSort(E.headEmloyee);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Vinay", "Bhura", "Ajay", "Rahul", "Vinnu", "Lokesh","Kamlesh",  "Manoj"};
		assertArrayEquals(expectedData, result);
	}
	@Test
	public void testRotation2() {
		Employees E = new Employees();
		E.insertIntoEmployee("Lokesh", 20, 30);
		E.insertIntoEmployee("Kamlesh", 20, 28);
		E.insertIntoEmployee("Vinnu", 30, 40);
		E.insertIntoEmployee("Rahul", 80, 25);
		E.insertIntoEmployee("Manoj", 70, 22);
		E.insertIntoEmployee("Ajay", 110, 20);
		E.insertIntoEmployee("Bhura", 250, 10);
		E.insertIntoEmployee("Vinay", 300, 5);
		E.insertionSort(E.headEmloyee);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Vinay", "Bhura", "Ajay", "Rahul", "Manoj", "Vinnu","Kamlesh",  "Lokesh"};
		assertArrayEquals(expectedData, result);
	}
	@Test
	public void testRotation3() {
		Employees E = new Employees();
		E.insertIntoEmployee("Lokesh", 100, 30);
		E.insertIntoEmployee("Kamlesh", 90, 30);
		E.insertIntoEmployee("Vinnu", 80, 40);
		E.insertIntoEmployee("Rahul", 80, 25);
		E.insertIntoEmployee("Manoj", 70, 22);
		E.insertIntoEmployee("Ajay", 70, 20);
		E.insertIntoEmployee("Bhura", 60, 10);
		E.insertIntoEmployee("Vinay", 3, 5);
		E.insertionSort(E.headEmloyee);
		E.printList();
		String[] result = E.printList();
		String[] expectedData = { "Lokesh", "Kamlesh", "Rahul", "Vinnu", "Ajay", "Manoj","Bhura",  "Vinay"};
		assertArrayEquals(expectedData, result);
	}
	@Test(expected = AssertionError.class) 
	public void testRotation4() {
		Employees E = new Employees();
		E.printList();
		String[] result = E.printList();
		String[] expectedData = {};
		assertArrayEquals(expectedData, result);
	}
}