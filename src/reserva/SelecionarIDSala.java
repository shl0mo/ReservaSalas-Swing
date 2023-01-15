package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reserva.TextField;

import java.sql.*;

public class SelecionarIDSala extends JFrame {
	private JFrame frame;
		
	public SelecionarIDSala () {
		final int largura_janela = 400;
		final int altura_janela = 300;
				
		this.frame = new JFrame("Selecionar Id da Sala");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Selecionar Id da Sala", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(1, 1, 0, 10));
		container_campos.setBounds(50, 80, 250, 40);
		
		JTextField id_sala = TextField.ConstroiTextField("Id da Sala", container_campos);
		
		JButton botao_selecionar_id = Botao.ConstroiBotao("Selecinar Id", 140, largura_janela, altura_janela, frame);
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 195, largura_janela, altura_janela, frame);
		
		getFrame().add(container_campos);
		
		botao_selecionar_id.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				String id_campo = id_sala.getText();
				if (id_campo.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE id = " + id_campo);
					Globais.id_alterar_sala = "";
					while (resultado.next()) Globais.id_alterar_sala = resultado.getString(1); 
					if (Globais.id_alterar_sala.equals("")) {
						JOptionPane.showMessageDialog(null, "O Id informado não pertence a nenhuma sala");
						return;
					}
					getFrame().setVisible(false);
					Globais.alterar_sala = new AlterarSala();
					Globais.alterar_sala.getFrame().setVisible(true);
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
		botao_voltar.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.admin_main.getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
