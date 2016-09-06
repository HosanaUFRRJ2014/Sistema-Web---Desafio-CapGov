package entity;

public class Aluno 
{
	private long id;
	private String nome;
	private float nota;
	
	public Aluno(String nome)
	{
		this.nome = nome;
		this.nota = -1; //nota = -1 se nenhuma nota foi atribuída
	}

	public long getId() 
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getNome() 
	{
		return nome;
	}

	public void setNome(String nome) 
	{
		this.nome = nome;
	}

	public float getNota() 
	{
		return nota;
	}

	public void setNota(float nota) 
	{
		this.nota = nota;
	}
	
	
}
