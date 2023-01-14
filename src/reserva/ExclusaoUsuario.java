package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import reserva.TextField;

import java.sql.*;
import java.io.*;

public class ExclusaoUsuario {
	private JFrame frame;
	
	public ExclusaoUsuario () {
		final int largura_janela = 400;
		final int altura_janela = 300;
		
		this.frame = new JFrame("Exclusão de Usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Exclusão de Usuário", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(1, 1, 0, 10));
		container_campos.setBounds(0, 90, largura_janela, 40);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JTextField campo_usuario = TextField.ConstroiTextField("Usuário", container_campos);
		container_campos.add(campo_usuario);
		
		JButton botao_excluir = Botao.ConstroiBotao("Excluir", 145, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 195, largura_janela, altura_janela, getFrame());
		
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
				Globais.admin_main.getFrame().setVisible(true);
			}
		});
		
		botao_excluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome_usuario = campo_usuario.getText();
				if (nome_usuario.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios WHERE usuario = '" + nome_usuario + "'");
					int numero_linhas = 0;
					while (resultado.next()) numero_linhas++;
					if (numero_linhas == 0) {
						JOptionPane.showMessageDialog(null, "Não foi possível excluir. Usuário não cadastrado");
						return;
					}
					statement.execute("DELETE FROM usuarios WHERE usuario = '" + nome_usuario + "'");
					JOptionPane.showMessageDialog(null, "Usuário excluído com sucesso");
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
