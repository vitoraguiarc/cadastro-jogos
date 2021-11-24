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
	
	public void salvar(Jogo jogo, int posiçao) {
		jogos[posiçao] = jogo;
	}
	
	public Jogo listarJogo(int posiçao) {
		return jogos[posiçao];
	}
	
	public Jogo[] listarTodos() {
		return jogos;
	}


}
