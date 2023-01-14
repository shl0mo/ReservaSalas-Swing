package reserva;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Login extends JFrame {
	private JFrame frame;
	
	public Login () {
		final int largura_janela = 400;
		final int altura_janela = 300;
				
		this.frame = new JFrame("Login");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo(getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(2,1));
		container_campos.setBounds(50, 70, 300, 100);
		
		JTextField campo_usuario = TextField.ConstroiTextField("Usuário", container_campos);
		
		
		
		/*JLabel label_senha = new JLabel("Senha");
		label_senha.setBounds(0, 30, 400, 20);
		label_senha.setHorizontalAlignment(SwingConstants.CENTER);
		label_senha.setFont(new Font("Dialog", Font.BOLD, 16));
		container_campos.add(label_senha);
		
		JPasswordField campo_senha = new JPasswordField("");
		campo_senha.setBounds(0, 30, 100, 30);
		container_campos.add(campo_senha);*/
		
		
		JButton botao_logar = Botao.ConstroiBotao("Botão Login", 180, largura_janela, altura_janela, frame);
		
		container_campos.setVisible(true);
		
		this.frame.add(container_campos);
		
		botao_logar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (campo_usuario.getText().equals("admin") && campo_senha.getText().equals("admin")) {
					if (Globais.admin_main == null) {
						Globais.admin_main  = new AdminMenu();
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