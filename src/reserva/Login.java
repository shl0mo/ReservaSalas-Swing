package reserva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
		panel.add(campo_senha);
		
		
		JButton botao_logar = Botao.ConstroiBotao("Botão Login", 200, largura_janela, altura_janela, frame);
		
		panel.setVisible(true);
		
		this.frame.add(panel);
		
		botao_logar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (campo_usuario.getText().equals("admin") && campo_senha.getText().equals("admin")) {
					if (Globais.admin_main == null) {
						Globais.admin_main  = new AdminMain();
						getFrame().setVisible(false);
						Globais.admin_main.getFrame().setVisible(true);
					} else {
						getFrame().setVisible(false);
						Globais.admin_main.getFrame().setVisible(true);
					}
				} else {
					
				}
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
	
}