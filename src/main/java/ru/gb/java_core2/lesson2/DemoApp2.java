package ru.gb.java_core2.lesson2;



public class DemoApp2 {

    public static String cell;

    public static void main(String[] args) {

        String[][] array = new String[][] {
                {"1","2","3","4"},
                {"1","2","$","4"},
                {"1","2","3","4"},
                {"1","f","3","4"}
        };

        int sum = 0;

        try{
            sum = checkArray(array);
            System.out.println("Сумма чисел массива: " + sum);
        }   catch (MyArraySizeException e) {
                System.out.println("Неверный размер массива");
        }   catch (MyArrayDataException e){
                System.out.println("В ячейке " + cell + " лежат неверные данные");
        }

    }




    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if(array.length != 4 || array[0].length != 4 || array[1].length != 4 || array[2].length != 4 || array[3].length != 4){
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                cell = String.valueOf(i) + "," + String.valueOf(j);
                    if(checkTransformation(array[i][j])) {
                        sum += Integer.parseInt(array[i][j]);
                    }
                cell = null;
            }
        }
        return sum;
    }


    public static boolean checkTransformation(String number) throws MyArrayDataException {

        int a = 0;
        try{
            a = Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            throw new MyArrayDataException();
        }


    }

}
