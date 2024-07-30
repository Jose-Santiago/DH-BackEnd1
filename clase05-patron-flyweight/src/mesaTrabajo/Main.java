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

            Arbol arbolrojo = arboles.getArbol("frutal");
            arbolrojo.setAlto(500);
            arbolrojo.setAncho(300);
            arbolrojo.setColor("rojo");
            System.out.println("Creando el arbol numero: " + (i+1) +" del tipo: " + arbolrojo.getTipo());
        }
        bosque.plantarArboles();
        bosque.MemoriaUtilizada();
    }
}
