package logica;

import java.util.ArrayList;

public class Manejador {
	public ArrayList<Usuario>usuarios;
	public ArrayList<Libro>libros;
	public ArrayList<Prestamo>prestamos;

	private static Manejador instance = null;
	
	private Manejador() {
		this.usuarios = new ArrayList<Usuario>();
		this.libros = new ArrayList<Libro>();
		this.prestamos = new ArrayList<Prestamo>();
	}
	
	public static Manejador getInstance() {
		if(instance == null) {
			instance = new Manejador();
		}
		
		return instance;
	}
	
		
//Methods

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public void setLibros(ArrayList<Libro> libros) {
		this.libros = libros;
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public void altaUsuario(int id, int CI, String nombre, String apellido, String mail, String password, TipoUsuario tipo, Orientacion orient){
		
		if( tipo == TipoUsuario.ESTUDIANTE ) {
			Estudiante estudiante = new Estudiante(id, CI, nombre, apellido, mail, password, orient, tipo);
			this.usuarios.add(estudiante);
			
		}else if( tipo == TipoUsuario.PROFESOR ) {
			Profesor profesor = new Profesor(id, CI, nombre, apellido, mail, password, orient, tipo);
			this.usuarios.add(profesor);
			
		}else if( tipo == TipoUsuario.BIBLIOTECARIO ) {
			Bibliotecario bibliotecario = new Bibliotecario(id, CI, nombre, apellido, mail, password, tipo);
			this.usuarios.add(bibliotecario);
	
		}
	}
	
	//Parsear Orientacion y TipoUsuario
	public Orientacion parsearOrient(String orientacion) {
		Orientacion orient = null;
		
		switch(orientacion) {
			case "TIC":
				orient = Orientacion.TIC;
				break;
			case "ADM":
				orient = Orientacion.ADM;
				break;
			case "TICYADM":
				orient = Orientacion.ADMYTIC;
				break;
		}
		
		return orient;
	}
	
	public TipoUsuario parsearTipoUsuario(String tipo) {
		TipoUsuario tipoUsuario = null;
		
		if(tipo == "ESTUDIANTE") {
				tipoUsuario = TipoUsuario.ESTUDIANTE;
		}
		if(tipo == "ESTUDIANTE") {
			tipoUsuario = TipoUsuario.PROFESOR;
		}
		if(tipo == "ESTUDIANTE") {
			tipoUsuario = TipoUsuario.BIBLIOTECARIO;
		}
		
		return tipoUsuario;
	}
	
	//Listar, buscar, consultar y modificar usuarios
	public ArrayList<Usuario> listarUsuariosExistentes(){
		return this.usuarios;
		
		//
	}
	
	public Usuario buscarUsuario(int CI) {
		Usuario resultado = null;
		
		for(int i=0; i <= this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getCI() == CI) {
				resultado = this.usuarios.get(i);
				break;
			}
		}
		
		return resultado;
	}
	
	public Usuario consultaUsuario(int id) {
		Usuario consulta = null;
		
		for(int i=0; i <= this.usuarios.size(); i++) {
			if(this.usuarios.get(i).getId() == id) {
				consulta = this.usuarios.get(i);
				break;
			}
		}
		
		return consulta;
	}
	
	public void modificarDatosUsuarios(int CI, String nombre, String apellido, String mail, String password) {
		
	}
	
}
