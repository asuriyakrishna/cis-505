package Module_1.FanApp;

/*
 * Test class for the Fan class.
 */
public class TestFanApp {
    public static void main(String[] args) {
        // Create fan using default constructor
        Fan fan1 = new Fan();

        // Create fan using argument constructor with constants
        Fan fan2 = new Fan(Fan.FAST, true, 10, "blue");

        // Display the objects
        System.out.println("Fan 1 (Default): " + fan1);
        System.out.println("Fan 2 (Custom): " + fan2);
    }
}
