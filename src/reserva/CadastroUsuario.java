package reserva;

import java.awt.*;
import javax.swing.*;

import javax.swing.JFrame;

public class CadastroUsuario {
	private JFrame frame;
	
	public CadastroUsuario () {
		this.frame = new JFrame("Cadastro de usuário");
		getFrame().setLayout(null);
		getFrame().setSize(400, 500);
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
