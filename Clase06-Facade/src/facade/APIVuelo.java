package facade;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class APIVuelo {
    private String salida, regreso;
    private String origen, destino;


    public APIVuelo() {
    }
    public void busquedaVuelos(String salida, String regreso, String origen, String destino){
        System.out.println("*******************************************");
        System.out.println("Estos son los resultados de la Busqueda de Vuelos con los datos:");
        System.out.println("Fecha Salida: " + salida);
        System.out.println("Fecha Regreso: " + regreso);
        System.out.println("Ciudad de Origen " + origen);
        System.out.println("Ciudad Destino " + destino);
        System.out.println("*******************************************");

    }
}
