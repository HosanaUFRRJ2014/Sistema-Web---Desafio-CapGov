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
 * Servlet implementation class CalcularDesempenho
 */
@WebServlet("/CalcularDesempenho")
public class CalcularDesempenho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalcularDesempenho() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String notaMin = request.getParameter("notaMin");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO(); 
		usuario = usuarioDAO.getUsuario();
		
		StringBuffer desempenho = usuario.visualizarDesempenhoTurma(Float.parseFloat(notaMin));
		
		out.println("<html>");
		
		out.println("<body style=\"color: white; background-color: #030069;\">");
		
		out.println("<div style=\"align: center; text-align: center; float: center; padding: 200px 400px 0px 400px;\">");
		out.println("<div style=\"align: center; text-align: center; background-color: #fb5a02; border: 2px solid red; width: 100%;\">");
		out.println("<p style=\"font-family: arial; font-size: 150%; color: white\">");
		
		out.println(desempenho);
		
		out.println("<a href=\"home.jsp\" style=\"text-decoration: none;\"> <button type=\"button\">Voltar ao menu inicial</button> </a>");
		
		out.println("</div> </div> </body> </body> </html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
