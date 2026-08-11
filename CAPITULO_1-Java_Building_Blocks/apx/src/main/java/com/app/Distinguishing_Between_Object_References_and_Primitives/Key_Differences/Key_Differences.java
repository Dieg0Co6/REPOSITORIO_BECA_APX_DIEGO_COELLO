package com.app.Distinguishing_Between_Object_References_and_Primitives.Key_Differences;

public class Key_Differences {
    //int value = null;   // No compila, los tipos primitivos no pueden ser nulos
    String s = null;        //Tipo de referencia


    String reference = "hola";
    int len = reference.length();
    //int bad = len.length(); // No compila, los tipos primitivos no tienen métodos
}

