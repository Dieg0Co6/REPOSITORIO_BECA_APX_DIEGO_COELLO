package com.app4.day_eight.Passing_Data_Among_Methods;

public class Passing_Data_Among_Methods {
    //JAVA ES UN LENGUAJE DE PASO POR VALOR. ESTO SIGNIFICA QUE:
    //Se hace una copia de la variable y el método recibe esa copia.
    //Las asignaciones que se hagan en el método no afectan al que llama.

    /* public static void main(String[] args) {
        int num = 4;        //Aquí se le asigna un valor int a num
        newNumber(5);       //aquí llama al metodo estatica, pasandole 5 como parametro
        System.out.println(num);     // 4       //imprime 4, porque no se modificó el valor de la variable num
    }
    public static void newNumber(int num) {     //es pura coincidencia que coloque num acá también, puede el cualquier otro nombre.
        num = 8;    //aquí se le cambia el valor al parametro.
    } */

    //Aunque este parámetro tiene el mismo nombre que la variable, esto es una coincidencia.
    //El nombre podría ser cualquier cosa. En los exámenes, a menudo se usa el mismo nombre para intentar confundirte.

    //otro ejemplo:
    /* public static void main(String[] args) {
        String name = "Webby";
        speak(name);
        System.out.println(name);   //imprime Webby
    }
    public static void speak(String name) {
        name = "Sparky";
    } */

    //tanto main.name como speaksname apuntabann al mismo objeto.
    //pero luego name ahora apuntaba a otro objeto String con valor Sparky, entonces, ahora la variable name y la copia (speak.name)
    //apuntan a objetos diferentes.

    //Al igual que en el ejemplo primitivo, la asignación de la variable es solo para el parámetro del método y no afecta al que llama.
    //Reasignar una variable dentro de un método (param = nuevoValor) NUNCA afecta a la variable de afuera,
    //sin importar si es String, objeto mutable, lo que sea. Solo cambia a qué apunta esa copia local.

    //Cuando speak termina: Esa variable local name (la de adentro del método) se destruye — desaparece del stack. 
    //Solo existía mientras el método se ejecutaba.


    //OTRO EJEMPLO:
    /* public static void main(String[] args) {
        StringBuilder name = new StringBuilder();
        speak(name);
        System.out.println(name); // Webby
    }
    public static void speak(StringBuilder s) {
        s.append("Webby");
    } */

    //AHORA SÍ IMPRIME Weeby y no algo vacío, porque STRINGBUILDER ES UN OBJETO MUTABLE, Y SE ESTÁ CAMBIANDO EL VALOR CON EL APPEND.
    //tanto main.name como speak.s apuntan al mismo objeto. por ello al agregar con el append, se cambia el valor del objeto.

    /* =======================================
        PASO POR VALOR VS PASO POR REFERENCIA
       ======================================= */
    
    /* public static void main(String[] args) {
        int original1 = 1;
        int original2 = 2;
        swap(original1, original2);
        System.out.println(original1);      //1
        System.out.println(original2);      //2
    }
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    } */

    //COMO YA VIMOS ANTERIORMENTE, LO QUE SE LE PASA ES SOLAMENTE EL VALOR, MÁS NO LA REFERENCIA. ENTONCES, original1 y original2
    //VAN A SEGUIR TENIENDO EL MISMO VALOR DE CUANDO FUERON INICIALIZADOS

    //POR REFERENCIA NO SE VA VER.

    //EJEMPLO:
    public class ReturningValues {
        public static void main(String[] args) {
        int number = 1;                           // 1
        String letters = "abc";                   // abc
        number(number);                           // 1
        letters = letters(letters);               // abcd
        System.out.println(number + letters);     // 1abcd
        }
        public static int number(int number) {
            number++;
            return number;
        }
        public static String letters(String letters) {
            letters += "d";
            return letters;
        }
    }

    //ESTE EJEMPLO ES FACIL, SE LES PASA LOS VALORES A LOS MÉTODOS, ESO ESTÁ CLARO, PERO AHORA HAY QUE TENER EN CUENTA QUE SE ESTÁ
    //RETORNANDO VALORES DE ESOS METODOS, PARA LOS CUALES. EN EL LLAMADO AL PRIMER METODO, NO SE LE ASIGNA NINGUN VARIABLE.
    //ENTONCES EL VALOR DE RETORNO DE ESE METODO MUERE AHÍ. SIN EMBARGO EN EL LLAMADO DEL OTRO METODO, AHÍ SÍ LO GUARDAN EN UNA VARIABLE
    //QUE ES JUSTO LA VARIABLE LETTERS, EL METODO HACE SUS OPERACIONES CON EL VALOR, RETORNA OTRO VALOR Y LO ASIGNA A LETTERS.
    //CAMBIANDO AHORA SÍ EL VALOR DE LETTERS. Y POR ELLO AL IMPRIMIR number + letters AHORA LA RESPUESTA ES:  1abcd.
}
