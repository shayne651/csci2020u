public class StudentRecord 
{
	private String ID;
	private char Grade;
	private float Assign,Midterm,Final;
	private double total;

	public StudentRecord(String ID, float Assignment, float Midterm, float Final)
	{
		this.ID=ID;
		this.Assign=Assignment;
		this.Midterm=Midterm;
		this.Final=Final;
		total = ((Assign*.2)+(Midterm*.3)+(Final*.5));
		if (total>80){Grade='A';}
		else if (total>70){Grade='B';}
		else if (total>60){Grade='C';}
		else if (total>50){Grade='D';}
		else {Grade = 'F';}
	}
	public String getID(){return ID;}
	public float getAssign(){return Assign;}
	public float getMidterm(){return Midterm;}
	public float getFinal(){return Final;}
	public char getGrade(){return Grade;}

	public void setID(String ID){this.ID=ID;}
	public void setMidterm(float Midterm){this.Midterm=Midterm;}
	public void setAssign(float Assignment){this.Assign=Assignment;}
	public void setFinal(float Final){this.Final=Final;}
}