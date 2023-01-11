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
		JButton botao = new JButton("Botao");
		botao.setSize(130, 40);
		panel.add(botao);
		panel.setVisible(true);
		
		this.frame.add(panel);
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
