package logica;

import java.util.ArrayList;

public class Prestamo {

	private int id;
	private String fechaSolicitado;
	private String fechaDevolucion;
	private Boolean devuelto;
	private ArrayList<Notificacion> Notificaciones;
	private String aniCode;
	private int id_user;
	private Notificacion notificacion;

	public Prestamo(int id, String fechaSolicitado, String fechaDevolucion, Boolean devuelto, String aniCode, int id_user) {
		this.id = id;
		this.fechaSolicitado = fechaSolicitado;
		this.fechaDevolucion = fechaDevolucion;
		this.devuelto = devuelto;
		this.Notificaciones = new ArrayList<>();
		this.aniCode = aniCode;
		this.id_user = id_user;
	}

	public String getAniCode() {
		return aniCode;
	}

	public void setAniCode(String aniCode) {
		this.aniCode = aniCode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFechaSolicitado() {
		return fechaSolicitado;
	}

	public void setFechaSolicitado(String fechaSolicitado) {
		this.fechaSolicitado = fechaSolicitado;
	}

	public String getFechaDevolucion() {
		return fechaDevolucion;
	}

	public void setFechaDevolucion(String fechaDevolucion) {
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