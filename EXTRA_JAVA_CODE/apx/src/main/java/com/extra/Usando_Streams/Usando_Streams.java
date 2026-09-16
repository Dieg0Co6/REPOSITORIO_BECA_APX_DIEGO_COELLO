package com.extra.Usando_Streams;

import java.util.*;
import java.util.function.*;
import java.util.stream.*;

public class Usando_Streams {

    public static void main(String[] args) {
        Usando_Streams notas = new Usando_Streams();

        notas.conceptoDePipeline();
        System.out.println("====================");
        notas.crearStreamsFinitos();
        System.out.println("====================");
        notas.crearStreamsInfinitos();
        System.out.println("====================");
        notas.tablaDeCreacionDeStreams();
        System.out.println("====================");
        notas.contarConCount();
        System.out.println("====================");
        notas.minYMax();
        System.out.println("====================");
        notas.findAnyYFindFirst();
        System.out.println("====================");
        notas.matchingAllAnyNone();
        System.out.println("====================");
        notas.iterandoConForEach();
        System.out.println("====================");
        notas.reduceUnParametro();
        System.out.println("====================");
        notas.reduceDosParametros();
        System.out.println("====================");
        notas.reduceTresParametros();
        System.out.println("====================");
        notas.collectConSupplierAccumulatorCombiner();
        System.out.println("====================");
        notas.collectConCollectorsPredefinidos();
        System.out.println("====================");
        notas.filterDistinctLimitSkip();
        System.out.println("====================");
        notas.mapYFlatMap();
        System.out.println("====================");
        notas.concatenarStreams();
        System.out.println("====================");
        notas.sortedYReverseOrder();
        System.out.println("====================");
        notas.peekParaDebug();
        System.out.println("====================");
        notas.armandoElPipelineCompleto();
        System.out.println("====================");
        notas.streamsInfinitosTrampaDeExamen();
        System.out.println("====================");
        notas.encadenandoDosPipelines();
    }


    // ================================================================
    // EL CONCEPTO DE PIPELINE (la idea general antes del código)
    // ================================================================
    // Un STREAM es una SECUENCIA DE DATOS. Un "stream pipeline" es
    // el conjunto de operaciones que corren SOBRE ese stream para
    // producir un resultado.
    //
    // ANALOGÍA DEL LIBRO: una línea de ensamblaje en una fábrica.
    // Cada trabajador (operación) hace SOLO su parte, y pasa el
    // resultado al siguiente trabajador. Nadie hace nada hasta que
    // le llega trabajo, y cuando termina su parte, ya no vuelve a
    // tocar ese dato.
    //
    // UN PIPELINE TIENE 3 PARTES (siempre, ni más ni menos):
    //
    //   1. SOURCE (fuente)       -> de dónde viene el stream
    //   2. INTERMEDIATE OPERATIONS (operaciones intermedias) -> 0 o más
    //   3. TERMINAL OPERATION (operación terminal)  -> exactamente 1
    //
    // Puede haber CERO O VARIAS operaciones intermedias, pero SIEMPRE
    // debe haber exactamente UNA fuente y UNA operación terminal.
    //
    // DATO CLAVE: un stream es de UN SOLO USO. Una vez que corre la
    // operación terminal, ESE stream ya no se puede volver a usar.
    // Si lo intentas, lanza IllegalStateException en runtime.
    //
    // LAZY EVALUATION (evaluación perezosa): los datos NO se generan
    // todos de antemano. Cada elemento se procesa SOLO cuando la
    // operación terminal lo "pide". Por eso los streams pueden ser
    // INFINITOS: mientras nadie pida el elemento 1000, no se genera.
    public void conceptoDePipeline() {
        // Ejemplo simple para visualizar las 3 partes:
        long cantidad = Stream.of("a", "b", "c")   // <- SOURCE
                .filter(s -> !s.equals("b"))         // <- INTERMEDIATE (puede haber 0, 1 o más)
                .count();                            // <- TERMINAL (siempre exactamente 1)

        System.out.println(cantidad); // 2
    }


    // ================================================================
    // TABLA: INTERMEDIATE vs TERMINAL (memorizar esto de memoria)
    // ================================================================
    // Pregunta                          | Intermediate | Terminal
    // ----------------------------------|--------------|----------
    // ¿Requerido en el pipeline?        | No           | Sí
    // ¿Puede existir varias veces?      | Sí           | No
    // ¿El tipo de retorno es Stream?    | Sí           | No
    // ¿Se ejecuta al llamar el método?  | No           | Sí
    // ¿El stream sigue válido después?  | Sí           | No
    //
    // EXPLICACIÓN DE "¿se ejecuta al llamar el método?":
    // Las operaciones intermedias son "perezosas" -> NO hacen nada
    // hasta que se llama la operación terminal. Solo ENTONCES todo
    // el pipeline se ejecuta de una vez, elemento por elemento.


    // ================================================================
    // CREAR STREAMS FINITOS
    // ================================================================
    public void crearStreamsFinitos() {

        // Stream vacío -> count = 0
        Stream<String> empty = Stream.empty();

        // Stream de un solo elemento -> count = 1
        Stream<Integer> singleElement = Stream.of(1);

        // Stream desde varargs -> count = 3
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        // Convertir una Collection (List, Set, etc) a Stream con .stream()
        var lista = List.of("a", "b", "c");
        Stream<String> fromList = lista.stream();

        System.out.println(empty.count());       // 0
        System.out.println(singleElement.count()); // 1
        System.out.println(fromArray.count());    // 3
        System.out.println(fromList.count());     // 3


        // STREAM PARALELO: se procesa en varios threads a la vez
        Stream<String> fromListParallel = lista.parallelStream();
        System.out.println(fromListParallel.count()); // 3

        // NOTA: los streams paralelos son útiles cuando cada elemento
        // se puede procesar de forma INDEPENDIENTE. Hay un costo de
        // coordinar los threads, así que para streams pequeños puede
        // no valer la pena (más rápido hacerlo secuencial).
    }


    // ================================================================
    // CREAR STREAMS INFINITOS
    // ================================================================
    public void crearStreamsInfinitos() {

        // generate(Supplier) -> llama al Supplier una y otra vez, PARA SIEMPRE
        // OJO: esto nunca termina si lo intentas recorrer completo,
        // así que aquí solo lo declaramos, no lo consumimos entero.
        Stream<Double> randoms = Stream.generate(Math::random);

        // iterate(seed, unaryOperator) -> el primer elemento es el seed,
        // y cada siguiente se calcula aplicando la función al anterior
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2);
        // esto generaría infinitamente: 1, 3, 5, 7, 9, 11...


        // Para poder VER algo sin que el programa nunca termine,
        // hay que combinarlo con una operación que lo "corte":
        System.out.println(oddNumbers.limit(5).collect(Collectors.toList())); // [1, 3, 5, 7, 9]


        // VERSIÓN CON 3 PARÁMETROS de iterate(): seed, predicate, unaryOperator
        // Esta versión SÍ puede ser finita, porque el predicate le dice
        // CUÁNDO detenerse (sin necesitar limit() después)
        //
        //   parámetro 1 (seed)          -> 1              (primer elemento)
        //   parámetro 2 (predicate)     -> n -> n < 100    (condición para SEGUIR)
        //   parámetro 3 (unaryOperator) -> n -> n + 2      (cómo calcular el siguiente)
        Stream<Integer> oddNumbersUnder100 = Stream.iterate(
                1,             // seed
                n -> n < 100,  // predicado: mientras sea true, sigue generando
                n -> n + 2     // cómo generar el siguiente valor
        );
        System.out.println(oddNumbersUnder100.count()); // 50

        // TRAMPA DE EXAMEN: los 3 parámetros van separados por COMA,
        // no por punto y coma como un for. Es fácil confundirse
        // porque se PARECE a un for tradicional (seed; condición; incremento).
    }


    // ================================================================
    // TABLA COMPLETA: MÉTODOS PARA CREAR UN STREAM (memorizar)
    // ================================================================
    public void tablaDeCreacionDeStreams() {
        // Método                                      | Finito/Infinito | Notas
        // --------------------------------------------|-----------------|-------
        // Stream.empty()                               | Finito          | Stream con 0 elementos
        // Stream.of(varargs)                            | Finito          | Stream con los elementos listados
        // coll.stream()                                 | Finito          | Stream desde una Collection
        // coll.parallelStream()                         | Finito          | Igual, pero puede correr en paralelo
        // Stream.generate(supplier)                     | Infinito        | Llama al Supplier repetidamente
        // Stream.iterate(seed, unaryOperator)            | Infinito        | seed, luego aplica la función repetidamente
        // Stream.iterate(seed, predicate, unaryOperator) | Finito o infinito | Se detiene cuando predicate da false
        System.out.println("Ver comentarios arriba - tabla puramente teórica para memorizar");
    }


    // ================================================================
    // OPERACIÓN TERMINAL: count()
    // ================================================================
    // Cuenta cuántos elementos hay en un stream FINITO.
    // NO termina nunca en un stream infinito (por obvias razones).
    // Firma: public long count()
    public void contarConCount() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        System.out.println(s.count()); // 3
    }


    // ================================================================
    // OPERACIÓN TERMINAL: min() y max()
    // ================================================================
    // Encuentran el valor más pequeño/grande según un Comparator
    // que TÚ le pasas. Devuelven un Optional<T> porque el stream
    // podría estar vacío (no habría mínimo/máximo).
    //
    // Firmas:
    //   public Optional<T> min(Comparator<? super T> comparator)
    //   public Optional<T> max(Comparator<? super T> comparator)
    public void minYMax() {
        Stream<String> s = Stream.of("monkey", "ape", "bonobo");

        // comparator personalizado: comparar por LONGITUD del string
        Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println); // ape (el más corto)

        // Ejemplo con stream vacío -> Optional vacío, comparator
        // NUNCA se llama porque no hay nada que comparar
        Optional<String> minEmpty = Stream.<String>empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent()); // false
    }


    // ================================================================
    // OPERACIÓN TERMINAL: findAny() y findFirst()
    // ================================================================
    // Devuelven UN elemento del stream (no una reducción completa),
    // envuelto en Optional (por si el stream está vacío).
    //
    // Son ÚTILES para streams INFINITOS porque NO necesitan procesar
    // todos los elementos, solo encontrar uno y parar ahí.
    //
    // findFirst() -> siempre devuelve el PRIMER elemento
    // findAny()   -> devuelve CUALQUIER elemento (normalmente el
    //                primero en streams secuenciales, pero con
    //                streams PARALELOS puede devolver cualquiera,
    //                no garantizado cuál)
    //
    // Firmas:
    //   public Optional<T> findAny()
    //   public Optional<T> findFirst()
    public void findAnyYFindFirst() {
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        Stream<String> infinite = Stream.generate(() -> "chimp");

        s.findAny().ifPresent(System.out::println);        // monkey (usualmente)
        infinite.findAny().ifPresent(System.out::println); // chimp
    }


    // ================================================================
    // OPERACIONES TERMINALES: allMatch(), anyMatch(), noneMatch()
    // ================================================================
    // Revisan si los elementos del stream cumplen (o no) un
    // Predicate, y devuelven un boolean (por eso NO son reducciones).
    //
    // anyMatch()  -> true si AL MENOS UN elemento cumple
    // allMatch()  -> true si TODOS los elementos cumplen
    // noneMatch() -> true si NINGÚN elemento cumple
    //
    // Con streams INFINITOS: pueden o no terminar, depende de los
    // datos. anyMatch() puede terminar rápido si encuentra un match
    // pronto. allMatch() puede quedarse esperando para siempre si
    // TODOS los elementos siguen cumpliendo indefinidamente.
    //
    // Firmas:
    //   public boolean anyMatch(Predicate<? super T> predicate)
    //   public boolean allMatch(Predicate<? super T> predicate)
    //   public boolean noneMatch(Predicate<? super T> predicate)
    public void matchingAllAnyNone() {
        var list = List.of("monkey", "2", "chimp");
        Stream<String> infinite = Stream.generate(() -> "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));

        System.out.println(list.stream().anyMatch(pred));  // true
        System.out.println(list.stream().allMatch(pred));  // false ("2" no empieza con letra)
        System.out.println(list.stream().noneMatch(pred)); // false
        System.out.println(infinite.anyMatch(pred));       // true (termina rápido, encuentra match)

        // OJO: si llamaras allMatch(pred) sobre "infinite" con un
        // predicate que SIEMPRE es true, el programa correría para
        // siempre, porque nunca encuentra un elemento que lo rompa.
    }


    // ================================================================
    // OPERACIÓN TERMINAL: forEach()
    // ================================================================
    // Es la ÚNICA operación terminal que devuelve void.
    // Recibe un Consumer y lo aplica a cada elemento.
    //
    // Firma: public void forEach(Consumer<? super T> action)
    //
    // TRAMPA DE EXAMEN: forEach() en un Stream NO es lo mismo que un
    // for-each tradicional de un array/loop. No puedes usar un
    // for-each normal directamente sobre un Stream, porque Stream
    // NO implementa la interfaz Iterable:
    //
    //     Stream<Integer> s = Stream.of(1);
    //     for (Integer i : s) {} // DOES NOT COMPILE
    public void iterandoConForEach() {
        Stream<String> s = Stream.of("Monkey", "Gorilla", "Bonobo");
        s.forEach(System.out::print); // MonkeyGorillaBonobo
        System.out.println();
    }


    // ================================================================
    // OPERACIÓN TERMINAL: reduce() -- VERSIÓN DE 1 PARÁMETRO
    // ================================================================
    // reduce() combina TODOS los elementos del stream en UN SOLO
    // objeto. Es la operación de reducción más "manual" y flexible.
    //
    // Firma (1 parámetro):
    //   public Optional<T> reduce(BinaryOperator<T> accumulator)
    //
    // Con 1 parámetro, no hay valor inicial (identity), así que
    // el resultado viene envuelto en Optional (por si el stream
    // está vacío).
    public void reduceUnParametro() {
        Stream<Integer> stream = Stream.of(3, 5, 6);
        Optional<Integer> result = stream.reduce((a, b) -> a * b);
        result.ifPresent(System.out::println); // 90
    }


    // ================================================================
    // OPERACIÓN TERMINAL: reduce() -- VERSIÓN DE 2 PARÁMETROS
    // ================================================================
    // Firma (2 parámetros):
    //   public T reduce(T identity, BinaryOperator<T> accumulator)
    //
    // El primer parámetro (identity) es el valor INICIAL de la
    // reducción, y también lo que se devuelve si el stream está
    // vacío (por eso YA NO se necesita Optional, siempre hay
    // un resultado).
    public void reduceDosParametros() {

        // ejemplo: concatenar Strings SIN usar identity vacía explícita
        Stream<String> stream = Stream.of("w", "o", "l", "f");
        String word = stream.reduce("", (s, c) -> s + c);
        System.out.println(word); // wolf

        // el mismo ejemplo, pero con method reference
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        String word2 = stream2.reduce("", String::concat);
        System.out.println(word2); // wolf


        // ejemplo con multiplicación: identity = 1
        Stream<Integer> nums = Stream.of(3, 5, 6);
        Integer product = nums.reduce(1, (a, b) -> a * b);
        System.out.println(product); // 90


        // COMPORTAMIENTO SEGÚN LA CANTIDAD DE ELEMENTOS (regla general):
        //   - Si el stream está VACÍO -> se devuelve la identity tal cual
        //   - Si el stream tiene UN elemento -> se devuelve ese elemento
        //     (o el resultado de combinarlo con identity, según el caso)
        //   - Si el stream tiene VARIOS -> se van combinando todos con
        //     el accumulator, empezando desde identity
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(3);
        Stream<Integer> threeElements = Stream.of(3, 5, 6);

        System.out.println(empty.reduce(1, op));         // 1 (la identity)
        System.out.println(oneElement.reduce(1, op));    // 3
        System.out.println(threeElements.reduce(1, op)); // 90
    }


    // ================================================================
    // OPERACIÓN TERMINAL: reduce() -- VERSIÓN DE 3 PARÁMETROS
    // ================================================================
    // Firma (3 parámetros):
    //   public <U> U reduce(U identity,
    //                        BiFunction<U, ? super T, U> accumulator,
    //                        BinaryOperator<U> combiner)
    //
    // Se usa cuando el TIPO del acumulador (U) es DISTINTO al tipo
    // de los elementos del stream (T). Por ejemplo: contar caracteres
    // de varios Strings, donde el resultado es un int pero los
    // elementos son String.
    //
    // El tercer parámetro (combiner) SOLO se usa cuando trabajas con
    // STREAMS PARALELOS: permite combinar resultados parciales que
    // fueron calculados por separado en distintos threads.
    public void reduceTresParametros() {
        Stream<String> stream = Stream.of("w", "o", "l", "f", "f");

        // identity: 0 (empezamos contando desde 0)
        // accumulator: (contadorParcial, stringActual) -> suma su longitud
        // combiner: (a, b) -> a + b (para combinar resultados en paralelo)
        int length = stream.reduce(0,
                (i, s) -> i + s.length(),
                (a, b) -> a + b);

        System.out.println(length); // 5
    }


    // ================================================================
    // OPERACIÓN TERMINAL: collect() -- VERSIÓN LARGA (3 parámetros)
    // ================================================================
    // collect() es otro tipo de reducción, especial para trabajar
    // con OBJETOS MUTABLES mientras se acumula (StringBuilder,
    // ArrayList, TreeSet, etc), a diferencia de reduce() que
    // normalmente trabaja con objetos inmutables.
    //
    // Firma larga:
    //   public <R> R collect(Supplier<R> supplier,
    //                         BiConsumer<R, ? super T> accumulator,
    //                         BiConsumer<R, R> combiner)
    //
    //   supplier    -> CREA el objeto que va a acumular el resultado
    //   accumulator -> AGREGA un elemento al objeto acumulador
    //   combiner    -> UNE dos objetos acumuladores (para paralelismo)
    public void collectConSupplierAccumulatorCombiner() {

        Stream<String> stream = Stream.of("w", "o", "l", "f");

        StringBuilder word = stream.collect(
                StringBuilder::new, // supplier: crea un StringBuilder vacío
                StringBuilder::append, // accumulator: agrega el String actual
                StringBuilder::append  // combiner: une dos StringBuilder
        );
        System.out.println(word); // wolf


        // Ejemplo con una lógica DISTINTA en accumulator y combiner
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream2.collect(
                TreeSet::new,   // supplier: crea un TreeSet vacío
                TreeSet::add,   // accumulator: agrega un solo String al TreeSet
                TreeSet::addAll // combiner: agrega TODOS los elementos de otro TreeSet
        );
        System.out.println(set); // [f, l, o, w] (TreeSet ordena automáticamente)
    }


    // ================================================================
    // OPERACIÓN TERMINAL: collect() -- VERSIÓN CORTA (con Collectors)
    // ================================================================
    // Firma corta:
    //   public <R, A> R collect(Collector<? super T, A, R> collector)
    //
    // Java ya trae collectors PREDEFINIDOS en la clase Collectors,
    // para no tener que escribir supplier/accumulator/combiner
    // manualmente cada vez.
    public void collectConCollectorsPredefinidos() {

        Stream<String> stream = Stream.of("w", "o", "l", "f");
        TreeSet<String> set = stream.collect(Collectors.toCollection(TreeSet::new));
        System.out.println(set); // [f, l, o, w]

        // Si no necesitas que quede ordenado, hay algo aún más corto:
        Stream<String> stream2 = Stream.of("w", "o", "l", "f");
        Set<String> set2 = stream2.collect(Collectors.toSet());
        System.out.println(set2); // [f, w, l, o] (orden NO garantizado, probablemente HashSet)

        // NOTA IMPORTANTE: toSet() NO garantiza qué implementación de
        // Set vas a recibir (probablemente HashSet). No debes asumir
        // ni depender de ningún orden con este método.
    }


    // ================================================================
    // OPERACIÓN INTERMEDIA: filter()
    // ================================================================
    // Firma: public Stream<T> filter(Predicate<? super T> predicate)
    // Devuelve un stream con solo los elementos que CUMPLEN el predicate.
    //
    // TAMBIÉN incluye en este método: distinct(), limit(), skip()
    public void filterDistinctLimitSkip() {

        // FILTER: conservar solo los que cumplan la condición
        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.filter(x -> x.startsWith("m")).forEach(System.out::print); // monkey
        System.out.println();


        // DISTINCT: elimina duplicados usando equals() (NO necesitan
        // estar adyacentes para ser eliminados)
        Stream<String> s2 = Stream.of("duck", "duck", "duck", "goose");
        s2.distinct().forEach(System.out::print); // duckgoose
        System.out.println();


        // LIMIT y SKIP: recortar un stream (útil sobre todo con
        // streams infinitos, para volverlos finitos)
        //   limit(maxSize) -> se queda con máximo esa cantidad
        //   skip(n)        -> se saltea los primeros n elementos
        Stream<Integer> infinite = Stream.iterate(1, n -> n + 1);
        infinite.skip(5)   // salta 1,2,3,4,5
                .limit(2)   // se queda solo con los siguientes 2: 6,7
                .forEach(System.out::print); // 67
        System.out.println();
    }


    // ================================================================
    // OPERACIÓN INTERMEDIA: map()
    // ================================================================
    // Firma: public <R> Stream<R> map(Function<? super T, ? extends R> mapper)
    //
    // Transforma cada elemento del stream en OTRO valor (puede ser
    // de tipo diferente), UNO A UNO (relación 1 a 1: entra 1
    // elemento, sale exactamente 1 elemento transformado).
    //
    // OJO: NO confundir con la interfaz Map (la de clave-valor).
    // Este map() es un método de Stream para TRANSFORMAR datos.
    public void mapYFlatMap() {

        Stream<String> s = Stream.of("monkey", "gorilla", "bonobo");
        s.map(String::length).forEach(System.out::print); // 676
        System.out.println();


        // ================================================================
        // OPERACIÓN INTERMEDIA: flatMap()
        // ================================================================
        // flatMap() "aplana" un stream de colecciones/streams en un
        // solo stream de nivel más bajo, quitando los "contenedores"
        // intermedios. También elimina listas vacías por completo.
        //
        // Firma:
        //   public <R> Stream<R> flatMap(
        //           Function<? super T, ? extends Stream<? extends R>> mapper)
        List<String> zero = List.of();
        var one = List.of("Bonobo");
        var two = List.of("Mama Gorilla", "Baby Gorilla");
        Stream<List<String>> animals = Stream.of(zero, one, two);

        animals.flatMap(m -> m.stream())
               .forEach(System.out::println);
        // Bonobo
        // Mama Gorilla
        // Baby Gorilla
        // (la lista vacía "zero" simplemente desaparece, no imprime nada)
    }


    // ================================================================
    // Stream.concat() -- unir dos streams
    // ================================================================
    // Forma más conveniente que flatMap() cuando solo quieres
    // pegar DOS streams uno después del otro.
    //
    // Firma: public static <T> Stream<T> concat(Stream<? extends T> a,
    //                                            Stream<? extends T> b)
    public void concatenarStreams() {
        var one = Stream.of("Bonobo");
        var two = Stream.of("Mama Gorilla", "Baby Gorilla");
        Stream.concat(one, two).forEach(System.out::println);
        // Bonobo
        // Mama Gorilla
        // Baby Gorilla
    }


    // ================================================================
    // OPERACIÓN INTERMEDIA: sorted()
    // ================================================================
    // Firmas:
    //   public Stream<T> sorted()                          // orden natural
    //   public Stream<T> sorted(Comparator<? super T> comparator) // orden custom
    public void sortedYReverseOrder() {

        // orden natural (alfabético/numérico según el tipo)
        Stream<String> s = Stream.of("brown-", "bear-");
        s.sorted().forEach(System.out::print); // bear-brown-
        System.out.println();


        // orden custom con un Comparator ya hecho (method reference válido)
        Stream<String> s2 = Stream.of("brown bear-", "grizzly-");
        s2.sorted(Comparator.reverseOrder()).forEach(System.out::print);
        System.out.println(); // grizzly-brown bear-


        // ================================================================
        // TRAMPA DE EXAMEN: sorted(Comparator::reverseOrder) NO compila
        // ================================================================
        // sorted(Comparator<? super T> comparator) espera un Comparator,
        // que es una interfaz funcional de DOS parámetros que devuelve int:
        //     int compare(T o1, T o2);
        //
        // Pero Comparator::reverseOrder es una referencia a un método
        // que NO recibe parámetros y devuelve un Comparator -> eso
        // encaja con la forma de un SUPPLIER, no con la de Comparator.
        //
        //     Stream<String> s3 = Stream.of("brown bear-", "grizzly-");
        //     s3.sorted(Comparator::reverseOrder); // DOES NOT COMPILE
        //
        // La forma correcta es LLAMAR al método (con paréntesis), para
        // que te devuelva el Comparator ya construido:
        //     s3.sorted(Comparator.reverseOrder()); // esto SÍ compila
    }


    // ================================================================
    // OPERACIÓN INTERMEDIA: peek() -- "espiar" sin modificar
    // ================================================================
    // Firma: public Stream<T> peek(Consumer<? super T> action)
    //
    // Permite ejecutar una acción (normalmente para DEBUG) sobre
    // cada elemento, SIN cambiar el contenido del stream. Es como
    // la versión "intermedia" de forEach() -- misma firma, pero
    // peek() devuelve el stream para seguir encadenando, y forEach()
    // termina el pipeline.
    public void peekParaDebug() {

        var stream = Stream.of("black bear", "brown bear", "grizzly");
        long count = stream.filter(s -> s.startsWith("g"))
                .peek(System.out::println) // efecto secundario: imprime "grizzly"
                .count();
        System.out.println(count); // 1

        // ADVERTENCIA IMPORTANTE (trampa de examen):
        // peek() está pensado para NO modificar el stream. Pero Java
        // NO TE IMPIDE hacerlo de todos modos si escribes mala lógica
        // dentro del Consumer. Si modificas la estructura de datos
        // fuente DENTRO de peek(), el resultado del pipeline puede
        // cambiar de forma inesperada. Ejemplo de MALA PRÁCTICA:
        //
        //     var numbers = new ArrayList<Integer>();
        //     numbers.add(1);
        //     var bad = Stream.of(numbers);
        //     bad.peek(x -> x.remove(0)) // modifica la lista mientras se usa
        //        .map(List::size)
        //        .forEach(System.out::println); // resultado inesperado
        //
        // CONCLUSIÓN: usa peek() SOLO para leer/imprimir, nunca para
        // modificar datos.
    }


    // ================================================================
    // ARMANDO UN PIPELINE COMPLETO (ejemplo integrador)
    // ================================================================
    // Objetivo: de una lista de nombres, sacar los primeros DOS
    // nombres (en orden alfabético) que tengan exactamente 4 letras.
    public void armandoElPipelineCompleto() {

        var list = List.of("Toby", "Anna", "Leroy", "Alex");

        list.stream()
                .filter(n -> n.length() == 4) // SOURCE ya viene de list.stream()
                .sorted()                     // intermedia: ordena
                .limit(2)                     // intermedia: se queda con los primeros 2
                .forEach(System.out::println); // TERMINAL: imprime cada uno

        // Toby
        // Anna
    }


    // ================================================================
    // STREAMS INFINITOS -- CASOS TRAMPA DE EXAMEN
    // ================================================================
    // Estos ejemplos muestran cómo el ORDEN de las operaciones
    // intermedias afecta si un pipeline con stream infinito
    // TERMINA o se queda COLGADO para siempre.
    public void streamsInfinitosTrampaDeExamen() {

        // CASO 1: sorted() ANTES de limit() -- SE CUELGA
        // El foreman (Java) sabe que sorted() necesita ver TODOS los
        // elementos antes de poder ordenar y dejar pasar el primero.
        // Como el stream es infinito, sorted() espera para siempre.
        //
        //     Stream.generate(() -> "Elsa")
        //           .filter(n -> n.length() == 4)
        //           .sorted()   // <- espera TODOS los elementos, nunca llega
        //           .limit(2)
        //           .forEach(System.out::println);
        //     // Se queda colgado (o lanza OutOfMemoryError eventualmente)


        // CASO 2: limit() ANTES de sorted() -- SÍ TERMINA
        // limit() corta el stream a 2 elementos ANTES de que sorted()
        // tenga que trabajar. Como ya es finito (2 elementos), sorted()
        // sí puede ordenar sin problema.
        Stream.generate(() -> "Elsa")
                .filter(n -> n.length() == 4)
                .limit(2)   // <- corta primero, ahora sorted() trabaja con datos finitos
                .sorted()
                .forEach(System.out::println);
        // Elsa
        // Elsa


        // CASO 3: filter() nunca deja pasar nada -- SE CUELGA
        // Si el predicate de filter() nunca es true para ningún
        // elemento generado, limit() JAMÁS junta los elementos que
        // necesita, así que el pipeline se queda esperando para siempre.
        //
        //     Stream.generate(() -> "Olaf Lazisson")
        //           .filter(n -> n.length() == 4) // nunca es true
        //           .limit(2)  // espera 2 elementos que nunca llegan
        //           .sorted()
        //           .forEach(System.out::println);
        //     // Se queda colgado para siempre


        // REGLA GENERAL PARA EL EXAMEN:
        // Con streams infinitos, SIEMPRE hay que preguntarse: "¿esta
        // operación necesita ver TODOS los elementos antes de dejar
        // pasar alguno?" (como sorted()) — si la respuesta es sí, y
        // el stream sigue siendo infinito en ese punto, el pipeline
        // NUNCA termina. limit() debe aplicarse ANTES para volver el
        // stream finito, si luego se va a usar sorted() u otra
        // operación de ese tipo.
    }


    // ================================================================
    // ENCADENANDO DOS PIPELINES (identificar SOURCE y TERMINAL)
    // ================================================================
    // A veces se combinan dos pipelines completos, uno alimentando
    // al otro. Para leerlo bien en el examen, identifica POR
    // SEPARADO cada pipeline: cuál es su source y cuál es su terminal.
    public void encadenandoDosPipelines() {

        // PRIMER pipeline: source = Stream.of(...), terminal = collect(...)
        // SEGUNDO pipeline: source = .stream() sobre la lista ya creada,
        //                   terminal = count()
        long count = Stream.of("goldfish", "finch")
                .filter(s -> s.length() > 5)      // intermedia del primer pipeline
                .collect(Collectors.toList())     // TERMINAL del primer pipeline
                .stream()                          // SOURCE del segundo pipeline
                .count();                           // TERMINAL del segundo pipeline
        System.out.println(count); // 1

        // Para no perderse, se puede reescribir en pasos, con una
        // variable intermedia, exactamente equivalente a lo de arriba:
        List<String> helper = Stream.of("goldfish", "finch")
                .filter(s -> s.length() > 5)
                .collect(Collectors.toList());
        long count2 = helper.stream().count();
        System.out.println(count2); // 1

        // TIP DE EXAMEN: cuando veas un pipeline largo o complicado
        // entre varias opciones de respuesta, enfócate en las
        // DIFERENCIAS entre las opciones -- ahí suele estar la pista
        // de cuál es la respuesta correcta, sin tener que re-leer
        // todo el pipeline completo cada vez.
    }
}
