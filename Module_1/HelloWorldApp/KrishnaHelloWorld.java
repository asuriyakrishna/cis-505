/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
public class KrishnaHelloWorld {
    /* Method with 2 arguments that will print Hello World along with the provided first name and last name
    @param fName First Name
    @param lName Last Name
    @return print the results on console window
     */
    public static void myName(String fName, String lName) {
        System.out.println("Hello World from " + fName + " " + lName);
    } //end of myName method

    // Call to myName method with first name and last name as arguments
    public static void main(String[] args) {
        String fName = "Athira";
        String lName = "Krishna";
        myName(fName, lName);
    } //end of main method
} //end of KrishnaHelloWorld class
