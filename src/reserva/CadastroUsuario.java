package reserva;

import java.awt.*;
import javax.swing.*;

import reserva.TextField;

public class CadastroUsuario {
	private JFrame frame;
	
	public CadastroUsuario () {
		final int largura_janela = 400;
		final int altura_janela = 500;
		
		this.frame = new JFrame("Cadastro de usuário");
		getFrame().setLayout(null);
		getFrame().setSize(largura_janela, altura_janela);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Titulo.adicionaTitulo("Cadastro de Usuários", getFrame());
		
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
		
		JButton botao_cadastrar = Botao.ConstroiBotao("Cadastrar", 370, largura_janela, altura_janela, getFrame());
		
	}
	
	public JFrame getFrame () {
		return this.frame;
	}
}
