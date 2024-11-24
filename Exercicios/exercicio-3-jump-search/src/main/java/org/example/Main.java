package org.example;
public class Main {
    public static void main(String[] args) {

    int[] v = {2, 5,6,8,9,16,19,21,23,25,28,29,37};
    System.out.println("Posição encontrada: " + jumpSearch(v,21));
    }
    static int jumpSearch(int[] v, int n){
       int salto = (int)Math.sqrt(v.length);
       int index = 0;
       while(v[Math.min(salto,v.length)-1] < n){
           index = salto;
           salto += (int)Math.sqrt((v.length));
           if(index >= v.length)
               return -1;
       }
       while(v[index] < n){
           index++;
           if(index == Math.min(salto,v.length))
               return -1;
       }
       if(v[index] == n)
           return index;
       return -1;
    }
}