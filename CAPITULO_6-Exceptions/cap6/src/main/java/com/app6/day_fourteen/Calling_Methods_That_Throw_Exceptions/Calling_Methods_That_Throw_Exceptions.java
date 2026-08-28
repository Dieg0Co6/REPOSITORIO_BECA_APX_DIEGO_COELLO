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
    }

    public void Subclasses(){
        
    }
    
}
