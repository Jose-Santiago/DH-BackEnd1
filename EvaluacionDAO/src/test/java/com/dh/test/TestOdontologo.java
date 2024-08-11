package com.dh.test;

import com.dh.evaluacion.dao.BDH2;
import com.dh.evaluacion.model.Odontologo;
import com.dh.evaluacion.service.ServicioOdontologo;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class TestOdontologo {
    ServicioOdontologo servicioOdontologo;

    Odontologo odontologo1 = new Odontologo(12345, "Juan", "Perez");
    Odontologo odontologo2 = new Odontologo(18475, "raul", "lopez");
    Odontologo odontologo3 = new Odontologo(85471, "pedro", "ruiz");
    Odontologo odontologo4 = new Odontologo(12478, "macario", "cruz");


    @Test
    public void guardarDatos(){
        BDH2.sqlCrearTabla();
        servicioOdontologo = new ServicioOdontologo();

        servicioOdontologo.guardarOdontologo(odontologo1);
        servicioOdontologo.guardarOdontologo(odontologo2);
        servicioOdontologo.guardarOdontologo(odontologo3);

        Odontologo resultado = servicioOdontologo.guardarOdontologo(odontologo4);
        Assert.assertEquals((Integer) 4,resultado.getId());

    }

    @Test
    public void listarOdontologos(){
        BDH2.sqlCrearTabla();
        servicioOdontologo = new ServicioOdontologo();

        servicioOdontologo.guardarOdontologo(odontologo1);
        servicioOdontologo.guardarOdontologo(odontologo2);
        servicioOdontologo.guardarOdontologo(odontologo3);

        List<Odontologo> listaOdontologos = servicioOdontologo.mostrarOdontologos();

        System.out.println("------Lista de Todos los Odontologos: -------");
        for (Odontologo odontologo : listaOdontologos){
            System.out.println("ID: "+odontologo.getId()+" Matricula: "+ odontologo.getMatricula()+" Nombre: "+odontologo.getNombre());
        }
        Assert.assertEquals( 3, listaOdontologos.size());
    }

}
