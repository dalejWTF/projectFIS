package DATVentas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author SMART
 */
public class connectionSQL {

    private final String base = "proyecto";
    private final String usuari = "root";
    private final String clave = "";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.usuari, this.clave);
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

