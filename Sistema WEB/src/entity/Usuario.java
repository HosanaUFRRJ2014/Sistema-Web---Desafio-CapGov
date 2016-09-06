package entity;

import java.util.LinkedList;

import DAO.*;

public class Usuario 
{
	private String senha;  //descobrir se não vai ser muito trabalhoso criptografar


	public boolean inserirAluno(String nome)
	{
		boolean sucesso;
		Aluno novo = new Aluno(nome);
		AlunoDAO alunoDAO = new AlunoDAO();
		
		LinkedList<Aluno> alunos = alunoDAO.getListaAlunos();
		
		for(Aluno a : alunos)
		{
			String aux1 = novo.getNome().trim();
			String aux2 = a.getNome().trim();
			
			if(aux1.compareToIgnoreCase(aux2) == 0) //se o aluno já está cadastrado
				return sucesso = false; //o aluno já está cadastrado no banco. Retornar erro;
		}

		//inserir no PostgreSQL..
		sucesso = alunoDAO.inserir(novo);
		
		return sucesso = true;

	}

	public LinkedList<Aluno> consultarAlunos()
	{
		AlunoDAO alunoDAO = new AlunoDAO();
		LinkedList<Aluno> alunos;	

		//realizar consulta no Banco de dados...
		alunos = alunoDAO.getListaAlunos();

		//realizar os opcionais 1 e 2 fora da função. Botões "Exibir :  Em ordem alfabética ou Em ordem de chamada"
		//...

		return alunos;

	}

	//lançar nota de todos os alunos
	/*Antes desse método, realizar consulta
	 * lancar nota - UC04 ficará dentro de um loop*/
	//serve para ambos os lancar nota (04 e 05)
	public void lancarNota(Aluno aluno)
	{
		AlunoDAO alunoDAO = new AlunoDAO();

		alunoDAO.alterar(aluno);

	}

	public StringBuffer visualizarDesempenhoTurma(float notaMinimaAprovacao)
	{
		int numAprovados = 0, numReprovados = 0;
		float porcentagemAprovacao, porcentagemReprovacao;
		double media = 0, desvioPadrao = 0;
		float maiorNota = 0, menorNota = Integer.MAX_VALUE;
		
		AlunoDAO alunoDAO = new AlunoDAO();
		LinkedList<Aluno> alunos;	

		//realizar consulta no Banco de dados...
		alunos = this.consultarAlunos();
		
		for(Aluno aluno : alunos)
		{
			//alunos que não tem a nota cadastrada no BD a tem como -1. Por isso foi feita a modificação a seguir.
			float aux = aluno.getNota();	
			if(aux < 0) 
				aux = 0;
			
			
			media += aux;
			
			//calculo de menor e maior nota
			if(aux < menorNota)
				menorNota = aux;
			
			if(aux > maiorNota)
				maiorNota = aux;
			
			//contagem de numAprovados e numReprovados
			if(aux >= notaMinimaAprovacao)
				numAprovados++;
			
			else
				numReprovados++;
		
		}
		
		porcentagemAprovacao = this.calcularPorcentagem(numAprovados, alunos.size());
		porcentagemReprovacao = 100 - porcentagemAprovacao;
		
		media = media/alunos.size();
		
		desvioPadrao = this.calcularDesvioPadrao(alunos, media);
		
		
		StringBuffer desempenho = new StringBuffer();
		desempenho.append("Número de aprovados:  " + numAprovados + "\n");
		desempenho.append("Número de reprovados:  " + numReprovados + "\n");
		desempenho.append("Porcentagem de aprovacao:  " + porcentagemAprovacao + "%\n");
		desempenho.append("Porcentagem de reprovacao:  " + porcentagemReprovacao + "%\n");
		desempenho.append("Média:  " + media + "\n");
		desempenho.append("Desvio Padrão:  " + desvioPadrao + "\n");
		desempenho.append("Maior Nota:   " + maiorNota + "\n");
		desempenho.append("MenorNota:  " + menorNota + "\n");
		
		return desempenho; 

	}

	//simbolo de separação: "=". Exemplo: Henrique = 10.0
	public void inserirAlunoENota(String nomeEnota)
	{
		AlunoDAO alunoDAO = new AlunoDAO();
		boolean cadastrado = false;

		//separar a string nos campos nome e nota
		String [] aux = nomeEnota.split("=");
		String nomeAluno = aux[0];
		float nota = Float.parseFloat(aux[1]);

		//verificar se o aluno de nome indicado está cadastrado no sistema
		LinkedList<Aluno> alunos = alunoDAO.getListaAlunos();
		Aluno aluno = null;
		
		for(int i = 0; i < alunos.size() ; i++)
		{
			aluno = alunos.get(i);
			String aux1 = aluno.getNome().trim();
			String aux2 = nomeAluno.trim();
			if(aux1.compareToIgnoreCase(aux2) == 0) //se o aluno já está cadastrado
			{
				cadastrado = true;
				break;
			}
		}


		if(cadastrado == true)  //se o aluno já está cadastrado
		{
			if(aluno.getNota() == -1) //se nenhuma nota foi lancada
			{
				aluno.setNota(nota);
			
				alunoDAO.alterar(aluno);
				

			}
			else //se a nota já foi lançada
			{
				
				System.out.println("Erro: o aluno  "+ aluno.getNome() + "  já tem nota cadastrada");
				System.out.println("Nota: "+ aluno.getNota());
				return;

			}

		}

		else //se o aluno não está cadastrado
		{
			//inserir o aluno
			Aluno novo = new Aluno(nomeAluno);
			novo.setNota(nota);
			alunoDAO.inserir(novo);
			System.out.println("Novo usuário cadastrado!");
		}


	}
	
	private float calcularPorcentagem(float num1, float num2)
	{
		return (num1 * 100)/num2;
	}
	
	private double calcularDesvioPadrao(LinkedList<Aluno> alunos, double media)
	{
		double desvio = 0;
		for(Aluno a : alunos)
		{
			float aux = a.getNota();
			if(aux < 0) //alunos que não tem a nota cadastrada no BD a tem como -1. Por isso foi feita essa modificação.
				aux = 0;
			
			desvio += Math.abs(aux - media);
			
		}
			

		
		desvio = desvio/alunos.size();
		
		return desvio;
	}

	public String getSenha() 
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	

}
