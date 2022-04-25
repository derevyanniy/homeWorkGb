package ru.gb.java_core1.lesson6;

public class Dog extends Animal{
    static int dogs;

    public Dog(String name) {
        super(name);
        dogs++;
    }

    @Override
    void run(int distance){
        if(distance > 500) {
            System.out.println("This is too much for dog " + this.name);
        } else {
            System.out.println("Dog " + this.name + " run " + distance);
        }
    }

    @Override
    void swim(int distance){

        if(distance > 10) {
            System.out.println("This is too much for dog " + this.name);
        } else {
            System.out.println("Dog " + this.name + " swim " + distance);
        }
    }


}
