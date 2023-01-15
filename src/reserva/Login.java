package reserva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;

public class Login extends JFrame {
	private JFrame frame;
	
	public Login () {
		final int largura_janela = 400;
		final int altura_janela = 300;
				
		this.frame = new JFrame("Login");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Sistema de Reserva de Salas do IComp", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(2, 1, 0, 10));
		container_campos.setBounds(50, 70, 300, 100);
		
		JTextField campo_usuario = TextField.ConstroiTextField("Usuário", container_campos);
		JPasswordField campo_senha = PasswordField.ConstroiPasswordField("Senha", container_campos);
		
		JButton botao_logar = Botao.ConstroiBotao("Login", 180, largura_janela, altura_janela, frame);
		
		container_campos.setVisible(true);
		
		this.frame.add(container_campos);
		
		botao_logar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String usuario = campo_usuario.getText();
				String senha = campo_senha.getText();  
				if (usuario.equals("") || senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				if (usuario.equals("admin") && senha.equals("admin")) {
					Globais.id_usuario = 0;
					Globais.usuario = "admin";
					if (Globais.admin_main == null) {
						Globais.admin_main  = new MenuAdmin();
						getFrame().setVisible(false);
						Globais.admin_main.getFrame().setVisible(true);
					} else {
						getFrame().setVisible(false);
						Globais.admin_main.getFrame().setVisible(true);
					}
				} else {
					try {
						Statement statement = Globais.conn.createStatement();
						ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios WHERE usuario = '" + usuario + "'" + " AND senha = '" + senha + "';");
						int id = 0;
						int numero_linhas = 0;
						while (resultado.next()) {
							id = Integer.parseInt(resultado.getString(1));
							numero_linhas++;
						}
						if (numero_linhas == 0) {
							JOptionPane.showMessageDialog(null, "Usuário ou senha inválidos");
							return;
						}
						Globais.id_usuario = id;
						Globais.usuario = usuario;
						getFrame().setVisible(false);
						Globais.menu_usuario = new MenuUsuario();
						Globais.menu_usuario.getFrame().setVisible(true);
					} catch (Exception ioe) {
						ioe.printStackTrace();
					}
				}
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
	
}