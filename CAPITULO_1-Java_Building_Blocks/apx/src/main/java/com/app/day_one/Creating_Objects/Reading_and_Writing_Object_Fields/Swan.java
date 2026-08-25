package com.app.day_one.Creating_Objects.Reading_and_Writing_Object_Fields;

public class Swan {
    int numberEggs; //VARIABLE DE INSTANCIA
    public static void main(String[] args) {
        Swan mother = new Swan();
        mother.numberEggs = 1;
        System.out.println(mother.numberEggs);
    }
}
