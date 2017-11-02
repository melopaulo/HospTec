package pesistencia;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import entidade.EPaciente;

/**
 * @author Hallef.sud
 */
public class PPaciente {
    
    public void incluir(EPaciente oPaciente) throws SQLException, Exception {
        Connection connection = Conexao.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" INSERT INTO paciente (nome,rg,cpf,endereco,dt_nasc,sexo,telefone) VALUES(?,?,?,?,?,?,?) ");
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
            String sql2 = " SELECT currval('paciente_id_seq') as codigo ";
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
            throw new Exception("Erro ao incluir");
        }
    }
    
    public void alterar(EPaciente oPaciente) throws SQLException, Exception {
        Connection connection = Conexao.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" UPDATE paciente SET nome = ?, rg = ?, cpf = ?, endereco = ?, dt_nasc = ?, sexo = ?, telefone = ? WHERE id = ? ");
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
            throw new Exception("Erro ao alterar");
        }
    }
    
    public void excluir(EPaciente oEPaciente) throws SQLException, Exception {
        Connection connection = Conexao.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" DELETE FROM paciente WHERE id = ? ");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            preparedStatement.setInt(1, oEPaciente.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Erro ao excluir");
        }
    }
    
    public EPaciente consultar(EPaciente oPaciente) throws SQLException, Exception {
        Connection connection = Conexao.getConexao();
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM paciente WHERE id = ? ");
        try{//nome,rg,cpf,endereco,dt_nasc,sexo,telefone
            PreparedStatement preparedStatement = connection.prepareStatement(sql.toString());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                oPaciente.setId(resultSet.getInt("id"));
                oPaciente.setNome(resultSet.getString("nome"));
                oPaciente.setRg(resultSet.getString("rg"));
                oPaciente.setCpf(resultSet.getString("cpf"));
                oPaciente.setEndereco(resultSet.getString("endereco"));
                oPaciente.setDataNascimento(resultSet.getString("dt_nasc"));
                oPaciente.setSexo(resultSet.getString("sexo"));
                oPaciente.setTelefone(resultSet.getString("telefone"));
            }
            preparedStatement.setInt(1, oPaciente.getId());
            preparedStatement.close();
            resultSet.close();
        }catch(SQLException erro) {
            throw new Exception("Erro ao pesquisar");
        }
        
        return oPaciente;
    }
    
    public ArrayList<EPaciente> listar() throws SQLException, Exception {
        Connection connection = Conexao.getConexao();
        ArrayList<EPaciente> lista = new ArrayList<>();
        EPaciente ePaciente = null;
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT * FROM paciente ORDER BY nome ");
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
            throw new Exception("Erro ao listar.");
        }        
        return lista;
    }
}
