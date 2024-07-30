package mesaTrabajo;

import java.util.HashMap;
import java.util.Map;

public class ArbolFactory {
    private Map<String, Arbol> arboles;

    public ArbolFactory() {
        arboles = new HashMap<>();
    }

    public Arbol getArbol(String tipo){
        Arbol arbol = arboles.get(tipo);
        if(arbol == null){
            arbol = new Arbol(tipo);
            arboles.put(tipo,arbol);
            System.out.println("Se creo Un arbol del tipo: " + tipo);
        }
        return arbol;
    }
}
