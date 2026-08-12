package com.app.Writing_a_main_method;

//Así se ve la clase más simple con un método main
public class Zoo {

    //Es el punto de entrada para la ejecución del código
    public static void main(String[] args) {
        //Imprimimos los dos primeros argumentos que se pasan
        System.out.println(args[0]);
        System.out.println(args[1]);

        //Si no paso suficientes argumentos, me va salir un error, el cual la evidencia del error está en la carpeta images

        //Si paso 3 argumentos, entonces me va retornar lo siguiente. 
        // Ejm: Ver captura_2.png

        //En el caso de que quieras pasa un argumento que continene un espacio, entonces se debe usar comillas. 
        // Ejm: Ver captura_3.png

        //Los argumentos que se pasan, se tratan como objetos String, incluso si representan otro tipo de dato.
        //Ejm: Ver captura_4.png
        
    }
}
