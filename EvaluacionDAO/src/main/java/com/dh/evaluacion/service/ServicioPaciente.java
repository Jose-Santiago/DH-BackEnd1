package com.dh.evaluacion.service;

import com.dh.evaluacion.dao.IDao;
import com.dh.evaluacion.dao.implementacion.ImplePacienteDAOH2;
import com.dh.evaluacion.model.Paciente;

public class ServicioPaciente {
    private IDao<Paciente> pacienteiDao;

    public ServicioPaciente() {
        pacienteiDao= new ImplePacienteDAOH2();
    }
    //metodos manuales CRUD
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
}
