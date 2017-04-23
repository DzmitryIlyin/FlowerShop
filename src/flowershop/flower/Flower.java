package flowershop.flower;

public abstract class Flower {

    private String flowerName;
    private int flowerSize;
    private int flowerPrice;

    public Flower (String flowerName, int flowerSize, int flowerPrice){

        this.flowerName = flowerName;
        this.flowerSize = flowerSize;
        this.flowerPrice = flowerPrice;
    }

    public String getFlowerName() {
        return flowerName;
    }

    public int getFlowerSize() {
        return flowerSize;
    }

    public int getFlowerPrice() {
        return flowerPrice;
    }
}
