package com.app.Creating_Objects.Constructors;

/* import java.util.Random; */

public class Chick {
    String name;
    int numEggs = 0;
    
    //EL NOMBRE DEL CONSTRUCTOR COINCIDE CON EL NOMBRE DE LA CASE Y NO TIENE TIPO DE RETORNO (NI DEL VOID):
    public Chick(){
        name = "Duke";
        System.out.println("Este es un contructor");
    }

    /* public void Chick() { } // NO ES UN CONTRUCTOR, ES UN METODO VOID */

    public static void main(String[] args) {
        //Para crear una instancia de una clase se debe colocar el new:
        /* Random r  = new Random() */
    }
}

