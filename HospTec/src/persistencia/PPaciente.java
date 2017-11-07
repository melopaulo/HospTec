package persistencia;

import util.Conexao;
import entidade.EPaciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Hallef.sud
 */
public class PPaciente {
    
    Conexao oBanco;
    
    public PPaciente() {
        oBanco = new Conexao();
    }
    
    public void incluir(EPaciente oPaciente) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO tb_paciente (nome,rg,cpf,endereco,dt_nasc,sexo,telefone) VALUES(?,?,?,?,?,?,?) ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, oPaciente.getNome());
            preparedStatement.setString(2, oPaciente.getRg());
            preparedStatement.setString(3, oPaciente.getCpf());
            preparedStatement.setString(4, oPaciente.getEndereco());
            preparedStatement.setString(5, oPaciente.getDataNascimento());
            preparedStatement.setString(6, oPaciente.getSexo());
            preparedStatement.setString(7, oPaciente.getTelefone());
            preparedStatement.execute();
            String sql2 = " SELECT currval('tb_paciente_id_seq') as codigo ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql2);

            if (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                oPaciente.setId(codigo);
            }
            preparedStatement.close();
            statement.close();;
            resultSet.close();
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void alterar(EPaciente oPaciente) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE tb_paciente SET nome = ?, rg = ?, cpf = ?, endereco = ?, dt_nasc = ?, sexo = ?, telefone = ? WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setString(1, oPaciente.getNome());
            preparedStatement.setString(2, oPaciente.getRg());
            preparedStatement.setString(3, oPaciente.getCpf());
            preparedStatement.setString(4, oPaciente.getEndereco());
            preparedStatement.setString(5, oPaciente.getDataNascimento());
            preparedStatement.setString(6, oPaciente.getSexo());
            preparedStatement.setString(7, oPaciente.getTelefone());
            preparedStatement.setInt(8, oPaciente.getId());
            preparedStatement.execute();
            preparedStatement.close();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
    }
    
    public void excluir(Integer cod) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE FROM tb_paciente WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public EPaciente consultar(Integer cod) throws SQLException {
        Connection connection = oBanco.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_paciente WHERE id = ? ");
        EPaciente oEPaciente = null;
        try{//nome,rg,cpf,endereco,dt_nasc,sexo,telefone
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, cod);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                oEPaciente = new EPaciente();
                oEPaciente.setId(resultSet.getInt("id"));
                oEPaciente.setNome(resultSet.getString("nome"));
                oEPaciente.setRg(resultSet.getString("rg"));
                oEPaciente.setCpf(resultSet.getString("cpf"));
                oEPaciente.setEndereco(resultSet.getString("endereco"));
                oEPaciente.setDataNascimento(resultSet.getString("dt_nasc"));
                oEPaciente.setSexo(resultSet.getString("sexo"));
                oEPaciente.setTelefone(resultSet.getString("telefone"));
            }

            preparedStatement.close();
            resultSet.close();
        }catch(SQLException erro) {
            erro.printStackTrace();
        }
        
        return oEPaciente;
    }
    
    public ArrayList<EPaciente> listar() throws SQLException {
        Connection connection = oBanco.getConexao();
        ArrayList<EPaciente> lista = new ArrayList<>();
        EPaciente ePaciente = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM tb_paciente ORDER BY nome ");
        try {//nome,rg,cpf,endereco,dt_nasc,sexo,telefone
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql.toString());
            while(resultSet.next()) {
                ePaciente = new EPaciente();
                ePaciente.setId(resultSet.getInt("id"));
                ePaciente.setNome(resultSet.getString("nome"));
                ePaciente.setRg(resultSet.getString("rg"));
                ePaciente.setCpf(resultSet.getString("cpf"));
                ePaciente.setEndereco(resultSet.getString("endereco"));
                ePaciente.setDataNascimento(resultSet.getString("dt_nasc"));
                ePaciente.setSexo(resultSet.getString("sexo"));
                ePaciente.setTelefone(resultSet.getString("telefone"));
                lista.add(ePaciente);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }        
        return lista;
    }
}