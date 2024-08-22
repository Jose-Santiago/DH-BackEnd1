package com.digitalhouse.ClinicaOdontologica.Service;

import com.digitalhouse.ClinicaOdontologica.Model.Turno;
import com.digitalhouse.ClinicaOdontologica.Repository.IDao;
import com.digitalhouse.ClinicaOdontologica.Repository.ImplementacionRepository.ImpleOdontologoRepository;
import com.digitalhouse.ClinicaOdontologica.Repository.ImplementacionRepository.ImpleTurnoRepositoryList;

import java.util.List;

public class ServicioTurno {
    private IDao<Turno> turnoIDao;

    public ServicioTurno() {
        turnoIDao = new ImpleTurnoRepositoryList();
    }

    public Turno guardarTurno(Turno turno){
        return turnoIDao.guardar(turno);
    }

    public Turno buscarPorId(Integer id){
        return turnoIDao.buscarPorId(id);
    }

    public List<Turno> listarTodos(){
        return turnoIDao.mostrarTodos();
    }

}
