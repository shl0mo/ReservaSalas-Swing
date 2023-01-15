package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reserva.TextField;

import java.sql.*;


public class ExclusaoSala {
	private JFrame frame;
	
	public ExclusaoSala () {
		final int largura_janela = 400;
		final int altura_janela = 470;
		
		this.frame = new JFrame("Exclusão de Sala");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Exclusão de Sala", getFrame());
		
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
		
		JButton botao_excluir = Botao.ConstroiBotao("Excluir", 300, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 350, largura_janela, altura_janela, getFrame());
		
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.admin_main = new MenuAdmin();
				Globais.admin_main.getFrame().setVisible(true);
			}
		});
		
		botao_excluir.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String numero = numero_sala.getText();
				String bloco = bloco_sala.getText();
				String andar = andar_sala.getText();
				String tipo = (String)tipo_sala.getSelectedItem();
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE numero = '" + numero + "' AND bloco = '" + bloco + "' AND andar = '" + andar + "' AND tipo = '" + tipo + "'");
					int quantidade_linhas = 0;
					while (resultado.next()) quantidade_linhas++;
					if (quantidade_linhas == 0) {
						JOptionPane.showMessageDialog(null, "Não é possível realizar a exclusão. A sala solicitada não existe");
						return;
					}
					statement.execute("DELETE FROM salas WHERE numero = '" + numero + "' AND bloco = '" + bloco + "' AND andar = '" + andar +  "' AND tipo = '" + tipo +  "';");
					JOptionPane.showMessageDialog(null, "Sala excluida com sucesso");
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
