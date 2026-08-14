package main.java.com.app.Understanding_Java_Statements;

import javax.xml.crypto.Data;

public class Understanding_Java_Statements {
    public static void main(String[] args) {
        Understanding_Java_Statements understanding_Java_Statements = new Understanding_Java_Statements();
        understanding_Java_Statements.The_if_then_Statement();
        understanding_Java_Statements.The_if_then_else_Statement();
        understanding_Java_Statements.Ternary_Operator();
        understanding_Java_Statements.The_switch_Statement();
        understanding_Java_Statements.The_while_Statement();
        understanding_Java_Statements.The_for_Statement();
        understanding_Java_Statements.The_for_each_Statement();
    }

    public void The_if_then_Statement(){
        //La instrucción if-then logra que nuestra aplicación ejecute un bloque de código en particular si
        //y solo si una expresión booleana evalúa como verdadera en tiempo de ejecución.
        //EJMPLO:
        if(hourOfDay < 11)
            System.out.println("Good Morning");     //SOLO TE VA MOSTRAR EL MENSAJE CUANDO EL VALOR SEA MENOR A 11
                                                      // CUANDO SEA LAS 11 O MÁS, YA NO MOSTRARÁ ESE MENSAJE
        
        //SI SOLO TIENE UNA INSTRUCCIÓN SE PUEDE USAR SIN LLAVES, PERO SI SE QUIERE AÑADIR MÁS, SE DEBE USAR UN BLOQUE DE CODIGO CON LLAVES
        if(hourOfDay < 11) {
            System.out.println("Good Morning");
            morningGreetingCount++;
        }

        //SE DEBE TENER CUIDADO CON LAS LLAVES DE LOS BLOQUES DE SENTENCIAS IF, PORQUE AVECES LOS CREADORES DEL EXAMEN, SOLO USARÁN UNA
        //EXPRESIÓN EN EL IF, EN EL QUE NO COLOCARÁN LLAVES. EJMPLO

        if(hourOfDay < 11)
            System.out.println("Good Morning");
            morningGreetingCount++;

        //POR LA SANGRÍA, UNO PODRÍA PENSAR QUE ESTÁ EJECUTANDO LOS DE LA LINEA 28 Y 29, PERO SOLAMENTE EL IF SIN LLAVE TOMA
        //A UNA EXPRESIÓN, ES DECIR EL System.out.println("Good Morning");. EL morningGreetingCount++; ESTÁ FUERA DE LA SENTENCIA IF.
        //PARA JAVA, LAS TABULACIONES, SON SOLO ESPACIOS, NO ES COMO PYTHON.
    }

    public void The_if_then_else_Statement(){

        //En el caso de que se quiera ejecutar codigo luego que sean las 11 o más, se puede hacer así. pero no es lo más recomendable
        if(hourOfDay < 11) {
            System.out.println("Good Morning");
        }
        if(hourOfDay >= 11) {
            System.out.println("Good Afternoon");
        }
        //además se ve redundante, para ello, está la sentencia if-else. Ejmplo:

        if(hourOfDay < 11) { //Si son antes de las 11 ejecutar este codigo
            System.out.println("Good Morning");
        } else {             //Si son las 11 o más, entonces ejecutar este codigo
            System.out.println("Good Afternoon");
        }

        //Y de esta manera podemos añadir declaraciones if-then adicionales a un bloque else para llegar a un ejemplo más refinado:
        if(hourOfDay < 11) {    //Si son antes de las 11, ejecutar este codigo
            System.out.println("Good Morning");
        } else if(hourOfDay < 15) {     // si no, si son las 11 o más pero antes de las 15 horas, entonces ejecutar este codigo 
            System.out.println("Good Afternoon");
        } else {                        // Sino, entonces ejecutar este codigo (solo se ejecuta si son las 15 horas o más)
            System.out.println("Good Evening");
        }
        //En este ejemplo, el proceso de Java continuará su ejecución hasta que encuentre una sentencia if-then que se evalúe como verdadera.
        //Si ninguna de las dos primeras expresiones es verdadera, ejecutará el código final del bloque else.

        // DE IGUAL MANERA, HAY QUE TENER EN CUENTA QUE: Lo importante de las declaraciones if-then-else es que el orden importa. EJM:
        if(hourOfDay < 15) {    //Si son antes de las 15, entonces se va ejecutar este codigo
            System.out.println("Good Afternoon");
        } else if(hourOfDay < 11) { //Este codigo nunca se va ejecutar porque siempre se va ejecutar el codigo con expresion hourOfDay < 15
            System.out.println("Good Morning");  // codigo inaccesible
        } else {
            System.out.println("Good Evening");
        }


        //TAMBIÉN HAY QUE TENER CUIDADO CON LAS DECLARACIONES IF, YA QUE LOS CREADORES DEL EXAMEN, PUEDEN INTENTAR DESVIARNOS, DANDONOS
        //UNA DECLARACIÓN DEL IF QUE NO ES UNA EXPRESIÓN BOOLEANA.

        int x = 1;
        /* if(x) {  // NO COMPILARÁ, YA QUE X NO TIENE UN TIPO DE DATO BOOLEANO, SINO INT. TIENE QUE SER UNA EXPRESIÓN BOOLEANA.
        ...
        } */

        //ADEMÁS TAMBIÉN TENER EN CUENTA LOS OPERADORES DE ASIGNACIÓN =, QUE LOS USAN COMO OPERADORES DE IGUALDAD ==, !=
        //EN LAS SENTENCIAS IF THEN

        int x1 = 1;    //Es una variable de tipo int
        /* if(x1 = 5) {  //NO ESTÁ IGUALANDO, ESTÁ ASIGNANDO. NO COMPILARÁ
        ...
        } */
    }

    public void Ternary_Operator(){
        // El operador condicional (?) o conocido como operador ternario.
        //Es el único operador que toma tres operandos y tiene la forma: booleanExpression ? expression1 : expression2.
        //El primer operando debe ser obligatoriamente una expresión booleana, si es true, esa expresión, se retorna el valor de la
        //expression1, en el caso de que sea false, entonces se retorna el valor de la expression2.

        //Es una forma condensada de una sentencia if-then-else que devuelve un valor. Ejm:
        //Utilizando la sentencia if then else
        int y = 10;
        final int x;
        if(y > 5) {
        x = 2 * y;
        } else {
        x = 3 * y;
        }

        //utilizando operador ternario:
        int y1 = 10;
        int x1 = (y1 > 5) ? (2 * y1) : (3 * y1);  //ambos retornan lo mismo, pero el operador ternario es más compacto y ahorra lineas de codigo

        //No hay un requisito de que la segunda y tercera expresión en operaciones ternarias tengan los mismos tipos de datos, aunque esto puede
        //influir cuando se combina con el operador de asignación. Ejm:
        System.out.println((y > 5) ? 21 : "Zebra");     //Aquí funciona normal, ya que puede imprimir 21 o Zebra, 
        int animal = (y < 91) ? 9 : "Horse";            // Aquí no compila, ya que el valor de este operador ternario se va asignar a un
                                                        //tipo de dato int, por lo cual, saldrá error si hay la posibilidad de que retorne
                                                        //un string
        
        //Al igual que los operadores de logica con cortocircuitos, solo se evaluará en tiempo de ejecución una de las expresiones del lado
        //derecho del operador ternario. Ejmplo:

        int y3 = 1;         //Se asigna el valor de 1 a y3
        int z3 = 1;         //Se asigna el valor de 1 a z3
        final int x3 = y3<10 ? y3++ : z3++;     //y3 es menor que 10, entonces solo se ejecuta la primera expresión y3++, entonces x3 = 1 y y3 = 2
        System.out.println(y3+","+z3);          //y se va imprimir 2 y 1, ya que la expresión de z3++ nunca se ejecutó.
    
        //OTRO EJEMPLO:

        int y4 = 1;     //Se asigna el valor de 1 a y4
        int z4 = 1;     //Se asigna el valor de 1 a z4
        final int x4 = y4>=10 ? y4++ : z4++;    // y4 es menor que 10, entonces se ejecuta la segunda expresión z4++, entonces x4 = 1 y z4 =2
        System.out.println(y4+","+z4);          // el resultado daría 1 y 2, y4++ nunca se ejecutó
    
        //TENER CUIDADO QUE SÍ EXISTEN LOS OPERADORES TERNARIOS ANIDADOS. EJMPLOS:
        int x = 5;
        System.out.println(x > 2 ? x < 4 ? 10 : 8 : 7); //SERÍA COMO DECIR condicion1 ? (condicion2 ? valorA : valorB) : valorC
    
    }

    public void The_switch_Statement(){
        //Ahora continuamos con la sentencia SWITCH
        //es una estructura de toma de decisiones compleja en la que se evalúa un solo valor y el flujo se redirige a la
        //primera rama que coincida, conocida como sentencia case. Si no se encuentra ninguna sentencia case que coincida con el valor,
        //se llamará a una sentencia default opcional. Si no hay una opción default disponible, toda la sentencia switch se omitirá.

        //* Tipos de datos compatibles

       //la instrucción switch admite lo siguiente:
        /* 
        *int e Integer
        *byte y Byte
        *short y Short
        *char y Character
        *int e Integer
        *String
        *valores enum
        */

        //Tener en cuenta que boolean y long, y sus clases envolventes asociadas, no son compatibles con las sentencias switch.

        // * Valores constantes en tiempo de compilación

        /* Los valores en cada declaración case deben ser valores constantes en tiempo de compilación del mismo tipo de datos que el valor del switch.
        Esto significa que solo puedes usar:
        * literales, constantes enum o variables constantes finales del mismo tipo de datos.
        * Por constante final, nos referimos a que la variable debe estar marcada con el modificador final e inicializada
        * con un valor literal en la misma expresión en la que se declara. (final significa que esa variable no puede ser modificada una vez
        * asignado un valor)
        */
       //EJM:
        int dayOfWeek = 5;      //se asigna el valor de 5 a dayOfWeek
        switch(dayOfWeek) {
        default:
            System.out.println("Weekday");
            break;
        case 0:
            System.out.println("Sunday");
            break;
        case 6:
            System.out.println("Saturday");
            break;
        }

        //Como no hay el caso donde dayOfWeek sea 5, entonces se ejecuta el bloque de código por defecto (default) que es opcional
        // resultado: Weekday

        //LA DECLARACIÓN BREAK, lo que hacer se devuelva el control del flujo a la instrucción que la rodea, es decir, salir de switch.
        //Si no colocamos el break, va continuar con la siguiente instrucción de los case hasta que encuentre un break o termine la sentencia switch.
        // EJM:
        int dayOfWeek2 = 5;
        switch(dayOfWeek2) {
        case 0:
            System.out.println("Sunday");
        default:
            System.out.println("Weekday");
        case 6:
            System.out.println("Saturday");
            break;
        }

        //EN EL CODIGO ANTERIOR, SE EJECUTA EL DEFAULT, Y COMO NO TIENE BREAK, EJECUTA EL SIGUIENTE CASE, HASTA ENCONTRAR EL BREAK.
        //DANDO COMO RESULTADO:
        /* 
        *Weekday
        *Saturday
        */

        //El orden de las declaraciones case y default ahora es importante,
        //ya que colocar la declaración default al final del switch haría que solo se muestre una palabra.

        //En el caso de que dayOfWeek2 fuera 6, entonces se imprimiría:
        //Saturday

        //El bloque por defecto, solo se entra en él si no hay un valor de case que coincida con la declaración switch,
        //sin importar su posición dentro del switch.

        // Y si en el ultimo codigo dayOfWeek2 fuera 0, se imprimirían los tres enunciados:
        //Sunday
        //Weekday
        //Saturday


        //A los creadores de exámenes les gustan los ejemplos de switch que carecen de instrucciones break.
        //Al evaluar declaraciones switch en el examen, siempre considera que se pueden visitar varias ramas en una sola ejecución.
        //También recordar que el tipo de dato de las declaraciones case debe coincidir con el tipo de dato de la variable switch.
        //Además el valor de la declaración case también debe ser un literal, una constante enum o una variable constante final.

        //RETURN Y BREAK SE PUEDE USAR PARA SALIR RAPIDO DEL SWITCH


        //Ejmplo:

        /* private int getSortOrder(String firstName, final String lastName) {
            String middleName = "Patricia";
            final String suffix = "JR";
            int id = 0;
            switch(firstName) {         //TIENE EL TIPO DE DATO STRING
            case "Test":       //ESTE SÍ COMPILA PORQUE COINCIDE CON EL MISMO TIPO DE DATO STRING
                return 52;      //Una instrucción return, al igual que una instrucción break, puede usarse para salir temprano del switch. 
            case middleName:  // NO COMPILA PORQUE NO ES UNA VARIABLE CONSTANTE FINAL, ES DECIR, NO PUEDE CAMBIAR SU VALOR DEL CASE
                id = 5;
                break;
            case suffix:      //ESTE SÍ COMPILA, SÍ TIENE TIPO DE DATO ESTÁTICO Y STRING 
                id = 0;
                break;
            case lastName:  // NO COMPILA, A PESAR DE QUE TIENE EL FINAL, NO ES CONSTANTE YA QUE SE PASA A LA FUNCION
                id = 8;
                break;
            case 5:         // NO COMPILA PORQUE ES UN TIPO DE DATO INT
                id = 7;
                break;
            case 'J':       // NO COMPILA PORQUE ES UN TIPO DE DATO CHAR
                id = 10;
                break;
            case java.time.DayOfWeek.SUNDAY:  // NO COMPILA PORQUE TAMPOCO TIENE EL MISMO TIPO DE DATO DE LA SENTENCIA DEL SWITCH.
                id=15;
                break;
            }
            return id;
        } */
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
