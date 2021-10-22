package ufpb.dsc.lab3.dtos;

import java.util.ArrayList;

public class AtualizaComentarioDisciplina {
	private ArrayList<String> comentario;
	
	public AtualizaComentarioDisciplina(){
		super();
	}
	
	public AtualizaComentarioDisciplina(ArrayList<String> comentario){
		super();
		this.comentario = comentario;
	}

	public ArrayList<String> getComentario() {
		return comentario;
	}

	public void setComentario(ArrayList<String> comentario) {
		this.comentario = comentario;
	}
}
