package org.example;

import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] v = {25, 65, 84, 98, 24, 36, 12, 8, 7, 2, 6, 10, 38, 44};
        quicksortcomeco(v, 0, v.length-1);
        System.out.println(Arrays.toString(v));
        int[] v1 = {25, 65, 84, 98, 24, 36, 12, 8, 7, 2, 6, 10, 38, 44};
        quicksortmeio(v1, 0, v.length-1);
        System.out.println(Arrays.toString(v1));
    }
    static void quicksortmeio(int[] v, int c, int f){
        if(c >= f){
            return;
        }
        //pivo meio
        int m = (c + f) / 2;
        int pivo = v[m];
        int i = c;
        int j = f;
        while(true) {
            while (v[i] < pivo) {
                i++;
            }
            while (v[j] > pivo) {
                j--;
            }
            if(j <= i) {
                break;
            }
            int temp = v[i];
            v[i] = v[j];
            v[j] = temp;

        }
        quicksortmeio(v,c,j);
        quicksortmeio(v, j+1,f);
    }

    static void quicksortcomeco(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }

        int pivot = arr[low];
        int st = low;
        int end = high;
        int k = high;
        for (int i = high; i > low; i--) {
            if (arr[i] > pivot) {
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
                k--;
            }
        }
        int temp = arr[low];
        arr[low] = arr[k];
        arr[k] = temp;
        quicksortcomeco(arr, low, k - 1);
        quicksortcomeco(arr, k + 1, high);

    }
}