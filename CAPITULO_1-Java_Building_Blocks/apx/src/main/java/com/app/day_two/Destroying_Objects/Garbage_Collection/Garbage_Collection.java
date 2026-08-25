package com.app.day_two.Destroying_Objects.Garbage_Collection;

public class Garbage_Collection {
    //Es un recolector de basura, el cual se usa para que Java deje de usar memoria de un objeto. 
    //Java espera hasta que el código ya no necesita esa memoria.
    // Un objeto permanecerá en el montón hasta que ya no sea accesible.
    // Un objeto deja de ser accesible cuando ocurre una de dos situaciones:
    // * El objeto ya no tiene ninguna referencia apuntando a él.
    // * Todas las referencias al objeto han salido de su alcance.


    //DIFERENCIAS ENTRE OBJETOS Y REFERENCIAS:
    // Es distinto una referencia a un objeto que se refiere
    // La referencia es una variable que tiene un nombre y puede usarse para acceder al contenido de un objeto. 
    // Una referencia puede asignarse a otra referencia, pasarse a un método o devolverse desde un método.

    //Los objetos pueden ser de diferentes tamaños de memoria, las referencias no, todas son del mismo tamaño
    //La referencia apunta hacia el objeto, pero no es el objeto en sí, como un papel indicando donde se encuentra tal objeto.
    //La referencia tiene un nombre
    // EL OBJETO SE ENCUENTRA EN UNA ZONA DE MEMORIA LLAMADA "HEAP"
    // LA REFERENCIA VENDRÍA SER LA VARIABLE UNO USA EN EL CODIGO CON UN NOMBRE Y ESA VARIABLE APUNTA HACIA EL OBJETO. EJMPLO:

    //Perro miPerro = new Perro(); //miPerro es la referencia
    // Perro otroPerro = miPerro;   //otroPerro es otra referencia. No se creó un perro nuevo, 
                                    // solo hiciste otra copia del papelito que apunta a la misma caja.


}
