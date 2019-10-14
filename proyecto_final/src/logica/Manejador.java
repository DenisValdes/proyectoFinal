package logica;

import java.util.ArrayList;

public class Manejador {
	public ArrayList<Usuario>usuarios;
	public ArrayList<Libro>libros;
	public ArrayList<Prestamo>prestamos;

	private static Manejador instance;
	
	private Manejador() {
	
	}
	
	public static Manejador getInstance() {
		if(instance == null) {
			instance = new Manejador();
		}
		
		return instance;
	}
		
//Methods
	

	public void altaUsuario(int CI, String nombre, String apellido, String mail, String password, TipoUsuario tipo, Orientacion orient){

		switch(tipo) {


		
			case ESTUDIANTE:
				Estudiante estudiante = new Estudiante(CI, nombre, apellido, mail, password, orient, tipo);
				this.usuarios.add(estudiante);
				
				break;
			case PROFESOR:
				Profesor profesor = new Profesor(CI, nombre, apellido, mail, password, orient, tipo);
				this.usuarios.add(profesor);
				
				break;
			case BIBLIOTECARIO:
				Bibliotecario bibliotecario = new Bibliotecario(CI, nombre, apellido, mail, password, tipo);
				this.usuarios.add(bibliotecario);
				
				break;

		}
		
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
