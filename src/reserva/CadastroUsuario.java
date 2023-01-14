package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import java.io.*;

import reserva.TextField;

public class CadastroUsuario {
	private JFrame frame;
	
	public CadastroUsuario () {
		final int largura_janela = 400;
		final int altura_janela = 500;
		
		this.frame = new JFrame("Cadastro de usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Cadastro de Usuários", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(5, 1, 0, 10));
		container_campos.setBounds(0, 90, largura_janela, 250);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JTextField campo_nome = TextField.ConstroiTextField("Nome", container_campos);
		JTextField campo_sobrenome = TextField.ConstroiTextField("Sobrenome", container_campos);
		JTextField campo_usuario = TextField.ConstroiTextField("Usuário", container_campos);
		JTextField campo_senha = PasswordField.ConstroiPasswordField("Senha", container_campos);
		
		String[] opcoes = {"Professor", "Funcionário"};
		JComboBox campo_tipo = ComboBox.ConstroiComboBox("Tipo", opcoes, container_campos);
		
		JButton botao_cadastrar = Botao.ConstroiBotao("Cadastrar", 370, largura_janela, altura_janela, getFrame());
		
		
		botao_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String nome = campo_nome.getText();
				String sobrenome = campo_sobrenome.getText();
				String usuario = campo_usuario.getText();
				String senha = campo_senha.getText();
				String tipo = (String)campo_tipo.getSelectedItem();
				if (nome.equals("") || sobrenome.equals("") || usuario.equals("") || senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios");
					int id = 0;
					while (resultado.next()) {
						id = Integer.parseInt(resultado.getString(1));
					}
					id++;
					statement.execute("INSERT INTO usuarios(id, nome, sobrenome, usuario, senha, tipo) VALUES('" + id + "', '" + nome + "', '" + sobrenome + "', '" + usuario + "', '" + senha + "', '" + tipo + "')");
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso");
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
