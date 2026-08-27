package com.app6.day_thirteen.Understanding_Exceptions;

import java.util.ArrayList;

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
        understanding_Exceptions.The_Role_of_Exceptions();
        understanding_Exceptions.Understanding_Exception_Types();
        understanding_Exceptions.Throwing_an_Exception();
    }

    public void The_Role_of_Exceptions(){
        //Una excepción es la manera de Java de decir: “Me rindo. No sé qué hacer en este momento. Tú lidias con esto.”
        //Cuando se escribe un método, puedes manejar la excepción tú mismo o hacer que sea un problema del código que lo llama.

        //Estos son los dos enfoques que Java usa al lidiar con excepciones.
        //Un método puede manejar la excepción por sí mismo o hacer que sea responsabilidad del que lo llama.

        //Ejmplo del Capítulo 1 (ahí se vio una excepción):
        //Colocamos este codigo en la clase Zoo
        /* public class Zoo {
            public static void main(String[] args) {
                System.out.println(args[0]);
                System.out.println(args[1]);
            } 
        } */

        //Luego en consola, escribimos estos comandos, el cual le pasamos sin los suficientes argumentos:

        //$ javac Zoo.java (compilamos)
        //$ java Zoo Zoo   (llamamos solo con un argumento)

        //En la línea 4, Java se dio cuenta de que solo hay un elemento en el arreglo y que el índice 1 no está permitido.
        //Java se rindió y lanzó una excepción. No intentó manejar la excepción. Simplemente dijo:
        //“No puedo lidiar con esto” y se mostró la excepción:

        /* ZooException in thread "main" 
        java.lang.ArrayIndexOutOfBoundsException: 1
        at mainmethod.Zoo.main(Zoo.java:7) */

        //Las excepciones pueden y ocurren todo el tiempo, incluso en código de programa sólido.

        //Cuando escribas programas más avanzados, tendrás que lidiar con fallos al acceder a archivos, redes y servicios externos.

        //En el examen, las excepciones se relacionan principalmente con errores en los programas.
        //Por ejemplo, un programa podría intentar acceder a una posición inválida en un arreglo.
        //
        
        //==================================================================
        //Códigos de Retorno vs. Excepciones
        //==================================================================
        //Las excepciones se usan cuando “algo sale mal.” Sin embargo, la palabra “mal” es subjetiva.
        //El siguiente código devuelve –1 en lugar de lanzar una excepción si no se encuentra ninguna coincidencia:

        /* public int indexOf(String[] names, String name) {
            for (int i = 0; i < names.length; i++) {
                if (names[i].equals(name)) { return i; }
            }
            return -1;
        } */
        
        /* 
        Hay dos formas de decirle a quien usa tu método "oye, algo pasó":
        * Código de retorno (return -1, null, etc.)
        * Excepción (lanzar un error que hay que manejar) 
        */

        /* Búsquedas -> usar código de retorno (-1)
        Si buscas "Joe" en una lista de nombres y no está, no es un error. Es un resultado válido y esperado.
        Es normal que alguien no esté en la lista.
        Además, los programadores ya están acostumbrados a que las búsquedas devuelvan -1 o null cuando no encuentran nada.
        Es una convención conocida. 
        */

        /* Casos raros/graves -> usa excepción
        Si le pasas null como el array de nombres, eso no debería pasar nunca en un uso normal.
        Es una condición verdaderamente anormal, así que ahí sí lanzas una excepción.
        */

        //EN RESUMEN:
        //Usa -1/valores especiales solo cuando sea algo esperado (como no encontrar algo en una búsqueda).
        //Para todo lo demás que sea realmente anormal, usa excepciones, porque estas no se pueden ignorar tan fácilmente.
    }

    public void Understanding_Exception_Types(){
        //Como se ha explicado, una excepción es un evento que altera el flujo del programa.
        //Java tiene una superclase Throwable para todos los objetos que representan estos eventos.
        //No todos ellos tienen la palabra exception en su nombre de clase, lo cual puede ser confuso.
        /*
         * Jerarquía de excepciones en Java:
         *
         *                  java.lang.Object
         *                         │
         *                  java.lang.Throwable
         *                    /            \
         *      java.lang.Exception      java.lang.Error
         *              │
         *      java.lang.RuntimeException
         *
         * - Throwable: clase raíz de todo lo que se puede lanzar (throw) y capturar (catch).
         * - Error: problemas graves del sistema/JVM (ej: OutOfMemoryError). No se deben manejar normalmente.
         * - Exception: errores que la aplicación puede querer capturar y manejar.
         * - RuntimeException: excepciones no verificadas (unchecked), no obligan a usar try/catch
         *   ni declarar "throws" (ej: NullPointerException, ArrayIndexOutOfBoundsException).
         * - Exception (sin ser RuntimeException) son excepciones verificadas (checked),
         *   el compilador obliga a manejarlas con try/catch o declararlas con "throws".
         */

        //Error significa que algo salió tan mal que tu programa no debería intentar recuperarse.
        //Por ejemplo, que el disco duro “desapareciera.” Estas son condiciones anormales que probablemente no vas a encontrar.
        //Una excepción en tiempo de ejecución se define como la clase RuntimeException y sus subclases.
        //Las excepciones en tiempo de ejecución tienden a ser inesperadas, pero no necesariamente fatales.
        //Por ejemplo, acceder a un índice de arreglo inválido es inesperado.
        //Las excepciones en tiempo de ejecución también se conocen como excepciones no verificadas.


        //========================================================================
        //Tiempo de ejecución vs. en el momento en que se ejecuta el programa
        //========================================================================
        //Técnicamente, TODAS las excepciones (checked y unchecked) ocurren en tiempo de ejecución, no al compilar.
        // Pero si se dijera "excepción de tiempo de ejecución" para describir eso, SE CONFUNDIRÍA CON RUNTIMEEXCEPTION.
        // Por eso nadie usa esa frase así.

        //Cuando alguien dice "runtime exception", siempre se refiere a RuntimeException (unchecked),
        //no a "una excepción que pasó mientras el programa corría".
        //========================================================================

        //Una excepción verificada (checked) incluye Exception y todas las subclases que no extienden RuntimeException (unchecked).
        //Las excepciones verificadas tienden a ser más previsibles; por ejemplo, intentar leer un archivo que no existe.

        //¿Excepciones verificadas? Sí, Java tiene una regla llamada la regla de manejar o declarar.
        //Para las excepciones verificadas, Java requiere que el código o las maneje o las declare en la firma del método.
        //Por ejemplo, este método declara que podría lanzar una excepción:

        /* void fall() throws Exception {
            throw new Exception();
        } */

        //En el anterior ejemplo, la firma throws Exception NO garantiza que el método vaya a lanzar la excepción.
        // Solo es un aviso al compilador

        //Fíjate que estás usando dos palabras clave diferentes aquí. throw le dice a Java que quieres lanzar una Excepción.
        //throws simplemente declara que el método podría lanzar una Excepción. O tal vez no

        //Como las excepciones verificadas tienden a ser anticipadas,
        //Java exige que el programador haga algo para mostrar que se pensó en la excepción.
        //Tal vez se manejó dentro del método. O tal vez el método declara que no puede manejar la excepción y
        //que alguien más debería hacerlo.

        //Un ejemplo de excepción en tiempo de ejecución es NullPointerException, que ocurre cuando intentas llamar a un miembro
        //de una referencia nula. Esto puede pasar en cualquier método.


        //============================================================================
        //Excepciones comprobadas vs. no comprobadas (en tiempo de ejecución)
        //============================================================================
        //Antes: se usaban mucho las excepciones comprobadas (checked), pensadas para errores de los que el programador puede recuperarse.
        //Problema real: en la práctica, terminaban pasando la excepción de método en método (throws) sin que nadie realmente la manejara.
        //Era ruido, no protección real.
        //Ahora: muchas bibliotecas prefieren usar RuntimeException (unchecked) incluso para errores recuperables,
        //porque es más simple y no obliga a ese "arrastre" de throws.
        //============================================================================

    }

    public void Throwing_an_Exception(){
        //Cualquier código Java puede lanzar una excepción

        //Para el examen: Lo más probable es que sean excepciones que vienen con Java.
        //Podría encontrarme con una excepción que se inventó para el examen.
        //La pregunta dejará claro que son excepciones porque el nombre de la clase terminará con 'Exception'.
        //Por ejemplo, 'MyMadeUpException'

        //En el examen, verás dos tipos de código que resultan en una excepción. El primero es código que está mal. Por ejemplo:
        /* String[] animals = new String[0];
        System.out.println(animals[0]);  */

        //El codigo anterior lanza lo siguiente:
        //Este código lanza una ArrayIndexOutOfBoundsException.
        //Eso significa que las preguntas sobre excepciones pueden estar escondidas en preguntas que parecen ser sobre otra cosa.

        //PARA EL EXAMEN:
        //La gran mayoría de las preguntas tienen una opción sobre que no compila y sobre que lanza una excepción.
        //Se debe prestar mucha atención al código que llama a un método en un objeto null o que hace referencia a un índice
        //inválido de un array o ArrayList.
        //Si notas esto, sabes que la respuesta correcta es que el código lanza una excepción.


        //La segunda manera en que un código puede provocar una excepción es solicitar explícitamente a Java que lance una.
        //Java te permite escribir declaraciones como estas:

        /* throw new Exception();
        throw new Exception("Ow! I fell."); */
        throw new RuntimeException();
        //throw new RuntimeException("Ow! I fell.");

        //La palabra clave throw le dice a Java que quieres que otra parte del código se encargue de la excepción.
        //Alguien más necesita averiguar qué hacer con la excepción.Al crear una excepción, normalmente puedes pasar un
        //parámetro String con un mensaje o no pasar ningún parámetro y usar los valores predeterminados.

        //Los dos primeros ejemplos crean un nuevo objeto de tipo Exception y lo lanzan.
        //Los últimos dos muestran que el código se ve igual sin importar qué tipo de excepción lances.


        //REGLAS IMPORTANTES:
        /*
         * Tipos de excepciones en Java:
         *
         * ┌────────────────────┬─────────────────────────────────┬───────────┬───────────────┐
         * │ Tipo               │ Cómo se reconoce                │¿Se puede  │ ¿Obligatorio  │
         * │                    │                                 │ capturar? │ manejarla?    │
         * ├────────────────────┼─────────────────────────────────┼───────────┼───────────────┤
         * │ RuntimeException   │ Subclase de RuntimeException    │ Sí        │ No            │
         * │ (unchecked)        │                                 │           │               │
         * ├────────────────────┼─────────────────────────────────┼───────────┼───────────────┤
         * │ Exception          │ Subclase de Exception, pero NO  │ Sí        │ Sí (try/catch │
         * │ (checked)          │ de RuntimeException             │           │ o throws)     │
         * ├────────────────────┼─────────────────────────────────┼───────────┼───────────────┤
         * │ Error              │ Subclase de Error               │ No debería│ No            │
         * │                    │ (problema grave de la JVM)      │           │               │
         * └────────────────────┴─────────────────────────────────┴───────────┴───────────────┘
         *
         * Regla clave: las tres se PUEDEN capturar con try/catch,
         * pero solo las checked exceptions OBLIGAN a hacerlo
         * (con try/catch o declarando "throws" en la firma del método).
         */
    }

}
