package controller;

import access.MuseoDAO;
import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class MuseoController {
    Scanner sc = new Scanner(System.in);
    
    public void gestionMuseo(){
        int opcion;
        do{
            System.out.println("Gestion de Museos".toUpperCase());
            System.out.println("1. Agregar Museo");
            System.out.println("2. Consultar Museo");
            System.out.println("3. Actualizar Museo");
            System.out.println("4. Eliminar Museo");
            System.out.println("5. Listar Museos");
            System.out.println("6. Salir");
            System.out.print("Opción ? : ");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                case 1: addMuseo(); break;
                case 2: getMuseo(); break;
                case 3: updateMuseo(); break;
                case 4: deleteMuseo(); break;
                case 5: listMuseo(); break;
            }
            
        }while( opcion != 6);
    }
    
    private void addMuseo(){
        //TODO add museo
        /*
        1. Solicitar el id
        2. Solicitare el nombre del museo
        3. Crear un objeto museo con los datos capturados
        5. Invocar el método saveMuseo de MuseoDAO
        6. Si lo retornado es 1 informar que el museo fu grabado sino }
            mostrar mensaje dwe error
        */
        
        int id;
        do{
            System.out.println("ADD Museo".toUpperCase());
            System.out.print("Código [Ingrese 0 para terminar] : ");
            id = sc.nextInt();
            sc.nextLine();
            
            if (id != 0){
                MuseoDAO museoDao = new MuseoDAO();
                
                ArrayList<Museo> museoBuscado = museoDao.getListMuseos(id);
                
                if(museoBuscado.isEmpty()){
                    System.out.print("Nombre : ");
                    String nombre = sc.nextLine();
                    
                    Museo nuevoMuseo = new Museo(id, nombre);
                    
                    if(museoDao.saveMuseo(nuevoMuseo) == 1 ){
                        System.out.println("Museo grabado con éxito");
                    }else{
                        System.out.println("Error al grabar museo");
                    }                    
                }else{
                    System.out.println("El código del museo ya existe");
                }
                System.out.println("Presione una tecla para continuar");
                sc.nextLine();
                
            }            
            
        }while (id != 0);
         
    }
    
    private void getMuseo(){
        Museo museo = new Museo();
        MuseoDAO museoDao = new MuseoDAO();
        System.out.print("Código : ");
        int id = sc.nextInt();
        sc.nextLine();           
        ArrayList<Museo> museoBuscado = museoDao.getListMuseos(id);
        museo = museoBuscado.get(0);
        
        System.out.println(museo.getMu_id() + "\t" 
                        + museo.getMu_nombre());
    }
    
    private void updateMuseo(){
            Museo museo = new Museo();
             MuseoDAO museoDao = new MuseoDAO();
            //Se configura los datos en el objeto museo de la clase
            //Museo
            System.out.print("Código : ");
            int codigo = sc.nextInt();
            museo.setMu_id(codigo);
            sc.nextLine();
 
            System.out.print("Nombre : ");
            String nombre = sc.nextLine();
            museo.setMu_nombre(nombre);                                          
    
                         
            if(museoDao.updateMuseo(museo) == 1){
                System.out.println("Actualización exitosa");
            }else{
                System.out.println("Error al actualizar museo");
            } 
            
    }
    
    private void deleteMuseo(){
            MuseoDAO museoDao = new MuseoDAO();
            System.out.print("Código : ");
            int codigo = sc.nextInt();
            sc.nextLine();
            
            if(museoDao.deleteMuseo(codigo) ==  1){
                System.out.println("Eliminación exitosa");                
            }else{
                System.out.println("Error al eliminar museo");                
            }
    }
    
    private void listMuseo(){
        //TODO add museo
        
        MuseoDAO museoDao = new MuseoDAO();
        ArrayList<Museo> list = museoDao.getListMuseos(0);
        
        if (list.isEmpty()){
            System.out.println("No hay museos para visualizar");
        }else{
            System.out.println("LIstado de Museos".toUpperCase());
            System.out.println("CÓDIGO\tNOMBRES");
            for (Museo museo : list) {
                System.out.println(museo.getMu_id() + "\t" 
                        + museo.getMu_nombre());
            }
        }
        System.out.println("Presione una tecla para contrinuar");
        sc.nextLine();
    }
}
