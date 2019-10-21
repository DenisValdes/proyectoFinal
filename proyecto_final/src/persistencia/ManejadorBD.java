package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;

import logica.Orientacion;
import logica.TipoUsuario;

public class ManejadorBD {
	
	private Connection con;
	
	public ManejadorBD() {
		
	}
	
	public int generarId() {
		int id = 0;
		
		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			String query = "SELECT MAX(u.id) FROM usuarios u";
			
			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query);
			
			while(x.next()) {
				id = x.getInt(1);
			}
			
		}catch(SQLException i) {
			System.out.println("Error al tomar y generar id " + i);
		}
		
		return id= id + 1;
	}
	
	
	
	//PARSEAR LOS ENUM DESDE BASE DE DATOS A JAVA
	public TipoUsuario parsearTipo(String tipoUsuario) {
		
		TipoUsuario tipo = null;
		
		if( tipoUsuario == "ESTUDIANTE" ){
			tipo = TipoUsuario.ESTUDIANTE;
		}
		
		if( tipoUsuario == "PROFESOR" ){
			tipo = TipoUsuario.PROFESOR;
		}
			
		if( tipoUsuario == "BIBLIOTECARIO" ){
			tipo = TipoUsuario.BIBLIOTECARIO;
		}
			
	
		return tipo;
	}
	
	public Orientacion parsearOrientacion(String orientacion) {
			
			Orientacion orient = null;
			
				
			if( orientacion == "TIC" ){
				orient = Orientacion.TIC;
			}
			
			if( orientacion == "ADM" ){
				orient = Orientacion.ADM;
			}
				
			if( orientacion == "TICYADM" ){
				orient = Orientacion.ADMYTIC;
			}
			
			return orient;
	}
	
	
	//LOGIN
	
	public int Login(String mail, String pass) {
		
		int i = 0;
		
		try {
			Conn connect = new Conn();
			Connection con = connect.conectarMySQL();
			
			String query = "select mail, pass from usuarios where mail='"+mail+"' and pass='"+pass+"'";
			Statement st = con.createStatement();
																
			ResultSet x = st.executeQuery(query);
			
			while(x.next()) {
				i= i + 1;
			}
			
			x.close();
			st.close();
		
		}catch(SQLException e) {
			System.out.println(i);
		}
	
		return i;
	}
	
	
	//USUARIOS
	
	public void altaUsuarioDB(int id, int ci, String nombre, String apellido, String mail, String password, String tipo) {
		
		try {
			
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			PreparedStatement statement = con.prepareStatement("INSERT INTO usuarios(id, ci, nombre, apellido, mail, pass, tipo) VALUES (?,?,?,?,?,?,?);");
			statement.setInt(1, id);
			statement.setInt(2, ci);
			statement.setString(3, nombre);
			statement.setString(4, apellido);
			statement.setString(5, mail);
			statement.setString(6, password);
			statement.setString(7, tipo);
			
			int x = statement.executeUpdate();
			
			if(x > 0) {
				System.out.println("Registro exitoso...");
				
			}else {
				System.out.println("Registro fallido...");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void traeUsuarios() {
		
		try {
			
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			String query = "SELECT * FROM usuarios";
			
			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query);
			
			while(x.next()) {
				int id = x.getInt("id");
				int ci = x.getInt("ci");
				String nombre = x.getString("nombre");
				String apellido = x.getString("apellido");
				String mail = x.getString("mail");
				String password = x.getString("pass");
				
				String tipo = x.getString("tipo");
				
				System.out.println(id + ci + nombre + apellido + mail + password +  tipo);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public DefaultListModel<String> listarUsuarios() {
		DefaultListModel<String> DLM = new DefaultListModel<String>();
		
		try {
			Conn connect = new Conn();
			Connection con = connect.conectarMySQL();
			
			String query = "select * from usuarios";
			Statement st = con.createStatement();
																
			ResultSet x = st.executeQuery(query);
			
			while(x.next()) {
				DLM.addElement(x.getString("mail"));
			}
			
			x.close();
			st.close();
		
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		return DLM;
	}
	
	public String nombreBD(String mail) {
		
		String nombre = null;
		
		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			String query = "SELECT nombre FROM usuarios WHERE mail= '"+ mail +"'";
			
			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query);
			
			while(x.next()) {
				nombre = x.getString("nombre"); 
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return nombre;
	}
}
