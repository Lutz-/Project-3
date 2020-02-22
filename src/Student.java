/**
 * This class is the abstract parent class for the different types of Students.
 * @author Chris Zachariah (cvz2)
 * @author Anthony Topol (at877)
 */
public abstract class Student implements Comparable {
	private String fname;	// first name of the Student
	private String lname;	// last name of the Student
	protected int credit;	// the number of credits that are taken by the Student

	/**
	 * This is the parameterized Constructor of the Student class.
	 * @param fname is the first name
	 * @param lname is the last name
	 * @param credit is the number of credits taken by the student
	 */
	public Student(String fname, String lname, int credit)
	{
		this.fname = fname;
		this.lname = lname;
		this.credit = credit;
	} // Student()
	
	
	/**
	 * This method will compare two Students.
	 * @param obj is the Student that needs to be compared to the current Student
	 * @return 0 if the first and last name are the same, 1 if this > obj and -1 if this < obj
	 */
	public int compareTo(Object obj) 
	{
		return 0;
	} // compareTo()
	
	/**
	 * This method will be used to print and full name and number of credits for a specific Student.
	 * @return String containing fname, lname and credit hours
	 */
	public String toString() 
	{
		return this.fname + " " + this.lname + " " + this.credit;
	} // toString()

	//compute the tuition due; concrete implementation is required in the subclasses.
	/**
	 * This method will be used to compute the tuition that a specific Student must pay.
	 * @return the amount of tution that the student must pay
	 */
	public abstract int tuitionDue();
} // Student