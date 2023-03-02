package main.menu;

import main.Util;

public abstract class Drink extends Product{
    public Drink(Util.Kind kind, String name, int price) {
        super(Util.Type.DRINK, kind, name, price);
    }
}
