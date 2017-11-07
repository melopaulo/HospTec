package apresentacao;


import util.Forms;
import negocio.NPaciente;
import entidade.EPaciente;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;

public class CadastroPaciente extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public CadastroPaciente() {
        initComponents();
    }

    public CadastroPaciente(JDesktopPane parametro) {
        this();
        this.pnlPrincipal = parametro;
    }

    public CadastroPaciente(JDesktopPane parametro, EPaciente tipo) {
        this(parametro);
        preencherTela(tipo);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jtextNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnLimpar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jtxtRg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtIdentificador = new javax.swing.JTextField();
        btnPesquisar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtextCpf = new javax.swing.JTextField();
        jtextEndereco = new javax.swing.JTextField();
        jtextData = new javax.swing.JTextField();
        jtextSexo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtextTel = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Cadastro de Tipo Associado");

        jLabel3.setText("Rg");
        jLabel3.setToolTipText("");

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

        jLabel2.setText("Nome");
        jLabel2.setToolTipText("");

        jLabel4.setText("CPF");

        jLabel5.setText("Endereço");

        jLabel6.setText("Data/nasc");

        jLabel7.setText("Sexo");

        jLabel8.setText("Tel");

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
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)//aqui s[ tem 1
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtextNome)
                    .addComponent(jtextTel)
                    .addComponent(jtxtRg)
                    .addComponent(jtextCpf)
                    .addComponent(jtextEndereco)
                    .addComponent(jtextData)
                    .addComponent(jtextSexo))
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
                            .addComponent(jtextNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtextCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtextEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtextTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            EPaciente tipoAssociado = new EPaciente();
            tipoAssociado.setNome(jtextNome.getText());
            tipoAssociado.setRg(jtxtRg.getText());
            tipoAssociado.setCpf(jtextCpf.getText());
            tipoAssociado.setEndereco(jtextEndereco.getText());
            tipoAssociado.setDataNascimento(jtextData.getText());
            tipoAssociado.setSexo(jtextSexo.getText());
            tipoAssociado.setTelefone(jtextTel.getText());

            if (!txtIdentificador.getText().isEmpty()) {
                tipoAssociado.setId(Integer.parseInt(txtIdentificador.getText()));
            }

            NPaciente negocio = new NPaciente();
            negocio.salvar(tipoAssociado);

            JOptionPane.showMessageDialog(null, "Operação efetuada com "+ "sucesso!");

            limparTela();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                         

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {                                           
        try {

            int resposta = JOptionPane.showConfirmDialog(null,"Confirma a exclusão do 'Paciente'?", "Sistema Hostipal", JOptionPane.YES_NO_OPTION);

            if (resposta == JOptionPane.YES_OPTION) {

                NPaciente negocio = new NPaciente();
                negocio.excluir(Integer.parseInt(
                        txtIdentificador.getText()));

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

            PesquisarPaciente janela = new PesquisarPaciente(pnlPrincipal);
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
    private javax.swing.JTextField jtextCpf;
    private javax.swing.JTextField jtextData;
    private javax.swing.JTextField jtextEndereco;
    private javax.swing.JTextField jtextNome;
    private javax.swing.JTextField jtextSexo;
    private javax.swing.JTextField jtextTel;
    private javax.swing.JTextField jtxtRg;
    private javax.swing.JTextField txtIdentificador;
    // End of variables declaration                   

    private void preencherTela(EPaciente tipo) {
        try {
            txtIdentificador.setText(tipo.getId()+ "");
            jtextNome.setText(tipo.getNome());
            jtxtRg.setText(tipo.getRg()+ "");
            jtextCpf.setText(tipo.getCpf());
            jtextEndereco.setText(tipo.getEndereco());
            jtextData.setText(tipo.getDataNascimento());
            jtextSexo.setText(tipo.getSexo());
            jtextTel.setText(tipo.getTelefone());
            btnExcluir.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void limparTela() {

        txtIdentificador.setText("");
        jtextNome.setText("");
        jtxtRg.setText("");

        btnExcluir.setEnabled(false);

        jtextNome.requestFocus();
    }
}
