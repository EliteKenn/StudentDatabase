package StudentDatabase;

import java.util.Scanner;

public class StudentDatabase {
public static void main(String[] args) {
	
	
	
	
	//Ask the user how many student's they want to add
	System.out.print("Enter number of new students to enroll: ");
	Scanner sc = new Scanner(System.in);
	int numOfStu  = sc.nextInt();
	Student[] students = new Student[numOfStu];
	
	
	///Create n number of new students 
	for(int i = 0; i < numOfStu;i++) {
		students[i] = new Student();
		students[i].enroll();
		students[i].payTuition();
		System.out.println(students[i].showInfo());
	}
	
	
}
}
