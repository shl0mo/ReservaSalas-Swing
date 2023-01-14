package reserva;

import java.awt.*;
import javax.swing.*;

public class ComboBox {
	
	public static JComboBox ConstroiComboBox (String conteudo_label, String[] opcoes, JFrame frame) {
		JPanel container_comboBox = new JPanel();
		container_comboBox.setLayout(new GridLayout(1, 2));
		container_comboBox.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_comboBox.add(label);
		
		JComboBox combo_box = new JComboBox(opcoes);
		container_comboBox.add(combo_box);
		
		frame.add(container_comboBox);
		return combo_box;
	}
	
	public static JComboBox ConstroiComboBox (String conteudo_label, String[] opcoes, JPanel panel) {
		JPanel container_comboBox = new JPanel();
		container_comboBox.setLayout(new GridLayout(1, 2));
		container_comboBox.setSize(400, 20);
		
		JLabel label = new JLabel(conteudo_label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Dialog", Font.BOLD, 16));
		container_comboBox.add(label);
		
		JComboBox combo_box = new JComboBox(opcoes);
		container_comboBox.add(combo_box);
		
		panel.add(container_comboBox);
		return combo_box;
	}
}
