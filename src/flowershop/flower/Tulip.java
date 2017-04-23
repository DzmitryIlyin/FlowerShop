package flowershop.flower;

public class Tulip extends OneFlower {


    public static final String TULIP_FLOWER_NAME = "Tulip";

    public Tulip (int flowerSize, int flowerPrice, String color, int petal){
        super (TULIP_FLOWER_NAME, flowerSize, flowerPrice, color, petal);
    }
}