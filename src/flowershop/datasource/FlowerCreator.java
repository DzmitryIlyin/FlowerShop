package flowershop.datasource;

import flowershop.flower.*;

import java.lang.reflect.InvocationTargetException;

public class FlowerCreator {

    protected Flower createFlower(String name, Integer flowerSize, Integer flowerPrice, String color, Integer petal, Integer density) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (name.equals(Rose.class.getSimpleName())) {
            return (Flower) Class.forName(Rose.class.getName()).getConstructors()[0].newInstance(flowerSize, flowerPrice, color, petal);
        } if(name.equals(Tulip.class.getSimpleName())){
            return (Flower) Class.forName(Tulip.class.getName()).getConstructors()[0].newInstance(flowerSize, flowerPrice, color, petal);
        }else if(name.equals(Decorative.class.getSimpleName())){
            return (Flower) Class.forName(Decorative.class.getName()).getConstructors()[0].newInstance(flowerSize, flowerPrice);
        }else if(name.equals(Lilac.class.getSimpleName())){
            return (Flower) Class.forName(Lilac.class.getName()).getConstructors()[0].newInstance(flowerSize, flowerPrice, color, density);
        } else {
            return null;
        }
    }

    protected Integer getIntValue(String value){
        return value!=null?Integer.parseInt(value):null;
    }

}
