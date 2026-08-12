package com.app.Understanding_Package_Declarations_and_Imports.Wildcards;

import java.util.*;     //Importa java.util.Random y entre otras cosas. Se les llama comodines

public class ImportExample {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
