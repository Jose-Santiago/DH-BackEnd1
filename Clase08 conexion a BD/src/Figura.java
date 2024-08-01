import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Figura {
    private  static final Logger logger = Logger.getLogger(Figura.class);
    public static void main(String[] args) throws Exception {
        // Cargar el controlador H2
        Class.forName("org.h2.Driver");

        // Conexión a la base de datos
        Connection con = DriverManager.getConnection("jdbc:h2:mem:~/tablaFiguras", "sa", "");
        logger.info("Se creo la conexion a BD");

        //comunicamos objetos con tablas
        Statement stmt = con.createStatement();

        // Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        String crearTabla = "DROP TABLE IF EXISTS tablaFiguras;\n"
                + "CREATE TABLE tablaFiguras(ID INT PRIMARY KEY, TIPO VARCHAR(40), COLOR VARCHAR(40));";
        stmt.execute(crearTabla);
        logger.info("Creando Tabla tablaFiguras");

        //se agregan datos a la tabla
        String agregarDatos = "INSERT INTO tablaFiguras VALUES(1, 'CIRCULO', 'ROJO');\n"+
                "INSERT INTO tablaFiguras VALUES(2, 'CIRCULO', 'VERDE');\n"+
                "INSERT INTO tablaFiguras VALUES(3, 'CUADRADO', 'AZUL');\n"+
                "INSERT INTO tablaFiguras VALUES(4, 'CUADRADO', 'ROJO');\n"+
                "INSERT INTO tablaFiguras VALUES(5, 'CUADRADO', 'GRIS');\n";
        stmt.execute(agregarDatos);
        logger.info("Agregando Datos a tabla");

        // Asegurarse de que los cambios se persistan
        //con.commit();

        //consulta pra ver circulos rojos
        String consultaSQL = "SELECT * FROM tablaFiguras WHERE COLOR = 'ROJO'";
       // String consultaSQL = "SELECT * FROM tablaFiguras";
        ResultSet resultado = stmt.executeQuery(consultaSQL);

        //recorremos los resultados de la consulta

        while (resultado.next()){
            System.out.println("ID: " + resultado.getInt(1) + " - Tipo: " + resultado.getString(2) + " -Color: " + resultado.getString(3));
        }

        //cerrar recursos
        resultado.close();
        stmt.close();
        con.close();
    }

}
