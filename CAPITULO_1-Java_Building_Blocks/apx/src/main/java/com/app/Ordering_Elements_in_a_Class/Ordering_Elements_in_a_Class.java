package com.app.Ordering_Elements_in_a_Class;

public class Ordering_Elements_in_a_Class {
    //EL ORDEN ES IMPORTANTE, PRIMERO SE DECLARA EL PACKAGE, LUEGO VIENE INMEDIATAMENTE DEBAJO LAS IMPORTACIONES
    // LUEGO DE LAS IMPORTACIONES VIENE LA DECLARACIÓN DE LA CLASE, LA CUAL ESTE ES OBLIGATORIA, DESPUÉS ESTÁN LAS VARIABLES
    // LAS CUALES SE PUEDEN ASIGNAR EN CUALQUIER PARTE DE LA CLASE, AL IGUAL QUE LOS METODOS

    //EJEMPLO:
    /*package structure;   
    import java.util.*;  
    public class Meerkat { 
        double weight;       
        public double getWeight() {
            return weight;
        }
        double height;   
    } */


    //OTRO EJEMPLO:
    /* header */
    /* package structure; */  //paquete
    // clase
    //public class Meerkat { }


    //OTRO EJEMPLO: ESTE EJEMPLO ESTÁ MAL PORQUE SE ESTÁN COLOCANDO LAS IMPORTACIONES PRIMERO, Y SIEMPRE VAN DEBAJO DE 
    // LA DECLARACION DEL PACKAGE Y ADEMÁS YA QUE LAS VARIABLES VAN DENTRO DE LA CLASE, NO AFUERA

    //import java.util.*;  
    //package structure;   // NO COMPILA
    //String name;  // ESTO TAMPOCO COMPILA
    //public class Meerkat { }


    //TEN SIEMPRE EN CUENTA QUE:
    //Se pueden definir varias clases en el mismo archivo, 
    // pero solo una de ellas puede ser pública.
    // La clase pública coincide con el nombre del archivo.
}
