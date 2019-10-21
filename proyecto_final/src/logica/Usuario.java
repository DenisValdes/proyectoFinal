package logica;

import java.util.ArrayList;

public class Usuario {
	
	private int id;
	private int CI;
	private String nombre;
	private String apellido;
	private String mail;
	private String password;
	private TipoUsuario tipoUsuario;
	
	private ArrayList<Prestamo> prestamos;
	
	public Usuario(int id, int CI, String nombre, String apellido, String mail, String password, TipoUsuario tipoUsuario) {
		this.id = id;
		this.CI = CI;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.password = password;
		this.tipoUsuario = tipoUsuario;
		this.prestamos = new ArrayList<Prestamo>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCI() {
		return CI;
	}

	public void setCI(int CI) {
		this.CI = CI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
	
}