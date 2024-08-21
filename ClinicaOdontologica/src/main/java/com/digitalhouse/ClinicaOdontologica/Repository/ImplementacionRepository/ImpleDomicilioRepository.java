package com.digitalhouse.ClinicaOdontologica.Repository.ImplementacionRepository;

import com.digitalhouse.ClinicaOdontologica.Repository.BDH2;
import com.digitalhouse.ClinicaOdontologica.Repository.IDao;
import com.digitalhouse.ClinicaOdontologica.Model.Domicilio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ImpleDomicilioRepository implements IDao<Domicilio> {
    private static final Logger logger= LogManager.getLogger(ImpleDomicilioRepository.class);
    private static final String SQL_SELECT_ONE="SELECT * FROM DOMICILIOS WHERE ID=?";
    private static final String SQL_INSERT="INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES(?,?,?,?)";

    @Override
    public Domicilio guardar(Domicilio domicilio) {
        logger.info("iniciando las operaciones de guardado de un domicilio");

        try{
            Connection connection= BDH2.getConnection();
            PreparedStatement psGuardar = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            psGuardar.setString(1, domicilio.getCalle());
            psGuardar.setInt(2,domicilio.getNumero());
            psGuardar.setString(3, domicilio.getLocalidad());
            psGuardar.setString(4, domicilio.getProvincia());
            psGuardar.execute();
            ResultSet rs= psGuardar.getGeneratedKeys();
            while(rs.next()){
                domicilio.setId(rs.getInt(1));
            }
            logger.info("domicilio persistido");
        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        logger.info("iniciando las operaciones de buscado de un domicilio");
        Connection connection= null;
        Domicilio domicilio= null;
        try{
            connection= BDH2.getConnection();
            PreparedStatement psSelectOne= connection.prepareStatement(SQL_SELECT_ONE);
            psSelectOne.setInt(1,id);
            ResultSet rs= psSelectOne.executeQuery();
            while (rs.next()){
                domicilio= new Domicilio(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
            }

        }catch (Exception e){
            logger.error("conexion fallida: "+e.getMessage());
        }
        return domicilio;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
    }

    @Override
    public void eliminar(Integer id) {
    }

    @Override
    public List<Domicilio> mostrarTodos() {
        return List.of();
    }
}
