package boundary;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import DAO.*;
import entity.*;

/**
 * Servlet implementation class Servidor
 */
@WebServlet("/Servidor")
public class Servidor extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servidor()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	/*protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//	response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	 */
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String senha = request.getParameter("senha");


		//verificar se  a senha digitada é a mesma que a cadastrada.
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO(); 
		usuario = usuarioDAO.getUsuario();

	  if(usuario.getSenha().equals(senha)/* senha.equals("1234")*/)
        	response.sendRedirect("home.jsp");

        else
        {
        	//response.sendRedirect("login.jsp");
	  		out.println("Senha Incorreta");
        }

	/*	out.println("<html>");
		out.println("<body>");
		if(senha.equals("1234"))
		{
			out.println("<h1>Login realizado com sucesso</h1>");
			
		}

        else
		 	out.println("<h1>Senha Incorreta!</h1>");
		
		out.println("</body>");
		out.println("</html>");*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		service(request,response);
		//doGet(request, response);
	}

}
