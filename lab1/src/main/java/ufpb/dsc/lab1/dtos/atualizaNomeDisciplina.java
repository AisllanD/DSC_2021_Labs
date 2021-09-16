package ufpb.dsc.lab1.dtos;

public class atualizaNomeDisciplina {
	private String novoNome;
	
	
	public atualizaNomeDisciplina() {
		super();
	}
	
	public atualizaNomeDisciplina(String novoNome) {
		super();
		this.novoNome = novoNome;
	}

	public String getNovoNome() {
		return novoNome;
	}

	public void setNovoNome(String novoNome) {
		this.novoNome = novoNome;
	}
}
