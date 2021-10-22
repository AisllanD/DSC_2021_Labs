package ufpb.dsc.lab3.dtos;

public class AtualizaNotaDisciplina {
	private double novaNota;
	
	public AtualizaNotaDisciplina() {
		super();
	}
	
	public AtualizaNotaDisciplina(double novaNota) {
		super();
		this.novaNota = novaNota;
	}
	
	public double getNovaNota() {
		return novaNota;
	}

	public void setNovaNota(double novaNota) {
		this.novaNota = novaNota;
	}
	
}
