package assignment2;
import java.sql.*; 
import java.util.Scanner;

public class StudMain {
	public static void main(String[] args) throws SQLException {
		
		Scanner scan = new Scanner(System.in);
		
		//Initialize M-V-C classes
		StudModel model = new StudModel();
		StudView view = new StudView();
		StudController controller = new StudController(model, view);
		
		System.out.print("1. Input data into database \n2. Retrieve data from database \nPlease choose your number: ");
		int choose = scan.nextInt();
		
		if(choose == 1) {
			
			//Get data from user
			System.out.println("\nInsert student data");
			System.out.print("Student ID: ");
			int studentId = scan.nextInt();
			
			System.out.print("Name: ");
			String name = scan.next();
			
			System.out.print("Department: ");
			String department = scan.next();
			
			System.out.print("Mathematics mark: ");
			int mathMark = scan.nextInt();
			
			System.out.print("Science mark: ");
			int scienceMark = scan.nextInt();
			
			System.out.print("Chemistry mark: ");
			int chemistryMark = scan.nextInt();
			
			//Send data to Controller class
			controller.saveData(studentId, name, department, mathMark, scienceMark, chemistryMark);
			
		}else if(choose == 2) {
			
			//Get student id from user
			System.out.print("\nEnter student id: ");
			int studId = scan.nextInt();
			
			try {
				//Send student id to Controller class
				controller.readData(studId);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}