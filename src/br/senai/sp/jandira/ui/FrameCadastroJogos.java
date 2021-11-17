package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.senai.sp.jandira.model.Console;
import br.senai.sp.jandira.model.Fabricante;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class FrameCadastroJogos extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtValor;
	private JTextField txtObservacoes;

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
		
		JComboBox comboBoxFabricante = new JComboBox();
		comboBoxFabricante.setBounds(101, 60, 154, 22);
		contentPane.add(comboBoxFabricante);
		
		JCheckBox chckbxUsado = new JCheckBox("Usado");
		chckbxUsado.setBounds(101, 110, 97, 45);
		contentPane.add(chckbxUsado);
		
		JLabel lblConsole = new JLabel("Console:");
		lblConsole.setBounds(10, 170, 88, 25);
		contentPane.add(lblConsole);
		
		JComboBox comboBoxConsole = new JComboBox();
		DefaultComboBoxModel <String> comboModelPeriodo = new DefaultComboBoxModel <String>();
		
		// Carregar o comboModel com as descrições dos Perídos
		for (Console descricao : Console.values()) {
			comboModelPeriodo.addElement(descricao.getDescricao());
		}
		
		comboBoxConsole.setModel(comboModelPeriodo);
		comboBoxConsole.setBounds(101, 171, 154, 22);
		contentPane.add(comboBoxConsole);
		
		JLabel lblMeusJogos = new JLabel("Meus Jogos:");
		lblMeusJogos.setBounds(358, 11, 88, 25);
		contentPane.add(lblMeusJogos);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(358, 47, 201, 290);
		contentPane.add(scrollPane_1);
		
		JList list = new JList();
		list.setBounds(358, 64, 199, 288);
		contentPane.add(list);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(29, 388, 102, 53);
		contentPane.add(btnSalvar);
		
		JButton btnVoltar = new JButton("<");
		btnVoltar.setBounds(332, 388, 97, 39);
		contentPane.add(btnVoltar);
		
		JButton btnAvancar = new JButton(">");
		btnAvancar.setBounds(460, 388, 97, 39);
		contentPane.add(btnAvancar);
	}
}
