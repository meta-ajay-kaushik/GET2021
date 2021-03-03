package FactoryforADT;
import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;
// TestShape class to test methods of Shape class
public class TestShape {
	// Take Width and Height of shapes in ArrayList
	ArrayList<Integer> list1=new ArrayList<Integer>(Arrays.asList(6,4));
	ArrayList<Integer> list2=new ArrayList<Integer>(Arrays.asList(8,4));
	ArrayList<Integer> list3=new ArrayList<Integer>(Arrays.asList(6));
	ArrayList<Integer> list4=new ArrayList<Integer>(Arrays.asList(4));
	// Initialize Origin Points
	Point p=new Point(0,0);
	Point p1=new Point(1,1);
	Point p2=new Point(2,2);
	Point p3=new Point(3,3);
	// Create object of screen class
	Screen s1=new Screen();
	// method to create shapes by Factory class object
	public void add()
	{
	Shape s=Fectory.createShape("Triangle",p,list1);
	s1.addShape(s);
	s=Fectory.createShape("Rectangle",p1,list2);
	s1.addShape(s);
	s=Fectory.createShape("Square",p2,list3);
	s1.addShape(s);
	s=Fectory.createShape("Circle",p3,list4);
	s1.addShape(s);
	}
	// Test the all shapes Origins, Areas, perimeters and they are created or not
	@Test
	public void testSortOrigin_sort_SortedShapeArray()
	{
		add();
		ArrayList<Shape> list=s1.sort("Origin");
		assertEquals(0,list.get(0).getOrigin().x);
		assertEquals(0,list.get(0).getOrigin().y);
		assertEquals(1,list.get(1).getOrigin().x);
		assertEquals(1,list.get(1).getOrigin().y);
		assertEquals(2,list.get(2).getOrigin().x);
		assertEquals(2,list.get(2).getOrigin().y);
		assertEquals(3,list.get(3).getOrigin().x);
		assertEquals(3,list.get(3).getOrigin().y);
	}
	// Test all the shapes Area is right or not.
	@Test
	public void testSortArea_sort_SortedShapeArray()
	{
		ArrayList<Shape> list=s1.sort("Area");
		assertEquals(12,list.get(0).getArea());
		assertEquals(32,list.get(1).getArea());
		assertEquals(36,list.get(2).getArea());
		assertEquals(48,list.get(3).getArea());	
	}
}
