package ru.gb.java_core1.lesson7;

public class Cat {
    private String name;
    private int howMuchEat;
    private boolean satiety;

    public Cat (String name, int howMuchEat) {
        this.name = name;
        this.howMuchEat = howMuchEat;
    }

    public void eating (Bowl bowl) {
        if(bowl.decreaseFood(howMuchEat)) {
            System.out.println(name + " наелся");
            satiety = true;
        } else  {
            System.out.println(name + " не покушал, еды мало");
        }
    }

    public String getName(){
        return this.name;
    }

    public boolean getSatiety() {
        return satiety;
    }


}
