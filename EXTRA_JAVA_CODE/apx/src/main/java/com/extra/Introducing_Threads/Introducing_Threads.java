package com.extra.Introducing_Threads;

import java.util.concurrent.TimeUnit;

public class Introducing_Threads {
    public static void main(String[] args) throws InterruptedException {
        Introducing_Threads notas = new Introducing_Threads();
        notas.conceptosBasicos();
        System.out.println("====================");
        notas.crearThreadConRunnable();
        System.out.println("====================");
        notas.startEsAsincronoRunEsSincrono();
        System.out.println("====================");
        notas.threadsDaemonVsUsuario();
        System.out.println("====================");
        notas.cicloDeVidaDelThread();
        System.out.println("====================");
        notas.pollingConSleep();
        System.out.println("====================");
        notas.threadYield();
        System.out.println("====================");
        notas.synchronizedKeyword();
        System.out.println("====================");
        notas.waitNotifyNotifyAll();
    }

    
    public void conceptosBasicos() {
        // ================================================================
        // CONCEPTOS BÁSICOS (thread, process, task, concurrency)
        // ================================================================
        // THREAD: la unidad más pequeña de ejecución que el sistema
        // operativo puede programar/ejecutar.
        //
        // PROCESS (proceso): un grupo de threads que se ejecutan juntos,
        // compartiendo el MISMO espacio de memoria.
        // - proceso "single-threaded" = tiene exactamente 1 thread
        // - proceso "multithreaded" = tiene más de 1 thread
        //
        // MEMORIA COMPARTIDA: los threads de un mismo proceso comparten
        // memoria (variables static, y variables de instancia/locales
        // que se les pasen). Por eso una variable static es útil:
        // si un thread la cambia, los demás ven el cambio al instante.
        //
        // TASK (tarea): el trabajo que hace un thread. En este libro,
        // casi siempre una tarea es una lambda expression.
        // Un thread puede hacer varias tareas, pero SOLO UNA a la vez.
        //
        // CONCURRENCY (concurrencia): que varios threads/procesos se
        // ejecuten "al mismo tiempo" (o lo parezca).
        //
        // THREAD SCHEDULER: el sistema operativo decide qué thread corre
        // en cada momento (por ejemplo con "round-robin": cada
        // thread recibe su turno de CPU por igual, en orden circular).
        //
        // CONTEXT SWITCH: cuando se acaba el tiempo asignado a un thread
        // y aún no terminó, el sistema GUARDA su estado actual
        // y luego lo RESTAURA para seguir después. Esto tiene un
        // costo (tiempo perdido en guardar/restaurar).
        //
        // THREAD PRIORITY: un número que le dice al scheduler qué threads
        // deberían tener preferencia para ejecutarse.
    }

    // ================================================================
    // CREAR UN THREAD CON RUNNABLE
    // ================================================================
    // Runnable es una interfaz funcional que NO recibe nada y NO
    // devuelve nada (void run()). Es la forma más común de definir
    // una "tarea" para un thread.
    //
    // @FunctionalInterface
    // public interface Runnable {
    // void run();
    // }
    //
    // Para EJECUTAR esa tarea en un thread NUEVO (real, paralelo),
    // hay que pasarla al constructor de Thread y llamar start().
    public void crearThreadConRunnable() {

        // Forma más corta: todo en una línea
        new Thread(() -> System.out.print("Hello")).start();
        System.out.print("World");
        System.out.println();
        // IMPORTANTE: el orden de salida NO está garantizado.
        // Puede imprimir "HelloWorld" o "WorldHello", depende del
        // scheduler del sistema operativo. Esto es justo lo que
        // les gusta preguntar en el examen: "¿qué imprime esto?"
        // -> la respuesta correcta suele ser "no se sabe con certeza".

        System.out.println("----");

        // Ejemplo con Runnables guardados en variables (más legible)
        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        System.out.println("begin");
        new Thread(printInventory).start(); // thread nuevo #1
        new Thread(printRecords).start(); // thread nuevo #2
        new Thread(printInventory).start(); // thread nuevo #3
        System.out.println("end");

        // Aquí se usan 4 threads en total: el main() + estos 3.
        // El orden de las líneas impresas por CADA thread individual
        // sigue siendo secuencial (el for imprime 0,1,2 en orden),
        // pero el ORDEN ENTRE THREADS distintos es impredecible.
        // Lo único garantizado: "begin" siempre sale antes que "end"
        // (porque esas líneas corren en el thread main, de forma lineal).
    }

    // ================================================================
    // start() vs run() -- TRAMPA CLÁSICA DE EXAMEN
    // ================================================================
    // .start() -> SÍ crea un thread nuevo de verdad, y ejecuta
    // la tarea en PARALELO (asíncrono). El programa
    // NO espera a que termine para seguir con la
    // siguiente línea.
    //
    // .run() -> NO crea ningún thread nuevo. Simplemente ejecuta
    // el método run() COMO SI FUERA UN MÉTODO NORMAL,
    // en el mismo thread actual (síncrono). El programa
    // SÍ espera a que termine antes de seguir.
    //
    // Ambos COMPILAN bien. La diferencia es de COMPORTAMIENTO en
    // tiempo de ejecución, no de compilación. Por eso es fácil que
    // te la pongan como trampa: el código se ve casi igual.
    public void startEsAsincronoRunEsSincrono() {

        Runnable printInventory = () -> System.out.println("Printing zoo inventory");
        Runnable printRecords = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Printing record: " + i);
            }
        };

        System.out.println("begin");
        new Thread(printInventory).run(); // NO es un thread nuevo, es como llamar un método normal
        new Thread(printRecords).run(); // espera a que termine antes de seguir
        new Thread(printInventory).run(); // espera a que termine antes de seguir
        System.out.println("end");

        // A diferencia del ejemplo con start(), aquí el resultado es
        // SIEMPRE el mismo en cada ejecución, porque cada línea
        // espera a que la anterior termine (comportamiento síncrono,
        // lineal, como cualquier llamada a método normal).
    }

    // ================================================================
    // DOS FORMAS DE CREAR UN THREAD (dato para el examen)
    // ================================================================
    // 1. Pasar un Runnable (objeto o lambda) al constructor de Thread:
    // new Thread(() -> hacerAlgo()).start();
    // -> Es la forma preferida y más usada (más simple, más flexible).
    //
    // 2. Crear una clase que EXTIENDA Thread y sobreescriba run():
    // class MiTarea extends Thread {
    // public void run() { hacerAlgo(); }
    // }
    // new MiTarea().start();
    // -> Poco común. Solo se usa si necesitas sobreescribir OTROS
    // métodos de Thread además de run() (caso especial/raro).

    // ================================================================
    // SYSTEM THREADS vs USER-DEFINED THREADS, y DAEMON THREADS
    // ================================================================
    // SYSTEM THREAD: lo crea la JVM y corre en segundo plano.
    // Ejemplo: el garbage collector corre en un system thread.
    // Por esto, TODA aplicación Java es en realidad "multithreaded"
    // aunque tú solo hayas escrito un main().
    //
    // USER-DEFINED THREAD: el que TÚ creas como programador para
    // hacer una tarea específica. El main() en sí también
    // corre en un user-defined thread (el thread "main").
    //
    // DAEMON THREAD: un thread (de sistema o de usuario) marcado como
    // "daemon". La diferencia clave: un daemon thread NO
    // evita que la JVM se cierre. El programa termina en
    // cuanto los ÚNICOS threads que quedan corriendo son daemons.
    //
    // Por DEFECTO, los threads que tú creas NO son daemon. Por eso
    // la JVM los espera antes de cerrar el programa.
    public void threadsDaemonVsUsuario() throws InterruptedException {

        // job es un thread normal (NO daemon) que tarda ~2 segundos
        // (usamos 2 en vez de 10 para no hacer esperar tanto la demo)
        var job = new Thread(() -> pausaCorta());

        // Si comentas la siguiente línea, el programa ESPERA
        // los ~2 segundos antes de terminar, porque job NO es daemon.
        //
        // Si DESCOMENTAS esta línea, el programa termina apenas
        // main() acaba, SIN esperar a que job imprima su mensaje:
        // job.setDaemon(true);

        job.start();
        System.out.println("Main method finished!");

        // Para que esta demo no corra 2 segundos de más en cada
        // ejecución del archivo completo, esperamos manualmente aquí
        // (esto es solo para la demo, normalmente no harías esto):
        job.join();
    }

    private void pausaCorta() {
        try {
            TimeUnit.SECONDS.sleep(2); // simula una tarea que tarda
        } catch (InterruptedException e) {
        }
        System.out.println("Thread finished!");
    }

    // ================================================================
    // CICLO DE VIDA DE UN THREAD (6 estados)
    // ================================================================
    // Puedes consultar el estado actual con thread.getState()
    //
    // NEW -> creado, pero start() todavía NO fue llamado
    // RUNNABLE -> start() ya se llamó. Puede estar corriendo
    // O simplemente "listo para correr" (el scheduler
    // decide). RUNNABLE NO significa "ejecutándose
    // en este instante exacto".
    // BLOCKED -> esperando poder entrar a un bloque synchronized
    // WAITING -> esperando indefinidamente ser notificado (wait())
    // TIMED_WAITING -> esperando un tiempo específico (ej: sleep())
    // TERMINATED -> ya terminó (run() completó, o lanzó una excepción
    // no capturada)
    //
    // TRANSICIONES CLAVE:
    // NEW -> (start()) -> RUNNABLE
    // RUNNABLE -> (run() termina) -> TERMINATED
    // RUNNABLE -> (sleep()) -> TIMED_WAITING -> (tiempo pasa) -> RUNNABLE
    // RUNNABLE -> (wait()) -> WAITING -> (notify()/notifyAll()) -> RUNNABLE
    // RUNNABLE -> (pide un lock ocupado) -> BLOCKED -> (lock liberado) -> RUNNABLE
    public void cicloDeVidaDelThread() {
        Thread t = new Thread(() -> pausaCorta());
        System.out.println(t.getState()); // NEW (aún no se llamó start())
        t.start();
        System.out.println(t.getState()); // probablemente RUNNABLE
        try {
            t.join(); // esperamos a que termine, solo para la demo
        } catch (InterruptedException e) {
        }
        System.out.println(t.getState()); // TERMINATED
    }

    // ================================================================
    // POLLING CON Thread.sleep()
    // ================================================================
    // POLLING: revisar repetidamente si una condición ya se cumplió.
    // Un while() vacío que solo revisa una condición SIN esperar nada
    // es MALA PRÁCTICA: consume CPU sin necesidad ("busy waiting").
    //
    // La mejora es meter un Thread.sleep() dentro del ciclo, para
    // "liberar" el CPU un poquito en cada revisión, en vez de
    // preguntar sin parar a máxima velocidad.
    public void pollingConSleep() {

        CheckResultsConSleep.main(null);
        // (ver clase CheckResultsConSleep más abajo en este archivo)

        // DATO CLAVE: sleep() SÍ mete al thread en estado TIMED_WAITING
        // mientras espera, y vuelve a RUNNABLE cuando el tiempo termina.
    }

    // ================================================================
    // Thread.yield()
    // ================================================================
    // yield() es un método STATIC de Thread. Le da al scheduler una
    // SUGERENCIA (no una orden) de que el thread actual está
    // dispuesto a cederle el turno a otro thread.
    //
    // PUNTOS CLAVE PARA EL EXAMEN:
    // - Es un método STATIC (Thread.yield(), no instancia.yield())
    // - Es solo una SUGERENCIA -> el scheduler puede ignorarla
    // - El thread se queda en estado RUNNABLE (no pasa a WAITING
    // ni a BLOCKED)
    // - NO garantiza que otro thread vaya a ejecutarse
    // - NO libera ningún monitor/lock que el thread tenga
    // - NO lanza InterruptedException (a diferencia de sleep())
    // - NO sincroniza el acceso a datos compartidos entre threads
    public void threadYield() {
        Runnable tarea = () -> {
            for (int i = 0; i < 5; i++) {
                if (i == 2) {
                    Thread.yield(); // solo una sugerencia al scheduler
                }
                System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            }
        };
        new Thread(tarea, "hilo-A").start();
        new Thread(tarea, "hilo-B").start();

        // IMPORTANTE: aunque veas yield() en el código, eso NO establece
        // ningún orden garantizado de ejecución entre hilo-A y hilo-B.
    }

    // ================================================================
    // synchronized
    // ================================================================
    // synchronized controla el acceso a datos compartidos cuando
    // varios threads pueden ejecutar el mismo código al mismo tiempo.
    //
    // Un método synchronized usa el "monitor lock" (candado) DEL OBJETO.
    // Solo UN thread a la vez puede tener ese lock.
    //
    // Forma 1: método completo synchronized
    // public synchronized void increment() { count++; }
    //
    // Forma 2: bloque synchronized (más específico/flexible)
    // synchronized (this) { count++; }
    //
    // Cuando un thread entra a un método/bloque synchronized, debe
    // ADQUIRIR el monitor asociado. Si otro thread ya lo tiene,
    // el segundo thread ESPERA (queda BLOCKED) hasta que se libere.
    //
    // La sincronización está asociada al LOCK, no al método en sí.
    // Dos métodos synchronized DISTINTOS, si usan el mismo objeto como
    // lock, NO pueden ejecutarse al mismo tiempo entre ellos tampoco.
    //
    // Un método STATIC synchronized usa el lock de la CLASE (el objeto
    // Class), no el de una instancia:
    // public static synchronized void increment() { count++; }
    public void synchronizedKeyword() {
        Counter contador = new Counter();

        Runnable incrementar1000veces = () -> {
            for (int i = 0; i < 1000; i++) {
                contador.increment();
            }
        };

        Thread t1 = new Thread(incrementar1000veces);
        Thread t2 = new Thread(incrementar1000veces);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
        }

        // Gracias a synchronized, el resultado SIEMPRE es 2000 exacto,
        // sin importar cuántas veces lo ejecutes.
        System.out.println("Contador final: " + contador.getCount());
    }

    // ================================================================
    // wait(), notify() y notifyAll()
    // ================================================================
    // Estos métodos están definidos en Object (no en Thread), y sirven
    // para que threads se "comuniquen" usando el MISMO monitor (lock).
    //
    // wait(): el thread actual LIBERA el monitor y se pone en estado
    // WAITING, esperando indefinidamente a ser notificado.
    // SOLO se puede llamar dentro de un bloque/método
    // synchronized sobre ESE MISMO objeto.
    //
    // Object lock = new Object();
    // synchronized (lock) {
    // lock.wait();
    // }
    //
    // notify(): despierta a UN thread que esté esperando en el
    // MISMO monitor. Si hay varios esperando, se elige
    // solo uno para continuar.
    //
    // synchronized (lock) {
    // lock.notify();
    // }
    //
    // notifyAll(): despierta a TODOS los threads que estén esperando
    // en el mismo monitor. No corren todos a la vez
    // dentro del bloque synchronized -> deben competir
    // por reobtener el lock, solo uno lo tiene a la vez.
    //
    // synchronized (lock) {
    // lock.notifyAll();
    // }
    //
    // DIFERENCIA CLAVE:
    // notify() -> despierta 1 solo thread en espera
    // notifyAll() -> despierta a TODOS los threads en espera
    //
    // MUY IMPORTANTE: wait() y notify()/notifyAll() deben usarse
    // sobre el MISMO objeto (mismo monitor). Si usas objetos
    // DIFERENTES, no hay comunicación entre esos threads:
    //
    // Object lock1 = new Object();
    // Object lock2 = new Object();
    //
    // synchronized (lock1) { lock1.wait(); } // espera en lock1
    // synchronized (lock2) { lock2.notify(); } // esto NO despierta
    // // al que espera en lock1
    //
    // PATRÓN COMÚN: revisar una condición ANTES de llamar wait(),
    // usando un while() (no un if()), por si el thread se despierta
    // "de más" sin que la condición realmente se haya cumplido:
    //
    // synchronized (lock) {
    // while (!condicion) {
    // lock.wait();
    // }
    // // aquí la condición ya es verdadera
    // }
    //
    // DIFERENCIA wait() vs sleep():
    // wait() -> SÍ libera el monitor mientras espera
    // sleep() -> NO libera ningún monitor mientras espera
    public void waitNotifyNotifyAll() throws InterruptedException {

        Object lock = new Object();

        Thread esperador = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Esperador: voy a esperar...");
                try {
                    lock.wait(); // libera el monitor y espera
                } catch (InterruptedException e) {
                }
                System.out.println("Esperador: ¡me despertaron!");
            }
        });

        esperador.start();
        TimeUnit.MILLISECONDS.sleep(200); // damos tiempo a que "esperador" llegue a wait()

        Thread notificador = new Thread(() -> {
            synchronized (lock) {
                System.out.println("Notificador: notificando...");
                lock.notify(); // despierta al que espera en 'lock'
            }
        });
        notificador.start();

        esperador.join();
        notificador.join();
    }

    // ================================================================
    // TABLA RESUMEN PARA MEMORIZAR
    // ================================================================
    // Thread "main" : ya existe automáticamente, corre tu main()
    // System thread : lo crea la JVM (ej: garbage collector)
    // User-defined thread: lo creas tú
    // Daemon thread : NO evita que la JVM cierre el programa
    // NEW -> RUNNABLE -> (BLOCKED/WAITING/TIMED_WAITING) -> TERMINATED
    // sleep() : pausa por tiempo fijo, TIMED_WAITING, no libera lock
    // yield() : sugerencia al scheduler, sigue en RUNNABLE, no libera lock
    // wait() : libera el lock, WAITING indefinido, se llama en synchronized
    // notify() : despierta 1 thread en espera del mismo monitor
    // notifyAll(): despierta a TODOS los threads en espera del mismo monitor
    // synchronized: solo 1 thread a la vez puede tener el lock de ese objeto
}

// ================================================================
// Clase auxiliar para el ejemplo de polling con sleep()
// ================================================================
class CheckResultsConSleep {
    private static int counter = 0;

    public static void main(String[] a) {
        counter = 0; // reset para que la demo sea repetible
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++)
                counter++;
        }).start();

        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(200); // pausa corta para no saturar el CPU
            } catch (InterruptedException e) {
                System.out.println("Interrupted!");
            }
        }
        System.out.println("Reached: " + counter);
    }

}

// ================================================================
// Clase auxiliar para el ejemplo de synchronized
// ================================================================
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}

// ================================================================
// RACE CONDITIONS (condición de carrera)
// ================================================================
// Una race condition ocurre cuando el RESULTADO de un programa
// depende del ORDEN/TIMING en que varios threads acceden a los
// MISMOS datos compartidos (mutable).
//
// El problema: count++ NO es una operación atómica (indivisible).
// En realidad son 3 pasos por separado:
//   1. LEER el valor actual de count
//   2. MODIFICARLO (sumarle 1)
//   3. ESCRIBIR el nuevo valor de vuelta
//
// Si dos threads hacen estos 3 pasos AL MISMO TIEMPO, se pueden
// "pisar" entre ellos y perder una actualización:
//
//   count vale 0
//   Thread A lee 0        Thread B lee 0     (ambos leen ANTES de escribir)
//   Thread A calcula 1    Thread B calcula 1
//   Thread A escribe 1    Thread B escribe 1
//
//   Resultado final: count = 1 (¡debería ser 2!)
//
// SIN synchronized (con el problema):
class CounterConRace {
    private int count = 0;

    public void increment() {
        count++; // NO es atómico -> puede haber race condition
    }
}

// CON synchronized (arreglado):
class CounterSinRace {
    private int count = 0;

    // synchronized asegura que SOLO UN thread a la vez pueda
    // ejecutar esta "sección crítica" para el mismo objeto.
    public synchronized void increment() {
        count++;
    }
}

// TAMBIÉN se puede arreglar con un bloque synchronized en vez
// de todo el método:
class CounterSinRaceConBloque {
    private int count = 0;
    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            count++;
        }
    }
}

// DEFINICIÓN CLAVE:
// "Sección crítica" (critical section) = el código que accede a
// datos mutables compartidos, y que NO debe ejecutarse por dos
// threads AL MISMO TIEMPO. El lock (synchronized) garantiza
// exclusión mutua sobre esa sección.