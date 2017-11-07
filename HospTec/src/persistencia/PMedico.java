package persistencia;


import entidade.EMedico;
import persistencia.PPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexao;

/**
 * @author Hallef.sud
 */
public class PMedico {
    
    Conexao oBanco;
    
    public PMedico() {
        oBanco = new Conexao();
    }
    
    public void incluir(EMedico oEMedico) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO tb_medico (crm, nome, especialidade, salario, dt_nasc, admissao, demissao) VALUES(?,?,?,?,?,?,?) ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
             preparedStatement.setString(1, oEMedico.getCrm());
            preparedStatement.setString(2, oEMedico.getNome());
            preparedStatement.setString(3, oEMedico.getEspecialidade());
            preparedStatement.setBigDecimal(4, oEMedico.getSalario());
            preparedStatement.setString(5, oEMedico.getDataNascimento());
            preparedStatement.setString(6, oEMedico.getDataAdimissao());
            preparedStatement.setString(7, oEMedico.getDataDemissao());//perai....na insercao tem que estar na mesma posicao correto?
            preparedStatement.execute();
            String sql2 = " SELECT currval('tb_medico_id_seq') as codigo ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql2);

            if (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                oEMedico.setId(codigo);
            }
            preparedStatement.close();
            statement.close();;
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(EMedico oEMedico) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        
        sql.append(" UPDATE tb_medico SET crm = ?, nome = ?, especialidade = ?, salario = ?, dt_nasc = ?, admissao = ?, demissao = ? WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, oEMedico.getCrm());
            preparedStatement.setString(2, oEMedico.getNome());
            preparedStatement.setString(3, oEMedico.getEspecialidade());
            preparedStatement.setBigDecimal(4, oEMedico.getSalario());
            preparedStatement.setString(5, oEMedico.getDataNascimento());
            preparedStatement.setString(6, oEMedico.getDataAdimissao());
            preparedStatement.setString(7, oEMedico.getDataDemissao());
            preparedStatement.setInt(8, oEMedico.getId());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Integer cod) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE FROM tb_medico WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EMedico consultar(Integer cod) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_medico WHERE id = ? ");
        EMedico oEMedico = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                oEMedico = new EMedico();
                oEMedico.setId(resultSet.getInt("id"));
                oEMedico.setCrm(resultSet.getString("crm"));
                oEMedico.setNome(resultSet.getString("nome"));
                oEMedico.setEspecialidade(resultSet.getString("especialidade"));
                oEMedico.setSalario(resultSet.getBigDecimal("salario"));
                oEMedico.setDataNascimento(resultSet.getString("dt_nasc"));
                oEMedico.setDataAdimissao(resultSet.getString("admissao"));
                oEMedico.setDataDemissao(resultSet.getString("demissao"));
            }

            preparedStatement.close();
            resultSet.close();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        
        return oEMedico;
    }
    
    public ArrayList<EMedico> listar() throws SQLException {
        Connection connection = oBanco.getConexao();
        ArrayList<EMedico> lista = new ArrayList<>();
        EMedico oEMedico = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_medico ORDER BY nome ");
        try {//crm,nome,dt_nasc,especialidade,dt_admissao,salario
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while(resultSet.next()) {
                oEMedico = new EMedico();
                oEMedico.setId(resultSet.getInt("id"));
                oEMedico.setCrm(resultSet.getString("crm"));
                oEMedico.setNome(resultSet.getString("nome"));
                oEMedico.setEspecialidade(resultSet.getString("especialidade"));
                oEMedico.setSalario(resultSet.getBigDecimal("salario"));
                oEMedico.setDataNascimento(resultSet.getString("dt_nasc"));
                oEMedico.setDataAdimissao(resultSet.getString("admissao"));
                oEMedico.setDataDemissao(resultSet.getString("demissao"));
                lista.add(oEMedico);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }
}
