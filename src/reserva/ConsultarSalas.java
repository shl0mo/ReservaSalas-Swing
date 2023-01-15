package reserva;

import java.awt.*;
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
		Titulo.adicionaTitulo("Consulta de Salas", largura_janela, frame);
		
		JPanel container_tabela = new JPanel();
		container_tabela.setLayout(new GridLayout(1, 1));
		container_tabela.setBounds(0, 80, 487, 200);
		String[] colunas = {"id", "Número", "Bloco", "Andar", "Tipo"};
		Object[][] dados = {
				{"1", "103", "A", "3", "Laboratório de Graduação"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"},
				{"2", "104", "B", "4", "Senha"}
		};
		JTable tabela = new JTable(dados, colunas);
		JScrollPane barra_rolagem = new JScrollPane(tabela);
		container_tabela.add(barra_rolagem);
		
		getFrame().add(container_tabela);
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", altura_janela - 105, largura_janela, altura_janela, frame);
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}

