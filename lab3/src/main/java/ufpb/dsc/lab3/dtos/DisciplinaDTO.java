package ufpb.dsc.lab3.dtos;

public class DisciplinaDTO {
	private String nome;
	private int likes;
	private double nota;
	
	public DisciplinaDTO() {
		super();
	}
	
	public DisciplinaDTO(String nome) {
		this.setNome(nome);
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	
	
	
	
}
