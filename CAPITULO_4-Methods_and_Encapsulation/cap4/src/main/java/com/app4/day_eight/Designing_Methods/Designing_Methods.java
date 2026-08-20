package com.app4.day_eight.Designing_Methods;

public class Designing_Methods {

    public static void main(String[] args) {
        
        /*
                Element                                 Value in nap() example              Required?
            * Modificador de acceso                 public / private / protected                NO
            * Especificador opcional                final / static / abstract                   NO
            * Tipo de retorno                       void/ int/ String / List                    YES
            * Nombre de método                      (hay con excepciones)                       YES
            * Paréntesis                                    (   )                               YES 
            * Lista de parámetros                       (int minutes)             YES, pero pueden ser paréntesis vacíos
            * Lista de excepciones opcional         throws InterruptedException                 NO
            * Method body                                  {  //     }            YES, pero pueden ser llaves vacías            
        */

        //EJMPLO:

        /* public final void nap(int minutes) throws InterruptedException {
                //

        } */
        
        // Y para llamar al método, en este caso se tiene que hacer esto: nap(10)

        Designing_Methods designing_Methods = new Designing_Methods();
        designing_Methods.Return_Type();
        designing_Methods.Method_Name();
        designing_Methods.Parameter_List();
        designing_Methods.Optional_Exception_List();
        designing_Methods.Method_Body();
    }

    public void Return_Type(){
        //El tipo de retorno podría ser un tipo de Java real como String o int.
        //Si no hay tipo de retorno, se usa la palabra clave void.
        //Este tipo de retorno especial viene del idioma inglés: void significa sin contenido.

        //EL TIPO DE RETORNO ES OBLIGATORIO, SI ES QUE NO SE QUIERE RETORNAR NADA ENTONCES COLOCAR VOID.
        //Los métodos con un tipo de retorno diferente a void deben tener una sentencia return dentro del cuerpo del método.
        //Esta sentencia return debe incluir el valor primitivo u objeto que se va a retornar.

        /* public void walk1() { }        //está bien la sintaxis 
        public void walk2() { return; }         //está bien la sintaxis 
        public String walk3() { return ""; }    //está bien la sintaxis 
        public String walk4() { }  // NO COMPILA PORQUE FALTA EL RETURN CON UN VALOR STRING EN EL BODY
        public walk5() { }  // NO COMPILA PORQUE NO TIENE NINGUN TIPO DE RETORNO
        String walk6(int a) { if (a == 4) return ""; }  //NO COMPILA PORQUE HAY LA POSIBILIDAD DE QUE NO SE RETORNE NADA. */

        //Al devolver un valor, necesita ser asignable al tipo de retorno.

        /* int integer() {
            return 9;       //ESTE SI ESTÁ BIEN
        }
        int long() {
            return 9L; // DOES NOT COMPILE      //NO COMPILA PORQUE TIENE QUE RETORNAR UN INT, NO UN LONG
        } */


        /* int integerExpanded() {
            int temp = 9;    //ESTE SI ESTÁ BIEN
            return temp;
        }

        int longExpanded() {
            int temp = 9L; // DOES NOT COMPILE  //NO COMPILA PORQUE TIENE QUE RETORNAR UN INT, NO UN LONG
            return temp;
        } */
    }

    public void Method_Name(){
        //LOS NOMBRES DE LOS METODOS TIENEN LAS MISMAS REGLAS QUE LOS NOMBRES DE LAS VARIABLES.

        //un identificador solo puede contener letras, números, $, o _.
        //Además, el primer carácter no puede ser un número, y no se permiten palabras reservadas. 

        /* public void walk1() { }
        public void 2walk() { } // NO COMPILA PORQUE EMPIEZA CON NUMERO
        public walk3 void() { } // NO COMPILA PORQUE EL NOMBRE VA DESPUES DEL TIPO DE RETORNO
        public void Walk_$() { }    //SÍ COMPILA
        public void() { } // NO COMPILA PORQUE NO SE HA COLOCADO EL NOMBRE DEL METODO */
    }

    public void Parameter_List(){
        //Aunque se requiere la lista de parámetros, no tiene que contener ningún parámetro.
        //Esto significa que puedes simplemente poner un par de paréntesis vacíos después del nombre del método, como void nap(){}.
        //Si tienes varios parámetros, los separas con una coma.

        /* public void walk1() { } //este está bien
        public void walk2 { } // NO COMPILA PORQUE NO SE HAN COLOCADO LOS PARENTESIS
        public void walk3(int a) { }   //este está bien
        public void walk4(int a; int b) { }  // NO COMPILA PORQUE SE ESTÁ SEPARANDO CON PUNTO Y COMA, Y DEBE SER SOLO COMAS.
        public void walk5(int a, int b) { } //este está bien */
    }

    public void Optional_Exception_List(){
        //El metodo puede indicar que algo salió mal lanzando una excepción.
        //Se puede listar tantos tipos de excepciones como quieras en esta cláusula, separados por comas.
        //Se usa el throws para listar las excepciones

        /* public void zeroExceptions() { }        //este está bien, ya que no tiene exceptions y es opcional
        public void oneException() throws IllegalArgumentException { }      //este está bien
        public void twoExceptions() throws 
        IllegalArgumentException, InterruptedException { }  //este está bien */
    }

    public void Method_Body(){
        //La parte final de una declaración de método es el cuerpo del método (excepto en métodos abstractos e interfaces)
        //Un cuerpo de método es simplemente un bloque de código. Tiene llaves que contienen cero o más sentencias de Java.

        /* public void walk1() { }      //este está bien, ya que puede que no tenga nada en el cuerpo del método
        public void walk2;          // NO COMPILA PORQUE NO HAY EL PAR DE LLAVES QUE ES EL BLOQUE DE CODIGO
        public void walk3(int a) { int name = 5; }      //este está bien */
    }
}
