import java.util.Scanner;
/**
 * This class is called when running the program.
 * The methods are the different commands that can be run to change the set of team members.
 @author Anthony Topol (at877)
 */

public class TuitionManager {
    Scanner stdin;
    StudentList cs213;

    /**
     * This method will be used to run the main program. The rest of the private methods
     * are the accepted commands that will be used to manipulate the list of students.
     */
    public void run()
    {
        System.out.println("New Student List Created. Awaiting Input:");
        stdin = new Scanner(System.in);
        cs213 = new StudentList();

        boolean done = false;
        while (!done)
        {
            String command = stdin.next();
            switch (command.charAt(0))
            {
                case 'I': addInstate();
                    break;
                case 'O': addOutstate();
                    break;
                case 'N': addInternational();
                    break;
                case 'R': remove();
                    break;
                case 'P': print();
                    break;
                case 'Q': print(); done = !done; // terminate the program
                    break;
                case 'a': System.out.println("Command '"+ command.charAt(0) +"' is not supported!"); command = stdin.next(); command = stdin.next();
                    break;
                case 'r': System.out.println("Command '"+ command.charAt(0) +"' is not supported!"); command = stdin.next(); command = stdin.next();
                    break;
                default: System.out.println("Command '"+ command.charAt(0) +"' is not supported!");	//deal with bad command here
            } // ends the switch statement
        } // ends the while loop
        System.out.println("Student Input Complete.");
        stdin.close();
    } // run()

    /**
     * This method will be used to add new in-state students.
     * The members must not already be on the team and the condition of part-time students not having funding.
     */
    private void addInstate()
    {
        String fname;
        fname = stdin.next();

        String lname;
        lname = stdin.next();

        String creditS;
        creditS = stdin.next();
        int credit = Integer.parseInt(creditS);

        String fundingS;
        fundingS = stdin.next();
        int funding = Integer.parseInt(fundingS);
        if(funding > 0 && credit < 12) { //Credit load deemed part time is under 12 credits
            System.out.println("Instate Part-Time Students are ineligible for funding. Invalid input, please correct and reinput");
            return;
        }

        Instate newStudent = new Instate(fname,lname,credit,funding);
        cs213.add(newStudent);

    } // addInstate()

    /**
     * This method will be used to add new out-of-state students.
     * The members must not already be on the team.
     */
    private void addOutstate()
    {
        String fname;
        fname = stdin.next();

        String lname;
        lname = stdin.next();

        String creditS;
        creditS = stdin.next();
        int credit = Integer.parseInt(creditS);

        String tristateS;
        tristateS = stdin.next();

        boolean tristate;
        System.out.println(tristateS);
        if(tristateS.equals("T")) {
            tristate = true;
            Outstate newStudent = new Outstate(fname, lname, credit, tristate);
            cs213.add(newStudent);
            return;
        }
        if(tristateS.equals("F")) {
            tristate = false;
            Outstate newStudent = new Outstate(fname, lname, credit, tristate);
            cs213.add(newStudent);
            return;
        }

        System.out.println("Invalid command input. For Tristate status T = true, F = false. Please reinput and try again.");

    } //addOutstate()

    /**
     * This method will be used to add new international students.
     * The student must not already be on the team and the condition of exchange students having more than 9 credits must be met.
     */
    private void addInternational()
    {
        String fname;
        fname = stdin.next();

        String lname;
        lname = stdin.next();

        String creditS;
        creditS = stdin.next();
        int credit = Integer.parseInt(creditS);

        String exchangeS;
        exchangeS = stdin.next();
        if(exchangeS.equals("T"))
            exchangeS = "true";
        else if(exchangeS.equals("F"))
            exchangeS = "false";
        else{
            System.out.println("Invalid input for exchange status please correct and reinput. T = true, F = false");
            return;
        }
        boolean exchange = Boolean.parseBoolean(exchangeS);

        if(exchange && credit<9) { //9 is the credit amount that exchange students must meet
            System.out.println("International Exchange Students must enroll at least 9 credit hours. Invalid input please correct and reinput.");
            return;
        }

        International newStudent = new International(fname,lname,credit,exchange);
        cs213.add(newStudent);
    } //addInternational()

    /**
     * This method will be used to remove students from the list.
     * The student must be in the team to be removed.
     */
    private void remove()
    {
        String fname;
        fname = stdin.next();

        String lname;
        lname = stdin.next();

        for(int i=0; i<cs213.numStudents; i++){
            Student current = cs213.list[i];
            if(current.compareTo(new Instate(fname, lname,0,0)) ==0 )
                cs213.remove(current);
        }

    } // remove()

    /**
     * This method will print the current members in the team.
     */
    private void print()
    {
        cs213.print();
    } // print()
}
