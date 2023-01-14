package reserva;

import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class AdminMain extends JFrame {
	private JFrame frame;
	
	public AdminMain () {
		final int largura_janela = 400;
		final int altura_janela = 400;
		
		this.frame = new JFrame("Admin Main");
		getFrame().setLayout(new GridLayout(2, 1));
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo(getFrame());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 0, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(panel);
		
		JButton botao_cadastrar_usuario = Botao.ConstroiBotao ("Cadastrar Usuário", 0, largura_janela, altura_janela, panel);
		JButton botao_excluir_usuario = Botao.ConstroiBotao ("Excluir Usuário", 0, largura_janela, altura_janela, panel);
		JButton botao_cadastrar_sala = Botao.ConstroiBotao ("Cadastrar Sala", 0, largura_janela, altura_janela, panel);
		JButton botao_excluir_sala = Botao.ConstroiBotao ("Excluir Sala", 0, largura_janela, altura_janela, panel);
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
