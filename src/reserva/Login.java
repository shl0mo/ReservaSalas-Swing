package reserva;

import java.awt.*;
import javax.swing.*;

public class Login extends JFrame {
	private JFrame frame;
	
	public Login () {
		final int largura_janela = 400;
		final int altura_janela = 500;
				
		this.frame = new JFrame("Login");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo(getFrame());
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2,2));
		panel.setBounds(50, 70, 300, 100);
		panel.setBackground(Color.RED);
		
		JLabel label_usuario = new JLabel("Usuário");
		label_usuario.setBounds(0, 30, 400, 20);
		label_usuario.setHorizontalAlignment(SwingConstants.CENTER);
		label_usuario.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(label_usuario);
		
		JTextField campo_usuario = new JTextField();
		campo_usuario.setBounds(70, 20, 100, 30);
		panel.add(campo_usuario);
		
		JLabel label_senha = new JLabel("Senha");
		label_senha.setBounds(0, 30, 400, 20);
		label_senha.setHorizontalAlignment(SwingConstants.CENTER);
		label_senha.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(label_senha);
		
		JPasswordField campo_senha = new JPasswordField("");
		campo_senha.setBounds(0, 30, 100, 30);
		//campo_senha.setHorizontalAlignment(JPasswordField.CENTER);
		panel.add(campo_senha);
		
		JPanel container_botao = new JPanel();
		container_botao.setLayout(new GridLayout());
		container_botao.setBounds(largura_janela/4, 200, largura_janela/2, 40);
		container_botao.setBackground(Color.BLUE);
		
		getFrame().add(container_botao);
		
		JButton botao = new JButton("Logar");
		botao.setBounds(0, 0, 130, 40);
		container_botao.add(botao, BorderLayout.CENTER);
		panel.setVisible(true);
		
		
		this.frame.add(panel);
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}