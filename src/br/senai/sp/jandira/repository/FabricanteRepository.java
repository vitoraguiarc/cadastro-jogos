package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Fabricante;

public class FabricanteRepository {
	
	private Fabricante [] fabricantes;
	
	public FabricanteRepository() {
		fabricantes = new Fabricante[5];
		
		fabricantes [0] = new Fabricante("Nintendo", "Japão");
		fabricantes [1] = new Fabricante("Ubisoft", "França");
		fabricantes [2] = new Fabricante("Electronic Arts", "Estados Unidos");
		fabricantes [3] = new Fabricante("Rockstar Games", "Estados Unidos");
		fabricantes [4] = new Fabricante("Sony", "Japão");
	}
	
	public Fabricante[] getFabricantes() {
		return fabricantes;
	}
	
	public Fabricante getFabricantesIndex(int index) {
		return fabricantes [index];
	}
	
	public Fabricante getFabricanteNome (String fabricanteNome) {
		for (Fabricante f : fabricantes) {
			if (f.getNome().equalsIgnoreCase(fabricanteNome));
			return f;
		}
		return null;
	}
	
	public int getIndex (Fabricante fabricante) {
		for (int i = 0; i < fabricantes.length; i++) {
			return i;
		}
		return 0;
	}
	public int getTamanho() {
		return fabricantes.length;
	}
}


