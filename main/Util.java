package main;

import java.util.Random;

public class Util {

    public enum Type { DISH, DRINK }
    public enum Kind { SALAD, MAIN, DESERT, ALCOHOL, NON_ALCOHOL }
    public static String[] salad = { "Sis", "Sidhf", "Iggds", "Ufkdwfi", "Ugfrg", "Ngffdg", "Uhee", "Ugecd", "Tgdfe", "Bfdvd" };
    public static String[] main = { "Ugffc", "Ibdd", "Ufgs", "Terew", "Ijgfc", "Ivcxc", "Ihff", "Udfvs", "Obvfevfsd", "Ucssd" };
    public static String[] desert = { "Rvfds", "Eiuhg", "Fuigu", "Guigh", "Sihg", "Ebvd", "Xihu", "Eidcds", "Dgnr", "Wgdb" };
    public static String[] drink = {"Suh", "Jfdw", "Hwfw", "Hhuh", "Wgygs", "Gqewj", "Gjc", "Qiohj", "Ijsi", "JUnc", "IJjdsj", "HJpokd"};
    public static String[] name = {"Goshko", "Ivancho", "Mariika", "Petranka", "Kircho", "Joanka", "Keranka", "Manolcho"};
    public static  String getRandomSaladName() {
        return salad[new Random().nextInt(0, salad.length)];
    }
    public static  String getRandomMainName() {
        return main[new Random().nextInt(0, main.length)];
    }
    public static  String getRandomDesertName() {
        return desert[new Random().nextInt(0, desert.length)];
    }
    public static  String getRandomDrinkName() {
        return drink[new Random().nextInt(0, drink.length)];
    }
    public static  String getRandomName() {
        return name[new Random().nextInt(0, name.length)];
    }
}
