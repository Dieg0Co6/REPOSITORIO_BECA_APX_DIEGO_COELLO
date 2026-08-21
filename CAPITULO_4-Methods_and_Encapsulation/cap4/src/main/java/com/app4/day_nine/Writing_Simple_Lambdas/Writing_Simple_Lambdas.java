package com.app4.day_nine.Writing_Simple_Lambdas;

import java.util.ArrayList;
import java.util.List;

public class Writing_Simple_Lambdas {
    //En Java 8, el lenguaje añadió la capacidad de escribir código usando otro estilo.
    //La programación funcional es una manera de escribir código de forma más declarativa.
    //Especificas lo que quieres hacer en lugar de lidiar con el estado de los objetos.Te concentras más en expresiones que en bucles. 
    //La programación funcional usa expresiones lambda para escribir código.

    //Una expresión lambda es un bloque de código que se pasa de un lugar a otro.
    //Puedes pensar en una expresión lambda como un método anónimo simple.
    //Tiene parámetros y un cuerpo, igual que los métodos completos, pero no tiene un nombre como un método real.
    //las expresiones lambda se llaman simplemente lambdas para abreviar.

    //Una expresión lambda es como un método que puedes pasar como si fuera una variable.

    public static void main(String[] args) {
        
        Writing_Simple_Lambdas writing_Simple_Lambdas = new Writing_Simple_Lambdas();
        writing_Simple_Lambdas.Lambda_Example();
        writing_Simple_Lambdas.Lambda_Syntax();
        writing_Simple_Lambdas.Predicates();
    }

    public void Lambda_Example(){
        //Ejmplo: imprimir todos los animales en una lista según algunos criterios. 

        //Sin lambdas:
        /* public class Animal {
            private String species;
            private boolean canHop;
            private boolean canSwim;
            public Animal(String speciesName, boolean hopper, boolean swimmer) {
                species = speciesName;
                canHop = hopper;
                canSwim = swimmer;
            }
            public boolean canHop() { return canHop; }
            public boolean canSwim() { return canSwim; }
            public String toString() { return species; }
        } */

        //La clase Animal tiene tres variables de instancia, que se establecen en el constructor.
        //Tiene dos métodos que obtienen el estado de si el animal puede saltar o nadar.
        //También tiene un método toString() para que podamos identificar fácilmente al Animal en los programas.

        //Para las verificaciones se implementa la sgte interfaz:

        /* public interface CheckTrait {
            boolean test(Animal a);
        }

        public class CheckIfHopper implements CheckTrait {
            public boolean test(Animal a) {
                return a.canHop();
            }
        } */

        //Teniendo esto, ahora sí tenemos todo lo que tenemos para listar los Animales que saltan:

        /* public class TraditionalSearch {
            public static void main(String[] args) {
                List<Animal> animals = new ArrayList<Animal>();  // lista de animales
                animals.add(new Animal("fish", false, true));
                animals.add(new Animal("kangaroo", true, false));
                animals.add(new Animal("rabbit", true, false));
                animals.add(new Animal("turtle", false, true));

                print(animals, new CheckIfHopper());      // clase pasada que hace la verificación
            }
            
            private static void print(List<Animal> animals, CheckTrait checker) {   //metodo estatico que imprime
                for (Animal anima : animals) {
                  if (checker.test(animal))               // verifica si son animales que saltan
                    System.out.print(animal + " ");
                }
                System.out.println();
            }
        } */

        //El método print() en la línea 11 es muy general: puede verificar cualquier característica. Esto es un buen diseño.
        //No debería necesitar saber específicamente qué estamos buscando para imprimir una lista de animales.
        //Ahora, ¿qué pasa si queremos imprimir los animales que nadan? 
        //Pues, necesitamos escribir otra clase CheckIfSwims.
        //Luego necesitamos añadir una nueva línea debajo que instancie esa clase. Eso son dos cosas solo para hacer otra verificación.
        //Con expresiones lambda. Podríamos repetir toda esa clase aquí y hacer que encuentres la línea que cambió.
        //En cambio, solo te lo mostraremos. Podríamos reemplazar print(animals, new CheckIfHopper()); con lo siguiente, que usa una lambda:

        /* print(animals, a -> a.canHop()); */

        //Le estamos diciendo a Java que solo nos importan los Animales que pueden saltar.

        /* print(animals, a -> a.canSwim()); */

        //y de los animales que no pueden nadar:

        //print(animals, a -> ! a.canSwim());


        //EN POCAS PALABRAS: Lambda (a -> a.canHop()) Es la Implementación rápida del método test(), sin crear una clase aparte (CheckIfHopper)

        //Este código usa un concepto llamado ejecución diferida.
        //Ejecución diferida significa que el código se especifica ahora, pero se ejecutará después.
        //En este caso, después es cuando el método print() lo llama.
    }

    public void Lambda_Syntax(){
        //Una de las expresiones lambda más simples que se puede escribir es la que acabamos de ver:

        //a -> a.canHop();

        //En el ejemplo anterior Java intenta mapear nuestra lambda a esa interfaz:

        //boolean test(Animal a);

        //Como el método de esa interfaz toma un Animal, eso significa que el parámetro del lambda tiene que ser un Animal.
        //Y como el método de esa interfaz devuelve un booleano, sabemos que el lambda devuelve un booleano.

        //La sintaxis de los lambdas es complicada porque muchas partes son opcionales. Estas dos líneas hacen exactamente lo mismo:

        /* a -> a.canHop()
        (Animal a) -> { return a.canHop(); } */

        /* EXPLICANDO UN POCO LA SINTAXIS DE LAS EXPRESIONES LAMBDAS TENEMOS LO SIGUIENTE:
            * Especificar un solo parámetro con el nombre a
            * El operador de flecha para separar el parámetro y el cuerpo
            * Un cuerpo que llama a un solo método y devuelve el resultado de ese método
        */

        //Tener en cuenta dos cosas:
        //una que a debe ser de tipo Animal
        //el metodo que se pasa en el cuerpo debe retornar un boolean, como está en el contrato de la interfaz.

        //Los paréntesis solo se pueden omitir si hay un único parámetro y su tipo no se indica explícitamente
        //Se puede omitir las llaves cuando solo tenemos una instrucción. Al igual que con la sentencia IF y los bucles
        //Lo diferente aquí es que las reglas cambian cuando omites las llaves.
        //Java no requiere que escribas return ni uses un punto y coma cuando no se usan llaves.
        //Este atajo especial no funciona cuando tenemos dos o más instrucciones.

        /* print(() -> true);                                       // 0 parametros
        print(a -> a.startsWith("test"));                        // 1 parametro
        print((String a) -> a.startsWith("test"));               // 1 parametro
        print((a, b) -> a.startsWith("test"));                   // 2 parametros
        print((String a, String b) -> a.startsWith("test"));     // 2 parametros */


        //Ahora, cual de los sgtes es invalida

        /* print(a, b -> a.startsWith("test"));                 // NO COMPILA PORQUE SON 2 PARAMETROS, DEBEN TENER PARENTESIS
        print(a -> { a.startsWith("test"); });      // NO COMPILA, CUANDO TIENE LLAVES, LE FALTA LA PALABRA CLAVE RETURN
        print(a -> { return a.startsWith("test") });  // NO COMPILA, PORQUE SIEMPRE AL FINAL DEBE TENER SU PUNTO Y COMA.
         */

        //RECORDAR QUE: los paréntesis solo son opcionales cuando hay un parámetro y no tiene tipo declarado

        //Se permite que los lambdas accedan a variables. EJM:

        /* boolean wantWhetherCanHop = true;
        print(animals, a -> a.canHop() == wantWhetherCanHop); */

        //Pero no pueden acceder a todas las variables. Las variables de instancia y estáticas están bien.
        //Los parámetros de los métodos y las variables locales están bien si no se les asignan nuevos valores.

        //Hay un problema más que podrías notar con los lambdas.
        //Hemos estado definiendo una lista de argumentos en nuestras expresiones lambda.
        //Dado que Java no nos permite redeclarar una variable local, lo siguiente es un problema:

        //(a, b) -> { int a = 0; return 5;}     // NO COMPILA. YA QUE COMO YA SE ESTÁ DECLARANDO a COMO PARAMETRO,
                                               // NO SE PUEDE VOLVER A REDECLARAR UNA VARIABLE CON EL MISMO NOMBRE. 

        //Intentamos redeclarar a, lo cual no está permitido.
        //En cambio, la siguiente línea está bien porque usa un nombre de variable diferente:

        //(a, b) -> { int c = 0; return 5;}
    }

    public void Predicates(){
        
    }
}
