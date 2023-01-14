package reserva;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	
	public static void main (String args[]) {
		//ConectarBD.conecta();
		Globais.login = new Login();
		Globais.login.getFrame().setVisible(true);
		//AdminMain admin_main = new AdminMain();
		//admin_main.getFrame().setVisible(true);
	}
}
