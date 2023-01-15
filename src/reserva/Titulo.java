package reserva;

import java.awt.*;
import javax.swing.*;

public class Titulo {
	public static void adicionaTitulo (String conteudo_titulo, JFrame janela) {
		JLabel titulo = new JLabel(conteudo_titulo);
		titulo.setBounds(0, 30, 400, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Dialog", Font.BOLD, 16));
		janela.add(titulo);
	}
	
	public static void adicionaTitulo (String conteudo_titulo, int largura_janela, JFrame janela) {
		JLabel titulo = new JLabel(conteudo_titulo);
		titulo.setBounds(largura_janela/2 - 200, 30, 400, 20);
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setFont(new Font("Dialog", Font.BOLD, 16));
		janela.add(titulo);
	}
}
