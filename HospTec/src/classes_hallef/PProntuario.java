package classes_hallef;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Hallef.sud
 */
public class PProntuario {
    
    Conexao oBanco;
    
    public PProntuario() {
        oBanco = new Conexao();
    }
    
    public void incluir(EProntuario oEProntuario) {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();//aqui tá correto
        sql.append(" INSERT INTO tb_prontuario(data, descricao, receituario, paciente, medico)VALUES(?, ?, ?, ?, ?) ");
        try {
            Connection con = Conexao.getConexao();
            PreparedStatement stmt = con.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);

            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.sql.Date data = new java.sql.Date(fmt.parse(oEProntuario.getData()).getTime());

            stmt.setDate(1, data);
            stmt.setString(2, oEProntuario.getDescricao());
            stmt.setString(3, oEProntuario.getReceituario());
            stmt.setInt(4, oEProntuario.getIdPaciente());
            stmt.setInt(5, oEProntuario.getIdMedico());

            stmt.execute();

            //comando para pegar id gerado pelo banco de dados
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                oEProntuario.setId(rs.getInt("id"));
            }
            rs.close();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Erro ao incluir!");
            e.printStackTrace();
            
        } catch (ParseException ex) {
            Logger.getLogger(PProntuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(EProntuario oEProntuario) {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" UPDATE tb_prontuario SET data = ?, descricao = ?,receituario = ?, medico = ?, paciente = ? WHERE id = ? ");
        try {//data retorno foi tirado
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, oEProntuario.getData());
            preparedStatement.setString(2, oEProntuario.getDescricao());
            preparedStatement.setString(3, oEProntuario.getReceituario());
            preparedStatement.setInt(4, oEProntuario.getIdMedico());
            preparedStatement.setInt(5, oEProntuario.getIdPaciente());
            preparedStatement.setInt(6, oEProntuario.getId());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao alterar!");
            erro.printStackTrace();
        }
    }
    
    public void excluir(Integer cod) {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE FROM tb_prontuario WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao excluir!");
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EProntuario consultar(Integer cod) {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_prontuario WHERE id = ? ");
        EProntuario oEProntuario = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {//data = ?, descricao = ?,receituario = ?, medico = ?, paciente = ? WHERE id = ?
                oEProntuario = new EProntuario();
                oEProntuario.setId(resultSet.getInt("id"));
                oEProntuario.setData(resultSet.getString("data"));
                oEProntuario.setDescricao(resultSet.getString("descricao"));
                oEProntuario.setReceituario(resultSet.getString("receituario"));
                oEProntuario.setIdMedico(resultSet.getInt("medico"));
                oEProntuario.setIdPaciente(resultSet.getInt("paciente"));

            }

            preparedStatement.close();
            resultSet.close();
        }catch(SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao consultar!");
            erro.printStackTrace();
        }
        
        return oEProntuario;
    }
    
    public ArrayList<EProntuario> listar() {
        Connection connection = oBanco.getConexao();
        ArrayList<EProntuario> lista = new ArrayList<>();
        EProntuario oEProntuario = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_prontuario ORDER BY descricao ");
        try {//crm,nome,dt_nasc,especialidade,dt_admissao,salario
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while(resultSet.next()) {
                oEProntuario = new EProntuario();
                oEProntuario.setId(resultSet.getInt("id"));
                oEProntuario.setData(resultSet.getString("data"));
                oEProntuario.setDescricao(resultSet.getString("descricao"));
                oEProntuario.setReceituario(resultSet.getString("receituario"));
                oEProntuario.setIdMedico(resultSet.getInt("medico"));
                oEProntuario.setIdPaciente(resultSet.getInt("paciente"));
                lista.add(oEProntuario);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao listar!");
        }        
        return lista;
    }
    
    public ArrayList<LinkedHashMap<String, Object>> listagemCompleta() {
            Connection connection = oBanco.getConexao();
            LinkedHashMap<String, Object> item = new LinkedHashMap<>();
            ArrayList<LinkedHashMap<String,Object>> lista = new ArrayList<>();
        try {
            StringBuffer sql = new StringBuffer();
            sql.append("SELECT  tb_prontuario.id,");
            sql.append("        tb_medico.nome AS nomeMedico, ");
            sql.append("        tb_medico.id,  ");
            sql.append("        tb_paciente.nome AS nomePaciente, ");
            sql.append("        tb_paciente.id, ");
            sql.append("        tb_prontuario.descricao, ");
            sql.append("        tb_prontuario.receituario ");
            sql.append(" FROM tb_prontuario ");
            sql.append(" INNER join tb_medico ");
            sql.append("    ON tb_prontuario.medico = tb_medico.id ");
            sql.append(" INNER join tb_paciente ");
            sql.append("    ON tb_prontuario.paciente = tb_paciente.id ");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while(resultSet.next()) {
                item = new LinkedHashMap<>();
                item.put("id", resultSet.getString("id"));
                item.put("nomeMedico", resultSet.getString("nomeMedico"));
                item.put("nomePaciente", resultSet.getString("nomePaciente"));
                item.put("descricao", resultSet.getString("descricao"));
                item.put("receituario", resultSet.getString("receituario"));
                lista.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao listar!");
        }
        
        return lista;
    }
    
//    public static void main(String[] args) {
//        PProntuario oPPRontuario = new PProntuario();
//        ArrayList<EProntuario> lis = oPPRontuario.listar();
//        for(EProntuario ePaciente : lis){
//            System.out.println(ePaciente.getDescricao());
//
//        }
//    }
}
