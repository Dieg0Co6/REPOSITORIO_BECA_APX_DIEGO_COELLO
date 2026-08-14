package com.app.day_two.Understanding_Variable_Scope;

public class Mouse {
    static int MAX_LENGTH = 5;   //ESTA ES UNA VARIABLE DE CLASE, SE RECONOCE POR LA PALABRA STATIC QUE ESTÁ DELANTE.
    int length;                 //ESTA ES UNA VARIABLE DE INSTANCIA, YA QUE NO SE ENCUENTRA DENTRO DE UN METODO,
                                //SINO COMO CAMPO DE UNA CLASE

    public void grow(int inches) { //ESTE ES UN METODO QUE TIENEN UNA VARIABLE LOCAL inches, su alcance es en todo el método
        if (length < MAX_LENGTH) {  
            int newSize = length + inches; //Aquí se declara e iniciliza esta variable local newSize
            length = newSize;
        }//Hasta esta linea de codigo tiene alcance la variable newSize
    }

    // Variables locales: en alcance desde la declaración hasta el final del bloque.
    // Variables de instancia: en alcance desde la declaración hasta que el objeto sea recolectado por el garbage collector.
    // Variables de clase: en alcance desde la declaración hasta que el programa termine.

    
}
