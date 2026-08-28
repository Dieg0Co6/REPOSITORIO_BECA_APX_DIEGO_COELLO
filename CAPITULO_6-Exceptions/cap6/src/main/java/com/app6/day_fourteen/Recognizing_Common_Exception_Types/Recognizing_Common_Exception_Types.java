package com.app6.day_fourteen.Recognizing_Common_Exception_Types;

public class Recognizing_Common_Exception_Types {

    public static void main(String[] args) {
        /* 
        Necesitas reconocer tres tipos de excepciones para el examen OCA:
        * excepciones en tiempo de ejecución
        * excepciones verificadas
        * errores.
        
        Vamos a ver ejemplos comunes de cada tipo.
        Para el examen, se necesitará identificar qué tipo de excepción es y si la lanza la JVM o un programador. 
        Para que puedas reconocerlas, te mostraremos algunos ejemplos de código de esas excepciones.
        */

        Recognizing_Common_Exception_Types recognizing_Common_Exception_Types = new Recognizing_Common_Exception_Types();
        recognizing_Common_Exception_Types.Runtime_Exceptions();
        recognizing_Common_Exception_Types.Checked_Exceptions();
        recognizing_Common_Exception_Types.Errors();
    }

    public void Runtime_Exceptions(){
        //Las excepciones en tiempo de ejecución extienden RuntimeException.
        //No tienen que ser manejadas o declaradas (OPCIONALES).Pueden ser lanzadas por el programador o por la JVM.
        //Las más comunes son las siguientes:
        this.ArithmeticException();
        this.ArrayIndexOutOfBoundsException();
        this.ClassCastException();
        this.IllegalArgumentException();
        this.NullPointerException();
        this.NumberFormatException();
    }

    private void ArithmeticException(){
        //Lanzado por la JVM cuando el código intenta dividir entre cero

        //Intentar dividir un int por cero da un resultado indefinido.
        // Cuando esto ocurre, la JVM lanzará una ArithmeticException

        int answer = 11 / 0;

        //Ejecutar este código produce la siguiente salida:
    
        //Excepción en el hilo "main" java.lang.ArithmeticException: división por cero

        //Sabemos que / es el operador de división y que Java está tratando de decirnos que ocurrió una división entre cero.
        //El hilo "main" nos está diciendo que el código fue llamado directa o indirectamente desde un programa con un método main. 
        //En el examen OCA, esto es todo lo que veremos como salida. 

        // Luego viene el nombre de la excepción, seguido de información extra (si la hay) que acompaña a la excepción.
    }

    private void ArrayIndexOutOfBoundsException(){
        //Lanzado por la JVM cuando el código usa un índice ilegal para acceder a un arreglo

        //Ya sabes que los índices de los arrays comienzan en 0 y van hasta uno menos que la longitud del array,
        //lo que significa que este código lanzará una ArrayIndexOutOfBoundsException:

        int[] countsOfMoose = new int[3];
        System.out.println(countsOfMoose[-1]); //lanza un ArrayIndexOutOfBoundsException

        //Esto es un problema porque no existe algo como un índice de arreglo negativo. 

        //Ejecutar este código produce la siguiente salida:

        //Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1

        //Al menos Java nos dice qué índice fue inválido.

        //otro ejemplo:

        int total = 0;
        int[] countsOfMoose2 = new int[3];
        for (int i = 0; i <= countsOfMoose2.length; i++) 
        total += countsOfMoose2[i]; 

        //El problema es que el for tiene la condición que el indice llegue al numero igual al tamaño del arreglo (<=)
        //el cual genera, dicho indice no existe (porque comienza desde 0).

        //el bucle for debería tener < en lugar de <=. En la última iteración del bucle, Java intenta llamar a countsOfMoose[3],
        //lo cual no es válido. El arreglo solo tiene tres elementos, así que 2 es el índice más grande posible.

        //La salida se ve así: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    }
    
    private void ClassCastException(){
        //Lanzado por la JVM cuando se intenta convertir una excepción a una subclase de la que no es una instancia

        //Java intenta protegerte de conversiones imposibles. 
        //Este código no se compila porque Integer no es una subclase de String:

        /*String type = "moose";
        Integer number = (Integer) type;  // NO COMPILA */

        //Un código más complicado frustra los intentos de Java de protegerte.
        //Cuando la conversión falla en tiempo de ejecución, Java lanzará una ClassCastException:

        String type = "moose";
        Object obj = type;
        Integer number = (Integer) obj; 

        //El compilador ve un casteo de Object a Integer. Eso podría estar bien.
        //El compilador no se da cuenta de que hay un String en ese Object. Cuando el código se ejecuta, da como resultado la salida:

        //Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer

    }

    private void IllegalArgumentException(){
        //Lanzado por el programador para indicar que a un método se le ha pasado un argumento ilegal o inapropiado

        //IllegalArgumentException es una forma de que tu programa se proteja a sí mismo. ejm:

        /* public void setNumberEggs(int numberEggs) {// setter
            if (numberEggs >= 0) // condición de guardia
                this.numberEggs = numberEggs;
        } */

        //Este código funciona, pero realmente no queremos ignorar la solicitud del que llama cuando nos dicen que un cisne
        //tiene -2 huevos. Queremos decirle al que llama que algo está mal, de preferencia de una manera muy evidente que no
        //puedan ignorar para que el programador arregle el problema. Las excepciones son una manera eficiente de hacer esto.
        
        //Así que para comunicarle, hacemos lo siguiente:

        /* public static void setNumberEggs(int numberEggs) {
            if (numberEggs < 0) 
                throw new IllegalArgumentException("el numero de huevos no debe ser negativo");
            this.numberEggs = numberEggs;
        } */

        //El programa lanza una excepción cuando no está contento con los valores de los parámetros. La salida se ve así:

        //Exception in thread "main" java.lang.IllegalArgumentException: el numero de huevos no debe ser negativo

        //Claramente, este es un problema que debe arreglarse si el programador quiere que el programa haga algo útil.
    }

    private void NullPointerException(){
        // Lanzado por la JVM cuando hay una referencia nula donde se requiere un objeto

        //Las variables de instancia y los métodos deben llamarse sobre una referencia que no sea nula.

        //Si la referencia es nula, la JVM lanzará una NullPointerException.

        String name;
        /* public void printLength() throws NullPointerException {
            System.out.println(name.length());
        } */

        //Ejecutar este código produce este resultado:
        //Exception in thread "main" java.lang.NullPointerException
    }

    private void NumberFormatException(){
        //Lanzado por el programador cuando se intenta convertir una cadena a un tipo numérico
        //pero la cadena no tiene un formato adecuado

        //Java proporciona métodos para convertir cadenas en números.
        //Cuando se les pasa un valor inválido, lanzan una NumberFormatException. 

        //La idea es similar a IllegalArgumentException. Como este es un problema común, Java le da una clase separada. 

        //De hecho, NumberFormatException es una subclase de IllegalArgumentException.

        //Ejm de intentar convertir algo no numérico en un int:

        Integer.parseInt("abc");

        //La salida se ve así:

        //Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
    }

    public void Checked_Exceptions(){
        //Las excepciones verificadas tienen Exception en su jerarquía pero no RuntimeException.
        //Deben ser manejadas o declaradas.
        //Pueden ser lanzadas por el programador o por la JVM.

        this.FileNotFoundException();
        this.IOException();
    }

    private void FileNotFoundException(){
        //Se lanza automáticamente cuando el código intenta hacer referencia a un archivo que no existe
    }

    private void IOException(){
        //Se lanza de manera programática cuando hay un problema al leer o escribir un archivo

        //Para el examen OCA, solo necesitas saber que estas son excepciones verificadas.
        //También ten en cuenta que FileNotFoundException es una SUBCLASE de IOException,
        //aunque el examen te recordará ese hecho si aparece.
    }

    public void Errors(){
        //Los errores extienden la clase Error.

        //Son lanzados por la JVM y NO deberían ser manejados ni declarados.
        //Los errores son raros, pero podrías ver estos:

        this.ExceptionInInitializerError();
        this.StackOverflowError();
        this.NoClassDefFoundError();
    }

    private void ExceptionInInitializerError(){
        //Lanzado por la JVM cuando un inicializador estático lanza una excepción y no la maneja

        //CUANDO UNA VARIABLE ESTÁTICA O BLOQUE INICIALIZADOR ESTÁTICO lanza una excepción durante su inicialización,
        //ENTONCES SE LANZA ExceptionInInitializerError

        //Java ejecuta inicializadores estáticos la primera vez que se usa una clase. Si uno de los inicializadores estáticos
        //lanza una excepción, Java no puede empezar a usar la clase. Declara la derrota lanzando un ExceptionInInitializerError. 

        //El siguiente código muestra un ArrayIndexOutOfBounds en un inicializador estático:

        /* static {
            int[] countsOfMoose = new int[3];
            int num = countsOfMoose[-1];
        }
        public static void main(String[] args) { } */

        //Este código proporciona información sobre dos excepciones:
        //Exception in thread "main" java.lang.ExceptionInInitializerError
        //Caused by: java.lang.ArrayIndexOutOfBoundsException: -1

        //Obtenemos el ExceptionInInitializerError porque el error ocurrió en un inicializador estático.
        //Esa información por sí sola no sería muy útil para solucionar el problema.

        //Por eso, Java también nos dice la causa original del problema: el ArrayIndexOutOfBoundsException que necesitamos arreglar.
        //El ExceptionInInitializerError es un error porque Java no pudo cargar toda la clase. Este fallo evita que Java continúe.
    }

    private void StackOverflowError(){
        //Lanzado por la JVM cuando un método se llama a sí mismo demasiadas veces
        //(esto se llama recursión infinita porque el método normalmente se llama a sí mismo sin fin)

        //Cuando Java llama a métodos, pone los parámetros y las variables locales en la pila.
        //Después de hacer esto muchísimas veces, la pila se queda sin espacio y se desborda.
        //Esto se llama un StackOverflowError. La mayoría de las veces, este error ocurre cuando un método se llama a sí mismo.

        //EJM:

        /* public static void doNotCodeThis(int num) {
            doNotCodeThis(1);
        } */
        
        //La salida contiene esta línea:

        //Exception in thread "main" java.lang.StackOverflowError

        //Como el método se llama a sí mismo, nunca terminará. Eventualmente, Java se queda sin espacio en la pila y lanza el error.
        //Esto se llama recursión infinita. Es mejor que un bucle infinito porque al menos Java lo detectará y lanzará el error.
        //Con un bucle infinito, Java simplemente usa toda tu CPU hasta que puedes cerrarlo.
    }

    private void NoClassDefFoundError(){
        //Lanzado por la JVM cuando una clase que el código usa está disponible en tiempo de compilación pero no en tiempo de ejecución

        //Este error no aparecerá en el código del examen; solo necesitas saber que es un error.
        
        //NoClassDefFoundError ocurre cuando Java no puede encontrar la clase en tiempo de ejecución.
    }
}
