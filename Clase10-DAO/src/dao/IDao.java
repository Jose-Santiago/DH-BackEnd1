package dao;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorID(Integer id);
    T eliminar(Integer id);
    T actualizar(T t);
    void mostrarDatosTabla();

}
