package negocio;


import persistencia.PMedico;
import entidade.EMedico;
import java.sql.SQLException;
import java.util.ArrayList;


public class NMedico {

    private PMedico oPMedico;
    
    public NMedico() {
        oPMedico = new PMedico();
    }
    
    public void salvar(EMedico oEMedico) throws SQLException {
        if(oEMedico.getId() == null || oEMedico.getId().equals(0)) {
            oPMedico.incluir(oEMedico);
        }else {
            oPMedico.alterar(oEMedico);
        }
    }
    
    public void excluir(Integer cod) throws SQLException {
        oPMedico.excluir(cod);
    }
    
    public EMedico consultar(Integer cod) throws SQLException {
        return oPMedico.consultar(cod);
    }
    
    public ArrayList<EMedico> lista() throws SQLException {
        return oPMedico.listar();
    }
}
