package reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import reserva.TextField;

import java.sql.*;

public class Relatorio extends JFrame {
	private JFrame frame;
	
	public Relatorio () {
		final int largura_janela = 500;
		final int altura_janela = 410;
		
		this.frame = new JFrame("Relatório");
		this.frame.setLayout(null);
		this.frame.setBounds(0, 0, largura_janela, altura_janela);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Relatório de Reservas", largura_janela, frame);
		
		JPanel container_busca_id = new JPanel();
		container_busca_id.setLayout(new GridLayout(1, 3));
		container_busca_id.setBounds(50, 60, 400, 40);
		container_busca_id.setBackground(Color.BLACK);
		
		JPanel container_tabela = new JPanel();
		container_tabela.setLayout(new GridLayout(1, 1));
		container_tabela.setBounds(0, 130, 487, 150);
		container_tabela.setBackground(Color.BLACK);
		getFrame().add(container_tabela);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Reservada por");
		model.addColumn("Data");
		
		JTable tabela = new JTable(model);
		JScrollPane barra_rolagem = new JScrollPane(tabela);
		container_tabela.add(barra_rolagem);
		
		
		JTextField id_sala = TextField.ConstroiTextField("Id da sala", container_busca_id);
		JButton botao_gerar_relatorio = Botao.ConstroiBotao("Gerar relatório", 300, largura_janela, altura_janela, container_busca_id);
		
		getFrame().add(container_busca_id);
		
		
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", altura_janela - 105, largura_janela, altura_janela, frame);
		
		botao_gerar_relatorio.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				if (id_sala.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o Id da Sala para gerar o relatório");
				}
				model.setRowCount(0);
				try {
					Statement statement = Globais.conn.createStatement();
					ResultSet resultado = statement.executeQuery("SELECT * FROM salas WHERE id = " + id_sala.getText());
					int quantidade_linhas = 0;
					while (resultado.next()) quantidade_linhas++;
					if (quantidade_linhas == 0) {
						JOptionPane.showMessageDialog(null, "Não existe sala cadastrada com o Id solicitado");
						return;
					}
					boolean sem_reservas = true; 
					resultado = statement.executeQuery("SELECT b.nome, b.sobrenome, a.data\r\n"
							+ "FROM (SELECT * FROM reservas WHERE id_sala = " + id_sala.getText() + ") AS a\r\n"
							+ "JOIN usuarios AS b\r\n"
							+ "ON a.id_usuario = b.id");
					while (resultado.next()) {
						sem_reservas = false;
						model.addRow(new Object[] {resultado.getString(1) + " " + resultado.getString(2), resultado.getString(3)});						
					}
					if (sem_reservas) {
						JOptionPane.showMessageDialog(null, "Sala sem reservas");
					}
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
		botao_voltar.addActionListener (new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				getFrame().setVisible(false);
				if (Globais.usuario.equals("admin")) {
					Globais.admin_main.getFrame().setVisible(true);
				} else {
					Globais.menu_usuario.getFrame().setVisible(true);
				}
			}
		});
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
