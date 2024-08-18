package com.digitalhouse.ClinicaOdontologica.Controller;

import com.digitalhouse.ClinicaOdontologica.Model.Paciente;
import com.digitalhouse.ClinicaOdontologica.Service.ServicioPaciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/paciente")
public class PacienteController {
    private ServicioPaciente servicioPaciente;

    public PacienteController() {
        servicioPaciente = new ServicioPaciente();
    }

    @GetMapping("/buscar")
    public String buscarPorCorreo(Model model, @RequestParam("email") String correo){
        Paciente paciente = servicioPaciente.buscarPorCorreo(correo);
        if(paciente != null){
            model.addAttribute("nombre", paciente.getNombre());
            model.addAttribute("apellido", paciente.getApellido());
        }else {
            model.addAttribute("nombre","Paciente");
            model.addAttribute("apellido","No encontrado!!!");
        }
        return "index";
    }
}
