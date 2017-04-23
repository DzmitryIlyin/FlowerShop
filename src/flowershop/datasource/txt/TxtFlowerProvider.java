package flowershop.datasource.txt;

import flowershop.datasource.FlowerCreator;
import flowershop.flower.*;
import flowershop.datasource.FlowerProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TxtFlowerProvider extends FlowerCreator implements FlowerProvider{

    private static final int NAME_COL_INDEX = 0;
    private static final int SIZE_COL_INDEX = 1;
    private static final int PRICE_COL_INDEX = 2;
    private static final int COLOR_COL_INDEX = 3;
    private static final int PETAL_COL_INDEX = 4;
    private static final int DENSITY_COL_INDEX = 5;
    private static final String FLOWERS_TXT_NAME = "./FlowersList.txt";

    private Map<String, Flower> storage = new HashMap<>();

    public TxtFlowerProvider() {
        try {
            List<Flower> flowers = readTextDoc();
            for(Flower flower:flowers){
                storage.put(flower.getFlowerName(), flower);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<Flower> readTextDoc() throws Exception {
        List<Flower> result = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FLOWERS_TXT_NAME))){
            String l;
            while((l=br.readLine())!=null){
                String [] tokens = l.split(",");
                String name = tokens[NAME_COL_INDEX];
                String size = tokens[SIZE_COL_INDEX];
                String price = tokens[PRICE_COL_INDEX];
                String color = tokens[COLOR_COL_INDEX];
                String petal = tokens[PETAL_COL_INDEX];
                String density = tokens[DENSITY_COL_INDEX];
                result.add(createFlower(name, getIntValue(size), getIntValue(price), color, getIntValue(petal), getIntValue(density)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public Flower getFlowerByName(String name) {
        return storage.get(name);    }
}