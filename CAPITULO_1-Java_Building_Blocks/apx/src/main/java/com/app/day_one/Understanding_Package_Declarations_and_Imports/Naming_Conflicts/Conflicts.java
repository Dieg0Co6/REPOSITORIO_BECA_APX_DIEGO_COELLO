package com.app.day_one.Understanding_Package_Declarations_and_Imports.Naming_Conflicts;

import java.util.*;
import java.util.Date; //En esos casos, es mejor especificar e importar el paquete con la clase a la que corresponde
import java.sql.*;  // No compila, dado que la clase se encuentra en diferentes paquetes. Date es ambiguo (está presente en util y sql)

/* import java.util.Date; 
import java.sql.Date; //Otro error, es cuando se importan explicitamente los dos paquetes con la misma clase */

public class Conflicts {
    Date date;
    // más código

    //EN EL CASO DE QUE SE QUIERA USAR EL NOMBRE DE UNA CLASE DE DIFERENTES PAQUETES, ENTONCES UNA SOLUCION ES
    // DECLARAR LA VARIABLE INDICANDO EL PAQUETE Y LA CLASE:
    /* java.util.Date date;
    java.sql.Date sqlDate; */
}
