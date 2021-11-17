package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {
	
	private Fabricante [] fabricantes;
	
	public FabricanteRepository() {
		fabricantes = new Fabricante [5];
	}
	
	public FabricanteRepository(int quantidadeFabricantes) {
		fabricantes = new Fabricante [quantidadeFabricantes];
	}
	
	public void gravar(Fabricante fabricante, int posiçao) {
		fabricantes[posiçao] = fabricante;
	}
	
	public Fabricante listarFabricantes(int posiçao) {
		return fabricantes[posiçao];
	}
	
	public Fabricante[] listarTodos() {
		return fabricantes;
	}
	
	public void criarFabricante() {
		Fabricante a = new Fabricante();
		a.setNome("EA");
		a.setFundacao("1982");
		a.setPais("EUA");
		
		Fabricante b = new Fabricante();
		b.setNome("Sony");
		b.setFundacao("1942");
		b.setPais("Japão");
		
		
		
	}
	
}


