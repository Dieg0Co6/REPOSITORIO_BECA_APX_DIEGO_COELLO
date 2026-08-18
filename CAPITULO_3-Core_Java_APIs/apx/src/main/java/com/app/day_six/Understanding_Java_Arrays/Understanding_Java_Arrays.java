package main.java.com.app.day_five.Understanding_Java_Arrays;

import java.util.Arrays;

public class Understanding_Java_Arrays {

    public static void main(String[] args) {
        //Un arreglo es un área de memoria en el heap con espacio para un número designado de elementos.
        //Un String se implementa como un arreglo con algunos métodos que podrías querer usar cuando trabajas
        //específicamente con caracteres.

        //Un StringBuilder se implementa como un arreglo donde el objeto arreglo se reemplaza por un nuevo objeto
        //arreglo más grande cuando se queda sin espacio para almacenar todos los caracteres. 

        char[] letters;

        //char es un tipo primitivo. Pero char es lo que va dentro del arreglo y no el tipo del arreglo en sí.
        //El arreglo en sí es de tipo char[]. Puedes leer mentalmente los corchetes ([]) como “arreglo”.
        //En otras palabras, un arreglo es una lista ordenada. Puede contener duplicados.
        Understanding_Java_Arrays understanding_Java_Arrays = new Understanding_Java_Arrays();
        understanding_Java_Arrays.Multidimensional_Arrays();

    }

    public void Multidimensional_Arrays(){

        //Los arreglos son objetos, y por supuesto, los componentes de un arreglo pueden ser objetos.
        //ESO QUIERE DECIR QUE LOS ARREGLOS PUEDEN CONTENER COMO ELEMENTOS OTROS ARREGLOS.

        Creating_a_Multidimensional_Array();
        Using_a_Multidimensional_Array();
    }

    private void Creating_a_Multidimensional_Array(){
        //Solo se necesitan múltiples separadores de arreglos para declarar arreglos con múltiples dimensiones.
        //Se pueden ubicar en el tipo o el nombre de la variable en la declaración. EJMPLO:

        int[][] vars1;          // 2D array
        int vars2 [][];         // 2D array
        int[] vars3[];          // 2D array  //PUEDE QUE APAREZCAN TANTO EN EL TIPO DE DATO COMO EN EL NOMBRE DE LA VARIABLE
        int[] vars4 [], space [][];  // vars4 es un array 2D y space es un array 3D

        //PARA SABER LA DIMENSIONALIDAD DEL ARRAY, SE SUMAN LA CANTIDAD DE PARES DE CORCHETES QUE TIENE LA VARIABLE Y SU TIPO DE DATO

        //Se puede especificar el tamaño del arreglo multidimensional en la declaración:

        String [][] rectangle = new String[3][2];

        //El resultado de esta declaración es un arreglo rectangular con tres elementos,
        //cada uno de los cuales se refiere a un arreglo de dos elementos.

        rectangle[0][1] = "set";
        
        //Otro ejemplo
        int[][] differentSize = {{1, 4}, {3}, {9,8,7}};

        //Se empieza con un arreglo de 3 elementos, pero luego los elementos en el siguiente nivel son de tamaños diferentes.
        //esto es TOTALMENTE VÁLIDO.

        //Otra forma de crear un arreglo asimétrico es inicializar solo la primera dimensión de un arreglo y definir el tamaño de
        //cada componente del arreglo en una instrucción separada.

        int [][] args = new int[4][];   //aquí se declara un array 2D, en donde la primera dimensión constará de 4 elementos.
        args[0] = new int[5];       //El primer elemento tendrá un arreglo de 5 elementos
        args[1] = new int[3];       //El segundo elemento tendrá un arreglo de 3 elementos

        //args[2] y args[3] como no tienen definido un tamaño, actualmente son null.
    }

    private void Using_a_Multidimensional_Array(){
        //La operación más común en un arreglo multidimensional es recorrerlo. Ejmplo:

        int[][] twoD = new int[3][2];       //Se declara un array 2D con tipo de dato int
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++)
                System.out.print(twoD[i][j] + " "); // print element
            System.out.println();                 // Aquí hace un salto de línea
        }

        //Aquí se usan dos bucles.El primero usa el índice i y recorre el primer subarreglo de twoD.
        //El segundo usa una variable de bucle diferente, j.
        //Es muy importante que tengan nombres de variable distintos para que los bucles no se mezclen.
        //Cuando el bucle interno termina, el bucle externo pasa a una nueva línea y repite el proceso para el siguiente elemento.

        //CON EL BUCLE O FOR MEJORADO SE VE MUCHO MÁS FACIL:
        int[][] twoD1 = new int[3][2]; 
        for (int[] inner : twoD1) {      //Se coloca int[], ya que cada elemento es un array de tipo int
            for (int num : inner)       //Se coloco int porque cada elemento del segundo array contienen un elemento de tipo int
                System.out.print(num + " ");
            System.out.println();
        }
    }

}
