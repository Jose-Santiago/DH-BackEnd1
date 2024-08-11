package com.dh.evaluacion.dao.implementacion;

import com.dh.evaluacion.dao.BDH2;
import com.dh.evaluacion.dao.IDao;
import com.dh.evaluacion.model.Odontologo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ImpleOdontologoDAOH2 implements IDao<Odontologo> {
    private static final Logger logger = LogManager.getLogger(ImpleOdontologoDAOH2.class);

    private static final String SQL_INSERT_ODONTOLOGO = "INSERT INTO ODONTOLOGOS(MATRICULA, NOMBRE, APELLIDO) VALUES(?,?,?);";
    private static final String SQL_OBTENER_ODONTOLOGOS = "SELECT * FROM ODONTOLOGOS";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        logger.info("Inciando operacion de guardado de un odontologo");
        try {
            Connection connection = BDH2.getConnection();
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_ODONTOLOGO, Statement.RETURN_GENERATED_KEYS);

            psInsert.setInt(1,odontologo.getMatricula());
            psInsert.setString(2, odontologo.getNombre());
            psInsert.setString(3, odontologo.getApellido());
            psInsert.execute();
            logger.info("Datos de Odotologo guardados con Exito");

            ResultSet resultSet = psInsert.getGeneratedKeys();
            while (resultSet.next()) odontologo.setId(resultSet.getInt("ID"));

        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> mostrarOdontologos() {
        List<Odontologo> listaOdontologos = new ArrayList<>();
        try {
            Connection connection = BDH2.getConnection();
            PreparedStatement psObtener = connection.prepareStatement(SQL_OBTENER_ODONTOLOGOS);
            ResultSet resultSet = psObtener.executeQuery();

            logger.info("Obteniendo todos los Odontologos en la BD H2");

            while (resultSet.next())listaOdontologos.add(new Odontologo(resultSet.getInt("ID"), resultSet.getInt("MATRICULA"), resultSet.getString("NOMBRE"), resultSet.getString("APELLIDO")));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return listaOdontologos;
    }
}
