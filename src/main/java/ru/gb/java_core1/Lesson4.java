package ru.gb.java_core1;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    private static char[][] field;
    private static final char DOT_EMPTY = '.';
    private static final char DOT_PLAYER = 'X';
    private static final char DOT_AI = '0';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final int size_y = 5;
    private static final int size_x = 5;
    private static int scoreAI = 0;
    private static int scorePlayer = 0;

    public static void main(String[] args) {
        startGame();

    }

    private static boolean chooseFirst() {
        System.out.println("Who goes first? 'X' or '0' ");
        if(scanner.next().toLowerCase(Locale.ROOT).equals("x")){
            return true;
        }
        return false;
    }

    private static void startGame () {
        initField(size_y, size_x);
        drawField(size_y, size_x);
        if(chooseFirst()) {
            while (true) {
                PLAYER_MOVE();
               if (drawValidation(DOT_PLAYER, "Player")) {
                   scorePlayer++;
                   break;
               }
                AI_MOVE_PRINT();
                if (drawValidation(DOT_AI, "AI")) {
                    scoreAI++;
                    break;
                }
            }
            System.out.println("Игра закончена!");
        } else {
            while (true) {
                AI_MOVE_PRINT();
                if (drawValidation(DOT_AI, "AI")) {
                    scoreAI++;
                    break;
                }
                PLAYER_MOVE();
                if (drawValidation(DOT_PLAYER, "Player")) {
                    scorePlayer++;
                    break;
                }
            }

            System.out.println("Игра закончена!");
        }
        System.out.println("Score       Player      AI");
        System.out.printf("              %d         %d", scorePlayer, scoreAI);
        System.out.println();
        System.out.println("If you want play again enter 'Y'");
        if(scanner.next().toLowerCase(Locale.ROOT).equals("y")){
            startGame();
        } else {
            System.out.println("Bye Bye!");
        }


    }

    private static boolean drawValidation(char dot, String str) {
        drawField(size_y, size_x);
        if(checkWinning(dot)) {
            System.out.println("Win " + str);
            return true;
        }
        if(isFull()) {
            System.out.println("Ничья");
            return true;
        }
        return false;
    }

    public static void initField(int size_y, int size_x) {
        field = new char[size_y][size_x];
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                field[y][x] = DOT_EMPTY;
            }
        }
    }

    public static void drawField (int size_y, int size_x) {
        System.out.print("+");
        for (int i = 0; i < size_x * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();
        for (int i = 0; i < size_y; i++) {
            System.out.print(i+1 + "|");
            for (int j = 0; j < size_x; j++) {
                System.out.print(field[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void PLAYER_MOVE () {
        int x,y;
        do {
            System.out.println("Enter your move >>>");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        } while (!cellValid(y, x));

        field[y][x] = DOT_PLAYER;

    }

    public static boolean checkNextDotAI(int y, int x) {

        if(cellValid(y, x)) {
            field[y][x] = DOT_AI;
            if(checkWinning(DOT_AI)){
                field[y][x] = DOT_EMPTY;
                return true;
            }else {
                field[y][x] = DOT_EMPTY;
                return false;
            }
        }
        return false;
    }

    public static boolean checkNextDotPlayer(int y, int x) {

        if(cellValid(y, x)) {
            field[y][x] = DOT_PLAYER;
            if(checkWinning(DOT_PLAYER)){
                field[y][x] = DOT_EMPTY;
                return true;
            }else {
                field[y][x] = DOT_EMPTY;
                return false;
            }
        }
        return false;
    }

    public static void AI_MOVE_PRINT () {

            int[] arr = AI_MOVE_ANALIS();
            int y = arr[0];
            int x = arr[1];
            field[y][x] = DOT_AI;
        }

    public static int[] AI_MOVE_ANALIS () {

        int x,y;

            for (y = 0; y < size_y; y++) {          // поиск выигрышной клетки для ИИ
                for (x = 0; x < size_x; x++) {      // (если есть такая то ставит и выигрывает)
                    if (checkNextDotAI(y, x)) {
                        int[] arr = {y, x};
                        return arr;
                    }
                }
            }


            for (y = 0; y < size_y; y++) {          // поиск выигрышной клетки для Игрока
                for (x = 0; x < size_x; x++) {      // (если есть такая то ставит и блокирует выйгрыш игрока)
                    if (checkNextDotPlayer(y, x)) {
                        int[] arr = {y, x};
                        return arr;
                    }
                }
            }

            for (y = 0; y < size_y; y++) {              // если 2 клетки по горизонтали "Х" то ставит рядом "0",
                for (x = 0; x < size_x - 1; x++) {      //  блокируя развитие событий в этом направлении
                    if(field[y][x] == field[y][x + 1] && field[y][x] == DOT_PLAYER && cellValid(y,x+2)) {
                        int[] arr = {y, x + 2};
                        return arr;
                    }
                    else if (field[y][x] == field[y][x + 1] && field[y][x] == DOT_PLAYER && cellValid(y,x-1)){
                        int[] arr = {y, x - 1};
                        return arr;
                    }
                }
            }


            for (x = 0; x < size_x; x++) {          // аналогично с горизонталями, только по вертикали
                for (y = 0; y < size_y - 1; y++) {
                    if(field[y][x] == field[y + 1][x] && field[y][x] == DOT_PLAYER && cellValid(y + 2, x)) {
                        int[] arr = {y + 2, x};
                        return arr;
                    }
                    else if (field[y][x] == field[y + 1][x] && field[y][x] == DOT_PLAYER && cellValid(y -1, x)){
                        int[] arr = {y - 1, x};
                        return arr;
                    }
                }
            }

            for (y = 0; y <  size_y - 1; y++) {         // аналогично с горизонталями и вертикалями, для диагоналей
                for (x = 0; x < size_x - 1; x++) {
                    if(field[y][x] == field[y + 1][x + 1] && field[y][x] == DOT_PLAYER && cellValid(y + 2,x+2)) {
                        int[] arr = {y + 2, x + 2};
                        return arr;
                    }
                    else if (field[y][x] == field[y + 1][x + 1] && field[y][x] == DOT_PLAYER && cellValid(y - 1,x-1)){
                        int[] arr = {y - 1, x - 1};
                        return arr;
                    }
                }
            }


                do {                    // если нечего блокировать то просто рандомим
                    x = random.nextInt(size_x);
                    y = random.nextInt(size_y);
                } while (!cellValid(y, x));

            int[] arr = {y,x};
            return arr;

    }

    public static boolean cellValid(int y, int x) {
        return (x >= 0 && y >= 0 && x < size_x && y < size_y && field[y][x] == DOT_EMPTY);
    }

    public static boolean checkWinning (char symb) {        // логика на проверку победы из 4 символов в ряд

        for (int y = 0; y < size_y; y++) {          // цикл на проверку горизонтальных линий на выйгрыш
            for (int x = 0; x < 2; x++) {
                if(field[y][x] == symb && field[y][x] == field[y][x + 1] && field[y][x] == field[y][x + 2]  && field[y][x] == field[y][x + 3]) {
                    return true;
                }
            }
        }

        for (int x = 0; x < size_x; x++) {          // цикл на проверку вертикальных линий на выйгрыш
            for (int y = 0; y < 2; y++) {
                if(field[y][x] == symb && field[y][x] == field[y + 1][x] && field[y][x] == field[y + 2][x] && field[y][x] == field[y + 3][x]) {
                    return true;
                }
            }
        }


        for (int y = 0; y < 2; y++) {       // проверка диагоналей слева на право
            for (int x = 0; x < 2; x++) {
                if (field[y][x] == symb && field[y][x] == field[y + 1][x + 1] && field[y][x] == field[y + 2][x + 2] && field[y][x] == field[y + 3][x + 3]) {
                        return true;
                    }
                }
            }

        for (int y = 0; y < 2; y++) {      // проверка диагоналей справа на лево
            for (int x = 3; x < size_x; x++) {
                if(field[y][x] == symb && field[y][x] == field[y + 1][x - 1] && field[y][x] == field[y + 2][x - 2] && field[y][x] == field[y + 3][x - 3]){
                        return true;
                    }
                }
            }


        return false;
    }

    public static boolean isFull() {
        for (int y = 0; y < size_y; y++) {
            for (int x = 0; x < size_x; x++) {
                if(field[y][x] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}

