package model;

public class Usuario {
    private String rut;
    private String nombre;
    private String clave;
    private String tipoUsuario;

    // Constructor, getters y setters
    public Usuario(String rut, String nombre, String clave, String tipoUsuario) {
        this.rut = rut;
        this.nombre = nombre;
        this.clave = clave;
        this.tipoUsuario = tipoUsuario;
    }

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	} 
}