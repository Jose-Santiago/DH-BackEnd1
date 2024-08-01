import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestLog {
    public static void main(String[] args) throws Exception {
        // Cargar el controlador H2
        Class.forName("org.h2.Driver").newInstance();

        // Conexión a la base de datos
        Connection con = DriverManager.getConnection("jdbc:h2:mem:~/test", "sa", "");

        // Crear una declaración para comunicar objto con tablas
        Statement stmt = con.createStatement();

        // Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        String createSql = "DROP TABLE IF EXISTS TEST;\n" +
                "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255));\n" +
                "INSERT INTO TEST VALUES(1, 'Hello');\n" +
                "INSERT INTO TEST VALUES(2, 'World');\n";
        stmt.execute(createSql);

        // Asegurarse de que los cambios se persistan
        con.commit();

        // Código para consultar todos los registros de la tabla TEST
        String sql = "SELECT * FROM TEST";
        ResultSet rd = stmt.executeQuery(sql);

        // Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2));
        }

        // Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        createSql ="INSERT INTO TEST VALUES(3, 'prueba');\n" +
                "INSERT INTO TEST VALUES(4, 'World');\n";
        stmt.execute(createSql);

        // Código para consultar todos los registros de la tabla TEST
        rd = stmt.executeQuery(sql);

        // Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2));
        }

        // Cerrar recursos
        rd.close();
        stmt.close();
        con.close();
    }
}
