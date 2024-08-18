package com.digitalhouse.ClinicaOdontologica.Service;

import com.digitalhouse.ClinicaOdontologica.DAO.IDao;
import com.digitalhouse.ClinicaOdontologica.DAO.ImplementacionDAO.ImpleOdontologoDAO;
import com.digitalhouse.ClinicaOdontologica.Model.Odontologo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioOdontologo {
    private IDao<Odontologo> odontologoIDao;

    public ServicioOdontologo() {
        odontologoIDao = new ImpleOdontologoDAO();
    }

    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoIDao.guardar(odontologo);
    }
    public Odontologo buscarPorID(Integer id){
        return odontologoIDao.buscarPorId(id);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoIDao.actualizar(odontologo);
    }

    public void eliminarOdontologo(Integer id){
        odontologoIDao.eliminar(id);
    }

    public List<Odontologo> mostrarOdontologos(){
        return odontologoIDao.mostrarOdontologos();
    }
}
