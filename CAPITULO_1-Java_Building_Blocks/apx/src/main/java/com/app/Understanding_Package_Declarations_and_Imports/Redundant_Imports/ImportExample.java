package com.app.Understanding_Package_Declarations_and_Imports.Redundant_Imports;

import java.lang.System; //redundate
import java.lang.*;     //redundante
import java.util.*;
import java.util.Random; //redundante  

public class ImportExample {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(10));
    }
}
