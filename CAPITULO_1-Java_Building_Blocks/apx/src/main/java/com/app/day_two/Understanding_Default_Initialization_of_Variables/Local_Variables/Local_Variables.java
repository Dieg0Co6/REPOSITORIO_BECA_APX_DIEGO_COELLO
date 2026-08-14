package com.app.day_two.Understanding_Default_Initialization_of_Variables.Local_Variables;

public class Local_Variables {
    
    //LAS VARIABLES LOCALES SON VARIABLES DEFINIDAS DENTRO DE UN METODO
    //ESTAS VARIABLES SE DEBEN ENCONTRAR INICIALIZADAS ANTES DE USARSE. YA QUE NO TIENEN UN VALOR POR DEFECTO.

    public int notValid() {
        int y = 10; 
        int x; 
        int reply = x + y; // No compila ya que la variable reply se le asigna x + y, pero x no se encuentra inicializada
                            //Hasta que a x se le asigne un valor, no puede aparecer dentro de una expresion
        return reply;
    }

    public int valid() { //Este metodo si compila
        int y = 10;
        int x; // Aquí se declara la variable pero no se ha inicializado. AÚN NO SE PUEDE COLOCAR DENTRO DE UNA EXPRESION
        x = 3; // Aquí ya se inicializó, ya puede aparecer en una expresión a partir de la siguiente linea de codigo
        int reply = x + y;
        return reply;
    }

    public void findAnswer(boolean check) {
        int answer; //Aquí se declara la variable answer
        int onlyOneBranch;   //Aquí se declara la variable onlyOneBranch
        if (check) {
            onlyOneBranch = 1;  //Sí check es true entonces se inicializan las variables
            answer = 1;
        } else {
            answer = 2; //pero si check es false, solo se inicializa answer, NO SE INICIALIZA onlyOneBranch. POR LO TANTO,
                        // onlyOneBranch NO PUEDE APARECER EN UNA EXPRESION.
        }
        System.out.println(answer);
        System.out.println(onlyOneBranch); // NO COMPILA, PORQUE APARECE EN UNA EXPRESION Y NO SE ASEGURA SU INICIALIZACION
                                            //COMO HAY UNA POSIBILIDAD DE QUE NO SEA INICIALIZADO, ENTONCES ARROJA ERROR.
    }
}
