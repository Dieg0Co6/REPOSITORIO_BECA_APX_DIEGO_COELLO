package com.app.day_one.Understanding_Package_Declarations_and_Imports.Redundant_Imports;

import java.lang.System; 
import java.lang.*;     //redundante, hace uso System y con el comodin ya está importando denuevo esa clase
import java.util.*;     //redundante  
import java.util.Random; 

public class ImportExample {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
