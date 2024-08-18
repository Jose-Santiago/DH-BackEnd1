package com.example.odontologo.services;

import com.example.odontologo.domain.Odontologo;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OdontoloServiceImpl implements OdontologoService{

    @Override
    public List<Odontologo> listaOdontologos() {
        return Arrays.asList(new Odontologo("Juan",25), new Odontologo("pedro",55));
    }
}
