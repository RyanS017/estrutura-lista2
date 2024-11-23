package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] v = {0,2,3,5,9,11,15,19,20,21};
        System.out.println("O indice encontrado foi: " + binarySearch(v,19));

    }

    static int binarySearch(int[] v, int numero){
        int inicio = 0;
        int fim = v.length-1;
        int meio = 0;
        while(inicio <= fim){
            meio = (inicio+fim) / 2;
            if(v[meio] == numero){
                return meio;
            }else if(v[meio]> numero){
                fim = meio-1;
            }else {
                inicio = meio+1;
            }
        }
        return -1;
    }
}