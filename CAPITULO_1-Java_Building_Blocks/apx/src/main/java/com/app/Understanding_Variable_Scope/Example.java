package com.app.Understanding_Variable_Scope;

public class Example {
    //Las variables locales son las que se encuentran en un método, ya sea que se encuentren dentro del cuerpo del método 
    // o como parametros. EJM:

    public void eat(int piecesOfCheese) {       // En este método hay dos variables locales, una que es bitesOfCheese
        int bitesOfCheese = 1;                  //y la otra es piecesOfCheese que se pasa como parametro, estas variables son
    }                                           // locales porque tampoco se usan fuera del método


    //hungry tiene un alcance de todo el método.
    // bitesOfCheese tiene un alcance más pequeño.
    // Solo está disponible para usarse dentro de la instrucción if porque se declara dentro de ella.
    // Cuando hay un conjunto de llaves ({ }) en el código, significa que se ha entrado en un nuevo bloque de código.
    // Cada bloque de código tiene su propio alcance. Cuando hay múltiples bloques, los emparejas de adentro hacia afuera.
    public void eatIfHungry(boolean hungry) {
        if (hungry) {
            //int bitesOfCheese = 1;
        }  // Aquí termina el alcance de la variable bitesOfCheese
        //System.out.println(bitesOfCheese); // NO COMPILA PORQUE AQUÍ NO SE SABE QUE ES bitesOfCheese.
    }


    //OTRO EJEMPLO:

    public void eatIfHungry2(boolean hungry) {
        if (hungry) {
            int bitesOfCheese = 1;
            { 
            //boolean teenyBit = true; 
            System.out.println(bitesOfCheese); 
            } //SALE DE ALCANCE LA VARIABLE teenyBit
        } //SALE DE ALCANCE LA VARIABLE bitesOfCheese
        //System.out.println(teenyBit);  // NO COMPILA YA QUE NO SABE QUE ES teenyBit
    }

    public void eatMore(boolean hungry, int amountOfFood) {
        int roomInBelly = 5;
        if (hungry) {
            boolean timeToEat = true;
            while (amountOfFood > 0) { 
                int amountEaten = 2;

                roomInBelly = roomInBelly - amountEaten;
                amountOfFood = amountOfFood - amountEaten;
            } //amountEaten TIENE ALCANCE HASTA ACÁ
        } //timeToEat TIENE ALCANCE HASTA ACÁ
        System.out.println(amountOfFood);
    }


}
