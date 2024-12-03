package org.example;

import java.lang.reflect.Array;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    String[] v = {"maçã", "bola", "casa", "sol", "lua", "gato", "cão", "carro", "árvore", "nuvem", "computador", "programador", "algoritmo", "inteligência", "artificial", "aprendizado", "máquina", "dados", "internet", "rede"};
    mergeSort(v,0,v.length-1);
    String[] v1 = {"maçã", "bola", "casa", "sol", "lua", "gato", "cão", "carro", "árvore", "nuvem", "computador", "programador", "algoritmo", "inteligência", "artificial", "aprendizado", "máquina", "dados", "internet", "rede"};
    quicksortmeio(v1,0,v1.length-1);
    System.out.println("Ordenação por mergesort: " + Arrays.toString(v));
    System.out.println("Ordenação por quicksort: " + Arrays.toString(v1));
    System.out.println("O index da palavra carro é: " + binarySearch(v, "carro"));
    }
    static int binarySearch(String[] v, String palavra){
        int inicio = 0;
        int fim = v.length-1;
        int meio = 0;
        while(inicio <= fim){
            meio = (inicio+fim) / 2;
            if(v[meio].compareTo(palavra) == 0){
                return meio;
            }else if(v[meio].compareTo(palavra) > 0){
                fim = meio-1;
            }else {
                inicio = meio+1;
            }
        }
        return -1;
    }
    static void quicksortmeio(String[] v, int c, int f){
        if(c >= f){
            return;
        }
        //pivo meio
        int m = (c + f) / 2;
        String pivo = v[m];
        int i = c;
        int j = f;
        while(true) {
            while (v[i].compareToIgnoreCase(pivo) < 0) {
                i++;
            }
            while (v[j].compareToIgnoreCase(pivo) > 0) {
                j--;
            }
            if(j <= i) {
                break;
            }
            String temp = v[i];
            v[i] = v[j];
            v[j] = temp;

        }
        quicksortmeio(v,c,j);
        quicksortmeio(v, j+1,f);
    }
    static void intercalar(String[] v, int c1, int f1, int c2, int f2){
        int tam = (f1 -c1 +1) + (f2-c2+1);
        String[] a = new String[tam];
        int i1 = c1;
        int i2 = c2;
        int k = 0;
        while(i1 <= f1 && i2 <= f2){
            //v[i1] <= v[i2]
            if(v[i1].compareToIgnoreCase(v[i2]) <= 0){
                a[k] = v[i1];
                i1++;
                k++;
            }else {
                a[k] = v[i2];
                i2++;
                k++;
            }
        }
        while(i1 <= f1){
            a[k] = v[i1];
            i1++;
            k++;
        }
        while(i2 <= f2){
            a[k] = v[i2];
            i2++;
            k++;
        }
        //k = 0;
        //for(int i = c1; i <= f2; i++){
        //  v[i] = a[k];
        k++;
        //}
        System.arraycopy(a,0,v,c1,a.length);
    }
    static void mergeSort(String [] v, int c, int f){
        if(c < f){
            int m = (c+f) /2;
            mergeSort(v, c, m);
            mergeSort(v, m+1, f);
            intercalar(v, c, m, m+1, f);
        }
    }
}