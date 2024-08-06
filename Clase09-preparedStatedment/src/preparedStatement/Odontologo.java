package preparedStatement;

import org.apache.log4j.Logger;

import java.sql.*;

public class Odontologo {
    //objeto para crear los logs de la clase
    private static final Logger logs = Logger.getLogger(Odontologo.class);

    //Consultas prametrizadas
    private static final String SQL_DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;"
            + "CREATE TABLE ODONTOLOGOS(ID INT PRIMARY KEY, NOMBRE VARCHAR(100) NOT NULL, APELLIDO VARCHAR(100) NOT NULL, MATRICULA VARCHAR(100) NOT NULL )";
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE ID = ?";

    private static final String SQL_READBD = "SELECT * FROM ODONTOLOGOS";
    // metodo principal
    public static void main(String[] args) {
        Connection connection = null;

        try {
            //obtenemos la conexion a la BD
            connection = getConnection();

            //Creamos la tabla odontologos
            Statement stmt = connection.createStatement();
            stmt.execute(SQL_DROP_CREATE);
            logs.info("Tabla creado con exito");

            //ejecutamos las sentencias parametrizadas

            PreparedStatement pStInser = connection.prepareStatement(SQL_INSERT);
            //agregamos parametros a la sentencia
            pStInser.setInt(1,1);
            pStInser.setString(2,"Juan");
            pStInser.setString(3,"Perez");
            pStInser.setString(4,"12345");
            //Ejecutamos la sentencia Insert
            pStInser.execute();
            logs.info("Datos Insertados con Exito");

            //realizamos una consulta a la BD e imprimimos la informacion.
            ResultSet rd = stmt.executeQuery(SQL_READBD);
            while (rd.next()){
                System.out.println("id: " + rd.getInt(1) + " Nombre: " + rd.getString(2) + " Apellido: " + rd.getString(3) + " Matricula: " + rd.getString(4));
            }

            // Sentencia de Actualizacion
            PreparedStatement pStUpdate = connection.prepareStatement(SQL_UPDATE);
            pStUpdate.setString(1,"nuevaMatricual");
            pStUpdate.setInt(2,1);
            //Ejecutamos la sentencia Insert
            pStUpdate.execute();
            logs.info("Matricula Actualizada con Exito!!");

            // consultamos los datos para verificar la actualziacion
            rd = stmt.executeQuery(SQL_READBD);
            while (rd.next()){
                System.out.println("id: " + rd.getInt(1) + " Nombre: " + rd.getString(2) + " Apellido: " + rd.getString(3) + " Matricula: " + rd.getString(4));
            }

        }catch (Exception err){

        }finally {

        }

    }
    //metodo para obtener la conexion
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/Database/tablaOdontologo", "sa","sa");
    }
}
