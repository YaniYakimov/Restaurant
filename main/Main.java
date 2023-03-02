package main;

import main.person.*;
import main.restaurant.Restaurant;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("При Пешо Таланта", "Geo Milev", 1000);
        Waiter waiter = null;
        for (int i = 0; i < 5; i++) {
            waiter = new Waiter();
            waiter.setRestaurant(restaurant);
            restaurant.hire(waiter);
        }
        Client client = null;
        for (int i = 0; i < 15; i++) {
            int chance = new Random().nextInt(0, 100);
            if(chance < 20) {
                client = new Vegan();
            }
            if(chance >= 20 && chance < 50) {
                client = new Student();
            }
            if(chance >= 50) {
                client = new Bandit();
            }
            client.setRestaurant(restaurant);
            restaurant.welcomeClient(client);
        }
        restaurant.startWorking();
        restaurant.printStat();
    }
}