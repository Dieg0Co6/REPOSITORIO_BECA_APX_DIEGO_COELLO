package com.app.Understanding_Package_Declarations_and_Imports;

import java.util.Random;    //Si no lo importo, me va salir un error en la linea 7.

public class ImportExample {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
