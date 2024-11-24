1 - o código se encontra em src/main/java/org.example  
O tamanho ideal de saltos para uma lista de tamanho n seria:
salto = sqrt(n)  



2-

| tamanho da lista | Binary Search<br/>O log(n) | Jump Search<br/> $\sqrt{n}$ | 
|------------------|----------------------------|-----------------------------|
| 10               | 4                          | 4                           |
| 50               | 6                          | 8                           |
| 100              | 7                          | 10                          |
| 500              | 9                          | 23                          |
| 1000             | 10                         | 32                          |
| 10000            | 14                         | 100                         |
| 50000            | 16                         | 224                         |

