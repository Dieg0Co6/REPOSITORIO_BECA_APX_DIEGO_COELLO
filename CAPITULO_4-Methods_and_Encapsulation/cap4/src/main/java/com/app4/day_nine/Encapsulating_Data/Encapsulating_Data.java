package com.app4.day_nine.Encapsulating_Data;

public class Encapsulating_Data {
    public static void main(String[] args) {
        
        //Anteriormente teníamos una clase el cual no era private. ejm:
        /* public class Swan {
            int numberEggs;     // variable de instancia con modificador de acceso por defecto (package private)
        } */
        
        //Esto quiere decir, que cualquier objeto que se encuentre en el mismo package, puede acceder a ese dato y manipularlo. ejm:

        //mother.numberEggs = -1; 

        //Esto lógicamente es peligroso. Aquí es donde entra la ENCAPSULACIÓN DE DATOS.

        //La encapsulación significa que configuramos la clase de manera que solo los métodos dentro de la clase con las variables
        //puedan referirse a las variables de instancia. Se requiere que los que llamen a la clase usen estos métodos. EJM:

        /* public class Swan {
            private int numberEggs;                    // variable private. SOLO PUEDE USARSE EN LA MISMA CLASE
            public int getNumberEggs() {                    // getter
                return numberEggs;
            }
            public void setNumberEggs(int numberEggs) {     // setter
                if (numberEggs >= 0)                     // condición de protección
                    this.numberEggs = numberEggs;
                else
                    throw new IllegalArgumentException("No pueden ser negativos");
            } 
        } */


        //Para la encapsulación, recuerda que los datos (una variable de instancia) son privados y los getters/setters son públicos.
        //Java define una convención de nombres que se usa en JavaBeans.
        //Los JavaBeans son componentes de software reutilizables.
        //Los JavaBeans llaman propiedad a una variable de instancia.
        //Lo único que necesitas saber sobre JavaBeans para el examen son las convenciones de nombres que se listan a continuación:

        /* Reglas para las convenciones de nombres de JavaBeans
        *           Regla                                                                               Ejemplo
        * Las propiedades son privadas.                                                         private int numEggs;
        * Los métodos getter comienzan con 'is' si la propiedad es booleana.            public boolean isHappy() { return Happy;}
        * Los métodos getter comienzan con get si la propiedad no es booleana.          public int getNumEggs() { return numEggs;}
        * Los métodos setter comienzan con set.                                         public void setHappy(boolean happy) { this.happy = happy; }
        * El nombre del método debe tener un prefijo de set/get/is,                     public void setNumEggs(int num) { numEggs = num; }
        * seguido de la primera letra de la propiedad en mayúscula,
        * seguido del resto del nombre de la propiedad.
        */

        //Ejmplo para identificar cuales siguen las reglas de los JavaBeans:
        /* private boolean playing;            //bien
        private String name;                //bien
        public boolean getPlaying() { return playing; }     //esto no, debe ser isPlaying()
        public boolean isPlaying() { return playing; }      //esto está bien
        public String name() { return name; }               //esto está mal, debe ser getName()
        public void updateName(String n) { name = n; }      //esto está mal, debe ser setName(String n)
        public void setname(String n) { name = n; }         //esto está mal, debe ser setName(String n) (JAVA DISTINGUE ENTRE MAYUSCULAS Y MINUSCULAS)
         */

    }

    public void Creating_Immutable_Classes(){
        //Encapsular datos evita que los llamadores hagan cambios descontrolados en tu clase.
        //Otra técnica común es hacer que las clases sean inmutables para que no puedan cambiarse en absoluto.

        //Las clases inmutables son útiles porque sabes que siempre serán iguales.
        //Puedes pasarlas por tu aplicación con la garantía de que el llamador no cambió nada.

        //Un paso para hacer una clase inmutable es omitir los métodos setter.
        //Pero todavía queremos que el llamador pueda especificar el valor inicial, solo que no queremos que cambie después
        //de que se cree el objeto. Ahí es donde aparece el constructor.

        /* public class ImmutableSwan {
            private int numberEggs;     //variable private
            public ImmutableSwan(int numberEggs) {  //constructor 
                this.numberEggs = numberEggs;   //inicialización de la variable de instancia
            }
            public int getNumberEggs() {    //solo metodo setter
                return numberEggs;
            } 
        } */
        
        //Recordar que, lo inmutable solo se mide después de que el objeto ha sido construido.
        //Las clases inmutables pueden tener valores, simplemente no pueden cambiar después de la instanciación.

        //Tipos de retorno en clases inmutables:
        //Cuando se está escribiendo una clase inmutable,tener cuidado con los tipos de retorno.
        //A simple vista, esta clase parece ser inmutable ya que no tiene un setter:

        /* public class NotImmutable {
            private StringBuilder builder;      //variable de instancia privada
            public NotImmutable(StringBuilder b) {      //constructor
                builder = b;
            }
            public StringBuilder getBuilder() {     //este get devuelve el dato, pero StringBuilder es mutable.
                return builder;
            } 
        } */

        //NO ES INMUTABLE, SINO, CONSIDERA ESTE CODIGO:
        
        /* StringBuilder sb = new StringBuilder("initial");        //Se instancia la variable sb con tipo de dato StringBuilder
        NotImmutable problem = new NotImmutable(sb);        //Se instancia el objeto de la clase NotInmmutable con valor de sb
        sb.append(" added");        //acá se agrega un valor al objeto StringBuilder (initial added)
        StringBuilder gotBuilder = problem.getBuilder();  // acá obtenemos el valor del objeto que apunta a la variable problem.(initial added)
        gotBuilder.append(" more");         //acá al valor que obtenemos le añadimos el valor more. StringBuilder es mutable (initial added more)
        System.out.println(problem.getBuilder());       //acá devuelve el valor cambiado: initial added more. */

        //El problema es que solo estamos pasando el mismo StringBuilder por todas partes. 
        //El que llama tiene una referencia porque se pasó al constructor.
        //Cualquiera que llame al getter también obtiene una referencia.
        //Una solución es hacer una copia del objeto mutable. Esto se llama una copia defensiva.

        /* public Mutable(StringBuilder b) {
            builder = new StringBuilder(b);     //aquí hacemos una copia, apuntando a otro objeto StringBuilder
        }
        public StringBuilder getBuilder() {         
            return new StringBuilder(builder);      //Aquí retornamos otro objeto Stringbuilder con el valor del que se instanció en el objeto
        } */

        //Es decir, por cada instanciación y por cada llamado al getter, se va crear un nuevo objeto StringBuilder

        //Otro enfoque para el getter es devolver un objeto inmutable:
        /* public String getValue() {
            return builder.toString();
        } */

        //No hay ninguna regla que diga que tenemos que devolver el mismo tipo que estamos almacenando.
        //Devolver un string es seguro porque es inmutable desde el principio.

        //EN RESUMEN: la encapsulación se refiere a evitar que los que llaman cambien las variables de instancia directamente.
        //La inmutabilidad se refiere a evitar que los que llaman cambien las variables de instancia por completo.
    }
}
