/*
 * Jair Velazquez https://github.com/jairvelazquez
 */
package Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 *
 * @author Jair Velazquez
 */

public class Conexion {
	public static Connection conectar() {
		Connection con = null;
		
		String password = "elian2010";//Contrasenia del servidor
		String usuario = "root";
		String url = "jdbc:mysql://localhost:3306/salaurgencias?user=" + usuario
				+ "&password=" + password;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}
        public static void main(String[] args){
            new Conexion();
        }
}