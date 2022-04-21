package ru.gb.java_core2.lesson1;

public class Cat implements Mooving {
    private final int runDistance;
    private final int jumpDistance;

    public Cat(int runDistance, int jumpDistance) {
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
    }

    @Override
    public boolean run(int size) {
        if(size <= runDistance) {
            System.out.println("Cat running");
            return false;
        } else {
            System.out.println("Cat not running");
            return true;
        }
    }

    @Override
    public boolean jump(int size){
        if(size <= jumpDistance) {
            System.out.println("Cat jumping");
            return false;
        } else {
            System.out.println("Cat not jumping");
            return true;
        }
    }
}
