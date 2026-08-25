package com.app5.Implementing_Interfaces;

public class Implementing_Interfaces {

    //Aunque Java no permite la herencia múltiple, sí permite que las clases implementen cualquier cantidad de interfaces.
    //Una interfaz es un tipo de dato abstracto que define una lista de métodos públicos abstractos que cualquier clase que
    //implemente la interfaz debe proporcionar. 

    //Una interfaz también puede incluir una lista de variables constantes y métodos por defecto

    //En Java, una interfaz se define con la palabra clave interface.
    //Una clase invoca la interfaz usando la palabra clave implements en su definición de clase.. EJMPLO:


    //DEFINIENDO UNA INTERFACE:
    /* public abstract interface Animal{
        public static final int MINIMUM_DEPTH = 2;
        public abstract int getMaximumDepth();
    } */

    //IMPLEMENTANDO UNA INTERFACE
    /*public class Perro implements Animal, Zoo{
        public int getMaximumDepth() {
            return 10;
        }
    }*/

    //COMO SE PUEDE VER, UNA INTERFACE NO SE DECLARA COMO UNA CLASE ABSTRACT,
    //aunque tenga muchas de las mismas propiedades de una clase abstracta.

    //Un método de interfaz declarado sin default, static o private es implícitamente public abstract.
    //En otras palabras, tanto si los provees como si no, el compilador los insertará automáticamente como parte de la definición
    //del método. 

    //Una clase puede implementar múltiples interfaces, cada una separada por una coma. EJM:

    /* public class Elephant implements WalksOnFourLegs, HasTrunk, Herbivore {
    } */

    //En el ejemplo, si alguna de las interfaces definiera métodos abstractos,
    //la clase concreta Elephant tendría que implementar esos métodos.

    public static void main(String[] args) {
        Implementing_Interfaces implementing_Interfaces = new Implementing_Interfaces();
        implementing_Interfaces.Defining_an_Interface();
        implementing_Interfaces.Inheriting_an_Interface();
    }

    public void Defining_an_Interface(){
        //Las interfaces son muy parecidas a la clases abstractas, y comparten varias características.
        //A continuación unas reglas para definir una interfaz.

        /* 
            * 1. Las interfaces no se pueden instanciar directamente.
            * 2. Una interfaz puede definirse sin declarar ningún método en su interior. 
            * 3. Una interfaz no puede marcarse como final.
            * 4. Todas las interfaces de nivel superior se asumen con acceso público o por defecto, y deben incluir el modificador abstract en su definición
            * (SI NO SE COLOCA ABSTRACT, LO ASUME IMPLICITAMENTE).
            * Por lo tanto, marcar una interfaz como privada, protegida o final generará un error de compilación, ya que esto es incompatible con estas suposiciones.
            * 5. Todos los métodos que no sean predeterminados en una interfaz se asumen con los modificadores abstract y public en su definición. Por lo tanto, marcar un método como privado, protegido o final generará errores de compilación, ya que estos son incompatibles con las palabras clave abstract y public
        */

        //La cuarta regla no se aplica a las interfaces internas, aunque las clases e interfaces internas no están dentro del alcance del examen OCA
        //TENER EN CUENTA QUE LAS 3 PRIMERAS REGLAS SON IGUALES QUE LAS 3 PRIMERAS REGLAS PARA DEFINIR UNA CLASE ABSTRACTA.

        //EJMPLO, TENEMOS LO SIGUIENTE:
        
        /* public interface WalksOnTwoLegs {} */        //Se compila sin problema, ya que no se requiere que las interfaces definan ningún método.

        //OTRO EJMPLO:

        /* public class TestClass {
            public static void main(String[] args) {
                WalksOnTwoLegs example = new WalksOnTwoLegs();  // NO COMPILA PORQUE UNA INTERFACE NO SE PUEDE INSTANCIAR.
            }
        }
        public final interface WalksOnEightLegs {  // NO COMPILA PORQUE SE COLOCÓ LA PALABRA FINAL EN EL INTERFACE
        } */

        //El primer ejemplo no se compila, ya que WalksOnTwoLegs es una interfaz y no se puede instanciar directamente.
        // El segundo ejemplo, WalksOnEightLegs, no se compila porque las interfaces no pueden marcarse como final 

        //La cuarta y quinta regla sobre "palabras clave asumidas" resultan nuevas, pero significan lo sgte:
        //Puedes proporcionar estos modificadores tú mismo, aunque el compilador los insertará automáticamente si no lo haces. EJM:

        //LOS SIGUIENTES EJEMPLOS SON EQUIVALENTES (ya que el compilador las convertirá a ambas en el segundo ejemplo):

        /* public interface CanFly {       //Interfaz sin especificar la palabra clave Abstract
            void fly(int speed);        //Metodo void, sin especificar el public abstract
            abstract void takeoff();    //Metodo void, sin especificar el public 
            public abstract double dive();  //metodo especificando el public abstract
        }
        public abstract interface CanFly {      //Segundo ejemplo, especificando el public abstract en la interfaz.
            public abstract void fly(int speed);    //Metodo especificando el public abstract
            public abstract void takeoff();         //Metodo especificando el public abstract
            public abstract double dive();          //Metodo especificando el public abstract
        } */

        //En este ejemplo, la palabra clave abstract se añade automáticamente primero a la definición de la interfaz.
        //Luego, a cada método se le añaden las palabras clave abstract y public.
        //Si el método ya tiene alguna de estas palabras clave, entonces no se requiere ningún cambio.

        //OTRO EJEMPLO:

        /* private final interface CanCrawl {  // NO COMPILA PORQUE TIENE EL FINAL Y EL MODIFICADOR DE ACCESO PRIVATE (DEBE SER PUBLIC O PACKAGE PRIVATE - SIN MODIFICADOR DE ACCESO)
            private void dig(int depth);  // NO COMPILA PORQUE LOS METODOS SE ASUMEN COMO PUBLICOS
            protected abstract double depth();  // NO COMPILA PORQUE LOS METODOS SE ASUMEN COMO PUBLICOS
            public final void surface();  // NO COMPILA PORQUE TIENE EL FINAL
        } */

        //La primera línea no compila por dos razones. Primero, está marcada como final, lo cual no se puede aplicar a una interfaz ya que entra en conflicto
        //con la palabra clave abstract implícita. Luego, está marcada como private, lo que choca con el acceso público o por defecto que se requiere en las interfaces.
        //La segunda y tercera línea no compilan porque todos los métodos de la interfaz se asumen como públicos y marcarlos como private o protected
        //provoca un error de compilación.
        //Finalmente, la última línea no compila porque el método está marcado como final y, dado que los métodos de la interfaz se asumen abstractos,
        //el compilador lanza un error por usar palabras clave abstract y final al mismo tiempo en un método.

        //=======================================================================================================
        //VERIFICAR BIEN LOS MODIFICADORES DE ACCESO EN INTERFACES.
        //Probablemente habrá al menos una pregunta en el examen en la que una interfaz o un método de interfaz use un modificador inválido.
    }

    public void Inheriting_an_Interface(){
        /*
        Hay dos reglas de herencia que se debe tener en cuenta al extender una interfaz:
        * 1. Una interfaz que extiende a otra interfaz, así como una clase abstracta que implementa una interfaz,
        * hereda todos los métodos abstractos como sus propios métodos abstractos.
        * 
        * 2. La primera clase concreta que implementa una interfaz, o que extiende una clase abstracta que implementa una interfaz,
        * debe proporcionar una implementación para todos los métodos abstractos heredados.
        */

        //Ejemplo de la regla 1:

        /* interface Volador {
            void volar();
        }

        interface Nadador {
            void nadar();
        }

        // Una interfaz puede extender MÚLTIPLES interfaces (a diferencia de las clases)
        interface Anfibio extends Volador, Nadador {
            // Hereda volar() y nadar() como métodos abstractos propios
            // No los implementa, sigue siendo interfaz
            void caminar(); // agrega uno propio también
        }

        class Pato implements Anfibio {
            // Obligado a implementar los TRES: volar(), nadar(), caminar()
            public void volar() { System.out.println("Volando"); }
            public void nadar() { System.out.println("Nadando"); }
            public void caminar() { System.out.println("Caminando"); }
        } */

        
        //Además, tener en cuenta que: Al igual que una clase abstracta, una interfaz puede extenderse usando la palabra clave extends.
        //De esta manera, la nueva interfaz hija hereda todos los métodos abstractos de la interfaz padre.
        //Sin embargo, a diferencia de una clase abstracta, una interfaz puede extender múltiples interfaces. EJM:

        /* public interface HasTail {
            public int getTailLength();
        }
        public interface HasWhiskers {
            public int getNumberOfWhiskers();
        }
        public interface Seal extends HasTail, HasWhiskers {        //la interfaz Seal extiende de HasTail y HasWhiskers
        } */

        //Cualquier clase que implemente la interfaz Seal debe proporcionar una implementación para todos los métodos de las interfaces
        //parentales, en este caso, getTailLength() y getNumberOfWhiskers().



        //¿Qué pasa con una clase abstracta que implementa una interfaz? 
        //En este escenario, la clase abstracta se trata de la misma manera que una interfaz que extiende otra interfaz.
        //En otras palabras, la clase abstracta hereda los métodos abstractos de la interfaz, pero no está obligada a implementarlos.
        //Dicho esto, al igual que una clase abstracta, la primera clase concreta que extienda la clase abstracta debe implementar todos
        //los métodos abstractos heredados de la interfaz. EJM:
        
        /* public interface HasTail {      //INTERFAZ
            public int getTailLength();
        }
        public interface HasWhiskers {      //OTRA INTERFAZ
            public int getNumberOfWhiskers();
        }
        public abstract class HarborSeal implements HasTail, HasWhiskers { //CLASE ABSTRACTA QUE IMPLEMENTA INTERFACES HAZTAIL Y HASWHISKERS

        }
        public class LeopardSeal implements HasTail, HasWhiskers {  // NO COMPILA
        } */

        //ESTA CLASE CONCRETA NO COMPILA PORQUE NO ESTÁ IMPLEMENTANDO LOS MÉTODOS ABSTRACTOS DE LAS INTERFACES.
        //A DIFERENCIAR DE LA CLASE ABSTRACTA QUE IMPLEMENTA LAS INTERFACES PERO NO ESTÁ OBLIGADO A IMPLEMENTARLOS, SOLO LOS HEREDA.

        this.Classes_Interfaces_and_Keywords();
        this.Abstract_Methods_and_Multiple_Inheritance();
    }

    private void Classes_Interfaces_and_Keywords(){
        //TENER MUCHO CUIDADO, PORQUE:
        //A los creadores de exámenes les gustan las preguntas que mezclan la terminología de clases e interfaces. (extends e implements)

        //Aunque una clase puede implementar una interfaz,una clase no puede extender una interfaz.
        //De igual manera, mientras que una interfaz puede extender otra interfaz, una interfaz no puede implementar otra interfaz.

        //ejm:

        /* public interface CanRun {}      //INTERFACE
        public class Cheetah extends CanRun {}  // NO COMPILA PORQUE LA CLASE CONCRETA DEBE IMPLEMENTAR (implements) LA INTERFACE
        public class Hyena {}       //CLASE
        public interface HasFur extends Hyena {} // NO COMPILA PORQUE UNA INTERFAZ NO PUEDE EXTENDER NI IMPLEMENTAR UNA CLASE
        */

        //El primer ejemplo muestra una clase intentando extender una interfaz que no compila. 
        //El segundo ejemplo muestra una interfaz intentando extender una clase, lo cual tampoco compila.

        //ASEGURARSE QUE: la única conexión entre una clase y una interfaz sea con la sintaxis de class implements interface
    }

    private void Abstract_Methods_and_Multiple_Inheritance(){
        //Dado que Java permite la herencia múltiple a través de interfaces,
        //qué pasará si se define una clase que hereda de dos interfaces que contienen el mismo método abstracto?

        /* public interface Herbivore {        //interface
            public void eatPlants();
        }
        public interface Omnivore {     //interface
            public void eatPlants();
            public void eatMeat();
        } */

        //Las firmas de los dos métodos de interfaz eatPlants() son compatibles,
        //así que se puede definir una clase que cumpla con ambas interfaces al mismo tiempo. Ejm:

        /* public class Bear implements Herbivore, Omnivore {       //esta clase Bear, implementa las interfaces Herbivore, Omnivore
            public void eatMeat() {         //implementa el metodo
                System.out.println("Eating meat");
            }
            public void eatPlants() {         //implementa el metodo
                System.out.println("Eating plants");
            }
        } */

        //SÍ COMPILA.

        //Java no distingue dos métodos por la interfaz de donde vienen — SOLO MIRA LA FIRMA (NOMBRE , TIPOS Y ORDENPARAMETROS).
        //Entonces para Java, eatPlants() es un solo método abstracto, aunque esté "declarado" en dos lugares distintos.

        //SI TUVIERAN DIFERENTES FIRMAS, ENTONCES AHÍ BEAR TENÍA QUE IMPLEMENTAR AMBOS POR SEPARADO (SOBRECARGA)

        //Si el nombre del método es el mismo pero los parámetros de entrada son diferentes,
        // no hay conflicto porque esto se considera una sobrecarga de métodos. EJM:

        /* public interface Herbivore {
            public int eatPlants(int quantity); //METODO CON UN PARAMETRO
        }
        public interface Omnivore {
            public void eatPlants();        //METODO SIN PARAMETROS
        } 
        
        public class Bear implements Herbivore, Omnivore {
            public int eatPlants(int quantity) {                    //SE IMPLEMENTA EATPLANTS CON UN PARAMETRO
                System.out.println("Eating plants: "+quantity);
                return quantity;
            }
            public void eatPlants() {                   //SE IMPLEMENTA EATPLANTS SIN PARAMETRO
                System.out.println("Eating plants");
            }
        }
        */

        //SON METODOS DIFERENTES (DIFERENTE FIRMA)

        //La clase que implementa ambas interfaces debe proporcionar implementaciones de ambas versiones 
        //de eatPlants(), ya que se consideran métodos separados. 

        //Observa que NO IMPORTA SI EL TIPO DE RETORNO DE LOS DOS MÉTODOS ES EL MISMO O DIFERENTES,
        //porque el compilador trata estos métodos como independientes. 

        //TENER EN CUENTA QUE:
        //Desafortunadamente, si el nombre del método y los parámetros de entrada son los mismos pero
        //los tipos de retorno son diferentes entre los dos métodos, la clase o interfaz que intenta heredar ambas
        //interfaces no se compilará.

        //No es posible en Java definir dos métodos en una clase con el mismo nombre y parámetros de entrada
        //pero con diferentes tipos de retorno

        //EJEMPLO:

        /* public interface Herbivore {        //INTERFACE
            public int eatPlants();
        }
        public interface Omnivore {     //INTERFACE
            public void eatPlants();
        }
        public class Bear implements Herbivore, Omnivore {      //SE IMPLEMENTA INTERFACES Herbivore, Omnivore
            public int eatPlants() {  // NO SE COMPILA
                System.out.println("Eating plants: 10");
                return 10;
            }
            public void eatPlants() {  // NO SE COMPILA
                System.out.println("Eating plants");
            }
        } */

        //El código no se compila, ya que la clase define dos métodos con el mismo nombre y parámetros de entrada
        //pero diferentes tipos de retorno.
        
        //Si elimináramos cualquiera de las definiciones de eatPlants(), el compilador se detendría porque a la
        //definición de Bear le faltaría uno de los métodos requeridos.
        
        //En otras palabras,no hay una implementación de la clase Bear que herede de Herbívoro y Omnívoro que el compilador acepte
        


        //ADEMÁS, el compilador también lanzaría una excepción si defines una interfaz o clase abstracta 
        //que herede de dos interfaces conflictivas. EJM:

        /* public interface Herbivore {    //INTERFACE
            public int eatPlants();
        }
        public interface Omnivore {         //INTERFACE
            public void eatPlants();
        }
        public interface Supervore extends Herbivore, Omnivore {} // NO COMPILA POR LOS METODOS QUE TIENE MISMA FIRMA Y DIFERENTES TIPO DE RETORNO
        public abstract class AbstractBear implements Herbivore, Omnivore {} // NO COMPILA
         */

        //Incluso sin detalles de implementación, el compilador detecta el problema con la definición
        //abstracta y evita la compilación.

        //LUEGO SE VERÁN LOS MÉTODOS DE INTERFACE POR DEFECTO.
    }

}
