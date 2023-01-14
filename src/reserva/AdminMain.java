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
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo(getFrame());
		
		JButton botao_cadastrar_usuario = new JButton("Cadastrar usuário");
		
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
