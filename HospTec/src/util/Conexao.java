package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicente
 */
public class Conexao {

    public Conexao() {
    }
    public static Connection con = null;

    public static Connection getConexao() throws SQLException {
        if (con == null) {
            con = Conectar();
        }
        return con;
    }

    private static Connection Conectar() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/senai", "postgres", "123456");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada, adicione o driver nas bibliotecas.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }
}
