package classes_hallef;


import java.util.ArrayList;


public class NPaciente {

    private PPaciente oPPaciente;
    
    public NPaciente() {
        oPPaciente = new PPaciente();
    }
    
    public void salvar(EPaciente oEPaciente) {
        if(oEPaciente.getId() == null || oEPaciente.getId().equals(0)) {
            oPPaciente.incluir(oEPaciente);
        }else {
            oPPaciente.alterar(oEPaciente);
        }
    }
    
    public void excluir(Integer cod) {
        oPPaciente.excluir(cod);
    }
    
    public EPaciente consultar(Integer cod) {
        return oPPaciente.consultar(cod);
    }
    
    public ArrayList<EPaciente> lista() {
        return oPPaciente.listar();
    }
}
