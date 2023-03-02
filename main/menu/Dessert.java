package main.menu;

import main.Util;

public class Dessert extends Dish{
    public Dessert() {
        super(Util.Kind.DESERT, Util.getRandomDesertName(), 4);
    }

    @Override
    int getMinWeight() {
        return 200;
    }
    @Override
    int getMaxWeight() {
        return 300;
    }
}