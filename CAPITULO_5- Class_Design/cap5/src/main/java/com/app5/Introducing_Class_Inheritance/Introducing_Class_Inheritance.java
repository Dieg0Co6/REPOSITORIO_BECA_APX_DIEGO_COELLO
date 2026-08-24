package com.app5.Introducing_Class_Inheritance;

public class Introducing_Class_Inheritance {

    
    public static void main(String[] args) {
        // La herencia es el proceso por el cual la nueva subclase hija incluye automáticamente cualquier primitivo,
        // objeto o método público o protegido definido en la clase padre.

        //Java soporta la herencia simple, por lo que una clase puede heredar de solo una clase padre directa.
        //Java también soporta múltiples niveles de herencia, mediante los cuales una clase puede extender otra clase,
        //que a su vez extiende otra clase.
        
        //Se puede extender una clase cualquier número de veces, permitiendo que cada descendiente tenga acceso a los miembros
        //de su ancestro.

        //Solo permite extender o que se herede de una sola clase. Pero, las clases pueden implementar múltiples interfaces

        //Se consideran herencia simple porque cada hija tiene exactamente un padre.
        //La herencia simple no impide que los padres tengan múltiples hijos.

        //En Java es posible evitar que una clase sea extendida marcándola con el modificador final.
        //Si intentas definir una clase que herede de una clase final, el compilador lanzará un error y no compilará.

        Introducing_Class_Inheritance introducing_Class_Inheritance = new Introducing_Class_Inheritance();
        introducing_Class_Inheritance.Extending_a_Class();
        introducing_Class_Inheritance.Applying_Class_Access_Modifiers();
        introducing_Class_Inheritance.Creating_Java_Objects();
        introducing_Class_Inheritance.Defining_Constructors();
        introducing_Class_Inheritance.Understanding_Compiler_Enhancements();
        introducing_Class_Inheritance.Reviewing_Constructor_Rules();
        introducing_Class_Inheritance.Calling_Constructors();
        introducing_Class_Inheritance.Calling_Inherited_Class_Members();
        introducing_Class_Inheritance.Inheriting_Methods();
        introducing_Class_Inheritance.Inheriting_Variables();
    }

    public void Extending_a_Class(){
        //En Java, puedes extender una clase añadiendo el nombre de la clase padre en la definición usando la palabra clave extends.
        //Ejm de sintaxis:

        /* public abstract class ElephantSeal extends Seal {
            // Métodos y variables definidos aquí
        } */

        //Como Java permite solo una clase pública por archivo, se puede crear dos archivos, Animal.java y Lion.java,
        //en los que la clase Lion extiende la clase Animal. Suponiendo que están en el mismo paquete,
        //no se requiere una declaración import en Lion.java para acceder a la clase Animal. 

        /* public class Animal {
            private int age;
            public int getAge() {
                return age;
            }
            public void setAge(int age) {
                this.age = age;
            }
        } */
        
        /* public class Lion extends Animal {
            private void roar() {
                System.out.println("The "+getAge()+" year old lion says: Roar!");
            }
        } */

        //En este ejemplo, vemos que getAge() y setAge() son accesibles para la subclase Lion,
        // porque están marcados como public en la clase padre. Y no están accediendo directamente de la variable age
        // ya que esa variable se encuentra en private,y, por lo tanto, no es accesible desde la subclase Lion.
        // lo siguiente no compilaría:
        /* public class Lion extends Animal {
            private void roar() {
                System.out.println("The "+age+" year old lion says: Roar!"); //NO COMPILA PORQUE SE ESTÁ USANDO LA VARIABLE age que es private
            }
        } */
    }
    
    public void Applying_Class_Access_Modifiers(){
        //Como ya se ha vuisto anteriormente, se puede colocar modificadores de acceso (public, private, protected, default) a los métodos
        //y variables de la clase. Así también se pueden agregar modificadores de acceso a las definiciones de clase. Así como lo hemos
        //estado viendo, colocando la palabra public al momento de definir una clase.

        //Para el examen OCA, solo debería estar familiarizado con los modificadores de acceso de clase a nivel de paquete públicos y
        //por defecto, porque son los únicos que se pueden aplicar a clases de nivel superior dentro de un archivo Java.
        //Los modificadores protected y private solo se pueden aplicar a clases internas, que son clases definidas dentro de otras clases.

        //El modificador de acceso public aplicado a una clase indica que puede ser referenciada y utilizada en cualquier clase.

        //El modificador predeterminado de package private, que es la ausencia de cualquier modificador de acceso,
        //indica que la clase solo puede ser accedida por una subclase o una clase dentro del mismo paquete.

        //Como se sabe, un archivo Java puede tener muchas clases pero como máximo una clase pública.
        //De hecho, puede no tener ninguna clase pública en absoluto. (COMO MÁXIMO PUEDE TENER 1, ES DECIR, PUEDE QUE NINGUNA O UNA TENGA
        //EL PUBLIC)

        //Ejmplo de como dos clases pueden estar en el mismo archivo

        /* class Rodent {}
        public class Groundhog extends Rodent {} */

        //Las reglas para aplicar modificadores de acceso a las clases son idénticas para las interfaces.
        //Puede haber como máximo una clase o interfaz pública en un archivo Java.
        //Al igual que las clases, las interfaces de nivel superior también se pueden declarar con los modificadores public o por defecto.
    }

    public void Creating_Java_Objects(){
        //En Java, todas las clases heredan de una sola clase, java.lang.Object.
        //java.lang.Object es la única clase que no tiene ninguna clase padre.

        //Las siguientes dos clases son equivalentes:
        /* public class Zoo {
        }
        public class Zoo extends java.lang.Object {
        } */
        
        //La clave es que cuando Java ve que defines una clase que no extiende de otra clase, inmediatamente agrega la sintaxis
        //extends java.lang.Object a la definición de la clase. Si defines una nueva clase que extiende de una clase existente,
        //Java no agrega esta sintaxis, aunque la nueva clase aún hereda de java.lang.Object.
        //Como todas las clases heredan de java.lang.Object, extender una clase existente (clase padre) significa que la clase hija
        //automáticamente hereda de java.lang.Object por construcción.

        //Esto significa que si se observa la estructura de herencia de cualquier clase, siempre terminará con java.lang.Object
        //en la parte superior del árbol.
    }

    public void Defining_Constructors(){
        //Como ya se ha visto antes, cada clase tiene al menos un constructor.
        //En el caso de que no se declare ningún constructor, el compilador insertará automáticamente un constructor por defecto sin argumentos.
        //Sin embargo, en el caso de extender una clase, la primera instrucción de cada constructor es o una llamada a otro constructor
        //dentro de la clase, usando this(), o una llamada a un constructor en la clase padre directa, usando super()

        //Ejmplo del uso de super():

        /* public class Animal {
            private int age;
            public Animal(int age) {
                super();
                this.age = age;
            }
        }
        public class Zebra extends Animal {
            public Zebra(int age) {
                super(age);
            }
            public Zebra() {
                this(4);
            }
        } */

        //Como Animal no usa extends para heredar de ninguna otra clase, implícitamente extiende de java.lang.Object.
        //Todas las clases en Java, si no indicas lo contrario, heredan de Object.

        //En la segunda clase, Zebra, la primera declaración del primer constructor es una llamada al constructor de Animal,
        //que toma un solo argumento. La clase Zebra también incluye un segundo constructor sin argumentos que no llama a super(),
        //sino que llama al otro constructor dentro de la clase Zebra usando this(4).
        
        //Al igual que el comando this(), el comando super() solo puede usarse como la primera declaración del constructor.
        //SINO, NO COMPILARÍA. EJM:

        /* public class Zoo {
            public Zoo() {
                System.out.println("Zoo created");
                super(); // NO COMPILA, PORQUE super() debe ser declarado en la primera instrucción del constructor
            }
        }

        public class Zoo {
            public Zoo() {
                super();
                System.out.println("Zoo created");
                super();  //NO COMPILA, YA QUE A PESAR QUE TIENE UN super() EN LA PRIMERA INSTRUCCION DEL CONSTRUCTOR, ESTA LINEA
                            QUE CONTIENE super() SE ENCUENTRA EN LA TERCERA INSTRUCCION DEL CONSTRUCTOR.
            }
        } */

        //OBLIGATORIAMENTE DEBE IR EN LA PRIMERA INSTRUCCION DEL CONSTRUCTOR
        //APARTE QUE NO ES OBLIGARTORIO COLOCAR EL SUPER(), SI ES QUE EL PADRE NO TIENE CONSTRUCTORES (JAVA LE INSERTA UNO POR DEFECTO),
        //O TIENE UN CONSTRUCTOR SIN PARAMETROS

        //EN CAMBIO, ES OBLIGATORIO COLOCAR EL SUPER(), CUANDO LA CLASE PADRE TIENE CONSTRUCTORES CON PARAMETROS

        //Si la clase padre tiene más de un constructor, la clase hija puede usar cualquier
        //constructor válido de la clase padre en su definición,

        /* public class Animal {
            private int age;
            private String name;
            public Animal(int age, String name) {
                super();
                this.age = age;
                this.name = name;
            }
            public Animal(int age) {
                super();
                this.age = age;
                this.name = null;
            }
        }
            
        public class Gorilla extends Animal {
            public Gorilla(int age) {
                super(age,"Gorilla");
            }
            public Gorilla() {
                super(5);
            }
        } */

        //Los constructores hijos no están obligados a llamar a constructores padres coincidentes
        //Cualquier constructor padre válido es aceptable siempre que se proporcionen los parámetros de entrada adecuados al constructor padre.
    }

    public void Understanding_Compiler_Enhancements(){
        //Anteriormente hemos definido numerosas clases que no llamaban explícitamente al constructor
        //de la clase padre mediante la palabra clave super()

        //El compilador de Java insertaba automáticamente una llamada al constructor sin argumentos super()
        //si la primera instrucción no es una llamada al constructor de la clase padre. 

        //Ejmplo: las sgtes 3 son equivalentes y Java lo convertiría a la ultima versión:

        /* public class Donkey {
        }
        public class Donkey {
            public Donkey() {
            }
        }
        public class Donkey {
            public Donkey() {
                super();
            }
        } */

        // ES DECIR, SI YO TENGO ESTO:
        /* public class Animal {
            // sin constructores definidos (o con Animal() explícito)
        }

        public class Donkey extends Animal {
            // sin ningún constructor escrito
        } */
        
        //Java, al compilar, se comporta como si hubieras escrito:

        /* public class Donkey extends Animal {
            public Donkey() {
                super();
            }
        } */

        //EL SIGUIENTE CODIGO NO SE COMPILARÁ:
        /* public class Mammal {
            public Mammal(int age) {    //TIENE UN CONSTRUCTOR CON UN PARAMETRO
            }
        }

        public class Elephant extends Mammal {  //NO COMPILARÁ PORQUE NO HAZ DECLARADO UN CONSTRUCTOR CON EL SUPER() 
                                                    PASANDOLE EL ARGUMENTO INT AGE
        } */

        //En este ejemplo no se define ningún constructor dentro de la clase Elefante,
        //así que el compilador intenta insertar un constructor predeterminado sin argumentos con una llamada a super().
        //Sin embargo, el compilador se detiene cuando se da cuenta de que no hay ningún constructor padre que no requiera argumentos.

        // OTRO EJEMPLO QUE NO COMPILARÍA:

        /* public class Mammal {
            public Mammal(int age) {
            }
        }
        public class Elephant extends Mammal {
            public Elephant() {  // TAMPOCO COMPILARÁ, PORQUE SE DECLARÓ EL CONTRUCTOR ELEPHANT, Y JAVA TRATA DE COLOCARLE EL SUPER()
                                POR DEFECTO, SIN ARGUMENTOS, PERO MAMMAL NO TIENE UN CONSTRUCTOR SIN ARGUMENTOS.
            }
        } */

        //SIN EMBARGO, SE PUEDE ARREGLAR ESTO AÑADIENDO EL SUPER() Y PASANDOLE EL ARGUMENTO DEL CONSTRUCTOR DE LA CLASE PADRE. EJM:

        /* public class Mammal {
            public Mammal(int age) {
            }
        }
        public class Elephant extends Mammal {
            public Elephant() {
                super(10);
            }
        } */

        //Las subclases pueden definir constructores sin argumentos aunque sus clases padre no lo hagan,
        //siempre y cuando el constructor del hijo llame a un constructor del padre mediante un comando super() explícito.

        //TENER CUIDADO CON ELLO EN EL EXAMEN Y SIEMPRE ASEGURARSE DE QUE EL CODIGO COMPILE.
    }

    public void Reviewing_Constructor_Rules(){
        //Reglas de definición de constructores: 
        /* 
            * 1. La primera instrucción de cada constructor es una llamada a otro constructor dentro de la clase usando this(),
            *    o una llamada a un constructor en la clase directa padre usando super()
            * 2. La llamada a super() no se puede usar después de la primera instrucción del constructor.
            * 3. Si no se declara una llamada a super() en un constructor, Java insertará un super() sin argumentos como la primera
            *    instrucción del constructor.
            * 4. Si la clase padre no tiene un constructor sin argumentos y la clase hija no define ningún constructor, el compilador
            *    dará un error e intentará insertar un constructor por defecto sin argumentos en la clase hija.
            * 5. Si la clase padre no tiene un constructor sin argumentos, el compilador requiere una llamada explícita a un constructor
            *    de la clase padre en cada constructor de la clase hija.
        */
    }

    public void Calling_Constructors(){
        //En Java, el constructor de la clase padre siempre se ejecuta antes que el constructor de la clase hija. Ejm:
        /* class Primate {
            public Primate() {
                System.out.println("Primate");
            }
        }

        class Ape extends Primate {
            public Ape() {
                System.out.println("Ape");
            }
        }
            
        public class Chimpanzee extends Ape {
            public static void main(String[] args) {
                new Chimpanzee();
            }
        } */

        //La respuesta a este llamado serí: 
        // Primate 
        // Ape

        //El compilador primero inserta el comando super() como la primera instrucción de los constructores de Primate y Ape.
        //Luego, el compilador inserta un constructor predeterminado sin argumentos en la clase Chimpancé con super()
        //como la primera instrucción del constructor.
        //El código se ejecutará llamando primero a los constructores padres.

        //TENER EN CUENTA QUE A LOS CREADORES DEL EXAMEN LES GUSTA COLOCAR EJERCICIOS COMO EL EJEMPLO ANTERIOR.
        //ASÍ QUE ES BUENO, PENSAR COMO EL COMPILADOR.
    }

    public void Calling_Inherited_Class_Members(){
        //Las clases de Java pueden usar cualquier miembro público o protegido de la clase padre, incluidos métodos, primitivas o
        //referencias a objetos.

        //Si la clase padre y la clase hija son parte del mismo paquete, la clase hija también puede usar cualquier miembro
        //predeterminado definido en la clase padre.
        
        //Finalmente, una clase hija nunca puede acceder a un miembro privado de la clase padre, al menos no a través de una referencia directa.
        //Sino a través de métodos como el getter. EJM:

        /* class Fish {
            protected int size;
            private int age;
            public Fish(int age) {
                this.age = age;
            }
            public int getAge() {
                return age;
            }
        }
        public class Shark extends Fish {
            private int numberOfFins = 8;
            public Shark(int age) {
                super(age);
                this.size = 4; 
            }
            public void displaySharkDetails() {
                System.out.print("Shark with age: "+getAge());
                System.out.print(" and "+size+" meters long");
                System.out.print(" with "+numberOfFins+" fins");
            }
        } */

        //protected significa que ese atributo es heredado y accesible directamente por cualquier subclase, incluyendo Shark.
        //Cuando Shark extends Fish, cada objeto Shark contiene dentro de sí mismo el campo size (heredado de Fish), como si fuera propio.
        //POR ESO PERMITE UTILIZAR EL THIS.SIZE.

        //La clase hija hereda todos los miembros del padre excepto los private.

        //EJEMPLO:
        /* public void displaySharkDetails() {
            System.out.print("Shark with age: "+this.getAge());
            System.out.print(" and "+this.size+" meters long");
            System.out.print(" with "+this.numberOfFins+" fins");
        } */

        //ESTO ESTÁ CORRECTO, YA QUE ESAS VARIABLES Y MÉTODOS DEL PADRE TAMBIÉN LE CORRESPONDEN AL HIJO.

        //Además, en Java, puedes referenciar explícitamente un miembro de la clase padre usando la palabra clave super. EJM:
        /* public void displaySharkDetails() {
            System.out.print("Shark with age: "+super.getAge());
            System.out.print(" and "+super.size+" meters long");
            System.out.print(" with "+this.numberOfFins+" fins");
        } */

        //Como se puede ver, podríamos usar this o super para acceder a un miembro de la clase padre.
        //SIN EMBARGO, NO SE PUEDE USAR SUPER EN VARIABLES O METODOS QUE LE CORRESPONDEN NETAMENTE A LA CLASE HIJA. EJM:

        /* public void displaySharkDetails() {
            System.out.print("Shark with age: "+super.getAge());
            System.out.print(" and "+super.size+" meters long");
            System.out.print(" with "+super.numberOfFins+" fins"); //NO COMPILA PORQUE numberOfFins ES VARIABLE SOLO DE LA CLASE HIJA.
        } */

        /*======================================================
        Super() vs super
        _______________________________________________________
        Así como this() (LLAMA A OTRO CONSTRUCTOR) y this (ACCEDE A LOS ATRIBUTOS O METODOS DEL OBJETO) no están relacionados en Java.
        De la misma manera, super() y super son bastante diferentes,
        pero pueden usarse en los mismos métodos en el examen.

        * El primero, super(), es una instrucción que llama explícitamente a un constructor padre y solo puede usarse en la primera línea
        de un constructor de una clase hija.

        * El segundo, super, es una palabra clave que se usa para referirse a un miembro (VARIABLE O METODO) definido en una clase padre
        y puede usarse en toda la clase hija.

        PARA TENERLO CLARO, TENGAMOS EN CUENTA LO SIGUIENTE: SUPER() VA EN EL CONSTRUCTOR Y SUPER NO VA EN EL CONSTRUCTOR, LO USAN EN METODOS
        DE LA CLASE HIJA Y TAMBIÉN EN EL CONSTRUCTOR: EJM: this.numeroDeAletas = super.size;. PERO LUEGO DE LA PRIMERA LINEA.


        //OTRO EJEMPLO:
        public Rabbit(int age) {
            super();
            super.setAge(10);
        }

        EL EJEMPLO ESTÁ CORRECTO, La primera declaración del constructor llama al constructor de la clase padre,
        mientras que la segunda declaración llama a una función definida en la clase padre.

        //OTRO EJEMPLO:
        public Rabbit(int age) {
            super;  // NO COMPILA
            super().setAge(10);  // NO COMPILA
        }
        
        NO COMPILA, porque la primera declaración debe ser super(), con parentesis, y la segunda instrucción, debe ser super.setAge(10).
        para acceder al metodo de la clase padre.
        ======================================================== */
    }

    public void Inheriting_Methods(){
        //Heredar una clase nos da acceso a los miembros públicos y protegidos de la clase padre,
        //pero también prepara el terreno para choques entre métodos definidos tanto en la clase padre como en la subclase
        this.Overriding_a_Method();
        this.Redeclaring_private_Methods();
        this.Hiding_Static_Methods();
        this.Overriding_vs_Hiding_Methods();
        this.Creating_final_methods();
    }

    private void Overriding_a_Method(){
        //¿Qué pasa si hay un método definido tanto en la clase padre como en la clase hija?
        //En este caso, se puede sobrescribir un método declarando un nuevo método con la misma firma y tipo de retorno que el método en la clase padre.
        //RECORDAR TAMBIÉN que la firma del método incluye el nombre y la lista de parámetros de entrada.
        //Y ADEMÁS hay una restricción: el tipo de retorno del método hijo debe ser igual o un subtipo (covariante) del tipo de retorno del método padre.

        //Cuando se sobrescribe un método, se puede hacer referencia a la versión del método del padre usando la palabra clave super.
        //De esta manera, las palabras clave this y super te permiten elegir entre la versión actual y la versión del padre de un método, respectivamente.

        /* public class Canine {
            public double getAverageWeight() {
                return 50;
            }
        }
        public class Wolf extends Canine {
            public double getAverageWeight() {
                return super.getAverageWeight()+20;
            }
            public static void main(String[] args) {
                System.out.println(new Canine().getAverageWeight());
                System.out.println(new Wolf().getAverageWeight());
            }
        } */
        
        //LO QUE SE IMPRIMIRÁ ES LO SGTE:
        //50.00
        //70.00

        //ERA NECESARIO USAR EL SUPER EN EL METODO DEL HIJO? QUE PASARÍA? SI SE QUITA EL SUPER?. PUES PASARÍA LO SIGUIENTE:

        /* public double getAverageWeight() {
            return getAverageWeight()+20;  // INFINITE LOOP
        } */

        //SE FORMARÍA UN BUCLE INFINITO, DONDE A EL RETURN SIEMPRE VUELVE A LLAMAR AL METODO PARA SUMARLE 20

        //Java pensaría que estás ejecutando una llamada recursiva.
        //Una función recursiva es aquella que se llama a sí misma como parte de su ejecución, y es común en la programación.
        //Una función recursiva debe tener una condición de terminación. En este ejemplo, no hay una condición de terminación; por lo tanto,
        //la aplicación intentará llamarse a sí misma infinitamente y producirá un error de desbordamiento de pila en tiempo de ejecución.

        /*
            El compilador realiza las siguientes comprobaciones cuando sobrescribes un método no privado:
            * 1. El método en la clase hija debe tener la misma firma que el método en la clase padre.
            * 2. El método en la clase hija debe ser al menos tan accesible o más accesible que el método en la clase padre.
            * 3. El método en la clase hija no puede lanzar una excepción comprobada que sea nueva o más amplia que la clase de cualquier excepción lanzada en el
            *    método de la clase padre.
            * 4. Si el método devuelve un valor, debe ser el mismo o una subclase del método en la clase padre, lo que se conoce como tipos de retorno covariantes.
        */

        /*======================================================
        Overloading (sobrecarga) vs. Overriding (sobreescritura)
        _______________________________________________________

        Sobrecargar un método y sobrescribir un método son similares en que ambos implican redefinir un método usando el mismo nombre.
        Se diferencian en que un método sobrecargado usará una firma diferente (parametros) a la de un método sobrescrito.
        Esta distinción permite que los métodos sobrecargados tengan mucha más libertad en la sintaxis que un método sobrescrito.

        UN METODO SOBRECARGADO PUEDE TENER DIFERENTE TIPO DE RETORNO.

        public class Bird {
            public void fly() {
                System.out.println("Bird is flying");
            }
            public void eat(int food) {
                System.out.println("Bird is eating "+food+" units of food");
            }
        }

        public class Eagle extends Bird {
            public int fly(int height) {        //ESTE METODO SE SOBRECARGA / OVERLOAD (MISMO NOMBRE DE METODO, PERO DIFERENTES PARAMETROS)
                System.out.println("Bird is flying at "+height+" meters");
                return height;
            }
            public int eat(int food) { // ESTE METODO NO COMPILA PORQUE NO ES EL MISMO METODO QUE ESTÁ EN LA CLASE PADRE, ESTÁS QUE RETORNAS DIFERENTE
                System.out.println("Bird is eating "+food+" units of food");
                return food;
            }
        }

        //El primer método, fly(), se sobrecarga en la subclase Eagle, ya que la firma cambia de un constructor sin argumentos a un constructor con un argumento int.
        // Como el método se está sobrecargando y no sobreescribiendo, el tipo de retorno se puede cambiar de void a int sin problema.

        //El segundo método, eat(), se sobreescribe en la subclase Eagle, ya que la firma es la misma que en la clase padre Bird: ambos toman un solo argumento int.
        //Como el método se está sobreescribiendo, el tipo de retorno del método en Eagle debe ser una subclase o del mismo tipo de retorno del método en Bird.
        //En este ejemplo, el tipo de retorno void no es una subclase de int; por lo tanto, el compilador lanzará una excepción en esta definición del método.

            * EN POCAS PALABRAS, SOBRECARGA (mismo nombre pero diferentes parametros) SI PERMITE DIFERENTE TIPO DE RETORNO.
            * SOBREESCRITURA (mismo nombre e igual parametro) PERMITE QUE TENGA EL MISMO TIPO DE RETORNO O UNA SUBCLASE DE RETORNO.
            * 
            * //TENER CUIDADO: PRIMERO OBSERVAR SI EL METODO SE ESTÁ SOBRECARGANDO O SOBREESCRIBIENDO, PARA SABER SI EL PROGRAMA COMPILA.
            * Sobrescritura (Override) → SIEMPRE necesita herencia
            * Sobrecarga (Overload) → puede darse en AMBOS casos
        ========================================================*/

        //EJM:
        /* public class Camel {
            protected String getNumberOfHumps() {
                return "Undefined";
            }
        }

        public class BactrianCamel extends Camel {
            private int getNumberOfHumps() {  // NO COMPILA. 
                return 2;
            }
        } */

        //Tienen el mismo nombre, y tienen los mismo parametros (ninguno), entonces es sobreescritura, POR LO TANTO, NO PUEDEN TENER DIFERENTE TIPO DE RETORNO

        //En este ejemplo, el método en la clase hija no compila por dos razones.
        //Primero, viola la segunda regla de sobrescribir métodos: el método hijo debe ser al menos tan accesible como el del padre.
        //En el ejemplo, el método del padre usa el modificador protected, pero el método de la hija usa el modificador private,
        //lo que lo hace menos accesible en la hija que en el padre.
        //También viola la cuarta regla de sobrescribir métodos: el tipo de retorno del método del padre y del hijo debe ser covariante.
        //En este ejemplo, el tipo de retorno del método del padre es String, mientras que el tipo de retorno del método de la hija es int,
        //ninguno de los cuales es covariante con el otro.

        //OTRO EJEMPLO:

        /* public class InsufficientDataException extends Exception {}
        public class Reptile {
            protected boolean hasLegs() throws InsufficientDataException {
                throw new InsufficientDataException();
            }
            protected double getWeight() throws Exception {
                return 2;
            }
        }
        public class Snake extends Reptile {
            protected boolean hasLegs() {       //metodo sobreescrito
                return false;
            }
            protected double getWeight() throws InsufficientDataException{      //metodo sobreescrito
                return 2;
            }
        } */

        //ESTE CODIGO FUNCIONA, PORQUE SON METODO SOBREESCRITOS, Y RESPETAN LA REGLA DOS DE LOS MODIFICADORES DE ACCESO,
        //RESPETAN LA REGLA 3 DE QUE LOS METODOS HIJOS NO PUEDEN LANZAR
        //EXCEPCIONES NUEVAS O MÁS AMPLIAS QUE LA DEL PADRE Y TAMBIÉN LA REGLA 4 QUE RESPETAN LOS TIPOS DE RETORNO DEL METODO PADRE.

        //Además, un método hijo puede ocultar o eliminar la excepción de un método padre sin problema.

        //Otro ejemplo:

        /* public class InsufficientDataException extends Exception {}
        public class Reptile {
            protected double getHeight() throws InsufficientDataException {
                return 2;
            }
            protected int getLength() {
                return 10;
            }
        }

        public class Snake extends Reptile {
            protected double getHeight() throws Exception {  // NO COMPILA
                return 2;
            }
            protected int getLength() throws InsufficientDataException { // NO COMPILA
                return 10;
            }
        } */

        //Este nuevo ejemplo no va compilar en los métodos de la clase hija, porque el primer metodo sobreescrito está lanzando una Exception
        //mayor a la que lanza su clase padre que es InsufficientDataException.
        //Como Exception no es una subclase de InsufficientDataException, se viola la tercera regla de los métodos sobrescritos y el código no compilará. 

        //Y el segundo metodo sobreescrito de la clase hija, está añadiendo una exception nueva que el metodo de la clase padre no tiene.
        //la clase hija define una nueva excepción que la clase padre no tenía, lo que también viola la tercera regla de los métodos sobrescritos.
    }

    private void Redeclaring_private_Methods(){
        //En Java, no es posible sobrescribir un método privado en una clase padre, ya que el método de la clase padre no es accesible
        //desde la clase hija. Solo porque una clase hija no tenga acceso al método del padre, no significa que la clase hija no pueda
        //definir su propia versión del método. Esto simplemente significa, que el nuevo método no es una versión sobrescrita del método
        //de la clase padre. Java te permite redeclarar un nuevo método en la clase hija con la misma firma o una modificada que
        //la del método en la clase padre. Este método en la clase hija es un método separado e independiente,
        //sin relación con el método de la versión del padre, por lo que no se aplican las reglas para sobrescribir métodos.

        //ES DECIR QUE, ESTAMOS HABLANDO DE METODOS QUE YA NO SON SOBREESCRITOS, SINO METODOS INDEPENDIENTES (SIEMPRE Y CUANDO SEAN PRIVATE) EJM:

        /* public class Camel {
            private String getNumberOfHumps() {     //METODO PRIVATE DE TIPO DE RETORNO STRING
                return "Undefined";
            }
        }

        public class BactrianCamel extends Camel {
            private int getNumberOfHumps() {        //METODO PRIVATE DE TIPO DE RETORNO INT
                return 2;   
            }
        } */

        //ESTE CODIGO, SI COMPILA, YA QUE SON METODO INDEPENDIENTES Y NO SOBREESCRITOS.
        //Si el método en la clase padre fuera público o protegido, el método en la clase hija no se compilaría porque
        //violaría dos reglas de sobrescribir métodos. (DE MODIFICADOR DE ACCESO MENOR Y DE DIFERENTES TIPO DE RETORNO)
    }

    private void Hiding_Static_Methods(){
        //Un método oculto ocurre cuando una clase hija define un método estático con el mismo nombre y
        //firma (parámetros) que un método estático definido en una clase padre.

        //Ocultar un método es similar, pero no exactamente igual, que sobrescribir un método.
        //Primero, se deben seguir las cuatro reglas anteriores para sobrescribir un método cuando se oculta uno. 
        //Además, se agrega una nueva regla para ocultar un método, que es que el uso de la palabra clave static,
        //que debe ser el mismo entre las clases padre e hija.

        /*
            LAS REGLAS PARA OCULTAR UN MÉTODO ESTATICO SON LAS SIGUIENTES:
            * 1. El método en la clase hija debe tener la misma firma que el método en la clase padre.
            * 2. El método en la clase hija debe ser al menos tan accesible o más accesible que el método en la clase padre.
            * 3. El método en la clase hija no puede lanzar una excepción comprobada que sea nueva o más amplia que la clase de cualquier excepción lanzada en el
            *    método de la clase padre.
            * 4. Si el método devuelve un valor, debe ser el mismo o una subclase del método en la clase padre, lo que se conoce como tipos de retorno covariantes.
            * 5. El método de la clase hija debe tener la palabra estatic si está como static en la clase padre (ocultamiento de métodos).
            *    Y, el método no debe tener la palabra static en la clase hija si no está como estatic en la clase padre (sobrescritura de métodos).
        */

        //EJMPLO, VIENDO LA UILTIMA REGLA:

        /* public class Bear {
            public static void eat() {
                System.out.println("Bear is eating");
            }
        }

        public class Panda extends Bear {
            public static void eat() {
                System.out.println("Panda bear is chewing");
            }
            public static void main(String[] args) {
                Panda.eat();
            }
        } */

        //Imprime Panda bear is chewing
        //El código se compila y se ejecuta sin problema. El método eat() en la clase hija oculta al método eat() en la clase padre.
        //Como ambos están marcados como estáticos, esto no se considera un método sobrescrito.

        //Otro ejemplo que viola la 5ta regla:

        /* public class Bear {
            public static void sneeze() {
                System.out.println("Bear is sneezing");
            }
            public void hibernate() {
                System.out.println("Bear is hibernating");
            }
        }
        public class Panda extends Bear {
            public void sneeze() {  // NO COMPILA
                System.out.println("Panda bear sneezes quietly");
            }
            public static void hibernate() {  // NO COMPILA
                System.out.println("Panda bear is going to sleep");
            }
        } */

        //El primer metodo de la clase Panda no compila porque no tiene la palabra static y la clase padre con su misma firma si lo tiene
        //El segundo metodo, es al revés, el metodo de la clase hija si tiene la palabra static pero la de la clase padre no la tiene. entonces tampoco compila
    }

    private void Overriding_vs_Hiding_Methods(){
        //quién decide qué método se ejecuta y cuándo.

        //Override (métodos normales)
        //Siempre gana el método del objeto real, sin importar dónde esté escrita la llamada (en el padre o en el hijo).

        //HAY QUE TENER EN CUENTA QUE OBJETO REAL SE REFIERE AL OBJETO QUE SE CREÓ CON new, SIN IMPORTAR QUE TIPO DE VARIABLE SE UTILIZÓ PARA GUARDARLO. EJMPLO:

        class Bear {
            public void eat() { System.out.println("Bear eating"); }
            public void llamar() { eat(); } // está en Bear, pero...
        }

        class Panda extends Bear {
            @Override
            public void eat() { System.out.println("Panda chewing"); }
        }

        Bear b = new Panda();
        b.llamar(); // imprime "Panda chewing" ← aunque llamar() esté definido en Bear


        //Aunque llamar() esté en Bear y llame a eat(), como el objeto real es Panda, ejecuta la versión de Panda. Siempre gana el hijo.

        //Hiding (métodos static)
        //Gana el método de la clase donde está escrita la llamada, no el objeto real.

        class Bear1 {
            public static void eat() { System.out.println("Bear eating"); }
            public static void llamar() { eat(); } // está en Bear
        }
        class Panda1 extends Bear1 {
            public static void eat() { System.out.println("Panda chewing"); }
        }

        Panda1.llamar(); // imprime "Bear eating" ← porque llamar() está en Bear


        //OTRO EJMPLO:

        /* public class Marsupial {
            public static boolean isBiped() {
                return false;
            }
            public void getMarsupialDescription() {
                System.out.println("Marsupial walks on two legs: "+isBiped());
            }
        }

        public class Kangaroo extends Marsupial {
            public static boolean isBiped() {
                return true;
            }
            public void getKangarooDescription() {
                System.out.println("Kangaroo hops on two legs: "+isBiped());
            }
            public static void main(String[] args) {
                Kangaroo joey = new Kangaroo();
                joey.getMarsupialDescription();
                joey.getKangarooDescription();
            }
        } */

        //EL CODIGO COMPILA Y MUESTRA EL SIGUIENTE MENSAJE:
        //Marsupial walks on two legs: false
        //Kangaroo hops on two legs: true

        //En este ejemplo isBiped() devuelve false en la clase padre y true en la clase hija.
        //En la primera llamada al método, se usa el método de la clase padre getMarsupialDescription().
        //La clase Marsupial solo conoce isBiped() desde su propia definición de clase, así que devuelve false.
        //En la segunda llamada al método, la clase hija ejecuta un método de isBiped(),
        //que oculta la versión del método de la clase padre y devuelve true.

        //OTRO EJEMPLO:

        /* class Marsupial {
            public boolean isBiped() {
                return false;
            }
            public void getMarsupialDescription() {
                System.out.println("Marsupial walks on two legs: "+isBiped());
            }
        }

        public class Kangaroo extends Marsupial {
            public boolean isBiped() {      //METODO SOBREESCRITO
                return true;
            }
            public void getKangarooDescription() {  //METODO SOBREESCRITO
                System.out.println("Kangaroo hops on two legs: "+isBiped());
            }
            public static void main(String[] args) {
                Kangaroo joey = new Kangaroo();
                joey.getMarsupialDescription();
                joey.getKangarooDescription();
            }
        } */

        //EN ESTE EJEMPLO, VEMOS QUE SE INSTANCIÓ EL OBJETO DE LA CLASE Kangaroo, Y TODAS LAS FUNCIONES VAN A APUNTAR A LOS METODOS SOBREESCRITOS DE Kangaroo.
        //POR LO TANTO, VA IMPRIMIR LO SIGUIENTE:
        //Marsupial walks on two legs: true
        //Kangaroo hops on two legs: true

        //Este ejemplo hace uso del polimorfismo.
    }

    private void Creating_final_methods(){
        //Los métodos final no se pueden sobreescribir.
        //Se puede crear un método con la palabra clave final.
        //Al hacerlo, sin embargo, le prohíbes a una clase hija sobreescribir este método.
        //Esta regla aplica tanto cuando sobrescribes un método como cuando ocultas un método.
        //En otras palabras, no puedes ocultar un método estático en una clase padre si está marcado como final.

        //EJM:

        /* public class Bird {
            public final boolean hasFeathers() {
                return true;
            }
        }
        public class Penguin extends Bird {
            public boolean hasFeathers() { // NO COMPILA
                return false;
            }
        } */

        //NO COMPILA YA QUE METODOS CON LA PALABRA FINAL NO SE PUEDE SOBREESCRIBIR NI OCULTAR
        //Tener en cuenta que si el método de la clase hija usa o no la palabra clave final no importa: el código no se compilará de ninguna manera.

        //Marcar un metodo como final tiene sus ventajas:
        //El modificador final solo se usa en métodos cuando el autor del método padre quiere garantizar un comportamiento muy específico.
    }

    public void Inheriting_Variables(){
        //Las reglas para las variables con el mismo nombre en la clase padre y la clase hija son mucho más simples,
        //porque Java no permite que las variables sean sobrescritas, sino que se oculten.

        this.Hiding_Variables();
    }

    private void Hiding_Variables(){
        //Cuando ocultas una variable, defines una variable con el mismo nombre que una variable en una clase padre.
        //Esto crea dos copias de la variable dentro de una instancia de la clase hija:
        // 1. una instancia definida para la referencia del padre.
        // 2. otra instancia definida para la referencia de la hija.
        
        //Al igual que al ocultar un método estático, no se puede sobrescribir una variable; solo se puede ocultar.

        //También, similar a ocultar un método estático, las reglas para acceder a las variables del padre y del hijo son bastante similares.
        //Si haces referencia a la variable desde dentro de la clase padre, se usa la variable definida en la clase padre.
        //Y si haces referencia a la variable desde dentro de una clase hija, se usa la variable definida en la clase hija.
        //De igual manera, puedes referirte al valor de la variable del padre usando explícitamente la palabra clave super.

        /* public class Rodent {
            protected int tailLength = 4;
            public void getRodentDetails() {
                System.out.println("[parentTail="+tailLength+"]");
            }
        }
        public class Mouse extends Rodent {
            protected int tailLength = 8;
            public void getMouseDetails() {
                System.out.println("[tail="+tailLength +",parentTail="+super.tailLength+"]");
            }
            public static void main(String[] args) {
                Mouse mouse = new Mouse();
                mouse.getRodentDetails();
                mouse.getMouseDetails();
            }
        } */

        //Este código se compila sin problemas
        //IMPRIME
        //[parentTail= 4]
        //[tail= 8 ,parentTail= 4]

        //SLa instancia de Mouse contiene dos copias de la variable tailLength:
        //una definida en el padre y otra definida en el hijo.
        // Estas instancias se mantienen separadas entre sí,
        // lo que permite que nuestra instancia de Mouse haga referencia a ambos valores de tailLength de manera independiente.


        //IMPORTANTE: No escondas variables en la práctica
        //Aunque Java permite ocultar una variable definida en una clase padre con otra definida en una clase hija,
        //se considera una práctica de codificación extremadamente mala.

        /* public class Animal {
            public int length = 2;
        }

        public class Jellyfish extends Animal {
            public int length = 5;
            public static void main(String[] args) {
                Jellyfish jellyfish = new Jellyfish();
                Animal animal = new Jellyfish();
                System.out.println(jellyfish.length);       //IMPRIME 5
                System.out.println(animal.length);          //IMPRIME 2
            }
        } */

        //las variables en Java no son polimórficas.
        //Este código se compila sin problema. Y el resultado es:
        //5
        //2

        //Se creó el mismo tipo de objeto dos veces, pero la referencia al objeto determina qué valor se ve como salida.
        //Ocultar variables hace que el código sea muy confuso y difícil de leer, especialmente si comienzas a modificar
        //el valor de la variable tanto en los métodos del padre como del hijo, ya que puede no estar claro qué variable estás actualizando.

        //Al definir una nueva variable en una clase hija, se considera una buena práctica de programación elegir un nombre para la variable
        //que no sea ya una variable pública, protegida o por defecto que se use en la clase padre

        //Ocultar variables privadas se considera menos problemático porque la clase hija no tenía acceso a la variable en la clase padre
        //desde un principio.
    }

}
