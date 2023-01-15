package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.*;

public class ConsultarSalas {
	private JFrame frame;
	
	public ConsultarSalas () {
		final int largura_janela = 500;
		final int altura_janela = 410;
		
		this.frame = new JFrame("Consulta de Salas");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if (Globais.usuario.equals("admin")) {
			Titulo.adicionaTitulo("Consulta de Salas", largura_janela, frame);
		} else {
			Titulo.adicionaTitulo("Salas Disponíveis", largura_janela, frame);
		}
		
		JPanel container_tabela = new JPanel();
		container_tabela.setLayout(new GridLayout(1, 1));
		container_tabela.setBounds(0, 80, 487, 200);
		try {
			String[] colunas = {"id", "Número", "Bloco", "Andar", "Tipo"};
			
			Statement statement = Globais.conn.createStatement();
			ResultSet resultado = null;
			if (Globais.usuario.equals("admin")) {
				resultado = statement.executeQuery("SELECT * FROM salas");
			} else {
				resultado = statement.executeQuery("SELECT * FROM salas WHERE disponivel = 1");
			}
			int quantidade_linhas = 0;
			while (resultado.next()) quantidade_linhas++;
			String[][] dados = new String[quantidade_linhas][5];
			if (Globais.usuario.equals("admin")) {
				resultado = statement.executeQuery("SELECT * FROM salas");
			} else {
				resultado = statement.executeQuery("SELECT * FROM salas WHERE disponivel = 1");
			}
			int i = 0;
			while (resultado.next()) {
				for (int j = 0; j < 5; j++) {
					dados[i][j] = resultado.getString(j + 1);
				}
				i++;
			}
			JTable tabela = new JTable(dados, colunas);
			JScrollPane barra_rolagem = new JScrollPane(tabela);
			container_tabela.add(barra_rolagem);
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		
		getFrame().add(container_tabela);
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", altura_janela - 105, largura_janela, altura_janela, frame);
		
		botao_voltar.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				Globais.menu_usuario.getFrame().setVisible(true);
			}
		});
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}

