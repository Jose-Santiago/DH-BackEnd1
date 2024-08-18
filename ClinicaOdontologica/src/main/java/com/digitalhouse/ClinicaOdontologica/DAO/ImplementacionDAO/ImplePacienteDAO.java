package com.digitalhouse.ClinicaOdontologica.DAO.ImplementacionDAO;

import com.digitalhouse.ClinicaOdontologica.DAO.BDH2;
import com.digitalhouse.ClinicaOdontologica.DAO.IDao;
import com.digitalhouse.ClinicaOdontologica.Model.Domicilio;
import com.digitalhouse.ClinicaOdontologica.Model.Paciente;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class ImplePacienteDAO implements IDao<Paciente> {
    private static final Logger logger= LogManager.getLogger(ImplePacienteDAO.class);
    private static final String SQL_INSERT="INSERT INTO PACIENTES (NOMBRE, APELLIDO, CEDULA, FECHA_INGRESO, DOMICILIO_ID, EMAIL) " +
            "VALUES(?,?,?,?,?,?)";
    private static final String SQL_SELECT_ONE="SELECT * FROM PACIENTES WHERE ID=? ";
    private static final String SQL_SELECT_EMAIL="SELECT * FROM PACIENTES WHERE EMAIL=? ";

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
            psInsert.setString(6,paciente.getEmail());
            //psInsert.execute(); no es necesario ejecutar el preparedstatement ya que en el resulset se ejecuta de forma automatica y
            ResultSet rs= psInsert.getGeneratedKeys(); //se van a generar ID
            while(rs.next()){
                paciente.setId(rs.getInt(1));// al generarse el ID con el resulset, lo obtenemos de la misma consulta y lo asignamos a nuestro objeto
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de buscado de un paciente");

        Paciente paciente=null;
        Domicilio domicilio=null;
        try{
            Connection connection= BDH2.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            ImpleDomicilioDAO daoAux= new ImpleDomicilioDAO();
            while (rs.next()){
                domicilio= daoAux.buscarPorId(rs.getInt(6));
                paciente= new Paciente(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5).toLocalDate(),domicilio, rs.getString(6));
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return paciente;
    }

    @Override
    public Paciente buscarPorString(String string) {
        logger.info("Iniciando las Operaciones de busqueda : ${}", string);
        Paciente paciente = null;
        Domicilio domicilio = null;
        ImpleDomicilioDAO daoAux = new ImpleDomicilioDAO();
        try {
            Connection connection = BDH2.getConnection();
            PreparedStatement psSelectEmail = connection.prepareStatement(SQL_SELECT_EMAIL);
            psSelectEmail.setString(1, string);
            ResultSet rs = psSelectEmail.executeQuery();
            while (rs.next()){
                domicilio = daoAux.buscarPorId(rs.getInt("DOMICILIO_ID"));
                paciente = new Paciente(rs.getInt("ID"),rs.getString("NOMBRE"),rs.getString("APELLIDO"),rs.getString("CEDULA"),rs.getDate("FECHA_INGRESO").toLocalDate(),domicilio,rs.getString("EMAIL"));
            }
        } catch (Exception e) {
            logger.error("Fallo en la conexion: ${}", e.getMessage());
        }
        if (paciente != null) {
            logger.info("Paciente encontrado con exito!!!");
        }else {
            logger.warn("error en la busqueda, paciente null");
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
