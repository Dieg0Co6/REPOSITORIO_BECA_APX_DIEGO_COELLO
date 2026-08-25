package com.app.day_two.Declaring_and_Initializing_Variables.Identifiers;

public class Identifiers {
    //Sobre el nombre de las variables, hay ciertas reglas de como deben ser nombradas,
    //pudiendo utilizar variables que tengan como prefijo el $ o _ o una letra.
    //Los Caracteres posteriores también pueden ser numero (EL PRIMERO NO).
    // Ejm:

    String okidentifier;
    String $OK2Identifier; 
    String _alsoOK1d3ntifi3r;
    String __SStillOkbutKnotsonice$; 

    //LOS QUE SON ILEGALES SON LOS QUE EL PRIMER CARACTER ES UN NUMERO, O LOS QUE SE USAN PALABRAS RESERVADAS DE JAVA
    //COMO METODOS, CLASES, ETC
    //EJM:
    /* String 3DPointClass;  // NO PUEDE COMENZAR CON UN NUMERO
    String hollywood@vine; // @ no es una letra, ni $ ni _
    String *$coffee;    // * tampoco es una letra, ni $ ni _
    String public;   // public es una palabra reserva de Java */

    //AUNQUE SE PUEDA ASIGNAR NOMBRE DE VARIABLES DE DISTINTAS MANERAS, ES RECOMENDABLE DECLARAR USANDO CAMELCASE, ES DECIR,
    //CADA PALABRA EMPIEZA CON LA LETRA MAYUSCULA, ASÍ EL CODIGO SE HACE MÁS LEGIBLE

    //Esto hace que los nombres de variables con varias palabras sean más fáciles de leer.
    //Cuando se vea un identificador no estándar, asegurarse de verificar si es legal. Si no lo es, se puede marcar la respuesta 
    // como “no compila” y saltarse el análisis del resto de la pregunta.

    //Se debe tener en cuenta que los desarrolladores de Java usan estas reglas: Los nombres de métodos y variables comienzan 
    // con una letra minúscula seguida de CamelCase. Los nombres de clases comienzan con una letra mayúscula seguida de CamelCase. 
    // No comiences ningún identificador con $. El compilador usa este símbolo para algunos archivos.
}
