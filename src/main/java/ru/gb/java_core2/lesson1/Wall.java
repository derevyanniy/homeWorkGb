package ru.gb.java_core2.lesson1;

public class Wall extends Obstacles {
    private final int wallHeight;

    public Wall (int wallHeight){
        this.wallHeight = wallHeight;
    }

    @Override
    public int getWallHeight() {
        return this.wallHeight;
    }
}
