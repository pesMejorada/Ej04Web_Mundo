package es.mundo.controladores;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.mundo.modelo.Negocio;

/**
 * Servlet implementation class ProcesarServlet
 */
@WebServlet("/Procesar")
public class ProcesarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcesarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		     int id = Integer.parseInt(request.getParameter("id"));
		     String nombre = request.getParameter("nombre");
		     int habitantes=Integer.parseInt(request.getParameter("habitantes"));
		     Negocio negocio = new Negocio();
		     
    		     //proceso borrar
    		     String mensaje=  negocio.borrar(id);
    		     //meter el mensaje en el request
    		     request.setAttribute("mensaje",mensaje);
    		     // redirigir... a  la vista mensaje
    		     RequestDispatcher rd= request.getRequestDispatcher("vistaMensaje.jsp");
    		     rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
