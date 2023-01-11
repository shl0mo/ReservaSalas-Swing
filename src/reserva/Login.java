package reserva;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
	private JFrame frame;
	
	public Login () {
		this.frame = new JFrame("Login");
		this.frame.setLayout(null);
		this.frame.setSize(400, 500);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo(this.frame);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(50, 70, 300, 300);
		panel.setBackground(Color.BLUE);
		
		JTextField campo_usuario = new JTextField("Usuário");
		campo_usuario.setBounds(70, 20, 100, 30);
		panel.add(campo_usuario);
		
		
		JPasswordField campo_senha = new JPasswordField("");
		campo_senha.setBounds(0, 70, 100, 30);
		//campo_senha.setHorizontalAlignment(JPasswordField.CENTER);
		panel.add(campo_senha, BorderLayout.CENTER);
		
		
		JButton botao = new JButton("Logar");
		botao.setBounds(50, 130, 130, 40);
		panel.add(botao);
		panel.setVisible(true);
		
		
		this.frame.add(panel);
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}