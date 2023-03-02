package main.person;

import main.Util;
import main.menu.Product;

import java.util.Optional;
import java.util.Random;
public class Student extends Client{
    public Student() {
        super(Util.getRandomName(), 10);
    }
    @Override
    public void makeOrder() {
        while(true) {
            Util.Type type;
            Util.Kind kind;
            if(new Random().nextBoolean()) {
                type = Util.Type.DISH;
                int chance = new Random().nextInt(0, 3);
                switch (chance) {
                    case 0 -> kind = Util.Kind.SALAD;
                    case 1 -> kind = Util.Kind.MAIN;
                    default -> kind = Util.Kind.DESERT;
                }
            }
            else {
                type = Util.Type.DRINK;
                if(new Random().nextBoolean()) {
                    kind = Util.Kind.ALCOHOL;
                }
                else {
                    kind = Util.Kind.NON_ALCOHOL;
                }
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