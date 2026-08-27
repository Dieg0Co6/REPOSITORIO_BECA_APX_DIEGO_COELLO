package main.java.com.app.day_six.Understanding_an_ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Understanding_an_ArrayList {
    public static void main(String[] args) {
        //Un arreglo tiene una gran desventaja: tienes que saber cuántos elementos habrá en el arreglo cuando lo creas
        //Ante eso, la solución es un ArrayList

        //Al igual que un StringBuilder, un ArrayList puede cambiar de tamaño en tiempo de ejecución según sea necesario.
        //Al igual que un arreglo, un ArrayList es una secuencia ordenada que permite duplicados.

        //ArrayList también necesita que se importe. Se puede importar de estas dos formas:

        /* import java.util.*          // import whole package including ArrayList
        import java.util.ArrayList;    // import just ArrayList */

        Understanding_an_ArrayList understanding_an_ArrayList = new Understanding_an_ArrayList();
        understanding_an_ArrayList.Creating_an_ArrayList();
        understanding_an_ArrayList.Using_an_ArrayList();
        understanding_an_ArrayList.Wrapper_Classes();
        understanding_an_ArrayList.Autoboxing();
        understanding_an_ArrayList.Converting_Between_array_and_List();
        understanding_an_ArrayList.Sorting();
    }

    public void Creating_an_ArrayList(){
        //Al igual que con StringBuilder, hay tres formas de crear un ArrayList:

        ArrayList list1 = new ArrayList();          //Crea un ArrayList pero sin llenar ninguna posición
        ArrayList list2 = new ArrayList(10);    //Indicandole la cantidad de elementos
        ArrayList list3 = new ArrayList(list2);    //genera una copia de otro ArrayList
        
        //El último ejemplo le dice a Java que queremos hacer una copia de otro ArrayList.
        //Copiamos tanto el tamaño como el contenido de ese ArrayList.

        //LOS EJEMPLOS ANTERIORES FUERON LA FORMA ANTIGUA DE DECLARAR LOS ARRAYLIST. PERO AHORA SE PUEDEN DECLARAR
        //ESPECIFICANDOLE EL TIPO DE CLASE QUE CONTENDRÁ EL ARRAYLIST.
        
        ArrayList<String> list4 = new ArrayList<String>();
        ArrayList<String> list5 = new ArrayList<>();

        //Java ahora te permite indicarle al compilador cuál sería el tipo, especificándolo entre < y >.
        //Incluso puedes omitir ese tipo del lado derecho. Sin embargo, los < y > aún son necesarios.
        //Esto se llama el operador diamante

        //ArrayList implementa una interfaz llamada List. En otras palabras, un ArrayList es un List.
        //Eso quiere decir que puedes almacenar un Arraylist en una variable de referencia de tipo List, pero no al revés.
        //Ya que List es una interfaz y las interfaces no se instancian.

        List<String> list6 = new ArrayList<>();     //ESTO SI SE PUEDE HACER, ES TOTALMENTE VÁLIDO.
        ArrayList<String> list7 = new List<>(); // NO COMPILA PORQUE LIST ES UNA INTERFAZ.

    }

    public void Using_an_ArrayList(){
        //A continuación se verán los principales métodos de la clase Arraylist.
        //E se usa por convención en genéricos para significar “cualquier clase que este arreglo pueda contener”.
        //Si no especificaste un tipo al crear el ArrayList, E significa Object.
        //De lo contrario, significa la clase que pusiste entre < y >.

        add();
        remove();
        set();
        isEmpty_and_size();
        clear();
        contains();
        equals();
    }

    private void add(){
        //Los métodos add() insertan un nuevo valor en el ArrayList.
        //las firmas son las siguientes:

        /* boolean add(E element)
        void add(int index, E element) */

        ArrayList list = new ArrayList();       //Se declara el arraylist
        list.add("hawk");          // [hawk]    //se añade el primer elemento
        list.add(Boolean.TRUE);    // [hawk, true]
        System.out.println(list);  // [hawk, true]

        //add() hace exactamente lo que esperamos: almacena el String en el ArrayList que ya no está vacío.
        //Esto está bien porque no especificamos un tipo para el ArrayList; por lo tanto, el tipo es Object,
        //que incluye todo excepto los primitivos.

        //Ahora, usemos generics para decirle al compilador que solo queremos permitir objetos String en nuestro ArrayList:

        ArrayList<String> safer = new ArrayList<String>();  //o también new ArrayList<>()
        safer.add("sparrow");       //Se añade el primer elemento de tipo String
        safer.add(Boolean.TRUE);    // NO COMPILA PORQUE ESPERA QUE LE AGREGUES UN ELEMENTO DE TIPO STRING.

        //Esta vez, el compilador sabe que solo se permiten objetos String y previene el intento de agregar un booleano

        List<String> birds = new ArrayList<>(); //Se declara el arraylist
        birds.add("hawk");            // [hawk]     //Se añade el primer elemento de tipo String
        birds.add(1, "robin");        // [hawk, robin]      //Se indica que se añadirá robin en el indice 1
        birds.add(0, "blue jay"); // [blue jay, hawk, robin]  //Se indica que se añadirá blue jay en el indice 0
                                                //y el resto se desplazan
        birds.add(1, "cardinal");     // [blue jay, cardinal, hawk, robin] //Se indica que ahora el indice 1 tendrá el
                                                    // valor de cardinal y  hawk, robin se desplazan
        System.out.println(birds);    // [blue jay, cardinal, hawk, robin]
    }

    private void remove(){
        //Los métodos remove() eliminan el primer valor que coincide en el ArrayList o
        //eliminan el elemento en un índice específico.Sus firmas son las siguientes:

        /* boolean remove(Object object)
        E remove(int index) */

        List<String> birds = new ArrayList<>();     //Se declara el ArrayList
        birds.add("hawk");     // [hawk]
        birds.add("hawk");     // [hawk, hawk]
        System.out.println(birds.remove("cardinal")); // prints false //Imprime falso, ya que no hay cardinal, entonces no se elimina
        System.out.println(birds.remove("hawk")); // prints true  //Imprime true y eliminó el primer elemento que encontró. posición 0
        System.out.println(birds.remove(0)); // prints hawk //Aquí se le pasa el indice, entonces retorna el objeto que se eliminó
        System.out.println(birds);     // []

        //Como llamar a remove() con un int usa el índice, un índice que no exista lanzará una excepción.
    }

    private void set(){
        //El método set() cambia uno de los elementos del ArrayList sin cambiar el tamaño. 
        //Su firma es la siguiente:

        /* E set(int index, E newElement) */

        //El tipo de retorno E es el elemento que fue reemplazado.

        List<String> birds = new ArrayList<>();
        birds.add("hawk");                    // [hawk]
        System.out.println(birds.size());     // 1
        birds.set(0, "robin");         // [hawk]     //Se pasa como parametro el indice y el nuevo valor
        System.out.println(birds.size());     // 1
        birds.set(1, "robin");        // IndexOutOfBoundsException

    }

    private void isEmpty_and_size(){
        //Los métodos isEmpty() y size() miran cuántas de las ranuras están en uso. 
        //Sus firmas son las siguientes:

        /* boolean isEmpty()
        int size() */

        System.out.println(birds.isEmpty());     // true    //Está vacío, entonces verdadero
        System.out.println(birds.size());     // 0
        birds.add("hawk");                    // [hawk]
        birds.add("hawk");                    // [hawk, hawk]
        System.out.println(birds.isEmpty());     // false
        System.out.println(birds.size());     // 2

        //SOLO TOMAN LOS ESPACIOS QUE SE ENCUENTRAN OCUPADOS POR ELEMENTOS.
    }

    private void clear(){
        //El método clear() ofrece una manera fácil de eliminar todos los elementos del ArrayList.
        //La firma del método es la siguiente:

        //void clear()

        List<String> birds = new ArrayList<>();
        birds.add("hawk");                    // [hawk]
        birds.add("hawk");                    // [hawk, hawk]
        System.out.println(birds.isEmpty());     // false
        System.out.println(birds.size());     // 2
        birds.clear();                         // []
        System.out.println(birds.isEmpty());     // true
        System.out.println(birds.size());     // 0
    }

    private void contains(){
        //El método contains() verifica si un cierto valor está en el ArrayList.
        //La firma del método es la siguiente:

        //boolean contains(Object object)

        List<String> birds = new ArrayList<>();
        birds.add("hawk");                         // [hawk]
        System.out.println(birds.contains("hawk")); // true
        System.out.println(birds.contains("robin")); // false

        //Este método llama a equals() en cada elemento del ArrayList para ver si hay coincidencias.
        //Como String implementa equals(), esto funciona bastante bien.
    }

    private void equals(){
        //ArrayList tiene una implementación personalizada de equals() para que puedas comparar dos listas
        //y ver si contienen los mismos elementos en el mismo orden.

        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();
        System.out.println(one.equals(two));      // true   //sale verdadero porque ambos están vacíos
        one.add("a");                         // [a]
        System.out.println(one.equals(two));     // false
        two.add("a");                         // [a]
        System.out.println(one.equals(two));     // true
        one.add("b");                         // [a,b]
        two.add(0, "b");          // [b,a]
        System.out.println(one.equals(two));     // false   //sale falso, porque EL ORDEN IMPORTA
    }

    public void Wrapper_Classes(){
        //Hasta el momento solo hemos añadido String en los Arraylist.
        //Que pasa si queremos añadir tipos primitivos?
        //Cada tipo primitivo tiene una clase envoltorio, que es un tipo de objeto que corresponde al primitivo.
        //Para añadir tipos primitivos tenes que usar esas clases envoltorio, o WRAPPER CLASSES.

        /* Primitive type               Wrapper class                   Example of constructing
        *    boolean                     Boolean                         new Boolean(true)
        *    byte                        Byte                            new Byte((byte) 1)
        *    short                       Short                           new Short((short) 1)
        *    int                         Integer                         new Integer(1)
        *    long                        Long                            new Long(1)
        *    float                       Float                           new Float(1.0)
        *    double                      Double                          new Double(1.0)
        *    char                        Character                       new Character('c')
        */

        //Las clases envolventes también tienen un método que convierte de nuevo a un tipo primitivo.
        //También hay métodos para convertir un String a un tipo primitivo o a una clase envolvente.

        //Sí necesitas conocer estos métodos. Los métodos parse, como parseInt(), devuelven un primitivo,
        //y el método valueOf() devuelve una clase envolvente.
        //Esto es fácil de recordar porque el nombre del primitivo devuelto está en el nombre del método. EJMPLO:

        int primitive = Integer.parseInt("123");    //el parseInt hace que convierta un String a un tipo primitvo int.
        Integer wrapper = Integer.valueOf("123");   //el valueOf hace que convierta un String a una clase envolvente, en este caso, Integer.

        //Si el String que se pasa no es válido para el tipo dado, Java lanza una excepción.EJM:

        int bad1 = Integer.parseInt("a");               // throws NumberFormatException     //Sale error porque le está pasando un letra
        Integer bad2 = Integer.valueOf("123.45");       // throws NumberFormatException     //Sale error porque le está pasando un String con formato Double a un Integer

        //TENER EN CUENTA QUE:
        //la clase Character no participa en los métodos parse/valueOf.
        //Dado que un String está compuesto de caracteres, simplemente puedes usar charAt() normalmente.

        /* Wrapper class            Converting String to primitive                  Converting String to wrapper class          
        *    Boolean                  Boolean.parseBoolean("true");                  Boolean.valueOf("TRUE");
        *    Byte                     Byte.parseByte("1");                           Byte.valueOf("2");
        *    Short                    Short.parseShort("1");                         Short.valueOf("2");
        *    Integer                  Integer.parseInt("1");                         Integer.valueOf("2");
        *    Long                     Long.parseLong("1");                           Long.valueOf("2");
        *    Float                    Float.parseFloat("1");                         Float.valueOf("2.2");
        *    Double                   Double.parseDouble("1");                       Double.valueOf("2.2");
        *    Character                None                                           None
        */
    }

    public void Autoboxing(){
        //Desde Java 5, puedes simplemente escribir el valor primitivo y Java lo convertirá a la clase envoltorio
        //correspondiente por ti. Esto se llama autoboxing.Ejm:

        List<Double> weights = new ArrayList<>();
        weights.add(50.5);   // [50.5]  // En esta línea se convierte automáticamente el valor primitivo double en un objeto Double y lo agrega a la lista.
        weights.add(new Double(60)); // [50.5, 60.0] //En esta línea se muestra que todavía puedes escribir el código de la manera larga y pasar un objeto wrapper.
        weights.remove(50.5);    // [60.0]   //convierte automáticamente en el objeto wrapper y lo pasa a remove()
        double first = weights.get(0);     // 60.0  //recupera el Double y lo convierte de nuevo en un primitivo double.

        //SI SE DESEMPAQUETA UN NULL PASA ESTO:
        List<Integer> heights = new ArrayList<>();
        heights.add(null);
        int h = heights.get(0);          // NullPointerException    //NOS LANZA UNA EXCEPTION

        //Como llamar a cualquier método sobre null da una NullPointerException, eso es exactamente lo que obtenemos.
        //TENER CUIDADO cuando veas NULL en relación con el autoboxing.

        //TAMBIEN TENER CUIDADO CUANDO SE AUTOBOXEE EN INTEGER.
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.remove(1);
        System.out.println(numbers);    //RETORNA 1, YA QUE LO QUE SE ELIMINÓ ES LA POSICIÓN O INDICE 1, ES DECIR, EL SEGUNDO ELEMENTO

        //Si quieres eliminar el 2, puedes escribir numbers.remove(new Integer(2)) para forzar el uso de la clase envoltorio.
    }
    
    public void Converting_Between_array_and_List(){
        //LOS ARRAYLIST SE PUEDEN CONVERTIR A ARRAY Y VICEVERSA.

        //PARA CONVERTIR DE ARRAYLIST A ARRAY, SE HACE LO SIGUIENTE:
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");
        Object[] objectArray = list.toArray();      //METODO QUE CONVIERTE A ARRAY //SE LE ASIGNA A UNA VARIABLE ARRAY DE TIPO OBJECT
        System.out.println(objectArray.length);     // 2
        String[] stringArray = list.toArray(new String[0]);     //SE LE ASIGNA A UNA VARIABLE ARRAY DE TIPO STRING
        System.out.println(stringArray.length);     // 2

        //Un ArrayList sabe cómo convertirse a un array. El único problema es que por defecto crea un array de la clase Object.
        //new String[0] = "quiero un String[], no me importa el tamaño, Java pon el tamaño correcto"


        //Convertir de un array a una List es más interesante.
        //El array original y la List creada a partir de él están vinculados.
        //Cuando se hace un cambio en uno, está disponible en el otro.
        //Es una lista de tamaño fijo y también se conoce como backed List porque el array cambia con ella. 

        String[] array = { "hawk", "robin" };     // [hawk, robin]
        List<String> list2 = Arrays.asList(array); //devuelve una lista de tamaño fijo //convierte el arreglo en una Lista.
        System.out.println(list2.size());     // 2
        list2.set(1, "test");          // [hawk, test]      //Setiamos tanto la lista como el arreglo
        array[0] = "new";    // [new, test]     //ACÁ TAMBIÉR CAMBIA TANTO EL ARREGLO COMO LA LISTA
        for (String b : array) System.out.print(b + " "); // new test
        list2.remove(1);     // throws UnsupportedOperation Exception   

        //TEN EN CUENTA QUE lista2 NO ES UN ARRAYLIST COMO HEMOS VISTO ANTERIORMENTE.
        //Es una versión respaldada de TAMAÑO FIJO de una Lista.
        //el set() actualiza tanto el arreglo como la lista porque apuntan al mismo almacenamiento de datos.
        //En la ultima linea del ejemplo lanza una excepción porque NO SE NOS PERMITE CAMBIAR EL TAMAÑO DE LA LISTA.

        List<String> list3 = Arrays.asList("one", "two");
        //asList() acepta varargs, lo que te permite pasar un arreglo o simplemente escribir los valores de String.
        //Esto es útil al hacer pruebas porque puedes crear y llenar fácilmente una Lista en una sola línea.
    }

    public void Sorting(){
        //Ordenar un ArrayList es muy similar a ordenar un arreglo. Solo que usas una clase auxiliar diferente:
        List<Integer> numbers = new ArrayList<>();
        numbers.add(99);
        numbers.add(5);
        numbers.add(81);
        Collections.sort(numbers);  //Nos apoyamos de la clase Collections para utilizar el método sort()
        System.out.println(numbers); //[5, 81, 99]

        //Y CUANDO SON STRINGS, TAMBIÉN SE ORDENAN DE FORMA ALFABÉTICA - lexicográfica
    }
}
