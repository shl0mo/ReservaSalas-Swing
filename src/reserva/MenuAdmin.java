package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

import reserva.CadastroSala;

public class MenuAdmin extends JFrame {
	private JFrame frame;
	
	public MenuAdmin () {
		final int largura_janela = 400;
		final int altura_janela = 650;
		
		this.frame = new JFrame("Menu");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Menu do Administrador", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(10, 1, 0, 10));
		container_campos.setBounds(0, 80, largura_janela, altura_janela - 200);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JButton botao_cadastrar_usuario = Botao.ConstroiBotao ("Cadastrar Usuário", 0, largura_janela, altura_janela, container_campos);
		JButton botao_consultar_usuarios = Botao.ConstroiBotao ("Consultar Usuários", 0, largura_janela, altura_janela, container_campos);
		JButton alterar_usuario = Botao.ConstroiBotao ("Alterar Usuário", 0, largura_janela, altura_janela, container_campos);
		JButton botao_excluir_usuario = Botao.ConstroiBotao ("Excluir Usuário", 0, largura_janela, altura_janela, container_campos);
		JButton botao_cadastrar_sala = Botao.ConstroiBotao ("Cadastrar Sala", 0, largura_janela, altura_janela, container_campos);
		JButton botao_consultar_salas = Botao.ConstroiBotao ("Consultar Salas", 0, largura_janela, altura_janela, container_campos);
		JButton botao_alterar_sala = Botao.ConstroiBotao ("Alterar Sala", 0, largura_janela, altura_janela, container_campos);
		JButton botao_excluir_sala = Botao.ConstroiBotao ("Excluir Sala", 0, largura_janela, altura_janela, container_campos);
		JButton botao_gerar_relatorio = Botao.ConstroiBotao ("Gerar Relatório", 0, largura_janela, altura_janela, container_campos);
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
		
		botao_consultar_usuarios.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.consultar_usuarios = new ConsultarUsuarios();
				Globais.consultar_usuarios.getFrame().setVisible(true);
			}
		});
		
		alterar_usuario.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.selecionar_id_usuario = new SelecionarIDUsuario();
				Globais.selecionar_id_usuario.getFrame().setVisible(true);
			}
		});
		
		botao_sair.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Globais.id_usuario = 0;
				Globais.usuario = "";
				getFrame().setVisible(false);
				Globais.admin_main = null;
				Globais.login = new Login();
				Globais.login.getFrame().setVisible(true);
			}
		});
		
		botao_excluir_usuario.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				Globais.admin_main.getFrame().setVisible(false);
				if (Globais.exclusao_usuario == null) {
					Globais.exclusao_usuario = new ExclusaoUsuario();
					Globais.exclusao_usuario.getFrame().setVisible(true);	
				} else {
					Globais.exclusao_usuario.getFrame().setVisible(true);
				}
			}
		});
		
		botao_cadastrar_sala.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.cadastro_sala = new CadastroSala();
				Globais.cadastro_sala.getFrame().setVisible(true);
			}
		});
		
		botao_consultar_salas.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.consultar_salas = new ConsultarSalas();
				Globais.consultar_salas.getFrame().setVisible(true);
			}
		});
		
		botao_alterar_sala.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.selecionar_id_sala = new SelecionarIDSala();
				Globais.selecionar_id_sala.getFrame().setVisible(true);
			}
		});
		
		botao_excluir_sala.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.exclusao_sala = new ExclusaoSala();
				Globais.exclusao_sala.getFrame().setVisible(true);
			}
		});
		
		botao_gerar_relatorio.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.relatorio = new Relatorio();
				Globais.relatorio.getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}

