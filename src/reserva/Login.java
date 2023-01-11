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
		
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
