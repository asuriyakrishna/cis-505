/*
Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
Comprehensive Version (12th ed.). Pearson Education, Inc.
*/
package Module_1.FanApp;

/*
    * Fan class with constants, private data fields, constructors, accessor and mutator methods, and toString method.
 */
public class Fan {
    // Constants for fan speeds
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    // Private data fields
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // No-argument constructor that initializes the fan with default values
    public Fan() {
        this.speed = STOPPED;
        this.on = false;
        this.radius = 6;
        this.color = "white";
    } //end Fan method

    // Argument constructor
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    } //end Fan method with arguments

    // Get speed of fan
    public int getSpeed() {
        return speed;
    } // end of getSpeed method

    // Set speed of fan
    public void setSpeed(int speed) {
        this.speed = speed;
    } // end of setSpeed method

    // Get on/off status of fan
    public boolean isOn() {
        return on;
    } // end of isOn method

    public void setOn(boolean on) {
        this.on = on;
    }

    // Get radius of fan
    public double getRadius() {
        return radius;
    }   // end of getRadius method

    // Set radius of fan
    public void setRadius(double radius) {
        this.radius = radius;
    } // end of setRadius method

    // Get color of fan
    public String getColor() {
        return color;
    } // end of getColor method

    // Set color of fan
    public void setColor(String color) {
        this.color = color;
    } // end of setColor method

    // Override toString method
    @Override
    public String toString() {
        if (on) {
            return "set to " + speed + " with a color of " + color + " and a radius of " + radius;
        } else {
            return color + " with a radius of " + radius + " and the fan is off";
        }
    }
}
