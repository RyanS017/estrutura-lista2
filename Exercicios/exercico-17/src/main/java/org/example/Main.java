package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
    Aluno[] alunos = {new Aluno(15,"João"), new Aluno(7, "Alice"), new Aluno(37,"Alex"), new Aluno(98, "Lucas"), new Aluno(69, "Raphael"), new Aluno(24,"Bruno"),new Aluno(52,"Amanda"), new Aluno(3,"Pedro"), new Aluno(65,"Ryan")};
    Aluno.bucketSort(alunos);
    Aluno.impressao(alunos);
    System.out.println(Aluno.interpolationSerach(alunos,37));
    }
}