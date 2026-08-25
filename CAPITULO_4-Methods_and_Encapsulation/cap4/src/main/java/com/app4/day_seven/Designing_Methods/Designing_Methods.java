package com.app4.day_seven.Designing_Methods;

public class Designing_Methods {

    public static void main(String[] args) {
        
        /*
                Element                                 Value in nap() example              Required?
            * Modificador de acceso                 public / private / protected                NO
            * Especificador opcional                final / static / abstract                   NO
            * Tipo de retorno                       void/ int/ String / List                    YES
            * Nombre de método                      (hay con excepciones)                       YES
            * Paréntesis                                    (   )                               YES 
            * Lista de parámetros                       (int minutes)             YES, pero pueden ser paréntesis vacíos
            * Lista de excepciones opcional         throws InterruptedException                 NO
            * Method body                                  {  //     }            YES, pero pueden ser llaves vacías            
        */

        //EJMPLO:

        /* public final void nap(int minutes) throws InterruptedException {
                //

        } */
        
        // Y para llamar al método, en este caso se tiene que hacer esto: nap(10)

        Designing_Methods designing_Methods = new Designing_Methods();
        designing_Methods.Access_Modifiers();
        designing_Methods.Optional_Specifiers();
        
        
        
    }

    public void Access_Modifiers(){
        //JAVA OFRECE 4 OPCIONES DE MODIFICADORES DE ACCESO.

        /*
            * public                -> El método se puede llamar desde cualquier clase.
            * protected             -> El método solo se puede llamar desde clases en el mismo paquete y/o subclases.
            * private               -> El método solo se puede llamar desde dentro de la misma clase.
            * package private /     -> El método solo se puede llamar desde clases en el mismo paquete. 
            * Acceso por defecto       Sí hay otras clases o subclases en otro paquete, no va poder utilizarse el método.
            *                          Este es complicado porque no hay una palabra clave para el acceso por defecto.
            *                          Simplemente omites el modificador de acceso.
        */
        
        // TOMAR BIEN EN CUENTA EL ORDEN DE LOS ELEMENTOS PARA CREAR UN METODO, YA QUE LOS CREADORES DEL EXAMEN
        // SUELEN COLOCAR LOS ELEMENTOS DE UN MÉTODO EN EL ORDEN INCORRECTO O USANDO VALORES INCORRECTOS. EJM:

        /* public void walk1() {}      //ESTE METODO SI ESTÁ BIEN DEFINIDO

        default void walk2() {}     //NO EXISTE EL MODIFICADOR DE ACCESO DEFAULT //NO COMPILA

        void public walk3() {} // NO COMPILA //ORDEN INCORRECTO DE LOS ELEMENTOS DEL METODO.

        void walk4() {}     //SÍ ESTÁ BIEN DEFINIDO, EL MODIFICADOR DE ACCESO ES EL PACKAGE PRIVATE (POR DEFECTO) */
    }

    public void Optional_Specifiers(){
        /*
        Los especificadores opcionales provienen de la siguiente lista.
        A diferencia de los modificadores de acceso, puedes tener múltiples especificadores en el mismo método
        (aunque no todas las combinaciones son legales).
        Cuando esto ocurre, puedes especificarlos en cualquier orden.
        Y dado que es opcional, no tienes que tener ninguno
        */

        /*
            * static                -> Se usa para métodos de clase. ESTOS METODOS NO SE USAN EN OBJETOS.
            * abstract              -> Se usa cuando no se proporciona un cuerpo de método.
            * final                 -> Se usa cuando no se permite que un método sea sobrescrito por una subclase.(NO SE USAN EN INTERFACES)
            * synchronized          -> sincronizado en el OCP pero no en el examen OCA.
            * native                -> Se usa al interactuar con código escrito en otro lenguaje como C++.
            * strictfp              -> Se usa para hacer que los cálculos de punto flotante sean portables.                         
        */

        //EJMPLO:
        /* public void walk1() {}       //ESTO ESTÁ BIEN DEFINIDO - ES OPCIONAL
        public final void walk2() {}        //ESTO ESTÁ BIEN DEFINIDO
        public static final void walk3() {}  //ESTO ESTÁ BIEN DEFINIDO
        public final static void walk4() {}    //ESTO ESTÁ BIEN DEFINIDO
        public modifier void walk5() {} // NO COMPILA, PORQUE MODIFIER NO EXISTE COMO ESPECIFICADOR OPCIONAL
        public void final walk6() {} // NO COMPILA, POR EL ORDEN DE LOS ELEMENTOS, EL ESPECIFICADOR OPCIONAL SIEMPRE ES ANTES DEL TIPO DE RETORNO
        final public void walk7() {} //ESTO SÍ COMPILA, JAVA PERMITE QUE LOS ESPEFICADORES OPCIONES ESTÉN ANTES QUE EL MODIFICADOR
                                        DE ACCESO. TENER MUCHO CUIDADO, PUEDE ESTAR ANTES QUE EL MODIFICADOR DE ACCESO, PERO NO PUEDE
                                        ESTAR DESPUÉS DEL TIPO DE RETORNO
        */
        
    }


}
