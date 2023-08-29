package com.example.demo;

import java.util.Random;

public class Lab2 {

    public static int[] roll(int n){

        Random random = new Random();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(6) + 1;
        }

        return arr;
//        System.out.print("[");
//        for (int i = 0; i < arr.length; i++) {
//            try{
//                System.out.print(arr[i]);
//                if (i < arr.length - 1) {
//                    System.out.print(", ");
//                }
//            }catch (ArrayIndexOutOfBoundsException exception){
//                System.out.print(", index of array out of range");
//            }
//
//        }
//        System.out.println("]");
    }

    public static boolean containsDuplicates(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] == arr[j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static double[] temperatures(double[][] weeklyMonthTemperatures ){
        double[] arr = new double[weeklyMonthTemperatures.length];
        for (int i = 0; i < weeklyMonthTemperatures.length; i++) {
            double sum = 0;
            for (int j = 0; j < weeklyMonthTemperatures[i].length; j++) {
                sum += weeklyMonthTemperatures[i][j];
            }
            arr[i] = sum/weeklyMonthTemperatures[i].length;
        }
        return arr;
    }
}
