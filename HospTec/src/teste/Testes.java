/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teste;

//import entidade.EMedico;
import entidade.EMedico;
import entidade.EPaciente;
import entidade.EProntuario;
import java.sql.Date;
import javax.swing.JOptionPane;
import pesistencia.PPaciente;
import pesistencia.PProntuario;

/**
 *
 * @author Onix
 */
public class Testes {

    public static void main(String[] args) throws Exception {
        EMedico eMed = new EMedico();
        EPaciente ePac = new EPaciente();
        eMed.setId(1);        
        ePac.setId(2);
        EProntuario ePr = new EProntuario("01/09/2017", "Teste 3",  "Teste 3", ePac, eMed);
        PProntuario per = new PProntuario();

        try {
            per.inserir(ePr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
//        EPaciente ePac = new EPaciente("Teste", "teste", "teste", "teste", "teste", "teste", "teste");
//        PPaciente pPac = new PPaciente();
//
//        pPac.incluir(ePac);
    }
}
