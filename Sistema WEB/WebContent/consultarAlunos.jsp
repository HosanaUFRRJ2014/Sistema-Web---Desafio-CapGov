<%@ page import="java.util.LinkedList"%>
<%@ page import="DAO.*"%>
<%@ page import="entity.*"%>
<html>
<head>
<title>Consultar Alunos</title>
</head>
<body style="color: white; background-color: #030069;">

	<div
		style="align: center; text-align: center; float: center; padding: 200px 400px 0px 400px;">
		<div
			style="align: center; text-align: center; background-color: #fb5a02; border: 2px solid red; width: 100%;">
			<h1 style="font-family: arial; font-size: 250%; color: white">Alunos
				Cadastrados no sistema:</h1>

			<table>
				<% 
				Usuario usuario = new Usuario();
				UsuarioDAO usuarioDAO = new UsuarioDAO(); 
				usuario = usuarioDAO.getUsuario();
				LinkedList<Aluno> alunos = usuario.consultarAlunos();
				
				int aux = 0;
				
				for(Aluno a : alunos)
				{
				      %>
				<tr>
					<td><%=a.getId() %></td>
					<td><%=a.getNome() %></td>
					<% if(a.getNota() == -1)
						{%>
							<td>Não inf.</td>
						<% }
					    else {%>
						<td><%=a.getNota() %></td>
							
						<%} %>
					
				</tr>
				<%
                 }
                 %>
			</table>

			<a href="home.jsp" style="text-decoration: none;">
				<button type="button">Voltar ao menu inicial</button>
			</a>
		</div>
	</div>
</body>
</html>