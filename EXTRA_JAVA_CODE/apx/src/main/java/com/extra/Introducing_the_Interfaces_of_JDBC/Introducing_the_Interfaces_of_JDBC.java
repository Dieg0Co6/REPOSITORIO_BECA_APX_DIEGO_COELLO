package com.extra.Introducing_the_Interfaces_of_JDBC;

import java.sql.*;
import java.util.*;

public class Introducing_the_Interfaces_of_JDBC {

    public static void main(String[] args) throws SQLException {
        Introducing_the_Interfaces_of_JDBC notas = new Introducing_the_Interfaces_of_JDBC();

        notas.lasCincoInterfacesClave();
        System.out.println("====================");
        notas.formatoDeLaURL();
        System.out.println("====================");
        // Los siguientes métodos requieren una conexión real a una BD,
        // así que se muestran comentados como referencia de código,
        // no se ejecutan de verdad en esta demo.
        notas.obtenerConexion();
        System.out.println("====================");
        notas.porQuePreparedStatementEsMejor();
        System.out.println("====================");
        notas.sqlInjectionYBobbyTables();
        System.out.println("====================");
        notas.obtenerUnPreparedStatement();
        System.out.println("====================");
        notas.executeUpdateModificarDatos();
        System.out.println("====================");
        notas.executeQueryLeerDatos();
        System.out.println("====================");
        notas.executeMetodoGenerico();
        System.out.println("====================");
        notas.usarElMetodoCorrecto();
        System.out.println("====================");
        notas.tablasDeReferenciaPreparedStatement();
        System.out.println("====================");
        notas.trabajarConParametrosBindVariables();
        System.out.println("====================");
        notas.erroresComunesConBindVariables();
        System.out.println("====================");
        notas.tablaDeMetodosSetXxx();
        System.out.println("====================");
        notas.actualizarMultiplesRegistros();
        System.out.println("====================");
        notas.batchingStatements();
        System.out.println("====================");
        notas.leerDatosDeUnResultSet();
        System.out.println("====================");
        notas.cursorDelResultSet();
        System.out.println("====================");
        notas.leerUnaSolaFila();
        System.out.println("====================");
        notas.erroresComunesConResultSet();
        System.out.println("====================");
        notas.tablaDeMetodosGetXxx();
        System.out.println("====================");
        notas.getObjectGenerico();
    }


    // ================================================================
    // LAS 5 INTERFACES CLAVE DE JDBC
    // ================================================================
    // Para el examen necesitas conocer estas 5 interfaces. TODAS son
    // interfaces del JDK (paquete java.sql), y quien las IMPLEMENTA
    // de verdad es el DRIVER de cada base de datos (un JAR distinto
    // por cada vendor: PostgreSQL, MySQL, HyperSQL, etc).
    //
    // TÚ, EN TU CÓDIGO, solo usas las INTERFACES, nunca las clases
    // concretas del driver directamente (ni siquiera las conoces).
    //
    //   Driver           -> Establece una conexión a la base de datos
    //   Connection       -> Envía comandos a la base de datos
    //   PreparedStatement-> Ejecuta una consulta SQL
    //   CallableStatement-> Ejecuta comandos almacenados en la BD (stored procedures)
    //   ResultSet        -> Lee los resultados de una consulta
    //
    // Cada driver JAR tiene sus propias clases que implementan estas
    // interfaces (ej: FooDriver, FooConnection, FooPreparedStatement,
    // FooCallableStatement, FooResultSet, si el driver se llamara "Foo").
    // Nunca necesitas saber el nombre de esas clases concretas, el
    // patrón factory se encarga de dártelas ya listas.
    //
    // DATO IMPORTANTE: casi todas las clases de JDBC están en el
    // paquete java.sql (no lo confundas con las clases de streams
    // que vimos antes en java.util.stream).
    public void lasCincoInterfacesClave() {
        System.out.println("Driver, Connection, PreparedStatement, CallableStatement, ResultSet");
        System.out.println("Todas viven en el paquete java.sql");
    }


    // ================================================================
    // FORMATO DE LA URL DE JDBC
    // ================================================================
    // Para conectarte a una base de datos necesitas su URL. A
    // diferencia de las URLs web normales, las URLs de JDBC tienen
    // 3 partes, siempre separadas por DOS PUNTOS (:)
    //
    //   jdbc : subprotocolo : subname
    //
    //   1. PROTOCOLO   -> siempre es la palabra "jdbc" (fija, no cambia)
    //   2. SUBPROTOCOLO-> el nombre del producto/vendor de la BD
    //                     (hsqldb, mysql, postgresql, oracle, etc)
    //   3. SUBNAME     -> detalles específicos de conexión: puede
    //                     incluir host, puerto, y nombre de la BD.
    //                     El formato exacto VARÍA según el vendor.
    //
    // Ejemplos reales:
    //   jdbc:hsqldb:file:zoo
    //   jdbc:postgresql://localhost/zoo
    //   jdbc:oracle:thin:@123.123.123.123:1521:zoo
    //   jdbc:mysql://localhost:3306
    //   jdbc:mysql://localhost:3306/zoo?profileSQL=true
    //
    // NO necesitas memorizar el formato exacto de cada vendor, pero
    // SÍ debes reconocer las 3 partes separadas por los dos puntos,
    // y saber que siempre empieza con "jdbc:".
    public void formatoDeLaURL() {
        String url = "jdbc:hsqldb:file:zoo";
        //             ^^^^  ^^^^^^ ^^^^^^^^
        //          protocolo subproto subname
        System.out.println(url);
    }


    // ================================================================
    // OBTENER UNA CONEXIÓN (DriverManager.getConnection)
    // ================================================================
    // Hay dos formas principales de obtener un Connection:
    // DriverManager y DataSource. PARA EL EXAMEN, solo se cubre
    // DriverManager (DataSource tiene más funciones pero es más
    // avanzado, usado en apps reales de producción).
    //
    // DriverManager usa el PATRÓN FACTORY: llamas a un método static
    // (getConnection()) en vez de usar "new", y te devuelve la
    // implementación correcta según la URL que le diste.
    //
    // getConnection() tiene VARIAS SOBRECARGAS. Las 2 más importantes:
    //   getConnection(String url)
    //   getConnection(String url, String username, String password)
    public void obtenerConexion() {
        // Ejemplo básico, sin usuario/password (ej: base de datos local tipo archivo):
        //
        //     try (Connection conn =
        //             DriverManager.getConnection("jdbc:hsqldb:file:zoo")) {
        //         System.out.println(conn);
        //     }
        //
        // NOTA IMPORTANTE: se usa try-with-resources porque Connection
        // implementa AutoCloseable (¡así se conecta con el tema que
        // ya vimos antes!). Esto garantiza que la conexión se cierre
        // automáticamente.
        //
        // Assumiendo que corre bien, imprime algo como:
        //     org.hsqldb.jdbc.JDBCConnection@3dfc5fb8
        // (una clase específica del DRIVER, no "Connection" directamente)


        // Ejemplo con usuario y password (ej: base de datos remota tipo servidor):
        //
        //     try (Connection conn = DriverManager.getConnection(
        //             "jdbc:postgresql://localhost:5432/ocp-book",
        //             "username",
        //             "Password20182")) {
        //         System.out.println(conn);
        //     }
        //
        // MALA PRÁCTICA (pero así aparece en ejemplos didácticos):
        // NUNCA pongas la contraseña directo en el código en un
        // proyecto real. Siempre debe venir de alguna configuración
        // externa, idealmente encriptada.
        //
        // El método lanza SQLException si algo sale mal (por ejemplo,
        // si el driver JAR correcto no está en el classpath, o si
        // las credenciales son incorrectas).
        System.out.println("Ver comentarios: ejemplo con y sin usuario/password");
    }


    // ================================================================
    // POR QUÉ USAR PreparedStatement EN VEZ DE Statement
    // ================================================================
    // Statement, PreparedStatement y CallableStatement forman una
    // jerarquía: PreparedStatement y CallableStatement SON
    // subinterfaces de Statement.
    //
    //                Statement
    //               /          \
    //   PreparedStatement   CallableStatement
    //
    // Statement ejecuta CUALQUIER SQL que le pases como texto plano.
    // PreparedStatement toma PARÁMETROS (a diferencia de Statement).
    //
    // RAZONES para preferir PreparedStatement (para el examen):
    //
    //   1. PERFORMANCE: si corres la misma consulta varias veces,
    //      la base de datos puede armar un plan de ejecución UNA VEZ
    //      y reutilizarlo, en vez de re-analizar el SQL cada vez.
    //
    //   2. SEGURIDAD: te protege de un ataque llamado SQL INJECTION,
    //      que sí es posible si concatenas Strings a mano con
    //      Statement.
    //
    //   3. LEGIBILIDAD: no tienes que concatenar Strings a mano para
    //      armar el query con muchos parámetros.
    //
    //   4. USO FUTURO: aunque tu query hoy no tenga parámetros, usar
    //      PreparedStatement desde el inicio evita que en el futuro
    //      alguien tenga que CAMBIAR de Statement a PreparedStatement
    //      cuando se necesite agregar un parámetro.
    //
    // DATO: usar la interfaz Statement directamente NO entra en el
    // examen OCP, así que no se profundiza en ella.
    public void porQuePreparedStatementEsMejor() {
        System.out.println("Performance, Seguridad, Legibilidad, Uso futuro");
    }


    // ================================================================
    // SQL INJECTION Y "LITTLE BOBBY TABLES"
    // ================================================================
    // SQL injection ocurre cuando el input del usuario NO está bien
    // "saneado" (sanitized) y se concatena directamente dentro de un
    // comando SQL. Un usuario malicioso puede escribir texto que
    // ROMPE la estructura del SQL y ejecuta comandos que no deberían.
    //
    // El ejemplo clásico (la tira cómica de xkcd "Exploits of a Mom"):
    // una escuela pone como nombre de un estudiante algo como:
    //
    //     Robert'); DROP TABLE Students;--
    //
    // Si ese nombre se concatena directo en el SQL sin protección,
    // termina BORRANDO la tabla completa de estudiantes.
    //
    // LA SOLUCIÓN: usar PreparedStatement con bind variables (los
    // signos de pregunta ?), en vez de concatenar Strings a mano.
    // Cuando usas bind variables, el driver JDBC se encarga de
    // "escapar" correctamente el valor, tratándolo SIEMPRE como un
    // dato literal, nunca como código SQL ejecutable.
    public void sqlInjectionYBobbyTables() {
        System.out.println("Nunca concatenes input del usuario directo en el SQL.");
        System.out.println("Usa bind variables (?) con PreparedStatement.");
    }


    // ================================================================
    // OBTENER UN PreparedStatement
    // ================================================================
    // Se obtiene a partir de una Connection ya existente, con el
    // método prepareStatement(), pasándole el SQL como String.
    //
    // IMPORTANTE: crear el PreparedStatement NO ejecuta la consulta
    // todavía. Solo la "prepara".
    //
    // TRAMPA DE EXAMEN: pasar el SQL es OBLIGATORIO. Si lo omites,
    // no compila:
    //
    //     try (var ps = conn.prepareStatement()) { } // DOES NOT COMPILE
    //
    // La forma correcta:
    //
    //     try (PreparedStatement ps = conn.prepareStatement(
    //             "SELECT * FROM exhibits")) {
    //         // trabajar con ps
    //     }
    //
    // PreparedStatement (igual que Connection) implementa
    // AutoCloseable, por eso se puede usar en try-with-resources.
    public void obtenerUnPreparedStatement() {
        System.out.println("conn.prepareStatement(sql) -- el SQL es obligatorio, no opcional");
    }

//AQUÍ ME QUEDÉ
    // ================================================================
    // executeUpdate() -- MODIFICAR DATOS (DELETE, INSERT, UPDATE) - DML
    // ================================================================
    // Se usa para SQL que CAMBIA datos en una tabla: sentencias que
    // empiezan con DELETE, INSERT o UPDATE.
    //
    // Firma: public int executeUpdate() throws SQLException
    //
    // DEVUELVE: la cantidad de FILAS afectadas (insertadas, borradas,
    // o actualizadas) por la sentencia SQL.
    //
    // Ejemplo con los 3 tipos:
    public void executeUpdateModificarDatos() {
        // var insertSql = "INSERT INTO exhibits VALUES(10, 'Deer', 3)";
        // var updateSql = "UPDATE exhibits SET name = 'Gorilla' " +
        //                  "WHERE name = 'None'";
        // var deleteSql = "DELETE FROM exhibits WHERE id = 10";
        //
        // try (var ps = conn.prepareStatement(insertSql)) {
        //     int result = ps.executeUpdate();
        //     System.out.println(result); // 1 -> se insertó 1 fila
        // }
        //
        // try (var ps = conn.prepareStatement(updateSql)) {
        //     int result = ps.executeUpdate();
        //     System.out.println(result); // 0 -> ninguna fila coincidía con 'None'
        // }
        //
        // try (var ps = conn.prepareStatement(deleteSql)) {
        //     int result = ps.executeUpdate();
        //     System.out.println(result); // 1 -> se borró la fila insertada arriba
        // }
        //
        // PARA EL EXAMEN: no necesitas saber leer SQL complejo, solo
        // reconocer cuántas filas afecta cada sentencia según lo que
        // te digan explícitamente en el enunciado del problema.
        System.out.println("executeUpdate() devuelve int -> filas afectadas");
    }


    // ================================================================
    // executeQuery() -- LEER DATOS (SELECT)
    // ================================================================
    // Se usa para SQL que EMPIEZA con SELECT (consultas que devuelven
    // datos, no que los modifican).
    //
    // Firma: public ResultSet executeQuery() throws SQLException
    //
    // DEVUELVE: un ResultSet, que es lo que usarás para RECORRER
    // los resultados (visto más abajo en detalle).
    public void executeQueryLeerDatos() {
        // var sql = "SELECT * FROM exhibits";
        // try (var ps = conn.prepareStatement(sql);
        //      ResultSet rs = ps.executeQuery()) {
        //     // trabajar con rs (recorrer los resultados)
        // }
        System.out.println("executeQuery() devuelve ResultSet -> para leer filas");
    }


    // ================================================================
    // execute() -- MÉTODO GENÉRICO (sirve para ambos casos)
    // ================================================================
    // Firma: public boolean execute() throws SQLException
    //
    // execute() puede correr TANTO un query como un update. Como no
    // sabe de antemano cuál es, te devuelve un boolean para que TÚ
    // decidas qué hacer con el resultado:
    //
    //   true  -> el SQL era un SELECT -> puedes llamar getResultSet()
    //   false -> el SQL era DELETE/INSERT/UPDATE -> puedes llamar
    //            getUpdateCount() para saber cuántas filas se afectaron
    //
    // Patrón típico de uso:
    //
    //     boolean isResultSet = ps.execute();
    //     if (isResultSet) {
    //         try (ResultSet rs = ps.getResultSet()) {
    //             System.out.println("ran a query");
    //         }
    //     } else {
    //         int result = ps.getUpdateCount();
    //         System.out.println("ran an update");
    //     }
    public void executeMetodoGenerico() {
        System.out.println("execute() devuelve boolean: true=SELECT, false=update");
    }


    // ================================================================
    // USAR EL MÉTODO CORRECTO -- TRAMPA DE EXAMEN
    // ================================================================
    // Si usas el método EQUIVOCADO para el tipo de SQL que tienes,
    // Java NO puede detectarlo en tiempo de COMPILACIÓN (porque el
    // SQL es solo un String, no algo que el compilador entienda).
    // El error aparece en RUNTIME, como SQLException.
    //
    // Caso 1: usar executeUpdate() con un SELECT
    //
    //     var sql = "SELECT * FROM names";
    //     try (var ps = conn.prepareStatement(sql)) {
    //         var result = ps.executeUpdate(); // SQLException en runtime
    //     }
    //     // Exception: statement does not generate a row count
    //
    // Caso 2: usar executeQuery() con un SQL que modifica datos
    //     // Exception: statement does not generate a result set
    //
    // CONCLUSIÓN: revisa siempre que el método que usas coincida con
    // el tipo de sentencia SQL (SELECT -> executeQuery, DELETE/INSERT/
    // UPDATE -> executeUpdate, o execute() si no sabes/no importa).
    public void usarElMetodoCorrecto() {
        System.out.println("SELECT + executeUpdate() = SQLException en runtime");
        System.out.println("UPDATE/INSERT/DELETE + executeQuery() = SQLException en runtime");
    }


    // ================================================================
    // TABLAS DE REFERENCIA: qué SQL puede correr cada método, y qué devuelve
    // ================================================================
    // TABLA A: SQL que puede correr cada método (Sí/No)
    //
    //   Método          | DELETE | INSERT | SELECT | UPDATE
    //   ----------------|--------|--------|--------|--------
    //   ps.execute()     |  Sí    |  Sí    |  Sí    |  Sí
    //   ps.executeQuery()|  No    |  No    |  Sí    |  No
    //   ps.executeUpdate()| Sí    |  Sí    |  No    |  Sí
    //
    // TABLA B: tipo de retorno y qué te da cada método
    //
    //   Método            | Return type | Para SELECT       | Para DELETE/INSERT/UPDATE
    //   ------------------|-------------|--------------------|---------------------------
    //   ps.execute()       | boolean     | true               | false
    //   ps.executeQuery()  | ResultSet   | filas y columnas   | n/a
    //   ps.executeUpdate() | int         | n/a                | cantidad de filas afectadas
    public void tablasDeReferenciaPreparedStatement() {
        System.out.println("Ver las 2 tablas en los comentarios -- MEMORIZAR para el examen");
    }


    // ================================================================
    // TRABAJAR CON PARÁMETROS -- BIND VARIABLES (?)
    // ================================================================
    // En vez de escribir los valores directamente en el SQL (código
    // "hard-coded"), usamos el signo de pregunta (?) como un
    // "placeholder", y luego le decimos a Java qué valor va en cada
    // uno con métodos setXxx().
    //
    // ANTES (hard-coded, mal):
    //     var sql = "INSERT INTO names VALUES(6, 1, 'Edith')";
    //
    // MEJOR (con bind variables):
    //     var sql = "INSERT INTO names VALUES(?, ?, ?)";
    //     try (PreparedStatement ps = conn.prepareStatement(sql)) {
    //         ps.setInt(1, key);      // primer  ? -> un int
    //         ps.setInt(2, type);     // segundo ? -> un int
    //         ps.setString(3, name);  // tercer  ? -> un String
    //         ps.executeUpdate();
    //     }
    //
    // REGLAS CLAVE PARA EL EXAMEN:
    //
    //   1. Los bind variables se CUENTAN DESDE 1, no desde 0
    //      (a diferencia de casi todo lo demás en Java, que empieza
    //      en 0). JDBC en general SIEMPRE cuenta columnas desde 1.
    //      Esto se PREGUNTA MUCHO en el examen.
    //
    //   2. Puedes SETEAR los parámetros EN CUALQUIER ORDEN (no
    //      necesitas hacerlo 1, 2, 3 en ese orden exacto). Lo único
    //      que importa es que TODOS estén seteados antes de ejecutar
    //      la consulta.
    public void trabajarConParametrosBindVariables() {
        System.out.println("Los bind variables se cuentan DESDE 1, no desde 0");
        System.out.println("Se pueden setear en cualquier orden, mientras estén TODOS seteados");
    }


    // ================================================================
    // ERRORES COMUNES CON BIND VARIABLES (trampas de examen)
    // ================================================================
    // ERROR 1: dejar un bind variable SIN setear
    //
    //     var sql = "INSERT INTO names VALUES(?, ?, ?)";
    //     try (var ps = conn.prepareStatement(sql)) {
    //         ps.setInt(1, key);
    //         ps.setInt(2, type);
    //         // falta setear el parámetro número 3
    //         ps.executeUpdate();
    //     }
    //
    // COMPILA bien (el compilador no puede saber cuántos "?" hay en
    // el String SQL), pero lanza SQLException en RUNTIME:
    //     Exception: Parameter not set
    //
    //
    // ERROR 2: setear MÁS valores de los que hay bind variables
    //
    //     var sql = "INSERT INTO names VALUES(?, ?)"; // solo 2 signos
    //     try (var ps = conn.prepareStatement(sql)) {
    //         ps.setInt(1, key);
    //         ps.setInt(2, type);
    //         ps.setString(3, name); // NO hay un tercer "?" en el SQL
    //         ps.executeUpdate();
    //     }
    //
    // También compila, también SQLException en runtime, pero con
    // mensaje distinto:
    //     Exception: row column count mismatch in statement
    //
    // CONCLUSIÓN: la cantidad de "?" en el SQL y la cantidad de
    // setXxx() que llames DEBEN COINCIDIR EXACTAMENTE. Cualquier
    // desajuste (de más o de menos) da SQLException en runtime,
    // nunca error de compilación.
    public void erroresComunesConBindVariables() {
        System.out.println("Parámetro faltante -> SQLException: Parameter not set");
        System.out.println("Parámetro de más -> SQLException: row column count mismatch");
    }


    // ================================================================
    // TABLA: MÉTODOS setXxx() de PreparedStatement
    // ================================================================
    // El nombre del método es fácil de recordar porque coincide con
    // el TIPO de dato que estás seteando.
    //
    //   Método      | Tipo de parámetro Java | Tipo típico en la BD
    //   ------------|-------------------------|----------------------
    //   setBoolean  | boolean                 | BOOLEAN
    //   setDouble   | double                  | DOUBLE
    //   setInt      | int                     | INTEGER
    //   setLong     | long                    | BIGINT
    //   setNull     | int (código del tipo)   | Cualquier tipo
    //   setObject   | Object                  | Cualquier tipo
    //   setString   | String                  | CHAR, VARCHAR
    //
    // DATO CLAVE sobre setObject(): funciona con CUALQUIER tipo Java.
    // Si le pasas un primitivo, Java lo AUTOBOXEA automáticamente al
    // wrapper correspondiente antes de guardarlo. Por ejemplo:
    //
    //     ps.setObject(1, key);   // int se autoboxea a Integer
    //     ps.setObject(2, type);  // int se autoboxea a Integer
    //     ps.setObject(3, name);  // String ya es Object directamente
    //
    // VENTAJA de usar el setter ESPECÍFICO (setInt, setString, etc)
    // sobre setObject(): si pasas el TIPO EQUIVOCADO, con el setter
    // específico obtienes un ERROR DE COMPILACIÓN. Con setObject(),
    // como acepta cualquier Object, el error solo aparecería en
    // runtime (si es que aparece).
    public void tablaDeMetodosSetXxx() {
        System.out.println("setInt, setLong, setDouble, setBoolean, setString, setNull, setObject");
        System.out.println("setObject acepta cualquier tipo, pero pierdes el chequeo en compilación");
    }


    // ================================================================
    // ACTUALIZAR MÚLTIPLES REGISTROS con el mismo PreparedStatement
    // ================================================================
    // Un PreparedStatement se puede REUSAR: seteas nuevos valores y
    // vuelves a ejecutar, sin necesidad de crear un PreparedStatement
    // nuevo cada vez.
    //
    // DATO IMPORTANTE: el PreparedStatement "recuerda" los parámetros
    // ya seteados de la ejecución anterior. Solo necesitas volver a
    // setear los que SÍ van a cambiar.
    //
    //     var sql = "INSERT INTO names VALUES(?, ?, ?)";
    //     try (var ps = conn.prepareStatement(sql)) {
    //         ps.setInt(1, 20);
    //         ps.setInt(2, 1);
    //         ps.setString(3, "Ester");
    //         ps.executeUpdate();      // inserta a "Ester"
    //
    //         ps.setInt(1, 21);
    //         // el parámetro 2 sigue siendo "1" de la vez anterior,
    //         // no hace falta volver a setearlo si no cambió
    //         ps.setString(3, "Elias");
    //         ps.executeUpdate();      // inserta a "Elias"
    //     }
    public void actualizarMultiplesRegistros() {
        System.out.println("El PreparedStatement recuerda los parámetros -- solo re-seteas lo que cambia");
    }


    // ================================================================
    // BATCHING STATEMENTS -- addBatch() y executeBatch()
    // ================================================================
    // El "batching" permite correr VARIAS sentencias SQL en MENOS
    // viajes de ida y vuelta a la base de datos. Esto es útil cuando
    // la base de datos está en otra máquina, porque cada "viaje de
    // red" (network round trip) tiene un costo de tiempo.
    //
    // Ejemplo: si necesitas insertar 1000 registros, es mucho más
    // rápido agruparlos en batches (por ejemplo de 100 en 100) que
    // hacer 1000 llamadas de red por separado.
    //
    //   addBatch()    -> agrega la sentencia actual al "lote" pendiente
    //   executeBatch()-> ejecuta TODAS las sentencias del lote de una vez,
    //                    y devuelve un int[] con la cantidad de filas
    //                    afectadas por CADA sentencia del lote
    //
    // PARA EL EXAMEN: no necesitas memorizar la firma exacta de estos
    // 2 métodos, pero sí es bueno reconocer su uso general (aparecen
    // en ejemplos de código, aunque no se profundice mucho en teoría).
    //
    // Ejemplo:
    //
    //     public static void register(Connection conn, int firstKey,
    //             int type, String... names) throws SQLException {
    //         var sql = "INSERT INTO names VALUES(?, ?, ?)";
    //         var nextIndex = firstKey;
    //
    //         try (var ps = conn.prepareStatement(sql)) {
    //             ps.setInt(2, type);
    //             for (var name : names) {
    //                 ps.setInt(1, nextIndex);
    //                 ps.setString(3, name);
    //                 ps.addBatch();    // agrega esta combinación al lote
    //                 nextIndex++;
    //             }
    //             int[] result = ps.executeBatch(); // ejecuta todo el lote
    //             System.out.println(Arrays.toString(result));
    //         }
    //     }
    //
    // Si llamas register(conn, 100, 1, "Elias", "Ester"), el batch
    // tiene 2 elementos (una fila por cada nombre), y el resultado
    // sería algo como: [1, 1] (cada inserción afectó 1 fila).
    public void batchingStatements() {
        System.out.println("addBatch() agrega al lote, executeBatch() ejecuta todo junto");
        System.out.println("Devuelve int[] -- filas afectadas por cada sentencia del batch");
    }


    // ================================================================
    // LEER DATOS DE UN ResultSet -- patrón típico con while
    // ================================================================
    // El patrón MÁS COMÚN para leer un ResultSet es un while() que
    // llama rs.next() como condición.
    //
    //     var sql = "SELECT id, name FROM exhibits";
    //     var idToNameMap = new HashMap<Integer, String>();
    //
    //     try (var ps = conn.prepareStatement(sql);
    //          ResultSet rs = ps.executeQuery()) {
    //
    //         while (rs.next()) {
    //             int id = rs.getInt("id");
    //             String name = rs.getString("name");
    //             idToNameMap.put(id, name);
    //         }
    //         System.out.println(idToNameMap);
    //     }
    //
    // rs.next() avanza el "cursor" del ResultSet a la SIGUIENTE fila,
    // y devuelve boolean: true si SÍ había una fila más, false si ya
    // no quedan más filas.
    public void leerDatosDeUnResultSet() {
        System.out.println("while (rs.next()) { ... } -- patrón estándar para recorrer resultados");
    }


    // ================================================================
    // EL CURSOR DEL ResultSet -- cómo se mueve, paso a paso
    // ================================================================
    // Un ResultSet tiene un "cursor" que apunta a la posición ACTUAL
    // dentro de los datos. Al principio, el cursor apunta a una
    // posición ANTES de la primera fila (todavía no hay ninguna
    // fila "activa" para leer).
    //
    // Ejemplo con una tabla de 2 filas (African Elephant, Zebra):
    //
    //   Posición inicial:      antes de la fila 1 (nada leíble aún)
    //   rs.next() -> true      cursor ahora en fila 1 (African Elephant)
    //   rs.next() -> true      cursor ahora en fila 2 (Zebra)
    //   rs.next() -> false     cursor pasó del final, no hay más datos
    //
    // OTRA FORMA de acceder a las columnas: por ÍNDICE en vez de
    // nombre (igual que con los bind variables, el ÍNDICE EMPIEZA
    // EN 1, no en 0):
    //
    //     int id = rs.getInt(1);      // primera columna
    //     String name = rs.getString(2); // segunda columna
    //
    // CUÁL USAR: acceder por NOMBRE de columna es preferible porque
    // el código es más claro, y sigue funcionando si alguien
    // reordena las columnas en el SQL. Acceder por ÍNDICE es más
    // frágil ante esos cambios.
    public void cursorDelResultSet() {
        System.out.println("El cursor empieza ANTES de la fila 1");
        System.out.println("rs.next() avanza una fila y devuelve boolean");
        System.out.println("Columnas por índice también empiezan en 1, no en 0");
    }


    // ================================================================
    // LEER UNA SOLA FILA -- usar if en vez de while
    // ================================================================
    // Cuando SABES que la consulta devuelve máximo una fila (por
    // ejemplo, un COUNT(*)), se puede usar un if() en vez de un while().
    //
    //     var sql = "SELECT count(*) FROM exhibits";
    //     try (var ps = conn.prepareStatement(sql);
    //          var rs = ps.executeQuery()) {
    //         if (rs.next()) {
    //             int count = rs.getInt(1); // por índice
    //             System.out.println(count);
    //         }
    //     }
    //
    // También se puede acceder por nombre de la columna, si le
    // pusiste un alias con AS en el SQL:
    //
    //     var sql = "SELECT count(*) AS count FROM exhibits";
    //     // ...
    //     int count = rs.getInt("count");
    //
    // REGLA DE ORO: es MUY IMPORTANTE verificar que rs.next() haya
    // devuelto true ANTES de llamar cualquier getter. Si la consulta
    // no devolvió filas, y llamas un getter de todos modos, obtienes
    // SQLException porque el cursor no está apuntando a ninguna
    // posición válida.
    public void leerUnaSolaFila() {
        System.out.println("Con máximo 1 fila esperada -> usar if(rs.next()) en vez de while");
    }


    // ================================================================
    // ERRORES COMUNES CON ResultSet (trampas de examen)
    // ================================================================
    // ERROR 1: acceder a una columna que NO EXISTE
    //
    //     var sql = "SELECT count(*) AS count FROM exhibits";
    //     // ...
    //     if (rs.next()) {
    //         var count = rs.getInt("total"); // "total" no existe, es "count"
    //     }
    //
    // SQLException: Column not found: total
    //
    //
    // ERROR 2: llamar un getter cuando NO HAY filas que coincidan
    //
    //     var sql = "SELECT * FROM exhibits where name='Not in table'";
    //     try (var ps = conn.prepareStatement(sql);
    //          var rs = ps.executeQuery()) {
    //         rs.next();       // funciona bien, devuelve false
    //         rs.getInt(1);    // SQLException! cursor no apunta a fila válida
    //     }
    //
    //
    // ERROR 3: NO llamar rs.next() en absoluto, y llamar un getter
    // directamente
    //
    //     var sql = "SELECT count(*) FROM exhibits";
    //     try (var ps = conn.prepareStatement(sql);
    //          var rs = ps.executeQuery()) {
    //         rs.getInt(1); // SQLException! el cursor sigue ANTES
    //                        // de la primera fila, nunca se movió
    //     }
    //
    // REGLA DE ORO PARA MEMORIZAR (aparece MUCHO en el examen):
    //   1. SIEMPRE usa un if() o while() al llamar rs.next(), antes
    //      de intentar leer cualquier columna.
    //   2. Los índices de columna empiezan en 1, no en 0.
    public void erroresComunesConResultSet() {
        System.out.println("Columna que no existe -> SQLException: Column not found");
        System.out.println("Getter sin fila válida -> SQLException (cursor mal posicionado)");
        System.out.println("SIEMPRE checar rs.next() antes de leer, columnas empiezan en 1");
    }


    // ================================================================
    // TABLA: MÉTODOS getXxx() de ResultSet
    // ================================================================
    // Son los métodos "opuestos" a los setXxx() de PreparedStatement
    // que vimos antes. Sirven para LEER el valor de una columna.
    //
    //   Método      | Tipo de retorno Java
    //   ------------|----------------------
    //   getBoolean  | boolean
    //   getDouble   | double
    //   getInt      | int
    //   getLong     | long
    //   getObject   | Object
    //   getString   | String
    //
    // DATO CURIOSO DE EXAMEN: NO existen getByte() ni getFloat() en
    // la lista que necesitas memorizar (aunque sí existen en la API
    // real, no son parte del contenido del examen). TAMPOCO existe
    // un método getChar() -- el examen no te hará caer en esa trampa
    // de esperar algo que no existe, pero es bueno saber que no está.
    public void tablaDeMetodosGetXxx() {
        System.out.println("getBoolean, getDouble, getInt, getLong, getObject, getString");
        System.out.println("NO existe getChar(). getByte()/getFloat() no son parte del examen.");
    }


    // ================================================================
    // getObject() -- el método GENÉRICO para leer cualquier tipo
    // ================================================================
    // getObject() puede leer una columna de CUALQUIER tipo. Si el
    // valor real es un primitivo en la base de datos, Java te lo
    // devuelve como su clase WRAPPER correspondiente (Integer,
    // Boolean, etc), porque Object no puede contener un primitivo
    // directamente.
    //
    // Ejemplo usando pattern matching de instanceof (visto en el
    // tema de instanceof) para averiguar el tipo real que devolvió:
    //
    //     var sql = "SELECT id, name FROM exhibits";
    //     try (var ps = conn.prepareStatement(sql);
    //          var rs = ps.executeQuery()) {
    //
    //         while (rs.next()) {
    //             Object idField = rs.getObject("id");
    //             Object nameField = rs.getObject("name");
    //
    //             if (idField instanceof Integer id) {
    //                 System.out.println(id);
    //             }
    //             if (nameField instanceof String name) {
    //                 System.out.println(name);
    //             }
    //         }
    //     }
    //
    // EN LA PRÁCTICA: casi nunca usarás getObject() al escribir
    // código real para el trabajo (es más cómodo usar el getter
    // específico como getInt() o getString()). Pero PARA EL EXAMEN
    // es importante que sepas que existe y cómo se comporta.
    public void getObjectGenerico() {
        System.out.println("getObject() devuelve Object -- primitivos se autoboxean a su wrapper");
    }
}
