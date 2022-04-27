package ru.gb.java_core2.lesson3;


import java.util.*;

public class Application {


    public static void main(String[] args) {

        listExm();


    }

    private static void listExm() {

        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        HashMap<String, Integer> list3 = new HashMap<>();

        list.add("word");
        list.add("space");
        list.add("cat");
        list.add("dog");
        list.add("pen");
        list.add("map");
        list.add("tree");
        list.add("word");
        list.add("speed");
        list.add("word");
        list.add("rome");
        list.add("snikers");
        list.add("nuts");
        list.add("book");
        list.add("map");
        list.add("animal");


        for (String str : list) {
            int b = 0;
            for (String s : list) {
                if (str.equals(s)) {
                    b++;
                }
            }
            if (b == 1) {
                list2.add(str);
            } else {
                list3.put(str, b);
            }
            b = 0;
        }
        System.out.print("Список уникальных слов, которые встречаются 1 раз: ");
        System.out.println(list2);
        System.out.print("Список слов которые встречаются несколько раз и колличество их повторений: ");
        System.out.println(list3);

        }


        //   System.out.println(list);



    }

