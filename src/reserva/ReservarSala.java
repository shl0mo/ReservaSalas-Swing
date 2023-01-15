package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class ReservarSala extends JFrame {
	
	private JFrame frame;
	
	public ReservarSala  () {
		final int largura_janela = 400;
		final int altura_janela = 550;
		
		this.frame = new JFrame("Reserva de Sala");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Reserva de Sala", frame);
		
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
		JTextField campo_data = TextField.ConstroiTextField("Data", container_campos);
		
		JButton botao_reservar = Botao.ConstroiBotao("Reservar", 360, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 410, largura_janela, altura_janela, getFrame());
		
		getFrame().add(container_campos);
		
		botao_reservar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				int id_usuario = Globais.id_usuario;
				String numero = numero_sala.getText();
				String bloco = bloco_sala.getText();
				String andar = andar_sala.getText();
				String tipo = (String)tipo_sala.getSelectedItem();
				String data = campo_data.getText();
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE numero = '" + numero + "' AND bloco = '" + bloco + "' AND andar = '" + andar + "' AND tipo = '" + tipo + "';");
					int quantidade_linhas = 0;
					while (resultado.next()) {
						quantidade_linhas++;
					}
					if (quantidade_linhas == 0) {
						JOptionPane.showMessageDialog(null, "A sala solicitada não existe");
						return;
					}
					resultado = statement.executeQuery("SELECT * FROM salas WHERE numero = '" + numero + "' AND bloco = '" + bloco + "' AND andar = '" + andar + "' AND tipo = '" + tipo + "';");
					String id_sala = "";
					while (resultado.next()) id_sala = resultado.getString(1);
					resultado = statement.executeQuery("SELECT * FROM reservas WHERE id_sala = " + id_sala);
					while (resultado.next()) {
						if (resultado.getString(3).equals(data)) {
							JOptionPane.showMessageDialog(null, "A sala não está disponível na data solicitada");
							return;
						}
					}
					statement.execute("INSERT INTO reservas(id_usuario, id_sala, data) VALUES('" + id_usuario + "', '" + id_sala + "', '" + data + "');");
					JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso");
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				if (Globais.menu_usuario == null) {
					Globais.menu_usuario = new MenuUsuario();
					Globais.menu_usuario.getFrame().setVisible(true);
				} else {
					Globais.menu_usuario.getFrame().setVisible(true);
				}
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
