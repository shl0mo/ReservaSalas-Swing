package reserva;

import java.awt.*;
import javax.swing.*;

public class TextField {
	
	public static JTextField ConstroiTextField (String conteudo_label, JFrame frame) {
		JPanel container_textField = new JPanel();
		container_textField.setLayout(new GridLayout(1, 2));
		container_textField.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_textField.add(label);
		
		JTextField campo = new JTextField();
		campo.setBounds(70, 20, 100, 30);
		container_textField.add(campo);
		
		frame.add(container_textField);
		
		return campo;
	}
	
	public static JTextField ConstroiTextField (String conteudo_label, JPanel panel) {
		JPanel container_textField = new JPanel();
		container_textField.setLayout(new GridLayout(1, 2));
		container_textField.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_textField.add(label);
		
		JTextField campo = new JTextField();
		campo.setBounds(70, 20, 100, 30);
		container_textField.add(campo);
		
		panel.add(container_textField);
		
		return campo;
	}
}
