package main.person;

import main.Util;
import main.menu.Product;
import main.restaurant.Restaurant;

import java.util.Optional;
import java.util.Random;

public abstract class Client {
    private String name;
    private double initialMoney;
    private double money;
    private double bill;
    private Restaurant restaurant;
    private Waiter waiter;
    public Client(String name, double money) {
        this.name = name;
        this.initialMoney = money;
        this.money = initialMoney;
    }
    public abstract void makeOrder();
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    public double getMoney() {
        return money;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }
    public void reduceMoney(double money) {
        this.money -= money;
    }
    public double askForBill() {
        return this.bill;
    }
    public void payBill() {
        this.restaurant.addMoney(this.bill);
        if(new Random().nextInt(0, 10) < 8) {
            double tips = new Random().nextDouble(0.05, 0.1);
            this.waiter.addTips(tips*this.bill);
            this.money -= tips;
        }
    }
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
    public void addToBill(double money) {
        this.bill += money;
    }
    public double getBill() {
        return bill;
    }
}