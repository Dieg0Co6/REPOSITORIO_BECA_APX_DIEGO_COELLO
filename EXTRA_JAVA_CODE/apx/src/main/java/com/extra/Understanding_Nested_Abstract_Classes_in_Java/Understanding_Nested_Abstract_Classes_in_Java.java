package com.extra.Understanding_Nested_Abstract_Classes_in_Java;

public class Understanding_Nested_Abstract_Classes_in_Java {
    //En Java, la organización del código y la encapsulación son principios clave del diseño orientado a objetos limpio.
    //Aunque los desarrolladores frecuentemente usan clases anidadas para agrupar funcionalidades relacionadas,
    //Java también permite declarar una clase abstracta dentro de otra clase, por ejemplo:
    class C { abstract class Inner {} }

    //1. "Pertenece exclusivamente a su clase externa":
    // la clase abstracta anidada solo tiene sentido dentro del contexto de esa clase contenedora.
    // No es algo genérico que uses en cualquier parte del programa — está ahí porque solo C (y lo que esté relacionado con C) la necesita.

    //2. "Previene instanciación directa": como es abstract, no puedes hacer new Inner() directamente.
    //Estás obligado a crear una subclase concreta que implemente los métodos abstractos, y esa subclase es la que sí puedes instanciar.

    //EJEMPLO

    /*class C {
        abstract class Inner {
            abstract void hacerAlgo();
        }

        class Impl extends Inner {
            void hacerAlgo() { System.out.println("listo"); }
        }
    } */

    public static void main(String[] args) {
        Understanding_Nested_Abstract_Classes_in_Java understanding_Nested_Abstract_Classes_in_Java = new Understanding_Nested_Abstract_Classes_in_Java();
        understanding_Nested_Abstract_Classes_in_Java.Conceptos_Clave_y_Motivaciones_de_Diseño();
        understanding_Nested_Abstract_Classes_in_Java.Ejemplo_de_estructura_de_código();
        understanding_Nested_Abstract_Classes_in_Java.Clases_Internas_Abstractas_Estáticas_vs_No_Estáticas();
    }

    public void Conceptos_Clave_y_Motivaciones_de_Diseño(){
        /*
            ● Alcance Lógico y Jerarquía: Cuando una plantilla base abstracta solo es relevante dentro del contexto de una clase contenedora
                o de gestor específica, anidarla mantiene los espacios de nombres del paquete a nivel superior limpios y organizados.

            ● Flexibilidad de Control de Acceso: A diferencia de las clases a nivel superior, que solo pueden ser públicas o privadas de paquete,
                las clases abstractas anidadas pueden marcarse como privadas, protegidas, públicas o privadas de paquete.

            ● Encapsulamiento del Estado Privado: Una clase abstracta interna (no estática) mantiene acceso completo a los miembros privados
                de su clase externa que la contiene, permitiendo que las subclases internas derivadas interactúen de manera fluida
                con el estado interno de la instancia externa.
         */
    }

    public void Ejemplo_de_estructura_de_código(){
        /*
        public class OuterContainer { 
            --1. Nested abstract class defining a contract 
            abstract class Component { 
                protected String name; 
                public Component(String name) { 
                    this.name = name; 
                } 
                abstract void render(); // Must be implemented by subclasses
            } 
        
            --2. Concrete inner subclass fulfilling the abstract contract 
            class Button extends Component { 
                public Button(String name) { 
                    super(name); 
                } 
        
                @Override 
                void render() { 
                    System.out.println("Rendering UI Button: " + name); 
                } 
            } 
        }  
        */
    }

    public void Clases_Internas_Abstractas_Estáticas_vs_No_Estáticas(){
        /*
        ● No estática (abstract class Inner): Ligada a una instancia de la clase externa.
            Las subclases deben instanciarse en relación con una instancia de la clase externa.

        ● Estática (static abstract class Inner): Desacoplada de la instancia externa.
            Este es el enfoque más común para diseños modulares y plantillas de frameworks,
            ya que evita mantener una referencia implícita a la clase externa. */
    }
}
