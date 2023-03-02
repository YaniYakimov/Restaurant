package main.restaurant;

import main.Util;
import main.menu.*;
import main.person.Client;
import main.person.Waiter;

import java.util.*;

public class Restaurant {
    private String name;
    private String address;
    private double money;
    private Map<Util.Type, Map<Util.Kind, Set<Product>>> menu = new HashMap<>();
    private Set<Waiter> waitress = new HashSet<>();
    private Set<Client> clients = new HashSet<>();
    public Restaurant(String name, String address, double money) {
        this.name = name;
        this.address = address;
        this.money = money;

        Salad salad = null;
        Main main = null;
        Dessert dessert = null;
        Alcohol alcohol = null;
        Non_alcohol nonAlcohol = null;
        for (int i = 0; i < 100; i++) {
            salad = new Salad();
            putToMenu(salad);
            main = new Main();
            putToMenu(main);
            dessert = new Dessert();
            putToMenu(dessert);
        }
        for (int i = 0; i < 200; i++) {
            alcohol = new Alcohol();
            putToMenu(alcohol);
            nonAlcohol = new Non_alcohol();
            putToMenu(nonAlcohol);
        }
    }
    private void putToMenu(Product product) {
        if(!menu.containsKey(product.getType())) {
            menu.put(product.getType(), new HashMap<>());
        }
        if(!menu.get(product.getType()).containsKey(product.getKind())) {
            menu.get(product.getType()).put(product.getKind(), new HashSet<>());
        }
        menu.get(product.getType()).get(product.getKind()).add(product);
    }
    public void hire(Waiter waiter) {
        waitress.add(waiter);
    }
    public void startWorking() {
        for(Client client : this.clients) {
            client.makeOrder();
            client.payBill();
        }
    }
    public void welcomeClient(Client client) {
        clients.add(client);
    }
    public Waiter getRandomWaitress() {
        Optional<Waiter> w = this.waitress.stream().skip(new Random().nextInt(0, this.waitress.size())).findFirst();
        if(w.isPresent()) {
            return w.get();
        }
        return null;
    }
    public void addMoney(double money) {
        this.money += money;
    }
    public void printStat() {
        printTotalMoney();
        printRichestWeitress();
        printSortRichestWeitress();
        printMenu();
    }
    private void printMenu() {
        System.out.println("Stat 4:");
        for (Map.Entry<Util.Type, Map<Util.Kind, Set<Product>>> entry : menu.entrySet()) {
            System.out.println(entry.getKey());
            for(Map.Entry<Util.Kind, Set<Product>> entry1 : entry.getValue().entrySet()) {
                System.out.println("\t" + entry1.getKey() +" - " + entry1.getValue().size());
            }
        }
    }
    private void printSortRichestWeitress() {
        System.out.println("Stat 3:");
        this.waitress.stream().sorted((o1, o2) -> Double.compare(o2.getTips(), o1.getTips()))
                .forEach(w -> System.out.println(w.getName() + " - " + w.getTips()));
    }
    private void printRichestWeitress() {
        System.out.println("Stat 2:");
        this.waitress.stream().sorted((o1, o2) -> Double.compare(o2.getTips(), o1.getTips())).limit(1)
                .forEach(w -> System.out.println(w.getName() + " - " + w.getTips()));
    }
    private void printTotalMoney() {
        System.out.println("Stat 1:");
        System.out.println("\t" + this.money);
    }

    public void removeProduct(Product product) {
        this.menu.get(product.getType()).get(product.getKind()).remove(product);
    }

    public Map<Util.Type, Map<Util.Kind, Set<Product>>> getMenu() {
        return menu;
    }
}