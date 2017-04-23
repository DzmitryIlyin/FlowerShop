package flowershop.datasource.hardcode;

import flowershop.flower.*;
import flowershop.datasource.FlowerProvider;

import java.util.HashMap;
import java.util.Map;

public class HCFlowerProvider implements FlowerProvider{

    private Map<String, Flower> storage = new HashMap<>();

    public HCFlowerProvider() {
        Rose rose = new Rose(10, 20, "red", 50);
        Tulip tulip = new Tulip(20, 40, "blue", 60);
        Lilac lilac = new Lilac(30, 30, "violet", 200);
        Decorative decorative = new Decorative(30, 30);
        storage.put(Rose.ROSE_FLOWER_NAME, rose);
        storage.put(Tulip.TULIP_FLOWER_NAME, tulip);
        storage.put(Lilac.LILAC_FLOWER_NAME, lilac);
        storage.put(Decorative.DECORATIVE_FLOWER, lilac);
    }

    @Override
    public Flower getFlowerByName(String name) {
        return storage.get(name);
    }
}
