package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        //Médio caso
        int[] v1 = {2, 5, 6, 8, 9, 10, 13, 15, 16, 20, 23, 25, 28, 32, 35, 39, 50, 52, 55, 58,60};
        System.out.println("posição encontrada: " + interpolationSerach(v1, 10) + "\n");

        //Pior caso
        int[] v2 = {2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576};
        System.out.println("posição encontrada: " + interpolationSerach(v2,16384 ) + "\n");
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
}