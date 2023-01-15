package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class MenuUsuario extends JFrame {
	private JFrame frame;
	
	public MenuUsuario () {
		final int largura_janela = 400;
		final int altura_janela = 300;
				
		this.frame = new JFrame("Menu do Usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Selecione uma opção", getFrame());
		
		JButton botao_reservar = Botao.ConstroiBotao("Reservar Sala", 70, largura_janela, altura_janela, getFrame());
		JButton botao_consultar = Botao.ConstroiBotao("Consultar Salas", 130, largura_janela, altura_janela, getFrame());
		JButton botao_sair = Botao.ConstroiBotao("Sair", 190, largura_janela, altura_janela, getFrame());
		
		botao_reservar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.reservar_sala = new ReservarSala();
				Globais.reservar_sala.getFrame().setVisible(true);
			}
		});
		
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Globais.id_usuario = 0;
				Globais.usuario = "";
				getFrame().setVisible(false);
				Globais.login = new Login();
				Globais.login.getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
