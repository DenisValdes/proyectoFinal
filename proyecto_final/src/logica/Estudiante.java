package logica;

public class Estudiante extends Usuario{
	
	private Orientacion orient;
	private int prestamos;

	public Estudiante(int id, int CI, String nombre, String apellido, String mail, String password, Orientacion orient, TipoUsuario tipoUsuario, int prestamos) {
		super(id, CI, nombre, apellido, mail, password, tipoUsuario);
		this.orient = orient;
		this.prestamos = prestamos;
	}
	
	public Orientacion getOrient() {
		return orient;
	}

	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}

	public int getprestamos() {
		return prestamos;
	}

	public void setprestamos(int prestamos) {
		this.prestamos = prestamos;
	}
	
}