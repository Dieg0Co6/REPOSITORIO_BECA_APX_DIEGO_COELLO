package com.app.day_two.Destroying_Objects.Garbage_Collection;

public class Scope {
    public static void main(String[] args) {
        String one, two; //Aquí se declaran las variable one y two de tipo String
        one = new String("a");  //Aquí se crea una referencia al objeto String, con el nombre de one
        two = new String("b");  //Aquí se crea una referencia al objeto String, con el nombre de two
        one = two;      //Aquí se le asigna a la referencia one, la referencia two
        String three = one;     //Aquí se les asigna a una variable la referencia de one, que ahora tiene la referencia two
        one = null;             //Se le asignó null a la referencia one.

        //ESTO QUIERE DECIR, QUE COMO EL OBJETO "a" COMO A PARTIR DE LA LINEA 8 NO TENÍA NINGUNA REFERENCIA APUNTADOLO, ENTONCES
        // SE IBA PARA EL GARBAGE COLLECTION O RECOLECTOR DE BASURA. Y HABÍAN 3 REFERENCIAS APUNTANDO HACIA EL OBJETO B HASTA LA LINEA 10
        
    }
}
