package com.app.day_one.Understanding_Package_Declarations_and_Imports.Code_Formatting_on_the_Exam;

import java.util.ArrayList;

public class LineNumbers {

    public void method (ArrayList<String> list){
        if(list.isEmpty()){
            System.out.println("e");
        }else{
            System.out.println("n");
        }
    }


    //HABRÁN PREGUNTAS EN LAS CUALES SE VAN A OMITIR LAS IMPORTACIONES PARA AHORRAR ESPACIO, ES ESCENCIAL TENER EN CUENTA
    //EL NUMERO DE LINEA DE CODIGO, YA QUE SI NO COMIENZA DESDE EL 1 , ENTONCES SE PUEDE INTUIR QUE SE OBVIARON LAS IMPORTACIONES.
    //ejmm:
    /* 6: public void method(ArrayList list) {
    7:  if (list.isEmpty()) { System.out.println("e");
    8:  } else { System.out.println("n");
    9: }  } */

    //SIN EMBARGO, SI COMIENZA DESDE LA LINEA 1 Y EN EL CODIGO, SE NECESITA ALGUNA IMPORTACIÓN, ENTONCES AHÍ DEFRENTE SE MARCA
    //QUE HAY ERROR DE COMPILACIÓN EN TAL LINEA. EJM:
    //AQUÍ PARTE DE LA LINEA 1 PERO SE NECESITA LA IMPORTACIÓN DE SYSTEM, Y ARRAYLIST, ENTONCES, HAY ERROR.
    /* 1: public class LineNumbers {
    2: public void method(ArrayList list) {
    3:  if (list.isEmpty()) { System.out.println("e");
    4:  } else { System.out.println("n");
    5: }  } } */
}
