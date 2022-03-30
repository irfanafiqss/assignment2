package assignment2;
import java.sql.*; 

public class StudController {
	
	//Variable declaration
	private static StudModel model = new StudModel();
	private StudView view;
	
	//Constructor
	public StudController(StudModel model, StudView view){
		this.model = model;
		this.view = view;
	}
	
	//Read data from database
	public void readData(int studentId) throws SQLException{       
		// Connect to database
				Connection conn = null;
				
				String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
				
				conn = DriverManager.getConnection(connectionURL, "root", "206847");
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// Retrieve results from the table
		ResultSet rs = statement.executeQuery ("Select * from student"); 
		
		// Count columns
		ResultSetMetaData rsmd =rs.getMetaData(); 
		int i =rsmd.getColumnCount( );
				
		// Insert records to Model class
		while(rs.next( ) ) { 
			for(int j=1; j<=i; j++) 
			{ 
				if(Integer.valueOf(rs.getString( 1)) == studentId) {
					if(j == 1)
						model.setId(Integer.valueOf(rs.getString( j)));
					else if(j == 2)
						model.setName(rs.getString( j));
					else if(j == 3)
						model.setDepartment(rs.getString( j));
					else if(j == 4)
						model.setMathMark(Integer.valueOf(rs.getString( j)));
					else if(j == 5)
						model.setScienceMark(Integer.valueOf(rs.getString( j)));
					else if(j == 6)
						model.setChemistryMark(Integer.valueOf(rs.getString( j)));
			}}
		}
		updateView();
	}
	
	//Send data to View class
	public void updateView(){                
        view.printStudentMarks(model.getId(), model.getName(), model.getDepartment(), model.getMath(), model.getScience(), model.getChemistry());
     }
	
	//Save data to database
	public void saveData(int id, String name, String department, int math, int science, int chemistry) throws SQLException {
		
		// Connect to database
		Connection conn = null;
		
		String connectionURL = "jdbc:mysql://localhost:3306/db1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
		
		conn = DriverManager.getConnection(connectionURL, "root", "206847");
		
		// create a Statement from the connection
		Statement statement = conn.createStatement();
		
		// insert the data into database
		statement.executeUpdate("INSERT INTO student VALUES (" + id + ", '"+ name + "', '" +
		department + "', " + math + ", " + science + ", " + chemistry + ")");
	}
}