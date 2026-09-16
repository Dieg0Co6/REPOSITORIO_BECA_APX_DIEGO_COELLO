package com.extra.String_Split;

public class String_split {
    //split() es un método de String que divide una cadena en un arreglo de subcadenas usando una expresión regular como delimitador.

    //String[] split(String regex) La cadena no se modifica.

    //split() devuelve un nuevo String[].

    /*
    Example: 
    String value = "123-456-789"; 
    String[] result = value.split("-"); 
    Result: ["123", "456", "789"] 
     */

    //El delimitador - no está incluido en el arreglo resultante.

    //\D :
    //coincide con cualquier carácter que no sea un dígito.

    //String value = "123-456-789"; 
    //String[] result = value.split("\D");
    //da el mismo resultado  Result: ["123", "456", "789"]

    /*
    \d → digit 
    \D → non-digit  
    */

    //"123-456".split("\d") utiliza los dígitos como separadores.

    /*
    * REGLA #1: split() recibe una REGEX (expresión regular), no un texto literal.
    *   "123.456".split(".")   -> "." en regex significa "CUALQUIER carácter"
    *                              Resultado: [""] casi todo se corta mal
    *   "123.456".split("\\.") -> escapado, ahora sí es un punto literal
    *                              Resultado: ["123", "456"]
    *
    * REGLA #2: \d vs \D (la mayúscula/minúscula IMPORTA)
    *   \d = UN dígito     (equivale a [0-9])
    *   \D = UN NO-dígito  (equivale a [^0-9])
    *
    * REGLA #3: split() elimina el delimitador del resultado.
    *   El carácter que hace "match" desaparece, no aparece en el array.
    *
    * REGLA #4: \D (o \d) hace match de UN SOLO carácter a la vez,
    *   NO de una secuencia completa. Si hay varios no-dígitos seguidos,
    *   cada uno actúa como un delimitador separado -> aparecen "" (vacíos)
    *   entre ellos.
    *
    * REGLA #5: split() NO modifica el String original (los Strings son inmutables).
    *   Siempre devuelve un array NUEVO.
    */

public class ResumenSplitRegex {
    public static void main(String[] args) {

        // ---------------------------------------------
        // EJEMPLO 1: \D con un solo separador tipo guion
        // ---------------------------------------------
        String v1 = "123-456";
        String[] r1 = v1.split("\\D"); // \D = no-dígito -> el "-" hace match
        // Resultado: ["123", "456"]  (el "-" se consume, no aparece)
        imprimir("v1.split(\\D)", r1);

        // ---------------------------------------------
        // EJEMPLO 2: \D con VARIOS separadores distintos
        // ---------------------------------------------
        String v2 = "123-456/789:000";
        String[] r2 = v2.split("\\D"); // -, /, : todos son no-dígitos
        // Resultado: ["123", "456", "789", "000"]
        imprimir("v2.split(\\D)", r2);

        // ---------------------------------------------
        // EJEMPLO 3 (TRAMPA DE EXAMEN): \D con LETRAS SEGUIDAS
        // ---------------------------------------------
        String v3 = "123ABC456";
        String[] r3 = v3.split("\\D");
        // OJO: "ABC" NO es un solo delimitador.
        // A, B y C hacen match INDIVIDUALMENTE, uno por uno:
        //   123 [A] [B] [C] 456
        // Como A, B, C son delimitadores consecutivos, quedan "huecos"
        // vacíos entre ellos.
        // Resultado: ["123", "", "", "456"]
        imprimir("v3.split(\\D) - TRAMPA", r3);

        // ---------------------------------------------
        // EJEMPLO 4: \d como delimitador (al revés de lo normal)
        // ---------------------------------------------
        String v4 = "123-456";
        String[] r4 = v4.split("\\d"); // ahora el delimitador es CADA dígito
        // 1 2 3 - 4 5 6  -> cada número individual corta el string
        // Java elimina los "" vacíos SOLO al final del array (trailing),
        // no los del medio.
        // Resultado: ["", "", "", "-", "", ""]  (6 elementos)
        imprimir("v4.split(\\d)", r4);

        // ---------------------------------------------
        // EJEMPLO 5: split(regex, limit) -> limita el N° de elementos
        // ---------------------------------------------
        String v5 = "1-2-3-4";
        String[] r5 = v5.split("-", 2); // limit = 2 -> máximo 2 elementos
        // Solo se aplica el PRIMER delimitador; el resto queda intacto
        // Resultado: ["1", "2-3-4"]
        imprimir("v5.split(\"-\", 2)", r5);

        // ---------------------------------------------
        // EJEMPLO 6: split() NO modifica el String original
        // ---------------------------------------------
        String v6 = "123-456";
        v6.split("\\D"); // se ignora el resultado a propósito
        System.out.println("v6 sigue siendo: " + v6); // "123-456" sin cambios


        // ================================================
        // TABLA MENTAL RÁPIDA PARA EL EXAMEN
        // ================================================
        // \d  -> dígito        (0-9)
        // \D  -> NO dígito     (letras, símbolos, espacios, guiones, etc.)
        // \s  -> espacio en blanco
        // \S  -> NO espacio en blanco
        // .   -> CUALQUIER carácter (hay que escapar \\. para punto literal)
        //
        // split() SIEMPRE:
        //   1. Interpreta el argumento como REGEX
        //   2. Usa cada match como punto de corte
        //   3. ELIMINA el delimitador del resultado
        //   4. Devuelve un array NUEVO (no modifica el original)
        //
        // \D (o \d) hace match de A UN carácter, no de una secuencia.
        // Delimitadores consecutivos -> genera elementos "" vacíos.
    }

    // Método auxiliar solo para imprimir arrays bonito
    private static void imprimir(String etiqueta, String[] arr) {
        System.out.print(etiqueta + " -> [");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("\"" + arr[i] + "\"");
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

}
