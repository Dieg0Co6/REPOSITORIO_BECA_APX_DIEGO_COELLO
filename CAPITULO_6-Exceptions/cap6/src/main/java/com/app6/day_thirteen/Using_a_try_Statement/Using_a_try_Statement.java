package com.app6.day_thirteen.Using_a_try_Statement;

public class Using_a_try_Statement {
    //Ahora veremos como manejar las excepciones
    //Java utiliza una instrucción try para separar la lógica en sí del método, de la lógica para manejar esa excepción.

    /* try{
        También se conoce el bloque try como código protegido
    }catch( exception_type identifier (OBJETO DE EXCEPTIONA TRAPADO)){
        manejador de excepciones
    } */

    //El código en el bloque try se ejecuta normalmente.
    //Si alguna de las instrucciones lanza una excepción que pueda ser capturada por el tipo de excepción listado en el bloque catch,
    //el bloque try deja de ejecutarse y la ejecución pasa a la instrucción catch.

    // Si ninguna de las instrucciones en el bloque try lanza una excepción que pueda ser capturada, la cláusula catch no se ejecuta.

    //Como se ha visto, se ha utilizado 'block' (bloque) y 'clause' (clausula) de manera intercambiable. El examen también lo hace,
    //es para acostumbrarse. Ambas son correctas. “Bloque” es correcto porque hay llaves presentes. “Cláusula” es correcto porque
    //son parte de una instrucción try.

    /* void explore() {
        try {
            fall();
            System.out.println("never get here");
        } catch (RuntimeException e) {
            getUp();
        }
        seeAnimals();
    }
    void fall() {  throw new RuntimeException(); } 
    */

    //Primero, se llama al método fall() en el try. fall() lanza una excepción.
    //Esto significa que Java salta directamente al bloque catch, saltándose la línea donde se iba a imprimir "never get here".
    //Ahora pasa al catch donde se manejará la exception RuntimeException que se lanzó, en la cual ejecuta getUp().
    //Ahora la declaración try ha terminado y la ejecución continúa normalmente ejecutando el método seeAnimals().

    // Ahora veamos algunas declaraciones try inválidas con las que el examen podría intentar engañarme.

    /* try  // NO COMPILA
    fall();
    catch (Exception e) 
    System.out.println("get up"); */

    //NO COMPILA, PORQUE EL TRY/CATCH DEBEN ESTAR OBLIGATORIAMENTE CON LLAVES O BLOQUE DE CODIGO, TANTO EL TRY COMO EL CATCH
    //NO SON COMO EL IF, WHILE O FOR QUE LA PRIMERA INSTRUCCIÓN PUEDE IR SIN LLAVE.

    //El problema es que faltan las llaves. Tiene que verse así:

    /* try {
        fall();
    } catch (Exception e) {
        System.out.println("get up");
    } */

    // las llaves son necesarias incluso si solo hay una instrucción dentro de los bloques de código

    /* try { //NO COMPILA
        fall();
    } */

    //NO COMPILA PORQUE OBLIGATORIAMENTE DEBE TENER LA INSTRUCCIÓN DE CATCH, NO SOLAMANETE PUEDE IR EL TRY

    //Este código no se compila porque el bloque try no tiene nada después.
    //Recordar que el objetivo de una instrucción try es que algo ocurra si se lanza una excepción.
    //Sin otra cláusula, la instrucción try está solo

    //a continuación se verá sobre el finally
    //capturar diferentes tipos de excepciones y describir qué pasa si se lanza una excepción dentro de catch o finally

    public static void main(String[] args) {
        Using_a_try_Statement using_a_try_Statement = new Using_a_try_Statement();
        using_a_try_Statement.Adding_a_finally_Block();
    }

    public void Adding_a_finally_Block(){
        //La instrucción try también te permite ejecutar código al final con una cláusula finally,
        //sin importar si se lanza una excepción o no. Ejm:

        try{
            //cuerpo del bloque try
        }catch(Exception e){
            e.getMessage();     //cuerpo del bloque catch
        }finally{
            //cuerpo del bloque finally
            //El bloque finally siempre se ejecuta, ocurra o no una excepción en el bloque try.
        }

        /*
        Hay dos caminos a través del código con un catch y un finally.
        * Si se lanza una excepción, el bloque finally se ejecuta después del bloque catch. 
        * Si no se lanza ninguna excepción, el bloque finally se ejecuta después de que el bloque try termine.
        */

        //LA INSTRUCCIÓN CATCH NO ES OBLIGATORIO SI EL FINALLY ESTÁ PRESENTE.

        //Ejmplo con finally:

        /* void explore() {
            try {
                seeAnimals();
                fall();
            } catch (Exception e) {
                getHugFromDaddy();
            } finally {
                seeMoreAnimals();
            }
            goHome();
        } */

        //En el ejemplo, comienza con el try, en el cual se ejecuta fall() (se cae la chica).
        // Si se levanta sola, el código continúa al bloque finally y ejecuta el método seeMoreAnimals()
        //Luego la sentencia try termina y el código sigue y se ejecuta el método goHome().
        

        //En cambio, si la chica no se levanta sola, lanza una excepción. Se ejecuta el bloque catch
        //en el que se ejecuta el método getHugFromDaddy(), termina de ejecutar el bloque catch y pasa a ejecutarse el bloque finally
        // con el método seeMoreAnimals(). Luego la sentencia try termina y el código sigue ejecutandose con el bloque goHome()
        //De cualquier manera, el final es el mismo. El bloque finally se ejecuta y la sentencia try termina.

        //En el examen OCA, una declaración try debe tener catch y/o finally. Tener ambos está bien. No tener ninguno es un problema
        //En el examen OCA, puedes asumir que una declaración try es solo un try normal y no un try-with-resources.

        //El examen intentará engañarte con cláusulas faltantes o cláusulas en el orden incorrecto. 

        /* try { // NO COMPILA
            fall();
        } finally {
            System.out.println("all better");
        } catch (Exception e) {
            System.out.println("get up");
        } */

        /* try { // NO COMPILA
            fall();
        } */
            
        /* try {
            fall();
        } finally {
            System.out.println("all better");
        } */

        //El primer ejemplo NO COMPILA porque los bloques catch y finally están en el orden incorrecto.

        //El segundo ejemplo NO COMPILA porque debe haber un bloque catch o finally

        //El tercer ejemplo está bien. catch no es obligatorio si finally está presente.


        //Un problema con finally es que cualquier uso realista de él está fuera del alcance del examen OCA.
        //finally se utiliza para cerrar recursos como archivos o bases de datos, que son temas del examen OCP.
        //Esto significa que la mayoría de los ejemplos que encuentres en el examen OCA con finally van a parecer forzados.
        //Por ejemplo, te harán preguntas como qué imprime este código:

        String s = "";
        try {
            s += "t";
        } catch(Exception e) {
            s += "c";
        } finally {
            s += "f";
        }
        s += "a";
        System.out.print(s);

        //IMPRIME tfa , ya que no se lanzó ninguna excepcion, entonces, solo se ejecuta el try,luego el finally y después sale del bloque
        // try y sigue con ejecutando el codigo
        
        
        //IMPORTANTE:
        //System.exit(0) es un método especial que detiene el programa de inmediato, ahí mismo, sin importar en qué línea esté.
        //Si llamas a System.exit() dentro de un try o un catch, el bloque finally NO se ejecuta. 
        //El programa simplemente se apaga antes de llegar a esa parte.
        //EJM:

        /* try {
            System.out.println("Intentando...");
            System.exit(0); // el programa se cierra AQUÍ mismo
        } finally {
            System.out.println("Esto nunca se imprime"); // no se ejecuta
        } */
    }
}



