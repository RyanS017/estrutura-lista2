package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] v1 = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 55, 58,60};
        System.out.println("posição encontrada: " + exponentialSearch(v1, 39));
    }
    static int binarySearch(int v[], int n, int low, int high){

        while(low <= high){
            int chute = (low+high) / 2;
            if(v[chute] == n)
                return chute;
            else if(v[chute] > n)
                high = chute-1;
            else
                low = chute + 1;
        }
        return -1;
    }
    static int exponentialSearch(int[] v, int n){
        if(v[0] == n)
            return n;
        int i = 1;
        while(v[i] <= n && i < v.length)
            i = i*2;
        return binarySearch(v,n,i/2, Math.min(i,v.length));
    }
}