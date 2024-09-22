package com.digitalhouse.ClinicaOdontologica.Security;

import com.digitalhouse.ClinicaOdontologica.Entity.*;
import com.digitalhouse.ClinicaOdontologica.Repository.IOdontologoRepository;
import com.digitalhouse.ClinicaOdontologica.Repository.IPacienteRepository;
import com.digitalhouse.ClinicaOdontologica.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DatosIniciales implements ApplicationRunner {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    IPacienteRepository pacienteRepository;
    @Autowired
    IOdontologoRepository odontologoRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String passSinCifrar = "user";
        String passCifrado = bCryptPasswordEncoder.encode(passSinCifrar);
        Usuario usuario = new Usuario("Jorgito","jpereyradh","jorge@dh.com",passCifrado, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);

        String passSinCifrar2 = "admin";
        String passCifrado2 = bCryptPasswordEncoder.encode(passSinCifrar2);
        Usuario usuario2 = new Usuario("jose","jossdh","joss@dh.com",passCifrado2, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario2);

        Paciente paciente = new Paciente();
        paciente.setNombre("jose");
        paciente.setApellido("santiago");
        paciente.setCedula("wer789");
        paciente.setFechaIngreso(LocalDate.of(2024,9,10));
        paciente.setEmail("joss@dh.com");

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Morelos");
        domicilio.setNumero(20);
        domicilio.setLocalidad("Puebla");
        domicilio.setProvincia("Mexico");

        paciente.setDomicilio(domicilio);

        pacienteRepository.save(paciente);

        // creamos un nuevo odontologo
        Odontologo odontologo = new Odontologo();
        odontologo.setNombre("lucia");
        odontologo.setApellido("Pablo");
        odontologo.setMatricula("pab123");

        odontologoRepository.save(odontologo);
    }
}
