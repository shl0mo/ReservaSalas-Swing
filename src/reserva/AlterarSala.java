package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reserva.TextField;

import java.sql.*;

public class AlterarSala extends Frame {
	private JFrame frame;

	public AlterarSala () {
		final int largura_janela = 400;
		final int altura_janela = 470;
		
		this.frame = new JFrame("Alteração de Sala");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Alteração de Sala", frame);
		
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
		
		JButton botao_alterar = Botao.ConstroiBotao("Alterar", 300, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 350, largura_janela, altura_janela, getFrame());
		
		getFrame().add(container_campos);
		
		try {
			Statement statement = Globais.conn.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE id = " + Globais.id_alterar_sala);
			while (resultado.next()) {
				numero_sala.setText(resultado.getString(2));
				bloco_sala.setText(resultado.getString(3));
				andar_sala.setText(resultado.getString(4));
				if (resultado.getString(5).equals("Sala de Reunião")) {
					tipo_sala.setSelectedIndex(0);
				} else if (resultado.getString(5).equals("Auditório")) {
					tipo_sala.setSelectedIndex(1);
				} else {
					tipo_sala.setSelectedIndex(2);
				}
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		
		botao_alterar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String numero = numero_sala.getText();
				String bloco = bloco_sala.getText();
				String andar = andar_sala.getText();
				String tipo = (String)tipo_sala.getSelectedItem();
				if (numero.equals("") || bloco.equals("") || andar.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					statement.execute("UPDATE salas SET numero = '" + numero + "', bloco = '" + bloco + "', andar = '" + andar + "', tipo = '" + tipo + "' WHERE id = " + Globais.id_alterar_sala);
					JOptionPane.showMessageDialog(null, "Alteração realizada");
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
