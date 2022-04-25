package ru.gb.java_core1.lesson7;

public class testApp {
    public static void main(String[] args) {


        Bowl bowl = new Bowl(30);
        Cat[] cats = new Cat[] {
                new Cat("Barsik", 9),
                new Cat("Murka", 12),
                new Cat("Vasya", 15),
                new Cat("Persik", 8),
                new Cat("Fedya", 20),
        };


        for (int i = 0; i < cats.length; i++) {
            cats[i].eating(bowl);
        }

        System.out.println();

        for (int i = 0; i < cats.length; i++) {
            if(cats[i].getSatiety()){
                System.out.println(cats[i].getName() + " сытый");
            } else {
                System.out.println(cats[i].getName() + " голодный");
            }
        }


        bowl.getVolume();

        bowl.pourFood(50);

        bowl.getVolume();

    }

}
