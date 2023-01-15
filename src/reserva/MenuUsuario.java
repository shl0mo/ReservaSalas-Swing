package reserva;

import java.awt.*;
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
		
	}
	
	public JFrame getFrame() {
		return this.frame;
	}
}
