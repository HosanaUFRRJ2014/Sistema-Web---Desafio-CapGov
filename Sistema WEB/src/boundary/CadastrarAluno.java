package boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;
import entity.Usuario;

/**
 * Servlet implementation class CadastrarAluno
 */
@WebServlet("/CadastrarAluno")
public class CadastrarAluno extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CadastrarAluno() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO(); 
		usuario = usuarioDAO.getUsuario();

		String nomeAluno = request.getParameter("nome");

		boolean cadastrado = usuario.inserirAluno(nomeAluno);

		PrintWriter out = response.getWriter();

		response.setContentType("html");
		if(cadastrado == true)
		{
			out.println("Aluno Cadastrado");
			response.sendRedirect("home.jsp");

		}
		
		else
			out.println("Ocorreu um erro!");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
