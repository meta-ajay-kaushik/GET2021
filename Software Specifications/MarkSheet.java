package SoftwareSpecifications;

import java.util.Scanner;
// MarkSheet java class
public class MarkSheet {
	/**
	 * Find average of the grades of students.
	 * @param grades array of grades, requires values of grades
	 * @return average of the grades
	 */
	public static float get_average(float[] grades){
		float sum=0;
		for (int i = 0; i < grades.length; i++) {
			sum+=grades[i];
		}
		return sum/grades.length;
	}
	/**
	 * Find Maximum grade from all.
	 * @param grades array of grades, requires values of grades
	 * @return maximum value of the grades
	 */
	public static float get_max_grade(float[] grades){
		float max=grades[0];
		for (int i = 1; i < grades.length; i++) {
			if(max<grades[i]){
				max=grades[i];
			}
		}
		return max;
	}
	/**
	 * Find Minimum grade from all.
	 * @param grades array of grades, requires values of grades
	 * @return minimum value of the grades
	 */
	public static float get_min_grade(float[] grades){
		float min=grades[0];
		for (int i = 1; i < grades.length; i++) {
			if(min>grades[i]){
				min=grades[i];
			}
		}
		return min;
	}

	/**
	 * Find Percentage of passing students.
	 * @param grades array of grades, requires values of grades
	 * @return percentage of passing students
	 */
	public static float passed_students_percentage(float[] grades){
		float pass=0;
		for (int i = 0; i < grades.length; i++) {
			if(grades[i]>=40){
				pass+=1;
			}
		}
		return (pass/grades.length)*100;
	}
	// main method
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter total no of student");
		int total_students=scan.nextInt();
		float[] grades=new float[total_students];
		System.out.println("Enter grades in range 0 to 100");
		for (int i = 0; i < total_students; i++) {
			grades[i]=scan.nextFloat();
		}
		float average_grade=get_average(grades);
		float maximum_grade=get_max_grade(grades);
		float minimum_grade=get_min_grade(grades);
		float passed_students=passed_students_percentage(grades);
		System.out.println("The average of all grades is "+String.format("%.2f",average_grade));
		System.out.println("The maximum of all grades is "+String.format("%.2f",maximum_grade));
		System.out.println("The minimum of all grades is "+String.format("%.2f",minimum_grade));
		System.out.println("Percentage of passed student "+String.format("%.2f",passed_students)+"%");
		scan.close();
	}
}
