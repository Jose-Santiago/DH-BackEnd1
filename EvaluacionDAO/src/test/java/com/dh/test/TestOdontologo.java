package com.dh.test;

import com.dh.evaluacion.dao.BDH2;
import com.dh.evaluacion.model.Odontologo;
import com.dh.evaluacion.service.ServicioOdontologo;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestOdontologo {
    ServicioOdontologo servicioOdontologo = new ServicioOdontologo();
    //datos de prueba
    Odontologo odontologo1 = new Odontologo(12345, "Juan", "Perez");
    Odontologo odontologo2 = new Odontologo(18475, "raul", "lopez");
    Odontologo odontologo3 = new Odontologo(85471, "pedro", "ruiz");
    Odontologo odontologo4 = new Odontologo(12478, "macario", "cruz");

    public void crearDatos(){
        BDH2.sqlCrearTabla();
        servicioOdontologo.guardarOdontologo(odontologo1);
        servicioOdontologo.guardarOdontologo(odontologo2);
        servicioOdontologo.guardarOdontologo(odontologo3);
    }
    public void listarOdontologos(){
        //BDH2.sqlCrearTabla();
        List<Odontologo> listaOdontologos = servicioOdontologo.mostrarOdontologos();

        System.out.println("------Lista de Todos los Odontologos: -------");
        for (Odontologo odontologo : listaOdontologos){
            System.out.println("ID: "+odontologo.getId()+" Matricula: "+ odontologo.getMatricula()+" Nombre: "+odontologo.getNombre());
        }
        System.out.println("-----------FIN LISTA ODONTOLOGOS------- \n");
    }

    @Test
    public void guardarDatos(){
        crearDatos();
        Odontologo resultado = servicioOdontologo.guardarOdontologo(odontologo4);
        assertEquals((Integer) 4,resultado.getId());
    }

    @Test
    public void testActualizacionOdontologo(){
        crearDatos();
        System.out.println("Datos actuales en la BD H2");
        listarOdontologos();
        odontologo1.setMatricula(5000);
        odontologo1.setNombre("Nombre Actualizado");
        servicioOdontologo.actualizarOdontologo(odontologo1);

        System.out.println("Datos una vez actualizado un odontologo");
        listarOdontologos();
        assertEquals((Integer) 5000, servicioOdontologo.buscarPorID(odontologo1.getId()).getMatricula());
    }

    @Test
    public void testEliminarOdontologo(){
        crearDatos();
        System.out.println("Datos Antes de Eliminar un Odontologo");
        listarOdontologos();
        servicioOdontologo.eliminarOdontologo(3);

        System.out.println("datos despues de la eliminacion: ");
        listarOdontologos();

        int resultado = servicioOdontologo.mostrarOdontologos().size();
        assertEquals(2,resultado);
    }

}
