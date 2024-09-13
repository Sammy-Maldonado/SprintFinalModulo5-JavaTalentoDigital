package model;

public class Cliente extends Usuario {
    private String empresa;

    public Cliente(String rut, String nombre, String clave, String tipoUsuario, String empresa) {
        super(rut, nombre, clave, tipoUsuario);
        this.empresa = empresa;
    }

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

    
}