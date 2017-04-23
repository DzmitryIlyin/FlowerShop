package flowershop.datasource;

import flowershop.flower.Flower;

public interface FlowerProvider {

    Flower getFlowerByName(String name);

}
