package logica;

public class Estudiante extends Usuario{
	
	private Orientacion orient;
	private int cantPrestamosEnParalelo = 0;

	public Estudiante(int id, int CI, String nombre, String apellido, String mail, String password, Orientacion orient, TipoUsuario tipoUsuario) {
		super(id, CI, nombre, apellido, mail, password, tipoUsuario);
		this.orient = orient;
	}

	public Orientacion getOrient() {
		return orient;
	}

	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}

	public int getCantPrestamosEnParalelo() {
		return cantPrestamosEnParalelo;
	}

	public void setCantPrestamosEnParalelo(int cantPrestamosEnParalelo) {
		this.cantPrestamosEnParalelo = cantPrestamosEnParalelo;
	}
	
}