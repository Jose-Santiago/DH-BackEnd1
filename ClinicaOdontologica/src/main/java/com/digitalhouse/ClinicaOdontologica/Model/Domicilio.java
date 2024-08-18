package com.digitalhouse.ClinicaOdontologica.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Domicilio {
    private Integer id;
    private String calle;
    private int numero;
    private String localidad;
    private String provincia;

    public Domicilio(Integer id, String calle, int numero, String localidad, String provincia) {
        this.id = id;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }
}
