package logica;

import java.util.Date;

public class Notificacion {
	
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	
	public Notificacion(Date fechaSolicitado, Date fechaDevolucion) {
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
	}

	public Date getFechaSolicitado() {
		return fechaSolicitado;
	}

	public void setFechaSolicitado(Date fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}

	public Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}
	
}
