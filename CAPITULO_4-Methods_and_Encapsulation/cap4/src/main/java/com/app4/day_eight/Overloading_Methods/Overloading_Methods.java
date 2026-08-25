package com.app4.day_eight.Overloading_Methods;

public class Overloading_Methods {
    //La sobrecarga de métodos ocurre cuando hay diferentes firmas de métodos con el mismo nombre pero con distintos tipos de parámetros. 
    //La sobrecarga también permite tener diferentes cantidades de parámetros.
    //Todo lo demás que no sea la firma del método puede variar en los métodos sobrecargados.
    //Esto significa que pueden tener distintos modificadores de acceso, especificadores (como static),
    //tipos de retorno y listas de excepciones. Todos estos son métodos sobrecargados válidos:

    public void fly(int numMiles) { }
    public void fly(short numFeet) { }
    public boolean fly() { return false; }
    void fly(int numMiles, short numFeet) { }
    public void fly(short numFeet, int numMiles) throws Exception { }

    // Podemos tener un tipo diferente, más tipos, o los mismos tipos en un orden distinto.
    // También fíjate que el modificador de acceso y la lista de excepciones son irrelevantes para la sobrecarga.

    //Lo siguiente no es válido:

    /* public void fly(int numMiles) { }
    public int fly(int numMiles) { }     // NO COMPILA */

    //Este método no compila porque SOLO DIFIERE DEL ORIGINAL POR EL TIPO DE RETORNO
    //LA LISTA DE PARAMETROS SON IGUALES, así que son métodos duplicados según Java.

    //Porque Java identifica un método por su firma (signature), y la firma se compone de:
    //El nombre del método
    //Los tipos de los parámetros (en orden)

    //SI LOS METODOS TIENEN IGUAL EL NOMBRE Y LOS PARAMETROS (CON EL MISMO ORDEN), NO VA COMPILAR.

    /* public void fly(int numMiles) { }
    public static void fly(int numMiles) { }     // NO COMPILARÁ. PORQUE AQUÍ TIENEN EL MISMO NOMBRE Y EL MISMO PARAMETRO (int) */

    //TENER CUIDADO, PORQUE A PESAR QUE TIENEN NOMBRES DE PARAMETROS DIFERENTES, AMBOS SON DEL TIPO INT, POR LO TANTO, SON IGUALES.
    //LOS TIPOS DE RETORNO NO IMPORTAN QUE SEAN IGUAL O DIFERENTES.

    //LLAMAR A LOS METODOS SOBRECARGADOS ES FACIL, SOLO SE DEBE PASAR LOS PARAMETROS Y JAVA SE ENCARGA DE IDENTIFICAR A CUAL MÉTODO SE REFIERE.

    /* public void fly(int numMiles) {
        System.out.println("short");
    }
    public void fly(short numFeet) {
        System.out.println("short");
    } */

    //La llamada fly((short) 1); imprime short. Busca tipos que coincidan y llama al método apropiado.

    public static void main(String[] args) {
        Overloading_Methods overloading_Methods = new Overloading_Methods();
        overloading_Methods.Overloading_and_Varargs();
        overloading_Methods.Autoboxing();
        overloading_Methods.Reference_Types();
        overloading_Methods.Primitives();
        overloading_Methods.Putting_It_All_Together();
    }

    public void Overloading_and_Varargs(){

        //Si llamamos esto:

        /* public void fly(int[] lengths) { }
        public void fly(int... lengths) { }     // NO COMPILA */

        //Recuerda que Java trata los varargs como si fueran un arreglo.
        //Esto significa que la firma del método es la misma para ambos métodos.
        //Como no se nos permite sobrecargar métodos con la misma lista de parámetros, este código no compila.

        //fly(new int[] { 1, 2, 3 });
        //Sin embargo, solo puedes llamar a la versión varargs con parámetros independientes: 
        //fly(1, 2, 3);
    }

    public void Autoboxing(){
        //Se vio como se convierte un int primitivo en un objeto Integer para agregarlo a un ArrayList gracias al autoboxing. 
        //bueno acá tambien funciona eso.

        //public void fly(Integer numMiles) { }

        //Esto significa que llamar a fly(3); llamará al método anterior como se esperaba.

        //Pero en el caso que tengo esto:

        /* public void fly(int numMiles) { }
        public void fly(Integer numMiles) { } */

        //Java coincidirá con la versión int numMiles.
        //Java intenta usar la lista de parámetros más específica que pueda encontrar.
        //Cuando no está presente la versión primitiva int, hará autoboxing. 
    }


    public void Reference_Types(){
        //teniendo en cuenta la regla que java escoge la versión más especifica:
        /* public class ReferenceTypes {
            public void fly(String s) {
                System.out.print("string ");
            }
            public void fly(Object o) {
                System.out.print("object ");
            }
            public static void main(String[] args) {
                ReferenceTypes r = new ReferenceTypes();
                r.fly("test");
                r.fly(56);
            } 
        } */

            //La respuesta es "String Object". 
            //La primera llamada es a un String y encuentra una coincidencia directa.
            //No hay razón para usar la versión Object cuando hay una lista de parámetros String que está esperando ser llamada. 
            //La segunda llamada busca una lista de parámetros int. Cuando no encuentra una, hace auto-boxing a Integer.
            //Como todavía no encuentra una coincidencia, recurre a la versión Object.
    }

    public void Primitives(){
        //Los primitivos funcionan de manera similar a las variables de referencia.
        //Java intenta encontrar el método sobrecargado que coincida de la manera más específica. 
        /* public class Plane {
            public void fly(int i) {
                System.out.print("int ");
            }
            public void fly(long l) {
                System.out.print("long ");
            }
            public static void main(String[] args) {
                Plane p = new Plane();
                p.fly(123);
                p.fly(123L);
            } 
        } */

        //La respuesta es int long. La primera llamada pasa un int y encuentra una coincidencia exacta.
        //La segunda llamada pasa un long y también encuentra una coincidencia exacta

        //Si comentamos el método sobrecargado con la lista de parámetros int,la salida se vuelve long long.
        //A Java no le cuesta llamar a un primitivo más grande.
        //Sin embargo, no lo hará a menos que no se encuentre una mejor coincidencia

        //Ten en cuenta que Java solo puede aceptar tipos más amplios.
        //Un int se puede pasar a un método que toma un parámetro long.
        //Java no convertirá automáticamente a un tipo más estrecho.
        //Si quieres pasar un long a un método que toma un parámetro int,
        //tienes que agregar un cast para decir explícitamente que reducir el tipo está bien.
    }

    public void Putting_It_All_Together(){
        //Juntandolo todo, ahora indicar que sale en este ejemplo:
        /* public class Glider2 {
            public static String glide(String s) {
                return "1";
            }
            public static String glide(String... s) {
                return "2";
            }
            public static String glide(Object o) {
                return "3";
            }
            public static String glide(String s, String t) {
                return "4";
            }
            public static void main(String[] args) {
                System.out.print(glide("a"));       //1
                System.out.print(glide("a", "b"));  //4
                System.out.print(glide("a", "b", "c")); //2     //varags
            }
        } */

        //EL RESULTADO SERÍA 142

        //TENER EN CUENTA QUE POR MUY FLEXIBLE QUE SEA JAVA, SOLO VA HACER UNA CONVERSIÓN:

        /* public class TooManyConversions {
            public static void play(Long l) { }
            public static void play(Long... l) { }
            public static void main(String[] args) {
                play(4);     // NO COMPILA
                play(4L);     // por autoboxing usa el primer metodo
            } 
        } */

        //A Java le gusta convertir el int 4 a un long 4 o a un Integer 4.
        // Pero NO puede manejar la conversión en dos pasos a un long y luego a un Long. (SOLO PUEDE HACER UNA CONVERSION)
        //Si tuviéramos public static void play(Object o) { },
        //funcionaría porque solo sería necesaria una conversión: de int a Integer. Un Integer es un Object
    }
}
