package flowershop.flower;

public abstract class OneFlower extends Flowering {

    private int petal;

    public OneFlower(String flowerName, int flowerSize, int flowerPrice, String color, int petal){
        super (flowerName, flowerSize, flowerPrice, color);
        this.petal = petal;
    }

    public int getPetal(){

        return petal;
    }
}

//flowershop.flower.OneFlower всегда ромашка, то в констр не нужно имя