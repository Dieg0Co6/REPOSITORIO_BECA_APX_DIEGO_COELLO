package main.java.com.app.day_five.Understanding_Java_Arrays;

import java.util.Arrays;

public class Understanding_Java_Arrays {

    public static void main(String[] args) {
        //Un arreglo es un área de memoria en el heap con espacio para un número designado de elementos.
        //Un String se implementa como un arreglo con algunos métodos que podrías querer usar cuando trabajas
        //específicamente con caracteres.

        //Un StringBuilder se implementa como un arreglo donde el objeto arreglo se reemplaza por un nuevo objeto
        //arreglo más grande cuando se queda sin espacio para almacenar todos los caracteres. 

        char[] letters;

        
        //char es un tipo primitivo. Pero char es lo que va dentro del arreglo y no el tipo del arreglo en sí.
        //El arreglo en sí es de tipo char[]. Puedes leer mentalmente los corchetes ([]) como “arreglo”.
        //En otras palabras, un arreglo es una lista ordenada. Puede contener duplicados.
        Understanding_Java_Arrays understanding_Java_Arrays = new Understanding_Java_Arrays();
        understanding_Java_Arrays.Creating_an_Array_of_primitives();
        understanding_Java_Arrays.Creating_an_Array_with_Reference_Variables();
        understanding_Java_Arrays.Using_an_Array();
        understanding_Java_Arrays.Sorting();
        understanding_Java_Arrays.Searching();
        understanding_Java_Arrays.Varargs();
        
    }

    public void Creating_an_Array_of_primitives(){
        //LA FORMA MÁS COMUN DE ESCRIBIR UN ARREGLO
        
        int[] numbers1 = new int[3];
        //Especifica el tipo del arreglo (int) y el tamaño (3). Los corchetes te dicen que esto es un arreglo.
        //Los índices empiezan en 0 y van subiendo, igual que con un String.

        //Un arreglo vacío de tipo int tiene los elementos con valor 0

        //Otra forma es especificando los valores iniciales que va tener el arreglo. EJM:
        int[] numbers2 = new int[] {42, 55, 99};        //SE INICIALIZAN LOS ELEMENTOS SIEMPRE CON LLAVES
        //COMO UN ATAJO JAVA TE PERMITE HACER ESTO:
        int[] numbers3 = {42, 55, 99};


        //Lo siguientese llama un arreglo anónimo. Es anónimo porque no especificas el tipo ni el tamaño.
        //Finalmente, puedes escribir los [] antes o después del nombre, y agregar un espacio es opcional.
        //Esto significa que las cuatro declaraciones hacen exactamente lo mismo:

        int[] numAnimals;
        int [] numAnimals2;
        int numAnimals3[];
        int numAnimals4 [];

        //La mayoría de la gente usa el primero. Sin embargo, podrías ver cualquiera de estos en el examen,
        //así que acostúmbrate a ver los corchetes en lugares extraños.

        int[] ids, types; //Este crea dos arreglos con elementos de tipo int

        int ids1[], types1; //Este crea un arreglo de tipo int y el types1 es solamente una variable de tipo int
    }

    public void Creating_an_Array_with_Reference_Variables(){

        public class ArrayType {
            public static void main(String args[]) {
                String [] bugs = { "cricket", "beetle", "ladybug" };    //arreglo con elementos String
                String [] alias = bugs;     //referencia que apunta al mismo objeto de arreglo String
                System.out.println(bugs.equals(alias));     // true
                System.out.println(bugs.toString()); // [Ljava.lang.String;@160bc7c0

                //Podemos llamar a equals() porque un arreglo es un objeto.
                //Devuelve true debido a la igualdad de referencia.
                //El método equals() en los arreglos no revisa los elementos del arreglo.
                //int es un primitivo; int[] es un objeto

                //[L significa que es un arreglo, java.lang.String es el tipo de referencia, y 160bc7c0 es el código hash.

                //Java ha proporcionado un método que imprime un arreglo de manera bonita:
                //java.util.Arrays.toString(bugs) imprimiría [cricket, beetle, lady bug].
                //El examen tiende a no usarlo porque la mayoría de las preguntas sobre arreglos fueron escritas hace mucho tiempo.
                //De todos modos, este es un método útil cuando pruebas tu propio código.

                //TENER SIEMPRE EN CUENTA QUE:
                //el array NO contiene los objetos, contiene "flechas" hacia ellos

                /*
                * La casilla 0 del array no contiene el texto "cricket".
                * Contiene una flecha (referencia) que apunta hacia donde vive el objeto "cricket".
                *Lo mismo con la casilla 1 → apunta a "beetle".
                *Lo mismo con la casilla 2 → apunta a "ladybug".
                */

                class Names {
                    String names[];     //Este arreglo no apunta a nada y por ser variable de instancia, su valor es null
                }
                
                //y acá:
                class Names {
                    String names[] = new String[2]; //acá si apunta a arreglo de tipo String con dos referencias String.
                }

                //EJMPLO:
                String[] strings = { "stringValue" };
                Object[] objects = strings;
                String[] againStrings = (String[]) objects;
                againStrings[0] = new StringBuilder();   // NO COMPILA
                objects[0] = new StringBuilder();        // careful!
                
                //La línea 104 crea un arreglo del tipo String.
                //La línea 105 no requiere un casteo porque Object es un tipo más amplio que String.
                //En la línea 106, se necesita un casteo porque estamos pasando a un tipo más específico.
                //La línea 107 no compila porque un String[] solo permite objetos String y StringBuilder no es un String.

                //La línea 108 es donde esto se pone interesante. Desde el punto de vista del compilador, esto está bien.
                //Un objeto StringBuilder claramente puede ir en un Object[]. El problema es que en realidad no tenemos un Object[].
                //Tenemos un String[] al que se accede desde una variable Object[].
                //En tiempo de ejecución, el código lanza una ArrayStoreException.
                //No necesitas memorizar el nombre de esta excepción, pero sí necesitas saber que el código lanzará una excepción.
            }
        }
    }

    public void Using_an_Array(){
        //AHORA VAMOS A ACCEDER A UN ARREGLO.
        String[] mammals = {"monkey", "chimp", "donkey"};
        System.out.println(mammals.length);           // 3  // numero de elementos
        System.out.println(mammals[0]);               // monkey
        System.out.println(mammals[1]);               // chimp
        System.out.println(mammals[2]);               // donkey

        String[] birds = new String[6];
        System.out.println(birds.length);   //Esto imprime 6

        int[] numbers = new int[10];
        for (int i = 0; i < numbers.length; i++) 
            numbers[i] = i + 5;     //funciona perfecto

        numbers[10] = 3;        //aquí lanza exception porque no existe el indice 10
        numbers[numbers.length] = 5;        //también lanza exception, no existe ese indice, el ultimo es .length() -1 
        for (int i = 0; i <= numbers.length; i++) numbers[i] = i + 5;       //tmb lanza exception
    }

    public void Sorting(){
        //EXISTE EL METODO SORT() QUE ORDENA EL ARREGLO.

        //HAY UNA CLASE QUE PROPORCIONA JKAVA Y SE NECESITA IMPORTARTLO. EJM:
        /*  import java.util.*           
            import java.util.Arrays;  */    
        //EJEMPLO
        int[] numbers = { 6, 9, 1 };
        Arrays.sort(numbers);   //AQUÍ SE ORDENAN DE FORMA CRECIENTE: {1, 6, 9}
        for (int i = 0; i < numbers.length; i++) 
            System.out.print (numbers[i] +  " "); //1  6  9

        //SE TIENE QUE IMPRIMIR LOS ELEMENTOS DENTRO, SI QUEREMOS IMPRIMIR EL ARREGLO COMPLETO Y NO RECORRIENDOLO, NO VA DAR
        // ESTO:  el molesto hash de [I@2bd9c3e7.

        //OTRO EJEMPLO:
        String[] strings = { "10", "9", "100" };
        Arrays.sort(strings);   //AQUÍ SE ORDENAN 
        for (String string : strings)
            System.out.print(string + " ");     //Este código imprime 10 100 9.
        
        //El problema es que String se ordena en orden alfabético, y el 1 se ordena antes que el 9.
        //Los números se ordenan antes que las letras
        //las mayúsculas antes que las minúsculas.
    }

    public void Searching(){
        //También ofrece una forma conveniente de buscar, pero solo si el arreglo ya está ordenado.

        //EXISTEN REGLAS PARA LA BUSQUEDA BINARIA:

        /*
            * Elemento objetivo encontrado en arreglo ordenado    --->   Índice de coincidencia
            * Elemento objetivo no encontrado en arreglo ordenado --->   Valor negativo que muestra uno menor que el negativo 
            *                                                            del índice, donde se necesita insertar una coincidencia para
            *                                                            mantener el orden ordenado
            * Arreglo desordenado                                 --->   Una sorpresa: este resultado no es predecible
        */

        int[] numbers = {2,4,6,8};      //YA SE ENCUENTRA ORDENADO EL ARRAY
        System.out.println(Arrays.binarySearch(numbers, 2)); //POSICION: 0      PRIMER ELEMENTO
        System.out.println(Arrays.binarySearch(numbers, 4)); //POSICION: 1      SEGUNDO ELEMENTO    
        System.out.println(Arrays.binarySearch(numbers, 1)); // -1     NO ENCONTRADO, PERO INDICAD QUE DEBERÍA IR EN LA POSICION
                                                                            // 0 PARA MANTENER EL ORDEN. ENTONCES RESTA 1. 
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2   //3 DEBE IR EN POSICION 1, LO NIEGA Y LE RESTA UNO -> -2
        System.out.println(Arrays.binarySearch(numbers, 9)); // -5   //DEBE IR POSICION 4, NIEGA Y RESTA UNO -> -5           
    
        //OTRO EJEMPLO:
        int numbers2 = new int[] {3,2,1};
        System.out.println(Arrays.binarySearch(numbers2, 2)); //SALIDA IMPREDECIBLE
        System.out.println(Arrays.binarySearch(numbers2, 3)); //SALIDA IMPREDECIBLE
    }

    public void Varargs(){
        //CUANDO CREAMOS UN ARREGLO YA HEMOS VISTO COMO SE DECLARA.
        //PERO CUANDO SE PASA UN ARREGLO COMO PARAMETRO, EXISTEN 3 FORMAS. EJMPLO:
        
        /* 
        * public static void main(String[] args) //DECLARAR ARREGLO DE FORMA TRADICIONAL
        * public static void main(String args[]) //DECLARAR ARREGLO CON CORCHETES EN LA VARIABLE DE REFERENCIA
        * public static void main(String... args) // varargs 
        */

        //El tercer ejemplo utiliza una sintaxis llamada varargs (argumentos variables)
        //Se puede usar una variable definida con varargs como si fuera un arreglo normal
    }

}
