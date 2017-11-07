package entidade;

import java.sql.Date;

/**
 *
 * @author Vicente
 */
public class EProntuario {

    private int id;
    private String data;
    private String descricao;
    private String receituario;
    private EMedico medico;
    private EPaciente paciente;

    
    public EProntuario(int id) {
        this.id = id;
    }

    public EProntuario(int id, String data, String descricao, String receituario, EPaciente paciente, EMedico medico) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.receituario = receituario;
        this.medico = medico;
        this.paciente = paciente;
    }

    public EProntuario(String data, String descricao,  String receituario, EPaciente paciente, EMedico medico) {
        this.data = data;
        this.descricao = descricao;
        this.receituario = receituario;
        this.medico = medico;
        this.paciente = paciente;
    }

    public EProntuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getReceituario() {
        return receituario;
    }
    public void setReceituario(String receituario) {
        this.receituario = receituario;
    }

    public EMedico getMedico() {
        return medico;
    }
    public void setMedico(EMedico medico) {
        this.medico = medico;
    }

    public EPaciente getPaciente() {
        return paciente;
    }
    public void setPaciente(EPaciente paciente) {
        this.paciente = paciente;
    }

}
