package br.senai.sp.jandira.repository;

import br.senai.sp.jandira.model.Jogo;

public class JogoRepository {
	
	private Jogo [] jogos;
	
	public JogoRepository() {
		jogos = new Jogo[3];
	}
	
	public JogoRepository(int quantidadeJogos) {
		jogos = new Jogo [quantidadeJogos];
	}
	
	public void salvar(Jogo jogo, int posi�ao) {
		jogos[posi�ao] = jogo;
	}
	
	public Jogo listarJogo(int posi�ao) {
		return jogos[posi�ao];
	}
	
	public Jogo[] listarTodos() {
		return jogos;
	}


}
