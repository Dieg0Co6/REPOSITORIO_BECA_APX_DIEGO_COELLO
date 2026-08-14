package com.app.day_two.Destroying_Objects.Finalize;

import java.util.ArrayList;
import java.util.List;

public class Finalizer {
    //Finalize es un método que puedes escribir dentro de tu clase, y que Java podría llamar justo antes de 
    // tirar el objeto a la basura, como una última oportunidad de "despedirte" del objeto.

    // Puede que nunca se llame. Si el recolector de basura nunca pasa a limpiar tu objeto, finalize() nunca se ejecuta.
    //Nunca se llama dos veces.
    //No es confiable. Por eso en la vida real casi nadie lo usa


    //Dicho esto, esta llamada no produce salida cuando la ejecutamos:
    /* protected void finalize()  {
        System.out.println("Calling finalize");
    } 
    public static void main(String[] args) {
        Finalizer f = new Finalizer();
    } */

    //La razón es que el programa termina antes de que haya necesidad de ejecutar el recolector de basura. 
    // Aunque f sea elegible para la recolección de basura
    // Java tiene cosas mejores que hacer que sacar la basura constantemente.


    /* private static List Objects = new ArrayList<>();
    
    protected void finalize(){
        Objects.add(this);//NO HACER ESTO
    } */

    // finalize() solo se ejecuta cuando el objeto es elegible para la recolección de basura.
    // El problema aquí es que al final del método, el objeto ya no es elegible para la recolección de basura
    // porque una variable estática está referenciándolo y las variables estáticas permanecen en alcance hasta
    // que el programa termina. Así que Java aborta el intento de eliminar el objeto.
}
