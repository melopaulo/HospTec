package classes_hallef;


import java.util.ArrayList;
import java.util.LinkedHashMap;


public class NProntuario {

    private PProntuario oPProntuario;
    
    public NProntuario() {
        oPProntuario = new PProntuario();
    }
    
    public void salvar(EProntuario oEProntuario) {
        if(oEProntuario.getId() == null || oEProntuario.getId().equals(0)) {
            oPProntuario.incluir(oEProntuario);
        }else {
            oPProntuario.alterar(oEProntuario);
        }
    }
    
    public void excluir(Integer cod) {
        oPProntuario.excluir(cod);
    }
    
    public EProntuario consultar(Integer cod) {
        return oPProntuario.consultar(cod);
    }
    
    public ArrayList<EProntuario> lista() {
        return oPProntuario.listar();
    }
    
    public ArrayList<LinkedHashMap<String, Object>> listageCompleta() {
        return oPProntuario.listagemCompleta();
    }
}
