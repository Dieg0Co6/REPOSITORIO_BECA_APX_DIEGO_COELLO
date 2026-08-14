package main.java.com.app.Working_with_Binary_Arithmetic_Operators.Arithmetic_Operators;

public class Arithmetic_Operators {
    //AQUÍ SE ENCUENTRAN LOS OPERADORES BINARIOS, COMO LA SUMA, RESTA, MULTIPLICACIÓN, DIVISIÓN Y MÓDULO
    // ASÍ TAMBIÉN COMO EL AUMENTO Y DECREMENTO

    //EN ESTE CASO, SE DEBE TENER EN CUENTA MUCHO EL ORDEN DE PRECEDENCIA. EJM:
    public static void main(String[] args) {
        int x = 2 * 5 + 3 * 4 - 8;  //EN ESTE CASO, LA MULTIPLICACIÓN TIENE MAYOR NIVEL QUE EL NIVEL ADITIVO (+/-)
                                    // ENTONCES PRIMERO SE MULTIPLICA Y LUEGO SE SUMA, PRIMERO SE EVALUA 2 * 5  Y 3 * 4
        // x = 10 + 12 - 8          // LUEGO SE SUMA
        // x = 14

        // A MENOS QUE SE UTILICEN PARENTESIS, AHÍ SÍ SE ANULA EL NIVEL DE PRECEDENCIA Y SE RESUELVE DE ACUERDO A LOS PARENTESIS.
        int y = 2 * ((5 + 3) * 4 - 8); //PRIMERO SE RESUELVE EL PARENTESIS QUE SE ENCUENTRA MÁS INTERNO. (5 + 3)
        // y = 2 * (8 * 4 - 8);         // EN ESTE CASO PRIMERO SE RESUELVE EL PARENTESIS Y DENTRO DEL PARENTESIS SE RESUELVE PRIMERO LA MULTIPLICACION
        // y = 2 * (32 - 8)             // LUEGO SE PROCEDE CON LA RESTA DEL PARÉNTESIS
        // y = 2 * 24                   // YA SIN PARENTESIS SE PROCEDE CON LA MULTIPLICACION
        // y = 48

        // TENER EN CUENTA QUE TODO OPERADOR ARITMETICO SE PUEDE APLICAR A CUALQUIER TIPO PRIMITIVO DE JAVA, EXCEPTO EL B0OLEAN Y EL STRING.
        // SOLO LOS OPERADORES DE SUMA + y += SE PUEDEN APLICAR A VALORES STRING, LO QUE RESULTA EN LA CONCATENACIÓN DE STRINGS.

        //EL MODULO ES EL RESIDUO, POR EJM: 9 % 3 -> el resultado es 0, ya que son divisibles y no tiene residuo
        // Y 8 % 3 -> el resultado sería 2, porque al dividir, da un residuo de 2


        //AL DIVIDIR , DA COMO RESULTADO EL VALOR ENTERO MÁS CERCANO, Y EL MODULO DEVUELVE EL RESTO DE LA DIVISION.
        // EL MODULO SIEMPRE VA TENER QUE DAR COMO RESULTADO UN VALOR ENTRE 0 Y (DIVISOR - 1)
        // SALVO QUE EL DIVIDENDO SEA NEGATIVO Y AHÍ EL MODULO PODRÍA SER UN NEGATIVO O DECIMAL
        System.out.println(9 / 3);  // Resultado 3
        System.out.print(9 % 3);  // Resultado 0
        System.out.print(10 / 3);  // Resultado 3
        System.out.print(10 % 3);  // Resultado 1
        System.out.print(11 / 3);  // Resultado 3
        System.out.print(11 % 3);  // Resultado 2
        System.out.print(12 / 3);  // Resultado 4
        System.out.print(12 % 3);  // Resultado 0


    }
}
