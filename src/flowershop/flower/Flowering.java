package flowershop.flower;

public abstract class Flowering extends Flower {

    private String color;

    public Flowering(String flowerName, int flowerSize, int flowerPrice, String color) {

        super(flowerName, flowerSize, flowerPrice);
        this.color = color;
    }

    public String getColor() {

        return color;

    }

}