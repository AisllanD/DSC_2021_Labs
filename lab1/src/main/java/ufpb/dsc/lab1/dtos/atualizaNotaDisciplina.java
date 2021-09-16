package ufpb.dsc.lab1.dtos;

public class atualizaNotaDisciplina {
	private double [] novaNota;
	
	public atualizaNotaDisciplina() {
		super();
	}
	
	public atualizaNotaDisciplina(double [] novaNota) {
		super();
		this.setNovaNota(novaNota);
	}

	public double [] getNovaNota() {
		return novaNota;
	}

	public void setNovaNota(double [] novaNota) {
		this.novaNota = novaNota;
	}
	
}
