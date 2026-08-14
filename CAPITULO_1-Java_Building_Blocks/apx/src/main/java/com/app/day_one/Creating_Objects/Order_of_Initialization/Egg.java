package com.app.day_one.Creating_Objects.Order_of_Initialization;

public class Egg {
    public Egg() {
        number = 5;
    }

    public static void main(String[] args) {
        Egg egg = new Egg();
        System.out.println(egg.number);
    }
    private int number = 3;
    { number = 4; }

    //DE IGUAL MANERA AL MOMENTO DE EJECUTAR EL METODO MAIN, PRIMERO SE EJECUTA LAS VARAIABLES Y BLOQUES DE INICIALIZACIÓN
    // NUMBER SE LE ASIGNA 3 Y LUEGO NUMBER CAMBIA SU VALOR A 4, LUEGO SE EJECUTA EL CONSTRUCTOR, DONDE CAMBIA SU VALOR A 5
    //LUEGO SE IMPRIME EL EGG.NUMBER, ENTONCES SE VA IMPRIMIR EL VALOR DE 5
}
