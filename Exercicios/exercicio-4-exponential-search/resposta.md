1 - O código se encontra em src/main/java/org.example  
Esse algoritmo combina os saltos de jump search com a busca binaria, nos salto ao invés de saltar coforme um numero fixo
definido antes por $\sqrt{n}$, ele salta altráves de i = i*2, com i sendo 1 inicialmente. Na questão do binary search, ele se utiliza desse algoritmo para realizar a busca no intervalo encontrado pelos pulos.


2 - Em listas grandes, esse algoritmo é mais eficiente, por ele percorrer intervalos rapidamente, o que reduz o custo da busca binaria inicial. Mas em listas pequenas ele acaba por vezes ser menos eficiente do que a busca binaria pura, por uma de suas vantegens não ser utilizada, que é percorrer grandes intervalos, e esse cálculo inicial de intervalos em listas pequenas acaba por exigir um custo maior e desnecessário, tornando  o Binary Search melhor de se utilizar nessa situação. Concluindo, esse algoritmo é indicado para se utilizar quando sabe-se que há uma lista grande.