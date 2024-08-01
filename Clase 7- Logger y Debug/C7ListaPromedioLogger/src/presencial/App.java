package presencial;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class App {
    private static final Logger logger= Logger.getLogger(App.class);
    private List<Integer> listaEnteros;

    public App() {
        listaEnteros= new ArrayList<>();
        logger.info("instancia creada");
    }

    public void agregarEnterosAlaLista(Integer numero){
        listaEnteros.add(numero);
        logger.info("elemento agregado");
        //La logica indica que debemos loguear cuando?
        if(listaEnteros.size()>5){
            //anotabamos en el registro(logueamos)
            logger.warn("La lista tiene mas de 5: "+listaEnteros.size()+" Elementos");
        }
        if(listaEnteros.size()>10){
            //anotabamos en el registro(logueamos)
            logger.warn("La lista tiene mas de 10: "+" Actualmente contiene: "+listaEnteros.size()+" Elementos");
        }

    }

    public void calcularPromedio(){
        double promedio = 0.0;
        Integer suma = 0;
        if (listaEnteros.isEmpty()){
            logger.error("La lista no tiene elementos", new Throwable());
        }else{
            for (Integer numero: listaEnteros){
                suma += numero;
            }
            promedio = suma/ listaEnteros.size();
            logger.info("EL promedio es: "+promedio);
        }
    }
}
