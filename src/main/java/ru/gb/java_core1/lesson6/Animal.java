package ru.gb.java_core1.lesson6;

public abstract class Animal {
    String name;
    static int animals;


    public Animal(String name){
        this.name = name;
        animals++;
    }

    abstract void run(int distance);

    abstract void swim(int distance);


}

