package ru.gb.java_core1;


public class lesson2 {
    public static void main(String[] args) {

        tenTwenty(5, 6);
        positive(-5);
        System.out.println(positiveNegative(10));
        print("learning java", 10);
        System.out.println(leapYear(1996));

    }

    public static boolean tenTwenty (int a, int b) {
        boolean var;
        if((a + b) >= 10 && (a + b) <= 20) {
            var = true;
        } else {
            var = false;
        }
        return var;
    }

    public static void positive (int a) {
        if (a >= 0) {
            System.out.println(a + " is Positive");
        } else {
            System.out.println(a + " is Negative");
        }
    }

    public static boolean positiveNegative (int a) {
        boolean var;
        if(a >= 0) {
            var = false;
        } else {
            var = true;
        }
        return var;
    }

    public static void print (String a, int b) {
        for (int i = 0; i < b; i++) {
            System.out.println(a);
        }
    }

    public static boolean leapYear (int year) {
        boolean var;
        if((year % 4 == 0) && (year % 100 != 0)){
            var = true;
        } else if (year % 400 == 0) {
            var = true;
        } else {
            var = false;
        }

        return var;
    }
}
