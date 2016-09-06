package boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AlunoDAO;
import DAO.UsuarioDAO;
import entity.Aluno;
import entity.Usuario;

/**
 * Servlet implementation class LancarNota
 */
@WebServlet("/LancarNota")
public class LancarNota extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LancarNota() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO(); 
		usuario = usuarioDAO.getUsuario();
		
		String id = request.getParameter("id");
		
		AlunoDAO aDAO = new AlunoDAO();
		Aluno aluno = aDAO.buscar(id).get(0);
		
		   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
