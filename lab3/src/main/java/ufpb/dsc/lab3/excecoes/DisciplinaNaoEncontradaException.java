package ufpb.dsc.lab3.excecoes;

public class DisciplinaNaoEncontradaException extends RuntimeException {
	private String titulo;
	private String detalhe;
	
	public DisciplinaNaoEncontradaException(String titulo, String detalhe) {
		super();
		this.titulo = titulo;
		this.detalhe = detalhe;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDetalhe() {
		return detalhe;
	}

	public void setDetalhe(String detalhe) {
		this.detalhe = detalhe;
	}
	

}
