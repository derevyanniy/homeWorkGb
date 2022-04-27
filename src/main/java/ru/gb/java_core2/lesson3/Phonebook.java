package ru.gb.java_core2.lesson3;

import java.util.ArrayList;

public class Phonebook{
    private final String surname;
    private final Integer phoneNumber;
    public static ArrayList<Phonebook> book = new ArrayList<>();

    public Phonebook(String surname, Integer phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public static void add(String name, Integer phoneNumber) {
        book.add(new Phonebook(name, phoneNumber));
    }

    public static void get (String name) {

        for (Phonebook phonebook : book) {
            if (name.equals(phonebook.getSurname())) {
                System.out.println(phonebook.getSurname() + " - " + phonebook.getPhoneNumber());
            }
        }

    }


    public static void main(String[] args) {

        Phonebook.add("Pupkin", 823425162);
        Phonebook.add("Vasechkin", 868793327);
        Phonebook.add("Kotov", 810987543);
        Phonebook.add("Rogov", 825481571);
        Phonebook.add("Kotov", 867433477);
        Phonebook.add("Dmitriev", 812319234);
        Phonebook.add("Pupkin", 851342347);


        Phonebook.get("Pupkin");
        System.out.println();
        Phonebook.get("Rogov");
        System.out.println();
        Phonebook.get("Kotov");

    }
}
