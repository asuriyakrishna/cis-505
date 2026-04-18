package Module_4;

/*
ProductDB to represent the bowling shops database.
 */
public class ProductDB {
    public static GenericQueue<Product> getProducts(String code) {
        GenericQueue<Product> balls = new GenericQueue<Product>();

        if (code.equalsIgnoreCase("b")) {
            String[] colors = {
                "Black and Pink",
                "Red and Green",
                "Blue and Yellow",
                "White and Purple",
                "Orange and Black"
            };

            for (int i = 1; i <= 5; i++) {
                Ball ball = new Ball();
                ball.setCode("B100" + i);
                ball.setDescription("Black Widow " + i);
                ball.setPrice(49.99 + i);
                ball.setColor(colors[i - 1]);
                balls.enqueue(ball);
            }
        } else if (code.equalsIgnoreCase("s")) {
            for (int i = 1; i <= 5; i++) {
                Shoe shoe = new Shoe();
                shoe.setCode("S00" + i);
                shoe.setDescription("Bowling Shoe " + i);
                shoe.setPrice(29.99 + i);
                shoe.setSize(6.0 + i);
                balls.enqueue(shoe);
            }
        } else if (code.equalsIgnoreCase("a")) {
            for (int i = 1; i <= 3; i++) {
                Bag bag = new Bag();
                bag.setCode("A00" + i);
                bag.setDescription("Bowling Bag " + i);
                bag.setPrice(39.99 + i);
                bag.setType("Type " + i);
                balls.enqueue(bag);
            }
        }

        return balls;
    }
    
}
