package Formularios;

import Campeonato.CampeonatoPontosCorridos;
import javax.swing.JOptionPane;

public class PontosCorridos extends javax.swing.JFrame {

    /**
     * Creates new form PontosCorridos
     */
    public PontosCorridos() {
        String t=JOptionPane.showInputDialog("Informe a quantidade de times");
        if(t==null) System.exit(0);
        int qtdetimes=Integer.parseInt(t);
        initComponents();
        for (int i = 0; i < qtdetimes; i++)
            pc.CadastrarEquipe(JOptionPane.showInputDialog("Informe o nome do time"));
        tabelaclass.setModel(pc.GerarTabela(tabelaclass.getModel(),colunas));
        Redimensionar();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelclassificacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaclass = new javax.swing.JTable();

        adicionarresultado = new javax.swing.JButton();
        terminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelclassificacao.setText("Tabela de Classificação");

        tabelaclass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posição", "Time", "Pontos", "Vitórias", "Empates", "Derrotas", "Saldo De Gols"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaclass.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaclass);

        adicionarresultado.setText("Adicionar Resultado");
        adicionarresultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adicionarresultadoActionPerformed(evt);
            }
        });

        terminar.setText("Terminar o campeonato");
        terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adicionarresultado)
                    .addComponent(terminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelclassificacao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 669, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(labelclassificacao)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(adicionarresultado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terminar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void adicionarresultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adicionarresultadoActionPerformed
        int casa;
        casa=Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do time da casa no campeonato"));
        int visitante;
        visitante=Integer.parseInt(JOptionPane.showInputDialog("Digite a posição do time visitante no campeonato"));
        String timecasa=tabelaclass.getModel().getValueAt(casa-1, 1).toString();
        String timevisitante=tabelaclass.getModel().getValueAt(visitante-1, 1).toString();
        String a=String.format("Digite o placar da partida\nFormato: gols feitos pelo(a) %s-gols feitos pelo(a) %s",timecasa,timevisitante);
        String[] placar=JOptionPane.showInputDialog(a).split("-");
        pc.AtribuirResultado(placar,casa-1,visitante-1);
        tabelaclass.setModel(pc.GerarTabela(tabelaclass.getModel(),colunas));
        Redimensionar();
    }//GEN-LAST:event_adicionarresultadoActionPerformed

    private void terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminarActionPerformed
        String campeao=tabelaclass.getModel().getValueAt(0, 1).toString();
        this.dispose();
        JOptionPane.showMessageDialog(null, String.format("Acabou o campeonato!!\nO campeão é o(a) %s!!!\nParabéns %s!!!!", campeao,campeao), "Campeão!", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_terminarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PontosCorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PontosCorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PontosCorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PontosCorridos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PontosCorridos().setVisible(true);
            }
        });
    }
    
     private void Redimensionar() {
        tabelaclass.getColumnModel().getColumn(0).setMaxWidth(55);
        tabelaclass.getColumnModel().getColumn(0).setMinWidth(55);
        tabelaclass.getColumnModel().getColumn(2).setMaxWidth(55);
        tabelaclass.getColumnModel().getColumn(2).setMinWidth(55);
        tabelaclass.getColumnModel().getColumn(3).setMaxWidth(55);
        tabelaclass.getColumnModel().getColumn(3).setMinWidth(55);
        tabelaclass.getColumnModel().getColumn(4).setMaxWidth(60);
        tabelaclass.getColumnModel().getColumn(4).setMinWidth(60);
        tabelaclass.getColumnModel().getColumn(5).setMaxWidth(60);
        tabelaclass.getColumnModel().getColumn(5).setMinWidth(60);
        tabelaclass.getColumnModel().getColumn(6).setMaxWidth(90);
        tabelaclass.getColumnModel().getColumn(6).setMinWidth(90);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adicionarresultado;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelclassificacao;
    private CampeonatoPontosCorridos pc=new CampeonatoPontosCorridos();
    private Object[] colunas=new Object[]{"Posição","Time","Pontos","Vitórias","Empates","Derrotas","Saldo De Gols"};
    private javax.swing.JTable tabelaclass;
    private javax.swing.JButton terminar;
    // End of variables declaration//GEN-END:variables

   
}
