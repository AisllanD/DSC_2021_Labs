package ufpb.dsc.lab1.excecoes;

public class NomeDeDisciplinaInvalidoException extends RuntimeException {
	private String titulo;
	private String detalhes;
	
	public NomeDeDisciplinaInvalidoException(String titulo, String detalhes) {
		super();
		this.detalhes = detalhes;
		this.titulo = titulo;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDetalhes() {
		return detalhes;
	}
}
