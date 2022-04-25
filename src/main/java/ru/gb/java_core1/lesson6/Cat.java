package ru.gb.java_core1.lesson6;

public class Cat extends Animal{
    static int cats;

    public Cat(String name) {
        super(name);
        cats++;
    }

    @Override
    void run(int distance){
        if(distance > 200) {
            System.out.println("This is too much for cat " + this.name);
        } else {
            System.out.println("Cat " + this.name + " run " + distance);
        }
    }

    @Override
    void swim(int distance){
        System.out.println("Cat " + this.name + " can't swim");
    }



}
