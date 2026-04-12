package Module_4;

/*
 Product subclass named bag to represent a bowling bag
*/
public class Bag extends Product {
    private String type;

    public Bag() {
        super();
        this.type = "";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
               "  Type: " + type;
    }
}
