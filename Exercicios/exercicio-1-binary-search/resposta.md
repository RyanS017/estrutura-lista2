1 - o código se encontra em src/main/java/org.example
 
2 - precisa estar ordenada para que ele consiga chutar o valor corretamente, porque se um numero maior estiver na esquerda do chute, ele irá para a direita, fazendo com que ele nunca encontre o valor. Exemplo:  
[5, 8, 2, 3, 9, 15, 1, 6]  
Supondo que o valor que queiramos encontrar seja 8, conforme o algoritmo o primiero chute seria o indice 3, com o valor 3, e como 3 é menor que 8, ele desconsideraria do indice 3 até o inicio, ficando com:  
[9, 15, 1, 6]  
Assim, desconsiderando o indice do valor 8, fazendo com que não o encontre.
