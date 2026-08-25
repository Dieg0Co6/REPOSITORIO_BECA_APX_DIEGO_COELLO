package com.app4.day_nine.Creating_Constructors;

public class Creating_Constructors {
    public static void main(String[] args) {
        //Un constructor es un método especial que coincide con el nombre de la clase y no tiene tipo de retorno. EJM:

        /* public class Bunny {
            public Bunny() {        //ESTE ES EL CONTRUCTOR, EN EL QUE SE PUEDE VER QUE NO TIENE TIPO DE RETORNO, NI EL VOID
                System.out.println("constructor");
            }
        } */
        
        //El nombre del constructor, Bunny, coincide con el nombre de la clase, Bunny, y no tiene tipo de retorno, ni siquiera void.
        //Eso lo convierte en un constructor.

        //public bunny() { }     // NO COMPILA PORQUE NO ES IGUAL AL NOMBRE DE LA CLASE. YA QUE ES CASE SENSITIVE (DEBE SER Bunny)
        //public void Bunny() { } //Esto lo toma como método, ya que cuenta con retorno void

        //El primero no coincide con el nombre de la clase porque Java distingue entre mayúsculas y minúsculas.
        //El segundo método es un método perfectamente bueno, pero no es un constructor porque tiene un tipo de retorno.


        //Los constructores se usan al crear un nuevo objeto.
        //Este proceso se llama instanciación porque crea una nueva instancia de la clase.
        //Un constructor se llama cuando escribimos new seguido del nombre de la clase que queremos instanciar. EJM:

        //new Bunny()

        //Cuando Java ve la palabra clave new, asigna memoria para el nuevo objeto.
        //Java también busca un constructor y lo llama.
        // Un constructor normalmente se usa para inicializar variables de instancia.

        //La palabra clave this le indica a Java que quieres referirte a una variable de instancia. (EN SU MAYORÍA DE VECES ES OPCIONAL)

        // El problema es que a veces hay dos variables con el mismo nombre.
        // En un constructor, una es un parámetro y la otra es una variable de instancia.
        // Si no dices lo contrario, Java te da la que tiene el alcance más específico, que es el parámetro.
        // Usar this.name le dice a Java que quieres la variable de instancia. Ejm:

        /* public class Bunny {
            private String color;       //variable de instancia
            public Bunny(String color) {    //parametro
                this.color = color;     //el valor del parametro asignandose a la variable de instancia.
            } 
        } */

        //Asignamos el parámetro color a la variable de instancia color.
        //El lado derecho de la asignación se refiere al parámetro porque no especificamos nada especial.
        //El lado izquierdo de la asignación usa this para decirle a Java que queremos que use la variable de instancia.

        /* public class Bunny {
            private String color;       //3 variables de instancia
            private int height;
            private int length;
            public Bunny(int length, int theHeight) {       //constructor
                length = this.length;     // es al revés, ESTÁ MAL. ESTÁ INCORRECTO.
                height = theHeight;          // está bien porque son nombres diferentes, Java identifica cada uno
                this.color = "white";     // está bien pero redundante, siempre que se instancia, color será white.
            } 
            public static void main(String[] args) {
                Bunny b = new Bunny(1, 2);
                System.out.println(b.length + " " + b.height + " " + b.color);
            } 
        } */

        //TIENE MAL LA LÓGICA PERO SÍ COMPÍLA.

        //La variable de instancia length empieza con un valor de 0.
        //Ese 0 se asigna al parámetro del método length. La variable de instancia se queda en 0.

        Creating_Constructors creating_Constructors = new Creating_Constructors();
        creating_Constructors.Default_Constructor();
        creating_Constructors.Overloading_Constructors();
        creating_Constructors.Final_Fields();
        creating_Constructors.Order_of_Initialization();
    }
    
    public void Default_Constructor(){
        //Cada clase en Java tiene un constructor, ya sea que escribas uno o no.
        //Si no incluyes ningún constructor en la clase, Java creará uno por ti sin ningún parámetro.

        //Este constructor creado en Java se llama el constructor por defecto.
        //A veces lo llamamos el constructor por defecto sin argumentos para mayor claridad. EJM:

        /* public class Rabbit {
            public static void main(String[] args) {
                Rabbit rabbit = new Rabbit();          // LLAMADA AL CONSTRUCTOR POR DEFECTO
            }
        } */

        //En la clase Rabbit, Java ve que no se programó ningún constructor y crea uno.
        //Este constructor por defecto es equivalente a escribir esto:

        //public Rabbit() {}

        //El constructor por defecto tiene una lista de parámetros vacía y un cuerpo vacío.        
        // Esto ocurre durante el paso de compilación.Solo aparece en el archivo compilado con la extensión .class.
        // Recuerda que un constructor por defecto solo se proporciona si no hay constructores presentes.

        /* class Rabbit1 { //USARÁ UN CONSTRCUTOR POR DEFECTO
        }
        class Rabbit2 {
        public Rabbit2() { }    //YA TIENE CONSTRUCTOR, YA NO USARÁ OTRO POR DEFECTO
        }
        class Rabbit3 {
        public Rabbit3(boolean b) { }   //YA TIENE UN CONSTRUCTOR CON PARAMETRO
        }
        class Rabbit4 {
        private Rabbit4() { }   //YA TIENE CONSTRUCTOR, YA NO USARÁ OTRO POR DEFECTO
        } */

        //Solo Rabbit1 obtiene un constructor predeterminado sin argumentos.
        //No tiene un constructor codificado, así que Java genera un constructor predeterminado sin argumentos.
        //Rabbit2 y Rabbit3 ya tienen constructores públicos. Rabbit4 tiene un constructor privado. 
        //Como estas tres clases tienen un constructor definido, no se inserta el constructor predeterminado sin argumentos.
        
        //EJMPLO DE COMO LLAMARLO:
        /* public class RabbitsMultiply {
            public static void main(String[] args) {

            Rabbit1 r1 = new Rabbit1(); //está bien llamado al constructor
            Rabbit2 r2 = new Rabbit2(); //está bien llamado al constructor
            Rabbit3 r3 = new Rabbit3(true);  //está bien llamado al constructor
            Rabbit4 r4 = new Rabbit4(); // NO COMPILA PORQUE SE ESTÁ LLAMANDO EN OTRA CLASE, Y TIENE EL MODIFICADOR DE ACCESO PRIVATE.
            } 
        } */

        //La ultima no se compila. Rabbit4 hizo que el constructor fuera privado para que otras clases no pudieran llamarlo.
        //Tener un constructor privado en una clase le dice al compilador que no proporcione un constructor por defecto sin argumentos.
        //También evita que otras clases instancien la clase.
    }

    public void Overloading_Constructors(){
        //Se puede tener varios constructores en la misma clase siempre que tengan diferentes firmas de método.
        //Con los constructores, el nombre siempre es el mismo, ya que debe ser igual al nombre de la clase.
        //Esto significa que los constructores deben tener diferentes parámetros para poder ser sobrecargados.

        /* public class Hamster {
            private String color;
            private int weight;
            public Hamster(int weight) {               // Primer constructor
                this.weight = weight;
                color = "brown";
            }
            public Hamster(int weight, String color) {     // Segundo constructor
            this.weight = weight;
            this.color = color;
            }
        } */

        //Diferentes constructores, porque tienen diferentes parametros, entonces está cumpliendose la sobrecarga (overload) de constrcutores

        //En el caso de que realmente queremos es que el primer constructor llame al segundo constructor con dos parámetros.
        //Podrías sentir la tentación de escribir esto:

        /* public Hamster(int weight) {
            Hamster(weight, "brown");     // ESTO NO COMPILA
        } */

        //Esto no compilará. Los constructores solo se pueden llamar escribiendo new antes del nombre del constructor.
        //No son como los métodos normales que puedes simplemente llamar. EJM:
        
        /* public Hamster(int weight) {
            new Hamster(weight, "brown");     //Se compila pero no hace lo que queremos. ESTÁ MAL ASÍ.
        } */
        
        //Esto sí compila... pero crea un hámster nuevo y distinto, que se pierde (nadie lo guarda).
        //CREA UN OBJETO NUEVO Y SEPARADO (se pierde)
        //El hámster original que estabas construyendo se queda sin color asignado. No es lo que quieres.

        //La solución correcta ES USAR: this(...)
        
        /* public Hamster(int weight) {
            this(weight, "brown");
        } */

        //Cuando usas this(...) (con paréntesis, como si fuera método),
        //Java entiende: "llama a otro constructor de esta misma clase, sobre este mismo objeto".
        //No crea un objeto nuevo, solo termina de construir el que ya estás creando.

        //Y si coloco new this, tampoco compila. TENERLO EN CUENTA.

        /* public Hamster(int weight) {
            System.out.println("in constructor");
            this(weight, "brown");     // NO COMPILA
        } */

        //NO COMPILA porque this(...) debe ser la primera línea del constructor.
        //Java exige que la llamada a otro constructor sea lo primero que pase, sin excepciones.

        //Aunque una sentencia de impresión no cambia ninguna variable, sigue siendo una sentencia de Java y
        //no se permite insertarla antes de la llamada a this().
        //El comentario está bien. Los comentarios no ejecutan sentencias de Java y se permiten en cualquier parte.


        //Los constructores sobrecargados a menudo se llaman entre sí.
        //Una técnica común es que cada constructor agregue un parámetro hasta llegar al constructor que hace todo el trabajo.
        //Este enfoque se llama encadenamiento de constructores. Ejm:

        /* public class Mouse {
            private int numTeeth;       //se declaran 3 variables de instancia
            private int numWhiskers;
            private int weight;
            public Mouse(int weight) {  //primer constructor
                this(weight, 16); // llama al constructor con 2 parametros
            }
            public Mouse(int weight, int numTeeth) {    //segundo constructor
                this(weight, numTeeth, 6); //llama al constructor con 3 parametros
            }
            public Mouse(int weight, int numTeeth, int numWhiskers) {   //tercer constructor
                this.weight = weight;
                this.numTeeth = numTeeth;
                this.numWhiskers = numWhiskers;
            }
            public void print() {   //metodo de instancia
                System.out.println(weight + " " + numTeeth + " " + numWhiskers);
            }
            public static void main(String[] args) {
                Mouse mouse = new Mouse(15);
                mouse.print();  //imprime 15  16  6
            }
        } */
    }

    public void Final_Fields(){
        //Se vio que las variables de instancia final deben asignarse un valor exactamente una vez.
        //Esto sucede en la línea de la declaración y en un inicializador de instancia.
        // Pero hay un lugar más donde se puede hacer esta asignación: en el constructor. EJM:

        /* public class MouseHouse {
            private final int volume;       //variable de instancia final (NO SE HA INICIALIZADO AÚN)
            private final String name = "The Mouse House"; //variable de instancia final (YA SE HA INICIALIZADO AÚN). NO PUEDE CAMBIAR DE VALOR
            public MouseHouse(int length, int width, int height) {
                volume = length * width * height;       //EN EL CONSTRUCTOR SE VA INICIALIZAR EL VALOR DE VOLUME.
            }
        } */

            //El constructor es parte del proceso de inicialización, así que está permitido asignar variables de instancia final en él.
            //Para cuando el constructor termina, todas las variables de instancia final deben haber sido establecidas.
    }

    public void Order_of_Initialization(){
        //ORDEN DE INICIALIZACIÓN: HAY UN ORDEN DE INICIALIZACIÓN EN LA CUAL SE TIENE QUE APRENDER DE MEMORIA COMO VAN.

        /*
            * Si hay una superclase, inicialízala primero.(Cuando se instancia un objeto del hijo, primero se ejecuta el constructor del padre)
            * Declaraciones de variables estáticas e inicializadores estáticos en el orden en que aparecen en el archivo. (TODO AQUELLO ESTATICO)
            * Declaraciones de variables de instancia e inicializadores de instancia en el orden en que aparecen en el archivo.
            * El Constructor.
        */
        //EJM:

        /* public class InitializationOrderSimple {
            private String name = "Torchie";    //LUEGO SE TOMA EN CUENTA LOS INICIALIZADORES Y VARIABLES DE INSTANCIA
            { System.out.println(name); }
            private static int COUNT = 0;       //PRIMERO SE TOMA EN CUENTA LOS INICIALIZACIORES Y VARIABLES ESTÁTICOS.
            static { System.out.println(COUNT); }
            static { COUNT += 10; System.out.println(COUNT); }
            public InitializationOrderSimple() {
                System.out.println("constructor");
            } 
        }

        public class CallInitializationOrderSimple {
            public static void main(String[] args) {
                InitializationOrderSimple init = new InitializationOrderSimple();
            } 
        } */
            
        //SEGÚN EL ORDEN, IMPRIME: 
        // 0 
        // 10 
        // Torchie 
        // Constructor

        //La regla 1 no se aplica porque no hay una superclase.
        //La regla 2 dice que se deben ejecutar las declaraciones de variables estáticas y los inicializadores estáticos
        //La regla 3 dice que se deben ejecutar las declaraciones de variables de instancia y los inicializadores de instancia, 
        // Finalmente, la regla 4 dice que se debe ejecutar el constructor

        //Tener en cuenta que las cuatro reglas se aplican solo si se instancia un objeto
        //Si la clase se referencia sin una llamada a new, solo se aplican las reglas 1 y 2.
        //Las otras dos reglas se relacionan con instancias y constructores.
        //Tienen que esperar hasta que haya código para instanciar el objeto. ejm:

        /* public class InitializationOrder {
            private String name = "Torchie";    //CUARTO
            { System.out.println(name); }   //QUINTO
            private static int COUNT = 0;   //PRIMERO
            static { System.out.println(COUNT); } //SEGUNDO
            { COUNT++;  System.out.println(COUNT); }    //SEXTO
            public InitializationOrder() {      //SEPTIMO
                System.out.println("constructor");
            }
            public static void main(String[] args) {
                System.out.println("read to construct");    //TERCERO
                new InitializationOrder();
            }
        } */

        //ESTO IMPRIME:
        /* 0
        read to construct
        Torchie
        1
        Constructor */

        //La regla 1 no se aplica porque no hay una superclase.
        //La regla 2 nos dice que miremos las variables estáticas y los inicializadores estáticos.
        //Ahora que lo estático está resuelto, el método main() puede ejecutarse.
        //A continuación, podemos usar la regla 3 para ejecutar las variables de instancia y los inicializadores de instancia.
        //Finalmente, la regla 4 dice que se ejecute el constructor, que imprimen constructor.

        //TAMBIÉN TENER EN CUENTA QUE LOS METODOS SE PUEDEN LLAMAR DESDE CUALQUIER PARTE DEL ARCHIVO, ES DECIR, PUEDES LLAMARLOS PRIMERO
        //Y LUEGO DESPUES CREAR EL METODO.

        //OTRO EJEMPLO:

        /* public class YetMoreInitializationOrder {
            static { add(2); }  //PRIMERO
            static void add(int num) { System.out.print(num + " "); }   //SEGUNDO
            YetMoreInitializationOrder(){   //QUINTO
                add(5); 
            }
            static { add(4); }  //TERCERO
            { add(6); }
            static { new YetMoreInitializationOrder(); }    //CUARTO
            { add(8); }
            public static void main(String[] args) { }
        } */

        //COMO NO SE ESTÁ INSTANCIANDO UN OBJETO, ENTONCES, SOLO SE USAN LA REGLA 1 Y 2
        //IMPRIME 2 4 6 8 5 

        //No hay una superclase, así que saltamos directamente a la regla 2: los bloques estáticos.
        //Hay tres bloques estáticos. Se ejecutan en ese orden.El bloque estático llama al método add(), que imprime 2. 
        //El bloque estático llama al método add(), que imprime 4.
        //El último bloque estático, llama a new para instanciar el objeto.
        //Esto significa que podemos pasar a la regla 3 para ver las variables de instancia y los inicializadores de instancia.
        //Hay dos de estos. Ambos llaman al método add() e imprimen 6 y 8, respectivamente.
        //Finalmente, pasamos a la regla 4 y llamamos al constructor, que llama al método add() una vez más e imprime 5. 

        //Ese new interrumpe momentáneamente la secuencia estática para construir el objeto (reglas 3 y 4: instancia, luego constructor).

        //Y SI COMPLICAMOS MÁS EL EJEMPLO:

        /* public class YetMoreInitializationOrder {
            static { add(2); }  
            static void add(int num) { System.out.print(num + " "); }  
            YetMoreInitializationOrder(){   
                add(5); 
            }
            static { add(4); }  
            { add(6); }
            static { new YetMoreInitializationOrder(); }
            static{ add(9); } 
            { add(8); }
            static{ add(100); } 
            public static void main(String[] args) { }
        } */

        //IMPRIMIRÍA 2 4 6 8 5 9 100
        //YA QUE:
        /* Los bloques estáticos se ejecutan en orden de aparición, uno por uno:
        * static { add(2); } → imprime 2
        * static { add(4); } → imprime 4
        * static { new YetMoreInitializationOrder(); } → esto pausa la secuencia estática y construye el objeto:
        *       Inicializadores de instancia (regla 3, en orden): { add(6); } → 6, luego { add(8); } → 8
        *       Constructor (regla 4): add(5); → 5
        * Termina el new, se reanuda la secuencia estática donde se quedó:
        *       static{ add(9); } → imprime 9
        *       static{ add(100); } → imprime 100 
        */

        //TENER MUCHO CUIDADO.
    }



}
