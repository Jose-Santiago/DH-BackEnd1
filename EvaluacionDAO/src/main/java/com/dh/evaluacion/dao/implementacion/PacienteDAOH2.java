package com.dh.evaluacion.dao.implementacion;

import com.dh.evaluacion.dao.BDH2;
import com.dh.evaluacion.dao.IDao;
import com.dh.evaluacion.model.Domicilio;
import com.dh.evaluacion.model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class PacienteDAOH2 implements IDao<Paciente> {
    private static final Logger logger= LogManager.getLogger(PacienteDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID) " +
            "VALUES(?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=? ";

    @Override
    public Paciente guardar(Paciente paciente) {
        logger.info("iniciando las operaciones de guardado de un paciente");
        Connection connection= null;
        try{
            connection= BDH2.getConnection();
            PreparedStatement psInsert= connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psInsert.setString(1, paciente.getNombre());
            psInsert.setString(2, paciente.getApellido());
            psInsert.setString(3, paciente.getCedula());
            psInsert.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            psInsert.setInt(5,paciente.getDomicilio().getId());
            psInsert.execute(); //se van a generar ID
            ResultSet rs= psInsert.getGeneratedKeys();
            while(rs.next()){
                paciente.setId(rs.getInt(1));
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de buscado de un paciente");
        Connection connection= null;
        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            connection= BDH2.getConnection();
            Statement statement= connection.createStatement();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            DomicilioDAOH2 daoAux= new DomicilioDAOH2();
            while (rs.next()){
                domicilio= daoAux.buscarPorId(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio);
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public void actualizar(Paciente paciente) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Paciente> mostrarOdontologos() {
        return List.of();
    }
}
