package br.senai.sp.jandira.model;

public class Jogo {
	
	private String jogo;
	private Fabricante fabricante;
	private boolean usado;
	private Console console;
	private double valor;
	private String observacoes;
	
	public String getJogo() {
		return jogo;
	}
	public void setJogo(String jogo) {
		this.jogo = jogo;
	}
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public Console getConsole() {
		return console;
	}
	public void setConsole(Console console) {
		this.console = console;
	}
	public double getValor(String valor) {
		return Double.parseDouble(valor);
	}
	
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	
	public boolean getUsado() {
		return usado;
	}
	public void setUsado(boolean usado) {
		this.usado = usado;
	}
	public void setValor(String valor) {
		this.valor = Double.parseDouble(valor);
		
	}
	public String getValor() {
		
		return null;
	}
	
	
	


	



}
