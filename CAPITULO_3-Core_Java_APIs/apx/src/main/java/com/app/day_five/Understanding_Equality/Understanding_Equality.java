package main.java.com.app.day_five.Understanding_Equality;

public class Understanding_Equality {
    public static void main(String[] args) {
        
        StringBuilder one = new StringBuilder();        //Se instancia a un objeto StringBuilder
        StringBuilder two = new StringBuilder();        //Se instancia a OTRO objeto StringBuilder
        StringBuilder three = one.append("a");     //Cambia valor del primer objeto, ahora valor "a" y se le asigna a three
        System.out.println(one == two); // false        //Son dos referencias que apuntan a distintos objetos
        System.out.println(one == three); // true       //Son dos referencias que apuntan al mismo objeto

        String x = "Hello World"; //Se crea un objeto String
        String y = "Hello World"; //COMO YA HAY UN OBJETO CREADO CON ESE VALOR.Es el mismo objeto porque tienen el mismo valor literal
        System.out.println(x == y); //true

        String x1 = "Hello World";         //Se crea un objeto String con valor Hello World
        String z1 = " Hello World".trim();  //Al utilizar este método, ya no se considera un literal, ya no está en el Strin Pool
                                            //Entonces se vuelve otro objeto.
        System.out.println(x1 == z1);       //false

        //No tenemos dos literales de String iguales.
        //Aunque x y z resultan ser la misma cadena, una se calcula en tiempo de ejecución.
        //Como no es la misma en tiempo de compilación, se crea un nuevo objeto String.

        String x2 = new String("Hello World"); //Se crea un objeto String con valor Hello World. Usando el new no va al String Pool
        String y2 = "Hello World";                      //Este es otro objeto con valor literal
        System.out.println(x2 == y2);       //false


        //La lección es nunca usar == para comparar objetos String.
        // La única vez que deberías lidiar con == para Strings es en el examen.

        String x3 = "Hello World";         //objeto String con valor Hello World
        String z3 = " Hello World".trim();  //otro objeto que no está en el String Pool con valor " Hello World"
        System.out.println(x3.equals(z3));  //true. AQUÍ NO COMPARA OBJETOS, SINO COMPARA VALORES. Y LOS VALORES SON IGUALES.

        //TENER SIEMPRE EN CUENTA QUE EL EQUALS FUNCIONA EN STRING.
        //Si llamas a equals() en dos instancias de StringBuilder, va a revisar la igualdad de referencias.
        public class Tiger {
            String name;
            public static void main(String[] args) {
                Tiger t1 = new Tiger();
                Tiger t2 = new Tiger();
                Tiger t3 = t1;
                System.out.println(t1 == t1); // true   //AMBAS REFERENCIAS APUNTAN AL MISMO OBJETO
                System.out.println(t1 == t2); // false  //LAS REFERENCIAS APUNTAN A DISTINTOS OBJETOS
                System.out.println(t1.equals(t2)); // false     //TIGER NO IMPLEMENTA EQUALS
            }
        }

        //LA ULTIMA DA FALSE, PORQUE equals(), no se encuentra sobreescrito en la clase Tiger.
        // Tiger no define su propio método equals()
        //Y como no se encuentra sobreescrito
        //UTILIZA EL equals() DE LA CLASE OBJECT. En la cual, este método de Object, equals(),simplemente hace lo mismo 
        //que == , es decir compara si son la misma referencia, el mismo objeto en memoria. POR ELLO DA FALSE.
    }
    
}
