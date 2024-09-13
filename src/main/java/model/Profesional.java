package model;

public class Profesional extends Usuario {
    private String especialidad;

    public Profesional(String rut, String nombre, String clave, String tipoUsuario, String especialidad) {
        super(rut, nombre, clave, tipoUsuario);
        this.especialidad = especialidad;
    }

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

    
}