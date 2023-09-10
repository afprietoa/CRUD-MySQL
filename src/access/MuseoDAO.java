package access;
import java.sql.*;
import java.util.ArrayList;
import model.*;
import servicios.Fachada;

public class MuseoDAO { //DATA ACCESS OBJECT
        
    public int saveMuseo(Museo museo){
        Connection conexion = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        try {
            conexion = Fachada.getConnection();
            String sql = "INSERT INTO museo VALUE (?,?)";
        
            pstm = conexion.prepareStatement(sql);
            pstm.setInt(1, museo.getMu_id());
            pstm.setString(2, museo.getMu_nombre());
            
            resultado = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return resultado;
    }
    
     public int deleteMuseo(int mu_id){
        Connection conexion = null;
        PreparedStatement pstm = null;
        int resultado = 0;
        try {
            conexion = Fachada.getConnection();
            String sql = "DELETE FROM museo WHERE mu_id = ?";
        
            pstm = conexion.prepareStatement(sql);
            pstm.setInt(1, mu_id);
                        
            resultado = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return resultado;
    }
    
     /**
     * 
     * @param c Objeto de la clase museona a grabar
     * @return resultado resultado de la operación modificar
     */
    public int updateMuseo(Museo museo){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int resultado;
        resultado = 0;
        System.out.println(museo.getMu_id()+ " "+ museo.getMu_nombre());
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE museo " +
                        "SET mu_nombre = ? WHERE mu_id = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setInt(2, museo.getMu_id());
            pstm.setString(1,museo.getMu_nombre());            
            resultado = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            System.out.println("Error : " + ex.getMessage());
        }
        return resultado;
    }
    
    public ArrayList<Museo> getListMuseos(int mu_id){ // 0 -> Todos los museos
        Connection conexion = null;
        PreparedStatement pstm = null;
        ResultSet resultado = null;
        ArrayList<Museo> listadoMuseos = new ArrayList<>();
        try {
            conexion = Fachada.getConnection();
            String sql = "";
            if(mu_id == 0){
                sql = "SELECT * FROM museo ORDER BY mu_id";
            }else {
                sql = "SELECT * FROM museo WHERE mu_id = ? ORDER BY mu_id";
            }
            
            pstm = conexion.prepareStatement(sql);
             
            if ( mu_id != 0){
                pstm.setInt(1, mu_id);
            }
                                    
            resultado = pstm.executeQuery();
            
            Museo museo = null;
            while (resultado.next()){
                museo = new Museo();
                
                museo.setMu_id(resultado.getInt("mu_id"));
                museo.setMu_nombre(resultado.getString("mu_nombre"));
                listadoMuseos.add(museo);
            }
                        
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        
        return listadoMuseos;
    }
}
