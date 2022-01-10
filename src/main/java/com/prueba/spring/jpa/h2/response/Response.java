/**
 * 
 */
package com.prueba.spring.jpa.h2.response;

/**
 * @author Jose Garrido
 *
 */
public class Response {
	
	private String mensaje;
	

	public Response(String mensaje) {
		super();
		this.mensaje = mensaje;
	}

	@Override
	public String toString() {
		return "Response [mensaje=" + mensaje + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	

}
