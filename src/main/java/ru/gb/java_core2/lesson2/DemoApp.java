package ru.gb.java_core2.lesson2;



public class DemoApp {
    public static void main(String[] args) {

        String[][] array = new String[][] {
            {"1","2","a","4"},
            {"1","2","3","4"},
            {"1","b","3","4"},
            {"1","2","3","c"}
        };

        int sum = 0;

        try{
            sum = checkArray(array);
            System.out.println("Сумма чисел массива: " + sum);
        }   catch (MyArraySizeException e) {
            System.out.println("Неверный размер массива");
        }



    }

    public static int checkArray(String[][] array) throws MyArraySizeException {
        if(array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4){
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                try{
                    sum += transformation(array[i][j]);
                } catch (MyArrayDataException e){
                    System.out.println("В ячейке (" + i + "," + j + ") лежат неверные данные");
                }
            }
        }
        return sum;
    }


    public static int transformation(String number) throws MyArrayDataException {
       int a = 0;
        try{
            a = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException();
        }
        return a;

    }

}
