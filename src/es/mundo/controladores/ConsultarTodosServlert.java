package es.mundo.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.mundo.modelo.Negocio;
import es.mundo.modelo.Pais;

/**
 * Servlet implementation class ConsultarTodosServlert
 */
@WebServlet("/ConsultarTodos")
public class ConsultarTodosServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarTodosServlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   Negocio negocio= new Negocio();
		  ArrayList<Pais> paises= negocio.consultarTodos();
		  //meter el arraylist en el request....
		  request.setAttribute("listado", paises);
		  RequestDispatcher rd;
		  rd=request.getRequestDispatcher("mostrarTodos.jsp");
		  rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
