package main.java.com.app.day_six.Working_with_Dates_and_Times;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;

public class Working_with_Dates_and_Times {
    public static void main(String[] args) {
        
        //Al igual que con un ArrayList, necesitas una sentencia de importación para trabajar con las clases de fecha y hora.
        //La mayoría de ellas están en el paquete java.time.
        //PARA IMPORTAR UTILIZAMOS LO SIGUIENTE:

        //import java.time.*;          // import time classes

        Working_with_Dates_and_Times working_with_Dates_and_Times = new Working_with_Dates_and_Times();
        working_with_Dates_and_Times.Creating_Dates_and_Times();
        working_with_Dates_and_Times.Manipulating_Dates_and_Times();
        working_with_Dates_and_Times.Formatting_Dates_and_Times();
        working_with_Dates_and_Times.Parsing_Dates_and_Times();
    }

    public void Creating_Dates_and_Times(){
        //Cuando se trabaje con fechas y horas, lo primero que se debe hacer es decidir cuánta información necesitas.
        // El examen da tres opciones:
        LocalDate();
        LocalTime();
        LocalDateTime();

        //Oracle recomienda evitar las zonas horarias a menos que realmente las necesites.
        //Se debe intentar actuar como si todos estuvieran en la misma zona horaria cuando puedas.
        //Si se necesita comunicarse entre zonas horarias, ZonedDateTime se encarga de ellas.

        //Así tenemos los siguientes ejemplos:
        System.out.println(LocalDate.now());    //imprime la fecha actual
        System.out.println(LocalTime.now());    //imprime la hora actual
        System.out.println(LocalDateTime.now()); //imprime la fecha y hora actual  //2015-01-20T12:45:18.401

        //Java usa la T para separar la fecha y la hora al convertir LocalDateTime a una cadena.

        //TENER EN CUENTA QUE:
        //En el examen se van a considerar los formatos de fecha y hora de Estados Unidos
        //Donde el mes va antes del día: mm/dd/aaaa
        //Además, Java tiende a usar un reloj de 24 horas aunque en Estados Unidos se use un reloj de 12 horas con a.m./p.m.

        //Ambos ejemplos crean la misma fecha:
        LocalDate date1 = LocalDate.of(2015, Month.JANUARY, 20);//Aquí usamos la constante del mes de la clase Month
        LocalDate date2 = LocalDate.of(2015, 1, 20);    //Aquí asignamos el mes con el numero
        
        //La firma de los metodoso son las siguientes:
        /* public static LocalDate of(int year, int month, int dayOfMonth)
        public static LocalDate of(int year, Month month, int dayOfMonth) */

        //Month es un tipo especial de clase llamado enum.
        //Java comienza contando los meses desde el 1, como lo hacemos todos, es decir, comienza con Enero (January) siendo el 1.

        //Al crear una hora, se puede elegir cuán detallado se quiere ser.
        //Se puede especificar solo la hora y los minutos, o se puede agregar el número de segundos.
        //Incluso se puede añadir nanosegundos si se quiere ser muy preciso.

        LocalTime time1 =  LocalTime.of(6, 15);               // hora y minuto
        LocalTime time2 =  LocalTime.of(6, 15, 30);          // hora, minuto y segundos
        LocalTime time3 =  LocalTime.of(6, 15, 30, 200);  // hora, minuto, segundo y nanosegundos

        //Estos tres horarios son todos diferentes pero están dentro de un minuto entre sí.
        //Las firmas de los métodos son las siguientes:

        /* public static LocalTime of(int hour, int minute)
        public static LocalTime of(int hour, int minute, int second)
        public static LocalTime of(int hour, int minute, int second, int nanos) */

        //Finalmente, podemos combinar fechas y horas:

        //LocalDateTime dateTime1 = LocalDateTime.of(2015, Month.JANUARY, 20, 6, 15, 30);
        //LocalDateTime dateTime2 = LocalDateTime.of(date1, time1); //Se puede combinar pasando LocalDate y LocalTime

        /* public static LocalDateTime of(int year, int month, 
        int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, int month, 
        int dayOfMonth, int hour, int minute, int second)
        public static LocalDateTime of(int year, int month, 
        int dayOfMonth, int hour, int minute, int second, int nanos)
        public static LocalDateTime of(int year, Month month, 
        int dayOfMonth, int hour, int minute)
        public static LocalDateTime of(int year, Month month, 
        int dayOfMonth, int hour, int minute, int second)
        public static LocalDateTime of(int year, Month month, 
        int dayOfMonth, int hour, int minute, int second, int nanos)
        public static LocalDateTime of(LocalDate date, LocalTime) */


        //NO SE USAN CONTRUCTORES
        //Las clases de fecha y hora tienen constructores privados para obligarte a usar los métodos estáticos.

        LocalDate d = new LocalDate(); // ESTO NO COMPILA. NO SE PUEDE ASIGNAR EL NEW. SINO DEFRENTE LocalDate.

        //No se permite crear un objeto de fecha u hora directamente.

        //Y SI SER PASA NUMEROS INVALIDOS SE LANZA UNA EXCEPTION:
        LocalDate.of(2015, Month.JANUARY, 32);    // throws DateTimeException

        //EN LA FORMA ANTIGUA, TENIAMOS :
        //La clase Date representaba tanto la fecha como la hora, quisieras o no
        //Intentar crear una fecha específica requería más código del que debería.
        //Los índices de los meses empezaban en 0 en lugar de 1, lo cual era confuso.


        //FORMA VIEJA:
        //import java.util.*;
        //Date d = new Date();
        //Date d = new Date();
        //Calendar c = Calendar.getInstance(); c.set(2015, Calendar. JANUARY, 1); Date jan = c.getTime(); O
        //Calendar c = new GregorianCalendar(2015, Calendar. JANUARY, 1); Date jan = c.getTime();
        //Calendar c = Calendar.getInstance(); c.set(2015, 0, 1); Date jan = c.getTime();


        //FORMA NUEVA:
        //import java .time.*;
        //LocalDate d = LocalDate.now();
        //LocalDateTime dt = LocalDateTime. now();
        //LocalDate jan = LocalDate.of(2015, Month.JANUARY, 1);
        //LocalDate jan = LocalDate.of(2015, 1, 1)

    }

    private void LocalDate(){
        //LocalDate contiene solo una fecha, sin hora ni zona horaria.
        //Un buen ejemplo de LocalDate es la fecha de cumpleaños este año.
        //Es tu cumpleaños durante todo el día sin importar la hora que sea.
    }
    private  void LocalTime(){
        //Contiene solo una hora — no una fecha ni una zona horaria.
        //Un buen ejemplo de LocalTime es la medianoche.
        //Es medianoche a la misma hora todos los días.
    }
    private void LocalDateTime(){
        //Contiene tanto una fecha como una hora, pero sin zona horaria.
        //Un buen ejemplo de LocalDateTime es “la medianoche de Año Nuevo.”
    }

    public void Manipulating_Dates_and_Times(){
        //Las clases de fecha y hora son inmutables, igual que lo era String.
        //Esto significa que necesitamos recordar asignar los resultados de estos métodos a una variable
        //de referencia para que no se pierdan.

        LocalDate date = LocalDate.of(2014, Month.JANUARY, 20); //Se le asingna la fecha exacta (01/20/2014)
        System.out.println(date);          // 2014-01-20
        date = date.plusDays(2);    //sumarle dos días
        System.out.println(date);          // 2014-01-22
        date = date.plusWeeks(1);   //Sumarle una semana
        System.out.println(date);          // 2014-01-29
        date = date.plusMonths(1);  //Sumarle un mes
        System.out.println(date);          // 2014-02-28
        date = date.plusYears(5);   //Sumarle 5 años
        System.out.println(date);          // 2019-02-28

        //SE HAN CREADO VARIOS OBJETOS DE TIPO LOCALDATE, EL CUAL LO UNICO QUE SE HA CAMBIADO ES LA ASIGNACIÓN A LA VARIBLE DE REFERENCIA
        //ES DECIR date AHORA APUNTA AL ULTIMO OBJETO QUE ES EL QUE TIENE EL VALOR 2019-02-28

        //También hay métodos fáciles y agradables para retroceder en el tiempo.

        LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(5, 15);
        LocalDateTime dateTime = LocalDateTime.of(date1, time);
        System.out.println(dateTime);          // 2020-01-20T05:15
        dateTime = dateTime.minusDays(1);   //Se le retrocede un día
        System.out.println(dateTime);          // 2020-01-19T05:15
        dateTime = dateTime.minusHours(10); //Se le retrocede 10 horas
        System.out.println(dateTime);          // 2020-01-18T19:15
        dateTime = dateTime.minusSeconds(30);   //se le retrocede 20 segundos
        System.out.println(dateTime);          // 2020-01-18T19:14:30


        //otro ejmplo:
        LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time2 = LocalTime.of(5, 15);
        LocalDateTime dateTime2 = LocalDateTime.of(date2, time2)
        .minusDays(1).minusHours(10).minusSeconds(30);

        //por más que se añadan metodos en una sola linea, igual se están creando varios objetos por cada metodo

        //TENER CUIDADO PORQUE VAN A TRATAR DE ENGAÑAR EN EL EXAMEN:

        LocalDate date3 = LocalDate.of(2020, Month.JANUARY, 20);
        date3.plusDays(10);
        System.out.println(date3); //ESTO IMPRIME 20 DE ENERO DEL 2020. Porque no se le asignó la variable de referencia al nuevo objeto
    
        //o también en estos casos:
        LocalDate date4 = LocalDate.of(2020, Month.JANUARY, 20);
        date4 = date4.plusMinutes(1);     // NO COMPILA PORQUE ESTAMOS TRABAJANDO SOLO CON FECHA, NO CON HORAS, NI MINUTOS NI SEGUNDOS.

        //LocalDate no contiene tiempo.

        //DE LA FORMA ANTIGUA ERA TEDIOSO:
        //Agregar un día 
        // public Date agregarDia(Date date) { 
        // Calendar cal = Calendar.getInstance();
        // cal.setTime(date); 
        // cal.add(Calendar.DATE, 1); 
        // return cal.getTime(); 
        // } 
        
        //Restar un día
        //public Date restarDia(Date date) { 
        // Calendar cal = Calendar.getInstance(); 
        // cal.setTime(date); 
        // cal.add(Calendar.DATE, -1); 
        // return cal.getTime(); 
        //}

        //Y AHORA SE HACE ASÍ:

        //AGREGAR UN DÍA:
        //public LocalDate addDay(LocalDate date) { return date. plusDays(1); }

        //Restar un día
        //public LocalDate subtractDay(LocalDate date) { return date. minusDays(1); }
    }

    public void Working_with_Periods(){
        //

        /* public static void main(String[] args) {
            LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
            LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
            performAnimalEnrichment(start, end);
        }
        private static void performAnimalEnrichment(LocalDate start, LocalDate end) {
            LocalDate upTo = start;
            while (upTo.isBefore(end)) {          // revisa si upTo todavía no pasa la fecha end
            System.out.println("give new toy: " + upTo);
            upTo  = upTo.plusMonths(1);                    // se suma un mes
            }
        } */

        //LocalDate y LocalDateTime tienen un método para convertirlos en equivalentes en long en relación con 1970.

        /*
        * LocalDate tiene toEpochDay(), que es el número de días desde el 1 de enero de 1970.
        * LocalDateTime tiene toEpochTime(), que es el número de segundos desde el 1 de enero de 1970.
         */

        //ESOS DOS METODOS, DEVUELVE UN NUMERO EN TIPO DE DATO LONG.
        //LocalTime no tiene un método epoch.

        //Java tiene una clase Period que podemos usar. Este ejemplo hace lo mismo que el ejemplo de los Animales del Zoo:

        /* public static void main(String[] args) {
            LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
            LocalDate end = LocalDate.of(2015, Month.MARCH, 30);
            Period period = Period.ofMonths(1);               // crea un periodo (1 mes)
            performAnimalEnrichment(start, end, period);
        }

        private static void performAnimalEnrichment(LocalDate start, LocalDate end, Period period) { // usa el periodo genérico
            LocalDate upTo = start;
            while (upTo.isBefore(end)) {
                System.out.println("give new toy: " + upTo);
                upTo = upTo.plus(period);     // adds the period
            }
        } */

        //El método puede agregar un período de tiempo arbitrario que se pase como parámetro.
        //Esto nos permite reutilizar el mismo método para diferentes períodos de tiempo

        Period annually = Period.ofYears(1);               //cada 1 año
        Period quarterly = Period.ofMonths(3);               // cada 3 meses
        Period everyThreeWeeks = Period.ofWeeks(3);          // cada 3 semanas
        Period everyOtherDay = Period.ofDays(2);          // cada 2 días
        Period everyYearAndAWeek = Period.of(1, 0, 7);          // cada 1 año con 7 días

        //PERO TIENEN UN PROBLEMA, NO SE PUEDE ENCADENAR MÉTODOS AL CREAR UN PERIOD
        //SOLO SE UTILIZA EL ULTIMO METODO PORQUE LOS PERIOD.OFXXX SON MÉTODOS ESTÁTICOS
        Period wrong = Period.ofYears(1).ofWeeks(1);          //Es cada semana (NO ES CADA AÑO CON UNA SEMANA)

        //RECUERDA QUE LOS PERIODOS CONTIENEN MÉTODOS ESTÁTICOS

        //Este código complicado es realmente como escribir lo siguiente:
        Period wrong1 = Period.ofYears(1);
        wrong1 = Period.ofWeeks(7);

        //TENER EN CUENTA CON QUE OBJETOS SE PUEDE USAR EL PERIODO. EJM:

        LocalDate date = LocalDate.of(2015, 1, 20); //2015-01-20
        LocalTime time = LocalTime.of(6, 15);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Period period = Period.ofMonths(1); //CADA 1 MES
        System.out.println(date.plus(period));          // 2015-02-20
        System.out.println(dateTime.plus(period));          // 2015-02-20T06:15
        System.out.println(time.plus(period)); //UnsupportedTemporalTypeException. 
                                                // Lanza exception porque no se puede usar el periodo el tiempo

        //PERIODOS NO VAN CON TIEMPO (LOCALTIME), PERIODOS VAN CON FECHAS Y FECHAS-TIEMPO (LOCALDATE Y LOCALDATETIME)
    }

    public void Formatting_Dates_and_Times(){
        //Las clases de fecha y hora admiten muchos métodos para obtener datos de ellas.

        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        System.out.println(date.getDayOfWeek());     // MONDAY
        System.out.println(date.getMonth());          // JANUARY
        System.out.println(date.getYear());          // 2020
        System.out.println(date.getDayOfYear());    //20            //el numero de días que van en el año

        //Java nos ofrece una clase llamada DateTimeFormatter.
        //A diferencia de la clase LocalDateTime, DateTimeFormatter se puede usar para formatear cualquier tipo de objeto de fecha y/o hora.
        //Lo que cambia es el formato. DateTimeFormatter está en el paquete java.time.format.

        LocalDate date1 = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dateTime = LocalDateTime.of(date1, time);
        System.out.println(date1.format(DateTimeFormatter.ISO_LOCAL_DATE)); //2020-01-20  
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));  //11:12:34
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));  //2020-01-20T11:12:34

        //ISO es un estándar para fechas. 
        
        //HAY OTROS FORMATOS PARA LAS FECHAS :

        DateTimeFormatter shortDateTime = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT); //Aquí decimos que queremos un formateador localizado en el formato corto predefinido.
        System.out.println(shortDateTime.format(dateTime));     // 1/20/20
        System.out.println(shortDateTime.format(date));      // 1/20/20
        System.out.println(shortDateTime.format(time)); // UnsupportedTemporalTypeException     //no puede formatear tiempo, solo fechas o fecha/hora
    
        //El siguiente código imprime lo mismo que lo anterior:
        DateTimeFormatter shortDateTime1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        System.out.println(dateTime.format(shortDateTime1));    // 1/20/20
        System.out.println(date.format(shortDateTime1));    // 1/20/20
        System.out.println(time.format(shortDateTime1));    // UnsupportedTemporalTypeException     //no puede formatear tiempo, solo fechas o fecha/hora

        //el método ofLocalizedDate() es exclusivamente para fechas(LocalDate) u fechas/hora(LocalDateTime)
        //el metodo ofLocalizeTime() es exclusivamente para horas (LocalTime) u fechas/horas (LocalDateTime)
        //el método ofLocalizeDateTime() es exclusivamente para fecha/horas (LocalDateTime)

        //Hay dos formatos predefinidos que pueden aparecer en el examen: CORTO y MEDIO.Los otros formatos predefinidos implican zonas horarias.

        //Otro ejemplo:
        LocalDate date2 = LocalDate.of(2020, Month.JANUARY, 20);    //declaramos una fecha
        LocalTime time1 = LocalTime.of(11, 12, 34);         //declaramos una hora
        LocalDateTime dateTime1 = LocalDateTime.of(date2, time1);       //Declaramos una fecha y hora
         DateTimeFormatter shortF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);        //formato corto
        DateTimeFormatter mediumF = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);      //formato mediano
        System.out.println(shortF.format(dateTime1));     // 1/20/20 11:12 AM
        System.out.println(mediumF.format(dateTime1));    // Jan 20, 2020 11:12:34 AM

        //OTRA FORMA
        System.out.println(dateTime1.format(shortF));
        System.out.println(dateTime1.format(mediumF));

        //Si no quieres usar uno de los formatos predefinidos, puedes crear el tuyo propio.
        //Por ejemplo, este código escribe el mes con letras:

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM dd, yyyy, hh:mm");  //Se puede personalizar el formato de la fecha y hora
        DateTimeFormatter otherFormat = DateTimeFormatter.ofPattern("dd - MM - yyyy");  
        System.out.println(dateTime1.format(f));     // January 20, 2020, 11:12
        System.out.println(otherFormat.format(dateTime1));  //20 - 01 - 2020

        //TENER EN CUENTA QUE EL MES (EN NOMBRE O NUMERO) ES SIEMPRE CON MINUSCULAS, PORQUE SI SE COLOCA EL MINUSCULAS, LO TOMA COMO MINUTOS

        /*
            * MMMM  ->  M representa el mes. Cuantas más Ms tengas, más detallada será la salida de Java.
            *           Por ejemplo, M muestra 1, MM muestra 01, MMM muestra Ene y MMMM muestra Enero.
            
            * dd    ->  d representa el día del mes. Como con el mes, cuantos más ds tengas, más detallada será la salida de Java.
            *           dd significa incluir el cero inicial para un día de un solo dígito.
            
            * ,     ->  Usa , si quieres mostrar una coma (esto también aparece después del año).

            * yyyy  ->  y representa el año. yy muestra un año de dos dígitos y yyyy muestra un año de cuatro dígitos.
        
            * hh    ->  h representa la hora. Usa hh para incluir el cero inicial si estás mostrando una hora de un solo dígito.
            
            * :     ->  Usa : si quieres mostrar dos puntos.
        
            * mm    ->  m representa el minuto.
        */

        //DE ESTAS LINEAS CUAL LANZARÁ UNA EXCEPTION?
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("hh:mm");
        f1.format(dateTime);    //ESTE SI DEVUELVE LA HORA EN EL FORMATO ESTABLECIDO
        f1.format(date);        //ESTE LANZA EXCEPTION
        f1.format(time);        //ESTE SI DEVUELVE LA HORA EN EL FORMATO ESTABLECIDO
    }

    public void Parsing_Dates_and_Times(){
        //Así como una fecha se pasa a un formato String.
        //El String también se puede pasar a una fecha u hora
        //Al igual que el método format(), el método parse() también utiliza un formateador.
        //Si no se especifica uno, usa el predeterminado para ese tipo.

        DateTimeFormatter f = DateTimeFormatter.ofPattern("MM dd yyyy");    //formato de fecha
        LocalDate date = LocalDate.parse("01 02 2015", f);  //Se le asigna una fecha del String 01 02 2015, adoptando el formato f
        LocalTime time = LocalTime.parse("11:22");          //Se le pasa una hora en String, lo parsea y lo asigna a time
        System.out.println(date);          // 2015-01-02
        System.out.println(time);          // 11:22

        // El análisis es consistente en que si algo sale mal, Java lanza una excepción en tiempo de ejecución.
        // Eso podría ser un formato que no coincide con el String que se va a analizar o una fecha inválida.
    
    }

}
