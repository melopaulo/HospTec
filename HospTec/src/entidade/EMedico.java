package entidade;


import java.math.BigDecimal;

/**
 * @author Hallef.sud
 */

public class EMedico {
    
    private Integer id;
    private String crm;
    private String nome;
    private String dataNascimento;
    private String especialidade;
    private String dataAdimissao;
    private String dataDemissao;
    private BigDecimal salario;

    public EMedico() {
    }

    public EMedico(Integer id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @return the crm
     */
    public String getCrm() {
        return crm;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the dataNascimento
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @return the especialidade
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * @return the dataAdimissao
     */
    public String getDataAdimissao() {
        return dataAdimissao;
    }

    /**
     * @return the salario
     */
    public BigDecimal getSalario() {
        return salario;
    }
    
    public String getDataDemissao() {
        return dataDemissao;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @param crm the crm to set
     */
    public void setCrm(String crm) {
        this.crm = crm;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @param especialidade the especialidade to set
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * @param dataAdimissao the dataAdimissao to set
     */
    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }    

    

    public void setDataDemissao(String dataDemissao) {
        this.dataDemissao = dataDemissao;
    }
    
}
