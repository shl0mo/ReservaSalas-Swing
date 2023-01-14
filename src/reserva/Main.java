package reserva;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	
	public static void main (String args[]) {
		//ConectarBD.conecta();
		Login nova_janela = new Login();
		nova_janela.getFrame().setVisible(true);
		/*AdminMain admin_main = new AdminMain();
		admin_main.getFrame().setVisible(true);*/
	}
}
