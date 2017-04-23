package flowershop.bucket;

import flowershop.flower.Flower;

import java.util.ArrayList;
import java.util.List;

public class Bucket {

    private List<Flower> intBucket = new ArrayList<>();

    private int bucketSize;

    public Bucket(int bucketSize) {
        this.bucketSize = bucketSize;
    }

    public void addFlower(Flower flower) throws NoMoreSlotsException {
        int i = intBucket.size();
        if(i>bucketSize){
            throw new NoMoreSlotsException();
        }
        this.intBucket.add(flower);
    }

    public void removeFlower(Flower flower) throws NoSuchFlowerException {
        boolean isRemoved = this.intBucket.remove(flower);
        if (!isRemoved) {
            throw new NoSuchFlowerException();
        }
    }

    public void removeFlowerByIndex(String indexStr) throws WrongFlowerIndexException, NumberFormatException {
        int index = Integer.parseInt(indexStr);
        if (index > this.intBucket.size()) {
            throw new WrongFlowerIndexException();
        }
        this.intBucket.remove(index);
    }

    public int calcPrice() {
        int sum = 0;
        for (Flower fl : intBucket) {
            sum += fl.getFlowerPrice();
        }
        return sum;
    }

    public int getBucketSize(){
        return this.bucketSize;
    }

}