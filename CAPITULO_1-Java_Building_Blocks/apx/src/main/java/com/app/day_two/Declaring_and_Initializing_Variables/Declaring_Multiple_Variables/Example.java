package com.app.day_two.Declaring_and_Initializing_Variables.Declaring_Multiple_Variables;

public class Example {
    //También se puede inicializar varias variables en una sola linea, siempre que todas sean del mismo tipo, de esta manera:

    String s1, s2; //Se declararon dos variables: s1 y s2, ambos con el tipo de dato String.
    String s3 = "sí", s4 = "no"; //También se pueden declarar e inicializar varias variables en una sola linea

    int i1, i2, i3 = 0; //Aquí vemos que se han declarado 3 variables y solamente una se encuentra inicializada con el valor 0
                        //La inicialización solo aplica a i3, no al resto de variables que se encuentran separados mediante comas

    //int num, String value; //Esto no compila, no se puede asignar dos variables de diferente tipo de datos separados por coma en una misma linea
    //Este código no se compila porque intenta declarar múltiples variables de diferentes tipos en la misma instrucción. 
    // El atajo para declarar varias variables en la misma instrucción solo funciona cuando comparten un tipo.

    boolean b1, b2; //Estos dos se declararon con el tipo de dato boolean.
    String s5 = "1", s6; //Estos si funcionan, se declararon dos, se inicializó el primero
    //double d1, double d2; //Este no, porque está separado por comas, pero solamente se declara una vez el tipo de dato y es al principio
    int i7; int i8; //Este sí, ya que están separados por punto y coma y se coloca su tipo de dato en cada variable
                    //Sería como declarar dos variables sin hacer uso del salto de linea
    //int i9; i10; //Este está mal, ya que se están separando por punto y coma, y deberían ser por coma.
    
    //Para darse cuenta si está bien o mal en el ultimo caso, cuando se vea un punto y coma, simular que se da un salto de linea.
    //En ese caso será facil darse cuenta que no está bien declarado. Ejm:
    /* int i1; 
    int i2;
    int i3; 
    i4;// NO COMPILA */
}
