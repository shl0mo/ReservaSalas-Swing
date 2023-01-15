package reserva;

import java.sql.Connection;

public class Globais {
	public static Connection conn;
	public static Login login = null;
	public static MenuAdmin admin_main = null;
	public static CadastroUsuario cadastro_usuario = null;
	public static ExclusaoUsuario exclusao_usuario = null;
	public static CadastroSala cadastro_sala = null;
	public static ExclusaoSala exclusao_sala = null;
	public static MenuUsuario menu_usuario = null;
	public static ReservarSala reservar_sala = null;
	public static ConsultarSalas consultar_salas = null;
	public static int id_usuario = 0;
	public static String usuario = "";
}
