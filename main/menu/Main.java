package main.menu;

import main.Util;

public class Main extends Dish{
    public Main() {
        super(Util.Kind.MAIN, Util.getRandomMainName(), 9);
    }

    @Override
    int getMinWeight() {
        return 400;
    }

    @Override
    int getMaxWeight() {
        return 800;
    }
}
