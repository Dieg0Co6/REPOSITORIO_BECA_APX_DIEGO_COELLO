package com.app5.Understanding_Polymorphism;

import com.app5.Creating_Abstract_Classes.Creating_Abstract_Classes.Animal;

public class Understanding_Polymorphism {
    //El polimorfismo, es la propiedad de un objeto de asumir muchas formas diferentes.

    
    /* Para explicarlo con más precisión, un objeto de Java puede ser accedido de las sgtes manera:

    * 1 .una referencia del mismo tipo que el objeto. EJM:

    public class Animal{
        public static void main(String[] args) {
            Animal animal = new Animal();
        }
    } 

    * 2. una referencia que sea una superclase del objeto. EJM:

    public class Animal{}

    public classe Perro extends Animal{
        public static void main(String[] args) {
            Animal perro = new Perro();
        }
    }

    * 3. una referencia que defina una interfaz que el objeto implemente directamente

    interface Animal {
    void hacerSonido();
    }

    class Perro implements Animal {
        public void hacerSonido() {
            System.out.println("Guau");
        }
    }
        
    * 4. una referencia que defina una interfaz que el objeto implemente a través de una superclase

    interface Animal {
    void hacerSonido();
    }

    class Mamifero implements Animal {          // Mamifero implementa Animal DIRECTAMENTE
        public void hacerSonido() {
            System.out.println("Sonido genérico");
        }
    }

    class Perro extends Mamifero {              // Perro NO escribe "implements Animal"
        ///pero lo hereda de Mamifero
    }
    */

    //Además, no se requiere un casting si el objeto se está reasignando a un supertipo o interfaz del objeto.

    //EJMPLO:

    public class Primate {
        public boolean hasHair() {
            return true;
        }
    }

    public interface HasTail {
        public boolean isTailStriped();
    }

    /* public class Lemur extends Primate implements HasTail {
        public boolean isTailStriped() {
            return false;
        }
        public int age = 10;
        public static void main(String[] args) {
            Lemur lemur = new Lemur();      //PUEDO ISNTANCIAR UNA CLASE (CREAR UN OBJETO) CON EL MISMO TIPO DE VALOR DE LA CLASE
            System.out.println(lemur.age);  //IMPRIME 10
            HasTail hasTail = lemur;        //AHORA LA REFERENCIA HASTAIL APUNTA AL OBJETO DE LA CLASE LEMUR
            System.out.println(hasTail.isTailStriped());    //imprime false
            Primate primate = lemur;        //una variable de tipo de referencia Primate se le asigna el objeto de la clase lemur
            System.out.println(primate.hasHair());  //Se hereda el metodo de la superclase e imprime true.
        }
    } */

    //Imprime :
    // 10 
    // false 
    // true
    
    //Lo más importante a tener en cuenta sobre este ejemplo es que solo se crea un objeto, Lemur, y se referencia.
    //La capacidad de que una instancia de Lemur pueda pasarse como una instancia de una interfaz que implementa, HasTail,
    //así como una instancia de una de sus superclases, Primate, es la naturaleza del polimorfismo.

    //Un mismo objeto puede ser tratado de diferentes formas y ejecutar distintos comportamientos mediante un mismo método

    //Una vez que el objeto ha sido asignado a un nuevo tipo de referencia, SOLO LOS MÉTODOS Y VARIABLES DISPONIBLES PARA
    //ESE TIPO DE REFERENCIA SE PUEDEN USAR EN EL OBJETO sin un casting explícito.


    //ES DECIR, EL OBJETO VA SER DEL TIPO LEMUR, PERO SOLO SE VAN A PODER ACCEDER A LOS METODOS Y VARIABLES DEL TIPO DE REFERENCIA
    //QUE SE LE ASIGNE
    // EJM:

    
    /* HasTail hasTail = lemur;
    System.out.println(hasTail.age);  // NO COMPILA PORQUE LA VARIABLE AGE CORRESPONDE A CLASE PRIMATE, NO A LA INTERFAZ HASTAIL
    Primate primate = lemur;
    System.out.println(primate.isTailStriped());  // NO COMPILA PORQUE EL METODO IMPLEMENTADO NO CORRESPONDE A CLASE PRIMATE.
    */

    //La referencia hasTail solo tiene acceso directo a los métodos definidos con la interfaz HasTail;
    //por lo tanto, no sabe que la variable age es parte del objeto.

    //La referencia primate solo tiene acceso a los métodos definidos en la clase Primate,
    //y no tiene acceso directo al método isTailStriped().

    public static void main(String[] args) {
        Understanding_Polymorphism understanding_Polymorphism = new Understanding_Polymorphism();
        understanding_Polymorphism.Object_vs_Reference();
        understanding_Polymorphism.Casting_Objects();
        understanding_Polymorphism.Virtual_Methods();
        understanding_Polymorphism.Polymorphic_Parameters();
        understanding_Polymorphism.Polymorphism_and_Method_Overriding();
    }
    
    public void Object_vs_Reference(){
        //En Java, todos los objetos se acceden por referencia,
        //así que como desarrollador nunca tienes acceso directo al objeto en sí.
        
        //Conceptualmente, sin embargo, deberías considerar el objeto como la entidad que existe en la memoria,
        //asignada por el entorno de ejecución de Java.

        //Independientemente del tipo de referencia que tengas para el objeto en memoria, el objeto en sí no cambia.

        //Por ejemplo, dado que todos los objetos heredan de java.lang.Object, todos pueden reasignarse a java.lang.Object. Ejm:

        //Lemur lemur = new Lemur();
        //Object lemurAsObject = lemur;   //Se reasigna el objeto de la clase Lemur al tipo de referencia Object. 

        //Aunque al objeto Lemur se le haya asignado una referencia de un tipo diferente,
        //el objeto en sí no ha cambiado y todavía existe como un objeto Lemur en la memoria.

        //Lo que ha cambiado es nuestra capacidad de acceder a los métodos dentro de la clase Lemur con la referencia lemurAsObject.

        //Sin un casteo explícito de vuelta a Lemur,(como se verá más adelante),
        //ya no tenemos acceso a las propiedades de Lemur del objeto.

        //Podemos resumir con las sgtes dos reglas:
        /*
            * 1. El tipo del objeto determina qué propiedades existen dentro del objeto en la memoria.
            * 2. El tipo de la referencia al objeto determina qué métodos y variables son accesibles para el programa Java.
        */
        
        //Entonces se deduce que cambiar con éxito una referencia de un objeto a un nuevo tipo de referencia puede darte acceso a
        //nuevas propiedades del objeto, pero esas propiedades ya existían antes de que ocurriera el cambio de referencia.

        //Como ya se mencionó, es posible recuperar el acceso a la variable age haciendo un casting explícito de la referencia
        //hasTail a una referencia de tipo Lemur.
    }

    public void Casting_Objects(){
        // En el ejmplo anterior se vio que una vez que cambiamos el tipo de referencia,
        // perdimos el acceso a métodos más específicos definidos en la subclase que todavía existen dentro del objeto.
        // Podemos recuperar esas referencias haciendo un casting del objeto de vuelta a la subclase específica de la que proviene

        /* Primate primate = lemur;    //Se le asigna el objeto de la clase Lemur a un tipo de referencia Primate
        Lemur lemur2 = primate; // NO COMPILA (PORQUE PUEDE CAMBIARSE DE LO ESPECIFICO A LO GENERAL PERO NO AL REVÉS)
        Lemur lemur3 = (Lemur)primate;  //CASTEO A LA SUBCLASE DEL OBJETO DE CLASE LEMUR
        System.out.println(lemur3.age); //AHORA YA TIENE ACCESO A LA VARIABLE DEFINIDA EN LA CLASE LEMUR. */

        //En este ejemplo, primero intentamos convertir la referencia de primate de nuevo a una referencia de lémur, (lemur2),
        //sin un cast explícito. El resultado es que el código no se compilará.

        //En el segundo ejemplo, sin embargo, hacemos un cast explícito del objeto a una subclase del objeto Primate y
        //obtenemos acceso a todos los métodos disponibles en la clase Lemur.

        /*
        Reglas básicas a tener en cuenta al convertir variables:
        * 1. Hacer un casting de un objeto de una subclase a una superclase no requiere un casting explícito
        * 2. Hacer un casting de un objeto de una superclase a una subclase sí requiere un casting explícito.
        * 3. El compilador no permitirá castings a tipos que no estén relacionados.
        * 4. Incluso cuando el código se compila sin problema, se puede lanzar una excepción en tiempo de ejecución
        * si el objeto que se está casteando no es realmente una instancia de esa clase.
        */

        //IMPORTANTE SABER:
        //La tercera regla es importante; el examen puede intentar engañarte con un casting que el compilador no permite.
        //Por ejemplo, se pudo convertir una referencia de Primate a una referencia de Lémur, porque Lémur es una subclase de Primate
        //y, por lo tanto, están relacionados.

        //OTRO EJEMPLO:

        /* public class Bird {}

        public class Fish {
            public static void main(String[] args) {
                Fish fish = new Fish();
                Bird bird = (Bird)fish;  // NO COMPILA
            }
        } */

        //FISH NO EXTIENDE DE BIRD, NO ESTÁN RELACIONADOS, POR LO TANTO NO PUEDE CASTEARSE, POR LO TANTO, NO COMPILA.

        //El casting no está exento de limitaciones. Aunque dos clases compartan una jerarquía relacionada,
        //eso no significa que una instancia de una se pueda convertir automáticamente en la otra. EJM:

        /* public class Rodent {
        }

        public class Capybara extends Rodent {
            public static void main(String[] args) {
                Rodent rodent = new Rodent();
                Capybara capybara = (Capybara)rodent; // Throws ClassCastException EN TIEMPO DE EJECUCIÓN
            }
        } */

        //Este código crea una instancia de Roedor y luego intenta convertirla a una subclase de Roedor, Capibara.
        //Aunque este código se compilará sin problemas, lanzará una ClassCastException en tiempo de ejecución,
        //ya que EL OBJETO AL QUE SE HACE REFERENCIA NO ES UNA INSTANCIA DE LA CLASE CAPIBARA.

        //EL OBJETO QUE SE CREÓ NO TIENE NINGUNA RELACIÓN CON LA CLASE CAPIBARA.

        //Tener en cuenta que el operador instanceof se puede usar para comprobar si un objeto pertenece a una clase en particular
        //y para evitar ClassCastExceptions en tiempo de ejecución.

        //A diferencia del ejemplo anterior, el siguiente fragmento de código no lanza una excepción en tiempo de ejecución y
        //realiza el casting solo si el operador instanceof devuelve true.

        /* if(rodent instanceof Capybara) {
            Capybara capybara = (Capybara)rodent;
        } */


        // TENER SIEMPRE PRESENTE QUE:
        //En el examen se debe ver cuál es realmente la instancia del objeto.
        //Luego, fijarse bien en si el compilador permitirá que se haga referencia al objeto con o sin conversiones explícitas.
    }

    public void Virtual_Methods(){
        //La característica más importante del polimorfismo y una de las principales razones por las que tenemos la estructura de clases,
        //es para soportar métodos virtuales.

        //Un método virtual es un método en el que la iIMPLMENETACIÓN ESPECÍFICA no se determina hasta el TIEMPO DE EJECUCIÓN.
        //De hecho, todos los métodos de Java que no son finales, estáticos ni privados se consideran métodos virtuales,
        //ya que cualquiera de ellos puede ser sobrescrito en tiempo de ejecución.

        //Lo que hace especial a un método virtual en Java es que si llamas a un método de un objeto que sobrescribe un método,
        //obtienes el método sobrescrito, incluso si la llamada al método se hace desde una referencia del padre o dentro de la clase padre.

        //EJM:
        /* public class Bird {  //CLASE BIRD
            public String getName() {
                return "Unknown";
            }
            public void displayInformation() {
                System.out.println("The bird name is: "+getName());
            }
        }

        public class Peacock extends Bird {     //CLASE Peacock EXTIENDE DE BIRD
            public String getName() {
                return "Peacock";
            }
            public static void main(String[] args) {
                Bird bird = new Peacock();
                bird.displayInformation();      //SI PUEDE USAR ESE MÉTODO PORQUE BIRD SE LO HA HEREDADO
            }
        } */
        
        //IMPRIME: The bird name is: Peacock

        //El método getName() se sobrescribe en la clase hija Peacock.
        //Más importante aún, el valor del método getName() en tiempo de ejecución dentro del método displayInformation()
        //se reemplaza con el valor de la implementación en la subclase Peacock.

        //Aquí es donde entra el polimorfismo real (dynamic dispatch):
        //"un mismo objeto puede... ejecutar distintos comportamientos mediante un mismo método."
        
        
        //getName() está declarado en Bird, pero Peacock lo sobrescribe. 
        //Como el objeto real detrás de bird es un Peacock, cuando el código interno de displayInformation() llama a getName(),
        //Java ejecuta la versión de Peacock.

        //En otras palabras, aunque la clase padre Bird define su propia versión de getName() y no sabe nada sobre la clase Peacock
        //durante la compilación, en tiempo de ejecución la instancia usa la versión sobrescrita del método,
        //tal como está definida en la instancia del objeto.

        //La naturaleza del polimorfismo es que un objeto puede tomar muchas formas diferentes.
        //Al combinar tu comprensión del polimorfismo con la sobrescritura de métodos,
        //puedes ver que los objetos pueden interpretarse de maneras muy diferentes en tiempo de ejecución,
        //especialmente en los métodos definidos en las superclases de los objetos.
    }

    public void Polymorphic_Parameters(){
        //PARÁMETROS POLIMÓRFICOS: Un método que recibe un tipo (clase o interfaz) como parámetro
        //puede aceptar cualquier subtipo de ese parámetro, sin necesidad de casting (es upcast implícito).

        //ejmplo:

        /* public class Reptile {      //clase reptile
            public String getName() {
                return "Reptile";
            }
        }

        public class Alligator extends Reptile {  //clase Alligator que extiende de reptile
            public String getName() {
                return "Alligator";
            }
        }

        public class Crocodile extends Reptile { // clase Crocodile que extiende de Alligator 
            public String getName() {
                return "Crocodile";
            }
        }

        public class ZooWorker {            //clase ZooWorker
            public static void feed(Reptile reptile) {      //Se le pasa como parametro una variable con tipo de referencia Reptile
                System.out.println("Feeding reptile "+reptile.getName());      //imprimirá el nombre del reptile
            }
            public static void main(String[] args) {
                feed(new Alligator());     //Se pasa un objeto de tipo Alligator / imprime: Feeding reptile Alligator
                feed(new Crocodile());  //Se pasa un objeto de tipo Crocodile / imprime: Feeding reptile Crocodile
                feed(new Reptile());  //Se pasa un objeto de tipo Reptile / imprime: Feeding reptile Reptile
            }
        } */


        //En este ejemplo, nos tenemos que enfocar en el método feed(Reptile reptile).
        //Como se puede ver, ese método pudo manejar instancias de Alligator y Crocodile sin problema,
        //porque ambos son subclases de la clase Reptile. También pudo aceptar un tipo coincidente de la clase Reptile.

        //Si hubiéramos intentado pasar una clase no relacionada, como las clases Rodent o Capybara
        //o una superclase como java.lang.Object, al método feed(), EL CÓDIGO NO SE HABRÍA COMPILADO.

        /*==========================================================
        Parámetros polimórficos y reutilización de código
        ============================================================

        //Cuando defines un método (sobre todo si otros lo van a usar), es mejor pedir como parámetro
        //el tipo más general posible (una interfaz o superclase), no una clase específica.
        //Así el método acepta más tipos de objetos y es más reutilizable.

        // MAL: solo acepta ArrayList específicamente
        void imprimir(ArrayList lista) { ... }

        // BIEN: acepta ArrayList, LinkedList, Vector... cualquier cosa que sea List
        void imprimir(List lista) { ... }

        List lista = new ArrayList();   // referencia del tipo más general (interfaz List)
        imprimir(lista);                // funciona con cualquier tipo de List

        //ESO SIGNFIFICA QUE SE TIENE QUE USAR EL TIPO MÁS GENERAL QUE AÚN TENGA LOS MÉTODOS QUE NECESITAS.
        */
    }

    public void Polymorphism_and_Method_Overriding(){
        //Volvemos a las tres últimas reglas para la sobreescritura de métodos para demostrar cómo el polimorfismo
        //requiere que se incluyan como parte de la especificación de Java.

        //La primera regla es que un método sobreescrito debe ser al menos tan accesible como el método que está sobreescribiendo.
        //Supongamos que esta regla no es necesaria y consideremos el siguiente ejemplo:

        /* public class Animal {       //clase Animal
            public String getName() {       //metodo publico getName()
                return "Animal";
            }
        }
        public class Gorilla extends Animal {
            protected String getName() {  //NO COMPILA PORQUE TIENE QUE SER IGUAL O MÁS ACCESIBLE QUE EL METODO DE LA SUPERCLASE
                return "Gorilla";
            }
        }
        public class ZooKeeper {
            public static void main(String[] args) {
                Animal animal = new Gorilla();   //Se crea un objeto de tipo Gorilla con la referencia de Animal
                System.out.println(animal.getName());
            }
        } */

        //Por qué: si compilara, tendrías Animal animal = new Gorilla(); y animal.getName() sería válido para el compilador
        //(porque en Animal es public), pero el método real en Gorilla es protected (más restringido).
        //Contradicción. Java lo evita prohibiendo bajar el nivel de acceso.

        //Regla 2: No puedes agregar excepciones checked nuevas o más amplias

        //Si Animal.hacerAlgo() no lanza ninguna excepción checked, Gorilla no puede sobrescribirlo lanzando una nueva excepción checked.
        //Porque si usas Animal animal = new Gorilla();, el código que llama a animal.hacerAlgo() no sabe que debe manejar esa excepción (el compilador nunca se lo exigió, porque miró solo Animal).

        //Regla 3: El tipo de retorno debe ser covariante (igual o más específico)
        //Por qué: si `Gorilla` pudiera devolver algo más general de lo que espera `Animal`, el código que usa
        //`Animal animal = new Gorilla();` esperaría, por ejemplo, un `Double`, pero recibiría un `Integer`,
        //tipos incompatibles entre sí, causando errores en tiempo de ejecución.

        //EN POCAS PALABRAS: el compilador confía en lo que declara Animal.
        //Si la subclase pudiera cambiar el acceso, las excepciones o el tipo de retorno de forma incompatible,
        //se rompería esa confianza y el código fallaría en runtime sin que el compilador lo hubiera podido prevenir.
    }

}
