package ru.gb.java_core1.lesson6;

public class DemoApp {
    public static void main(String[] args){

        Animal catKusya = new Cat("Kusya");
        Animal dogSharik = new Dog("Sharik");
        Animal dogVasy = new Dog("Vasy");
        Animal catMursik = new Cat("Mursik");
        Animal catFedya = new Cat("Fedya");

        catKusya.run(20);
        dogSharik.run(600);
        catKusya.swim(50);
        dogSharik.swim(9);

        catMursik.run(300);;
        dogVasy.run(100);
        dogVasy.swim(20);



        System.out.println("Total animals: " + Animal.animals);
        System.out.println("Total cats: " + Cat.cats);
        System.out.println("Total dogs: " + Dog.dogs);

    }
}
