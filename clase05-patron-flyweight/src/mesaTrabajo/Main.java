package mesaTrabajo;

public class Main {
    public static void main(String[] args) {
        Bosque bosque = new Bosque();
        ArbolFactory arboles = new ArbolFactory();
        for (int i = 0; i < 50; i++) {
            Arbol arbol = arboles.getArbol("ornamental");
            arbol.setAlto(200);
            arbol.setAncho(400);
            arbol.setColor("verde");
            System.out.println("Creando el arbol numero: " + (i+1) +" del tipo: " + arbol.getTipo());
        }
        for (int i = 0; i < 50; i++) {
            Arbol arbol = arboles.getArbol("frutal");
            arbol.setAlto(500);
            arbol.setAncho(300);
            arbol.setColor("rojo");
            System.out.println("Creando el arbol numero: " + (i+1) +" del tipo: " + arbol.getTipo());
        }

        bosque.plantarArboles();
        bosque.MemoriaUtilizada();
    }
}
