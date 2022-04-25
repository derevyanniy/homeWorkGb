package ru.gb.java_core2.lesson1;

public class demoApp {
    public static void main(String[] args) {

        Mooving[] athletes = {                                 // создаем атлетов
                new Human(1500, 2),
                new Cat(500, 1),
                new Robot(10000, 5)
        };

        Obstacles[] obstacles = {                               // создали препятствия
                new Treadmill(1000),
                new Wall(2),
                new Treadmill(5000),
                new Wall(4)
        };

        for (Mooving athlete: athletes) {                //перебор атлетов

            for(Obstacles obstacle: obstacles) {            // перебор испытаний для каждого атлета
                if(obstacle instanceof Treadmill) {
                    if (athlete.run(obstacle.getDistance()))        // если бежать не может то прерываем цикл и не прыгаем
                        break;
                } else  if(obstacle instanceof Wall){

                   if (athlete.jump(obstacle.getWallHeight())) {    // если не может прыгнуть прерываем полосу препятствий
                       break;
                   }
                }
            }
        }
    }
}
