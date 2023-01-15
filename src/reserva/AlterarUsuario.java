package reserva;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AlterarUsuario {
	private JFrame frame;
	
	public AlterarUsuario () {
		final int largura_janela = 400;
		final int altura_janela = 550;
		
		this.frame = new JFrame("Alteração de Usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Alteração de Usuário", getFrame());
		
		JPanel container_campos = new JPanel();
		container_campos.setLayout(new GridLayout(5, 1, 0, 10));
		container_campos.setBounds(0, 90, largura_janela, 250);
		container_campos.setBorder(BorderFactory.createEmptyBorder(0, 70, 0, 70));
		getFrame().add(container_campos);
		
		JTextField campo_nome = TextField.ConstroiTextField("Nome", container_campos);
		JTextField campo_sobrenome = TextField.ConstroiTextField("Sobrenome", container_campos);
		JTextField campo_usuario = TextField.ConstroiTextField("Usuário", container_campos);
		JTextField campo_senha = PasswordField.ConstroiPasswordField("Senha", container_campos);
		
		String[] opcoes = {"Professor", "Funcionário"};
		JComboBox campo_tipo = ComboBox.ConstroiComboBox("Tipo", opcoes, container_campos);
		
		JButton botao_alterar = Botao.ConstroiBotao("Alterar", 370, largura_janela, altura_janela, getFrame());
		JButton botao_voltar = Botao.ConstroiBotao("Voltar", 430, largura_janela, altura_janela, getFrame());
		
		try {
			Statement statement = Globais.conn.createStatement();
			ResultSet resultado = statement.executeQuery("SELECT * FROM usuarios WHERE id = " + Globais.id_alterar_usuario);
			while (resultado.next()) {
				campo_nome.setText(resultado.getString(2));
				campo_sobrenome.setText(resultado.getString(3));
				campo_usuario.setText(resultado.getString(4));
				if (resultado.getString(5).equals("Professor")) {
					campo_tipo.setSelectedIndex(0);
				} else {
					campo_tipo.setSelectedIndex(1);
				}
				campo_senha.setText(resultado.getString(6));
			}
		} catch (Exception ioe) {
			ioe.printStackTrace();
		}
		
		
		botao_alterar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				String nome = campo_nome.getText();
				String sobrenome = campo_sobrenome.getText();
				String usuario = campo_usuario.getText();
				String senha = campo_senha.getText();
				String tipo = (String)campo_tipo.getSelectedItem();
				if (nome.equals("") || sobrenome.equals("") || usuario.equals("") || senha.equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos");
					return;
				}
				try {
					Statement statement = Globais.conn.createStatement();
					statement.execute("UPDATE usuarios SET nome = '" + nome +"', sobrenome = '" + sobrenome + "', usuario = '" + usuario + "', tipo = '" + tipo + "', senha = '" + senha + "' WHERE id = " + Globais.id_alterar_usuario);
					JOptionPane.showMessageDialog(null, "Alteração realizada");
				} catch (Exception ioe) {
					ioe.printStackTrace();
				}
			}
		});
		
		botao_voltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrame().setVisible(false);
				Globais.selecionar_id_usuario.getFrame().setVisible(true);
			}
		});
	}
	
	
	public JFrame getFrame () {
		return this.frame;
	}
}
