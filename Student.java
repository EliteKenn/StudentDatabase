import java.util.InputMismatchException;
import java.util.Scanner;
public class Student {
	
	private String firstName;
	private String lastName;
	private String gradeYear;
	private String studentID;
	private String courses = "";
	private int tuitionBalance = 0;
	private static int costOfCourse = 600;
	private byte level;
	private static int id = 1000;
	
	
	//Constructor with name and year from the user(Scanner)
	public Student() {
	Scanner sc = new Scanner(System.in);
	System.out.print("Enter student's first name: ");
	this.firstName = sc.nextLine();
	System.out.print("Enter student's last name: ");
	this.lastName = sc.nextLine();
	
	System.out.print("1 For Freshman\n2 For Sophomore\n3 For Junior\n4 For Senior" + "\nEnter grade level: ");
	try {
	level = sc.nextByte();
	while(level < 1 || level > 4) {
		System.out.print("Wrong input, please put in the correct input: ");
		level = sc.nextByte();
		
	}
		//Switch statement, input from the user to gradeYear being entered automatically
	
	if(level == 1) {
		this.gradeYear = "Freshman";
	}
	else if(level == 2) {
		this.gradeYear = "Sophomore";
	}
	else if(level == 3) {
		this.gradeYear = "Junior";
	}
	else if(level == 4) {
		this.gradeYear = "Senior";
	}
	}catch(InputMismatchException e) {
		System.out.println("I'm sorry, wrong input. Start Over");
		System.exit(1);
	}
//Alternative switch, but if statements are more dynamic and stable.
//	switch(level) {
//	case 1: 
//		this.gradeYear = "Freshman";
//		break;
//	case 2:
//		this.gradeYear = "Sophomore";
//		break;
//	case 3:
//		this.gradeYear = "Junior";
//		break;
//	case 4:
//		this.gradeYear = "Senior";
//		break;
//
//	}
	setStudentID();
	}
	
	//Generate an ID
	private void setStudentID() {
		//Grade level  + ID
		
		this.studentID = level + "" + id;
		id++;
	}
	//Enroll in courses
	public void enroll() {
		//Get inside a loop, user hits 0 when they're done enrolling
		
		do {
		System.out.print("Enter course to enroll(Q to quit): ");
		Scanner input = new Scanner(System.in);
		String course = input.nextLine();
		if(!course.equals("Q")) {
			this.courses = courses + "\n " +course;
			tuitionBalance = tuitionBalance + costOfCourse;
		}else {
			break;
		
		}
		}while(1 != 0);
		
	}
	
	//View balance method
	public void viewBalance() {
		System.out.println("Your current balance is: $" +tuitionBalance);
	}
	
	// pay tuition method
	public void payTuition() {
		viewBalance();
		System.out.print("How much would you like to pay today?:$");
		Scanner sc = new Scanner(System.in);
		int payment = sc.nextInt();
		tuitionBalance = tuitionBalance - payment;
		System.out.println("Thank you for your payment of: $" +payment);
		viewBalance();
		
	}
	
	//ShowStatus() method
	public String showInfo() {
		return "Name: " +firstName + " " + lastName + "\nStudent ID: " +studentID + "\nGrade Year: " +gradeYear +
				"\nCourses Enrolled: " +courses + "\nCurrent Balance: "+ tuitionBalance;
	}
}
