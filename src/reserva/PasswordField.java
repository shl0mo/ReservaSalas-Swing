package reserva;

import java.awt.*;
import javax.swing.*;


public class PasswordField {
	
	public static JPasswordField ConstroiPasswordField (String conteudo_label, JFrame frame) {
		JPanel container_passwordField = new JPanel();
		container_passwordField.setLayout(new GridLayout(1, 2));
		container_passwordField.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_passwordField.add(label);
		
		JPasswordField campo_senha = new JPasswordField("");
		campo_senha.setBounds(0, 30, 100, 30);
		container_passwordField.add(campo_senha);
		
		frame.add(container_passwordField);
		
		return campo_senha;
	}
	
	public static JPasswordField ConstroiPasswordField (String conteudo_label, JPanel panel) {
		JPanel container_passwordField = new JPanel();
		container_passwordField.setLayout(new GridLayout(1, 2));
		container_passwordField.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_passwordField.add(label);
		
		JPasswordField campo_senha = new JPasswordField("");
		campo_senha.setBounds(0, 30, 100, 30);
		container_passwordField.add(campo_senha);
		
		panel.add(container_passwordField);
		
		return campo_senha;
	}
}
