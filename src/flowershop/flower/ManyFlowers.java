package flowershop.flower;

public abstract class ManyFlowers extends Flowering{

    private int density;

    public ManyFlowers(String flowerName, int flowerSize, int flowerPrice, String color, int density){
        super (flowerName, flowerSize, flowerPrice, color);
        this.density = density;
    }

}