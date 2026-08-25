package main.java.com.app.Understanding_Java_Statements;

import javax.xml.crypto.Data;

public class Understanding_Java_Statements {
    public static void main(String[] args) {
        Understanding_Java_Statements understanding_Java_Statements = new Understanding_Java_Statements();
        understanding_Java_Statements.The_if_then_Statement();
        understanding_Java_Statements.The_if_then_else_Statement();
        understanding_Java_Statements.Ternary_Operator();
        understanding_Java_Statements.The_switch_Statement();
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
        int x6 = 5;
        System.out.println(x6 > 2 ? x6 < 4 ? 10 : 8 : 7); //SERÍA COMO DECIR condicion1 ? (condicion2 ? valorA : valorB) : valorC
    
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
    
}
