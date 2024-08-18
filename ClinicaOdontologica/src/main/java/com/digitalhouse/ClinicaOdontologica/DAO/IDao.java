package com.digitalhouse.ClinicaOdontologica.DAO;

import java.util.List;

public interface IDao<T> {
    T guardar(T t);
    T buscarPorId(Integer id);
    T buscarPorString(String string);
    void actualizar(T t);
    void eliminar(Integer id);
    List<T> mostrarOdontologos();
}
