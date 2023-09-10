package museocrud20;

import access.MuseoDAO;
import controller.MuseoController;
import java.util.ArrayList;
import model.*;

public class MuseoCRUD20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                
        /* Connection con = Fachada.getConnection();
        System.out.println("Conexion exitosa");*/
        
        //MuseoDAO museoDao = new MuseoDAO();
        
        /*Museo nuevoMuseo = new Museo(3039,"Museo de Arte moderno");
        museoDao.saveMuseo(nuevoMuseo);*/
        
        /*ArrayList<Museo> list = museoDao.getListMuseos(0);
        
        if (list.isEmpty()){
            System.out.println("No hay museos para visualizar");
        }else{
            System.out.println("LIstado de Museos".toUpperCase());
            System.out.println("CÓDIGO\tNOMBRES");
            for (Museo museo : list) {
                System.out.println(museo.getMu_id() + "\t" 
                        + museo.getMu_nombre());
            }
        }*/
        
        
        MuseoController mc = new MuseoController();        
        mc.gestionMuseo();
    }   
}
