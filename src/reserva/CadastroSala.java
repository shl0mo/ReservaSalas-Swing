package reserva;

import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class CadastroSala extends JFrame {
	
	private JFrame frame;
	
	public CadastroSala  () {
		final int largura_janela = 400;
		final int altura_janela = 470;
		
		this.frame = new JFrame("Cadastro de Sala");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Cadastro de Sala", frame);
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(5, 1, 0, 10));
		container_campos.setBounds(0, 90, largura_janela, 250);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		String[] tipos_salas = {"Sala de Reunião", "Auditório", "Labotoratório de Graduação"};
		ComboBox.ConstroiComboBox("Tipo", tipos_salas, container_campos);
		JTextField numero_sala = TextField.ConstroiTextField("Número", container_campos);
		JTextField bloco = TextField.ConstroiTextField("Bloco", container_campos);
		JTextField andar = TextField.ConstroiTextField("Andar", container_campos);
		
		JButton botao_cadastrar = Botao.ConstroiBotao("Cadastrar", 300, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 350, largura_janela, altura_janela, getFrame());
		
		getFrame().add(container_campos);

	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
