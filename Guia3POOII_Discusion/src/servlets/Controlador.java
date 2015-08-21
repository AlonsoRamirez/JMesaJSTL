package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javabeans.VentasBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;

import modelo.*;


/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("Hola Mundo");
        try {
        	
        	
        	String op=request.getParameter("operacion");
            if(op.equals("envio")){
              response.sendRedirect("agregar.jsp");
            }
           if(op.equals("grabar")){
        	   VentasBean men=(VentasBean) request.getAttribute("mensa");
               Operaciones oper= new Operaciones();
               oper.guardarVenta(men);
               response.sendRedirect("inicio.html");

            }
            if(op.equals("muestra")){
            
                response.sendRedirect("mostrar.html");
            }
         if(op.equals("ver")){
              Operaciones oper=new Operaciones();
              ArrayList mensajes=oper.obtenerMensajes();
              request.setAttribute("mensajes", mensajes);
              RequestDispatcher rd=request.getRequestDispatcher("/ver.jsp");
              rd.forward(request, response);
           }
         
         if(op.equals("eliminar")){
             VentasBean men=(VentasBean) request.getAttribute("id");
             Operaciones oper= new Operaciones();
             oper.eliminarVenta(request.getParameter("id"));
             response.sendRedirect("inicio.html");
         }

        	
        }
        finally {
            out.close();
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}

}

