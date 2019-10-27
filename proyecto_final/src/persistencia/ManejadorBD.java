package persistencia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

			while (x.next()) {
				id = x.getInt(1);
			}

		} catch (SQLException i) {
			System.out.println("Error al tomar y generar id " + i);
		}

		return id = id + 1;
	}

	public int generarIdPrestamo() {
		int id = 0;

		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			String query = "SELECT MAX(p.id) FROM prestamos p";

			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query);

			while (x.next()) {
				id = x.getInt(1);
			}

		} catch (SQLException i) {
			System.out.println("Error al tomar y generar id " + i);
		}

		return id = id + 1;
	}
	
	public String traerPass(String mail) {
		String pass = "";

		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			String query = "SELECT pass FROM usuarios WHERE mail='" + mail + "'";

			Statement st = con.createStatement();
			ResultSet x = st.executeQuery(query);

			while (x.next()) {
				pass = x.getString("pass");
			}

		} catch (SQLException i) {
			System.out.println("Error al tomar y generar id " + i);
		}

		return pass;
	}

	// PARSEAR LOS ENUM DESDE BASE DE DATOS A JAVA
	public TipoUsuario parsearTipo(String tipoUsuario) {

		TipoUsuario tipo = null;

		if (tipoUsuario == "ESTUDIANTE") {
			tipo = TipoUsuario.ESTUDIANTE;
		}

		if (tipoUsuario == "PROFESOR") {
			tipo = TipoUsuario.PROFESOR;
		}

		if (tipoUsuario == "BIBLIOTECARIO") {
			tipo = TipoUsuario.BIBLIOTECARIO;
		}

		return tipo;
	}

	public Orientacion parsearOrientacion(String orientacion) {

		Orientacion orient = null;

		if (orientacion == "TIC") {
			orient = Orientacion.TIC;
		}

		if (orientacion == "ADM") {
			orient = Orientacion.ADM;
		}

		if (orientacion == "TICYADM") {
			orient = Orientacion.ADMYTIC;
		}

		return orient;
	}

	// LOGIN

	public int Login(String mail, String pass) {

		int i = 0;

		try {
			Conn connect = new Conn();
			Connection con = connect.conectarMySQL();

			String query = "select mail, pass from usuarios where mail='" + mail + "' and pass='" + pass + "'";
			Statement st = con.createStatement();

			ResultSet x = st.executeQuery(query);

			while (x.next()) {
				i = i + 1;
			}

			x.close();
			st.close();

		} catch (SQLException e) {
			System.out.println(i);
		}

		return i;
	}

	// USUARIOS
	public void altaUsuarioDB(int id, int ci, String nombre, String apellido, String mail, String password, String tipo,
			String orient) {

		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			Statement statement;

			statement = con.createStatement();
			statement.executeUpdate("INSERT INTO usuarios(id,ci,nombre,apellido,mail,pass,tipo) VALUES (" + id + ","
					+ ci + ",'" + nombre + "','" + apellido + "','" + mail + "','" + password + "','" + tipo + "')");

			switch (tipo) {
			case "Estudiante":
				statement.executeUpdate("INSERT INTO estudiantes(id,orientacion,prestamos_activos) VALUES (" + id + ",'"+ orient + "'," + 2 + ");");
				break;

			case "Profesor":
				statement.executeUpdate("INSERT INTO profesores(id,orientacion) VALUES (" + id + ",'" + orient + "')");
				break;

			case "Bibliotecario":
				statement.executeUpdate("INSERT INTO bibliotecarios(id) VALUES (" + id + ");");
				break;
			}

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void modificarDatos(int id, int ci, String nombre, String apellido, String mail, String pass) {
		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			PreparedStatement ps = con
					.prepareStatement("UPDATE usuarios SET ci=?, nombre=?, apellido=?, mail=?, pass=? WHERE id=?");
			ps.setInt(1, ci);
			ps.setString(2, nombre);
			ps.setString(3, apellido);
			ps.setString(4, mail);
			ps.setString(5, pass);
			ps.setInt(6, id);

			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Prestamos
	public void altaPrestamoDB(int id, Boolean devuelto, Date fecha_solicitud, Date fecha_devolucion, int id_usuario, int codigo_libro) {

		try {
			Conn connect = new Conn();
			con = connect.conectarMySQL();
			Statement statement;

			statement = con.createStatement();
			statement.executeUpdate("INSERT INTO usuarios(id, devuelto, fecha_solicitud, fecha_devolucion, id_usuario, codigo_libro) VALUES ("+id+", "+devuelto+", "+fecha_solicitud+", "+fecha_devolucion+", "+id_usuario+", "+codigo_libro+")");

			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
