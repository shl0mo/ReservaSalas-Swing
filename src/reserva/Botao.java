package reserva;

import java.awt.*;
import javax.swing.*;

public class Botao {
	
	public static JButton ConstroiBotao (String label_botao, int y, int largura_janela, int altura_janela, JPanel panel) {
		JPanel container_botao = new JPanel();
		container_botao.setLayout(new GridLayout());
		container_botao.setBounds(largura_janela/4, y, largura_janela/2, 40);
		JButton botao = new JButton(label_botao);
		container_botao.add(botao, BorderLayout.CENTER);
		panel.add(container_botao);
		return botao;
	}
	
	public static JButton ConstroiBotao (String label_botao, int y, int largura_janela, int altura_janela, JFrame frame) {
		JPanel container_botao = new JPanel();
		container_botao.setLayout(new GridLayout());
		container_botao.setBounds(largura_janela/4, y, largura_janela/2, 40);
		JButton botao = new JButton(label_botao);
		container_botao.add(botao, BorderLayout.CENTER);
		frame.add(container_botao);
		return botao;
	}
}
