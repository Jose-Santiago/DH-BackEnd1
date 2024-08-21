package com.digitalhouse.ClinicaOdontologica.Repository;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorId(Integer id);
    void actualizar(T t);
    void eliminar(Integer id);
    List<T> mostrarTodos();
}
