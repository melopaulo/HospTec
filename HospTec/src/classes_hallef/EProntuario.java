package classes_hallef;



/**
 *
 * @author Vicente
 */
public class EProntuario {

    private Integer id;
    private String data;
    private String descricao;
    private String receituario;
    private EMedico oEMedico;//deixa assim mesmo
    private EPaciente oEPaciente;
    private Integer idMedico;//quando faz isso, não foge da orientação a objetos não? não primeiro get e depois set
    private Integer idPaciente;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the receituario
     */
    public String getReceituario() {
        return receituario;
    }

    /**
     * @return the oEMedico
     */
    public EMedico getoEMedico() {
        return oEMedico;
    }

    /**
     * @return the oEPaciente
     */
    public EPaciente getoEPaciente() {
        return oEPaciente;
    }

    /**
     * @return the idMedico
     */
    public Integer getIdMedico() {
        return idMedico;
    }

    /**
     * @return the idPaciente
     */
    public Integer getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param receituario the receituario to set
     */
    public void setReceituario(String receituario) {
        this.receituario = receituario;
    }

    /**
     * @param oEMedico the oEMedico to set
     */
    public void setoEMedico(EMedico oEMedico) {
        this.oEMedico = oEMedico;
    }

    /**
     * @param oEPaciente the oEPaciente to set
     */
    public void setoEPaciente(EPaciente oEPaciente) {
        this.oEPaciente = oEPaciente;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
    
    
}
