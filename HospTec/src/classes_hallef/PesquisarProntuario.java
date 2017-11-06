package classes_hallef;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Vector;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PesquisarProntuario extends javax.swing.JInternalFrame {

    JDesktopPane pnlPrincipal;

    public PesquisarProntuario() {
        initComponents();

        preencherTabela();
    }

    public PesquisarProntuario(JDesktopPane pnlPrincipal) {
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
        setTitle("Pesquisa Prontuário");

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

            EProntuario tipo = new PProntuario().consultar(Integer.parseInt(codigo));

            CadastroProntuario janela = new CadastroProntuario(pnlPrincipal, tipo);

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
            cabecalho.add("Pasciente");
            cabecalho.add("Médico");
            cabecalho.add("descricao");
            cabecalho.add("receituario");

            @SuppressWarnings("UseOfObsoleteCollectionType")
            Vector detalhes = new Vector();
            ArrayList<LinkedHashMap<String,Object>> lista = new NProntuario().listageCompleta();
            for (final LinkedHashMap<String,Object> dados : lista) {
                Vector<String> linha = new Vector();
                linha.add((String) dados.get("id"));
                linha.add((String) dados.get("nomePaciente"));
                linha.add((String) dados.get("nomeMedico")+ "");
                linha.add((String) dados.get("descricao")+ "");
                linha.add((String) dados.get("receituario"));

                detalhes.add(linha);
            }  

            tblPesquisa.setModel(new DefaultTableModel(detalhes, cabecalho));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
