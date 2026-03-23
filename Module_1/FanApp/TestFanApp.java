package Module_1.FanApp;

/*
 * Test class for the Fan class.
 */
public class TestFanApp {
    public static void main(String[] args) {
        // Create fan using default constructor
        Fan fan1 = new Fan();

        // Create fan using argument constructor with constants
        Fan fan2 = new Fan(Fan.MEDIUM, true, 8.0, "Blue");

        // Display the objects
        System.out.println("The fan is " + fan1);
        System.out.println("The fan speed is " + fan2);
    }
}
