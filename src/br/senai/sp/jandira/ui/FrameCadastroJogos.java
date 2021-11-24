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
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

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
		setBounds(100, 100, 779, 671);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("T\u00EDtulo do jogo:");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitulo.setBounds(41, 237, 106, 25);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTitulo.setBounds(182, 237, 154, 25);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel lblValorEstimado = new JLabel("Valor estimado:");
		lblValorEstimado.setFont(new Font("Arial", Font.BOLD, 14));
		lblValorEstimado.setBounds(43, 369, 129, 25);
		contentPane.add(lblValorEstimado);
		
		txtValor = new JTextField();
		txtValor.setFont(new Font("Arial", Font.PLAIN, 14));
		txtValor.setBounds(182, 369, 129, 25);
		txtValor.setColumns(10);
		contentPane.add(txtValor);
		
		JLabel lblObservacoes = new JLabel("Observa\u00E7\u00F5es:");
		lblObservacoes.setFont(new Font("Arial", Font.BOLD, 14));
		lblObservacoes.setBounds(41, 447, 106, 25);
		contentPane.add(lblObservacoes);
		
		txtObservacoes = new JTextField();
		txtObservacoes.setFont(new Font("Arial", Font.PLAIN, 14));
		txtObservacoes.setBounds(182, 447, 140, 68);
		txtObservacoes.setColumns(10);
		contentPane.add(txtObservacoes);
		
		JLabel lblFabricante = new JLabel("Fabricante:");
		lblFabricante.setFont(new Font("Arial", Font.BOLD, 14));
		lblFabricante.setBounds(41, 191, 88, 25);
		contentPane.add(lblFabricante);
		
		JComboBox<String> comboBoxFabricante = new JComboBox<String>();
		comboBoxFabricante.setBackground(new Color(240, 128, 128));
		comboBoxFabricante.setFont(new Font("Arial", Font.BOLD, 14));
		comboBoxFabricante.setBounds(182, 192, 154, 22);
        DefaultComboBoxModel <String> comboModelFabricante = new DefaultComboBoxModel <String>();
		
       
		// Carregar o comboModel com as descrições dos Perídos
		for (Fabricante fabricante : a.getFabricantes() ) {
			comboModelFabricante.addElement(fabricante.getNome());
		}
		
		comboBoxFabricante.setModel(comboModelFabricante);
		contentPane.add(comboBoxFabricante);
		
		JCheckBox chckbxUsado = new JCheckBox("Usado");
		chckbxUsado.setBackground(new Color(255, 250, 240));
		chckbxUsado.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxUsado.setBounds(124, 269, 97, 45);
		contentPane.add(chckbxUsado);
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setFont(new Font("Arial", Font.BOLD, 14));
		lblConsole.setBounds(41, 313, 88, 25);
		contentPane.add(lblConsole);
		
		JComboBox<String> comboBoxConsole = new JComboBox<String>();
		comboBoxConsole.setBackground(new Color(240, 128, 128));
		comboBoxConsole.setFont(new Font("Arial", Font.BOLD, 14));
		comboBoxConsole.setBounds(182, 314, 154, 22);
		DefaultComboBoxModel <String> comboModelConsole = new DefaultComboBoxModel <String>();
		
		// Carregar o comboModel com as descrições dos Perídos
		for (Console d : Console.values()) {
			comboModelConsole.addElement(d.getDescricao());
		}
		
		comboBoxConsole.setModel(comboModelConsole);
		contentPane.add(comboBoxConsole);
		
		JLabel lblMeusJogos = new JLabel("Meus Jogos:");
		lblMeusJogos.setFont(new Font("Arial", Font.BOLD, 14));
		lblMeusJogos.setBounds(438, 191, 106, 25);
		contentPane.add(lblMeusJogos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 237, 201, 290);
		contentPane.add(scrollPane_1);
		
		JList listJogos = new JList();
		scrollPane_1.setViewportView(listJogos);
		DefaultListModel modelJogos = new DefaultListModel(); 
		listJogos.setModel(modelJogos);
		
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
		
		
		
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBackground(new Color(240, 128, 128));
		btnSalvar.setFont(new Font("Arial", Font.BOLD, 14));
		btnSalvar.setBounds(95, 541, 102, 53);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.setBackground(new Color(240, 128, 128));
		btnVoltar.setFont(new Font("Arial", Font.BOLD, 14));
		btnVoltar.setBounds(435, 548, 97, 39);
		contentPane.add(btnVoltar);
		
		JButton btnAvancar = new JButton(">");
		btnAvancar.setBackground(new Color(240, 128, 128));
		btnAvancar.setFont(new Font("Arial", Font.BOLD, 14));
		btnAvancar.setBounds(542, 548, 97, 39);
		contentPane.add(btnAvancar);
		
		JButton btnMostrarJogos = new JButton("Jogos:");
		btnMostrarJogos.setBackground(new Color(240, 128, 128));
		btnMostrarJogos.setFont(new Font("Arial", Font.BOLD, 14));
		btnMostrarJogos.setBounds(278, 545, 88, 45);
		contentPane.add(btnMostrarJogos);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 182, 193));
		panel.setBounds(0, 0, 763, 147);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHeader = new JLabel("Minha Cole\u00E7\u00E3o de Jogos:");
		lblHeader.setForeground(new Color(128, 0, 0));
		lblHeader.setFont(new Font("Arial Black", Font.ITALIC, 18));
		lblHeader.setBounds(227, 53, 282, 37);
		panel.add(lblHeader);
		
		ImageIcon controle = new ImageIcon((getClass().getResource("/br/senai/sp/jandira/images/vida.png")));
		
		
		
		JLabel lblIconImg_1 = new JLabel();
		lblIconImg_1.setBounds(576, 11, 147, 125);
		lblIconImg_1.setIcon(controle);
		panel.add(lblIconImg_1);
		
		JLabel lblIconImg_1_1 = new JLabel();
		lblIconImg_1_1.setBounds(32, 11, 147, 125);
		lblIconImg_1_1.setIcon(controle);
		panel.add(lblIconImg_1_1);
		
		
		
		
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
				
				
				
			}
		});
		
		
		btnAvancar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione algum item da lista", "Espere um momento",JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()+1);
				}
					
			}
		}  );
		
		btnVoltar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (listJogos.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione algum item da lista", "Espere um momento",JOptionPane.WARNING_MESSAGE);
				} else {
					listJogos.setSelectedIndex(listJogos.getSelectedIndex()-1);
				}
				
			}
		});
		
		btnMostrarJogos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Jogo jogo : jogos.listarTodos()) {
					System.out.println(jogo.getJogo());
					System.out.println(jogo.getValor());
					System.out.println(jogo.getObservacoes());
					System.out.println(jogo.getFabricante().getNome());
					System.out.println(jogo.getUsado());
					System.out.println(jogo.getConsole());
					System.out.println("---------------------");
				}
				
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