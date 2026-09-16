package com.extra.Comparable;

import java.lang.reflect.Method;
import java.util.Comparator;

public class Comparable {
    // La interfaz Comparable tiene solo un método. De hecho, esta es toda la
    // interfaz:
    /*
     * public interface Comparable<T> {
     * public int compareTo(T o);
     * }
     */

    // Los genéricos permiten evitar el casting al implementar compareTo().
    // Cualquier objeto puede ser Comparable.EJM:

    // tenemos un montón de patos y queremos ordenarlos por nombre:

    /*
     * import java.util.*;
     * 
     * public class Duck implements Comparable<Duck> {
     * private String name;
     * 
     * public Duck(String name) {
     * this.name = name;
     * }
     * 
     * public String toString() { // usar salida legible
     * return name;
     * }
     * 
     * public int compareTo(Duck d) {
     * return name.compareTo(d.name); // llamar a compareTo de String
     * }
     * 
     * public static void main(String[] args) {
     * List<Duck> ducks = new ArrayList<>();
     * ducks.add(new Duck("Quack"));
     * ducks.add(new Duck("Puddles"));
     * Collections.sort(ducks); // ordenamos por nombre     //se usa acá el compareTo internamente
     * System.out.println(ducks); // [Puddles, Quack]
     * }
     * }
     */

    // La clase Duck implementa la interfaz Comparable. Sin implementar esa
    // interfaz,
    // lo único que tendríamos sería un método llamado compareTo(), pero no sería un
    // objeto Comparable.

    // la clase Duck implementa compareTo().
    // Como Duck está comparando objetos del tipo String y la clase String ya tiene
    // un método compareTo(), simplemente puede delegar.

    /* Qué devuelve el método compareTo() para poder escribir el nuestro?
        Hay tres reglas que debemos conocer:
     * ● Se devuelve el número cero cuando el objeto actual es igual al argumento de compareTo().
     * ● Se devuelve un número menor que cero cuando el objeto actual es más pequeño que el argumento de compareTo().
     * ● Se devuelve un número mayor que cero cuando el objeto actual es más grande que el argumento de compareTo().
     */

    //Echemos un vistazo a una implementación de compareTo() que compara números en lugar de objetos String:

    /* public class Animal implements java.util.Comparable<Animal> {
        private int id;
        public int compareTo(Animal a) { 
            return id - a.id; 
        } 
        public static void main(String[] args) { 
            Animal a1 = new Animal(); 
            Animal a2 = new Animal(); 
            a1.id = 5; 
            a2.id = 7; 
            System.out.println(a1.compareTo(a2)); // -2 
            System.out.println(a1.compareTo(a1)); // 0 
            System.out.println(a2.compareTo(a1)); // 2 
        }
    } */

    //Recuerda que id - a.id se ordena en orden ASCENDENTE y a.id - id se ordena en orden DESCENDENTE.

    //Al tratar con código HEREDADO, el método compareTo() requiere un CASTING ya que se le pasa un OBJECT:

    /* public class LegacyDuck implements java.util.Comparable { 
        private String name; 
        public int compareTo(Object obj) { 
            LegacyDuck d = (LegacyDuck) obj;   // casteo porque no hay genéricos
            return name.compareTo(d.name); 
        } 
    } */ 

    //Cuando escribes implements java.util.Comparable sin especificar el tipo genérico (es decir, sin <LegacyDuck>),
    //Java trata eso como un raw type (tipo crudo, sin genéricos). En ese caso, Java asume que el parámetro de compareTo() es de tipo Object

    //Dado que no especificamos un tipo genérico para Comparable, Java asume que queremos un Object,
    //lo que significa que tenemos que hacer un casting a LegacyDuck antes de acceder a sus variables de instancia.

    public static void main(String[] args) {
        Comparable comparable = new Comparable();
        comparable.Consistencia_compareTo_y_equals();
        comparable.Comparator();
        comparable.Una_manera_mas_facil_de_comparar_multiples_campos();

    }
    
    public void Consistencia_compareTo_y_equals(){
        //Si escribes una clase que implemente Comparable, estás introduciendo nueva lógica de negocio para determinar la igualdad.
        //El método compareTo() devuelve 0 si dos objetos son iguales, mientras que tu método equals() devuelve true si dos objetos son iguales.
        //Se dice que un orden natural que usa compareTo() es consistente con equals si, y solo si, x.equals(y) es verdadero siempre
        //que x.compareTo(y) sea igual a 0.

        //Se recomienda encarecidamente hacer que tus clases Comparable sean consistentes con equals porque no todas las clases de colección
        //se comportan de manera predecible si los métodos compareTo() y equals() no son consistentes. EJM:

        //Por ejemplo, la siguiente clase Product define un método compareTo() que no es consistente con equals:

        /* public class Product implements Comparable<Product> { 
            int id; 
            String name; 
        
            public boolean equals(Object obj) { 
                if (!(obj instanceof Product)) { 
                    return false; 
                } 
                Product other = (Product) obj; 
                return this.id == other.id; 
            } 
        
            public int compareTo(Product obj) { 
                return this.name.compareTo(obj.name); 
            }  
        }  */

        //Podrías estar ordenando objetos Product por nombre, pero los nombres no son únicos.
        //Por lo tanto, el valor de retorno de compareTo() podría no ser 0 al comparar dos objetos Product iguales,
        //así que este método compareTo() no es consistente con equals.
        

        //Una forma de solucionarlo es usar un Comparator para definir el orden en otro lugar.
        //Ahora que sabes cómo implementar objetos Comparable, puedes fijarte en los Comparators y centrarte en las diferencias.
    }

    public void Comparator(){
        //A veces quieres ordenar un objeto que no implementa Comparable, o quieres ordenar objetos de diferentes maneras en distintos momentos. 

        /* public class Duck implements Comparable<Duck> { 
            private String name; 
            private int weight; 
        
            public Duck(String name, int weight) { 
                this.name = name; 
                this.weight = weight; 
            } 
        
            public String getName() { return name; } 
            public int getWeight() { return weight; } 
            public String toString() { return name; } 
        
            public int compareTo(Duck d) { 
                return name.compareTo(d.name); 
            }

            public static void main(String[] args) { 
                Comparator<Duck> byWeight = new Comparator<Duck>() { 
                    public int compare(Duck d1, Duck d2) { 
                        return d1.getWeight() - d2.getWeight(); 
                    } 
                };

                List<Duck> ducks = new ArrayList<>(); 
                ducks.add(new Duck("Quack", 7)); 
                ducks.add(new Duck("Puddles", 10)); 
                Collections.sort(ducks); 
                System.out.println(ducks);   // [Puddles, Quack] 
                Collections.sort(ducks, byWeight); 
                System.out.println(ducks);  // [Quack, Puddles] 
            } 

        } */

        //Primero, definimos una clase interna con el COMPARATOR.
        //Luego ordenamos sin el COMPARATOR y con el COMPARATOR para ver la diferencia en el resultado.

        //Comparator es una interfaz funcional ya que solo hay un método abstracto por implementar.
        //Esto significa que podemos reescribir el comparador en el ejemplo anterior como cualquiera de los siguientes:

        /* Comparator<Duck> byWeight = (d1, d2) -> d1.getWeight() - d2.getWeight(); 
        Comparator<Duck> byWeight = (Duck d1, Duck d2) -> d1.getWeight() - d2.getWeight(); 
        Comparator<Duck> byWeight = (d1, d2) -> { return d1.getWeight() - d2.getWeight(); }; 
        Comparator<Duck> byWeight = (Duck d1, Duck d2) -> { return d1.getWeight() - d2.getWeight(); }; */

        //¿Es Comparable una Interfaz Funcional?
        //Comparable también es una interfaz funcional ya que también tiene un solo método abstracto.
        //Sin embargo, usar un lambda para Comparable sería tonto.
        //El punto de Comparable es implementarlo dentro del objeto que se está comparando.

        //Hay una buena cantidad de diferencias entre Comparable y Comparator.
        /*                                                     Comparable	        Comparator
        Paquete	                                               java.lang	        java.util
        ¿La implementa la clase que se compara?	                Sí	            No (es externa)
        Método	                                           compareTo(T o)	    compare(T o1, T o2)
        Parámetros	                                             1	                    2
        Uso común con lambda	                            No (raro)	        Sí (muy común) */

        /*
        Comparator<Duck> byWeight = new Comparator<Duck>() { // NO COMPILA
            public int compareTo(Duck d1, Duck d2) {        //Es compare no compareTo
                return d1.getWeight() - d2.getWeight(); 
            } 
        };*/

        //El nombre del método está mal. Un Comparator debe implementar un método llamado compare().

        //Presta especial atención a los nombres de los métodos y al número de parámetros cuando veas Comparator y Comparable en las preguntas.
    }

    public void Una_manera_mas_facil_de_comparar_multiples_campos(){
        //Cuando escribes un Comparator que compara múltiples variables de instancia, el código se vuelve un poco desordenado.
        //Supongamos que tenemos una clase Squirrel y asumimos que el nombre de la especie nunca será nulo.
        //Podríamos escribir un constructor para asegurarnos de eso si quisiéramos:

        /* public class Squirrel { 
            private int weight; 
            private String species; 
        
            public Squirrel(String theSpecies) { 
                if (theSpecies == null) throw new IllegalArgumentException(); 
                species = theSpecies; 
            } 
        
            public int getWeight() { return weight; } 
            public void setWeight(int weight) { this.weight = weight; } 
            public String getSpecies() { return species; } 
        }  */

        //Queremos escribir un Comparador para ordenar por nombre de especie.
        //Si dos ardillas son de la misma especie, queremos ordenar primero la que pesa menos.
        //Podríamos hacer esto con un código que se vea así:

        /*
        public class MultiFieldComparator implements Comparator<Squirrel> { 
            public int compare(Squirrel s1, Squirrel s2) { 
                int result = s1.getSpecies().compareTo(s2.getSpecies()); 
                if (result != 0) return result; 
                return s1.getWeight() - s2.getWeight(); 
            } 
        } */

        //Esto funciona. Comprueba un campo. Si no coinciden, terminamos de ordenar. Si coinciden, mira el siguiente campo.
        //Aunque, no es tan fácil de leer. También es fácil equivocarse. Cambiar != por == rompe por completo la ordenación.

        //Java 8 hace esto mucho más fácil. Con la introducción de métodos estáticos y por defecto en las interfaces,
        //ahora hay algunos métodos auxiliares nuevos en Comparator. El código ahora se puede escribir así:

        /* public class ChainingComparator implements Comparator<Squirrel> { 
            public int compare(Squirrel s1, Squirrel s2) { 
                Comparator<Squirrel> c = Comparator.comparing(s -> s.getSpecies()); //cuando se comparen objetos como String
                c = c.thenComparingInt(s -> s.getWeight());     //comparan con el primitivo int
                return c.compare(s1, s2); 
            } 
        } */

        //El lambda sirve para obtener el valor de la especie de la ardilla y pasarlo al método.
        //Verás mucho código de programación funcional en el próximo capítulo. Te concedemos que es el mismo número de líneas.

        // La segunda opción, sin embargo, es más fácil de leer. Describe muy bien lo que estamos haciendo.
        //Primero ordenamos por especie, y luego ordenamos por peso. Podríamos haber usado encadenamiento de métodos para escribir todo
        //esto en una sola línea.


        //Probablemente ya hayas notado que hemos ignorado los nulls al comprobar la igualdad y al comparar objetos.
        //Esto funciona bien para el examen. En el mundo real, sin embargo, las cosas no son tan ordenadas.
        //Tendrás que decidir cómo manejar los nulls o evitar que estén en tu objeto.
        //Es común decidir que los nulls se ordenen antes que cualquier otro valor.



        //Los métodos auxiliares que deberías conocer para construir un Comparator.
        //Hemos omitido los tipos de parámetros para que te concentres en los métodos. 
        //Usan muchas de las interfaces funcionales que aprendiste en el capítulo anterior.

        //TABLA 9.11 Métodos estáticos auxiliares para construir un Comparator

        /*Method                                                         Description
        comparing(function)                 Compara por los resultados de una función que devuelve cualquier objeto
                                            (o un primitivo convertido automáticamente en objeto).

        comparingDouble(function)           Compara según los resultados de la función que devuelve un doble.

        comparingInt(function)              Compara según los resultados de una función que devuelve un entero.

        comparingLong(function)             Compara según los resultados de la función que devuelve un long.

        naturalOrder()                      Ordena usando el orden especificado por la implementación de Comparable en el propio objeto.

        reverseOrder()                      Ordena usando el reverso del orden especificado por la implementación de Comparable en el propio objeto.

        */

        //La Tabla 9.12 muestra los métodos que puedes encadenar a un Comparator para especificar más su comportamiento. 
        //TABLA 9.12 Métodos predeterminados de ayuda para construir un Comparator

        /* 
        Method                                                          Description
        reversed()                                      Orden inverso del Comparator encadenado.

        thenComparing(function)             Si el comparador anterior devuelve 0, usa este comparador que devuelve un Objeto o que
                                            se puede convertir automáticamente en uno.

        thenComparingDouble(function)       Si el comparador anterior devuelve 0, usa este comparador que devuelve double. De lo contrario, 
                                            devuelve el valor del comparador anterior.
                                            
        thenComparingInt(function)          Si el comparador anterior devuelve 0, usa este comparador que devuelve int. 
                                            De lo contrario, devuelve el valor del comparador anterior.
                            
        thenComparingLong(function)         Si el comparador anterior devuelve 0, usa este comparador que devuelve un long.
                                            De lo contrario, devuelve el valor del comparador anterior.
        */


    }
}
