package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Fachada {
    private static String url = "jdbc:mysql://localhost:3306/museo";
    private static String user = "root";
    private static String password = "8746554201";        
    private static Connection conexion = null;
    private static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection(){
        try {
            if (conexion == null){
            
                Class.forName(driver);
                conexion = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return conexion;
    }
    
    
}
