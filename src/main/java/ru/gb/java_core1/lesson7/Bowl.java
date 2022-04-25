package ru.gb.java_core1.lesson7;

public class Bowl {
    private int volume;

        public Bowl(int volume) {
            this.volume = volume;
        }

        public boolean decreaseFood(int howMuchEat) {
            if (howMuchEat < volume) {
                volume -= howMuchEat;
                System.out.println("Еды уменьшилось на " + howMuchEat + ", осталось " + volume);
                return true;
            }
            return false;
        }


        public void getVolume () {
            System.out.println("В тарелке осталось " + volume);
        }

        public void pourFood ( int food){
            volume += food;
            System.out.println("Тарелка пополнена на " + food);
        }
    }
