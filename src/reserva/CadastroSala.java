package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class CadastroSala extends JFrame {
	
	private JFrame frame;
	
	public CadastroSala  () {
		final int largura_janela = 400;
		final int altura_janela = 470;
		
		this.frame = new JFrame("Cadastro de Sala");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Cadastro de Sala", frame);
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(5, 1, 0, 10));
		container_campos.setBounds(0, 90, largura_janela, 250);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JTextField numero_sala = TextField.ConstroiTextField("Número", container_campos);
		JTextField bloco_sala = TextField.ConstroiTextField("Bloco", container_campos);
		JTextField andar_sala = TextField.ConstroiTextField("Andar", container_campos);
		String[] tipos_salas = {"Sala de Reunião", "Auditório", "Labotoratório de Graduação"};
		JComboBox tipo_sala = ComboBox.ConstroiComboBox("Tipo", tipos_salas, container_campos);
		
		JButton botao_cadastrar = Botao.ConstroiBotao("Cadastrar", 300, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 350, largura_janela, altura_janela, getFrame());
		
		getFrame().add(container_campos);
		
		botao_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String numero = numero_sala.getText();
				String bloco = bloco_sala.getText();
				String andar = andar_sala.getText();
				String tipo = (String)tipo_sala.getSelectedItem();
				if (numero.equals("") || bloco.equals("") || andar.equals("") || tipo.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE numero = '" + numero + "' AND bloco = '" + bloco + "' AND andar = '" + andar + "';");
					int quantidade_linhas = 0;
					while (resultado.next()) quantidade_linhas++;
					if (quantidade_linhas != 0) {
						JOptionPane.showMessageDialog(null, "Falha ao cadastrar. A sala já se encontra cadastrada");
						return;
					}
					resultado = statement.executeQuery("SELECT * FROM salas");
					int id = 0;
					while (resultado.next()) id = Integer.parseInt(resultado.getString(1));
					id++;
					statement.execute("INSERT INTO salas(id, numero, bloco, andar, tipo) VALUES('" + id + "','" + numero + "', '" + bloco + "', '" + andar + "', '" + tipo + "')");
					JOptionPane.showMessageDialog(null, "Sala cadastrada com sucesso");
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
				
			}
		});
		
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				if (Globais.admin_main == null) {
					Globais.admin_main = new MenuAdmin();
					Globais.admin_main.getFrame().setVisible(true);
				} else {
					Globais.admin_main.getFrame().setVisible(true);
				}
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
