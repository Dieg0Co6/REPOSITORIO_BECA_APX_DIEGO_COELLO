package com.app.day_one.Distinguishing_Between_Object_References_and_Primitives.Primitive_Types;

public class Primitive_Types {

    //Permite usar guiones bajos en los literales numéricos para mejorar la legibilidad
    //double notAtStart = _1000.00;        // No compila
    //double notAtEnd = 1000.00_;          // No compila
    //double notByDecimal = 1000_.00;      // No compila
    double annoyingButLegal = 1_00_0.0_0;  // Sí compila
    //TENER EN CUENTA: Se puede agregar guiones bajos en cualquier lugar excepto al principio de un literal
    //al final de un literal, justo antes de un punto decimal o justo después de un punto decimal.

    //long max = 3123456789; // NO COMPILA
    //Java se queja de que el número está fuera de rango. Y lo está, para un int. 
    // Sin embargo, no tenemos un int. La solución es agregar el carácter L al número:
    long max2 = 3123456789L; // NO COMPILA

    //OTRA FORMA DE REPRESENTAR LOS NUMEROS, ES CAMBIANDOLES LA BASE, PUDIENDO SER DE VASE 10, 2, 5, 8, HEXADECIMAL, ETC.
    //EJMPLO:
    //octal (dígitos 0–7), que usa el número 0 como prefijo—por ejemplo, 017
    //hexadecimal (dígitos 0–9 y letras A–F), que usa el número 0 seguido de x o X como prefijo—por ejemplo, 0xFF
    //binario (dígitos 0–1), que usa el número 0 seguido de b o B como prefijo—por ejemplo, 0b10
    public static void main(String[] args) {
        System.out.println(0b11);     // 3
        System.out.println(017);      // 15
        System.out.println(0x1F);     // 31
    }
}
