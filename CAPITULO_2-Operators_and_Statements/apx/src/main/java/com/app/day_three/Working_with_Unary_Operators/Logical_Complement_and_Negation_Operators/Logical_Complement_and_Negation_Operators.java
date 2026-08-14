package main.java.com.app.Working_with_Unary_Operators.Logical_Complement_and_Negation_Operators;

public class Logical_Complement_and_Negation_Operators {



    public static void main(String[] args) {

            //Aquí tenemos el operador lógico y de negación: !
            //EL CUAL INVIERTE UN OPERADOR BOOLEANDO, SI ES VERDADERO LO VUELVE FALSO
            //Y SI ES FALSO, LO CONVIERTE EN VERDADERO. EJMPLO:

            boolean x = false;
            System.out.println(x);  // falso
            x = !x;
            System.out.println(x);  // verdadero

            //También está el operador -, el cual cambia la expresión a negativo. Ejm:
            double x1 = 1.21;       //numero positivo
            System.out.println(x1);  // 1.21
            x1 = -x1;                //se cambió a negativo
            System.out.println(x);  // -1.21
            x1 = -x1;
            System.out.println(x1);  // 1.21

            // NO SE PUEDE ASIGNAR UN OPERADOR LÓGICO COMO ! A UNA EXPRESION NUMERICA, NI TAMPOCO ASIGNAR UN OPERADOR DE NEGACIÓN COMO -
            // A UNA EXPRESIÓN BOOLEANA.

            /* int x2 = !5;  // NO COMPILA
            boolean y2 = -true;  // NO COMPILA
            boolean z2 = !0;  // NO COMPILA */



    }

}
