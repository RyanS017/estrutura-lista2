1 - o código se encontra em src/main/java/org.example

| array                                                   | shell | hibbard | knuth | 
|---------------------------------------------------------|-------|---------|-------|
| 5, 9, 4, 3, 8, 12, 57, 39, 5, 29, 15, 37, 13, 16, 59, 6 | 59    | 50      | 58    |


O de shell que seria o original acaba por ser o mais lento, enquanto o de hibbard acaba se dando melhor. Mas acredito que isso é conforme o array proposto, e a decisão de qual gap usar esteja atrelada a como está o array a ser ordenado.

2- Cada sequência terá impacto na forma como os elementos são comparados e reorganizados, sequências muito curtas pode levar a um maior número de comparações, enquanto sequências muito longas levam o efeito contrário. A melhor sequência depende muito do caso, mas em geral a definição do intervalo afeta o número de comparações e trocas.

