package SoftwareSpecifications;

import java.util.Scanner;
// MarkSheet java class
public class MarkSheet {
	/**
	 * Find average of the grades of students.
	 * @param grades array of grades, requires values of grades
	 * @return average of the grades
	 */
	public static float getAverage(float[] grades){
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
	public static float getMaxGrade(float[] grades){
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
	public static float getMinGrade(float[] grades){
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
	public static float passedStudentsPercentage(float[] grades){
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
		int totalStudents=scan.nextInt();
		float[] grades=new float[totalStudents];
		System.out.println("Enter grades in range 0 to 100");
		int flag=0;
		while(flag<3){
			for (int i = 0; i < totalStudents; i++) {
				float temp=scan.nextFloat();
				if (temp<0 || temp>100) {
					System.out.println("Wrong Input, enter again");
					i--;
				}
				else{
					grades[i]=temp;
					flag++;
				}
			}			
		}
		float averageGrade=getAverage(grades);
		float maximumGrade=getMaxGrade(grades);
		float minimumGrade=getMinGrade(grades);
		float passedStudents=passedStudentsPercentage(grades);
		System.out.println("The average of all grades is "+String.format("%.2f",averageGrade));
		System.out.println("The maximum of all grades is "+String.format("%.2f",maximumGrade));
		System.out.println("The minimum of all grades is "+String.format("%.2f",minimumGrade));
		System.out.println("Percentage of passed student "+String.format("%.2f",passedStudents)+"%");
		scan.close();
	}
}
