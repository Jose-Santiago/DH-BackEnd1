package com.digitalhouse.ClinicaOdontologica.Service;

import com.digitalhouse.ClinicaOdontologica.Repository.ImplementacionRepository.ImplePacienteRepository;
import com.digitalhouse.ClinicaOdontologica.Model.Paciente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioPaciente {
    private ImplePacienteRepository pacienteRepository;

    public ServicioPaciente() {
        pacienteRepository = new ImplePacienteRepository();
    }
    //metodos manuales CRUD
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.guardar(paciente);
    }
    public Paciente buscarPorId(Integer id){
        return pacienteRepository.buscarPorId(id);
    }
    public Paciente buscarPorCorreo(String correo){ return pacienteRepository.buscarPorString(correo); }
    public List<Paciente> obtenerLosPacientes(){ return pacienteRepository.mostrarTodos(); }
}
