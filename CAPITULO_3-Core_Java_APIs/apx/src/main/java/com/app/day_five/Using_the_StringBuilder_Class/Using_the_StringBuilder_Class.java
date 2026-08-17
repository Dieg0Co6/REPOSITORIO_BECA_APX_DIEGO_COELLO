package main.java.com.app.day_five.Using_the_StringBuilder_Class;

public class Using_the_StringBuilder_Class {
    public static void main(String[] args) {
        //Un programa pequeño puede crear muchos objetos String muy rápido.
        // Por ejemplo, ¿cuántos crees que crea este fragmento de código?

        String alpha = "";  //objeto 1
        for(char current = 'a'; current <= 'z'; current++) 
            alpha += current;
        System.out.println(alpha); //27 objetos creados


        //De los 27 objetos,La mayoría de los cuales son elegibles para la recolección de basura inmediatamente. Esto es muy ineficiente. 
        //Por suerte, Java tiene una solución. La clase StringBuilder crea un String sin almacenar todos esos valores intermedios de String.
        // A diferencia de la clase String, StringBuilder no es INMUTABLE.
        StringBuilder alpha1 = new StringBuilder();
        for(char current = 'a'; current <= 'z'; current++) 
            alpha1.append(current);
        System.out.println(alpha1);

        //En la línea 17, se crea un nuevo objeto StringBuilder. La llamada a append() en la línea 19 añade un carácter al objeto StringBuilder
        //cada vez que se ejecuta el bucle for y agrega el valor de current al final de alpha.
        //Este código reutiliza el mismo StringBuilder sin crear un String intermedio cada vez.

        //QUIERE DECIR QUE EN ESTE CASO EL STRINGBUILDER SI MODIFICA EL MISMO OBJETO, A DIFERENCIA DEL STRING QUE CREA 27 OBJETOS.

        Using_the_StringBuilder_Class using_the_StringBuilder_Class = new Using_the_StringBuilder_Class();
        using_the_StringBuilder_Class.Mutability_and_Chaining();
        using_the_StringBuilder_Class.Creating_a_StringBuilder();
        using_the_StringBuilder_Class.Important_StringBuilder_Methods();
        using_the_StringBuilder_Class.StringBuilder_vs_StringBuffer();
    }

    public void Mutability_and_Chaining(){
        //StringBuilder no es inmutable.
        //Probablemente el examen intentará confundirte respecto a que String y StringBuilder son mutables.

        //Encadenar hace esto aún más interesante. Cuando enlazamos llamadas a métodos de String,
        //el resultado era un nuevo String con la respuesta.

        //Con StringBuilder es diferente. El StringBuilder cambia su propio estado y devuelve una referencia a sí mismo.

        StringBuilder sb = new StringBuilder("start");
        sb.append("+middle");                      // sb = "start+middle" 
        StringBuilder same = sb.append("+end");    // "start+middle+end"

        //La línea 42 añade texto al final de sb. También devuelve una referencia a sb, que se ignora.
        //La línea 43 también añade texto al final de sb y devuelve una referencia a sb.
        //Esta vez la referencia se guarda en same, lo que significa que sb y same apuntan al mismo objeto exacto y mostrarían el mismo valor.


        //TENER CUIDADO: El examen no siempre hará que el código sea fácil de leer usando solo un método por línea.EJMPLO

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a);       //abcdefg
        System.out.println("b=" + b);       //abcdefg

        //Aquí solo hay un objeto StringBuilder.
        //Se sabe porque new StringBuilder() se llamó solo una vez.
        //En la línea 53, hay dos variables que se refieren a ese objeto, que tiene un valor de "abcde".
        //En la línea 54, esas dos variables siguen refiriéndose al mismo objeto, que ahora tiene un valor de "abcdefg".

        //TENER EN CUENTA QUE: la asignación de b no hace absolutamente nada. b ya está apuntando a ese StringBuilder.
    }

    //Creando un StringBuilder
    public void Creating_a_StringBuilder(){
        //HAY 3 MANERAS DE CONSTRUIR UN STRINGBUILDER:
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("animal");
        StringBuilder sb3 = new StringBuilder(10);      //LE INDICA LA CANTIDAD DE ESPACIOS PARA LOS CARACTERES (CAPACIDAD)

        //El primero dice que se cree un StringBuilder que contenga una secuencia vacía de caracteres y que se asigne sb1 para apuntar a él.
        //El segundo dice que se cree un StringBuilder que contenga un valor específico y que se asigne sb2 para apuntar a él.
        //Para los dos primeros, le indica a Java que maneje los detalles de implementación.
        //El ejemplo final le dice a Java que tenemos cierta idea de qué tan grande será el valor final y que nos gustaría que el StringBuilder
        //reserve cierto número de espacios para los caracteres.

        //TENER EN CUENTAS: SIZE VS CAPACITY
        //El tamaño es el número de caracteres que hay actualmente en la secuencia, y la capacidad es el número de caracteres que
        //la secuencia puede contener actualmente. Como un String es inmutable, el tamaño y la capacidad son iguales.
        //El número de caracteres que aparecen en el String es tanto el tamaño como la capacidad.
        //Para StringBuilder, el tamaño probablemente cambiará a medida que se use el objeto.
        //Cuando se construye un StringBuilder, puede empezar con la capacidad predeterminada (que resulta ser 16) o con una capacidad
        //que el programador elija.

        StringBuilder sb = new StringBuilder(5);    //0 1 2 3 4 (posiciones de los caracteres)
        sb.append("anim");          
        /*  a n i m
            0 1 2 3 4 */
    }

    public void Important_StringBuilder_Methods(){
        //LOS MÉTODOS STRINGBUILDER QUE PODRÍA VER EN EL EXAMEN SON LOS SIGUIENTES:
        // charAt(), indexOf(), length(), and substring()   //FUNCIONAN IGUAL QUE LOS METODOS STRING. ESTOS METODOS NO MODIFICAN EL OBJETO
        //append(), insert(), delete(), replace(), reverse() //ESTOS METODOS SI MODIFICAN EL OBJETO STRINGBUILDER
    
        StringBuilder sb = new StringBuilder("animals");        //Se instancia un objeto StringBuilder con valor animals
        String sub = sb.substring(sb.indexOf("a"), sb.indexOf("al"));    //cambia el valor de sb a anim y tmb tiene otra referencia: sub
        int len = sb.length();          //sb.length es 7 y se le asigna a la variable len.
        char ch = sb.charAt(6);     //S
        System.out.println(sub + " " + len + " " + ch);     //anim    7      s

        //TENER EN CUENTA QUE: substring() devuelve un String en lugar de un StringBuilder.
        //Por eso sb no cambia. substring() es realmente solo un método que pregunta dónde se encuentra la subcadena.

        append();
        insert();
        delete_and_deleteCharAt();
        reverse();
        to_String();
    }

    private void append(){
        //Es el método más utilizado en StringBuilder.
        //agrega el parámetro al StringBuilder y devuelve una referencia al StringBuilder actual.
        //Su firma es la siguiente:

        //StringBuilder append(String str)
        StringBuilder sb = new StringBuilder().append(1).append('c');
        sb.append("-").append(true);
        System.out.println(sb);      // 1c-true

        //CON ESTO NOS DIMOS CUENTA QUE: se puede llamar a append() sin tener que convertir tu parámetro a un String primero.
    }

    private void insert(){
        //Agrega caracteres al StringBuilder en el índice solicitado y devuelve una referencia al StringBuilder actual.
        //Su firma es la siguiente:
        //StringBuilder insert(int offset, String str)          //Se le pasa la posición o indice y el valor que se quiere insertar

        StringBuilder sb = new StringBuilder("animals");     
        sb.insert(7, "-");                   // sb = animals-        
        sb.insert(0, "-");                   // sb = -animals-       //SE INSERTA ANTES DEL INDICE INDICADO
        sb.insert(4, "-");                   // sb = -ani-mals      //COMO ES EL MISMO OBJETO, AHORA QUEDARÍA ASÍ
        System.out.println(sb);
    }

    private void delete_and_deleteCharAt(){
        //El método delete() es el opuesto del método insert().
        //Elimina caracteres de la secuencia y devuelve una referencia al StringBuilder actual.
        //El método deleteCharAt() es útil cuando quieres eliminar solo un carácter. Las firmas de los métodos son las siguientes:

        //StringBuilder delete(int start, int end)
        //StringBuilder deleteCharAt(int index)

        StringBuilder sb = new StringBuilder("abcdef");
        sb.delete(1, 3);                  // sb = adef
        sb.deleteCharAt(5);                   // throws an exception        //LANZA ERROR PORQUE AHORA SOLO TENEMOS "adef"
    }

    private void reverse(){
        //Invierte los caracteres en las secuencias y devuelve una referencia al StringBuilder actual.
        //La firma del método es la siguiente:

        //StringBuilder reverse()

        StringBuilder sb = new StringBuilder("ABC");
        sb.reverse();       //CBA
        System.out.println(sb);
    }

    private void to_String(){
        //Convierte un StringBuilder en una String. La firma del método es la siguiente:
        //String toString()

        String s = sb.toString();

        //A menudo se usa StringBuilder internamente por razones de rendimiento, pero el resultado final necesita ser un String.
        //Por ejemplo, tal vez necesite pasarse a otro método que espere un String.
    }

    public void StringBuilder_vs_StringBuffer(){
        //Cuando escribas código nuevo que concatene muchos objetos String, deberías usar StringBuilder.
        //Si te encuentras con código más antiguo, verás que se usa StringBuffer para este propósito.
        //StringBuffer hace lo mismo, pero más lento porque es seguro para hilos.
    }
}
