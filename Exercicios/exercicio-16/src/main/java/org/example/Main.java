package org.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Livro[] livros = {new Livro("978-65-5511-192-7", "O Senhor dos Áneis"), new Livro("978-65-5552-136-8", "O Pequeno Príncipe"), new Livro("978-65-991706-5-2", "Harry Potter"), new Livro("978-85-441-0370-8", "Crônicas de gelo e fogo dourado"), new Livro("978-85-441-0668-6", "As crônicas de gelo e fogo")};
    System.out.println("Livro encontrado: " + Livro.binarySearch(livros,"978-65-5552-136-8"));
    }

}