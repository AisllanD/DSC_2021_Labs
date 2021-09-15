package ufpb.dsc.lab1.dtos;

public class ItemDeAtualizacaoDeDisciplina {
	
	private String atributo;
	private String novoValor;
	
	public ItemDeAtualizacaoDeDisciplina() {
		super();
	}
	
	public ItemDeAtualizacaoDeDisciplina(String atributo, String novoValor) {
		super();
		this.atributo = atributo;
		this.novoValor = novoValor;
	}

	public String getAtributo() {
		return atributo;
	}

	public void setAtributo(String atributo) {
		this.atributo = atributo;
	}

	public String getNovoValor() {
		return novoValor;
	}

	public void setNovoValor(String novoValor) {
		this.novoValor = novoValor;
	}
	
	
	
	
	
	
	
}
