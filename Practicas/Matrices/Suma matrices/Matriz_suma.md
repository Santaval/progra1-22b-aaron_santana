# Suma valores de una matriz


Cree una matriz con un largo  y un ancho  los cuales son números enteros proporcionados mediante la entrada estándar en ese mismo orden. Los valores de largo y ancho deben ser guales (matriz cuadrada), en caso contrario aumente el valor mínimo hasta igualarlo con el valor máximo. Por ejemplo, si se tiene un largo de 3 y un ancho de 4 la longitud final de la matriz debe ser **4 x 4** donde los valores de cada una de la(s) filas o columnas agregadas bajo esta regla será igual a 0. Una vez creada la matriz realice en diferentes subrutinas los siguientes tareas: 
***
1) Lea de la entrada estándar los valores los cuales son de tipo int con lo que se rellenará la matriz. 
**Ejemplo de entrada junto con los valores de largo y ancho**
```
3 4
1 0 1 3
7 1 0 1
0 0 8 5
```

**Ejemplo de salida**
```
1 0 1 3
7 1 0 1
0 0 8 5
0 0 0 0
```

Nota: Como se observa en el ejmplo la última fila se rellena con **0** debido a que la longitud de la matriz proporcionada en la entrada es *3 x 4*, pero como se dijo anteriormente la matriz debe ser cuadrada, por lo tanto la longitud final es de **4 x 4** donde los valores de la fila (4) se rellenan con ceros debido a que esta fue la fila insertada para que se cumpliera la regla. 

***
2) Elabore una subrutina que sume los valores de cada una de las filas y los imprima por la salida estándar. Ejemplo: 

**Matriz de ejemplo**
```
1 0 1 3 
7 1 0 1
0 0 8 5
0 0 0 0
````
**Salida esperada** 
```
Fila #1: 5
Fila #2: 9
Fila #3: 13
Fila #4: 0

```

***
3) Elabore una subrutina que sume los valores de cada una de las columnas y los imprima por la salida estándar. Ejemplo: 

**Matriz de ejemplo**
```
1 0 1 3 
7 1 0 1
0 0 8 5
0 0 0 0
````
**Salida esperada** 
```
Columna #1: 8
Columna #2: 1
Columna #3: 9
Columna #4: 9
```


***
4) Elabore una subrutina que sume los valores de la diagonal principal (ver matriz de ejemplo, los valores en rojo representan la diagonal) y los imprima por la salida estándar. Ejemplo: 


**Matriz de ejemplo**

**<span style="color:red">**1**</span> 0 1 3   
7 <span style="color:red">**1**</span> 0 1   
0 0 <span style="color:red">**8**</span> 5  
0 0 0 <span style="color:red">**0**</span>**  



**Salida esperada** 
```
Diagonal principal: 10 
```


***
5) Elabore una subrutina que sume los valores de la diagonal inversa (ver matriz de ejemplo, los valores en rojo representan la diagonal) y los imprima por la salida estándar. Ejemplo: 


**Matriz de ejemplo**

1 0 1 <span style="color:red">**3**</span>   
7 1 <span style="color:red">**0**</span> 1  
0 <span style="color:red">**0**</span> 8 5  
<span style="color:red">**0**</span> 0 0 0



**Salida esperada** 
```
Diagonal inversa: 3
```


# Ejemplo

**Entrada**

```
3 4
1 0 1 3
7 1 0 1
0 0 8 5
```

**Salida** 

```
1 0 1 3 
7 1 0 1
0 0 8 5
0 0 0 0

Fila #1: 5
Fila #2: 9
Fila #3: 13
Fila #4: 0

Columna #1: 8
Columna #2: 1
Columna #3: 9
Columna #4: 9

Diagonal principal: 10 
Diagonal inversa: 3

```