package com.digitalhouse.ClinicaOdontologica.Repository.ImplementacionRepository;

import com.digitalhouse.ClinicaOdontologica.Model.Turno;
import com.digitalhouse.ClinicaOdontologica.Repository.IDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ImpleTurnoRepositoryList implements IDao<Turno> {
    private static final Logger logger = LogManager.getLogger(ImpleTurnoRepositoryList.class);
    private List<Turno> turnos = new ArrayList<>();


    @Override
    public Turno guardar(Turno turno) {
        logger.info("Inciando Operaciones de Guardado en Lista de turnos");
        ImplePacienteRepository implePacienteRepository = new ImplePacienteRepository();
        ImpleOdontologoRepository impleOdontologoRepository = new ImpleOdontologoRepository();

        turno.setPaciente(implePacienteRepository.buscarPorId(turno.getPaciente().getId()));
        turno.setOdontologo(impleOdontologoRepository.buscarPorId(turno.getOdontologo().getId()));

        turnos.add(turno);
        logger.info("Turno guardado");
        return turno;
    }

    @Override
    public Turno buscarPorId(Integer id) {
        logger.info("Inciando Operaciones de busqueda de turno por ID: {}", id);
        for (Turno turno : turnos){
            if(turno.getId().equals(id)){
                return turno;
            }
        }
        System.out.println("Turno no encontrado");
        return null;
    }

    @Override
    public void actualizar(Turno turno) {

    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Turno> mostrarTodos() {
        return turnos;
    }
}
