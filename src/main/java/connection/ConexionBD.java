package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
	private static ConexionBD instancia;
	private Connection conexion;
	private static final String URL = "jdbc:mysql://localhost:3306/prevencion_riesgos";
	private static final String USUARIO = "root";
	private static final String CLAVE = "123456";

	private ConexionBD() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);

			// Verificar si la conexión fue exitosa
			if (this.conexion != null) {
				System.out.println("Conexión exitosa a la base de datos.");
			} else {
				System.out.println("No se pudo establecer la conexión.");
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static synchronized ConexionBD getInstancia() {
		if (instancia == null) {
			instancia = new ConexionBD();
		}
		return instancia;
	}

	public Connection getConexion() {
		return conexion;
	}
}