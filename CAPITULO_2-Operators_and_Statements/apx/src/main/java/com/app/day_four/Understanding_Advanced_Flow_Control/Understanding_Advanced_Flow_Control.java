package main.java.com.app.Understanding_Advanced_Flow_Control;

import java.util.Optional;

public class Understanding_Advanced_Flow_Control {

    public static void main(String[] args) {
        
        //LAS ETIQUETAS SE PUEDEN USAR EN CUALQUIER DECLARACION DE BLOQUE INCLUIDO LOS IF, ASÍ TAMBIÉN LOS BUCLES Y EL SWITCH
        //EL BREAK Y EL CONTINUE NO ESTÁ PERMITIDO PARA SENTENCIAS IF
        //LA SENTENCIA BREAK ESTÁ PERMITIDO PARA BUCLES Y EL SWITCH, MENOS PARA IF
        //LA SENTENCIA CONTINUE ESTÁ PERMITIDO PARA BUCLES (WHILE,DO-WHILE Y FOR), MENOS PARA IF NI SWITCH.
        Understanding_Advanced_Flow_Control understanding_Advanced_Flow_Control = new Understanding_Advanced_Flow_Control();
        understanding_Advanced_Flow_Control.Nested_Loops();
        understanding_Advanced_Flow_Control.Adding_Optional_Labels();
        understanding_Advanced_Flow_Control.The_break_Statement();
        understanding_Advanced_Flow_Control.The_continue_Statement();

    }

    //BUCLES ANIDADOS
    public void Nested_Loops(){
        //LOS BUCLES PUEDEN TENER OTROS BUCLES, QUE SON UTILES CUANDO QUEREMOS ITERAR ARREGLOS BIDIMENSIONALES
        //(QUE SON ARREGLOS QUE CONTIENENE OTROS ARREGLOS COMO ELEMENTOS)

        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}}; //Aquí se declara y se iniciliza un array de arrays o array 2D
        for(int[] mySimpleArray : myComplexArray) {     //Este for-each recorre el primer array, el externo
            for(int i=0; i<mySimpleArray.length; i++) {     //Este for recorre el segundo array, que ya son elementos
                System.out.print(mySimpleArray[i]+"\t");    //IMPRIME EL ELEMENTO SEGÚN POSICION Y LUEGO HACE UNA TABULACION
            }
            System.out.println();   //AL TERMINAR EL ARREGLO COMO ELEMENTO, HACE UN SALTO DE LINEA Y PASA AL SIGUIENTE ARRAY
        }

        // Los bucles anidados pueden incluir while y do-while. EJMPLO:
        int x = 20;             //SE DECLARA LA VARIABLE X E INICIALIZA CON VALOR 20
        while(x>0) {            // SI ES MAYOR QUE 0 ENTRA AL BLOQUE DE CODIGO
            do {
                x -= 2;         //SE LE DISMINUYE DOS, AHORA ES 18
            } while (x>5);      //SI ES MAYOR QUE 5, SE ITERA.
            x--;                //CUANDO EL VALOR ES 4, SE DISMINUYE 1, QUEDANDO 3.
            System.out.print(x+"\t");       //SE IMPRIME 3 CON UN TAB. Y SE VUELVE A ITERAR AHORA CON X = 3
                                           //RESULTADO: 3     0
        }
    }

    public void Adding_Optional_Labels(){
        //Las declaraciones if-then, las declaraciones switch y los bucles pueden tener etiquetas opcionales. 
        //Una etiqueta es un puntero opcional a la cabeza de una declaración que permite que el flujo de la aplicación
        //salte a ella o se rompa desde ella. Es una sola palabra seguida de dos puntos (:).

        //SON ETIQUETAS OPCIONALES.
        //Cuando se trata de un solo bucle, no aportan ningún valor, pero como veremos en la siguiente sección,
        //son extremadamente útiles en entornos anidados.
        //Las etiquetas opcionales a menudo solo se usan en estructuras de bucle.
        int[][] myComplexArray = {{5,2,1,3},{3,9,8,9},{5,7,12,7}};
        OUTER_LOOP:  for(int[] mySimpleArray : myComplexArray) {
            INNER_LOOP: for(int i=0; i<mySimpleArray.length; i++) {
                System.out.print(mySimpleArray[i]+"\t");
            }
        System.out.println();
        }

        //Las ETIQUETAS sirven para controlar a cuál bucle específico le aplicas un break o continue cuando tienes bucles anidados.
    }

    public void The_break_Statement(){
        //Una sentencia break transfiere el flujo de control hacia la sentencia que la contiene.
        //Se puede usar tanto en switch, como en bucles (while, do-while y for). EJMPLO:

        int x = 8;
        LOOP_LABEL: while (x < 0){
            //body del loop
            break LOOP_LABEL;
        }

        //La instrucción break puede llevar un parámetro opcional de etiqueta. Sin un parámetro de etiqueta,
        //la instrucción break terminará el bucle interno más cercano que se esté ejecutando en ese momento.
        //El parámetro de etiqueta opcional nos permite salir de un bucle externo de un nivel superior

        //EJMPLO:
        public class SearchSample {
            public static void main(String[] args) {
                //Se declara e inicializa este array 2D llamado list
                int[][] list = {{1,13,5},{1,2,5},{2,7,2}};
                int searchValue = 2;
                int positionX = -1;
                int positionY = -1;
                //BUCLE SUPERIOR EL CUAL TIENE LA ETIQUETA PARENT_LOOP
                PARENT_LOOP: for(int i=0; i<list.length; i++) {
                    //BUCLE INTERNO EL CUAL SE EJECUTA SIEMPRE QUE J SEA MENOR QUE EL TAMAÑO DEL ARRAY INTERNO
                    for(int j=0; j<list[i].length; j++) {
                        //Si el valor del elemento que está en el array interno es 2,entonces:
                        if(list[i][j]==searchValue) {
                        positionX = i;  //se le cambia la posicionX a la posicion del arreglo externo
                        positionY = j;  //se le cambia la posicionY a la posicion del arreglo interno
                        break PARENT_LOOP;      //al encontrar el valor del elemento, sale de PARENT_LOOP, es decir de los dos bucles
                        //Esta instrucción saldrá de toda la estructura de bucle tan pronto como se encuentre el primer valor coincidente.
                        }
                    }
                }
                //AL SALIR DE LOS DOS BUCLES SI LO ENCONTRÓ EJECUTA ESTO
                //SI LAS POSICIONES SIGUEN SIENDO -1, ENTONCES NO ENCONTRÓ ESE ELEMENTO
                if(positionX==-1 || positionY==-1) {
                System.out.println("Value "+searchValue+" not found");
                } else {     //SI LO ENCONTRO, DEVUELVE LA POSICION EN LA QUE LO ENCONTRÓ.
                System.out.println("Value "+searchValue+" found at: " +
                    "("+positionX+","+positionY+")");   //DEVUELVE: VALUE 2 found at: (1 , 1)
                }
            }
        }

        //SI EN CAMBIO, SOLO PUSIERONAMOS ESTO:

        /* if(list[i][j]==searchValue) {
            positionX = i;
            positionY = j;
            break;
        } */

        //SOLAMENTE SALDRÍA DEL BUCLE MÁS CERCANO, ES DECIR, DEL BUCLE INTERNO, PERO SEGUIRÍA EJECUTANDOSE EL RESTO EL BUCLE
        //CON ETIQUETA PARENT_LOOP´, PASANDO AL SIGUIENTE ELEMENTO ARRAY, EN LA CUAL HAY OTRO DOS Y MOSTRARÍA ESA POSICIÓN.
        // IMPRIMIRÍA ENTONCES VALUE 2 found at: (2 , 0)
        
        //Y SI QUITAMOS EL BREAK:
        /* if(list[i][j]==searchValue) {
            positionX = i;
            positionY = j;
        } */

        //ENTONCES SE EJECUTARÍA HASTA EL FINAL, DANDO COMO RESULTADO QUE LA POSICION DEL ULTIMO VALOR COINCIDENTE
        //VALUE 2 found at: (2 , 2)
        
    }

    public void The_continue_Statement(){
        //CONTINUE es una instrucción que hace que el flujo termine la iteración del bucle actual

        //Mientras que la sentencia break transfiere el control a la sentencia que la contiene,
        //la sentencia continue transfiere el control a la expresión booleana que determina si el bucle debe continuar.
        //En otras palabras, termina la iteración actual del bucle. EJM:

        public class SwitchSample {
            public static void main(String[] args) {
                //ESTE BUCLE TIENE A QUE INICIA EN 1 Y SE VA EJECUTAR HASTA QUE SEA MENOR O IGUAL A 4
                FIRST_CHAR_LOOP: for (int a = 1; a <= 4; a++) {
                    //TIENE OTRO BUCLE INTERNO EL CUAL X INICIA CON A Y TERMINARÁ CUANDO X SEA MENOR O IGUAL QUE C
                    for (char x = 'a'; x <= 'c'; x++) {
                        //SI A ES IGUAL A 2 O X ES IGUAL A B, ENTONCES TERMINA ESA ITERRACIÓN, Y SIGUE A LA SIGUIENTE
                        // ITERACION DEL PRIMER FOR
                        if (a == 2 || x == 'b')
                            continue FIRST_CHAR_LOOP;
                        System.out.print(" " + a + x);// IMPRIME 1a   3a   4a
                    }
                }
            }
        }

        //y si eliminamos la etiqueta y solo dejamos el continue:
        //imprimirá 1a  1c  3a   3c   4a   4c

        //si eliminamos la instrucción continue y la instrucción if-then asociada por completo
        //imprimirá 1a  1b   1c   2a   2b   2c   3a   3b   3c   4a   4b   4c
    }
}
