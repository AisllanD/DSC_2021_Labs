package ufpb.dsc.lab1.dtos;

public class DisciplinasDtos {
	private String nome;
	private int likes;
	private double [] notas; 

	public DisciplinasDtos() {
		super();
	}
	
	public DisciplinasDtos(String nome, double [] notas) {
		super();
		this.nome = nome;
		this.likes = 0;
		this.notas = notas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public double [] getNotas() {
		return notas;
	}

	public void setNotas(double [] notas) {
		this.notas = notas;
	}
	
	
	
	
}
