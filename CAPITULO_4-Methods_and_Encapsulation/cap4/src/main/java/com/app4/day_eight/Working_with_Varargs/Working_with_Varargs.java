package com.app4.day_eight.Working_with_Varargs;

public class Working_with_Varargs {
    public static void main(String[] args) {
        //Un método puede usar un parámetro vararg (argumento variable) como si fuera un arreglo.
        //Sin embargo, es un poco diferente de un arreglo.
        //Un parámetro vararg debe ser el último elemento en la lista de parámetros de un método.
        //Esto implica que solo se permite tener un parámetro vararg por método y de un solo tipo.

        /* public void walk1(int... nums) { }      //ESTE ESTÁ BIEN
        public void walk2(int start, int... nums) { }       //ESTE ESTÁ BIEN
        public void walk3(int... nums, int start) { } // NO COMPILA porque el varargs debe estar al ultimo
        public void walk4(int... start, int... nums) { } // NO COMPILA porque solo permite colocar un varargs */

        //Al llamar a un método con un parámetro vararg, tienes una opción.
        //Puedes pasar un arreglo, o puedes enumerar los elementos del arreglo y dejar que Java lo cree por ti.
        //Incluso puedes omitir los valores del vararg en la llamada al método y Java creará un arreglo de longitud cero para ti.

        //al llamar a estos metodos me da:

        /* public static void walk(int start, int... nums) {   //se crea el metodo
            System.out.println(nums.length);
        }

        public static void main(String[] args) {
            walk(1);                    // 0    //en esta función, no se está pasando valores al nums, por eso sale 0
            walk(1, 2);  // 1    //acá, solo se está pasando un valor al nums. Se convierte ese valor en un arreglo de longitud 1
            walk(1, 2, 3);   // 2     //acá num empieza desde la primera coma, es decir, tiene 2 elementos.Arreglo de longitud 2
            walk(1, new int[] {4, 5});     // 2     //acá se le pasa un array, el cual es de 2 elementos, por ello, sale 2
        } */

        //Y si pasamos lo siguiente:

        //walk(1, null);     // throws a NullPointerException     //ahí lanza una excepcion, porque no permite que se pase un null
        //aún así, sí compila.


        //Acceder a un parámetro vararg también es igual que acceder a un arreglo. 
        /* public static void run(int... nums) {
            System.out.println(nums[1]);
        }
        public static void main(String[] args) {
            run(11, 22);     // 22      //imprime el segundo elemento
        } */
    }
}
