package negocio;

import entidade.EProntuario;
import persistencia.PProntuario;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Hallef
 */
public class NProntuario {
    
    private PProntuario pPrn;
    
    public NProntuario() {
        pPrn = new PProntuario();
    }
    
    public void salvar(EProntuario pPrn) throws Exception {
        if(pPrn.getId() == 0) {
            new PProntuario().inserir(pPrn);
        }else {
            new PProntuario().alterar(pPrn);
        }
    }
    
    public void excluir(int cod) throws Exception {
        pPrn.excluir(cod);
    }
    
    public EProntuario consultar(int cod) throws Exception {
        return pPrn.pesquisar(cod);
    }
    
    public ArrayList<EProntuario> lista() throws Exception {
        return pPrn.listar();
    }
    
    public ArrayList<EProntuario> listageCompleta() throws Exception {
        return new PProntuario().listar();
    }
    
    
}
