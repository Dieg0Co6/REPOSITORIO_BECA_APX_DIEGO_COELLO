package main.java.com.app.Understanding_Java_Operators;

public class Understanding_Java_Operators {

    //A MENOS QUE SE ESPECIFIQUE CON PARENTESIS, LOS OPERADORES EN JAVA SIGUEN UN ORDEN. Y SI DOS OPERADORES TIENE EL MISMO NIVEL, ENTONCES
    //JAVA GARANTIZA LA EVALUACIÓN DE IZQUIERDA A DERECHA
    public static void main(String[] args) {
        int y = 4;
        double x = 3 + 2 * --y; //En este caso comienza de derecha a izquierda, donde y adopta el valor de 3, luego se multiplica
                                //por dos y se le suma 3, siendo x igual a 9.0 porque es un double
        System.out.println(x);
        System.out.println(y);
    }

    //EN EL NIVEL DE OPERADORES TENEMOS (DE FORMA DECRECIENTE):
    // * OPERADORES POST-UNARIOS                    expresion++ expresion--
    // * OPERADORES PRE-UNARIOS                     ++expresion --expresion
    // * OTROS OPERADORES UNARIOS                   +, - !
    // * MULTIPLICACION/DIVISION/MÓDULO             *, /, %
    // * ADICIÓN, SUSTRACCIÓN                       +, -
    // * OPERADORES DE DESPLAZAMIENTO               <<, >>, >>>
    // * OPERADORES RELACIONALES                    <, >, >=, <=, instanceof
    // * IGUAL A / NO IGUAL A                       ==, !=
    // * OPERADORES LÓGICOS                         &, ^, |
    // * OPERADORES LÓGICOS DE CORTOCIRCUITO        &&, ||
    // * OPERADORES TERNARIOS                       boolean expresion ? expresion1 : expresion2
    // * OPERADORES DE ASIGNACIÓN                   =, +=, -=, *=, /=, %=, &=, ^=, !=, <<=, >>=, >>>=

    
}
