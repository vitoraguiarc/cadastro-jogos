package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.senai.sp.jandira.model.Console;
import br.senai.sp.jandira.model.Fabricante;
import br.senai.sp.jandira.model.Jogo;
import br.senai.sp.jandira.repository.FabricanteRepository;
import br.senai.sp.jandira.repository.JogoRepository;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;

public class FrameCadastroJogos extends JFrame {
	
	//Repositorios
	private JogoRepository jogos = new JogoRepository(); 
    private FabricanteRepository a = new FabricanteRepository();

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtValor;
	private JTextField txtObservacoes;
	
	int posicao = 0;

	public FrameCadastroJogos() {
		setTitle("Meus Jogos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 616, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo do jogo:");
		lblTitulo.setBounds(10, 24, 88, 25);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(101, 24, 154, 25);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblValorEstimado = new JLabel("Valor estimado:");
		lblValorEstimado.setBounds(10, 225, 88, 25);
		contentPane.add(lblValorEstimado);
		
		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(101, 225, 88, 25);
		contentPane.add(txtValor);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setBounds(10, 293, 88, 25);
		contentPane.add(lblObservacoes);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setColumns(10);
		txtObservacoes.setBounds(101, 293, 140, 68);
		contentPane.add(txtObservacoes);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setBounds(10, 60, 88, 25);
		contentPane.add(lblFabricante);
		
		JComboBox<String> comboBoxFabricante = new JComboBox<String>();
        DefaultComboBoxModel <String> comboModelFabricante = new DefaultComboBoxModel <String>();
		
       
		// Carregar o comboModel com as descrições dos Perídos
		for (Fabricante fabricante : a.getFabricantes() ) {
			comboModelFabricante.addElement(fabricante.getNome());
		}
		
		comboBoxFabricante.setModel(comboModelFabricante);
		comboBoxFabricante.setBounds(101, 60, 154, 22);
		contentPane.add(comboBoxFabricante);
		
		JCheckBox chckbxUsado = new JCheckBox("Usado");
		chckbxUsado.setBounds(101, 110, 97, 45);
		contentPane.add(chckbxUsado);
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(10, 170, 88, 25);
		contentPane.add(lblConsole);
		
		JComboBox<String> comboBoxConsole = new JComboBox<String>();
		DefaultComboBoxModel <String> comboModelConsole = new DefaultComboBoxModel <String>();
		
		// Carregar o comboModel com as descrições dos Perídos
		for (Console d : Console.values()) {
			comboModelConsole.addElement(d.getDescricao());
		}
		
		comboBoxConsole.setModel(comboModelConsole);
		comboBoxConsole.setBounds(101, 171, 154, 22);
		contentPane.add(comboBoxConsole);
		
		JLabel lblMeusJogos = new JLabel("Meus Jogos:");
		lblMeusJogos.setBounds(358, 11, 88, 25);
		contentPane.add(lblMeusJogos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 47, 201, 290);
		contentPane.add(scrollPane_1);
		
		JList listJogos = new JList();
		scrollPane_1.setViewportView(listJogos);
		
		DefaultListModel modelJogos = new DefaultListModel(); 
		listJogos.setModel(modelJogos);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(29, 388, 102, 53);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.setBounds(332, 388, 97, 39);
		contentPane.add(btnVoltar);
		
		JButton btnAvancar = new JButton(">");
		btnAvancar.setBounds(460, 388, 97, 39);
		contentPane.add(btnAvancar);
		
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Jogo jogo = new Jogo();
				jogo.setJogo(txtTitulo.getText());
				jogo.setFabricante(a.getFabricantes()[comboBoxFabricante.getSelectedIndex()]);
				jogo.setUsado(chckbxUsado.isSelected());
				jogo.setConsole(definirConsole(comboBoxConsole.getSelectedIndex()));
				jogo.setValor(txtValor.getText());
				jogo.setObservacoes(txtObservacoes.getText());
				
				jogos.salvar(jogo,posicao);
				posicao++;
				
				modelJogos.addElement(jogo.getJogo());
				
				System.out.println(jogo.getConsole().ordinal());
				
			}
		});
		
		listJogos.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				Jogo jogoSelecionado = jogos.listarJogo(listJogos.getSelectedIndex());
				txtTitulo.setText(jogos.listarJogo(listJogos.getSelectedIndex()).getJogo());
				comboBoxFabricante.setSelectedIndex(a.getIndex(jogoSelecionado.getFabricante()));
				comboBoxConsole.setSelectedIndex(jogoSelecionado.getConsole().ordinal());
				txtValor.setText(jogoSelecionado.getValor());
				txtObservacoes.setText(jogoSelecionado.getObservacoes());
				chckbxUsado.setSelected(jogoSelecionado.getUsado());
				
			}
		});
		
		
	}
	
        private Console definirConsole (int consoleSelecionado) {
			if (consoleSelecionado == 0) {
				return Console.PLAYSTATION2;
			} else if (consoleSelecionado == 1) {
				return Console.NINTENDODS;
			} else if (consoleSelecionado == 2) {
				return Console.PLAYSTATION4;
			} else if (consoleSelecionado == 3) {
				return Console.NINTENDOSWITCH;
			} else if (consoleSelecionado == 4) {
				return Console.XBOX360;
			} else  {
				return Console.XBOXONE;
			}
		} 
        
        
}