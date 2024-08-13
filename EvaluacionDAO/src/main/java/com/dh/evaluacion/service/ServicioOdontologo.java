package com.dh.evaluacion.service;

import com.dh.evaluacion.dao.IDao;
import com.dh.evaluacion.dao.implementacion.ImpleOdontologoDAOH2;
import com.dh.evaluacion.model.Odontologo;

import java.util.List;

public class ServicioOdontologo {
    private IDao<Odontologo> odontologoIDao;

    public ServicioOdontologo() {
        odontologoIDao = new ImpleOdontologoDAOH2();
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
