package logica;

public class Libro {

	private String aniCode;
	private String autor;
	private String titulo;
	private String genero;
	private int fechaPubl;
	private String editorial;
	private String nroEdicion;
	private String descripcion;
	private Long codigoISBN;
	private int cantEjemplares;
	private Boolean hayEjemplarDisponible;
	private String imagUrl;
	
	public Libro(String aniCode, String autor, String titulo, String genero, int fechaPubl, String editorial,
			String nroEdicion, String descripcion, Long codigoISBN, int cantEjemplares, Boolean hayEjemplarDisponible,
			String imagUrl) {
		
		this.aniCode = aniCode;
		this.autor = autor;
		this.titulo = titulo;
		this.genero = genero;
		this.fechaPubl = fechaPubl;
		this.editorial = editorial;
		this.nroEdicion = nroEdicion;
		this.descripcion = descripcion;
		this.codigoISBN = codigoISBN;
		this.cantEjemplares = cantEjemplares;
		this.hayEjemplarDisponible = hayEjemplarDisponible;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getFechaPubl() {
		return fechaPubl;
	}
	public void setFechaPubl(int fechaPubl) {
		this.fechaPubl = fechaPubl;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getNroEdicion() {
		return nroEdicion;
	}
	public void setNroEdicion(String nroEdicion) {
		this.nroEdicion = nroEdicion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getCodigoISBN() {
		return codigoISBN;
	}
	public void setCodigoISBN(Long codigoISBN) {
		this.codigoISBN = codigoISBN;
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
	public String getImagUrl() {
		return imagUrl;
	}
	public void setImagUrl(String imagUrl) {
		this.imagUrl = imagUrl;
	}
	
}