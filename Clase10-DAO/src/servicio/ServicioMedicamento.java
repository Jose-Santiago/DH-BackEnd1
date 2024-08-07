package servicio;

import dao.IDao;
import modelo.Medicamento;

public class ServicioMedicamento {
    private IDao<Medicamento> medicamentoIDao;

    public ServicioMedicamento(IDao<Medicamento> implementacionMediacamentoDao) {
        this.medicamentoIDao = implementacionMediacamentoDao;
    }

    public Medicamento guardarMedicamento(Medicamento m){
        return medicamentoIDao.guardar(m);
    }

    public Medicamento buscarMedicamentoPorID(Integer id){
        return medicamentoIDao.buscarPorID(id);
    }

    public void mostrarTodosLosMedicamentos(){
        medicamentoIDao.mostrarDatosTabla();
    }

    public Medicamento actualizarMedicamento(Medicamento m){
        return medicamentoIDao.actualizar(m);
    }

    public Medicamento eliminarMedicamento(Integer id){
        return medicamentoIDao.eliminar(id);
    }

}
