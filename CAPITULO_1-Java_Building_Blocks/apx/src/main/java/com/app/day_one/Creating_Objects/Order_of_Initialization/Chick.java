package com.app.day_one.Creating_Objects.Order_of_Initialization;

public class Chick {
    //Los campos y los bloques inicializadores de instancia se ejecutan en el orden en que aparecen en el archivo

    private String name = "Fluffy";
    { System.out.println("setting field"); }

    //El constructor se ejecuta después de que todos los campos y los bloques inicializadores de instancia hayan corrido.
    public Chick() {
        name = "Tiny";
        System.out.println("setting constructor");
    }

    public static void main(String[] args) {
        Chick chick = new Chick();
        System.out.println(chick.name);

        //ES DECIR, AL MOMENTO DE EJECUTAR ESTE CODIGO, EL ORDEN VA SER EL SIGUIENTE:
        //PRIMERO SE EJECUTAN LOS CAMPOS Y BLOQUES DE INICIALIZACIÓN, EN EL ORDEN EN QUE APARECEN EN EL ARCHIVO.
        //ASÍ QUE PRIMERO SE LE ASIGNA A LA VARIABLE NAME EL VALOR DE "Fluffy"
        //LUEGO SE IMPRIME "setting field", LUEGO SE EJECUTA EL CONSTRUCTOR, LUEGO EN EL CONSTRUCTOR IMPRIME "setting constructor"
        //Y LUEGO TERMINA IMPRIMIENDO EL CHICK.NAME QUE EN EL CONSTRUCTOR CAMBIÓ DE VALOR Y AHORA ES "TINY".
        //ES DECIR, EL ORDEN DE IMPRESIÓN ES:
        //setting field
        //setting constructor
        //Tiny
    }
}
