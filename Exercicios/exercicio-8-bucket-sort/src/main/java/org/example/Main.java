package org.example;

import java.util.ArrayList;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        double[] arr = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434, 0.632, 0.82};
        bucketSort(arr);

        System.out.println("Sorted array is:");
        for (double num : arr) {
            System.out.print(num + " ");
        }
    }

    static void insertionSort(ArrayList<Double> v){
        for(int i = 0; i<v.size(); i++){
            double n = v.get(i);
            int j = i - 1;
            while(j >= 0 && v.get(j) > n) {
                v.set(j + 1, v.get(j));
                j--;
            }
            v.set(j+1, n);
        }
    }
    static void bucketSort(double v[]){
        int n = v.length;
        ArrayList<Double>[] bucket = new ArrayList[n];
        for(int i = 0; i<n;i++){
            bucket[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int bi = (int) (n*v[i]);
            bucket[bi].add(v[i]);
        }
        for(int i = 0; i<n;i++){
            insertionSort(bucket[i]);
        }
        int index = 0;
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < bucket[i].size(); j++){
                v[index] = bucket[i].get(j);
                index++;
            }
        }
    }
}