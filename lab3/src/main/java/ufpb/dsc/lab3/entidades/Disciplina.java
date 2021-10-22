package ufpb.dsc.lab3.entidades;

import java.util.ArrayList;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import ufpb.dsc.lab3.dtos.DisciplinaDTO;

@Entity
public class Disciplina {
	@Id 
	@GeneratedValue
	private long id;
	
	private String nome;
	private double notas;
	private int likes;
	private ArrayList<String> comentarios = new ArrayList<String>();

	public Disciplina() {
		super();
	}
	
	public Disciplina(String nome, long id) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getNotas() {
		return notas;
	}

	public void setNotas(double notas) {
		this.notas = notas;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes() {
		this.likes++;
	}

	public ArrayList<String> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<String> comentarios) {
		this.comentarios.addAll(comentarios);
	}
	
}
