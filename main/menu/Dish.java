package main.menu;

import main.Util;

import java.util.Random;

public abstract class Dish extends Product{
    private int weight;
    public Dish(Util.Kind kind, String name, int price) {
        super(Util.Type.DISH, kind, name, price);
        this.weight = getWeight();
    }
    protected int getWeight() {
        return new Random().nextInt(getMinWeight(), getMaxWeight());
    }
    abstract int getMinWeight();
    abstract int getMaxWeight();
}