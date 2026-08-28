package com.app6.day_fourteen.Understanding_Exceptions;

import java.io.FileReader;

public class Understanding_Exceptions {
    //Muchas cosas pueden salir mal en un programa. Java usa excepciones para manejar algunos de estos escenarios.
    //El examen OCA solo cubre lo básico de trabajar con excepciones. 

    public static void main(String[] args) {
        //Un programa puede fallar por prácticamente cualquier razón.

        /*
        Alguna de las posibildiades pueden ser:
        * El código intenta conectarse a un sitio web, pero la conexión a Internet está caída.
        * Cometiste un error de programación y trataste de acceder a un índice inválido en un arreglo.
        * Un método llama a otro con un valor que el método no soporta.
        */

        //Como puedes ver, algunos de estos son errores de programación.
        //Otros están completamente fuera de tu control. El programa no puede hacer nada si la conexión a Internet se cae.

        //Lo que sí puede hacer es manejar la situación. Primero, veremos el papel de las excepciones.
        //Luego cubriremos los distintos tipos de excepciones, seguido de una explicación de cómo lanzar una excepción en Java.

        Understanding_Exceptions understanding_Exceptions = new Understanding_Exceptions();
        understanding_Exceptions.Catching_Various_Types_of_Exceptions();
        understanding_Exceptions.Throwing_a_Second_Exception();
    }

    public void Catching_Various_Types_of_Exceptions(){
        //Hasta ahora, solo se ha estado capturando un tipo de excepción.
        //Ahora veamos qué pasa cuando se pueden lanzar diferentes tipos de excepciones desde el mismo método.

        //El examen OCA puede definir excepciones básicas para mostrarte la jerarquía.
        //Solo necesitas hacer dos cosas con esta información.

        // Primero, debes poder reconocer si la excepción es una excepción comprobada (checked) o no comprobada 
        // (unchecked / RunTimeException).

        // Segundo, necesitas determinar si alguna de las excepciones es subclase de las otras.

        //EJM:

        class AnimalsOutForAWalk extends RuntimeException { }
        class ExhibitClosed extends RuntimeException { }
        class ExhibitClosedForLunch extends ExhibitClosed { }

        //En este ejemplo, hay tres excepciones personalizadas.
        //Todas son excepciones no verificadas porque extienden directa o indirectamente RuntimeException.

        //Ahora capturamos ambos tipos de excepciones y las manejamos imprimiendo el mensaje correspondiente:

        /* public void visitPorcupine() {
            try {
                seeAnimal();
            } catch (AnimalsOutForAWalk e) {// primer bloque catch
                System.out.print("try back later");
            } catch (ExhibitClosed e) {// segundo bloque catch
                System.out.print("not today");
            }
        } */

        /*
        IMPORTANTE:
            * 1. El orden de los catch importa cuando hay herencia entre las excepciones.
            * 2. Si una excepción es subclase de otra (como ExhibitClosedForLunch extiende ExhibitClosed),
            * el catch de la subclase debe ir antes que el catch de la superclase.
        */

        // ESTO NO COMPILA
        try {
            //seeAnimal();
        } catch (ExhibitClosed e) {          // superclase primero
            System.out.print("not today");
        }/*  catch (ExhibitClosedForLunch e) {  // subclase después → ERROR
            System.out.print("back in an hour");
        } */

        //¿Por qué falla? Porque ExhibitClosedForLunch ES UN ExhibitClosed (por herencia).
        //Entonces el primer catch (ExhibitClosed) ya atraparía CUALQUIER excepción de ese tipo, incluyendo las de la subclase.
        //El segundo catch nunca podría ejecutarse jamás → código inalcanzable → error de compilación.

        // ESTO SÍ COMPILA
        try {
            //seeAnimal();
        } catch (ExhibitClosedForLunch e) {  // subclase primero
            System.out.print("back in an hour");
        } catch (ExhibitClosed e) {          // superclase después
            System.out.print("not today");
        }

        //Ahora sí funciona porque Java revisa primero si es específicamente ExhibitClosedForLunch,
        //y si no lo es, cae al catch más general.

        //El siguiente ejemplo muestra tipos de excepciones que se heredan entre sí:

        /* public void visitMonkeys() {
            try {
                seeAnimal();
            } catch (ExhibitClosedForLunch e) {// subclase
                System.out.print("try back later");
            } catch (ExhibitClosed e) {// superclase
                System.out.print("not today");
            }
        } */

        //Si se lanza la excepción más específica ExhibitClosedForLunch, se ejecuta el primer bloque catch.
        //Si no, Java verifica si se lanza la excepción de la superclase ExhibitClosed y la captura.
        //Esta vez, el orden de los bloques catch sí importa. AL REVÉS NO FUNCIONARÍA:

        /* public void visitMonkeys() {
            try {
                seeAnimal();
            } catch (ExhibitClosed e) {
                System.out.print("not today");
            } catch (ExhibitClosedForLunch e) {// ESTO NO COMPILA
                System.out.print("try back later");
            } 
        } */

        //ESTO NO COMPILA PORQUE PRIMERO SE ESTÁ COLOCANDO LA SUPERCLASE EXCEPTION Y LUEGO LA SUBCLASE
        //lo que significa que no hay manera de que el segundo bloque catch se ejecute jamás. 
        //Java nos dice correctamente que hay un bloque catch inalcanzable.

        //OTRO EJEMPLO:

        /* public void visitSnakes() {
            try {
                seeAnimal();
            } catch (RuntimeException e) {
                System.out.print("runtime exception");
            } catch (ExhibitClosed e) {// ESTO NO COMPILA
                System.out.print("not today");
            } catch (Exception e) {
                System.out.print("exception");
            }
        } */

        //Es el mismo problema. ExhibitClosed es una RuntimeException.
        //Si se lanza, el primer bloque catch se encarga de ello, asegurándose de que no haya manera de llegar al segundo bloque catch.
        
        //En una sola ejecución del try, solo se puede lanzar UNA excepción
        //(un solo objeto de excepción, en un punto específico del código).
        //No es que ocurran varias excepciones en cadena dentro del mismo try.

    }

    public void Throwing_a_Second_Exception(){
        //Hasta ahora, nos hemos limitado a una sola sentencia try en cada ejemplo.
        //Sin embargo, un bloque catch o finally puede contener cualquier código Java válido, incluyendo otra sentencia try.

        //el examen OCA puede preguntarte sobre el manejo de excepciones con esas clases (leer archivos).

        //El siguiente código intenta leer un archivo:

        /* public static void main(String[] args) {
            FileReader reader = null;
            try {
                reader = read();
            } catch (IOException e) {
                try {
                    if (reader != null)  reader.close();
                } catch (IOException inner) {
                }
            }
        }

        private static FileReader read() throws IOException {
            EL CÓDIGO VA AQUÍ
        } */

        //LA IDEA PRINCIPAL ES QUE: puedes meter un try-catch DENTRO de otro catch.

        //ESCENARIOS POSIBLES:
        /* 
        Los 3 escenarios

        * 1.  read() no lanza nada
            - Todo bien, ni siquiera entra al catch externo. El programa sigue normal.

        * 2. read() lanza algo que NO es IOException (ej: NullPointerException)
            - El catch externo es específico para IOException, así que no la atrapa.
            - Esa excepción sigue su curso hacia arriba (se propaga), ignorando por completo este catch.

        * 3. read() SÍ lanza IOException ← aquí está lo interesante
            - Entra al catch externo.
            - Dentro, intenta cerrar el reader.
            - Aquí hay dos sub-posibilidades:
                a) close() funciona bien → el catch interno ni se usa, el método main() termina normal.
                b) close() también lanza IOException → el catch interno la atrapa... pero está vacío, no hace nada con ella. 
                Entonces esa excepción nueva sigue su camino y hace que main() termine con una excepción (crash).
        */

        //En el examen te van a dar código con nombres genéricos tipo letras o números 
        //para que te enfoques solo en el flujo de ejecución, sin distraerte con el contexto de la historia.

        /* try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            throw new RuntimeException();
        } finally {
            throw new Exception();
        } */

        /*
        Paso a paso

        * 1️.  En el try se lanza una RuntimeException.

        * 2️. El primer catch la atrapa (porque coincide el tipo).

        * 3️. Dentro del catch, se lanza otra RuntimeException nueva. Normalmente, esta sería la que se propaga hacia afuera del método.

        * 4️. PERO: antes de que esa excepción del catch pueda salir, Java siempre ejecuta el finally primero.
        *    Eso es una regla de oro: el finally se ejecuta sí o sí, sin importar qué pasó en el try o el catch.

        * 5️. el finally lanza su propia excepción (Exception).
        */

        //PRESTAR ATENCIÓN AL SGTE EJEMPLO (NIVEL DIFICIL):

        /* public String exceptions() {
            String result = "";
            String v = null;
            try {
                try {
                    result += "before";
                    v.length();     //lanza NullPointerException
                    result += "after";
                } catch (NullPointerException e) {
                    result += "catch";
                    throw new RuntimeException();
                } finally {
                    result += "finally";
                    throw new Exception();
                }
            } catch (Exception e) {
                result += "done";
            }
            return result;
        } */

        //result devuelve before catch finally done
        //ya que todo va bien hasta que se inserta el before, luego v.length(); lanza NullPointerException
        //y se va directo al catch, luego se añade el catch al result, después iba a lanzar otra exception, pero antes de que se propague
        //ejecuta el finally, entonces añade finally y despues lanza exception y se propaga. Después sale al catch externo que maneja
        //el exception y añade done.

    }

}
