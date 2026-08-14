package com.app.day_one.Understanding_Package_Declarations_and_Imports.Redundant_Imports;


//Para resolver el problema de las importaciones hay dos soluciones, la más corta es como que ambos tienen el mismo paquete
//se puede importar usando un comodin, es decir, import java.nio.file.*, y de esa manera se importan las dos clases.
//La otra forma es importando exactamente lo que necesitan, Files y Paths, uno por uno.

//Importaciones que no funcionan:

//import java.nio.*; //No funciona porque el comodin solo funciona con clases, no con paquetes
//import java.nio.*.*; //No funciona, porque solamente se tiene un comodin y solamente se debe usar al final.
//import java.nio.files.Paths.*; //No se importan metodos, solo se importan clases.

import java.nio.file.Files;
import java.nio.file.Paths;

public class InputImports {

    public void read(Files files) {
        Paths.get("name");
    }
}
