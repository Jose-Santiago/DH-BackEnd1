package com.digitalhouse.ClinicaOdontologica.Service;

import com.digitalhouse.ClinicaOdontologica.DAO.IDao;
import com.digitalhouse.ClinicaOdontologica.DAO.ImplementacionDAO.ImplePacienteDAO;
import com.digitalhouse.ClinicaOdontologica.Model.Paciente;
import org.springframework.stereotype.Service;

@Service
public class ServicioPaciente {
    private ImplePacienteDAO pacienteiDao;

    public ServicioPaciente() {
        pacienteiDao= new ImplePacienteDAO();
    }
    //metodos manuales CRUD
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteiDao.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteiDao.buscarPorId(id);
    }
    public Paciente buscarPorCorreo(String correo){ return pacienteiDao.buscarPorString(correo); }
}
