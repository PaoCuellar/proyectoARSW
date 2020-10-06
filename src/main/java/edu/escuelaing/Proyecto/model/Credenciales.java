package edu.escuelaing.Proyecto.model;

public class Credenciales {
	private String usuario;
	private String passwd;
	
	public Credenciales () {
		
	}
	
	public Credenciales(String usuario, String passwd) {
		super();
		this.usuario = usuario;
		this.passwd = passwd;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
}
