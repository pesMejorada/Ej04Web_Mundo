package es.mundo.integracion;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.mundo.modelo.Pais;

public class PaisDAO {
     private Connection cx;
   
     private void conectar() {
       try {
            Class.forName("com.mysql.jdbc.Driver");
            cx= DriverManager.getConnection("jdbc:mysql://localhost:3306/MUNDO","root","root");
            cx.setAutoCommit(false);
        } catch (SQLException e) {
           
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
     private void desconectar() {
         try {
            cx.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
         
     }
       public int darAlta(Pais pais) {
               try {
                
                //1. conectar
                conectar();
              //2.Preparar la sql (query)
                PreparedStatement ps = 
                            cx.prepareStatement("INSERT INTO PAIS VALUES(?,?,?)");
                
                     // 2.1 setear los interrogantes...
                ps.setInt(1, 0);
                ps.setString(2, pais.getNombre());
                ps.setInt(3,pais.getHabitantes());
                
                //3. Ejecutar la consulta
                 int filasAfectadas =ps.executeUpdate();
       
                 //4.  hacer el commit....
                 cx.commit();
                //.5.cerrar la conexión
                 desconectar();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         return 0;//OJO--->>>>>
    }
    public Pais consultarUno(int id) {
        Pais p = new Pais();
           try {
          //1. conectar
            conectar();
          //2. preparar la consulta
            PreparedStatement ps;
            ps = cx.prepareStatement("select * from pais where id=?");
           // 2.1 setear los ?
                ps.setInt(1, id);
           // 3, ejecutar la consulta
             ResultSet rs =ps.executeQuery();  
           //4. llenar el objeto pais.. con los datos de respuesta de BBDD..
                //Nota: La respuesta viene en un objeto ResultSet
             if(rs.next()) {
                 p.setId(rs.getInt("id"));
                 p.setNombre(rs.getString("nombre"));
                 p.setHabitantes(rs.getInt("habitantes"));
             }
           //5.desconectar
             desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
      return p;
    }
    public ArrayList<Pais> consultarTodos() {
        ArrayList<Pais> paises= new ArrayList<Pais>();
       
        try {
            //1. conectar
            conectar();
            //2. preparar la sentencia
            PreparedStatement ps = cx.prepareStatement("SELECT * FROM PAIS");
            //3. ejecutar la consulta
            ResultSet consulta = ps.executeQuery();
            //4. bajar el resultado de la consulta y ponerlo en el arrayList
            while(consulta.next()) {
                Pais p = new Pais();
                p.setId(consulta.getInt("id"));
                p.setNombre(consulta.getString("nombre"));
                p.setHabitantes(consulta.getInt("habitantes"));
                paises.add(p);
            }
            //5. desconectar
            desconectar();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return paises;
    }

}
