package com.app5.day_eleven.Implementing_Interfaces;

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
        implementing_Interfaces.Interface_Variables();
        implementing_Interfaces.Default_Interface_Methods();
        implementing_Interfaces.Static_Interface_Methods();
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
            * 5. Todos los métodos que no sean predeterminados en una interfaz se asumen con los modificadores abstract y public en su definición.
            * Por lo tanto, marcar un método como privado, protegido o final generará errores de compilación,
            * ya que estos son incompatibles con las palabras clave abstract y public
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

    public void Interface_Variables(){
        //EXISTEN LAS VARIABLES DE INTERFAZ,QUE PUEDEN DEFINIRSE DENTRO DE UNA INTERFAZ.

        //AL IGUAL QUE LOS MÉTODOS DE INTERFAZ, SE ASUME QUE LAS VARIABLES DE INTERFAZ SON PUBLICAS.
        //SIN EMBARGO, A DIFERENCIA DE LOS MÉTODOS DE INTERFAZ, TAMBIÉN SE ASUME QUE LAS VARIABLES DE INTERFAZ SON ESTÁTICAS Y FINALES

        /*
        REGLAS PARA LAS VARIABLES DE INTERFAZ
            * 1. Se asume que las variables de interfaz son públicas, estáticas y finales. 
            * Por lo tanto, marcar una variable como privada o protegida provocará un error de compilador,
            * al igual que marcar cualquier variable como abstracta.
            * 
            * 2. El valor de una variable de interfaz debe establecerse cuando se declara, ya que está marcada como final.
        */

        //ESO QUIERE DECIR QUE: las variables de interfaz son esencialmente variables CONSTANTES definidas a nivel de interfaz.

        // COMO SON ESTÁTICAS SON ACCESIBLES INCLUSO SIN UNA INSTANCIA DE LA INTERFAZ

        //Las siguientes dos definiciones de interfaz son equivalentes, porque el compilador las convertirá automáticamente
        //a la segunda opción:

        /* public interface CanSwim {      //INTERFACE
            int MAXIMUM_DEPTH = 100;        //no tiene ni el public ni el final. Pero Java lo convierte automaticamente
            final static boolean UNDERWATER = true; //no importa si es final static o static final. Java lo convierte a public automaticamente
            public static final String TYPE = "Submersible";    //bien declarado
        }

        public interface CanSwim {          //INTERFACE
            public static final int MAXIMUM_DEPTH = 100;
            public static final boolean UNDERWATER = true;
            public static final String TYPE = "Submersible";
        } */

        //ESTE CODIGO, SI COMPILA. JAVA ASUME QUE TODAS LAS VARIABLE DECLARADAS COMO PUBLIC STATIC FINAL, SI NO TIENEN ESAS PALABRAS CLAVE
        // JAVA LOS CONVIERTE AUTOMATICAMENTE.

        //El compilador insertará automáticamente public static final en cualquier variable de interfaz constante a la que le falten esos modificadores.

        //También hay que notar que es una práctica común de codificación usar letras mayúsculas para denotar valores constantes dentro de una clase.

        //EJMPLO:

        /* public interface CanDig {
            private int MAXIMUM_DEPTH = 100;  // NO COMPILA, PORQUE SE LE ESTÁ COLOCANDO EL MODIFICADOR DE ACCESO PRIVATE (DEBE SER PUBLIC)
            protected abstract boolean UNDERWATER = false;  //NO COMPILA, PORQUE SE LE ESTÁ COLOCANDO EL MODIFICADOR DE ACCESO PROTECTED (DEBE SER PUBLIC)
                                                            Y TAMPOCO PUEDE SER ABSTRACT (DEBE SER FINAL)
            public static String TYPE;  // NO COMPILA, PORQUE NO SE LE HA INICIALIZADO LA VARIABLE CONSTANTE.
        } */

        //El primer ejemplo, MAXIMUM_DEPTH, no compila porque se usa el modificador private, y se asume que todas las variables de la interfaz son públicas.
        //La segunda línea, UNDERWATER, no compila por dos razones. Está marcada como protected,
        //lo que entra en conflicto con el modificador público asumido, y está marcada como abstract,
        //lo que entra en conflicto con el modificador final asumido. 
        //Finalmente, el último ejemplo, TYPE, no compila porque le falta un valor a esa variable public static final.
    }

    public void Default_Interface_Methods(){
        //Con el lanzamiento de Java 8, los autores de Java introdujeron un nuevo tipo de método en una interfaz, conocido como método default.

        //Un método predeterminado es un método definido dentro de una interfaz con la palabra clave default, en el que se proporciona un cuerpo de método

        //Este método predeterminado constrasta con los métodos normales de las interfaces las cuales son abstractas y no pueden tener cuerpo de metodo.

        //Un método por defecto dentro de una interfaz define un método abstracto con una implementación por defecto.
        //De esta manera, las clases tienen la opción de sobrescribir el método por defecto si lo necesitan, pero no están obligadas a hacerlo.
        //Si la clase no sobrescribe el método, se usará la implementación por defecto. De este modo, LA DEFINICIÓN DEL MÉTODO ES CONCRETA, NO ABSTRACTA.
        

        //====================================================================
        // PROÓSITO DEL USO DE METODO(S) DE INTERFAZ POR DEFECTO
        //====================================================================
        //El propósito fue en parte ayudar con el desarrollo de código y la compatibilidad hacia atrás.
        //Imagina que tienes una interfaz que es compartida entre docenas o incluso cientos de usuarios y quieres añadirle un método nuevo.

        //Si solo actualizas la interfaz con el nuevo método, la implementación se rompería entre todos tus suscriptores,
        //quienes entonces se verían obligados a actualizar su código. En la práctica, esto incluso podría desanimarte a hacer el cambio por completo.
        //Sin embargo, al proporcionar una implementación por defecto del método, la interfaz se vuelve compatible con el código existente,
        //mientras sigue ofreciendo a aquellos que sí quieren usar el nuevo método la opción de sobrescribirlo.

        //EJMPLO DE UN METODO DE INTERFAZ POR DEFECTO.

        /* public interface IsWarmBlooded {        //INTERFACE
            boolean hasScales();                //METODO ABSTRACTO
            public default double getTemperature() {        //METODO CONCRETO POR DEFECTO
                return 10.0;
            }
        } */

        //NO CONFUNDIR: ESE DEFAULT NO ES COMO EL MODIFICADOR DE ACCESO DE PACKAGE PRIVATE O PAQUETE PRIVADO.
        //TODAS LAS VARIABLES Y METODOS DE UNA INTERFACE SE ASUMEN QUE SON PUBLICOS.

        //Cualquier clase que implemente IsWarmBlooded puede usar la implementación por defecto de getTemperature() o sobrescribir
        //el método y crear su propia versión.

        /*
        LAS SIGUIENTES SON LAS REGLAS DE LOS METODOS POR DEFECTO DE LAS INTERFACES:
        * 1. Un método por defecto solo puede declararse dentro de una interfaz y no dentro de una clase o clase abstracta.
        * 2. Un método por defecto debe estar marcado con la palabra clave default.
        * Si un método está marcado como default, debe proporcionar un cuerpo de método.
        * 3. No se asume que un método por defecto sea estático, final o abstracto, ya que puede ser usado o sobrescrito
        * por una clase que implemente la interfaz.
        * 4. Como todos los métodos en una interfaz, se asume que un método por defecto es público y no se compilará si
        * está marcado como private o protected 
        */

        /* public interface Carnivore {
            public default void eatMeat();  // NO COMPILA PORQUE SE LE INDICA QUE ES UN METODO POR DEFECTO PERO NO TIENE CUERPO DE METODO
            public int getRequiredFoodAmount() {  //NO COMPILA PORQUE NO ES UN METODO POR DEFECTO Y TIENE UN CUERPO DE METODO.
                return 13;
            }
        } */

        //El primer método, eatMeat(), no compila porque está marcado como default pero no tiene un cuerpo de método.
        //El segundo método, getRequiredFoodAmount(), tampoco compila porque tiene un cuerpo de método pero no está marcado con la palabra clave default

        /*
        * A diferencia de las variables de interfaz, que se consideran miembros estáticos de la clase,
        * los métodos por defecto no pueden marcarse como estáticos y requieren una instancia de la clase que implemente la interfaz para ser invocados.
        
        * Tampoco pueden marcarse como finales o abstractos, porque se permite que sean sobrescritos en subclases, pero no es obligatorio hacerlo.
        
        * Cuando una interfaz extiende otra interfaz que contiene un método por defecto, puede optar por ignorar el método por defecto, 
        * en cuyo caso se usará la implementación predeterminada del método. 
        
        * Alternativamente, la interfaz puede sobrescribir la definición del método por defecto usando las reglas estándar para la sobrescritura de métodos,
        * como no limitar la accesibilidad del método y usar retornos covariantes.
        
        * Finalmente, la interfaz puede redeclarar el método como abstracto, requiriendo que las clases que implementen la nueva interfaz
        * proporcionen explícitamente un cuerpo para el método. Opciones análogas se aplican para una clase abstracta que implemente una interfaz.
        
        */

        //Por ejemplo, la siguiente clase sobrescribe un método por defecto de la interfaz y redeclara un segundo método de la interfaz como abstracto:

        /* public interface HasFins {      //interface
            public default int getNumberOfFins() {
                return 4;
            }
            public default double getLongestFinLength() {
                return 20.0;
            }
            public default boolean doFinsHaveScales() {
                return true;
            }
        }

        public interface SharkFamily extends HasFins {      //interface SharkFamily extiende de HasFins
            public default int getNumberOfFins() {      //sobreescritura de metodo por defecto getNumberOfFins
                return 8;
            }
            public double getLongestFinLength();   //sobreescribe el metodo, pero ya no lo considera por defecto, entonces ya no tiene cuerpo.
            public boolean doFinsHaveScales() {  //NO COMPILA. PORQUE SE SOBREESCRIBIÓ Y YA NO ES METODO POR DEFECTO Y SE ESTÁ COLOCANDO UN CUERPO DE METODO.
                return false;
            }
        } */

        //La primera interfaz, HasFins, define tres métodos por defecto: getNumberOfFins(), getLongestFinLength() y doFinsHaveScales().
        //La segunda interfaz, SharkFamily, extiende HasFins y sobrescribe el método por defecto getNumberOfFins() con un nuevo método que
        //devuelve un valor diferente. Luego, la interfaz SharkFamily reemplaza el método por defecto getLongestFinLength() con un nuevo método
        //abstracto, obligando a cualquier clase que implemente la interfaz SharkFamily a proporcionar una implementación del método.
        
        //Finalmente, la interfaz SharkFamily sobrescribe el método doFinsHaveScales() pero no marca el método como por defecto.
        //Dado que las interfaces solo pueden contener métodos con cuerpo que estén marcados como por defecto, el código no se compilará.

        this.Default_Methods_and_Multiple_Inheritance();
    }

    private void Default_Methods_and_Multiple_Inheritance(){
        //Al permitir métodos predeterminados en las interfaces, junto con el hecho de que una clase puede implementar múltiples interfaces,
        //Java básicamente ha abierto la puerta a problemas de herencia múltiple. EJM:

        /* public interface Walk {     //INTERFACE
            public default int getSpeed() {
                return 5;
            }
        }

        public interface Run {      //INTERFACE
            public default int getSpeed() {
                return 10;
            }
        }

        public class Cat implements Walk, Run {  // NO COMPILA
            public static void main(String[] args) {
                System.out.println(new Cat().getSpeed());
            }
        } */


        //En este ejemplo, Cat hereda los dos métodos por defecto para getSpeed(), entonces, ¿cuál usa?
        //Como Walk y Run se consideran hermanos en términos de cómo se usan en la clase Cat,no está claro si el código debería mostrar 5 o 10.
        //La respuesta es que el código no muestra ninguno de esos valores: NO COMPILA.

        // Si una clase implementa dos interfaces que tienen métodos por defecto con el mismo nombre y firma, el compilador lanzará un error.
        
        //Sin embargo, hay una excepción a esta regla: si la subclase sobrescribe los métodos por defecto duplicados,
        //el código compilará sin problemas, ya que se elimina la ambigüedad sobre qué versión del método llamar. EJM:

        /* public class Cat implements Walk, Run {  
            public int getSpeed() {
                return 1;
            }
            public static void main(String[] args) {
                System.out.println(new Cat().getSpeed());       //COMPILARÁ SIN PROBLEMAS.PORQUE REDEFINIÓ EL METODO QUE ERA AMBIGUO
            }
        } */

        //Tener una clase que implemente o herede dos métodos predeterminados duplicados obliga a la clase a implementar una nueva versión del método,
        //o el código no se compilará. Esta regla se cumple incluso para las clases abstractas que implementan múltiples interfaces,
        //porque el método predeterminado podría ser llamado en un método concreto dentro de la clase abstracta.
    }

    public void Static_Interface_Methods(){
        //Java 8 también incluye ahora soporte para métodos estáticos dentro de las interfaces.
        //Estos métodos se definen explícitamente con la palabra clave static y
        //funcionan casi de la misma manera que los métodos estáticos definidos en clases

        //De hecho, realmente solo hay una diferencia entre un método estático en una clase y en una interfaz.
        //Un método estático definido en una interfaz NO SE HEREDA EN NINGUNA CLASE QUE IMPLEMENTE LA INTERFAZ.

        /*
        * 1. Como todos los métodos en una interfaz, se asume que un método estático es público .NO SE COMPILARÁ si se marca como private o protected
        * 2. Para referirse al método estático, se debe usar una referencia al nombre de la interfaz.
        */

        //Un método static en una interfaz debe tener cuerpo . NO puede quedar abstracto/sin implementación.

        //EJM:

        /* public interface Hop {      //INTERFACE
            static int getJumpHeight() {     //SE ASUME QUE ES UN METODO PUBLICO
                return 8;
            }
        } */

        //El método getJumpHeight() funciona como un método estático tal como se define en una clase.
        //En otras palabras, se puede acceder a él sin una instancia de la clase usando la sintaxis Hop.getJumpHeight(). 
        
        //Además, ten en cuenta que el compilador insertará automáticamente el modificador de acceso public,
        //ya que se asume que todos los métodos en las interfaces son públicos.

        //EJEMPLO DE UNA CLASE IMPLEMENTANDO EL INTERFACE .

        /* public class Bunny implements Hop {
            public void printDetails() {
                System.out.println(getJumpHeight()); // NO COMPILA, YA QUE PARA USAR EL METODO ESTATICO,
                                                    SE TIENE QUE USAR COMO REFERENCIA EL NOMBRE DE LA INTERFACE SEGUIDO DEL METODO STATIC
            }
        } */

        //Sin una referencia explícita al nombre de la interfaz, el código no compilará, aunque Bunny implemente Hop.
        //De esta manera, los métodos estáticos de la interfaz no son heredados por una clase que implementa la interfaz.

        //EJMPLO CORREGIDO:

        /* public class Bunny implements Hop {
            public void printDetails() {
                System.out.println(Hop.getJumpHeight());  //AHORA SÍ HACER REFERENCIA AL NOMBRE DE LA INTERFAZ, SI COMPILA.
            }
        } */

        //Una clase que implementa dos interfaces que contienen métodos estáticos con la misma firma todavía se compilará en tiempo de ejecución,
        //porque los métodos estáticos no se heredan por la subclase y deben ser accedidos con una referencia al nombre de la interfaz.
    }
}
