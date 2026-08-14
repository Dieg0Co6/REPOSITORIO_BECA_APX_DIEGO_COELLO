package main.java.com.app.Understanding_Java_Statements;

import javax.xml.crypto.Data;

public class Understanding_Java_Statements {
    public static void main(String[] args) {
        Understanding_Java_Statements understanding_Java_Statements = new Understanding_Java_Statements();
        understanding_Java_Statements.The_while_Statement();
        understanding_Java_Statements.The_for_Statement();
        understanding_Java_Statements.The_for_each_Statement();
    }


    //LA DECLARACIÓN WHILE
    public void The_while_Statement(){
        // TENER EN CUENTA QUE: En la declaración WHILE - THEN, la expresión booleana se evalúa antes de cada iteración del bucle
        // y se termina si la evaluación devuelve false.

               // Se declara e inicializa la variable 
        eatCheese(8);

        // TENER CUIDADO CON LOS BUCLES INFINITOS. EJM
        int x = 2;
        int y = 5;
        while(x < 10)   //En este caso, siempre va cumplir que la variable x con valor 2 sea mayor que 10, entonces
        y++;            //se formará un bucle infinito haciendo que y siga aumentando su valor.
        
        //POR ESO SE TIENE QUE EVALUAR SIEMPRE QUE EL BUCLE EVENTUALMENTE TERMINE BAJE CIERTA CONDICION
    }

    public void eatCheese(int bitesOfCheese) {
        int roomInBelly = 5; 
        while (bitesOfCheese > 0 && roomInBelly > 0) { //SE EJECUTA EL SIGUIENTE CODIGO SI CUMPLE ESA FUNCION
            bitesOfCheese--;
            roomInBelly--;
        }//TERMINA DE EJECUTARSE LAS INTRUCCIONES Y VUELVE A REVISAR LA EXPRESIÓN BOOLEANA DEL WHILE
        System.out.println(bitesOfCheese+" pieces of cheese left"); //Si bitesOfCheese fuera inicializado con 8, saldría del bucle
                                                                    // con valor de 3.
    }

    //LA DECLARACIÓN DO-WHILE
    public void The_do_while_Statement(){
        // LA PRINCIPAL DIFERENCIA con el bucle while es que un bucle do-while garantiza que la sentencia o el bloque se ejecutará
        // al menos una vez.

        //Un bucle do-while coloca a propósito la sentencia o el bloque de sentencias antes de la expresión condicional.

        int x = 0;
        do {
            x++;
        } while(false);
        System.out.println(x);  // Imprime 1, ya que primero ejecuta una vez el codigo de las instrucciones y luego revisa la
                                //expresión booleana, si la expresión da true, entonces repite, si da false, sale del bucle.

        //CUALQUIER BUCLE WHILE PUEDE CONVERTIRSE EN UN BUCLE DO-WHILE Y VICEVERSA.EJM:
        while(x > 10) {
            x--;
        }

        if(x > 10) {
            do {
                x--;
            } while(x > 10);
        }

        //son funcionalmente equivalentes, aunque el primero es mucho más sencillo de leer.

        if(x > 10) {
            do {
                x--;
            } while(x > 10);
        } else {
            x++;
        }
    }

    //LA DECLARACIÓN FOR
    public void The_for_Statement(){
        //Hay dos tipos de declaraciones for, la declaración for básica, y luego esté el bucle for-each.
        
        //El bucle for básico tiene una expresión booleana y un bloque de codigo como el while y el do-while
        //pero además cuenta con una sección de inicialización y una sentencia de actualización. 

        /*for (inicialización, expresión booleana, sentencia de actualizacion){} */

        /*  TENER EN CUENTA QUE:
            * Cada sección está separada por un punto y coma.
            * Las secciones de inicialización y actualización pueden contener múltiples declaraciones, separadas por comas.
            * Las variables declaradas en el bloque de inicialización solo son accesibles dentro del bucle for.
            * Ten cuidado con cualquier pregunta de examen en la que una variable declarada dentro del bloque de inicialización
            * de un bucle for esté disponible fuera del bucle. 
        */

        //Se está inicializando la variable i con valor 0, así mismo se establece la condicion que i sea menor a 10 y va ir aumentando
        //en 1 su valor por cada vez que se ejecuta el cuerpo del bucle for.
        for(int i = 0; i < 10; i++) {  
            System.out.print(i + " ");
        }

        // La variable local i se inicializa primero en 0. La variable i solo está disponible durante la duración del bucle y
        // no se puede usar fuera del bucle una vez que este ha terminado. La condición booleana se evalúa
        // en cada iteración del bucle antes de que este se ejecute. Como devuelve true, el bucle se ejecuta y muestra el 0 seguido
        // de un espacio. A continuación, el bucle ejecuta la sección de actualización, que en este caso aumenta el valor de i a 1.
        // Luego, el bucle evalúa la expresión booleana por segunda vez, y el proceso se repite varias veces.

        Infinite_Loop_For();
        Adding_Multiple_Terms_to_the_for_Statement();
        Redeclaring_a_Variable_in_the_Initialization_Block();
        Using_Incompatible_Data_Types_in_the_Initialization_Block();
    }

    //BUCLE FOR INFINITO
    private void Infinite_Loop_For(){
        //TENER CUIDADO EN LOS EXAMENES, QUE AVECES TAMBIÉN JUEGAN CON LAS SENTENCIAS FOR.
        // BUCLE INFINITO FOR. EJM:
        //AUNQUE PARECIERA QUE NO COMPILARÁ O QUE SALDRÁ UN ERROR, LA VERDAD ES QUE NO, SI COMPILA Y GENERA UN BUCLE INFINITO

        for( ; ; ) {
            System.out.println("Hello World");
        }

        /* 
        * Este ejemplo refuerza el hecho de que los componentes del bucle for son opcionales.
        * TENER EN CUENTA QUE:los puntos y coma que separan las tres secciones son obligatorios,
        * ya que for( ; ) y for( ) no se compilarán.
        */
    }

    //AGREGAR MULTIPLES TERMINOS A LA SENTENCIA FOR
    private void Adding_Multiple_Terms_to_the_for_Statement(){

        //Como se mencionó, se pueden inicializar varias variables, separadas de comas y de un mismo tipo de dato
        //Así también se pueden colocar expresiones booleanas complejas y también colocar varias sentencias de actualización
        //separadas siempre por comas.
        int x = 0;
        for(long y = 0, z = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");
        }
        System.out.print(x);

        //Primero se inicializaron las variables y y z con 0 y 4 respectivamente.
        //En las expresión booleana tiene dos condiciones, ejecutar el codigo solo si x es menor que 5 Y si y es menor que 10
        //En la sección de actualización se incrementa el valor de x y y en 1.

        //El bloque de inicialización, la expresión booleana y las instrucciones de actualización pueden incluir variables extra
        //que no tengan que referirse entre sí. Por ejemplo, z se define en el bloque de inicialización y nunca se usa.
    }

    //VOLVER A DECLARAR UNA VARIABLE EN EL BLOQUE DE INICIALIZACIÓN
    private void Redeclaring_a_Variable_in_the_Initialization_Block(){
        
        // ESTO NO COMPILARÁ, PORQUE YA INICIALIZÓ LA VARIABLE ANTES QUE SE VUELVA A INICIALIZAR EN EL BUCLE FOR
        int x = 0;
        for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) {   //NO COMPILA POR VARIABLE DUPLICADA
        System.out.print(x + " ");
        }

        //PERO SE SOLUCIONA DE ESTA MANERA, EN LA QUE YA NO SE DECLARA, SINO SOLAMENTE SE ASIGNA UN NUEVO VALOR A x y y

        int x1 = 0;
        long y1 = 10;
        for(y1 = 0, x1 = 4; x1 < 5 && y < 10; x1++, y1++) {
        System.out.print(x1 + " ");
        }
    }

    //USANDO TIPOS DE DATOS INCOMPATIBLES EN EL BLOQUE DE INICIALIZACION
    private void  Using_Incompatible_Data_Types_in_the_Initialization_Block(){

        //TENGO EL SIGUIENTE EJEMPLO:
        //NO COMPILARÁ PORQUE TODAS LAS VARIABLES DEL BLOQUE DE INICIALIZACIÓN DEBEN SER DEL MIMSO TIPO.
        //Como vemos y es de tipo long, y x de tipo int
        for(long y = 0, int x = 4; x < 5 && y<10; x++, y++) {   // NO COMPILARÁ
            System.out.print(x + " ");
        }
    }

    private void Using_Loop_Variables_Outside_the_Loop(){
        //EJMPLO
        // NO COMPILARÁ PORQUE X SOLAMENTE SE DECLARA E INICIALIZA EN EL BUCLE FOR, Y SU ALCANCE SOLO SERÁ EN EL BUCLE.
        // FUERA DEL BUCLE NO TIENE ALCANCE. EN LA LINEA 434 NO RECONOCE A LA VARIABLE X.
        for(long y = 0, x = 4; x < 5 && y < 10; x++, y++) {
            System.out.print(y + " ");
        }
        System.out.print(x);  // NO COMPILARÁ
    }

    public void The_for_each_Statement(){

        //ESTE ES UN TIPO FOR MEJORADO, DISEÑADO ESPECIFICAMENTE PARA ITERAR SOBRE ARRAYS Y OBJETOS COLLECTION.
        //ESTE FOR EACH CUENTA CON UNA EXPRESIÓN EN PARENTESIS EN LA CUAL SE DEFINE EL TIPO DE DATO LUEGO EL NOMBRE DE UNA INSTANCIA
        //SEGUIDO DE DOS PUNTOS (:) Y EL COLLECTION ITERABLE DE OBJETOS.
        // for ( Integer element : ListaNumerosPrimos){
        //}


        // Se compone de una sección de inicialización y un objeto sobre el que se va a iterar.
        // El lado derecho de la instrucción for-each debe ser un arreglo de Java incorporado o una coleccion de Java.
        // El lado izquierdo debe incluir la declaración de una instancia de una variable, cuyo tipo coincida con el
        // tipo de un miembro del arreglo o colección del lado derecho de la instrucción.
        // En cada iteración del bucle, a la variable nombrada del lado izquierdo de la instrucción se le asigna un nuevo valor
        // del arreglo o colección del lado derecho de la instrucción.

        //Para el examen los únicos miembros del framework de Collections que necesitas conocer son List y ArrayList.

        final String[] names = new String[3];       //Aquí se crea un array con espacios para 3 elementos con el nombre de names.
        names[0] = "Lisa";              //primer elemento del arreglo
        names[1] = "Kevin";             //segundo elemento del arreglo
        names[2] = "Roger";             //tercer elemento del arreglo
        //En este for-each se van a iterar cada elemento del arreglo, por cada iteración, name va cambiado su valor.
        for(String name : names) {
            System.out.print(name + ", ");  //Imprimirá: Lisa, Kevin, Roger 
        }

        //OTRO EJEMPLO:

        //ACÁ SE CREA UNA LISTA DE TIPO ARRRAYLIST, QUE CONTIENE ELEMENTOS DE TIPO STRING, LA LISTA SE LLAMA VALUES
        java.util.List<String> values = new java.util.ArrayList<String>();
        values.add("Lisa");         //primer elemento de la lista
        values.add("Kevin");        //segundo elemento de la lista
        values.add("Roger");        //tercer elemento de la lista
        //En este for-each se van a iterar cada elemento de la lista, por cada iteración, value va cambiando su valor
        for(String value : values) {
            System.out.print(value + ", "); //imprimirá Lisa, Kevin, Roger
        }

        //IMPORTANTE: En un for-each asegurarse de que el lado derecho sea un array u objeto Iterable y que el lado
        // izquierdo tenga un tipo que coincida. EJM:

        String names1 = "Lisa";     //El tipo de dato String no es un objeto iterable
        // NO COMPILARÁ PORQUE NAMES1 NO ES UN OBJETO ITERABLE NI UN ARREGLO
        //EN TODO CASO SERÍA MEJOR PASAR SUS CARACTERES A UN ARREGLO, CON .ToCharArray()
        for(String name : names1) {   
            System.out.print(name + " ");
        }

        String[] names2 = new String[3];     //Aquí se declara un arreglo con elementos String, de tamañao 3
        //NO COMPILARÁ PORQUE NO TIENE ELEMENTOS, EL ARREGLA TIENE ELEMENTOS NULOS. Y AUNQUE SE AÑADA ELEMENTOS
        //NO COMPILARÁ YA QUE LA INSTANCIA TIENE TIPO DE DATO INT, Y EL ARREGLO CONTIENE ELEMENTOS DE TIPO STRING
        for(int name : names2) {  // NO COMPILARÁ
            System.out.print(name + " ");
        }


        //A TENER CONOCIMIENTO QUE: Durante la compilación Java convierte el bucle for-each en un bucle for estándar.
        // EJMPLO: LOS SIGUIENTES EJEMPLOS SON EQUIVALENTES

        // AMBOS ITERAN CADA ELEMENTO STRING DEL ARREGLO
        for(String name : names) {
            System.out.print(name + ", ");
        }

        for(int i=0; i < names.length; i++) {
            String name = names[i];
            System.out.print(name + ", ");
        }

        // OTRO EJEMPLO PERO CON OBJETOS ITERABLES.
        for(int value : values) {
            System.out.print(value + ", ");
        }

        //no hay una instrucción de actualización, ya que no es necesaria al usar la clase java.util.Iterator.
        for(java.util.Iterator<Integer> i = values.iterator(); i.hasNext(); ) { 
            int value = i.next();
            System.out.print(value + ", ");
        }

        //IGUAL SURGE EL PEQUEÑO PROBLEMA DE QUE AL ULTIMO APARECE LA COMA, SI QUISIERAMOS IMPRIMIR SOLO LA COMA
        //ENTRE LOS NOMBRES, PODRÍAMOS CONVERTIR EL EJEMPLO EN UN BUCLE FOR ESTANDAR

        java.util.List<String> names3 = new java.util.ArrayList<String>(); //Se crea la lista con elementos String names3
        //Se le agregan 3 elementos
        names3.add("Lisa");
        names3.add("Kevin");
        names3.add("Roger");
        //se inicializa la variable i con 0, y va ejecutar este bucle hasta que sea menor al tamaño de la lista, aumentando i en 1
        //en cada iteración
        for(int i=0; i<names3.size(); i++) {
            String name = names3.get(i);    // se le asigna a name el valor del elemento por la posición en la que se encuentra
            if(i>0) {   //Si i es mayor que 0 entonces colocar una coma
                System.out.print(", ");
            }
            System.out.print(name); //imprime el nombre
        }

        //También es común usar un bucle for estándar en lugar de un bucle for-each si se comparan varios elementos en un bucle
        //dentro de una sola iteración, como en el siguiente ejemplo

        int[] values1 = new int[3];     //Se declara un arreglo con elementos de tipo int, de tamano 3.
        //Se agregan los elementos
        values1[0] = 10;
        values1[1] = new Integer(5);        //Aquí se añade un elemento de tipo Integer con valor 5
        values1[2] = 15;
        //Inicializa en 1, ya que las posicion -1 no existe, sino saldría error
        for(int i=1; i<values1.length; i++) {
            System.out.print(values1[i]-values1[i-1]);  //Imprime -5 10
        }
    }

}
