package com.app.day_one.Understanding_Package_Declarations_and_Imports.Creating_a_new_package.packageb;

import com.app.day_one.Understanding_Package_Declarations_and_Imports.Creating_a_new_package.packagea.ClassA;

public class ClassB {
    public static void main(String[] args) {
        ClassA a;
        System.out.println("Got it");


        //UNA VEZ COMPILADO, AHORA SE PROCEDERÁ A EJECUTAR LA CLASE, PARA ELLO, SE COLOCA ESTE COMANDO EN LA TERMINAL.
        // java packageb.ClassB
        //SI SE LOGRA EJECUTAR, EN CONSOLA SE DEBE IMPRIMIR LA FRASE: "Got it"
        //PARA VER EL RESULTADO, VER LA captura_2.png en la carpeta images
    }
}
