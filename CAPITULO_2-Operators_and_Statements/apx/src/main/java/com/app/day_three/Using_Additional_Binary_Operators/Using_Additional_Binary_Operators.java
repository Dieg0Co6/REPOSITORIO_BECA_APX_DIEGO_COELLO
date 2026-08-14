package main.java.com.app.Using_Additional_Binary_Operators;

import java.io.File;

public class Using_Additional_Binary_Operators {

    public static void main(String[] args) {
        Using_Additional_Binary_Operators using_Additional_Binary_Operators = new Using_Additional_Binary_Operators();
        using_Additional_Binary_Operators.Assignment_Operators();
        using_Additional_Binary_Operators.Casting_Primitive_Values();
        using_Additional_Binary_Operators.Compound_Assignment_Operators();
        using_Additional_Binary_Operators.Relational_Operators();
        using_Additional_Binary_Operators.Logical_Operators();
        using_Additional_Binary_Operators.Equality_Operators();

    }

    //OPERADORES DE ASIGNACIÓN
    public void Assignment_Operators(){
        // Es aquel operador que asigna o modifica la variable  que se encuentra en el lado izquierda, con el valor que se encuentra
        //del lado derecho

        int x = 1; //ASÍ SE ASIGNA EL VALOR A UNA VARIABLE

        //JAVA PUEDE CAMBIAR EL TIPO DE DATOS DE MÁS PEQUEÑOS A MÁS GRANDES, PERO NO COMPILARÁ SI SE DESEA PASAR DE TIPOS DE DATOS
        // GRANDES A MÁS PEQUEÑOS.
        int x1 = 1.0;                  // NO COMPILARÁ PORQUE SE ESTÁ DECLARANDO UN INT, PERO SE LE ESTÁ ASIGNANDO UN VALOR DE TIPO DOUBLE
        short y = 1921222;             // NO COMPILARÁ PORQUE SE ESTÁ PASANDO UN VALOR GRANDE, QUE ESTÁ FUERA DEL RANGO DE SHORT
        int z = 9f;                    // NO COMPILARÁ PORQUE SE ESTÁ PASANDO UN VALOR DE TIPO FLOAT EN UNA VARIABLE DE TIPO INT (MÁS PEQUEÑA)
        //long t = 192301398193810323; // NO COMPILARÁ POPRQUE EL VALOR ESTÁ QUE LO PASA COMO SI FUERA UN INT, Y COMO INT ESTÁ FUERA DEL RANGO
                                       // PARA SER CONSIDERADO COMO LONG SE NECESITARÁ QUE SE AGREGUE UNA L AL FINAL "192301398193810323L".
        System.out.println(x);
        System.out.println(x1);
        System.out.println(y);
        System.out.println(z);
        /* System.out.println(t); */
    }

    // CONVERTIR VALORES PRIMITIVOS
    public void Casting_Primitive_Values(){
        //SE PUEDE CONVERTIR DE DATOS GRANDES A UNOS MÁS PEQUEÑOS, O VICEVERSA. PARA ESTO SE TIENE QUE CASTEAR. EJM:

        int x = (int)1.0;           // Aquí se convierte de double a int
        short y = (short)1921222;  // Aquí se convierte a short pero se almacena como 20678
        int z = (int)9l;            // Aquí de convierte de un long a un int
        long t = 192301398193810323L;   //Aquí solo hace falta colocarle el sufijo L para ser considerado como Long.


        //HAY QUE TENER EN CUENTA EL DESBORDAMIENTO Y SUBDESBORDAMIENTO
        // El segundo valor, 1,921,222, es demasiado grande para almacenarse como un short, por lo que ocurre un 
        // desbordamiento numérico y se convierte en 20,678.
        //Pasa cuando un número es demasiado grande para el tipo de dato que lo va a guardar. 
        // Como no entra, Java corta el número y guarda solo una parte de él (los bits que sobran se pierden) 

        // EL SUBDESBORDAMEINTO pasa cuando un número es demasiado pequeño (muy negativo) para el tipo de dato.
        // También se corta y da un resultado extraño.

        short x1 = 10;
        short y2 = 3;
        short z3 = x1 * y2;         //NO COMPILARÁ, ya que los short, al aplicarse con operadores binarios, pasan automaticamente a 
        //System.out.println(z3);     //convertirse en int, lo que da como un resultado int, y ese resultado int, se le está asignando
                                    // a un tipo de valor short que es más pequeño, y por ser de grande a pequeño, no compila.

        // Sin embargo, se puede lograr eso, haciendole un cast al resultado, ejmplo:

        short x4 = 10;
        short y4 = 33;
        short z4 = (short)(x4 * y4);
        System.out.println(z4);    
    }

    //OPERADORES DE ASIGNACIÓN COMPUESTOS
    public void Compound_Assignment_Operators(){
        //PARA EL EXAMEN SOLO SE NECESITAN SABER ACERCA DE LOS OPERADORES += Y -=
        //LOS CUALES INDICAN QUE A LA VARIABLE SE LE VA ASIGNAR UN NUEVO VALOR, PERO ESTE VALOR VA SER EL RESULTADO DE UNA OPERACION
        // ARITMETICA O LOGICA ENTRE LOS VALORES DEL LADO IZQUIERDO CON EL DERECHO. EJM:

        int x = 2, z = 3;   //VARIABLE DECLARADAS E INICIALIZADAS
        x = x * z;          //x va tener un nuevo valor que va salir del resultado de x * z
        x *= z;             // Este operador significa lo mismo, x = x * z -> x = 6 . x ahora valdrá 6

        //El lado izquierdo del operador compuesto solo se puede aplicar a una variable que ya esté definida
        //y no se puede usar para declarar una nueva variable. En el ejemplo anterior, si x no estuviera ya definida,
        //entonces la expresión x *= z no compilaría.

        //Otro Ejmplo:
        long x1 = 10;
        int y1 = 5;
        y1 = y1 * x1;  // NO COMPILARÁ, PORQUE SE LE ESTÁ ASIGNANDO UN VALOR INT, Y NO PUEDE BAJARSE A UN TIPO MÁS PEQUEÑO. 
                        //SE SOLUCIONARÍA CON UN CAST (int)

        long x2 = 10;
        int y2 = 5;
        y2 *= x2;       //EN ESTE CASO SI COMPILARÁ, porque el operador compuesto primero convertirá x a un long,
                        //aplicará la multiplicación de dos valores long, y luego convertirá el resultado a un int.
                        //en este ejemplo vemos que el compilador convertirá automáticamente el valor resultante al tipo de dato del valor
                        //en el lado izquierdo del operador compuesto.

        //EN EL OPERADOR DE ASIGNACIÓN, SE TIENE QUE TENER EN CUENTA QUE EL RESULTADO ES UNA EXPRESIÓN EN SÍ MISMA. EJM
        long x3 = 5;            //Aquí se declara e inicializa una variable, con valor 5
        long y3 = (x3=3);        //Luego se inicializa el valor x a 3, y ese valor 3, también se le asigna a y3
        System.out.println(x3); // Resultado 3
        System.out.println(y3); // también muestra 3

        //EXPLICACIÓN: (x3=3) HACE DOS COSAS, PRIMERO ASIGNA 3 A LA VARIABLE, Y LUEGO MUESTRA UN RESULTADO QUE TAMBIÉN ES 3, Y ESE VALOR SE LE
        // ASIGNA A LA VARIABLE y3


        /* TENER EN CUENTA QUE:
        ------------------------ */
        // A los creadores de exámenes les gusta insertar el operador de asignación = en medio de una expresión y usar el valor de
        // la asignación como parte de una expresión más compleja.

    }

    public void Relational_Operators(){
        //En los operadores relacionales tenemos los siguientes que son para expresiones numericas.
        /*
        *   <       estrcitamente menor que
        *   <=     menor o igual que
        *   >       estrictamente mayor que
        *   >=      mayor o igual que
         */

        //EJMPLOS

        int x = 10, y = 20, z = 10;
        System.out.println(x < y);  // resultado: true
        System.out.println(x <= y);  // resultado: true
        System.out.println(x >= z);  // resultado: true
        System.out.println(x > z);  // resultado: false

        //El quinto operador relacional se aplica a referencias de objetos y clases o interfaces.
        //a instanceof b        Es verdadero si a es una instancia de una clase, subclase, interfaz B
        //ejmplo:
        String nombre = "Diego";
        System.out.println(nombre instanceof String); //Devuelve TRUE
    }

    public void Logical_Operators(){
        //Los operadores lógicos, (&), (|) y (^), pueden aplicarse tanto a tipos de datos numéricos como booleanos.
        //Cuando se aplican a tipos de datos booleanos, se les llama operadores lógicos.
        //Por otro lado, cuando se aplican a tipos de datos numéricos, se llaman operadores a nivel de bits

        /*
            * &         -> Para que sea verdadero ambos tienen que ser verdadero, sino serán falso
            * |         -> Basta que uno sea verdadero, para que sea verdadero
            *              y si los dos son falsos, entonces ahí recien es falso
            * ^         -> Si son iguales (ambos falsos o ambos verdaderos) es falso, y si son diferentes, es verdadero.
         */


        //Luego tenemos a && y || , que son llamados operadores con cortocircuito
        //Son casi iguales que sus similares & y |, pero con la diferencia que puede que nunca evalúen la operacion de la parte derecha
        //si el resultado final se puede determinar por el lado izquierdo de la expresión. EJMPLO

        boolean x = true || (y < 4); //x será verdadero, sí o sí, ya que del lado izquierdo ya tenemos true, y si es de un lado es true,
                                     //entonces el resultado es true, entonces ya no evalúa el lado derecho.
        
        // OTRO EJEMPLO DONDE AYUDA ESTOS OPERADORES CON CORTOCIRCUITO, ES QUE AYUDAN SI ES QUE UN OBJETO ES NULO+
        /* if(x != null && x.getValue() < 5) {
        // Do something
        } */

        //si x fuera nulo, entonces el cortocircuito previene que se lance una NullPointerException,
        //ya que nunca se llega a evaluar x.getValue() < 5. 
        //Y si se usara el operador &, entonces ahí sí se evaluarían ambos y cuando x fuera null, esto lanzaría una excepción.
        /* if(x != null & x.getValue() < 5) { 
            // Lanza una excepción si x es null 
            // Hacer algo
        } */

        //Por eso mismo tener cuidado con los cortocircuitos, ya que pueden usarse para indicar una expresión PERO QUE NUNCA SE VA EVALUAR.
        //EJMPLO
        int x5 = 6;     //ACÁ SE DECLARA E INICIALIZA UNA VARIABLE, EL VALOR ES 6
        boolean y5 = (x5 >= 6) || (++x5 <= 7);      //y5 es true por la expresión de la izquierda que es true y usa ||, la derecha NO SE EVALÚA
        System.out.println(x5);                     //eso quiere decir que x5 = 6
    }

    //OPERADORES DE IGUALDAD
    public void Equality_Operators(){
        //TENER CUIDADO PORQUE : hay una diferencia semántica entre “dos objetos son iguales” y “dos objetos son equivalentes”
        //AQUÍ TENEMOS AL IGUAL == Y AL NO ES IGUAL !=
        //Estos comparan dos operandos y devuelven un valor booleano sobre si las expresiones o valores son iguales o no respectivamente
        // Se usan para comparar dos valores de tipos primitivos, dos valores booleanos y dos objetos incluidos el null y el String.
        // Ejm: 5 == 5.00 devuelve true ya que el lado izquierdo se convierte a double.

        //Sin embargo, también hay excepciones donde no se puede comparar diferentes tipos de datos.
        /* boolean x = true == 3;  */             // NO COMPILARÁ PORQUE SE ESTÁ COMPARANDO UN TIPO BOOLEAN CON UN INT
        boolean y = false != "Giraffe";     // NO COMPILARÁ PORQUE SE COMPARA UN BOOLEAN CON UN TIPO STRING
        boolean z = 3 == "Kangaroo";        // NO COMPLICA PORQUE SE IGUAL UN TIPO INT CON UN STRING.


        //Los creadores del examen también suelen mezclar operadores de asignación y de igualdad, EJM:
        boolean y2 = false;         //se le asigna false
        boolean x2 = (y2 = true);   //aquí y2 se le asigna true y también devuelve el valor true, que se le asigna a x2
        System.out.println(x2);     // da como resultado true.

        //Para la comparación de objetos, el operador de igualdad se aplica a las referencias de los objetos,
        //no a los objetos a los que apuntan. Dos referencias son iguales si y solo si apuntan al mismo objeto,
        //o ambas apuntan a null. EJM:

        File x3 = new File("myFile.txt");    //Se crea un objeto, en el cual x3 es la referencia de ese objeto
        File y3 = new File("myFile.txt");    //Se crea otro objeto, en el cual tiene como referencia y3
        File z3 = x3;                                 //Se le asigna la referencia de x3 a z3, ambos tienen la misma referencia del primer objeto
        System.out.println(x3 == y3);                 //Da como resultado falso, ya que las referencias de x3 y y3 son distintas
        System.out.println(x3 == z3);                 //Da como resultado verdadero, ya que las referencias de x3 y z3 son las mismas y apuntan
                                                      //al mismo objeto
    }
}
