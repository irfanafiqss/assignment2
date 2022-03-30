package assignment2;

public class StudModel {
	
	//Variable declaration
	private int id;
	private String name;
	private String department;
	private int mathsMark;
	private int scienceMark;
	private int chemistryMark;
	
	

	//Accessor methods
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getMath() {
		return mathsMark;
	}
	
	public int getScience() {
		return scienceMark;
	}
	
	public int getChemistry() {
		return chemistryMark;
	}
	
	//Mutator methods
	public void setId(int id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setMathMark(int mathMark) {
		this.mathsMark = mathMark;
	}
	
	public void setScienceMark(int scienceMark) {
		this.scienceMark = scienceMark;
	}

	public void setChemistryMark(int chemistryMark) {
		this.chemistryMark = chemistryMark;
	}

}