package com.app.day_one.Creating_Objects.Instance_Initializer_Blocks;

public class Example {
    String name;
    public static void main(String[] args) {
        {
            System.out.println("Feathers");
        }
    }

    //ESTOS SON BLOQUES DE INICIALIZACIÓN, AQUÍ SE PUEDE INICIALIZAR LAS VARIABLES DE INSTANCIAS
    {
        name= "Diego";
        System.out.println("Snowy");
    }

}
