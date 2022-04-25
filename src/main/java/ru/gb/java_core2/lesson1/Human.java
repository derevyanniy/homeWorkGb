package ru.gb.java_core2.lesson1;

public class Human implements Mooving {
    private final int runDistance;
    private final int jumpDistance;

    public Human(int runDistance, int jumpDistance) {
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
    }

            @Override
    public boolean run(int size) {
        if(size <= this.runDistance) {
            System.out.println("Human running");
            return false;
        } else {
            System.out.println("Human not running");
            return true;
        }
            }

    @Override
    public boolean jump(int size){
        if(size <= jumpDistance) {
            System.out.println("Human jumping");
            return false;
        } else {
            System.out.println("Human not jumping");
            return true;
        }
    }
}
