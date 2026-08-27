package com.app5.day_eleven.Creating_Abstract_Classes;

public class Creating_Abstract_Classes {

    //Una clase abstracta es una clase marcada con la palabra clave abstract y NO SE PUEDE INSTANCIAR.
    //Un método abstracto es un método marcado con la palabra clave abstract definido en una clase abstracta,
    //para el cual no se proporciona implementación en la clase donde se declara.

    //Ejmplo:
    public abstract class Animal {  //clase abstracta
        protected int age;
        public void eat() { 
            System.out.println("Animal is eating");
        }
        public abstract String getName();   //metodo abstracto
    }

    public class Swan extends Animal {
        public String getName() {
            return "Swan";
        }
    }

    //Lo primero que hay que notar sobre este ejemplo de código es que la clase Animal se declara como abstracta y Swan no lo es.
    //Después, el miembro age y el método eat() están marcados como protected y public, respectivamente; por lo tanto, son heredados
    //en subclases como Swan. Finalmente, el método abstracto getName() termina con un punto y coma y no tiene cuerpo en la clase
    //padre Animal. Este método se implementa con el mismo nombre y firma que el método padre en la clase Swan.

    //Una clase abstract puede declarar métodos abstract para obligar a sus subclases concretas a proporcionar una implementación de esos métodos.

    public static void main(String[] args) {
        Creating_Abstract_Classes creating_Abstract_Classes = new Creating_Abstract_Classes();
        creating_Abstract_Classes.Defining_an_Abstract_Class();
        creating_Abstract_Classes.Creating_a_Concrete_Class();
        creating_Abstract_Classes.Extending_an_Abstract_Class();
    }

    public void Defining_an_Abstract_Class(){
        //Una clase abstracta puede incluir métodos y variables no abstractos
        //Como se vio en el ejemplo anterior, donde ni age ni eat() eran abstractos.

        //De hecho, no se requiere que una clase abstracta incluya algún método abstracto.
        //Por ejemplo, el siguiente código se compila sin problemas aunque no defina ningún método abstracto:

        /* public abstract class Cow {
        } */

        //Aunque una clase abstracta no tiene que implementar ningún método abstracto, un método abstracto solo puede definirse en una clase abstracta.
        //Por ejemplo, el siguiente código no se compilará porque un método abstracto no está definido dentro de una clase abstracta:

        /* public class Chicken {
            public abstract void peck();  // NO COMPILA PORQUE SI ES UN METODO ABSTRACTO, DEBE ESTAR EN UNA CLASE ABSTRACTA.
        } */

        //A los creadores de exámenes les gustan las preguntas que mezclan clases no abstractas con métodos abstractos.
        //También les gustan las preguntas con métodos marcados como abstractos para los cuales también se define una implementación.
        //Por ejemplo, ninguno de los métodos en el siguiente código se compilará porque los métodos están marcados como abstractos:

        /* public abstract class Turtle {      //CLASE ABSTRACTA
            public abstract void swim() {} //NO COMPILA, PORQUE SE ESTÁ COLOCANDO LLAVES DE CUERPO DEL METODO ABSTRACTO (ESO YA INDICA IMPLEMENTACIÓN)
            public abstract int getAge() {  //NO COMPILA, PORQUE SE ESTÁ IMPLEMENTANDO UN METODO ABSTRACTO
                return 10;
            }
        } */


        //TENER CUIDADO, El primer método, swim(), no compila porque se proporcionan dos llaves en lugar de un punto y coma,
        //y Java interpreta esto como si se le estuviera dando un cuerpo a un método abstracto.
        //El segundo método, getAge(), no compila porque también le da un cuerpo a un método abstracto.

        /* Implementaciones de métodos por defecto en clases abstractas 
        ==============================================================================
        Aunque no puedes proporcionar una implementación por defecto a un método abstracto en una clase abstracta,
        aún puedes definir un método con cuerpo; simplemente no puedes marcarlo como abstracto.
        Mientras no lo marques como final, la subclase todavía tiene la opción de sobrescribirlo
        */

        //UNA CLASE ABSTRACTA NO PUEDE SER MARCADA COMO FINAL POR UNA RAZÓN MUY OBVIA
        //Por definición, una clase abstracta es una que debe ser extendida por otra clase para poder ser instanciada,
        //mientras que una clase final no puede ser extendida por otra clase.
        //Al marcar una clase abstracta como final, estás diciendo que la clase nunca podrá ser extendida.
        //así que el compilador se niega a procesar el código. EJM:

        /* public final abstract class Tortoise {  // NO COMOPILA PORQUE DICE TIENE EL ABSTRACT Y EL FINAL
        } */


        //DE LA MISMA MANERA, UN MÉTODO ABSTRACTO NO PUEDE MARCARSE COMO FINAL, AL IGUAL QUE UNA CLASE ABSTRACTA NO PUEDE MARCARSE COMO FINAL
        // Una vez marcado como final, el método nunca se podrá sobrescribir en una subclase,
        // lo que hace imposible crear una instancia concreta de la clase abstracta.

        /* public abstract class Goat {
            public abstract final void chew();  // NO COMPILA
        } */

        //FINALMENTE, UN MÉTODO NO PUEDE ESTAR MARCADO COMO ABSTRACT Y PRIVATE AL MISMO TIEMPO
        //Esta regla tiene sentido.¿Cómo definirías una subclase que implemente un método obligatorio si el método no es
        //accesible por la propia subclase? La respuesta es que no se puede, y por eso el compilador se quejará.

        /* public abstract class Whale {
            private abstract void sing();  // no compila porque tiene abstract y private
            }
        
        public class HumpbackWhale extends Whale {
            private void sing() {       //no va poder acceder a este metodo
                System.out.println("Humpback whale is singing");
            }
        } */

        //El método abstracto sing() definido en la clase padre Whale no es visible para la subclase HumpbackWhale
        //Aunque HumpbackWhale sí proporciona una implementación, no se considera una sobrescritura del método abstracto ya que
        //el método abstracto no es accesible. El compilador reconoce esto en la clase padre y lanza una excepción tan pronto como
        //se aplican private y abstract al mismo método.

        //Ahora, si cambiamos de private a protected. Pasa lo siguiente:

        /* public abstract class Whale {
            protected abstract void sing();     //metodo abstract y protected
        }

        public class HumpbackWhale extends Whale {
            private void sing() {  // NO COMPILA PORQUE ES PRIVATE (DEBE SER PROTECTED O PUBLIC)
                System.out.println("Humpback whale is singing");
            }
        } */

        //El código aún no se compilará, debido a las reglas mencionadas sobre cómo sobrescribir un método,
        //la subclase no puede reducir la visibilidad del método del padre, sing().
        //Como el método está declarado como protegido en la clase padre, debe marcarse como protegido o público en la clase hija.
        //Incluso con métodos abstractos, se deben seguir las reglas para sobrescribir métodos.
    }

    public void Creating_a_Concrete_Class(){
        //RECORDAR QUE LAS CLASES ABSTRACTAS, POR SÍ SOLAS NO SE PUEDEN INSTANCIAR.
        //Y por lo tanto no hacen mucho más que definir variables y métodos estáticos.

        // Por ejemplo, el siguiente código no se compilará ya que es un intento de instanciar una clase abstracta.

        /* public abstract class Eel {
            public static void main(String[] args) {
                final Eel eel = new Eel();  // NO COMPILA PORQUE SE ESTÁ INSTANCIANDO UNA CLASE ABSTRACTA.
            }
        } */

        //Una clase abstracta se vuelve útil cuando es extendida por una subclase concreta.
        //Una clase concreta es la primera subclase no abstracta que extiende una clase abstracta
        //y SE REQUIERE QUE IMPLEMENTE TODOS LOS MÉTODOS ABSTRACTOS HEREDADOS.

        //Cuando vea una clase concreta extendiendo una clase abstracta en el examen,
        //ASEGURARSE DE QUE IMPLEMENTE TODOS LOS MÉTODOS ABSTRACTOS REQUERIDOS

        /* public abstract class Animal {
            public abstract String getName();
        }

        public class Walrus extends Animal { //NO COMPILA, YA QUE NO ESTÁ IMPLEMENTANDO EL METODO ABSTRACTO HEREDADO.
        } */

        //Primero, nota que Animal está marcado como abstracto y Walrus no.
        //En este ejemplo, Walrus se considera la primera subclase concreta de Animal.
        //Segundo, dado que Walrus es la primera subclase concreta, debe implementar todos los métodos abstractos heredados,
        //getName() en este ejemplo. Como no lo hace, el compilador rechaza el código.
        
        //El punto clave es que la primera clase que extiende la clase no abstracta debe implementar todos los métodos abstractos heredados.

        /* public abstract class Animal {
            public abstract String getName();
        }
        public class Bird extends Animal { //NO COMPILA PORQUE LA PRIMERA CLASE CONCRETA DEBE IMPLEMENTAR TODOS LOS MÉTODOS ABSTRACTOS HEREDADOS

        }

        public class Flamingo extends Bird {
            public String getName() {
                return "Flamingo";
            }
        } */

        //Aunque una segunda subclase Flamingo implementa el método abstracto getName(),
        //la primera subclase concreta Bird no lo hace; por lo tanto, la clase Bird no compilará.

    }

    public void Extending_an_Abstract_Class(){
        /*
            TENER EN CUENTA QUE:
            * Si puedes tener una cadena de varias clases abstractas. No es obligatorio que la clase que extiende a una clase abstracta sea concreta.
            * Una clase abstracta puede heredar métodos abstractos sin implementarlos.
            * La clase concreta, al ser instanciable, debe haber implementado todos los métodos abstractos que haya heredado.
        */

        /* abstract class Animal {
            abstract void hacerSonido();
        }

        abstract class Mamifero extends Animal {
            abstract void amamantar();
        }

        abstract class Perro extends Mamifero {
            abstract void ladrar();
        }

        class Labrador extends Perro {

            @Override
            void hacerSonido() {
                System.out.println("Sonido");
            }

            @Override
            void amamantar() {
                System.out.println("Amamantando");
            }

            @Override
            void ladrar() {
                System.out.println("Guau");
            }
        } */

        //OTRO EJM:

        /* public abstract class Animal {
            public abstract String getName();
        }

        public class Walrus extends Animal { // NO COMPILA, PORQUE COMO NO ES ABSTRACTA, DEBE IMPLEMENTAR EL METODO ABSTRACTO DE ANIMAL
        }

        public abstract class Eagle extends Animal {    //SI COMPILA PORQUE COMO TMB ES ABSTRACTA, NO ES NECESARIO QUE IMPLEMENTE UN METODO
        } */

        //Tenemos una clase abstracta Animal con una subclase concreta Walrus que no compila porque no implementa un método getName().
        //También tenemos una clase abstracta Eagle, que al igual que Walrus extiende Animal y no proporciona una implementación para getName().
        //En esta situación, Eagle sí compila porque está marcada como abstracta.

        //Las clases abstractas pueden extender otras clases abstractas y no se les exige proporcionar
        //implementaciones para ninguno de los métodos abstractos. 
        //De esto se sigue que una clase concreta que extiende una clase abstracta debe implementar todos los métodos abstractos heredados.

        /* public abstract class Animal {
            public abstract String getName();
        }
        public abstract class BigCat extends Animal {
            public abstract void roar();
        }

        public class Lion extends BigCat {
            public String getName() {
                return "Lion";
            }
            public void roar() {
                System.out.println("The Lion lets out a loud ROAR!");
            }
        } */

        //EL CODIGO ANTERIOR SI COMPILA. Y ADEMÁS TENER EN CUENTA QUE LION DEBE IMPLEMENTAR LOS MÉTODOS ABSTRACTOS getName() de Animal
        //y roar() de BigCat.

        //Hay una excepción a la regla para métodos abstractos y clases concretas:
        //Una subclase concreta no está obligada a proporcionar una implementación para un método abstracto
        //si una clase abstracta intermedia ya proporciona la implementación. 

        //Una subclase concreta no necesita implementar un método abstracto si una superclase intermedia ya lo implementó.

        //EJM:

        /* public abstract class Animal {
            public abstract String getName();
        }

        public abstract class BigCat extends Animal {
            public String getName() {
                return "BigCat";
            }
            public abstract void roar();
        }

        public class Lion extends BigCat {
            public void roar() {
                System.out.println("The Lion lets out a loud ROAR!");
            }
        } */


        //En este ejemplo, BigCat proporciona una implementación para el método abstracto getName() definido en la clase abstracta Animal.
        //Por lo tanto, Lion solo hereda un método abstracto, roar(), y no está obligado a proporcionar una implementación para el método getName()
        //PUEDE IMPLEMENTARLO IGUAL, PERO NO ESTÁ OBLIGADO.


        /*
        REGLAS PARA LA DEFINICIÓN DE CLASES ABSTRACTAS
        ================================================================================================================================================
        * 1. Las clases abstractas no se pueden instanciar directamente.
        * 2. Una clase abstracta puede tener cualquier cantidad de métodos abstractos y de métodos concretos, incluso puede no tener ningún método.
        * 3. Las clases abstractas no pueden marcarse como privadas o finales.
        * 4. Una clase abstracta que extiende a otra clase abstracta hereda todos sus métodos abstractos como sus propios métodos abstractos.
        * 5. La primera clase concreta que extiende una clase abstracta debe proporcionar una implementación para todos los métodos abstractos heredados. 
        */

        /*
        REGLAS PARA LA DEFINICIÓN DE MÉTODOS ABSTRACTOS
        ================================================================================================================================================
        * 1. Los métodos abstractos solo se pueden definir en clases abstractas.
        * 2. Los métodos abstractos no pueden declararse como privados o finales.
        * 3. Los métodos abstractos no deben proporcionar un cuerpo/implementación en la clase abstracta en la que se declaran.
        * 4. Implementar un método abstracto en una subclase sigue las mismas reglas que sobrescribir un método.
        * Por ejemplo, el nombre y la firma deben ser los mismos, y la visibilidad del método en la subclase debe ser al menos tan
        * accesible como la del método en la clase padre.
        */
    }

}
