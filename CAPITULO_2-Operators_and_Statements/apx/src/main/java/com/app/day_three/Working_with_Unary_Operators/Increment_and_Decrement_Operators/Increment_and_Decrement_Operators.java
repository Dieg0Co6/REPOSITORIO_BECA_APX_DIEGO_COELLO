package main.java.com.app.Working_with_Unary_Operators.Logical_Complement_and_Negation_Operators;


public class Increment_and_Decrement_Operators {

    public static void main(String[] args) {
        //AQUÍ HAY QUE TENER EN CUENTA QUE LOS OPERADORES UNARIOS TIENEN MAYOR NIVEL DE PRECEDENCIA QUE 
        // LOS OEPRADORES BINARIOS, ES DECIR, SE APLICAN PRIMERO EN UNA EXPRESIÓN.

        // SE TIENE QUE TENER CUIDADO, YA QUE:
        //Si el operador se coloca antes del operando (pre-incremento y operador de pre-decremento)
        // entonces el operador se aplica primero y el valor retornado es el nuevo valor de la expresión.
        // Alternativamente, si el operador se coloca después del operando (post-incremento y post-decremento) 
        // entonces se devuelve el valor original de la expresión, aplicándose el operador después de que se devuelva el valor.

        //EJEMPLO:

        int counter = 0;
        System.out.println(counter);    // AQUÍ EL VALOR ES 0
        System.out.println(++counter);  // AQUÍ EL VALOR ES 1
        System.out.println(counter);    // AQUÍ TAMBIÉN EL VALOR ES 1
        System.out.println(counter--);  // AQUÍ TAMBIÉN EL VALOR ES 1
        System.out.println(counter);    // AQUÍ EL VALOR ES 0

        //El primer operador de pre-incremento actualiza el valor de counter y muestra el nuevo valor de 1.
        //El siguiente operador de post-decremento también actualiza el valor de counter, pero muestra el
        //valor antes de que ocurra el decremento.

        int x = 3;
        int y = ++x * 5 / x-- + --x;    // y = 4 * 5 / 4 + 2 -> y = 7  | x = 2
        System.out.println("x is " + x);    // x= 2
        System.out.println("y is " + y);    // y = 7

        // EXPLICACIÓN: EL VALOR DE X COMIENZA CON 3, LUEGO TIENEN UN PRE INCREMENTO, EL CUAL SU NUEVO VALOR SERÍA 4.
        // LUEGO EN LA MISMA EXPRESIÓN, HAY UN POST DECREMENTO, EL CUAL AÚN SE LE ASIGNA 4 EN LA EXPRESIÓN, PERO AHORA SU VALOR PASA A SER 3
        // Y LUEGO HAY UN PRE DECREMENTO QUE HACE QUE SU NUEVO VALOR SEA 2. LUEGO SE RESUELVE LA EXPRESION ARITMETICA, SIENDO Y = 7
    }
}
