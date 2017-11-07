package apresentacao;


import util.Forms;
import negocio.NMedico;
import entidade.EMedico;
import java.math.BigDecimal;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class CadastraMedico extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public CadastraMedico() {
        initComponents();
    }

    public CadastraMedico(JDesktopPane parametro) {
        this();
        this.pnlPrincipal = parametro;
    }

    public CadastraMedico(JDesktopPane parametro, EMedico tipo) {
        this(parametro);
        preencherTela(tipo);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        //jtxtRg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtextCrm = new javax.swing.JTextField();
        jtextNome = new javax.swing.JTextField();
        jtextDtNasc = new javax.swing.JTextField();
        jtextEspecialidade = new javax.swing.JTextField();
        jtextDtadmissao = new javax.swing.JTextField();
        jtextDtdemissao = new javax.swing.JTextField();
        jtextSalario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Médico");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExcluir.setText("Excluir");
        btnExcluir.setEnabled(false);
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        jLabel1.setText("Identificador");
        jLabel1.setToolTipText("");

        txtIdentificador.setEditable(false);
        txtIdentificador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel2.setText("CRM");
        jLabel2.setToolTipText("");

        jLabel4.setText("Nome");

        jLabel5.setText("Data/Nas");

        jLabel6.setText("Especialidade");

        jLabel7.setText("Data/Admissão");

        jLabel8.setText("Salário");

        jLabel9.setText("Data/Demissão");
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtextCrm)
                    .addComponent(jtextNome)
                    .addComponent(jtextDtNasc)
                    .addComponent(jtextEspecialidade)
                    .addComponent(jtextDtadmissao)
                    .addComponent(jtextDtdemissao)
                    .addComponent(jtextSalario))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)

                            .addComponent(jtextCrm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
//                            .addComponent(jtxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                .addComponent(jtextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextEspecialidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextDtadmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextDtdemissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalvar)
                    .addComponent(btnExcluir)
                    .addComponent(btnLimpar)
                    .addComponent(btnFechar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            EMedico oEMedico = new EMedico();
            oEMedico.setCrm(jtextCrm.getText());
            oEMedico.setNome(jtextNome.getText());
            oEMedico.setDataNascimento(jtextDtNasc.getText());
            oEMedico.setEspecialidade(jtextEspecialidade.getText());
            oEMedico.setDataAdimissao(jtextDtadmissao.getText());
            oEMedico.setDataDemissao(jtextDtdemissao.getText());
            oEMedico.setSalario(BigDecimal.valueOf(Double.valueOf(jtextSalario.getText())));

            if (!txtIdentificador.getText().isEmpty()) {
                oEMedico.setId(Integer.parseInt(txtIdentificador.getText()));
            }

            NMedico oNMedico = new NMedico();
            oNMedico.salvar(oEMedico);

            JOptionPane.showMessageDialog(null, "Operação efetuada com "+ "sucesso!");

            limparTela();
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                         

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {

            int resposta = JOptionPane.showConfirmDialog(null,"Confirma a exclusão do 'Médico'?", "Sistema Hostipal", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {

                NMedico oNMedico = new NMedico();
                oNMedico.excluir(Integer.parseInt(txtIdentificador.getText()));
                JOptionPane.showMessageDialog(null,"Operação efetuada com sucesso!");

                limparTela();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                          

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {

            limparTela();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                         

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {                                          
        dispose();
    }                                         

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        try {

            PesquisarMedico janela = new PesquisarMedico(pnlPrincipal);
            pnlPrincipal.add(janela);
            janela.setVisible(true);
            Forms.centraliza(janela);

            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jtextCrm;
    private javax.swing.JTextField jtextNome;
    private javax.swing.JTextField jtextDtNasc;
    private javax.swing.JTextField jtextEspecialidade;
    private javax.swing.JTextField jtextDtadmissao;
    private javax.swing.JTextField jtextDtdemissao;
    private javax.swing.JTextField jtextSalario;
    //private javax.swing.JTextField jtxtRg;
    private javax.swing.JTextField txtIdentificador;
    // End of variables declaration                   

    private void preencherTela(EMedico tipo) {
        try {
            txtIdentificador.setText(tipo.getId()+ "");
            jtextCrm.setText(String.valueOf(tipo.getCrm()));
            jtextNome.setText(tipo.getNome());
            jtextDtNasc.setText(tipo.getDataNascimento());
            jtextEspecialidade.setText(tipo.getEspecialidade());
            jtextDtadmissao.setText(tipo.getDataAdimissao());
            jtextDtdemissao.setText(tipo.getDataDemissao());
            jtextSalario.setText(String.valueOf(tipo.getSalario()));
            btnExcluir.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void limparTela() {

        txtIdentificador.setText("");
        jtextCrm.setText("");
        jtextNome.setText("");
        jtextDtNasc.setText("");
        jtextEspecialidade.setText("");
        jtextDtadmissao.setText("");
        jtextDtdemissao.setText("");
        jtextSalario.setText("");
        btnExcluir.setEnabled(false);

        jtextCrm.requestFocus();
    }
}
