package logica;

import java.util.ArrayList;
import java.util.Date;

public class Prestamo {

	private int id;
	private Date fechaSolicitado;
	private Date fechaDevolucion;
	private Boolean devuelto;
	private ArrayList<Notificacion> Notificaciones;
	private ArrayList<Libro> libros;
	private Libro libro;
	private int id_user;
	private Notificacion notificacion;

	public Prestamo(int id, Date fechaSolicitado, Date fechaDevolucion, Boolean devuelto, Libro libro, int id_user) {
		this.id = id;
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
		this.devuelto = devuelto;
		this.libros = new ArrayList<>();
		this.Notificaciones = new ArrayList<>();
		this.libro = libro;
		this.id_user = id_user;
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
		return Notificaciones;
	}

	public void setNotificaciones(ArrayList<Notificacion> notificaciones) {
		try {
			if(0 < notificaciones.size() && notificaciones.size() < 3) {
				Notificaciones = notificaciones;
			}
		}catch(Exception e) {
			
		}
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Notificacion getNotificacion() {
		return notificacion;
	}

	public void setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
	}


}