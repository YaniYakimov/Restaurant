package main.menu;

import main.Util;

public abstract class Product {
    private Util.Type type;
    private Util.Kind kind;
    private String name;
    private double price;

    public Product(Util.Type type, Util.Kind kind, String name, int price) {
        this.type = type;
        this.kind = kind;
        this.name = name;
        this.price = price;
    }
    public Util.Type getType() {
        return type;
    }

    public Util.Kind getKind() {
        return kind;
    }
    public double getPrice() {
        return price;
    }
}