<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inserir aluno e nota</title>
</head>
<body style="color: white; background-color: #030069;">

	<div
		style="align: center; text-align: center; float: center; padding: 200px 400px 0px 400px;">
		<div
			style="align: center; text-align: center; background-color: #fb5a02; border: 2px solid red; width: 100%;">
			<h1 style="font-family: arial; font-size: 250%; color: white">Acesso ao Sistema WEB</h1>
			<form action= InserirAlunoEnota method=get>
				<p>Insira o nome do aluno e sua nota separados por "=".</p> 
				<p style="font-size:75%;"> Exemplo: maria = 10</p>
				<input type="text" name="alunoEnota" /> <input type="submit"
					value="Inserir" />
			</form>
		</div>
	</div>
</body>
</html>

