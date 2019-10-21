package logica;

public class Profesor extends Usuario{

	private Orientacion orient;
	
	public Profesor(int id, int CI, String nombre, String apellido, String mail, String password, Orientacion orient, TipoUsuario tipoUsuario) {
		super(id, CI, nombre, apellido, mail, password, tipoUsuario);
		this.orient = orient;
	}

	public Orientacion getOrient() {
		return orient;
	}

	public void setOrient(Orientacion orient) {
		this.orient = orient;
	}
	
}