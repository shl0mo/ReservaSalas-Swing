package reserva;

import java.sql.*;

public final class ConectarBD {
    public static Connection conecta () {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/reserva_salas";
            String username = "root";
            String password = "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Conectado ao banco de dados");
            Globais.conn = conn;
            return conn;
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Não foi possível conectar ao banco de dados");
        return null;
    }
}