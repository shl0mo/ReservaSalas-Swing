package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reserva.TextField;

import java.sql.*;

public class AlterarUsuarioID extends JFrame {
	private JFrame frame;
		
	public AlterarUsuarioID () {
		final int largura_janela = 400;
		final int altura_janela = 300;
				
		this.frame = new JFrame("Alterar Usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Alterar Usuário", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(1, 1, 0, 10));
		container_campos.setBounds(50, 80, 250, 40);
		
		JTextField id_usuario = TextField.ConstroiTextField("Id do Usuário", container_campos);
		
		JButton botao_alterar = Botao.ConstroiBotao("Selecinar Id", 140, largura_janela, altura_janela, frame);
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 195, largura_janela, altura_janela, frame);
		
		getFrame().add(container_campos);
		
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
