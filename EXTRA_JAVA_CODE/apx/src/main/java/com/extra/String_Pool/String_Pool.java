package com.extra.String_Pool;

public class String_Pool {

    public static void main(String[] args) {

        // Los literales van al String Pool (JVM reutiliza el mismo objeto)
        var x = "Hello World";
        var y = "Hello World";
        System.out.println(x == y); // true -> misma referencia en el pool

        // trim(), concat(), o cualquier método -> se calcula en runtime, NO usa el pool
        var x2 = "Hello World";
        var z = " Hello World".trim();
        System.out.println(x2 == z); // false -> z se crea en tiempo de ejecución

        // += en Strings equivale a un método -> crea un objeto NUEVO, no usa el pool
        var singleString = "hello world";
        var concat = "hello ";
        concat += "world";
        System.out.println(singleString == concat); // false

        // new String(...) SIEMPRE crea un objeto nuevo, ignora el pool a propósito
        var x3 = "Hello World";
        var y3 = new String("Hello World");
        System.out.println(x3 == y3); // false

        // intern() busca (o agrega) el String en el pool y devuelve esa referencia
        var name = "Hello World";
        var name2 = new String("Hello World").intern();
        System.out.println(name == name2); // true -> ahora sí apuntan al mismo lugar

        // Concatenación de literales/constantes en tiempo de COMPILACIÓN -> va al pool
        var first = "rat" + 1; // "rat1" -> compile-time constant
        var second = "r" + "a" + "t" + "1"; // también compile-time constant
        System.out.println(first == second); // true -> mismo pool

        // intern() sobre algo que YA es del pool no cambia nada
        System.out.println(first == second.intern()); // true

        // Si en la concatenación aparece new String(...), deja de ser compile-time
        // constant -> NO va al pool
        var third = "r" + "a" + "t" + new String("1");
        System.out.println(first == third); // false

        // pero con intern() explícito, sí lo comparamos contra el pool y coincide
        System.out.println(first == third.intern()); // true

        // REGLA DE ORO: nunca usar == ni intern() en código real, solo se pregunta en
        // examen
    }
}
