import dao.ConnectionH2;
import dao.ImplementacionMedicamentoDao;
import modelo.Medicamento;
import servicio.ServicioMedicamento;

public class Main {
    public static void main(String[] args) {
        ConnectionH2 connectionH2 = new ConnectionH2();
        connectionH2.crearTabla();

        ImplementacionMedicamentoDao implementacionMedicamentoDao = new ImplementacionMedicamentoDao(connectionH2);

        ServicioMedicamento servicioMedicamento = new ServicioMedicamento(implementacionMedicamentoDao);

        Medicamento medicamento= new Medicamento(1,"ibuprofeno",11111,"bayer",10.0,100);
        servicioMedicamento.guardarMedicamento(medicamento);
        servicioMedicamento.mostrarTodosLosMedicamentos();
        Medicamento medicamentoBuscado = servicioMedicamento.buscarMedicamentoPorID(1);

        medicamento.setCantidad(20);
        medicamento.setPrecio(18.0);
        servicioMedicamento.actualizarMedicamento(medicamento);
        servicioMedicamento.mostrarTodosLosMedicamentos();

        servicioMedicamento.eliminarMedicamento(1);
    }
}
