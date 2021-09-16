package ufpb.dsc.lab1.entidades;

import ufpb.dsc.lab1.dtos.DisciplinasDtos;

public class Disciplinas implements Comparable<Disciplinas>{
	private static long proximoId = 0;
	private Long id;
	private String nome;
	private int likes;
	private double [] notas;
	private boolean visibilidade = true;
	
	
	public Disciplinas() {
		super();
	}
	
	public Disciplinas (String nome, double [] notas) {
		super();
		this.id = proximoId++;
		this.nome = nome;
		this.likes = 0;
		this.notas = notas;
	}
	
	public Long getId() {
		return id;
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
	
	public boolean isVisibilidade() {
		return visibilidade;
	}

	public Disciplinas setVisibilidade(boolean visibilidade) {
		this.visibilidade = visibilidade;
		return null;
	}
	
	public static Disciplinas criaDisciplina(DisciplinasDtos disciplina) {
		return new Disciplinas(disciplina.getNome(), disciplina.getNotas());
	}
	
	public double retornaMedia() {
		double media = 0;
		double soma = 0;
		
		for (int i = 0; i < notas.length; i++) {
			soma += notas.length;
		}
		media = soma / notas.length;
		return media;
	}
	
	public int compareTo(Disciplinas o) {
		if(retornaMedia() < o.retornaMedia()) {
			return 1;
		}else if (retornaMedia() > o.retornaMedia()) {
			return -1;
		}
		return 0;
	}

	
	
	
}
