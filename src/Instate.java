/**
 * This is the In-State Student class that extends Student.
 * @author Chris Zachariah (cvz2)
 */
public class Instate extends Student 
{
	private int funds;
	
	public Instate(String fname, String lname, int credit, int funds)
	{
		super(fname, lname, credit);
		this.funds = funds;
	} // Instate()

	/**
	 * This method will be use to calculate the tuition due by this Student.
	 * @return the total tuition amount
	 */
	public int tuitionDue() 
	{
		return 0;
	} // tuitionDue()
	
	
	/**
	 * This method will print all the information about this Student.
	 * @return String with Name, Credits, Type and Funds about this Student
	 */
	@Override
	public String toString() 
	{
		String getNameAndCreds = super.toString();
		return getNameAndCreds + " , Student Type: In-State , Funds: $" + funds;
	} // toString()
	
	/**
	 * This is the test-bed main where the constructor and the methods will be tested.
	 * @param args 
	 */
	public static void main(String [] args)
	 {
	     Instate one = new Instate("Chris","Zachariah",12,0);
	     Instate ptr = one;
	     System.out.println(ptr.toString());
	     
	     Student One = new Instate("Chrisz","Z",12,0);
	     Student two = new Instate("Chrisa","Z",12,0);
			
	     System.out.println(One.compareTo(two));
	 } // main()
} // Instate
