package com.cibertec.entidad;

public class RespuestaServidor {

	private int codigo;
	private String mensaje;

	public RespuestaServidor() {

	}

	public RespuestaServidor(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
