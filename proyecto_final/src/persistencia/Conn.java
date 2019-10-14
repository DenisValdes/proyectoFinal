package persistencia;
import java.sql.*;

public class Conn {
	// Library of MySQL
    public String driver = "com.mysql.jdbc.Driver";

    // Data base's name
    public String database = "biblanima";

    // Host
    public String hostname = "localhost";

    // Port
    public String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;

    // Nombre de usuario
    public String username = "root";

    // Clave de usuario
    public String password = "";

    public Connection conectarMySQL() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

}
