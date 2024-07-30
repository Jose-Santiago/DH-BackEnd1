package mesaTrabajo;

import java.util.Map;

public class Bosque {


    public void plantarArboles(){
        System.out.println("Plantando " + Arbol.getContador() + " Arboles");
    }

    public void MemoriaUtilizada(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria Usada: " + (runtime.totalMemory() - runtime.freeMemory())/(1024*1024));
    }

}
