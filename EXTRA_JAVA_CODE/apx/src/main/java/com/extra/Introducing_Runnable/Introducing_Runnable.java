package com.extra.Introducing_Runnable;

public class Introducing_Runnable {

    //Runnable, abreviado, es una interfaz funcional que no toma argumentos y no devuelve datos.
    //A continuación se muestra la definición de la interfaz Runnable:

    @FunctionalInterface  
    public interface Runnable { 
        void run();} 

    //La interfaz Runnable se usa comúnmente para definir el trabajo que un hilo va a ejecutar, separado del hilo principal de la aplicación.
    //Vamos a depender de la interfaz Runnable a lo largo de este capítulo, especialmente cuando hablemos de aplicar operaciones 
    //en paralelo a los streams.

    //Las siguientes expresiones lambda dependen cada una de la interfaz Runnable:
    /*
    () -> System.out.println("Hello World") 
    () -> {int i=10; i++;} 
    () -> {return;} 
    () -> {} 
     */

    //DEBEN CUMPLIR DOS CONDICIONES:
    //1. CERO PARAMETROS
    //2. NO RETORNAR NINGUN VALOR

    //POR ESTAS RAZONES, AHORA MIRA las siguientes lambdas, aunque son válidas para otras interfaces funcionales,
    //no son compatibles con Runnable:

    /* () -> ""     //DEVUELVE UN STRING VACÍO
    () -> 5         //DEVUELVE 5
    () -> {return new Object();}    //DEVUELVE UN NUEVOB OBJETO DE TIPO OBJECT*/ 

    public static void main(String[] args) {
        Introducing_Runnable introducing_Runnable = new Introducing_Runnable();
        introducing_Runnable.Creating_Runnable_Classes();

    }

    public void Creating_Runnable_Classes(){
        //Runnable Fue, y todavía es, comúnmente usada para definir una tarea de hilo creando una clase que implemente la interfaz Runnable,
        //como se muestra en el siguiente código:

        /* public class CalculateAverage implements Runnable { 
            public void run() { 
                -- Define work here 
            } 
        }  */

        //También es útil si necesitas pasar información a tu objeto Runnable para que sea utilizada por el método run(),
        //como en el siguiente constructor de clase:

        /* public class CalculateAverages implements Runnable { 
            private double[] scores; 
            public CalculateAverages(double[] scores) { 
                this.scores = scores; 
            } 
            public void run() { 
                // Define work here that uses the scores object 
            } 
        }  */
    }
}
