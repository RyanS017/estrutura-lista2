package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        long time = System.nanoTime();
        //int[] v = {12, 25, 36, 72, 95, 85, 11, 69, 26, 47};
        //int[] v = {125, 268, 4567, 987, 654, 852, 346, 657, 124};
        int[] v = {12345, 65589, 24568, 69874, 14598, 56874, 36984, 65824, 65974};
        radixSort(v);
        System.out.println(Arrays.toString(v));
        long tempoFinal = System.nanoTime();

        System.out.println(tempoFinal - time);
    }
    static void radixSort(int[]v){
        int k = 10;
        List<Integer>[] lista = new ArrayList[k];
        for(int i = 0; i < lista.length;i++){
            lista[i] = new ArrayList<Integer>();
        }
        boolean bool = false;
        int temp = -1, pos = 1;
        while(!bool){
            bool = true;
            for (Integer i  : v){
                temp = i / pos;
                lista[temp%k].add(i);
                if(bool && temp > 0){
                    bool = false;
                }
            }
            int a = 0;
            for (int b = 0; b < k; b++){
                for (Integer i : lista[b]){
                    v[a++] = i;
                }
                lista[b].clear();
            }
            pos *= k;
        }
    }
}