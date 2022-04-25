package ru.gb.java_core1;

import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {

        //1
        int[] arr1 = {1,0,0,0,1,1,0,1,0,0,1,1};
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] == 1) arr1[i] = 0;
            else arr1[i] = 1;
        }
        System.out.println(Arrays.toString(arr1));

        //2
        int[] arr2 = new int[100];
        int a = 1;
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = a++;
        }
        System.out.println(Arrays.toString(arr2));

        //3
        int[] arr3 = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i = 0; i < arr3.length; i++) {
            if(arr3[i] < 6) arr3[i] = arr3[i] * 2;
        }
        System.out.println(Arrays.toString(arr3));

        //4
        int[][] arr4 = new int[5][5];
        for (int i = 0; i < arr4.length; i++) {
            for (int j = 0; j < arr4[i].length; j++) {
                if(i == j) arr4[i][j] = 1;
                if(i + j == arr4.length - 1)    arr4[i][j] = 1;
            }
        }

        for (int i = 0; i < arr4.length; i++) {
            System.out.println(Arrays.toString(arr4[i]));
        }

        //5
        int[] arr5 = arrayLen(10,2);
        System.out.println(Arrays.toString(arr5));

        //6
        int[] arr6 = {27,12,34,24,56,78,11,8,87,3,32,76};
        int min = arr6[0];
        int max = arr6[0];
        for (int i = 1; i < arr6.length; i++) {
            if (arr6[i] < min) min = arr6[i];
            if (arr6[i] > max) max = arr6[i];
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);

        //7
        // int[] arr7 = {2,2,2,1,2,2,10,1};
        int[] arr7 = {1,1,1,2,1};
        boolean result = halfSum(arr7);
        System.out.println(result);

        //8
        int[] arr8 = {1,2,3,4,5,6,7,8,9};

        int[] arr8new = displacement(arr8, 0);
        System.out.println(Arrays.toString(arr8new));


    }

    public static int[] arrayLen (int len, int initialValue){
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    public static boolean halfSum(int[] arr) {
        boolean result = false;
        double sum = 0;
        double halfSum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            halfSum += arr[i];
            if(halfSum == sum / 2)  result = true;
        }
        return result;
    }

    public static int[] displacement (int[] arr, int n) {
        n = n % arr.length;
        if(n < 0) n = arr.length + n;

        for (int j = 0; j < n; j++) {

            int a = arr[arr.length - 1];;

            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = a;
        }

        return arr;
    }


}
