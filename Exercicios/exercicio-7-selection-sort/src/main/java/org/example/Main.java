package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        int[] v = {63, 59, 24, 35, 38, 95, 25, 17, 5, 2, 3, 8, 69, 27};
        selection(v);
        for (int x : v) {
            System.out.printf(x + " ");
        }
    }
    static void selection(int[] v){
        for(int i = 0; i < v.length -1;i++){
            int min = i;
            for(int j = i+1; j < v.length;j++){
                if(v[min] > v[j])
                    min = j;
            }
            int temp = v[i];
            v[i] = v[min];
            v[min] = temp;
        }
    }
}