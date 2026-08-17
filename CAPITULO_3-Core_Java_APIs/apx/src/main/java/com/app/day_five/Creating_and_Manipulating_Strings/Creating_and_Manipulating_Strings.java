package main.java.com.app.day_five.Creating_and_Manipulating_Strings;

public class Creating_and_Manipulating_Strings {


    //LA CLASE STRING ES UN MUY FUNDAMENTAL PARA ESCRIBIR CODIGO CON JAVA, YA QUE NI SIQUIERA PUDIERAMOS ESCRIBIR EL
    //METODO MAIN SIN EL STRING.

    public static void main(String[] args) {
        
        //Básicamente, un string es una secuencia de caracteres.
        String name = "Fluffy";

        //EN JAVA SE PUEDE DECLARAR UN STRING DE LAS SIGUIENTES MANERAS:
        String name1 = "Fluffy";
        String name2 = new String("Fluffy");        //Tambien se puede crear un String de esta manera, ya que String
                                                             // es una clase, entonces estamos instanciando un objeto.
    
        //Ambos te dan una variable de referencia del tipo nombre que apunta al objeto String "Fluffy".

        Creating_and_Manipulating_Strings creating_and_Manipulating_Strings = new Creating_and_Manipulating_Strings();
        creating_and_Manipulating_Strings.Concatenation();
        creating_and_Manipulating_Strings.Immutability();
        creating_and_Manipulating_Strings.The_String_Pool();
        creating_and_Manipulating_Strings.Important_String_Methods();
        creating_and_Manipulating_Strings.Method_Chaining();

    }

    public void Concatenation(){

        //CONCATENACIÓN SE REFIERE A COMBINAR UN STRING ANTES DE OTRO STRING Y COMBINARLOS JUNTOS.
        //TENER CUIDADO PORQUE A LOS CREADORES DEL EXAMEN LES GUSTA LA CONCATENACIÓN, PORQUE EL OPERADOR + SE PUEDE USAR
        //DE DOS MANERAS DENTRO DE LA MISMA LINEA DE CODIGO.

        /* REGLAS 
            * SI AMBOS OPERANDOS SON NUMERICOS, SIGNIFICA SUMA NUMERICA
            * SI ALGUNO DE LOS OPERANDOS ES UN STRING + , ENTONCES ES CONCATENACIÓN.
            * LA EXPRESIÓN SE EVALÚA DE IZQUIERDA A DERECHA.
        */

        //EJEMPLO:
        System.out.println(1 + 2);  //AMBOS OPERANDOS SON NUMERICOS, SIN COMILLAS, ENTONCES RESULTADO 3
        System.out.println("a" + "b");  //AMBOS OPERANDOS SON CARACTERES, CON COMILLAS, ENTONCES CONCATENACION. RESULTADO ab.
        System.out.println("a" + "b" + 3);  //DOS DE LOS PRIMEROS OPERANDOS SON CARACTERES, CON COMILLAS, LUEGO SEGUIDO DE NUMERO
                                            //IGUAL ES CONCATENACION. RESULTADO ES ab3
        System.out.println(1 + 2 + "c");    //DOS PRIMEROS OPERANDOS SON NUMEROS, ENTONCES SE SUMA Y LUEGO SE AÑADE CON UN 
                                            //CARACTERE CON COMILLA, ENTONCES EL RESULTADO ES 3c
        
        /* NOTA IMPORTANTE: 
            * LAS COMILLAS PARA LA CADENA DE TEXTO SOLO SE USAN PARA EL CODIGO, EL RESULTADO SE MUESTRA SIN COMILLAS.
        */                           
        
        //TENER CUIDADO PORQUE EN EL EXAMEN TRATARÁN DE ENGAÑAR CON ALGO ASÍ. EJMPLO:
        int three = 3;          //VALOR NUMERICO
        String four = "4";      // CADENA DE TEXTO
        System.out.println(1 + 2 + three + four);   // 3 + 3 + "4" -> 64

        //TIP: SIEMPRE REVISAR LOS TIPOS DE DATO DE LA VARIABLE.

        //RECORDAR QUE =+ "cadena de texto" TAMBIÉN IMPLICA CONCATENACION. s =+ "2" es igual que s = s + "2". EJM:

        String s = "1";     //CADENA DE TEXTO
        s += "2";           // s = s + "2" -> s = "1" + "2" -> s = "12"
        s += 3;             // s = s + 3 -> s = "12" + 3 -> s = "123"
        System.out.println(s);  //123
        
    }

    public void Immutability(){
        //Una vez que se crea un objeto String, no se puede cambiar.
        //No se puede hacer más grande ni más pequeño, y no puedes cambiar uno de los caracteres dentro de él.

        //Puedes pensar en un string como una caja de almacenamiento que tienes completamente llena y cuyos lados
        //no pueden sobresalir. No hay forma de agregar objetos, ni puedes reemplazar objetos sin alterar todo el arreglo.

        /* 
            * INMUTABLE SIGNIFICA QUE UN OBJETO NO PUEDE SER CAMBIADO UNA VEZ CREADO.
            * STRING ES INMUTABLE
            * PARA EL EXAMEN ES IMPORTANTE RECORDAR QUE STRING ES INMUTABLE.
        */

        //EJEMPLO:
        class Mutable {     // HACE REFFERENCIA A CUALQUIER OTRA CLASE QUE CREAMOS, EL CUAL CUENTA CON UN GETTER AND SETTER
            private String s;       //SE DECLARA LA VARIABLE S
            public void setS(String newS){ s = newS; }  //EL SETTER LO HACE MUTABLE
            public String getS() { return s; }
        }

        //CON FINAL PARA QUE NADIE PUEDA HEREDAR A INMUTABLE 
        final class Immutable {      //HACE REFERENCIA A LA CLASE STRING, QUE SOLO TIENE GETTER, NO TIENE SETTER PARA CAMBIAR SU VALOR
            private String s = "name";      
            public String getS() { return s; }
        }

        //UN MOMENTO: IMPORTANTE
        // NO CONFUNDIR:

        /* 
            *ESTO SÍ SE PUEDE HACER:  //Esto sí funciona, y no contradice la inmutabilidad.
            String name = "Diego";    //Se crea el objeto "Diego" en memoria y la variable name apunta a ese objeto
            name = "Diego Coello";    //Cuando escribo name = "Diego Coello". Java crea un objeto NUEVO "Diego Coello" en memoria.
                                        La variable name ahora apunta al objeto nuevo, abandonando al anterior.
                                        Eso quiere decir que el objeto "Diego" original nunca cambió
        */

        //TAMBIÉN TENER EN CUENTA QUE:
        String a = "Diego";
        String b = "Diego";
        // a y b apuntan AL MISMO objeto en el String Pool (Java lo reutiliza)

        //EN CAMBIO:
        String a1 = new String("Diego");
        String b1 = new String("Diego");
        // a1 y b1 apuntan a DOS objetos DIFERENTES (aunque tengan el mismo contenido)


        //EJMPLO DEL LIBRO:
        String s1 = "1";                   //Se crea un objeto String con contenido "1"
        String s2 = s1.concat("2");   // crea una OBJETO NUEVO "12", y s2 apunta ahí
        s2.concat("3");                // Se CREA un OBJETO NUEVO "123"... pero NADIE la apunta, se pierde
        System.out.println(s2);        // s2 sigue apuntando a "12"
    }

    public void The_String_Pool(){
        //Los String están por todas partes, en la cuales en un programa puede representar el 25 o 40 % del programa Java.

        //Java se da cuenta que muchos String se repiten, entonces soluciona este problema reutilizando las comunes, es decir, que
        //los objetos String que tienen el mismo valor se reutilizan.

        //El String pool o el intern pool es un lugar en la máquina virtual de Java (JVM) que recopila todas estas cadenas.
        //Y aquí contienen todas las cadenas con valores literales, es decir, con un valor explicito en código que se le asignó, con sus comillas
        //y sin necesidad de calcularlo, procesarlo o generarlo con algún método. Ejm: name = "Diego", si es un literal, pero myObject.toString()
        //es una cadena pero no un literal. EJMPLO:

        String name = "Fluffy";
        String name1 = new String("Fluffy");

        //ESAS DOS LINEAS SON SUTILMENTE DIFERENTES. UNO ES CONSIDERADO UN LITERAL, Y EL OTRO NO, PORQUE FUERZA A CREAR UN OBJETO
        //En el segundo no se escribió directamente en el código. Se genera cuando el programa se está ejecutando.
    }

    public void Important_String_Methods(){
        //PARA EL EXAMEN SOLO ES NECESARIO SABER LOS MÁS IMPORTANTES, LO QUE SE USA EN EL DÍA A DÍA DE UN PROGRAMADOR

        //TAMBIÉN RECORDAR QUE:
        //Un String es una secuencia de caracteres y que Java cuenta desde 0 cuando se indexa. EJMPLO:
                    /*
                        * A     N     I       M       A       L       S
                        * 0     1     2       3       4       5       6      
                     */
        //A CONTINUACIÓN, SE VERÁN LOS PRINCIPALES 13 METODOS DE LA CLASE STRING.
        Method_Length();
        charAt();
        indexOf();
        subString();
        toLowerCase_and_toUpperCase();
        equals_and_equalsIgnoreCase();
        startsWith_and_endsWith();
        contains();
        replace();
        trim();
    }

    private void Method_Length(){
        //El método length() devuelve el número de caracteres en la cadena. TIENE LA SIGUIENTE FIRMA:
        // int length()

        String string = "animals";      //Se asigna a la variable string el objeto String de valor animals
        System.out.println(string.length());    //El tamaño de la cadena es 7, puesto que tiene 7 caracteres la palabra animals
        
        //SE COMIENZA DESDE CERO SOLAMENTE CUANDO ESTAMOS HABLANDO DE INDICES O POSICIONES DENTRO DE UNA LISTA, PERO CUANDO
        //SE TRATA DE TAMAÑO O LONGITUD, AHÍ SÍ DEVUELVE EL NUMERO DE CARACTERES CONTANDO NORMALMENTE.
    }

    private void charAt(){
        //Este método devuelve el caracter de acuerdo a la posición o índice que se le indica. TIENE LA SIGUIENTE FIRMA:
        //char charAt(int index)    //Devuelve un caracter y en los parentesis se le agrega la posicion indicando un numero
        
        String string = "animals";  //Se asigna a la variable string el objeto String de valor animals
        System.out.println(string.charAt(0));  // devolverá el primer caracter de la cadena de texto. Resultado: a
        System.out.println(string.charAt(6));  // devolverá el ultimo caracter de la cadena de texto. Resultado: s
        System.out.println(string.charAt(7));   // throws exception . YA QUE NO HAY POSICION 7 en esta cadena de texto.
        //java.lang.StringIndexOutOfBoundsException: String index out of range: 7
    }

    private void indexOf(){
        //Este método observa los caracteres en la cadena y encuentra el primer índice que coincide con el valor deseado.
        //indexOf puede funcionar con un caracter individual (char) o con una cadena completa como entrada.
        //También puede comenzar desde una posición solicitada. TIENE LAS SIGUIENTES FIRMAS:

        /* 
            * int indexOf(char ch)      //Se le pasa solo un caracter
            * int indexOf(char ch, index fromIndex)     //Se le pasa un caracter y el indice desde donde comenzar
            * int indexOf(String str)                   //Se le pasa una cadena de texto
            * int indexOf(String str, index fromIndex)  //Se le pasa una cadena de texto y el indice desde donde comenzar
        */

        String string = "animals";
        System.out.println(string.indexOf('a'));    //0
        System.out.println(string.indexOf("al"));       //4
        System.out.println(string.indexOf('a', 4)); //4
        System.out.println(string.indexOf("al", 5));    //-1

        //TENER EN CUENTA QUE CUANDO NO ENCUENTRA QUE COINCIDA CON EL CARACTER O LA CADENA DE TEXTO, ENTONCES DEVOLVERÁ
        //COMO RESULTADO -1. ESO SIGNFICA NOT FOUND.
    }

    private void subString(){
        //Este método substring() también busca caracteres en una cadena.
        //Pero devuelve partes de la cadena, NO LA POSICIÓN O INDICE.

        //El primer parámetro es el índice desde donde empezar para la cadena que se va a devolver. beginIndex
        //Hay un segundo parámetro opcional, que es el índice final donde quieres detenerte.
        //Esto significa que el parámetro endIndex puede ser 1 más allá del final de la secuencia si quieres detenerte
        //al final de la secuencia.Sin embargo, eso sería redundante, ya que podrías omitir el segundo parámetro por
        //completo en ese caso. IGUAL EN EL EXAMEN PUEDE COLOCARLO EL SEGUNDO PARAMETRO CON TAL DE CONFUNDIR.

        //TIENE LA SIGUIENTE FIRMA:
        /* int substring(int beginIndex)
        int substring(int beginIndex, int endIndex) */


        String string = "animals";
        System.out.println(string.substring(3));  //desde la posicion 3,entonces sería: als
        System.out.println(string.substring(string.indexOf('m'))); // mals
        System.out.println(string.substring(3, 4)); //m
        System.out.println(string.substring(3, 7)); //mals

        //Tener siempre en cuenta que la posición del PRIMER PARAMETRO (beginIndex) SÍ se considera
        //Y considerar que la posición del SEGUNDO PARAMETRO (endIndex) NO se considera.

        System.out.println(string.substring(3, 3)); // String vacío, porque no substrae nada.
        System.out.println(string.substring(3, 2));  //lanza throws exception, porque colocas un endIndex menor
        System.out.println(string.substring(3, 8)); // throws exception

        //EN LA LINEA 228 LANZA ERROR, y es confuso porque el error está en pensar que substring() funciona igual que charAt()
        //substring() NO funciona con "posiciones de letras". Funciona con "espacios ENTRE letras".

        //SIENDO ENTONCES DE LA SIGUIENTE MANERA:
            /*            a  n  i  m  a  l  s
            Índice      0  1  2  3  4  5  6  7
                        ↑                    ↑
                        inicio                final (después de la última letra) */


        //ES DECIR CON EL METODO SUBSTRING, SIEMPRE CONSIDERA EL ULTIMO VACÍOD DEL TEXTO COMO OTRA POSICION.
    }

    private void toLowerCase_and_toUpperCase(){
        //Estos dos metodos, hacen los que dicen, uno convierte el String a minusculas, y otro convierte el String a MAYUSUCULAS.

        /* String toLowerCase()
        String toUpperCase() */

        //ejmplo:

        String string = "animals";
        System.out.println(string.toUpperCase());  // ANIMALS
        System.out.println("Abc123".toLowerCase());  // abc123
    }

    private void equals_and_equalsIgnoreCase(){
        //El método equals() verifica si dos objetos String contienen exactamente los mismos caracteres en el mismo orden.
        //NO IMPORTA SI AL FINAL DE CUENTA ESTÁ COMPARANDO AL MISMO OBJETO COMO EN ESTE CASO:

        String name = "Diego";      
        String name1 = "Diego";
        name.equals(name1);   // true → compara "Diego" con "Diego"


        //O SI SON DIFERENTES OBJETOS COMO EN ESTE CASO:

        String name2 = new String("Diego");
        String name3 = new String("Diego");
        name2.equals(name3);   // true → compara "Diego" con "Diego"


        //El método equalsIgnoreCase() verifica si dos objetos String contienen los mismos caracteres, 
        // ignorando las mayusculas y minusculas, solo le importa si es igual el contenido.

        /* SU FIRMA DE AMBOS METODOS ES LA SIGUEINTE:
        boolean equals(String str)
        boolean equalsIgnoreCase(String str) */

        System.out.println("abc".equals("ABC"));  // false
        System.out.println("ABC".equals("ABC"));  // true
        System.out.println("abc".equalsIgnoreCase("ABC"));  // true
    }

    private void startsWith_and_endsWith(){
        //Los métodos startsWith() y endsWith() verifican si el valor proporcionado coincide con una parte del String.
        //DEVUELVE UN BOOLEAN: TRUE SI COINCIDE / FALSE SI NO COINCIDEN
        //Las firmas de los métodos son las siguientes:

        /* boolean startsWith(String prefix)
        boolean endsWith(String suffix) */

        System.out.println("abc".startsWith("a")); // true
        System.out.println("abc".startsWith("A")); // false
        System.out.println("abc".endsWith("c")); // true
        System.out.println("abc".endsWith("a")); // false
    }

    private void contains(){
        //El método contains() también busca coincidencias en el String. No es tan específico como startsWith() y endsWith():
        //la coincidencia puede estar en cualquier parte del String. La firma del método es la siguiente:

        /* boolean contains(String str) */

        System.out.println("abc".contains("b")); // true
        System.out.println("abc".contains("B")); // false

        //AL IGUAL QUE starsWith() y endsWith(), contains() TAMBIÉN DISTINGUE ENTRE MAYUSCULAS Y MINUSCULAS.
        
        //ESTE METODO FACILITA MUCHO Y EVITA ESTAR USANDO ESTO str.indexOf(otherString) != -1.
    }

    private void replace(){
        // El método replace() realiza una búsqueda y reemplazo simple en la cadena.
        //Hay una versión que usa parámetros char y otra versión que usa parámetros CharSequence.
        //Un CharSequence es una manera general de representar varias clases, incluyendo String y StringBuilder.
        //LAS FIRMAS DEL METODO SON LAS SIGUIENTES

        /* String replace(char oldChar, char newChar)
        String replace(CharSequence oldChar, CharSequence newChar) */

        System.out.println("abcabc".replace('a', 'A')); // AbcAbc
        System.out.println("abcabc".replace("a", "A")); // AbcAbc

        //El primer ejemplo usa la primera firma del método, pasando parámetros de tipo char.
        //El segundo ejemplo usa la segunda firma del método, pasando parámetros de tipo String.

        "hola mundo".replace("mundo", "Java");   // "hola Java"
    }

    private void trim(){
        //El método trim() elimina los espacios en blanco del principio y del final de un String.
        //En términos del examen, los espacios en blanco consisten en espacios junto con los caracteres (tab) (\t) y (newline)(\n).
        //Otros caracteres, como (carriage return)(\r), también se incluyen en lo que se elimina. La firma del método es la siguiente:
        
        /* public String trim() */

        System.out.println("abc".trim());           // abc
        System.out.println("\t   a b c\n".trim()); // a b c
    
        //El segundo ejemplo elimina la tabulación inicial, los espacios posteriores y el salto de línea al final.
        //Deja los espacios que están en medio de la cadena.

        //LOS ESPACIOS NORMALES NO LOS BORRA. EJM:
        String s = "Hola Mundo";
        System.out.println(s);      //imprime Hola Mundo
    }

    //Encadenamiento de métodos
    public void Method_Chaining(){
        //Es común varios métodos en la misma cadena de texto. EJM:

        String start = "AniMaL   ";
        String trimmed = start.trim();                 // "AniMaL"
        String lowercase = trimmed.toLowerCase();      // "animal"
        String result = lowercase.replace('a', 'A');   // "AnimAl"
        System.out.println(result);

        //Esto es solo una serie de métodos de String. Cada vez que se llama a uno, el valor devuelto se pone en una nueva variable.
        //Hay cuatro valores de String en el camino, y se muestra Animal.


        //PERO HAY LA FORMA DE COLOCAR LOS METODOS EN UNA MISMA LINEA, A ESO SE LE LLAMA ENCADENAMIENTO DE METODOS.

        //En el examen hay una tendencia a meter tanto código como sea posible en un espacio pequeño.
        //Verás código usando una técnica llamada encadenamiento de métodos.

        String result1 = "AniMaL   ".trim().toLowerCase().replace('a', 'A');
        System.out.println(result1);    //AnimAl


        //Para leer código que usa encadenamiento de métodos, empieza por la izquierda y evalúa el primer método.
        //Luego llama al siguiente método sobre el valor que devuelve el primer método. Sigue así hasta llegar al punto y coma

        String a = "abc";
        String b = a.toUpperCase();
        b = b.replace("B", "2").replace('C', '3');
        System.out.println("a=" + a);       //abc
        System.out.println("b=" + b);       //A23
    }
}
