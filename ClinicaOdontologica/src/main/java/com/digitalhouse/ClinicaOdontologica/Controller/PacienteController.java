package com.digitalhouse.ClinicaOdontologica.Controller;

import com.digitalhouse.ClinicaOdontologica.Model.Paciente;
import com.digitalhouse.ClinicaOdontologica.Service.ServicioPaciente;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    private ServicioPaciente servicioPaciente;

    public PacienteController() {
        servicioPaciente = new ServicioPaciente();
    }

    @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        Paciente nuevoPaciente = servicioPaciente.guardarPaciente(paciente);
        if (paciente != null){
            return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Paciente>> listarPacientes(){
        List<Paciente> todosLosPacientes = servicioPaciente.obtenerLosPacientes();

        if(todosLosPacientes.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(todosLosPacientes, HttpStatus.OK);
    }
}
