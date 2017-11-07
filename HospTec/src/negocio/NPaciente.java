package negocio;


import entidade.EPaciente;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.PPaciente;


public class NPaciente {

    private PPaciente oPPaciente;
    
    public NPaciente() {
        oPPaciente = new PPaciente();
    }
    
    public void salvar(EPaciente oEPaciente) throws SQLException {
        if(oEPaciente.getId() == null || oEPaciente.getId().equals(0)) {
            oPPaciente.incluir(oEPaciente);
        }else {
            oPPaciente.alterar(oEPaciente);
        }
    }
    
    public void excluir(Integer cod) throws SQLException {
        oPPaciente.excluir(cod);
    }
    
    public EPaciente consultar(Integer cod) throws SQLException {
        return oPPaciente.consultar(cod);
    }
    
    public ArrayList<EPaciente> lista() throws SQLException {
        return oPPaciente.listar();
    }
}
