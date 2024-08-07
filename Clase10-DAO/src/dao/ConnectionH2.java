package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionH2 {
    Logger logs = Logger.getLogger(ConnectionH2.class);

    private static final String URL = "jdbc:h2:mem:~/BDMedicamentos";
    private static  final String h2Username = "sa";
    private static final String h2Password = "sa";

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS MEDICAMENTOS; "
            +"CREATE TABLE MEDICAMENTOS (ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, CODIGO_NUMERICO INT NOT NULL, "
            +"LABORATORIO VARCHAR(100) NOT NULL, PRECIO NUMERIC(10,2) NOT NULL, CANTIDAD INT NOT NULL)";

    //metodo para crear la tabla de medicamentos
    public void crearTabla(){
        try {
            Connection connection = getConnection();
            logs.info("Conexion a H2 exitosa.");

            Statement stmt = connection.createStatement();
            stmt.execute(SQL_CREATE_TABLE);
            logs.info("Tabla Medicamentos creada con exito");


        }catch (Exception e){
            logs.error(e.getMessage());
        }
    }

    public Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL,h2Username,h2Password);
    }

}
