package com.extra.Usando_InstanceOf;
class HeavyAnimal { }
class Hippo extends HeavyAnimal { }
class Elephant extends HeavyAnimal { }
interface Mother { }
class MotherHippo extends Hippo implements Mother { }

public class Usando_InstanceOf {
    public static void main(String[] args) {

        // instanceof: true si el objeto ES esa clase, subclase (directa o indirecta),
        // o implementa esa interfaz (directa o indirecta)
        HeavyAnimal hippo = new Hippo();
        boolean b1 = hippo instanceof Hippo; // true -> es instancia de sí mismo
        boolean b2 = hippo instanceof HeavyAnimal; // true -> es instancia de su superclase
        boolean b3 = hippo instanceof Elephant; // false -> no es un Elephant
        System.out.println(b1 + " " + b2 + " " + b3);

        // TODAS las clases heredan de Object -> instanceof Object normalmente es true
        boolean b4 = hippo instanceof Object; // true
        System.out.println(b4);

        // EXCEPCIÓN: null nunca es instanceof de nada, siempre da false
        Hippo nullHippo = null;
        boolean b5 = nullHippo instanceof Object; // false -> null NO es un Object
        System.out.println(b5);

        // instanceof con CLASES: el compilador SÍ valida la relación de herencia
        // Hippo no extiende Elephant ni directa ni indirectamente -> ERROR DE
        // COMPILACIÓN
        // Hippo anotherHippo = new Hippo();
        // boolean b6 = anotherHippo instanceof Elephant; // DOES NOT COMPILE

        // instanceof con INTERFACES: el compilador NO valida nada, se revisa en RUNTIME
        // Aunque Hippo no implemente Mother directamente, el compilador permite el
        // check
        // porque podría existir una subclase que sí la implemente (ej: MotherHippo)
        HeavyAnimal hippo2 = new Hippo();
        boolean b6 = hippo2 instanceof Mother; // compila bien, evalúa en runtime (false aquí)
        System.out.println(b6);

        HeavyAnimal motherHippo = new MotherHippo();
        boolean b7 = motherHippo instanceof Mother; // true -> esta subclase SÍ implementa Mother
        System.out.println(b7);

        // USO TÍPICO: instanceof antes de hacer un cast explícito, para evitar
        // ClassCastException. Es común en el examen, poco común en código real de
        // producción.
        feedAnimal(new Hippo());
    }

    // ejemplo de patrón instanceof + cast (estilo del libro, adaptado)
    public static void feedAnimal(HeavyAnimal animal) {
        if (animal instanceof Hippo) {
            System.out.println("Alimentando al hipopótamo");
        } else if (animal instanceof Elephant) {
            System.out.println("Alimentando al elefante");
        } else {
            throw new RuntimeException("Animal no soportado");
        }
    }
}
