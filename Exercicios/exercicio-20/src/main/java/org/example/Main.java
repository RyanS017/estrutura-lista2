package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        escolha();
    }

    static void escolha(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escolha se deseja ordenar o seguinte vetor: \n25, 65, 84, 98, 24, 36, 12, 8, 7, 2, 6, 10, 38, 44" +
                "\n ou se deseja buscar um número no seguinte vetor: \n2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 55, 58,60\n" +
                "1 - para ordenar\n2 - para buscar");
        int n = sc.nextInt();
        if(n == 1){
            ordenacao();
        }else if(n == 2){
            busca();
        }else {
            System.out.println("Essa escolha não existe");
        }
    }
    static void ordenacao(){
        System.out.println("Escolha um dos seguintes algoritmos de ordenação: \n1 - Selection Sort: O (n^2)\n" +
                "2 - Merge Sort: O (n log n)\n3 - Quick Sort: O (n log n)\n" +
                "4 - Shell Sort: O (n log n) ou melhor que O (n^2)\n5 - Radix Sort: O (d *k)");
        int[] v = {25, 65, 84, 98, 24, 36, 12, 8, 7, 2, 6, 10, 38, 44};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        switch (n){
            case 1:
                selection(v);
                break;
            case 2:
                mergeSort(v, 0, v.length-1);
                break;
            case 3:
                quicksortmeio(v, 0, v.length-1);
                break;
            case 4:
                shellSort(v);
                break;
            case 5:
                radixSort(v);
                break;
            default:
                System.out.println("Não existe essa opção");
                return;
        }
        System.out.println("Array ordenado: \n"+Arrays.toString(v));
    }
    static void busca(){
        System.out.println("Escolha um dos seguintes algoritmos de ordenação: \n1 - Binary Search: O (log n)\n" +
                "2 - Interpolation Search: O (log log n)\n3 - Jump Search: O (sqrt(n))\n" +
                "4 - Exponential Search: O (log n)\n5 - Ternary Search: O (log3 n )");
        int[] v = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 55, 58,60};
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Agora escolha o número que deseja encontrar no seguinte vetor: \n" +
                "2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 55, 58,60");
        int number = sc.nextInt();
        int resu = -1 ;
        switch (n){
            case 1:
                resu = binarySearch(v,number);
                break;
            case 2:
                resu = interpolationSerach(v, number);
                break;
            case 3:
                resu = jumpSearch(v, number);
                break;
            case 4:
                resu = exponentialSearch(v,number);
                break;
            case 5:
                resu = ternarySearch(0,v.length-1,number,v);
                break;
            default:
                System.out.println("Não existe essa opção");
                return;
        }
        System.out.println("O número " + number + " se encontra na posição: " + resu);
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
    static int interpolationSerach(int[] v, int valor){
        if(v.length == 0){
            return -1;
        }
        int baixo = 0;
        int alto = v.length - 1;
        int contador = 1;
        while (v[baixo] < v[alto] && valor <= v[alto] && valor >= v[baixo]){
            int meio = (int)Math.round((baixo + (double)((alto - baixo) * (valor - v[baixo])) / (v[alto] - v[baixo])));
            if(v[meio] == valor){
                System.out.println("O número de tentativas foi: " + contador);
                return meio;
            }else if(valor < v[meio]){
                alto = meio - 1;
            }else{
                baixo = meio + 1;
            }
            contador++;
        }
        if(v[baixo] == valor){
            return baixo;
        }else{
            return - 1;
        }
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
    static int binarySearchex(int v[], int n, int low, int high){

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
        return binarySearchex(v,n,i/2, Math.min(i,v.length));
    }

    static void shellSort(int[] v){
        int contador = 0;
        int gap = 1;
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
        }
        System.out.println("Número de comparações: " + contador);
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

    static int ternarySearch(int l, int r, int number, int ar[])
    {
        if (r >= l) {
            int mid1 = l + (r - l) / 3;
            int mid2 = r - (r - l) / 3;
            if (ar[mid1] == number) {
                return mid1;
            }
            if (ar[mid2] == number) {
                return mid2;
            }
            if (number < ar[mid1]) {
                return ternarySearch(l, mid1 - 1, number, ar);
            }
            else if (number > ar[mid2]) {
                return ternarySearch(mid2 + 1, r, number, ar);
            }
            else {
                return ternarySearch(mid1 + 1, mid2 - 1, number, ar);
            }
        }
        return -1;
    }


}