package org.example;

import java.util.HashMap;

public class Livro {
    private String nome;
    private String ISBM;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getISBM() {
        return ISBM;
    }

    public void setISBM(String ISBM) {
        this.ISBM = ISBM;
    }

    public Livro(String ISBM, String nome) {
        this.nome = nome;
        this.ISBM = ISBM;
    }

    static String binarySearch(Livro[] v, String isbm){
        int inicio = 0;
        int fim = v.length-1;
        int meio = 0;
        while(inicio <= fim){
            meio = (inicio+fim) / 2;
            if(v[meio].getISBM().compareTo(isbm) == 0){
                return v[meio].getNome();
            }else if(v[meio].getISBM().compareTo(isbm) > 0){
                fim = meio-1;
            }else {
                inicio = meio+1;
            }
        }
        return "-1";
    }
}
