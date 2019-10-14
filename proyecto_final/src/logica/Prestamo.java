package logica;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {
	
	private int id;
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	private Boolean devuelto;
	private ArrayList<Notificacion> cantNotificaciones;
	private ArrayList<Libro> libro;
	
	public Prestamo(int id, Date fechaSolicitado, Date fechaDevolucion, Boolean devuelto) {
		this.id = id;
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
		this.devuelto = devuelto;
		libro = new ArrayList<>();
		cantNotificaciones = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Boolean getDevuelto() {
		return devuelto;
	}

	public void setDevuelto(Boolean devuelto) {
		this.devuelto = devuelto;
	}

	public ArrayList<Notificacion> getNotificaciones() {
		return cantNotificaciones;
	}

	public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
		this.cantNotificaciones = notificaciones;
	}

	public ArrayList<Libro> getLibro() {
		return libro;
	}

	public void setLibro(ArrayList<Libro> libro) {
		this.libro = libro;
	}
	
}
