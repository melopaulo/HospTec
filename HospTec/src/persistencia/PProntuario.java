package persistencia;

import entidade.EMedico;
import entidade.EPaciente;
import util.Conexao;
import entidade.EProntuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vicente
 */
public class PProntuario {
    
    EProntuario ePr = null;
    
    public void inserir(EProntuario ePr) throws Exception {
        String sql = "INSERT INTO tb_prontuario(data, descricao, receituario, paciente, medico)VALUES(?, ?, ?, ?, ?)";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            java.util.Date dataJava = new java.util.Date();//pega data atual do sistema
            java.sql.Date dataSql= new java.sql.Date(dataJava.getTime());//converte a data para sql
            
            stmt.setDate(1, dataSql);
            stmt.setString(2, ePr.getDescricao());
            stmt.setString(3, ePr.getReceituario());
            stmt.setInt(4, ePr.getPaciente().getId());
            stmt.setInt(5, ePr.getMedico().getId());

            stmt.execute();

            //comando para pegar id gerado pelo banco de dados
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                ePr.setId(rs.getInt("id"));
            }
            rs.close();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (Exception e) {
            throw new Exception("Erro ao incluir");
        }
    }

    public EProntuario pesquisar(int id) throws Exception {        //eu parei aqui no pesquisar
        String sql = "SELECT * FROM tb_prontuario WHERE id = ?";

        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                PPaciente pPac = new PPaciente();
                PMedico pMed = new PMedico();
                ePr = new EProntuario(rs.getInt("id"), rs.getString("data"), rs.getString("descricao"),
                        rs.getString("receituario"), new PPaciente().consultar(rs.getInt("paciente")),
                        new PMedico().consultar(rs.getInt("medico")));
            }
        } catch (Exception e) {
            throw new Exception("Erro ao pesquisar");
        }
        return ePr;
    }

    public void alterar(EProntuario ePr) throws Exception {
        String sql = "UPDATE tb_prontuario SET data = ?, descricao = ?, data_retorno = ?, receituario = ?, medico = ?, paciente = ? WHERE id = ?";
//não te falei, que parei no pesquisar, p ra exlcuir eu preciso saber o que né?rsrs
        try {

        } catch (Exception e) {
            throw new Exception("Erro ao alterar");
        }
    }

    public void excluir(int id) throws Exception {
        String sql = "DELETE FROM tb_prontuario WHERE id = ?";

        try {

        } catch (Exception e) {
            throw new Exception("Erro ao excluir");
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
                EMedico eMed = new EMedico(rs.getInt("medico"));
                EPaciente ePac = new EPaciente();
                ePac.setId(rs.getInt("paciente"));

                ePr = new EProntuario(rs.getInt("id"), rs.getString("data"), rs.getString("descricao"),
                        rs.getString("receituario"), new PPaciente().consultar(rs.getInt("paciente")),
                        new PMedico().consultar(rs.getInt("medico")));

                prontuarios.add(ePr);
            }

            stmt.close();
            rs.close();
        } catch (Exception e) {
            throw new Exception("Erro ao listar");
        }
        return prontuarios;
    }
}
