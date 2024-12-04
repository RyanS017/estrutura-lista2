package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Aluno {
    private int nota;
    private String nome;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static void impressao(Aluno[] v){
        System.out.println(Arrays.toString(v));
    }

    @Override
    public String toString() {
        return nome + " nota: " + nota;
    }

    public Aluno(int nota, String nome) {
        if(nota <0 || nota >100){
            throw new IllegalArgumentException("Nota com valor invalida");
        }
        this.nota = nota;
        this.nome = nome;
    }

    private static void insertionSort(ArrayList<Aluno> v){
        for(int i = 0; i<v.size(); i++){
            int n = v.get(i).getNota();
            Aluno n1 = v.get(i);
            int j = i - 1;
            while(j >= 0 && v.get(j).getNota() > n) {
                v.set(j + 1, v.get(j));
                j--;
            }
            v.set(j+1, n1);
        }
    }
    static void bucketSort(Aluno v[]){
        int n = v.length;
        ArrayList<Aluno>[] bucket = new ArrayList[n];
        for(int i = 0; i<n;i++){
            bucket[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int bi = (int) (n*v[i].getNota())/100;
            bucket[bi].add(v[i]);
        }
        for(int i = 0; i<n;i++){
            insertionSort(bucket[i]);
        }
        int index = 0;
        for(int i = 0;  i < n; i++){
            for(int j = 0; j < bucket[i].size(); j++){
                v[index] = bucket[i].get(j);
                index++;
            }
        }
    }
    static Aluno interpolationSerach(Aluno[] v, int valor){
        if(v.length == 0){
            return null;
        }
        int baixo = 0;
        int alto = v.length - 1;
        int contador = 1;
        while (v[baixo].getNota() < v[alto].getNota() && valor <= v[alto].getNota() && valor >= v[baixo].getNota()){
            int meio = (int)Math.round((baixo + (double)((alto - baixo) * (valor - v[baixo].getNota())) / (v[alto].getNota() - v[baixo].getNota())));
            if(v[meio].getNota() == valor){
                //System.out.println("O número de tentativas foi: " + contador);
                return v[meio];
            }else if(valor < v[meio].getNota()){
                alto = meio - 1;
            }else{
                baixo = meio + 1;
            }
            contador++;
        }
        if(v[baixo].getNota() == valor){
            return v[baixo];
        }else{
            return null;
        }
    }
}
