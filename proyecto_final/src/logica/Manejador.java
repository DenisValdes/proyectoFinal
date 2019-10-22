package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import persistencia.Conn;

public class Manejador {
	public ArrayList<Usuario>usuarios=new ArrayList<>();
	public ArrayList<Libro>libros=new ArrayList<>();;
	public ArrayList<Prestamo>prestamos=new ArrayList<>();;

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

	
	public void altaUsuario(){
		
		this.usuarios.clear();
			
		try {
			Conn connect = new Conn();
			Connection con = connect.conectarMySQL();
			
			String query1 = "SELECT * FROM estudiantes e INNER JOIN usuarios u ON e.id = u.id";
			String query2 = "SELECT * FROM profesores p INNER JOIN usuarios u ON p.id = u.id";
			String query3 = "SELECT * FROM bibliotecarios b INNER JOIN usuarios u ON b.id = u.id";
			
			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query1);
			
			while(x.next()) {
				
				int id = x.getInt("id");
				int ci = x.getInt("ci");
				String nombre = x.getString("nombre");
				String apellido = x.getString("apellido");
				String mail = x.getString("mail");
				String pass = x.getString("pass");
				TipoUsuario  tipo = parsearTipoUsuario(x.getString("tipo"));
				
				if(x.getString("orientacion").equals("TIC") ) {
					
					Estudiante estudiante = new Estudiante(id, ci, nombre, apellido, mail, pass, Orientacion.TIC, tipo);
					this.usuarios.add(estudiante);
				}
				
				if(x.getString("orientacion").equals("ADM") ) {
					
					Estudiante estudiante = new Estudiante(id, ci, nombre, apellido, mail, pass, Orientacion.ADM, tipo);
					this.usuarios.add(estudiante);
				}
			
			}
			
			ResultSet y = st.executeQuery(query2);
			
			while(y.next()) {
					
				int id = y.getInt("id");
				int ci = y.getInt("ci");
				String nombre = y.getString("nombre");
				String apellido = y.getString("apellido");
				String mail = y.getString("mail");
				String pass = y.getString("pass");
				TipoUsuario  tipo = parsearTipoUsuario(y.getString("tipo"));
				
				if(y.getString("orientacion").equals("TIC") ) {
					
					Profesor profesor = new Profesor(id, ci, nombre, apellido, mail, pass, Orientacion.TIC, tipo);
					this.usuarios.add(profesor);
				}
				if(y.getString("orientacion").equals("ADM") ) {
					
					Profesor profesor = new Profesor(id, ci, nombre, apellido, mail, pass, Orientacion.ADM, tipo);
					this.usuarios.add(profesor);
				}
				if(y.getString("orientacion").equals("TICYADM") ) {
	
					Profesor profesor = new Profesor(id, ci, nombre, apellido, mail, pass, Orientacion.ADMYTIC, tipo);
					this.usuarios.add(profesor);
				}
			}
			
			ResultSet z = st.executeQuery(query3);
			
			while(z.next()) {
										
					int id = z.getInt("id");
					int ci = z.getInt("ci");
					String nombre = z.getString("nombre");
					String apellido = z.getString("apellido");
					String mail = z.getString("mail");
					String pass = z.getString("pass");
					TipoUsuario  tipo = parsearTipoUsuario(z.getString("tipo"));
					
					Bibliotecario bibliotecario = new Bibliotecario(id, ci, nombre, apellido, mail, pass, tipo);
					this.usuarios.add(bibliotecario);
			}
			
			x.close();
			st.close();
			
			System.out.println(getUsuarios());
		
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	//Parsear TipoUsuario
		
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
	public DefaultListModel<String> listarUsuariosExistentes(){
		
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		
		String mail = "";
		
		for(int i=0; i <= this.usuarios.size(); i++) {
			mail = this.usuarios.get(i).getMail();
			DLM.addElement(mail);
		}
		
		return DLM;
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
