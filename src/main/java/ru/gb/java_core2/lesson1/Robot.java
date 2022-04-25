package ru.gb.java_core2.lesson1;

public class Robot implements Mooving {
    private final int runDistance;
    private final int jumpDistance;

    public Robot(int runDistance, int jumpDistance) {
        this.runDistance = runDistance;
        this.jumpDistance = jumpDistance;
    }

    @Override
    public boolean run(int size) {
        if(size <= runDistance) {
            System.out.println("Robot running");
            return false;
        } else {
            System.out.println("Robot not running");
            return true;
        }
    }

    @Override
    public boolean jump(int size){
        if(size <= jumpDistance) {
            System.out.println("Robot jumping");
            return false;
        } else {
            System.out.println("Robot not jump");
            return true;
        }
    }
}
