package main.menu;

import main.Util;

public class Non_alcohol extends Drink{
    public Non_alcohol() {
        super(Util.Kind.NON_ALCOHOL, Util.getRandomDrinkName(), 2);
    }
}
