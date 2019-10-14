package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ManejadorBD {
	
	public ManejadorBD() {
		
	}
	
	public void altaUsuarioDB(int ci, String nombre, String apellido, String mail, String password, String tipo) {
		
		try {
			
			Conn connect = new Conn();
			Connection con = connect.conectarMySQL();
			PreparedStatement statement = con.prepareStatement("INSERT INTO usuarios(ci, nombre, apellido, mail, pass, tipo) VALUES (?,?,?,?,?,?);");
			statement.setInt(1, ci);
			statement.setString(2, nombre);
			statement.setString(3, apellido);
			statement.setString(4, mail);
			statement.setString(5, password);
			statement.setString(6, tipo);
			
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
}
