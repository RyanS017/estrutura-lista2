package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[])
    {

        int v[] = { 1, 5, 9, 26, 45, 85, 120, 250, 698, 1000 };


        System.out.println( "Index encontrado: " + ternarySearch(0, v.length-1, 85, v));

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