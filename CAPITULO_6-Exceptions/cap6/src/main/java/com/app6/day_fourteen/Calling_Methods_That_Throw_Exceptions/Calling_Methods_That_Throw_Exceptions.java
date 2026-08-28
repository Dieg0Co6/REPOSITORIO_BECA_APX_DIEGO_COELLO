package com.app6.day_fourteen.Calling_Methods_That_Throw_Exceptions;

public class Calling_Methods_That_Throw_Exceptions {
    //Cuando llamas a un método que lanza una excepción, las reglas son las mismas que dentro de un método.
    //EJM QUE NO COPMPILA:

    /* class NoMoreCarrotsException extends Exception {}

    public class Bunny {
        public static void main(String[] args) {
            eatCarrot();// NO COMPILA
        }
        private static void eatCarrot() throws NoMoreCarrotsException {
        }
    } */

    //El problema es que NoMoreCarrotsException es una excepción VERIFICADA.
    //Las excepciones verificadas deben ser manejadas o declaradas.
    //El código se compilaría si cambiamos el método main() a cualquiera de estas:

    //EJEM 1:
    /* public static void main(String[] args) 
        throws NoMoreCarrotsException {// declarar exception
        eatCarrot();
    } */

    //EJM2: 
    /* public static void main(String[] args) {
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e ) {//manejar exception
            System.out.print("sad rabbit");
        }
    } */

    //eatCarrot() en realidad no lanzó una excepción; solo declaró que podría hacerlo.
    //Esto es suficiente para que el compilador requiera que quien llame al método maneje o declare la excepción.

    //El compilador todavía está atento al código inalcanzable.
    //Declarar una excepción que no se usa no se considera código inalcanzable.
    //Le da al método la opción de cambiar la implementación para lanzar esa excepción en el futuro.

    /* public void bad() {
        try {
            eatCarrot();
        } catch (NoMoreCarrotsException e ) {//NO COMPILA
            System.out.print("sad rabbit");
        }
    }

    public void good() throws NoMoreCarrotsException {
        eatCarrot();
    }

    private static void eatCarrot(){ } */

    //eatCarrot() no lanza ninguna excepción checked. No tiene throws en su firma, y su cuerpo está vacío — no hace throw de nada.
    //Entonces Java se pregunta: "¿de dónde podría venir un NoMoreCarrotsException dentro de este try?"
    //Y la respuesta es: de ningún lado. Es físicamente imposible que ese catch se active alguna vez.
    //POR ELLO LANZA UN ERROR DE COMPILACIÓN.

    public static void main(String[] args) {
        Calling_Methods_That_Throw_Exceptions calling_Methods_That_Throw_Exceptions = new Calling_Methods_That_Throw_Exceptions();
        calling_Methods_That_Throw_Exceptions.Subclasses();
        calling_Methods_That_Throw_Exceptions.Printing_an_Exception();

    }

    public void Subclasses(){
        //Veamos cómo sobrescribir métodos con excepciones en la declaración del método.

        //Cuando una clase sobrescribe un método de una superclase o implementa un método de una interfaz,
        //no se permite agregar nuevas excepciones comprobadas a la firma del método. Por ejemplo, este código no está permitido:

        class CanNotHopException extends Exception { }
        class Hopper {
            public void hop() { }
        }
        class Bunny extends Hopper {
            //public void hop() throws CanNotHopException { } // NO COMPILA
        }

        //No compila, porque el método sobreescrito de Bunny hop(), se le está añadiendo una exception verificada que el método de la
        //superclase no tiene dicha exception

        //Una subclase puede declarar menos excepciones que la superclase o la interfaz.

        //Ejm:

        /* class Hopper {
            public void hop() throws CanNotHopException { }
        }
        class Bunny extends Hopper {
            public void hop()  { }
        } */

        //El ejemplo anterior sí compila, porque el metodo sobreescrito de la subclase tiene menos o iguales excepciones que el método
        //de la clase padre.

        //De manera similar, a una clase se le permite declarar una subclase de un tipo de excepción.
        //La idea es la misma. La superclase o la interfaz ya se han encargado de un tipo más amplio.

        class Hopper2 {
            public void hop() throws Exception { }
        }
        class Bunny2 extends Hopper {
            //public void hop() throws CanNotHopException { }
        }

        //EL EJEMPLO ANTERIOR SI COMPILA, PORQUE EL METODO HOP() DE LA SUPERCLASE ESTÁ DECLARANDO QUE SE VA LANZAR UNA EXCEPTION
        //Y EL DE LA SUBCLASE ESTÁ DECLARANDO QUE SE LANZARÁ UN CanNotHopException (que es subclase de Exception)

        //ES DECIR, Bunny podría declarar que lanza Exception directamente, o podría declarar que lanza un tipo más específico
        //de Exception. Incluso podría declarar que no lanza nada en absoluto. Esta regla aplica solo a las excepciones verificadas.
    
        class Hopper3 {
            public void hop() { }
        }

        class Bunny3 extends Hopper {
            public void hop() throws IllegalStateException { }
        }

        //EN EL EJEMPLO ANTERIOR ESTÁ SOBREESCRIBIENDO UN METODO Y DECLARANDO QUE SE VA LANZAR UNA EXCEPTION
        //SÍ COMPILA, PORQUE ESA EXCEPTION ES NO VERIFICADA. Y ESE TIPO DE EXCEPCIONES SI TIENEN LA LIBERTAD DE DECLARARSE EN METODO
        //SOBREESCRITOS. LOS VERIFICADOS NO.
    }

    public void Printing_an_Exception(){
        /*
        Hay tres maneras de imprimir una excepción.
        * Puedes dejar que Java la imprima
        * imprimir solo el mensaje
        * imprimir de dónde proviene el rastro de pila. 
        */
        
        //Este ejemplo muestra los tres enfoques:

        /* public static void main(String[] args) {
            try {
                hop();
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }

        private static void hop() {
            throw new RuntimeException("cannot hop");
        } */

        //Este código produce la siguiente salida:

        //java.lang.RuntimeException: cannot hop
        // cannot hop
        //java.lang.RuntimeException: cannot hop at trycatch.Handling.hop(Handling.java:15) at trycatch.Handling.main(Handling.java:7)

        //La primera línea muestra lo que Java imprime por defecto: el tipo de excepción y el mensaje. 
        //La segunda línea muestra solo el mensaje.
        //El resto muestra un rastro de pila. 
        //El rastro de pila suele ser el más útil porque muestra dónde ocurrió la excepción en cada método por el que pasó.

        //En el examen OCA, mayormente verás el primer enfoque. 
        //Esto se debe a que el examen suele mostrar fragmentos de código.
        //El rastro de pila muestra todos los métodos en la pila.


        //===========================================================================================
        //Por qué ignorar las excepciones es malo
        //===========================================================================================

        //Como las excepciones verificadas requieren que las manejes o declares,
        //existe la tentación de atraparlas para que 'desaparezcan'.
        // Pero hacer eso puede causar problemas. 

        // En el siguiente código, hay un problema al leer el archivo:

        /* public static void main(String[] args) {
            String textInFile = null;
            try {
                readInFile();
            } catch (IOException e) {
                // Ignorar excepción   -   El catch la atrapa... pero no hace nada con ella. Está vacío. La "traga" en silencio.
            }

        
        imagina muchas líneas de código aquí
        Como textInFile nunca se llenó (porque leer el archivo falló), sigue siendo null.
        System.out.println(textInFile.replace(" ", ""));    //falla
        }

        private static void readInFile() throws IOException {
            throw new IOException();
        } */

        //El código da como resultado una NullPointerException.
        //Java no te dice nada sobre la IOException original porque ya se manejó. Claro, se manejó mal, pero se manejó.

        //Cuando escribas tu propio código, imprime un seguimiento de la pila o al menos un mensaje al capturar una excepción.
        //Además, considera si continuar es la mejor opción. En nuestro ejemplo, el programa no puede hacer nada después
        //de que falla al leer el archivo. Bien podría haber lanzado directamente la IOException.
    }
    
}
