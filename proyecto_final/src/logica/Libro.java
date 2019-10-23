package logica;

public class Libro {
	
	private String aniCode;
	private String autor;
	private int fechaPubl;
	private String nroEdicion;
	private String editorial;
	private String descripcion;
	private int cantEjemplares;
	private Boolean hayEjemplarDisponible;
	private Long codigoISBN;
	private String genero;
	private String imagUrl;
	
	public Libro(String aniCode, String autor, int fechaPubl, String nroEdicion, String editorial, String descripcion, int cantEjemplares,Boolean hayEjemplarDisponible, Long codigoISBN, String genero, String imagUrl) {
		this.aniCode = aniCode;
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

	public String getAniCode() {
		return aniCode;
	}

	public void setAniCode(String aniCode) {
		this.aniCode = aniCode;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getFechaPubl() {
		return fechaPubl;
	}

	public void setFechaPubl(int fechaPubl) {
		this.fechaPubl = fechaPubl;
	}

	public String getNroEdicion() {
		return nroEdicion;
	}

	public void setNroEdicion(String nroEdicion) {
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

	public Long getCodigoISBN() {
		return codigoISBN;
	}

	public void setCodigoISBN(Long codigoISBN) {
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
