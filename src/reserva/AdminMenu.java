package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;


public class AdminMenu extends JFrame {
	private JFrame frame;
	
	public AdminMenu () {
		final int largura_janela = 400;
		final int altura_janela = 400;
		
		this.frame = new JFrame("Menu");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Menu do Administrador", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(5, 1, 0, 10));
		container_campos.setBounds(0, 80, largura_janela, 250);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JButton botao_cadastrar_usuario = Botao.ConstroiBotao ("Cadastrar Usuário", 0, largura_janela, altura_janela, container_campos);
		JButton botao_excluir_usuario = Botao.ConstroiBotao ("Excluir Usuário", 0, largura_janela, altura_janela, container_campos);
		JButton botao_cadastrar_sala = Botao.ConstroiBotao ("Cadastrar Sala", 0, largura_janela, altura_janela, container_campos);
		JButton botao_excluir_sala = Botao.ConstroiBotao ("Excluir Sala", 0, largura_janela, altura_janela, container_campos);
		JButton botao_sair = Botao.ConstroiBotao ("Sair", 0, largura_janela, altura_janela, container_campos);
		
		botao_cadastrar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				if (Globais.cadastro_usuario == null) {
					Globais.cadastro_usuario = new CadastroUsuario();
					Globais.cadastro_usuario.getFrame().setVisible(true);
				} else {
					Globais.cadastro_usuario.getFrame().setVisible(true);
				}
			}
		});
		
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Globais.id_usuario = 0;
				Globais.nome_usuario = "";
				getFrame().setVisible(false);
				Globais.admin_main = null;
				Globais.login = new Login();
				Globais.login.getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
