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

    public ArrayList<Pais> consultarNombre(String nombre) {
        ArrayList<Pais> paises=paisdao.consultarNombre(nombre);
        return paises;
    }

    public String borrar(int id) {
        String msg;
        // verificar si el pais tiene deudas pendiente
        //mandar un correo al administrador..
        int paisesBorrados= paisdao.borrar(id);
        if(paisesBorrados>=1) {
            msg="Se han borrado" +paisesBorrados +" paises";
        }
        else {
              msg="No se ha podido borrar";
        }
       return msg;
    }


}
