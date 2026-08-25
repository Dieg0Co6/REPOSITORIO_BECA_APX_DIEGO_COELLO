package com.app.day_one.Understanding_the_Java_Class_Structure.ClassesVsFields;

//Se pueden crear varias clases en un solo archivo, en las cuales, como máximo solo una debe ser pública.
//Si la clase es pública, debe coincidir con el nombre del archivo, sino saldrá un error de compilación.
//Ejm: Animal2 no se compilaría si fuese una clase pública porque el archivo se llama Animal.java
public class Animal{
    String name;

    public String getName(){
        return name;
    }    

    public void setName(String newName){
        this.name = newName;
    }
}

class Animal2 {

}
