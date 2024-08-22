package com.digitalhouse.ClinicaOdontologica.Controller;

import com.digitalhouse.ClinicaOdontologica.Model.Turno;
import com.digitalhouse.ClinicaOdontologica.Service.ServicioOdontologo;
import com.digitalhouse.ClinicaOdontologica.Service.ServicioPaciente;
import com.digitalhouse.ClinicaOdontologica.Service.ServicioTurno;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turno")
public class TurnoController {
    private ServicioTurno servicioTurno;
    private ServicioPaciente servicioPaciente;
    private ServicioOdontologo servicioOdontologo;

    public TurnoController() {
        servicioTurno = new ServicioTurno();
        servicioPaciente = new ServicioPaciente();
        servicioOdontologo = new ServicioOdontologo();

    }

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        return null;
    }
}
