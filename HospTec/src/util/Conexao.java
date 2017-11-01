/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Onix
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
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto_cliente", "postgres", "root");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Classe não encontrada, adicione o driver nas bibliotecas.");
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Erro: " + e);
            throw new RuntimeException(e);
        }
        return con;
    }
}
