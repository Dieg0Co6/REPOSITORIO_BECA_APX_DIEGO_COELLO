public class Numeric_Promotion {

    //REGLAS DE PROMOCIÓN NUMERICA:

    // 1.Si dos valores tienen diferentes tipos de datos, Java automáticamente promoverá uno de los 
    // valores al tipo de dato más grande de los dos.

    // 2. Si uno de los valores es integral y el otro es de punto flotante, Java automáticamente promoverá 
    // el valor integral al tipo de dato del valor de punto flotante. 


    // 3. Los tipos de datos más pequeños, es decir, byte, short y char, se promueven primero a int cada vez que se 
    // usan con un operador aritmético binario de Java, incluso si ninguno de los operandos es int.
    //LOS OEPRADORES UNARIOS ESTÁN EXCLUIDOS DE ESTA REGLA, POR EJEMPLO, APLICAR ++ A UN VALOR DE TIPO SHORT, 
    // TERMINARÁ DANDO UN VALOR DE TIPO SHORT 

    // 4. Después de que se haya realizado toda la promoción y los operandos tengan el mismo tipo de dato, el valor 
    // resultante tendrá el mismo tipo de dato que sus operandos promovidos.


    // EJMPLOS:
    public static void main(String[] args) {
            int x = 1;
            long y = 33;
            System.out.println(x * y); //AL SEGUIR LA PRIMERA REGLA, ESTO DARÁ COMO RESULTADO UN VALOR DE TIPO DE DADO LONG

            double x1 = 39.21;
            float y1 = 2.1;
            System.out.println(x1 + y1); //AQUÍ ES ENGAÑOSO, YA QUE NO SE COMPILARÁ, ASÍ ESTE DECLARADO COMO FLOAT, Y1 ESTÁ CONSIDERANDO UN VALOR
                                        //DOUBLE POR DEFECTO, YA QUE NO TIENE EL SUFIJO (2.1f), Y SI TUVIERA 2.1f entonces AHÍ SÍ SE APLICARÍA LA REGLA 1
                                        // Y DARÍA UN RESULTADO DE TIPO DOUBLE.

            short x2 = 10;
            short y2 = 3; 
            System.out.println(x2 / y2);    //AQUÍ EL RESULTADO SERÍA 3 Y SE APLICA LA TERCERA REGLA, EL CUAL INDICA QUE LOS TIPOS DE DATOS
                                            // PEQUEÑOS SE PASAN A TIPO DE DATO INT, LO QUE DA COMO RESULTADO EN UN TIPO DE DATO INT.

            short x3 = 14;         
            float y3 = 13;
            double z3 = 30;
            System.out.println(x3 * y3 / z3); //AQUÍ PRIMERO EL X3 SE PASARÍA A SER UN INT POR SER UN SHORT Y SE ESTÁ USANDO EN UNA OPERACION
                                              //ARITMETICA BINARIA, LUEGO SE CONVERTIRÁ A FLOAT PARA PODER MULTIPLICARSE CON Y3.
                                              //COMO Y3 ES UN VALOR DE TIPO FLOAT PERO SE LE ASIGNA UN VALOR DE TIPO INT, ENTONCES, NO SURGE
                                              //INCONVENIENTES PORQUE EL INT ES UN VALOR MENOR JERARQUÍA (byte → short → int → long → float → double)
                                              //ENTONCES EL RESULTADO DE X3 * Y3 LUEGO SE PASARÁ AUTOMATICAMENTE AL TIPO DOUBLE Y AL HACER LA DIVISIÓN
                                              // DA COMO RESULTADO DOUBLE. 

    }
}
