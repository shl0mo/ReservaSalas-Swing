package reserva;

import java.awt.*;
import javax.swing.*;

public class Titulo {
	public static void adicionaTitulo (JFrame janela) {
		JLabel titulo = new JLabel("Sistema de Reserva de Salas do IComp");
		titulo.setBounds(0, 30, 400, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Dialog", Font.BOLD, 16));
		janela.add(titulo);
	}
}
