package br.senai.sp.jandira.model;

public class Fabricante {
	
	private String nome;
	private String sede;

	
	public Fabricante(String nome, String sede) {
		this.nome = nome;
		this.sede = sede;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPais() {
		return sede;
	}
	public void setPais(String pais) {
		this.sede = pais;
	}
	
	



}
