package com.app.day_one.Understanding_the_Java_Class_Structure.Fields_and_Methods;
//De esta manera de declara la clase más simple, palabra public significa que esta clase puede ser
//usada por otras clases.
public class Animals { 
    String name; //Se define una variable llamada name de tipo String

    //Definí métodos getter and setter para el acceso y manipulación de la variable.
    public String getName(){ //Este método retorna un valor String
        return name;
    }

    public void SetName(String newName){ //Este método recibe un parámetro de tipo String que sirve para cambiar el valor de la variable
        name = newName;
    }


    //Ejemplo de otro método:
    //public int numberVisitors(int month) //Este método recibe como parametro una variable de valor entero.
}
