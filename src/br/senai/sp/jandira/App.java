package br.senai.sp.jandira;

import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;
import br.senai.sp.jandira.ui.FrameCadastroJogos;

public class App {

	public static void main(String[] args) {
		
		/*JogoRepository jogos = new JogoRepository(1);
		FabricanteRepository fabricantes = new FabricanteRepository(1);
		
		/*Jogo a = new Jogo();
		a.setJogo("Fifa 14");
		Fabricante f = new Fabricante();
		f.setNome("EA");
		a.setFabricante(f);
		
		a.setObservacoes("aa");
		a.setUsado(true);
		a.setValor("40");
		
		jogos.salvar(a, 0);
		fabricantes.gravar(f, 0);
		
		for (Jogo jogosAtuais : jogos.listarTodos()) {
			System.out.println(jogosAtuais.getJogo());
			System.out.println(jogosAtuais.getFabricante().getNome());
			System.out.println(jogosAtuais.getObservacoes());
			
		}*/
		
		
	FrameCadastroJogos f = new FrameCadastroJogos();
	f.setVisible(true);
		
		
		
		

	}

}
