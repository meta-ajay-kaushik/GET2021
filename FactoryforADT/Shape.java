package FactoryforADT;
import java.util.*;
// Point java class
class Point
{
	final int x;
	final int y;
	// constructor which initialize coordinates
	Point(int a,int b)
	{
		x=a;
		y=b;
	}
} 
// Shape interface
interface Shape
{
	int getArea();
	int getParameter();
	Point getOrigin();
	boolean isPointEnclosed(Point pt); 
	String getType();
}
// Triangle class which implements Shape interface
class Triangle implements Shape
{
	Point p;
	String type;
	int base;
	int height;
	// constructor of Triangle
	Triangle(String t,Point o, ArrayList<Integer> a)
	{
		base=a.get(0);
		height=a.get(1);
		type=t;
		p=o;
	}
	// method to get Area of triangle
	public int getArea()
	{
		return base*height/2;
	}
	// method to get perimeter
	public int getParameter()
	{
		return (int)(base+height+Math.sqrt(base*base+height*height));
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
			Point v1,v2,v3;
			v1=new Point(p.x,p.y);
			v2=new Point(p.x+base,p.y);
			v3=new Point(p.x,p.y+height);
		    float d1, d2, d3;
		    boolean has_neg, has_pos;

		    d1 = sign(pt, v1, v2);
		    d2 = sign(pt, v2, v3);
		    d3 = sign(pt, v3, v1);

		    has_neg = (d1 < 0) || (d2 < 0) || (d3 < 0);
		    has_pos = (d1 > 0) || (d2 > 0) || (d3 > 0);

		    return !(has_neg && has_pos);
	}
	private float sign (Point p1, Point p2, Point p3)
	{
	    return (p1.x - p3.x) * (p2.y - p3.y) - (p2.x - p3.x) * (p1.y - p3.y);
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
//Square class which implements Shape interface
class Square implements Shape
{
	int side;
	Point p;
	String type;
	Square(String t,Point o, ArrayList<Integer> a)
	{
		side=a.get(0);
		type=t;
		p=o;
	}
	// method to get area
	public int getArea()
	{
		return side*side;
	}
	// method to get perimeter
	public int getParameter()
	{
		return 4*side;
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if(pt.x<p.x || pt.y<p.y)
			return false;
		if(pt.x>p.x+side || pt.y>p.y+side)
			return false;
		return true;
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
//Rectangle class which implements Shape interface
class Rectangle implements Shape
{
	Point p;
	String type;
	int length;
	int width;
	Rectangle(String t,Point o, ArrayList<Integer> a)
	{
		length=a.get(0);
		width=a.get(1);
		type=t;
		p=o;
	}
	// method to get area
	public int getArea()
	{
		return length*width;
	}
	// method to get perimeter
	public int getParameter()
	{
		return 2*(length+width);
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to find point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if(p.x<pt.x || p.y<pt.y || p.x>pt.x+length|| p.y>pt.y+width)
			return false;
		else 
			return true;
	}
	// method to find type of shape
	public String getType()
	{
		return type;
	}
}
//Circle class which implements Shape interface
class Circle implements Shape
{
	int radius;
	Point p;
	String type;
	// constructor
	Circle(String t,Point o, ArrayList<Integer> a)
	{
		radius=a.get(0);
		type=t;
		p=o;
	}
	// method to get area of circle
	public int getArea()
	{
		return (int)3.14*radius*radius;
	}
	// method to get perimeter
	public int getParameter()
	{
		return (int)3.14*2*radius;
	}
	// method to get origin points
	public Point getOrigin()
	{
		return p;
	}
	// method to check point enclosed or not
	public boolean isPointEnclosed(Point pt)
	{
		if((int)Math.sqrt((pt.x-p.x)*(pt.x-p.x)+(pt.y-p.y)*(pt.y-p.y))<radius)
			return true;
		else 
			return false;
	}
	// method to get type of shape
	public String getType()
	{
		return type;
	}
}
// Shape Factory Class
class Fectory
{
	// Create shapes
	public static Shape createShape(String type,Point o,ArrayList<Integer> a)
	{
		Shape s=null;
		if(type=="Triangle")
		{
			s=new Triangle(type,o,a);
		}
		if(type=="Square")
		{
			s=new Square(type,o,a);
		}
		if(type=="Rectangle")
		{
			s=new Rectangle(type,o,a);
		}
		if(type=="Circle")
		{
			s=new  Circle(type,o,a);
		}
		return s;
	}
}
// Screen class
class Screen
{
	static ArrayList<Shape> listShape=new ArrayList<Shape>();
	static ArrayList<Date> date=new ArrayList<Date>(); 
	// method to add shape to the list
	void addShape(Shape s)
	{
		listShape.add(s);
		date.add(new Date());
	}
	// method to remove shape from the list
	void removeShape(Shape s)
	{
		for(int i=0;i<listShape.size();i++)
		{
			if(listShape.get(i).getType()==s.getType())
			{
				listShape.remove(i);
				date.remove(i);
			}
		}
	}
	// method to remove all shapes
	void removeAllShape(String t)
	{
		for(int i=0;i<listShape.size();i++)
			if(listShape.get(i).getType()==t)
			{
				listShape.remove(i);
			}
	}
	// method to swap list on shape
	private void swap(ArrayList<Shape> list,int x,int y)
	{
		Shape s;
		s=list.get(x);
		list.set(x,list.get(y));
		list.set(y,s);
	}
	// method to swap list based on Date
	private void swapDate(ArrayList<Date> list,int x,int y)
	{
		Date s;
		s=list.get(x);
		list.set(x,list.get(y));
		list.set(y,s);
	}
	// method to sort array based on Area, Perimeter, Origin and time
	ArrayList<Shape> sort(String s)
	{
		ArrayList<Shape> list = listShape; 
			for(int i=0;i<list.size()-1;i++)
			{
				for(int j=0;j<list.size()-i-1;j++)
				{
					if(s=="Area")
					{
						if(list.get(j).getArea()>list.get(j+1).getArea())
						{
							swap(list,j,j+1);
							swapDate(date,j,j+1);
						}
					}
					if(s=="Paremeter")
					{
						if(list.get(j).getParameter()>list.get(j+1).getParameter())
						{
							swap(list,j,j+1);
							swapDate(date,j,j+1);
						}
					}
					if(s=="Origin")
					{
						Point p=list.get(j).getOrigin();
						Point q=list.get(j+1).getOrigin();
						int a=p.x*p.x-p.y*p.y;
						int b=q.x*q.x-q.y*q.y;
						if(a>b)
						{
							swap(list,j,j+1);
							swapDate(date,j,j+1);
						}
					}
					if(s=="time")
					{
						if(1 == date.get(j).compareTo(date.get(j+1)))
						{
							swap(list,j,j+1);
							swapDate(date,j,j+1);
						}
					}
				}
			}
		return list;
	}
	// method to find point enclosed or not
	ArrayList<Shape> enclosed(Point pt)
	{
		ArrayList<Shape> list=new ArrayList<Shape>();
		for(int i=0;i<listShape.size();i++)
		{
			if(listShape.get(i).isPointEnclosed(pt))
			{
				list.add(listShape.get(i));
			}
		}
		return list;
	}
}