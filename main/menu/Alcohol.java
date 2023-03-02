package main.menu;

import main.Util;

public class Alcohol extends Drink{
    public Alcohol() {
        super(Util.Kind.ALCOHOL, Util.getRandomDrinkName(), 4);
    }
}