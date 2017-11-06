package classes_hallef;


import java.util.ArrayList;


public class NMedico {

    private PMedico oPMedico;
    
    public NMedico() {
        oPMedico = new PMedico();
    }
    
    public void salvar(EMedico oEMedico) {
        if(oEMedico.getId() == null || oEMedico.getId().equals(0)) {
            oPMedico.incluir(oEMedico);
        }else {
            oPMedico.alterar(oEMedico);
        }
    }
    
    public void excluir(Integer cod) {
        oPMedico.excluir(cod);
    }
    
    public EMedico consultar(Integer cod) {
        return oPMedico.consultar(cod);
    }
    
    public ArrayList<EMedico> lista() {
        return oPMedico.listar();
    }
}
