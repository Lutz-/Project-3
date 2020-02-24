/**
 * This class is the abstract parent class for the different types of Students.
 * @author Chris Zachariah (cvz2)
 */
public abstract class Student implements Comparable 
{
	private String fname;
	private String lname;
	protected int credit;
	
	public final int PART_FULL_THRESHOLD = 12; // < 12 is part-time and >= 12 is full time
	public final int PART_TIME_STUD_FEE = 846;
	public final int FULL_TIME_STUD_FEE = 1441;
	
	public final int CREDIT_PAYMENT_MAX = 15; // Max amount of credits that the students can pay for

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
	 * This method will compare two Students. Comparisons start with last name and then first name.
	 * @param obj is the Student that needs to be compared to the current Student
	 * @return 0 if the first and last name are the same, 1 if this > obj and -1 if this < obj 
	 */
	public int compareTo(Object obj) 
	{
		Student ptr = (Student) obj;
		if ((this.lname.equals(ptr.lname)) && (this.fname.equals(ptr.fname)))
		{
			return 0;
		}
		else if (((this.lname.compareTo(ptr.lname)) > 0) || ((this.fname.compareTo(ptr.fname)) > 0))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	} // compareTo()
	
	/**
	 * This method will be used to print and full name and number of credits for a specific Student.
	 * @return String containing fname, lname and credit hours
	 */
	public String toString() 
	{
		return "Name: " + this.fname + " " + this.lname + " , Credits: " + this.credit;
	} // toString()

	/**
	 * This method will be used to compute the tuition that a specific Student must pay.
	 * @return the amount of tuition that the student must pay
	 */
	public abstract int tuitionDue();
} // Student