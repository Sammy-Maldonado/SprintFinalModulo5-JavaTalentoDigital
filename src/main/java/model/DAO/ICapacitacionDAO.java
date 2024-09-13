package model.DAO;

import java.util.List;

import model.Capacitacion;

public interface ICapacitacionDAO {
    List<Capacitacion> listarCapacitaciones();
    void crearCapacitacion(Capacitacion capacitacion);
}