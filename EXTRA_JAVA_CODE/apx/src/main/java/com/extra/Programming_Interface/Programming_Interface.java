package com.extra.Programming_Interface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Programming_Interface {

    // ============================================================
    // QUÉ ES Supplier
    // ============================================================
    // Supplier<T> es una interfaz funcional que NO recibe nada,
    // y devuelve (produce) un valor de tipo T.
    //
    // Su único método es:
    // T get();
    //
    // Piensa en Supplier como una "fábrica": no le das nada,
    // solo le pides "dame algo" y él te lo entrega.

    public static void main(String[] args) {
        Programming_Interface programming_Interface = new Programming_Interface();
        programming_Interface.supplier();
        programming_Interface.consumer();
        programming_Interface.biConsumer();
        programming_Interface.function();
        programming_Interface.biFunction();

    }

    public void supplier(){

        // ============================================================
        // EJEMPLO 1: Supplier que genera la fecha actual
        // ============================================================
        // LocalDate.now() es un método static que YA existe en Java
        // y devuelve la fecha de hoy. No recibe parámetros -> encaja
        // perfecto con la forma de Supplier (sin input, con output).

        // Forma 1: usando method reference (referencia a método static)
        Supplier<LocalDate> s1 = LocalDate::now;

        // Forma 2: usando lambda (exactamente lo mismo, escrito distinto)
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        // En ambos casos, hasta aquí NO se ha ejecutado nada todavía.
        // Solo estamos GUARDANDO la "receta" de cómo generar el valor.
        // Recién se ejecuta cuando llamamos .get():
        LocalDate d1 = s1.get(); // AHORA sí se llama LocalDate.now()
        LocalDate d2 = s2.get(); // AHORA sí se llama LocalDate.now()

        System.out.println(d1); // ejemplo: 2022-02-20
        System.out.println(d2); // ejemplo: 2022-02-20

        System.out.println("----");

        // ============================================================
        // EJEMPLO 2: Supplier que CREA un objeto nuevo (constructor)
        // ============================================================
        // Igual que con métodos static, también puedes usar un
        // CONSTRUCTOR como Supplier, con la sintaxis Clase::new

        // Forma 1: constructor reference
        Supplier<StringBuilder> s3 = StringBuilder::new;

        // Forma 2: lambda equivalente
        Supplier<StringBuilder> s4 = () -> new StringBuilder();

        System.out.println(s3.get()); // imprime un StringBuilder vacío ""
        System.out.println(s4.get()); // imprime un StringBuilder vacío ""

        System.out.println("----");

        // ============================================================
        // EJEMPLO 3: Supplier de un tipo con GENERICS (el que confunde)
        // ============================================================
        // Aquí hay que leerlo con calma, de afuera hacia adentro:
        //
        // Supplier<ArrayList<String>>
        // ^^^^^^^^ ^^^^^^^^^^^^^^^^^
        // | |
        // | este es el TIPO que produce el Supplier
        // | (una ArrayList de Strings)
        // |
        // es un Supplier normal, solo que lo que "fabrica"
        // es, en sí mismo, otro tipo con generics (ArrayList<String>)
        //
        // O sea: "un Supplier CUYO PRODUCTO es una ArrayList<String>"

        Supplier<ArrayList<String>> s5 = ArrayList::new;

        // al llamar get(), se ejecuta "new ArrayList<String>()"
        ArrayList<String> lista = s5.get();

        System.out.println(lista); // imprime [] (lista vacía recién creada)

        System.out.println("----");

        // ============================================================
        // EJEMPLO 4 (curiosidad): qué pasa si imprimes el Supplier
        // MISMO, en vez de llamar .get()
        // ============================================================
        // s5 es una LAMBDA (o method reference), no un objeto normal.
        // Si haces println(s5) en vez de println(s5.get()),
        // Java llama al toString() por defecto de la lambda, que es
        // solo texto interno sin mucho sentido para nosotros, algo así:
        //
        // SupplierNotas$$Lambda$1/0x0000000800066840@4909b8da
        //
        // Esto pasa porque las lambdas no existen como una "clase" normal
        // en el disco (.class), se generan en memoria en tiempo de
        // ejecución. Para el examen: NO necesitas memorizar ese texto,
        // solo reconocer que imprimir un Supplier sin get() no te da
        // el valor que produce, sino un texto interno feo sin utilidad real.

        System.out.println(s5); // algo como: SupplierNotas$$Lambda$.../0x...@...

        // ============================================================
        // RESUMEN PARA EL EXAMEN
        // ============================================================
        // - Supplier<T> = no recibe nada, produce un T -> método: T get()
        // - Sirve para "generar" o "crear" valores: fechas, objetos nuevos, etc.
        // - Se puede implementar con lambda: () -> algo
        // - Se puede implementar con method reference: Clase::metodoStatic
        // - Se puede implementar con constructor reference: Clase::new
        // - NADA se ejecuta hasta que llamas .get() explícitamente
        // - Supplier<ArrayList<String>> = un Supplier cuyo "producto" es
        // una ArrayList<String>. Léelo de afuera hacia adentro.
    }

    // ================================================================
    // CONSUMER
    // ================================================================
    // Consumer<T> es lo OPUESTO a Supplier: SÍ recibe un parámetro,
    // pero NO devuelve nada (void). Sirve para "hacer algo" con un
    // valor, sin necesitar un resultado de vuelta.
    //
    // Su único método es:
    // void accept(T t);
    //
    // Piensa en Consumer como algo que "consume" (se traga) un valor
    // y hace una acción con él, sin devolverte nada a cambio.

    public void consumer() {

        // Ejemplo típico: imprimir algo es "consumir" ese valor
        // (lo usas, pero no te da ningún resultado de vuelta)

        // Forma 1: method reference a una instancia (System.out)
        Consumer<String> c1 = System.out::println;

        // Forma 2: lambda equivalente
        Consumer<String> c2 = x -> System.out.println(x);

        c1.accept("Annie"); // Annie
        c2.accept("Annie"); // Annie
    }

    // ================================================================
    // BICONSUMER
    // ================================================================
    // BiConsumer<T, U> es exactamente igual a Consumer, PERO recibe
    // DOS parámetros en vez de uno. "Bi" siempre significa "dos"
    // (como en "bicicleta" = dos ruedas).
    //
    // Su único método es:
    // void accept(T t, U u);
    //
    // Los dos tipos (T y U) NO tienen que ser iguales entre sí.
    public void biConsumer() {

        var map = new HashMap<String, Integer>();

        // Forma 1: instance method reference -> map::put
        // (map ya existe como variable local, y put() es su método)
        BiConsumer<String, Integer> b1 = map::put;

        // Forma 2: lambda equivalente, recibe 2 parámetros (k, v)
        BiConsumer<String, Integer> b2 = (k, v) -> map.put(k, v);

        b1.accept("chicken", 7); // equivale a map.put("chicken", 7)
        b2.accept("chick", 1); // equivale a map.put("chick", 1)

        System.out.println(map); // {chicken=7, chick=1}

        // NOTA: T y U pueden ser del MISMO tipo también, por ejemplo
        // BiConsumer<String, String> si ambos parámetros fueran String.
    }

    // ================================================================
    // FUNCTION
    // ================================================================
    // Function<T, R> SÍ recibe un parámetro Y SÍ devuelve un valor,
    // que puede ser de un tipo DIFERENTE al que recibió.
    //
    // T = tipo de ENTRADA
    // R = tipo de SALIDA (return)
    //
    // Su único método es:
    // R apply(T t);
    //
    // Piensa en Function como una "conversión": entra un tipo, sale
    // (potencialmente) otro tipo distinto.
    public void function() {

        // Ejemplo: convertir un String en su longitud (un Integer)
        // Entrada: String -> Salida: Integer

        // Forma 1: method reference a método de instancia (String::length)
        Function<String, Integer> f1 = String::length;

        // Forma 2: lambda equivalente
        Function<String, Integer> f2 = x -> x.length();

        System.out.println(f1.apply("cluck")); // 5
        System.out.println(f2.apply("cluck")); // 5

        // NOTA: técnicamente length() devuelve un "int" primitivo,
        // pero se autoboxea a Integer porque el generic exige un Object.
    }

    // ================================================================
    // BIFUNCTION
    // ================================================================
    // BiFunction<T, U, R> es igual a Function, pero recibe DOS
    // parámetros de entrada en vez de uno.
    //
    // T = tipo del PRIMER parámetro de entrada
    // U = tipo del SEGUNDO parámetro de entrada
    // R = tipo de SALIDA (return)
    //
    // Su único método es:
    // R apply(T t, U u);
    public void biFunction() {

        // Ejemplo: unir dos Strings en uno solo (concat)
        // Entradas: String, String -> Salida: String

        // Forma 1: method reference a método de instancia (String::concat)
        // El PRIMER parámetro es el objeto sobre el que se llama concat(),
        // el SEGUNDO es lo que se le pasa a concat(...)
        BiFunction<String, String, String> bf1 = String::concat;

        // Forma 2: lambda equivalente
        BiFunction<String, String, String> bf2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(bf1.apply("baby ", "chick")); // baby chick
        System.out.println(bf2.apply("baby ", "chick")); // baby chick
    }

    // ================================================================
    // TABLA RESUMEN PARA MEMORIZAR
    // ================================================================
    // Supplier<T> : () -> T (no recibe, sí devuelve)
    // Consumer<T> : (T) -> void (sí recibe, no devuelve)
    // BiConsumer<T, U> : (T, U) -> void (2 entradas, no devuelve)
    // Function<T, R> : (T) -> R (sí recibe, sí devuelve)
    // BiFunction<T, U, R> : (T, U) -> R (2 entradas, sí devuelve)
    //
    // "Bi" = siempre agrega UN parámetro más de entrada. La salida
    // (o falta de ella) se mantiene igual que su versión sin "Bi".
}
