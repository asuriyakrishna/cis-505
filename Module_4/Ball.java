package Module_4;
/*
Product subclass named ball to represent a bowling ball.
*/
public class Ball extends Product {
    private String color;

    public Ball() {
        super();
        this.color = "";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Color: " + color;
    }
}
