package presencial;

public class Cliente {
    public static void main(String[] args) {
        App listado= new App();

        listado.calcularPromedio();

        for (int i=0; i<6;i++){
            listado.agregarEnterosAlaLista(i);
        }

        listado.calcularPromedio();

        for (int i=6; i<12;i++){
            listado.agregarEnterosAlaLista(i);
        }

    }
}
