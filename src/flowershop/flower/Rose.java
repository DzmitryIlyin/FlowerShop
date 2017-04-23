package flowershop.flower;

public class Rose extends OneFlower {


    public static final String ROSE_FLOWER_NAME = "Rose";

    public Rose (int flowerSize, int flowerPrice, String color, int petal){
        super (ROSE_FLOWER_NAME, flowerSize, flowerPrice, color, petal);
    }
}