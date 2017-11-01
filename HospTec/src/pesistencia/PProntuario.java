/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesistencia;

import conexao.Conexao;
import entidade.EProntuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Onix
 */
public class PProntuario {

    public void inserir(EProntuario p) throws Exception {
        String sql = "INSERT INTO tb_prontuario(data, descricao, data_retorno, receituario, paciente, medico)VALUES(?, ?, ?, ?, ?, ?)";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, p.getData());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getData_retorno());
            stmt.setString(4, p.getReceituario());
            stmt.setInt(5, p.getPaciente().getId());
            stmt.setInt(6, p.getMedico().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            throw new Exception("Erro ao tentar Salvar. " + e.getCause());
        }
    }

    public EProntuario pesquisar(int id) throws Exception {
        String sql = "SELECT * FROM tb_prontuario WHERE id = ?";
        try {

        } catch (Exception e) {
            throw new Exception("Erro ao tentar Pesquisar. " + e.getCause());
        }
        return null;
    }

    public void alterar(EProntuario prontuario) throws Exception {
        String sql = "UPDATE tb_prontuario SET data = ?, descricao = ?, data_retorno = ?, receituario = ?, medico = ?, paciente = ? WHERE id = ?";

        try {

        } catch (Exception e) {
            throw new Exception("Erro ao tentar Alterar. " + e.getCause());
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM tb_prontuario WHERE id = ?";

        try {

        } catch (Exception e) {
            throw new Exception("Erro ao tentar Excluir. " + e.getCause());
        }
    }

    public ArrayList<EProntuario> listar() throws Exception {
        String sql = "SELECT * FROM tb_prontuario ORDER BY id";
        ArrayList<EProntuario> prontuarios = new ArrayList<>();

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//                EProntuario eP = new EProntuario(rs.getInt("id"), rs.getString("data"), rs.getString("descricao"),
//                        rs.getString("data_retorno"), rs.getInt("paciente"), rs.getInt("medico"));

//                prontuarios.add(eP);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            throw new Exception("Erro ao tentar Listar. " + e.getCause());
        }
        return null;
    }
}
