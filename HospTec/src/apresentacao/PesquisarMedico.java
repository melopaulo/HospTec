package apresentacao;


import apresentacao.CadastraMedico;
import util.Forms;
import negocio.NMedico;
import persistencia.PMedico;
import entidade.EMedico;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesquisarMedico extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public PesquisarMedico() {
        initComponents();

        preencherTabela();
    }

    public PesquisarMedico(JDesktopPane pnlPrincipal) {
        this();

        this.pnlPrincipal = pnlPrincipal;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPesquisa = new javax.swing.JTable();

        setClosable(true);
        setTitle("Pesquisa Médico");

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
            
        });
        
        

        tblPesquisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblPesquisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblPesquisaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblPesquisa);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFechar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnFechar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {                                          
        try {
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                         

    private void tblPesquisaMousePressed(java.awt.event.MouseEvent evt) {                                         
        try {

            int linha = tblPesquisa.getSelectedRow();
            String codigo = tblPesquisa.getValueAt(linha, 0).toString();

            EMedico tipo = new PMedico().consultar(Integer.parseInt(codigo));

            CadastraMedico janela = new CadastraMedico(pnlPrincipal, tipo);

            pnlPrincipal.add(janela);
            janela.setVisible(true);
            Forms.centraliza(janela);

            this.dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }                                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton btnFechar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPesquisa;
    // End of variables declaration                   

    private void preencherTabela() {
        try {
            //Cria o cabeçalho da tabela
            Vector<String> cabecalho = new Vector();
            cabecalho.add("Identificador");
            cabecalho.add("Nome");
            cabecalho.add("CRM");
            cabecalho.add("Especialidade");

            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector detalhes = new Vector();
            for (EMedico detalhe : new NMedico().lista()) {
                Vector<String> linha = new Vector();
                linha.add(detalhe.getId()+ "");
                linha.add(detalhe.getCrm()+ "");
                linha.add(detalhe.getNome()+"");
                linha.add(detalhe.getDataNascimento() + "");
                linha.add(detalhe.getEspecialidade() + "");
                linha.add(detalhe.getDataAdimissao() + "");
                linha.add(detalhe.getDataDemissao()+ "");
                linha.add(detalhe.getSalario() + "");
                detalhes.add(linha);
            }  

            tblPesquisa.setModel(new DefaultTableModel(detalhes, cabecalho));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
