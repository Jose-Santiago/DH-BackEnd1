package com.dh.test;

import com.dh.evaluacion.dao.BDH2;
import com.dh.evaluacion.model.Paciente;
import com.dh.evaluacion.service.ServicioPaciente;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestPaciente {
    @Test
    public void buscarPaciente(){
        BDH2.sqlCrearTabla();
        ServicioPaciente servicioPaciente = new ServicioPaciente();
        Integer idABuscar = 1;
        Paciente paciente = servicioPaciente.buscarPorId(idABuscar);
        System.out.println("Paciente: " + paciente.getNombre());
        assertNotNull(paciente);
    }
}
