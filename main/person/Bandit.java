package main.person;

import main.Util;
import main.menu.Product;

import java.util.Optional;
import java.util.Random;
public class Bandit extends Client{
    public Bandit() {
        super(Util.getRandomName(), 50);
    }
    @Override
    public void makeOrder() {
        while(true) {
            Util.Type type;
            Util.Kind kind;
            if(new Random().nextBoolean()) {
                type = Util.Type.DISH;
                kind = Util.Kind.MAIN;
            }
            else {
                type = Util.Type.DRINK;
                kind = Util.Kind.ALCOHOL;
            }
            Optional<Product> product = getRestaurant().getMenu().get(type).get(kind).stream().findFirst();
            if(product.isPresent()) {
                if((getBill() + product.get().getPrice()) > 0.9 * getMoney()) {
                    break;
                }
                else {
                    addToBill(product.get().getPrice());
                    getRestaurant().removeProduct(product.get());
                }
            }
        }
        reduceMoney(getBill());
        setWaiter(getRestaurant().getRandomWaitress());
    }
}