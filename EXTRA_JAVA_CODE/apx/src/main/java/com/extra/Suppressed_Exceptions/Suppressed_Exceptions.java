package com.extra.Suppressed_Exceptions;

public class Suppressed_Exceptions {
    public static void main(String[] args) {

        // ============================================================
        // CASO 1: solo close() lanza excepción (el try no lanza nada)
        // ============================================================
        // close() se llama automáticamente al terminar el try.
        // Si close() lanza una excepción, se puede atrapar normal con catch.
        try (JammedTurkeyCage t = new JammedTurkeyCage()) {
            System.out.println("put turkeys in");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
        }
        // Salida:
        // put turkeys in
        // caught: Cage door does not close

        System.out.println("----");

        // ============================================================
        // CASO 2: el try lanza una excepción Y close() también lanza
        // ============================================================
        // Aquí es donde entran las "suppressed exceptions".
        // ORDEN DE EVENTOS:
        // 1. El try lanza la excepción (esta es la PRINCIPAL / primary)
        // 2. Java automáticamente llama close() ANTES de llegar al catch
        // 3. close() también lanza una excepción -> como ya había una
        // excepción "primero", esta segunda se vuelve SUPPRESSED
        // (no reemplaza a la principal, se "adjunta" a ella)
        // 4. El catch atrapa la excepción PRINCIPAL (no la suprimida)
        try {
            try (JammedTurkeyCage t = new JammedTurkeyCage()) {
                throw new IllegalStateException("turkeys ran off"); // <- principal
            } catch (IllegalStateException e) {
                System.out.println("caught: " + e.getMessage()); // imprime la principal
                // getSuppressed() te da las excepciones "extra" que quedaron guardadas
                for (Throwable sup : e.getSuppressed()) {
                    System.out.println(sup.getMessage()); // imprime la de close()
                }
            }
        } catch (Exception ignored) {
        }
        // Salida:
        // caught: turkeys ran off
        // Cage door does not close

        System.out.println("----");

        // ============================================================
        // IMPORTANTE: el catch busca coincidencia con la excepción PRINCIPAL,
        // no con la suprimida. Si no coincide el tipo, no se atrapa nada.
        // ============================================================
        // Aquí el try lanza RuntimeException (principal), pero el catch
        // solo espera IllegalStateException -> NO coincide -> no se atrapa
        // -> la excepción sigue subiendo (se propaga al que llamó el método)
        //
        // try (JammedTurkeyCage t = new JammedTurkeyCage()) {
        // throw new RuntimeException("turkeys ran off");
        // } catch (IllegalStateException e) {
        // System.out.println("caught: " + e.getMessage());
        // }
        //
        // Como NO hay catch que coincida, el programa termina así:
        // Exception in thread "main" java.lang.RuntimeException: turkeys ran off
        // Suppressed: java.lang.IllegalStateException: Cage door does not close
        //
        // CLAVE: la excepción suprimida SIGUE GUARDADA aunque nadie
        // la atrape explícitamente en el código.

        System.out.println("----");

        // ============================================================
        // CASO 3: DOS recursos, ambos fallan al cerrar
        // ============================================================
        // Java cierra los recursos en ORDEN INVERSO a como se crearon.
        // t2 se crea después -> t2 se cierra PRIMERO.
        // El primer error en cerrar (t2) se vuelve la excepción PRINCIPAL.
        // El segundo error en cerrar (t1) se vuelve SUPPRESSED.
        try (JammedTurkeyCage t1 = new JammedTurkeyCage();
                JammedTurkeyCage t2 = new JammedTurkeyCage()) {
            System.out.println("turkeys entered cages");
        } catch (IllegalStateException e) {
            System.out.println("caught: " + e.getMessage());
            for (Throwable sup : e.getSuppressed()) {
                System.out.println(sup.getMessage());
            }
        }
        // Salida:
        // turkeys entered cages
        // caught: Cage door does not close <- del cierre de t2 (se cerró primero)
        // Cage door does not close <- del cierre de t1 (suprimida)

        System.out.println("----");

        // ============================================================
        // CASO 4 (TRAMPA): las suppressed exceptions SOLO aplican
        // a excepciones del TRY. El finally NO participa en esto.
        // ============================================================
        // Orden de eventos aquí:
        // 1. El try lanza IllegalStateException
        // 2. close() falla también -> se guarda como suppressed (por ahora)
        // 3. PERO luego corre el finally, y el finally lanza OTRA excepción
        // 4. Cuando un finally lanza excepción, esta GANA y REEMPLAZA
        // completamente a la anterior (junto con su suprimida)
        // -> la excepción original y su suppressed SE PIERDEN para siempre
        try {
            try (JammedTurkeyCage t = new JammedTurkeyCage()) {
                throw new IllegalStateException("turkeys ran off");
            } finally {
                throw new RuntimeException("and we couldn't find them");
            }
        } catch (RuntimeException e) {
            System.out.println("Excepcion final que sobrevive: " + e.getMessage());
            // e.getSuppressed() aquí estaría VACÍO, se perdió todo lo anterior
        }
        // Esto es mala práctica (se pierden excepciones), pero así funciona
        // Java por compatibilidad con versiones viejas (finally siempre "gana").
    }
}

// close() lanza una RuntimeException (IllegalStateException) -> no obliga a
// declarar/manejar nada especial en el compilador (no es checked)
class JammedTurkeyCage implements AutoCloseable {
    public void close() throws IllegalStateException {
        throw new IllegalStateException("Cage door does not close");
    }
}


//ORDEN CORRECTO PARA LOS TRY WITH RECOURSES
/*
1. Se ejecuta el try
2. Se cierran los recursos (en orden INVERSO a como se crearon)
3. Se ejecuta el catch (si aplica)
4. Se ejecuta el finally
*/

//EJM:

/* try (Auto a1 = new Auto(1); Auto a2 = new Auto(2)) {
    throw new RuntimeException();
} catch (Exception e) {
    System.out.println("ex");
} finally {
    System.out.println("finally");
} */

//PASO A PASO:

/* 
1. Se crean a1 (num=1) y a2 (num=2), en ese orden.
2. El try lanza RuntimeException() inmediatamente.
3. Antes de llegar al catch, Java cierra los recursos, en orden inverso: primero a2 → imprime Close: 2, luego a1 → imprime Close: 1.
4. Ya cerrados los recursos, ahora sí se ejecuta el catch → imprime ex.
5. Por último, el finally → imprime finally. */

/* Resultado
Close: 2
Close: 1
ex
finally */