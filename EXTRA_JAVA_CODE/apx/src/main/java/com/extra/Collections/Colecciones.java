package com.extra.Collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Deque;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Set;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;

public class Colecciones {

    // ============================================================
    // EL "MAPA GENERAL" DEL COLLECTIONS FRAMEWORK
    // ============================================================
    // Todo lo que mencionas (ArrayList, HashMap, TreeMap...) vive
    // dentro de 3 grandes familias. Cada familia es una INTERFAZ,
    // y cada nombre raro (Hash..., Linked..., Tree...) es solo una
    // IMPLEMENTACIÓN distinta de esa misma interfaz:
    //
    // Collection (interfaz raíz)
    // │
    // ├── List (permite duplicados, tiene orden por índice: 0,1,2...)
    // │      ├── ArrayList -> array dinámico por debajo
    // │      └── LinkedList -> lista doblemente enlazada por debajo
    // │
    // └── Set (NO permite duplicados, no tiene índices)
    //        ├── HashSet -> sin orden garantizado (usa hashCode)
    //        ├── LinkedHashSet -> mantiene el orden de inserción
    //        └── TreeSet -> mantiene todo ORDENADO (ordenado = sorted)
    //
    // Map (NO es un Collection, es su propia interfaz aparte)
    // │ Guarda pares clave-valor (key -> value), las claves no se repiten
    // │
    // ├── HashMap -> sin orden garantizado
    // ├── LinkedHashMap -> mantiene el orden de inserción
    // └── TreeMap -> mantiene las claves ORDENADAS
    //
    // Fíjate en el PATRÓN de los prefijos, se repite en Set y en Map:
    // - "Hash..." = rápido, pero SIN orden garantizado
    // - "LinkedHash..." = rápido, y SÍ recuerda el orden en que insertaste
    // - "Tree..." = más lento, pero SIEMPRE ordenado (de menor a mayor,
    // o alfabético, o con la regla que tú definas)
    //
    // OJO: "TreeList" que mencionas NO existe en Java estándar (java.util).
    // Solo existen ArrayList y LinkedList como implementaciones de List.
    // (Existe una TreeList en una librería externa, Apache Commons, pero
    // NO es parte del Java normal, así que para el examen no la necesitas).

    public static void main(String[] args) {
        Colecciones colecciones = new Colecciones();
        colecciones.listas();
        colecciones.conjuntosSet();
        colecciones.mapas();
    }

    // ================================================================
    // LIST: ArrayList vs LinkedList
    // ================================================================
    // Ambas implementan List<T>:
    // - Mantienen el ORDEN en que agregas los elementos (índice 0,1,2...)
    // - Permiten ELEMENTOS DUPLICADOS
    // - Permiten null
    //
    // La diferencia está en CÓMO guardan los datos por dentro, y eso
    // afecta el rendimiento:
    public void listas() {

        // ------------------------------------------------------------
        // ArrayList: por dentro usa un ARRAY que crece automáticamente
        // ------------------------------------------------------------
        // - Leer un elemento por índice -> MUY rápido (acceso directo)
        // - Insertar/borrar al PRINCIPIO o en medio -> lento (hay que
        // recorrer/mover el resto de elementos un puesto)
        // - Es la opción por defecto si no sabes cuál usar.

        List<String> arrayList = new ArrayList<>();
        arrayList.add("gallina");
        arrayList.add("pato");
        arrayList.add("pavo");
        arrayList.add("gallina"); // los duplicados SÍ se permiten

        System.out.println(arrayList); // [gallina, pato, pavo, gallina]
        System.out.println(arrayList.get(1)); // "pato" -> acceso rapidísimo por índice

        arrayList.remove("pato"); // busca y quita la primera coincidencia
        System.out.println(arrayList); // [gallina, pavo, gallina]

        System.out.println("----");

        // ------------------------------------------------------------
        // LinkedList: por dentro es una cadena de "nodos" enlazados
        // (cada nodo apunta al anterior y al siguiente)
        // ------------------------------------------------------------
        // - Insertar/borrar al PRINCIPIO o al FINAL -> muy rápido
        // - Leer un elemento por índice -> lento (hay que ir nodo por
        // nodo desde el principio o el final hasta llegar ahí)
        // - Bonus: además de List, también implementa Deque, por lo
        // que sirve como pila (stack) o cola (queue).

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("pato");
        linkedList.addFirst("gallina"); // lo mete al inicio, rapidísimo
        linkedList.addLast("pavo"); // lo mete al final, rapidísimo

        System.out.println(linkedList); // [gallina, pato, pavo]

        // Usándola como Deque (cola de dos puntas):
        Deque<String> pila = new LinkedList<>();
        pila.push("uno"); // apilar (como una pila de platos)
        pila.push("dos");
        pila.push("tres");
        System.out.println(pila.pop()); // "tres" -> el último en entrar es el primero en salir

        System.out.println("----");

        // ------------------------------------------------------------
        // RESUMEN List
        // ------------------------------------------------------------
        // ArrayList -> úsala casi siempre (rápida para leer/recorrer)
        // LinkedList -> úsala si vas a insertar/quitar MUCHO al
        // principio o al final (ej. implementar una cola)
    }

    // ================================================================
    // SET: HashSet vs LinkedHashSet vs TreeSet
    // ================================================================
    // Las tres implementan Set<T>:
    // - NO permiten elementos DUPLICADOS (si agregas uno que ya
    // existe, simplemente lo ignora, sin dar error)
    // - NO tienen índice (no existe set.get(0), porque un Set no
    // garantiza "posiciones" como una List)
    public void conjuntosSet() {

        // ------------------------------------------------------------
        // HashSet: el más rápido, pero SIN orden garantizado
        // ------------------------------------------------------------
        // El orden en que los imprime NO tiene por qué ser el orden
        // en que los agregaste (depende del hashCode() de cada valor).

        Set<String> hashSet = new HashSet<>();
        hashSet.add("pato");
        hashSet.add("gallina");
        hashSet.add("pavo");
        hashSet.add("pato"); // duplicado -> se ignora, no se agrega otra vez

        System.out.println(hashSet); // orden variable, ej: [pato, pavo, gallina]
        System.out.println(hashSet.size()); // 3 (el duplicado no contó)

        System.out.println("----");

        // ------------------------------------------------------------
        // LinkedHashSet: igual que HashSet, pero SÍ recuerda el orden
        // en el que fuiste insertando los elementos
        // ------------------------------------------------------------

        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("pato");
        linkedHashSet.add("gallina");
        linkedHashSet.add("pavo");

        System.out.println(linkedHashSet); // [pato, gallina, pavo] -> SIEMPRE en este orden

        System.out.println("----");

        // ------------------------------------------------------------
        // TreeSet: mantiene los elementos SIEMPRE ordenados
        // (orden natural: alfabético para String, ascendente para
        // números; o el orden que tú definas con un Comparator)
        // ------------------------------------------------------------

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("pavo");
        treeSet.add("gallina");
        treeSet.add("pato");

        System.out.println(treeSet); // [gallina, pato, pavo] -> alfabético automáticamente

        // Como TreeSet implementa NavigableSet, tiene métodos extra
        // muy útiles al estar ordenado:
        TreeSet<Integer> numeros = new TreeSet<>();
        numeros.add(50);
        numeros.add(10);
        numeros.add(30);

        System.out.println(numeros); // [10, 30, 50]
        System.out.println(numeros.first()); // 10 -> el más pequeño
        System.out.println(numeros.last()); // 50 -> el más grande
        System.out.println(numeros.higher(10)); // 30 -> el siguiente mayor a 10

        System.out.println("----");

        // ------------------------------------------------------------
        // RESUMEN Set
        // ------------------------------------------------------------
        // HashSet -> úsalo cuando solo te importa "que no haya
        // duplicados" y no te importa el orden (el más rápido)
        // LinkedHashSet -> igual, pero quieres conservar el orden
        // en que fuiste agregando
        // TreeSet -> quieres los elementos siempre ordenados
    }

    // ================================================================
    // MAP: HashMap vs LinkedHashMap vs TreeMap
    // ================================================================
    // OJO: Map NO es un Collection (no tiene add()), es una interfaz
    // aparte para guardar pares CLAVE -> VALOR (key -> value).
    // Las claves (keys) no se pueden repetir, los valores (values) sí.
    //
    // El patrón Hash / LinkedHash / Tree se repite exactamente igual
    // que en Set, pero aplicado a las CLAVES del mapa:
    public void mapas() {

        // ------------------------------------------------------------
        // HashMap: el más común y rápido, SIN orden garantizado
        // ------------------------------------------------------------

        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("gallina", 5);
        hashMap.put("pato", 2);
        hashMap.put("pavo", 8);
        hashMap.put("gallina", 9); // misma clave -> PISA el valor anterior (5 -> 9)

        System.out.println(hashMap); // orden variable, ej: {pato=2, pavo=8, gallina=9}
        System.out.println(hashMap.get("gallina")); // 9

        System.out.println("----");

        // ------------------------------------------------------------
        // LinkedHashMap: igual que HashMap, pero recuerda el orden
        // de inserción de las claves
        // ------------------------------------------------------------

        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("gallina", 5);
        linkedHashMap.put("pato", 2);
        linkedHashMap.put("pavo", 8);

        System.out.println(linkedHashMap); // {gallina=5, pato=2, pavo=8} -> siempre este orden

        System.out.println("----");

        // ------------------------------------------------------------
        // TreeMap: mantiene las CLAVES siempre ordenadas
        // ------------------------------------------------------------

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("pavo", 8);
        treeMap.put("gallina", 5);
        treeMap.put("pato", 2);

        System.out.println(treeMap); // {gallina=5, pato=2, pavo=8} -> alfabético por clave

        // Recorrer un Map (aplica a los 3 tipos, aquí con TreeMap):
        for (Map.Entry<String, Integer> entrada : treeMap.entrySet()) {
            System.out.println(entrada.getKey() + " -> " + entrada.getValue());
        }
        // gallina -> 5
        // pato -> 2
        // pavo -> 8

        System.out.println("----");

        // ------------------------------------------------------------
        // RESUMEN Map
        // ------------------------------------------------------------
        // HashMap -> úsalo casi siempre (el más rápido)
        // LinkedHashMap -> quieres conservar el orden de inserción
        // TreeMap -> quieres las claves siempre ordenadas
    }

    // ================================================================
    // TABLA RESUMEN FINAL PARA MEMORIZAR
    // ================================================================
    // LIST (con índice, permite duplicados)
    // ArrayList -> array dinámico, rápida para LEER
    // LinkedList -> nodos enlazados, rápida para INSERTAR/BORRAR
    // en los extremos; también sirve como Deque/pila/cola
    //
    // SET (sin índice, NO permite duplicados)
    // HashSet -> rápido, SIN orden garantizado
    // LinkedHashSet -> rápido, mantiene el orden de inserción
    // TreeSet -> mantiene todo ORDENADO (usa NavigableSet: first,
    // last, higher, lower...)
    //
    // MAP (clave -> valor, NO es un Collection)
    // HashMap -> rápido, SIN orden garantizado
    // LinkedHashMap -> rápido, mantiene el orden de inserción
    // TreeMap -> mantiene las CLAVES ORDENADAS (usa NavigableMap)
    //
    // Truco mental: "Hash" = rápido y desordenado.
    // "LinkedHash" = rápido y recuerda el orden en que llegó.
    // "Tree" = más lento, pero siempre ordenado.
}

