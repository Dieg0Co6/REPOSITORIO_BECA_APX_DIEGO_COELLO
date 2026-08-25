package com.app4.day_eight.Applying_Access_Modifiers;

import java.util.List;

public class Applying_Access_Modifiers {
    
    public static void main(String[] args) {
        //Ya vi que hay cuatro tipos de modificadores de acceso.
        //public, private, proteged y package private (default)

        /*  
            * private                       -> Solo se puede usar el método en la misma clase
            * default (package private)     -> Solamente se puede usar el método en clases que se encuentren en el mismo package
            * protected                     -> Solo se puede usar el método en clases del mismo package y subclases 
            * public                        -> Se puede usar el método en cualquier clase
         */

        Applying_Access_Modifiers applying_Access_Modifiers = new Applying_Access_Modifiers();
        applying_Access_Modifiers.Private_Access();
        applying_Access_Modifiers.Default_Access_Package_Private();
        applying_Access_Modifiers.Protected_Access();
        applying_Access_Modifiers.Public_Access();
        applying_Access_Modifiers.Designing_Static_Methods_and_Fields();
        applying_Access_Modifiers.Calling_a_Static_Variable_or_Method();
        applying_Access_Modifiers.Static_vs_Instance();
        applying_Access_Modifiers.Static_Variables();
        applying_Access_Modifiers.Static_Imports();
        /* new Applying_Access_Modifiers().Static_vs_Instance(); */
    }

    public void Private_Access(){
        // Solo el código dentro de la misma clase puede llamar a métodos privados o acceder a campos privados. EJM:

        /* package pond.duck;

        public class FatherDuck {
            private String noise = "quack";
            private void quack() {  // se declara el metodo private quack
                System.out.println(noise); // el acceso de la variable de referencia noise es private, está bien.
            }
            private void makeNoise() {
                quack();                    // private access is ok
            } 
        } */

        // Ahora en otra clase:

        /* package pond.duck;
        public class BadDuckling {
            public void makeNoise() {
            FatherDuck duck = new FatherDuck();
            duck.quack();                       // NO COMPILA PORQUE ESTÁ QUE LLAMA UN METODO PRIVADO
            System.out.println(duck.noise);     // NO COMPILA PORQUE ESTÁ QUE LLAMA UNA VARIABLE DE TIPO PRIVADO
            }
        } */
    }

    public void Default_Access_Package_Private(){
        //Cuando no hay un modificador de acceso, Java usa el predeterminado, que es acceso privado al paquete.
        //Esto significa que el miembro es “privado” para las clases del mismo paquete.
        //En otras palabras, solo las clases del paquete pueden acceder a él. EJM:

        /* package pond.duck;
        public class MotherDuck {
            String noise = "quack";     //variable con package-private
            void quack() {      //metodo con package-private
                System.out.println(noise);     // si se puede usar la variable noise
            }
            private void makeNoise() {      //metodo privado
                quack();                    // Sí se puede usar el metodo quack
            }
        } */

        //Ahora en otra clase que se encuentra en el mismo package duck:

        /* package pond.duck;
        public class GoodDuckling {
            public void makeNoise() {       //se declara el metodo public makeNoise
                MotherDuck duck = new MotherDuck();     //Se instancia un objeto de la clase MotherDuck
                duck.quack();                         // Sí se puede acceder a ese método
                System.out.println(duck.noise);          // También se puede acceder a la variable noise
            } 
        } */

        //Ahora, en otro package tengo la siguiente clase:

        /* package pond.swan;
        import pond.duck.MotherDuck;          // import otro package
        public class BadCygnet {
            public void makeNoise() {
                MotherDuck duck = new MotherDuck();     //instanciamos el objeto de tipo MotherDuck
                duck.quack();                       // NO COMPILA, YA QUE SE ENCUENTRA EN OTRO PACKAGE
                System.out.println(duck.noise);     // TAMPOCO COMPILA, YA QUE ESTÁ INTENTANDO USAR UNA VARIABLE DE OTRO PACKAGE   
            } 
        } */
    }

    public void Protected_Access(){
        //El modificador de acceso protegido agrega la capacidad de acceder a los miembros de una clase padre.
        //Es decir, la variable o método va poder utilizarse en clases del mismo package y también subclases
        //que pueden encontrarse incluso en otros packages.

        //EJM:
        /* package pond.shore;
        public class Bird {
            protected String text = "floating";          // Se declaran los accesos protected
            protected void floatInWater() {               // Se declaran los accesos protected
                System.out.println(text);
            } 
        } */
        
        //AHORA, TAMBIÉN TENEMOS UNA SUBCLASE, QUE SE ENCUENTRA EN OTRO PACKAGE:
        /* package pond.goose;
        import pond.shore.Bird;               // DIFERENTE PACKAGE
        public class Gosling extends Bird {     // extiende de la clase padre (Gosling clase hija o subclase)
            public void swim() {
                floatInWater();               // llama al metodo floatWater() y está bien por tener el acceso protected
                System.out.println(text);     // llama a la variable protected text, lo cual está bien.
            } 
        } */

        //TENER EN CUENTA QUE EL MODIFICADOR DE ACCESO PROTECTED TAMBIÉN PUEDE HACER LO DE DEFAULT ACCESS, ES DECIR,
        //PUEDE USAR LOS METODOS PROTECTED EN CLASES DEL MISMO PACKAGE.

        /* package pond.shore;                    // esta clase se encuentra en el mismo package que Bird
        public class BirdWatcher {
            public void watchBird() {
                Bird bird = new Bird();             //Se instancia el objeto de tipo Bird
                bird.floatInWater();               // accede al método protected floatInWater, esto está bien
                System.out.println(bird.text);     // accede a la variable de referencia protected, esto está bien
            }
        } */
        
        //Pero ahora, tener cuidado con clases que no sean subclases de la clase padre. (da error si está en otra package)

        /* package pond.inland;
        import pond.shore.Bird;               // diferente package de la clase Bird
        public class BirdWatcherFromAfar {
            public void watchBird() {
                Bird bird = new Bird();
                bird.floatInWater();               // No compila porque no es una subclase de Bird y está en otro package
                System.out.println(bird.text);     // No compila porque no es una subclase de Bird y está en otro package
            } 
        } */

        //Solo las subclases y las clases en el mismo paquete pueden acceder a los miembros protegidos.

        //Ejmplo:
        /* package pond.swan;
        import pond.shore.Bird;     // diferente package
        public class Swan extends Bird {     // es subclase de bird
            public void swim() {
                floatInWater();               // Sí tiene acceso por ser subclase de Bird
                System.out.println(text);     // Sí tiene acceso por ser subclase de Bird
            }
            public void helpOtherSwanSwim() {
                Swan other = new Swan();
                other.floatInWater();          // Sí tiene acceso por ser subclase de Bird
                System.out.println(other.text); // Sí tiene acceso por ser subclase de Bird
            }
            public void helpOtherBirdSwim() {
                Bird other = new Bird();
                other.floatInWater();               // NO COMPILA PORQUE ESTÁ INSTANCIANDO UN OBJETO BIRD
                System.out.println(other.text);      // NO COMPILA PORQUE ESTÁ INSTANCIANDO UN OBJETO BIRD
            } 
        } */

        //SOLAMENTE SE PUEDE UTILZIAR LOS METODOS Y VARIABLES PROTECTED, INSTANCIANDO LA MISMA SUBCLASES O UNA SUBCLASE
        //DE LA SUBCLASE.
        //NO SE PUEDE UTILIZAR LOS METODOS Y VARIABLES PROTECTED INSTANCIANDO EL OBJETO DE LA CLASE PADRE.
        //TIENE QUE SE INSTANCIADO DESDE LA MISMA SUBCLASE. OTRO EJEMPLO:

        /* package pond.goose;
        import pond.shore.Bird;     //importa otro package
        public class Goose extends Bird {   //extiende de Bird (estamos en una subclase de Bird)
        public void helpGooseSwim() {
            Goose other = new Goose();
            other.floatInWater();    //Esto está bien, está usando el metodo protected instanciando un objeto de la subclase
            System.out.println(other.text); //esto está bien, está usando la variable instanciando un objeto de la subclase
        }
        public void helpOtherGooseSwim() {
            Bird other = new Goose();      //Instancia un objeto de la clase Padre
            other.floatInWater(); // No compila porque está usando el metodo protected desde el objeto de la clase padre
            System.out.println(other.text); // No compila porque está usando la variable protected desde el objeto de la clase padre
        } } */

        //Bird no es una subclase de Bird

        /* package pond.duck;
        import pond.goose.Goose;        //se importa desde otro package
        public class GooseWatcher {
            public void watch() {       //metodo watch
                Goose goose = new Goose();  //Se instancia el objeto de la clase Goose
                goose.floatInWater();     //Este código no se compila porque no estamos en la clase Goose.
            }
        } */

        //El método floatInWater() está declarado en Bird.
        //GooseWatcher no está en el mismo paquete que Bird, ni extiende Bird.
        //Goose extiende Bird. Eso solo permite que Goose se refiera a floatInWater() y no a los llamadores de Goose.
    }

    public void Public_Access(){
        //Public significa que cualquier persona puede acceder al miembro desde cualquier lugar.

        /* package pond.duck;
        public class DuckTeacher {
            public String name = "helpful";     // public access
            public void swim() {               // public access
                System.out.println("swim");
            } 
        }

        //EN OTRO PACKAGE:
        package pond.goose;
        import pond.duck.DuckTeacher;
        public class LostDuckling {
            public void swim() {
                DuckTeacher teacher = new DuckTeacher();
                teacher.swim();                                   // sí permite usar el metodo
                System.out.println("Thanks" + teacher.name);     // sí permite usar la variable
            } 
        } */
    }

    public void Designing_Static_Methods_and_Fields(){
        //TODOS LOS MÉTODOS QUE HE ESTADO VIENDO ERA MÉTODOS DE INSTANCIA, A EXCEPCIÓN DEL MÉTODO MAIN.
        //Los métodos estáticos no requieren una instancia de la clase.
        //Se comparten entre todos los usuarios de la clase.

        //El código del método se guarda UNA sola vez en memoria, sin importar cuántos objetos crees.

        //El método main() es un método estático. Eso significa que puedes llamarlo por el nombre de la clase.
        //NO SE USA MEDIANTE LA INSTANCIACIÓN DE UN OBJETO.

        /* public class Koala {
            public static int count = 0;               // variable estatica
            public static void main(String[] args) {      // método estatico
                System.out.println(count);
            }
        } */

        //JVM BASICAMENTE LLAMA A Koala.main() para iniciar el programa.Para llamarlo tenemos el siguiente ejemplo. EJM:

        /* public class KoalaTester {
            public static void main(String[] args) {
                Koala.main(new String[0]);          // llamada al método estático main de la clase Koala
            }
        } */

        /* LOS MÉTODOS ESTÁTICOS TIENEN ESTOS DOS PROPÓSITOS PRINCIPALES:
            * Para métodos de utilidad o ayudantes que no requieren estado del objeto.
            * Para el estado que se comparte entre todas las instancias de una clase, como un contador. 
        */
    }

    public void Calling_a_Static_Variable_or_Method(){
        //Para llamar a un método estático solo se tiene que llamar a la clase, seguida de un punto y el método estático.
        //Ejm:
        /* System.out.println(Koala.count);
        Koala.main(new String[0]); */


        //TENER EN CUENTA QUE:
        //sÍ SE PUEDE usar una instancia del objeto para llamar a un método estático.
        //FUNCIONA PARA VARIABLES Y MÉTODOS
        //EL COMPILADOR VERIFICA EL TIPO DE LA REFERENCIA Y USA ESO EN LUGAR DEL OBJETO. EJM:

        /* Koala k = new Koala();
        System.out.println(k.count);          // k es Koala
        k = null;
        System.out.println(k.count);          // k sigue siendo un Koala */


        //En tiempo de compilación Java mira el tipo declarado de k (que es Koala) (no en tiempo de ejecución.)
        //Traduce internamente k.count a Koala.count
        //Java no necesita que k tenga un objeto real, porque count es de la clase, no del objeto. Por eso funciona aunque k sea null

        //TENER CUIDADO: FIJARSE BIEN DEL TIPO DE REFERENCIA DE UNA VARIABLE CUANDO SE VEA UNA VARIABLE O MÉTODO ESTÁTICO.
        //Los creadores del examen intentarán engañarte haciéndote pensar que se lanza un NullPointerException porque la variable
        //resulta ser nula. EJM:

        /* Koala.count = 4;
        Koala koala1 = new Koala();
        Koala koala2 = new Koala();
        koala1.count = 6;
        koala2.count = 5;
        System.out.println(Koala.count);        //DA EL RESULTADO DE 5, Solo hay una variable count ya que es estática. */
    }

    public void Static_vs_Instance(){
        //HAY OTRA FORMA EN LA QUE LOS CREADORES DEL EXAMEN PUEDEN TRATAR DE ENGAÑAR.

        //RECORDAR QUE: “miembro” significa campo o método.
        //Un miembro estático no puede llamar a un miembro de instancia. EJM:

        /* public class Static {
            private String name = "Static class";
            public static void first() {  }
            public static void second() {  }
            public void third(){  
                System.out.println(name); 
            }
            public static void main(String args[]) {
                first();
                second();
                third();          // DOES NOT COMPILE
            } 
        } */

        //Lo siguiente NO COMPILA, ya que el método third() no tiene la palabra static. y al colocarla también tendriamos que hacer
        //que la variable name sea static, sino ese sería el nuevo problema.

        //Otra solución sería llamar a third como un método de instancia
        //por ejemplo, new Static().third() o new Applying_Access_Modifiers().Static_vs_Instance();;

        //Un método estático o un método de instancia puede llamar a un método estático porque
        //los métodos estáticos no requieren un objeto para usarse.

        //Solo un método de instancia puede llamar a otro método de instancia en la misma clase sin usar una variable
        //de referencia, porque los métodos de instancia sí requieren un objeto. 

        //===================================================================================================================
        //EN POCAS PALABRAS, UN METODO DE INSTANCIA SI PUEDE LLAMAR A UN METODO O VARIABLE ESTÁTICA. PERO UN MÉTODO ESTATICO
        //NO PUEDE LLAMAR A UN MÉTODO O VARIABLE DE INSTANCIA (SOLO PUEDE LLAMARLO UN MÉTODO DE INSTANCIA.)
        //===================================================================================================================


        /* public class Gorilla {
            public static int count;        //variable estatica
            public static void addGorilla() { count++; }        //metodo estatico
            public void babyGorilla() { count++; }  //metodo de instancia si puede usar variable o metodo estatico
            public void announceBabies() {
                addGorilla();   //metodo de instancia si puede usar variable o metodo estatico
                babyGorilla();  //metodo de instancia si puede usar variable o metodo de referencia
            }
            public static void announceBabiesToEveryone() { //metodo estatico
                addGorilla();       //metodo estatico sí puede llamar a un metodo estático
                babyGorilla();     //metodo estático no puede llamar a un método de instancia. NO COMPILA
            }
            public int total;       //VARIABLE DE INSTANCIA
            public static average = total / count;  //variable estática no puede usar una variable de instancia en su expresión. NO COMPILA
        } */

        //OTRO EJEMPLO

        /* public class Counter {
            private static int count;   //variable estática
            public Counter() { count++; }   //constructor
            public static void main(String[] args) {        //método estatico main
                Counter c1 = new Counter();     //Cada vez que se llama al constructor, incrementa count en 1
                Counter c2 = new Counter();
                Counter c3 = new Counter();
                System.out.println(count);          // 3
            }
        } */
    }

    public void Static_Variables(){
        //Algunas variables estáticas están destinadas a cambiar mientras el programa se ejecuta.
        //Los contadores son un ejemplo común de esto. Queremos que el conteo aumente con el tiempo.
        // Al igual que con las variables de instancia, se puede inicializar una variable estática en la línea en que se declara:

        /* public class Initializers {
            private static int counter = 0;          // inicialización de la variable estática en 0
        } */

        //Otras variables estáticas están pensadas para nunca cambiar durante el programa.
        //Este tipo de variable se conoce como CONSTANTE.
        //Usa el modificador FINAL para asegurar que la variable nunca cambie.
        //Las constantes estáticas finales usan una convención de nombres diferente a otras variables.
        //Usan todas letras MAYUSCULAS con guiones bajos entre las “palabras”. ejm:

        /* public class Initializers {
            private static final int NUM_BUCKETS = 45;  //CONSTANTE
            public static void main(String[] args) {
                NUM_BUCKETS = 5;  // NO COMPILA, YA QUE SE LE INDICÓ QUE SEA UNA CONSTANTE, POR EL MODIFICADOR FINAL.
            }
        } */

        //El compilador se asegurará de que no intentes actualizar accidentalmente una variable final.

        /* private static final ArrayList<String> values = new ArrayList<>();
        public static void main(String[] args) {
            values.add("changed");      //SÍ COMPILA
        } */

        //final significa: "la variable values NO puede volver a apuntar a otro objeto". Eso es TODO lo que final controla.
        //Esto NO está cambiando a qué objeto apunta values. values sigue apuntando al mismo ArrayList de siempre.
        //Solo estás modificando el contenido de ese objeto.
    }

    public void Static_Initialization(){
        //Antes había visto los inicializadores de instancia que eran un bloque de codigo dentro de llaves.
        //Los inicializadores estáticos se ven similares.
        //Se les añade la palabra clave static para especificar que deben ejecutarse cuando la clase se usa por primera vez

        //SI LA VARIABLE ES STATIC, ESTONCES EL BLOQUE INICIALIZADOR TAMBIÉN DEBE DECIR STATIC, SI SOLO COLOCAS LAS LLAVES DE INICIALIZACIÓN
        //NO COMPILARÁ

        /* private static final int NUM_SECONDS_PER_HOUR;
        static {
            int numSecondsPerMinute = 60;
            int numMinutesPerHour = 60;
            NUM_SECONDS_PER_HOUR = numSecondsPerMinute * numMinutesPerHour;
        } */

        //El inicializador estático se EJECUTA CUANDO LA CLASE SE USA POR PRIMERA VEZ
        //Las declaraciones en él se ejecutan y asignan cualquier variable estática según sea necesario.

        /* private static int one;     //variable estática
        private static final int two;   //variable estática final - CONSTANTE
        private static final int three = 3;     //variable estática final - INICIALIZADA
        private static final int four;     //NO COMPILA, YA QUE NO SE INICIALIZÓ EN TODO EL CÓDIGO, COMO NO TIENE VALOR, NO COMPILA
        static {
          one = 1;      //SE INICIALIZA A 1 APENAS SE EJECUTA LA CLASE
          two = 2;      //ESTO TAMBIEN ESTÁ BIEN, SE INICIALIZA POR PRIMERA VEZ LA CONSTANTE. YA NO PUEDE CAMBIAR ESE VALOR.
          three = 3;     // NO COMPILA, YA QUE ESTÁ QUE VUELVE A ASIGNAR LA CONSTANTE QUE YA HA SIDO INICIALIZADA.
          two = 4;     // NO COMPILA TAMBIEN POR LO MISMO QUE SE VUELVE A ASIGNAR UNA CONSTANTE INICIALIZADA.
        } */


        //Todo lo que se podría hacer en un inicializador de instancia se podría hacer en un constructor en su lugar.
        //El enfoque del constructor es más fácil de leer.

        //Cuando necesites usar un inicializador estático, pon toda la inicialización estática en el mismo bloque.
    }

    public void Static_Imports(){
        //Anteriormente se vio que se podía ahcer esto en cuanto a las importaciones:
        /* import java.util.ArrayList;
        import java.util.*; */
        //Otro ejemplo
        /* import java.util.List;
        import java.util.Arrays;
        public class Imports {
        public static void main(String[] args) {
            List<String> list = Arrays.asList("one", "two");
        }
        }   */

        //Hay otro tipo de importación llamada importación estática.
        //Las importaciones normales son para importar clases.
        //Las importaciones estáticas son para importar miembros estáticos de las clases.
        //Al igual que las importaciones normales, puedes usar un comodín o importar un miembro específico.
        //La idea es que no deberías tener que especificar de dónde viene cada método o variable estática cada vez que lo usas.
        
        /* import java.util.List;
        import static java.util.Arrays.asList;          // Importación Estatica (acá se importan los miembros)
        public class StaticImports {
            public static void main(String[] args) {
                List<String> list = asList("one", "two");     // ya no se coloca la clase Arrays, sino solamente el mimebro estático.
            } 
        } */

        //En este ejemplo, estamos importando específicamente el método asList.
        //Esto significa que cada vez que nos refiramos a asList en la clase, se llamará a Arrays.asList().

        //CUIDADO CON EL MAL USO DE LOS IMPORTS ESTÁTICOS.
        /* import static java.util.Arrays; // NO COMPILA - las importaciones estáticas son solo para importar miembros estáticos
        import static java.util.Arrays.asList;
        static import java.util.Arrays.*;  // NO COMPILA - La sintaxis es import static y no al revés.
        public class BadStaticImports {
            public static void main(String[] args) {
            Arrays.asList("one");  // NO COMPILA PORQUE IMPORTAMOS asList("one"), pero no se importó la clase Arrays.
            }
        } */

        //LA PRIMERA LÍNEA INTENTA USAR UNA IMPORTACIÓN ESTÁTICA PARA IMPORTAR UNA CLASE
        //La otra linea trata de ver si estás prestando atención al orden de las palabras clave. 
        //Luego en la otra linea que no compila. Importamos el método asList.
        //Sin embargo, no importamos la clase Arrays en ningún lado.
        //Esto hace que esté bien escribir asList("one"); pero no Arrays.asList("one");.

        //============================================================================================
        //RECORDAR QUE:
        //Importar dos clases con el mismo nombre da un error de compilador.
        //Esto también es cierto para las importaciones estáticas.
        //El compilador se quejará si intentas hacer explícitamente una importación estática de dos
        //métodos con el mismo nombre o dos variables estáticas con el mismo nombre.
        //============================================================================================

        /* import static statics.A.TYPE; //Este si lo toma, porque es el primero
        import static statics.B.TYPE; //NO COMPILA PORQUE YA HAY OTRA IMPORTACIÓN, EN EL QUE IMPORTAN UN MIEMBRO ESTATICO CON EL MISMO NOMBRE */
        
        //Para solucionar esta ambiguedad, podemos importar simplemente la clase donde se encuentra el miembro estático.
    }
}
