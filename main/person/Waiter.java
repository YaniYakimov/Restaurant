package main.person;

import main.Util;
import main.restaurant.Restaurant;

public class Waiter {
    private String name;
    private double tips;
    private Restaurant restaurant;
    public Waiter() {
        this.name = Util.getRandomName();
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public void addTips(double tips) {
        this.tips += tips;
    }
    public double getTips() {
        return tips;
    }
    public String getName() {
        return name;
    }
}