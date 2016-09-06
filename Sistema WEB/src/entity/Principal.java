package entity;

import java.util.LinkedList;

import DAO.AlunoDAO;
import DAO.UsuarioDAO;

public class Principal 
{

	public static void main(String[] args) 
	{
		Usuario u = new Usuario();
		
	/*	u.inserirAluno("Miguel Henrique Assunção");
		u.inserirAluno("James Cole");
	
		u.inserirAlunoENota("James Cole = 9.5");
		u.inserirAlunoENota("Tom Chandler = 9.0");
		u.inserirAlunoENota("Jake Riley = 8.8");
		u.inserirAlunoENota("Miguel Henrique Assunção = 4.0");*/
		
		System.out.println(u.visualizarDesempenhoTurma(6));
		
		

		LinkedList<Aluno> alunos;
		
		alunos = u.consultarAlunos();
	//	int i = 5;
		for(Aluno a : alunos)
		{
			System.out.println(a.getId() + "	" + a.getNome() + "	" + a.getNota());
			

		}
		
		UsuarioDAO uDAO = new UsuarioDAO();
		
		u = uDAO.getUsuario();
		
		System.out.println(u.getSenha());
		
		/*AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno = alunoDAO.buscar("", "James Cole");
		System.out.println(aluno.getId() + "	" + aluno.getNome());
	*/	
		
	//	u.inserirAlunoENota("Lincoln Burrows=10.0");
	}

}
