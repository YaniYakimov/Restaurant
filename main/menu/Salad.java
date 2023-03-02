package main.menu;

import main.Util;


public class Salad extends Dish{
    public Salad() {
        super(Util.Kind.SALAD, Util.getRandomSaladName(), 5);
    }
    @Override
    int getMinWeight() {
        return 300;
    }
    @Override
    int getMaxWeight() {
        return 600;
    }
}