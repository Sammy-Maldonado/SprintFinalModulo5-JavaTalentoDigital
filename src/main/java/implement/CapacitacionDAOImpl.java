package implement;

import model.Capacitacion;
import model.DAO.ICapacitacionDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import connection.ConexionBD;

public class CapacitacionDAOImpl implements ICapacitacionDAO {
    private Connection conexion;

    public CapacitacionDAOImpl() {
        this.conexion = ConexionBD.getInstancia().getConexion();
    }

    @Override
    public List<Capacitacion> listarCapacitaciones() {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        String sql = "SELECT id, nombre, detalle FROM capacitaciones";

        try (Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Capacitacion cap = new Capacitacion();
                cap.setId(rs.getInt("id"));
                cap.setNombre(rs.getString("nombre"));
                cap.setDetalle(rs.getString("detalle"));
                capacitaciones.add(cap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return capacitaciones;
    }

    @Override
    public void crearCapacitacion(Capacitacion capacitacion) {
        String sql = "INSERT INTO Capacitaciones (nombre, detalle) VALUES (?, ?)";

        try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
            pstmt.setString(1, capacitacion.getNombre());
            pstmt.setString(2, capacitacion.getDetalle());
            pstmt.executeUpdate();
            System.out.println("Capacitación creada: " + capacitacion);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}