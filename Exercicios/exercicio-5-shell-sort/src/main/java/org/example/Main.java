package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    int[] v = {5,9,4,3,8,12,57,39,5,29,15,37, 13, 16, 59, 6};
    shellSort(v);
    for( int e : v){
        System.out.printf(e + ", ");
    }

    }
    static void shellSort(int[] v){
        int contador = 0;
        int gap = 1;
        //int gap = (int)v.length/2;
        while(gap <= v.length)
          gap = 2 * gap;
        gap = gap/2 - 1;
        while(gap > 0){
            for(int i = gap; i < v.length; i += gap){
                int x = v[i];
                int j = i - gap;
                contador++;
                while(j >= 0 && v[j] > x){
                    v[j + gap] = v[j];
                    j-=gap;
                    contador++;
                }
                v[j + gap] = x;
            }
           gap /=2;
        //gap /=3;
        }
        System.out.println("Número de comparações: " + contador);
    }
}