package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import entity.*;

/*Tabela no PostgreSQL:

CREATE TABLE Alunos (
	id SERIAL NOT NULL,
	nome VARCHAR(255),
	nota REAL,
	primary key(id)
);

 */

public class AlunoDAO 
{
	private Connection connection;
	private LinkedList<Aluno> alunos;

	public AlunoDAO()
	{
		connection = new ConnectionFactory().getConnection();
	}

	public boolean inserir(Aluno aluno)
	{
		boolean sucesso = false;
		String sql = "INSERT INTO Alunos (nome,nota) values(?,?)";

		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);

			ps.setString(1, aluno.getNome());
			ps.setDouble(2, aluno.getNota());

			ps.execute();
			ps.close();

			sucesso = true;
		}

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}

		return sucesso;
	}

	public void alterar(Aluno aluno)
	{
		String sql = "UPDATE Alunos SET nota="+ aluno.getNota()+ "WHERE id="+ aluno.getId();

		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);

			ps.execute();
			ps.close();
		} 

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}

	}

	//para o Lancar Nota(Opcional),na busca por número (em andamento)
/*	public Aluno buscarPorID(long id)
	{
		Aluno aluno = null;

		String sql = "SELECT * FROM Alunos WHERE id=" + id; //se não funcionar, usar id=?;

		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			String nome = rs.getString("nome");
			float nota = rs.getFloat("nota");


			aluno = new Aluno(nome);
			aluno.setId(rs.getLong("id"));
			aluno.setNota(nota);
			//para setar o valor ONDE tem o id informado
			//		ps.setLong(3, aluno.getId());

			ps.execute();
			ps.close();
		} 

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}



		return aluno;

	}*/

	//para o inserir Aluno e Nota 
	public LinkedList<Aluno> buscar(String valorBuscado)
	{
		LinkedList<Aluno> alunos = new LinkedList<Aluno>();
		String sql;

			sql = "SELECT * FROM Alunos WHERE id = "+ valorBuscado;

		
		System.out.println(sql);
		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next() == true)
			{
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				float nota = rs.getFloat("nota");

				Aluno aluno = new Aluno(nome);
				aluno.setId(id);
				aluno.setNota(nota);
				
				alunos.add(aluno);
			}
		
			ps.close();
		} 

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}

		return alunos;

	}

	public LinkedList<Aluno> getListaAlunos()
	{
		alunos = new LinkedList<Aluno>();

		String sql = "SELECT * FROM Alunos";

		PreparedStatement ps;


		try 
		{
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next() == true)
			{
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				float nota = rs.getFloat("nota");

				Aluno aluno = new Aluno(nome);
				aluno.setId(id);
				aluno.setNota(nota);

				alunos.add(aluno);
			}

			rs.close();
			ps.close();
		} 

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}

		return alunos;
	}

}
