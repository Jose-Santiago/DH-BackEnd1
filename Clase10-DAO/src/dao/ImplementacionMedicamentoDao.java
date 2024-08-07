package dao;

import modelo.Medicamento;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ImplementacionMedicamentoDao implements IDao<Medicamento>{
    private static Logger logs = Logger.getLogger(ImplementacionMedicamentoDao.class);

    //creamos un objeto para la conexion con H2
    private ConnectionH2 connectionH2;

    public ImplementacionMedicamentoDao(ConnectionH2 connectionH2) {
        this.connectionH2 = connectionH2;
    }

    //consultas SQL
    private static final String INSERTAR_MEDICAMENTO ="INSERT INTO MEDICAMENTOS VALUES(?,?,?,?,?,?)";
    private static final String BUSCAR_POR_ID = "SELECT * FROM MEDICAMENTOS WHERE ID = ?";
    private static final String ELIMINAR_MEDICAMENTO = "DELETE FROM MEDICAMENTOS WHERE ID = ?";
    private static final String ACTUALIZAR_MEDICAMENTO = "UPDATE MEDICAMENTOS SET PRECIO = ?, CANTIDAD = ? WHERE ID = ?";
    private static final String MOSTRAR_TODOS_LOS_DATOS = "SELECT * FROM MEDICAMENTOS";

    @Override
    public Medicamento guardar(Medicamento medicamento) {
        try {
            Connection connection = connectionH2.getConnection();
            PreparedStatement psGuardar = connection.prepareStatement(INSERTAR_MEDICAMENTO);

            psGuardar.setInt(1,medicamento.getId());
            psGuardar.setString(2, medicamento.getNombre());
            psGuardar.setInt(3, medicamento.getCodigoNumerico());
            psGuardar.setString(4, medicamento.getLaboratorio());
            psGuardar.setDouble(5, medicamento.getPrecio());
            psGuardar.setInt(6, medicamento.getCantidad());

            psGuardar.execute();
            logs.info("Medicamento guardado con exito");

        }catch (Exception e){
            logs.error(e.getMessage());
        }

        return medicamento;
    }

    @Override
    public Medicamento buscarPorID(Integer id) {
        Medicamento medicamento = null;
        try {
            Connection connection = connectionH2.getConnection();
            PreparedStatement psBuscarPorID = connection.prepareStatement(BUSCAR_POR_ID);

            psBuscarPorID.setInt(1,id);

            ResultSet resultado = psBuscarPorID.executeQuery();

            while (resultado.next()){
                medicamento = new Medicamento(resultado.getInt("ID"),resultado.getString("NOMBRE"), resultado.getInt("CODIGO_NUMERICO"), resultado.getString("LABORATORIO"), resultado.getDouble("PRECIO"), resultado.getInt("PRECIO") );
                logs.info("El medicamento encontrado por id: " + medicamento.getId() + " es: " + medicamento.getNombre());
            }

        }catch (Exception e){
            logs.error(e.getMessage());
        }

        return medicamento;
    }

    @Override
    public Medicamento eliminar(Integer id) {
        Medicamento medicamentoEliminado = buscarPorID(id);
        try {
            //Connection connection = connectionH2.getConnection();
            //PreparedStatement psBuscarPorID = connection.prepareStatement(BUSCAR_POR_ID);
            //psBuscarPorID.setInt(1,id);
            //ResultSet resultado = psBuscarPorID.executeQuery();

            if (medicamentoEliminado != null){
                Connection connection = connectionH2.getConnection();
                //medicamentoEliminado = new Medicamento(resultado.getInt("ID"),resultado.getString("NOMBRE"), resultado.getInt("CODIGO_NUMERICO"), resultado.getString("LABORATORIO"), resultado.getDouble("PRECIO"), resultado.getInt("PRECIO") );
                logs.info("El medicamento a eliminar por id: " + medicamentoEliminado.getId() + " es: " + medicamentoEliminado.getNombre());

                PreparedStatement psEliminarPorID = connection.prepareStatement(ELIMINAR_MEDICAMENTO);
                psEliminarPorID.setInt(1,id);
                psEliminarPorID.execute();
                logs.info("Medicamento eliminado con exito");
            }else {
                logs.info("Medicamento a eliminar no encontrado");
            }

        }catch (Exception e){
            logs.error(e.getMessage());
        }

        return medicamentoEliminado;
    }

    @Override
    public Medicamento actualizar(Medicamento medicamento) {
        try {
            Connection connection = connectionH2.getConnection();
            PreparedStatement psActualizarMedicamento = connection.prepareStatement(ACTUALIZAR_MEDICAMENTO);

            psActualizarMedicamento.setDouble(1,medicamento.getPrecio());
            psActualizarMedicamento.setInt(2, medicamento.getCantidad());
            psActualizarMedicamento.setInt(3, medicamento.getId());
            psActualizarMedicamento.execute();

            logs.info("Medicamento actualizado con exito");
        }catch (Exception e){
            logs.error(e.getMessage());
        }
        return medicamento;
    }

    @Override
    public void mostrarDatosTabla() {
        try {
            Connection connection = connectionH2.getConnection();
            PreparedStatement psVerDatos = connection.prepareStatement(MOSTRAR_TODOS_LOS_DATOS);

            ResultSet resultado = psVerDatos.executeQuery();

            logs.info("ID --- NOMBRE -------------- PRECIO ---------- CANTIDAD------");

            while (resultado.next()){
                logs.info(resultado.getInt("ID") + " --- " + resultado.getString("NOMBRE") + " ---------- " + resultado.getDouble("PRECIO") + " -------- " + resultado.getInt("CANTIDAD"));
            }

        }catch (Exception e){
            logs.error(e.getMessage());
        }
    }
}
