package ru.gb.java_core2.lesson1;

public class Treadmill extends Obstacles{
    private final int distance;

    public Treadmill(int distance) {
        this.distance = distance;
    }

    @Override
    public int getDistance() {
        return this.distance;
    }
}
