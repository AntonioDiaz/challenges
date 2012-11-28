	Criba de Eratóstenes con Test-Driven Development (TDD) 
	http://www.solveet.com/exercises/Criba-de-Eratostenes-con-Test-Driven-Development-TDD/149

Aunque el algoritmo de la Criba de Eratóstenes es bastante sencillo de implementar, 
puede ser muy interesante desarrollarlo mediante TDD ya que nos da oportunidad de tomar algunas decisiones importantes y nos enseña 
cómo desarrollar con pruebas algoritmos.

En este caso, el algoritmo de la Criba de Eratóstenes calculará la lista de los números primos desde 2 hasta un número n indicado. 
Si no existiera ningún primo, el algoritmo devolverá una lista vacía. Los pasos del algoritmo se muestran a continuación de manera resumida.

1.	Se crea una lista con los números desde 2 hasta n.
2.	Se elige el siguiente número x no marcado (inicialmente el 2).
3.	Se marcan todos los múltiplos de dicho número (x2, x3, etc.).
4.	Se repite desde el paso 2.

Cuando se ha terminado con todos los números aquellos que queden sin marcar son primos. 
Más información sobre la criba de Eratóstenes en la Wikipedia: http://en.wikipedia.org/wiki/SieveofEratosthenes

Una vez terminado, es interesante plantearse cómo optimizar el algoritmo también aplicando TDD.

Un saludo