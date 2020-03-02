/**
 This class makes the list of students.
 The methods are used to add to, remove from or print from the current list.
 @author Anthony Topol (at877)
 */

public class StudentList {
    private int SIZE_MOD = 4; //initial and grow size
    private int NOT_FOUND = -1;
    public Student[] list;
    public int numStudents; //int that keeps track of how many students are present in the list array

    /**
     * This is the default constructor where an array of Students will be initialized.
     */
    public StudentList(){
        list = new Student[SIZE_MOD];
    }

    /**
     * This private method is used to iterate through the list and find a specific student.
     * @param s is the Team Member to search for
     * @return index in the list array where the student is found or -1, the code if the student is not found
     */
    private int find(Student s)
    {
        for (int i = 0 ; i < list.length ; i++)
        {
            if ((list[i] != null) && (list[i].compareTo(s) == 0))
            {
                return i;
            }
        }
        return NOT_FOUND;
    }

    /**
     * This method will grow the total size of the list by the SIZE_MOD
     */
    public void grow(){
        Student[] newList = new Student[list.length + SIZE_MOD];

        for(int i=0; i<list.length; i++){ // move all current Students into new array
            newList[i] = list[i];
        }
        list = newList;
    }

    /**
     * This method will add a new student to the list as long as this person already does not exist in the team to begin with.
     * @param s is the new student to add
     */
    public boolean add(Student s){
        if(numStudents != 0 && find(s) != NOT_FOUND)
            return false;

        if(numStudents == list.length){
            grow();
        }
        list[numStudents] = s;
        numStudents++;
        return true;
    }

    /**
     * This method will remove a specific student.
     * @param s is the student to remove
     * @return true if the student has been removed, false otherwise
     */
    public boolean remove(Student s){
        if ((numStudents != 0) && find(s) != NOT_FOUND)
        {
            int place = find(s);

            if (place == (numStudents - 1))	// the last member in the array gets removed
            {
                list[place] = null;
                numStudents--;
                return true;
            }
            else
            {
                list[place] = null;
                list[place] = list[numStudents - 1];
                list[numStudents - 1] = null;
                numStudents--;
                return true;
            }
        }

        return false;

    }

    /**
     * This method will print out the current list of students.
     */
    public void print(){
        if (numStudents > 0){
            System.out.println("We have the following students: ");
            for(int i = 0 ; i < numStudents ; i++)
            {
                System.out.println(list[i].toString());
            }
            System.out.println("-- end of the list --");
        }
        else
            System.out.println("The list is empty!");
    }


}
