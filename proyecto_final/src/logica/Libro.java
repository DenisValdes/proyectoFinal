package logica;

import java.util.Date;

public class Libro {
	
	private String codigoAnima;
	private String autor;
	private Date fechaPubl;
	private int nroEdicion;
	private String editorial;
	private String descripcion;
	private int cantEjemplares;
	private Boolean hayEjemplarDisponible;
	private int codigoISBN;
	private String genero;
	private String imagUrl;
	
	public Libro(String codigoAnima, String autor, Date fechaPubl, int nroEdicion, String editorial, String descripcion, int cantEjemplares,Boolean hayEjemplarDisponible, int codigoISBN, String genero, String imagUrl) {
		this.codigoAnima = codigoAnima;
		this.autor = autor;
		this.fechaPubl = fechaPubl;
		this.nroEdicion = nroEdicion;
		this.editorial = editorial;
		this.descripcion = descripcion;
		this.cantEjemplares = cantEjemplares;
		this.hayEjemplarDisponible = hayEjemplarDisponible;
		this.codigoISBN = codigoISBN;
		this.genero = genero;
		this.imagUrl = imagUrl;
	}

	public String getCodigoAnima() {
		return codigoAnima;
	}

	public void setCodigoAnima(String codigoAnima) {
		this.codigoAnima = codigoAnima;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getFechaPubl() {
		return fechaPubl;
	}

	public void setFechaPubl(Date fechaPubl) {
		this.fechaPubl = fechaPubl;
	}

	public int getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(int nroEdicion) {
		this.nroEdicion = nroEdicion;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantEjemplares() {
		return cantEjemplares;
	}

	public void setCantEjemplares(int cantEjemplares) {
		this.cantEjemplares = cantEjemplares;
	}

	public Boolean getHayEjemplarDisponible() {
		return hayEjemplarDisponible;
	}

	public void setHayEjemplarDisponible(Boolean hayEjemplarDisponible) {
		this.hayEjemplarDisponible = hayEjemplarDisponible;
	}

	public int getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(int codigoISBN) {
		this.codigoISBN = codigoISBN;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getImagUrl() {
		return imagUrl;
	}

	public void setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
	}
		
}
