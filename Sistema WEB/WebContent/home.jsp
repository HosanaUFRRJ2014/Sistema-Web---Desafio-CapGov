<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>home</title>
<link rel="stylesheet" type="text/css" href=tratamento.css>


</head>
<body style="background-color: #030069;">
<style>
a:link    {color:green; background-color:transparent; text-decoration:none}
a:visited {color:pink; background-color:transparent; text-decoration:none}
a:hover   {color:red; background-color:transparent; text-decoration:underline}
a:active  {color:yellow; background-color:transparent; text-decoration:underline}
</style>
	<div class="titulo" >
		<h1>Sistema WEB</h1>
	</div>

	<div class="botoes">

		<a href="cadastroAluno.jsp">
			<div class="inserirAluno">
				<h4>Cadastrar Aluno</h4>

			</div>
		</a> 
		
		<a href="consultarAlunos.jsp">
			<div class="consultarAlunos">
				<h4>Consultar Alunos</h4>

			</div> 
		</a>
		
		<a href="home.jsp">
				<div class="lancarNotas">
					<h4>Inserir Notas</h4>

				</div>
		
		</a> 
		
		<a href="home.jsp">
				<div class="lancarNotasOpt">
					<h4>Inserir Notas Individualmente</h4>

				</div>
		
		</a>
		
		 <a href="inserirAlunoEnota.jsp">
				<div class="inserirAlunoENota">
					<h4>Inserir Aluno e Nota</h4>

				</div>
		</a>
		
		 <a href="exibirDesempenho.jsp">
					<div class="verDesempenho">
						<h4>Medir Desempenho da Turma</h4>

					</div>
		 </a>
	</div>

</body>
</html>