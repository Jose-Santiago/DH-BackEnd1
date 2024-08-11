package com.dh.evaluacion.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BDH2 {
    private static final Logger logger = LogManager.getLogger(BDH2.class);

    private static final String URL = "jdbc:h2:mem:~/bdodontologos";
    private static final String h2User = "sa";
    private static final String h2Passw = "sa";

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS ODONTOLOGOS;"
            + "CREATE TABLE ODONTOLOGOS(ID INT AUTO_INCREMENT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL)";

    public static void sqlCrearTabla(){
        try {
            Connection connection = getConnection();
            logger.info("Conexion a h2 establecida con exito");

            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);
            logger.info("Tabla de Odontologos creada con exito");

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(URL,h2User,h2Passw);
    }
}
