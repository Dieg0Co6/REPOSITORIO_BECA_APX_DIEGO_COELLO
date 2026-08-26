package com.app.day_two.Understanding_Default_Initialization_of_Variables.Instance_and_Class_Variables;

public class Instance_and_Class_Variables {
    //LAS VARIABLES QUE NO SON LOCALES (QUE SE DECLARAN DENTRO DE UN METODO), SON LAS VARIABLES DE INSTANCIA O VARIABLES DE CLASE
    // ESTAS TAMBIÉN SON CONOCIDAS COMO CAMPOS Y SE COMPARTEN ENTRE MULTIPLES OBJETOS

    //Una variable es una variable de clase porque tiene la palabra clave static delante.

    //Las variables de instancia y de clase no requieren que las inicialices. Tan pronto como declares estas variables,
    // se les asigna un valor por defecto.

    //El compilador no sabe qué valor usar y por eso quiere el tipo más simple que pueda darle: null para un objeto
    // y 0/false para un primitivo.

    /* byte, short, int, long //se les asigna el valor 0 por defecto
    boolean //por defecto false
    float, double // 0.0
    char //'\u0000'
    cualquier objeto (incluido String) //null */
}
