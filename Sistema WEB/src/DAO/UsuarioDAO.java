package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Aluno;
import entity.Usuario;

/*
 CREATE TABLE Usuarios
 (
    id SERIAL NOT NULL,
	senha VARCHAR(255),
	primary key(id)
 );
*/

public class UsuarioDAO 
{

	private Connection connection;

	public UsuarioDAO()
	{
		connection = new ConnectionFactory().getConnection();
	}

/*	public void inserir(Usuario usuario)
	{

		String sql = "INSERT INTO usuarios (senha) values(?)";

		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);

			ps.setString(1, usuario.getSenha());


			ps.execute();
			ps.close();


		}

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}

	}*/

	public Usuario getUsuario()
	{
		Usuario usuario = null;

		String sql;

		sql = "SELECT * FROM Usuarios";

		PreparedStatement ps;

		try 
		{
			ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next() == true)
			{
				long id = rs.getLong("id");
				String senha = rs.getString("senha");

				usuario = new Usuario();
				usuario.setSenha(senha);

			}

			ps.close();
		} 

		catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}


		return usuario;
	}

}
