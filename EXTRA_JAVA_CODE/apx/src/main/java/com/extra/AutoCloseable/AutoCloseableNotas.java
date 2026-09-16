package com.extra.AutoCloseable;

public class AutoCloseableNotas {
    public static void main(String[] args) {

        // Solo clases que implementan AutoCloseable pueden ir en try-with-resources
        try (TurkeyCage t = new TurkeyCage()) {
            System.out.println("put turkeys in");
        }
        // Turkey (sin implementar AutoCloseable) -> DOES NOT COMPILE si se pone en el try(...)


        // AutoCloseable exige implementar: public void close() throws Exception;
        // El override PUEDE declarar menos (o ninguna) excepción -> eso está permitido
        // TurkeyCage.close() no declara ninguna excepción, y es válido


        // Si close() lanza una EXCEPCIÓN CHECKED, el método que la usa
        // debe manejarla o declararla, si no -> DOES NOT COMPILE
        try {
            try (StuckTurkeyCage s = new StuckTurkeyCage()) {
                System.out.println("put turkeys in");
            }
        } catch (Exception e) {
            System.out.println("Excepcion checked manejada: " + e.getMessage());
        }
        // si no hubiera try/catch (o "throws Exception" en main), no compilaría


        // BUENA PRÁCTICA (no obligatoria): close() debe lanzar excepciones
        // ESPECÍFICAS, no "Exception" genérica
        // ExampleOne (IllegalStateException) es mejor que ExampleTwo (Exception)


        // BUENA PRÁCTICA (no obligatoria): close() debe ser IDEMPOTENTE
        // (llamarlo varias veces no debe tener efectos secundarios raros)
        // ExampleThree ROMPE esta regla porque modifica un contador (side effect)
    }
}

// Turkey NO implementa AutoCloseable -> no puede usarse en try-with-resources
class Turkey {
}

// TurkeyCage SÍ implementa AutoCloseable -> se puede usar en try-with-resources
class TurkeyCage implements AutoCloseable {
    public void close() {
        System.out.println("Close gate");
    }
}

// close() puede lanzar excepción CHECKED -> obliga a manejarla o declararla afuera
class StuckTurkeyCage implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}

// BUENA práctica: excepción específica, no "Exception" genérica
class ExampleOne implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}

// MALA práctica: usa "Exception" genérica en vez de una más específica
class ExampleTwo implements AutoCloseable {
    public void close() throws Exception {
        throw new Exception("Cage door does not close");
    }
}

// MALA práctica: no es idempotente, tiene un side effect (modifica COUNT)
class ExampleThree implements AutoCloseable {
    static int COUNT = 0;
    public void close() {
        COUNT++;
    }
}

// Closeable existe desde ANTES de Java 7 (AutoCloseable es más nuevo, de Java 7)
// Closeable es MÁS ESTRICTO que AutoCloseable en 2 cosas:
//   1. close() solo puede lanzar IOException (no cualquier Exception)
//   2. close() está OBLIGADO a ser idempotente (con AutoCloseable es solo recomendado)
//
// Por compatibilidad hacia atrás, Java NO modificó Closeable.
// En vez de eso, hicieron AutoCloseable (más flexible), y Closeable
// pasó a EXTENDER AutoCloseable, ya que cumple con todo lo que pide.
interface CloseableEjemplo extends AutoCloseable {
    // como en la interfaz real java.io.Closeable
    void close() throws java.io.IOException;
}