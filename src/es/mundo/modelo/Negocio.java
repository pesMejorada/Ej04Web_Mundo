package es.mundo.modelo;

import java.util.ArrayList;

import es.mundo.modelo.Pais;
import es.mundo.integracion.PaisDAO;

public class Negocio {
      private PaisDAO paisdao = new PaisDAO();
    
      public int darAlta(String nombre, int habitantes) {
       // validar el pais...
        // mandar un correo al alguna institucion
        Pais pais= new Pais(nombre,habitantes);
        int id =paisdao.darAlta(pais);
      return  id;
    }

    public Pais consultarUno(int id) {
       // validar si el q solicita la consulta tiene autorizacion
        Pais pais =paisdao.consultarUno(id);
      
        return pais;
    }

    public ArrayList<Pais> consultarTodos() {
       //reglas...
        //-....
       ArrayList<Pais> paises=paisdao.consultarTodos();
      return paises;
    }


}
