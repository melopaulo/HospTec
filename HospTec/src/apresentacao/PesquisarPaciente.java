package apresentacao;


import apresentacao.CadastroPaciente;
import util.Forms;
import negocio.NPaciente;
import entidade.EPaciente;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesquisarPaciente extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public PesquisarPaciente() {
        initComponents();

        preencherTabela();
    }

    public PesquisarPaciente(JDesktopPane pnlPrincipal) {
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
        setTitle("Pesquisa Paciente");

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

            EPaciente tipo = new NPaciente().consultar(Integer.parseInt(codigo));

            CadastroPaciente janela = new CadastroPaciente(pnlPrincipal, tipo);

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
            cabecalho.add("RG");
            cabecalho.add("CPF");

            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector detalhes = new Vector();

            for (EPaciente detalhe : new NPaciente().lista()) {
                Vector<String> linha = new Vector();
                linha.add(detalhe.getId()+ "");
                linha.add(detalhe.getNome()+ "");
                linha.add(detalhe.getRg() +"");
                linha.add(detalhe.getCpf() + "");
                linha.add(detalhe.getEndereco() + "");
                linha.add(detalhe.getDataNascimento() + "");
                linha.add(detalhe.getSexo() + "");
                linha.add(detalhe.getTelefone() + "");
                System.out.println(detalhe.getCpf()+" "+detalhe.getNome()+" "+detalhe.getSexo());
                detalhes.add(linha);
            }  

            tblPesquisa.setModel(new DefaultTableModel(detalhes, cabecalho));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
