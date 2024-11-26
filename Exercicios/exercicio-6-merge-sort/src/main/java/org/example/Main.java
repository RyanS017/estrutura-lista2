package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] v = {63,59,24,35,38,95,25,17,5,2,3,8,69,27};
        mergeSort(v,0,v.length-1);
        for(int x : v){
            System.out.printf(x + " ");
        }

        }
        static void intercalar(int[] v, int c1, int f1, int c2, int f2){
            int tam = (f1 -c1 +1) + (f2-c2+1);
            int[] a = new int[tam];
            int i1 = c1;
            int i2 = c2;
            int k = 0;
            while(i1 <= f1 && i2 <= f2){
                if(v[i1] <= v[i2]){
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
    static void mergeSort(int [] v, int c, int f){
        if(c < f){
            int m = (c+f) /2;
            mergeSort(v, c, m);
            mergeSort(v, m+1, f);
            intercalar(v, c, m, m+1, f);
        }
    }
}