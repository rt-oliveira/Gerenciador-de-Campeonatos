package Formularios;

import Campeonato.CampeonatoMataMata;
import Time.TimeMataMata;
import javax.swing.JOptionPane;

public class MataMata extends javax.swing.JFrame {

    public MataMata() {
        String t=JOptionPane.showInputDialog("Informe a quantidade de times\nObservação: a quantidade de times deve um número potência de 2.\nExemplo: 2, 4, 8, 16,...");
        if(t==null)  System.exit(0);
        int qtdetimes=Integer.parseInt(t);
        initComponents();
        jLabel1.setText("<html><p>Para colocar os resultados de um confronto,</p><p>basta o selecionar entre</p><p>os confrontos sem resultados ainda.</p></html>a");
        for (int i = 0; i < qtdetimes; i++){
            String time=JOptionPane.showInputDialog("Informe o nome do time");
            if (time==null)
                System.exit(0);
            else
                mm.CadastrarEquipe(time);
        }
        mm.GerarConfrontos();
        ehfinal();
        Redimensionar();
        MudarLabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelconfrontos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaconfrontos = new javax.swing.JTable();
        computarresultados = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        labelconfrontos.setText("Confrontos desta fase");

        tabelaconfrontos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Time 1", "x", "Time 2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaconfrontos.setColumnSelectionAllowed(true);
        tabelaconfrontos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaconfrontos);
        tabelaconfrontos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        computarresultados.setText("Computar Resultados");
        computarresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                computarresultadosActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(computarresultados)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelconfrontos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(computarresultados)
                        .addGap(87, 87, 87)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelconfrontos)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void computarresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_computarresultadosActionPerformed
        int a=tabelaconfrontos.getSelectedRow();
        if (a==-1)
            JOptionPane.showMessageDialog(null, "Selecione um confronto antes de colocar os resultados", "Erro", JOptionPane.ERROR_MESSAGE);
        else{
            String t1=tabelaconfrontos.getValueAt(a, 0).toString();
            String t2=tabelaconfrontos.getValueAt(a, 2).toString();
            mm.Confronto(t1,t2,a);
            String v=mm.DeterminarVencedorDoConfronto(a,t1,t2);
            mm.GerarTabela(tabelaconfrontos.getModel(), colunas);
            Redimensionar();
            if (mm.ConfrontosRestantes()==0)
                MudouDeFase();
        }
    }//GEN-LAST:event_computarresultadosActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MataMata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MataMata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton computarresultados;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelconfrontos;
    private CampeonatoMataMata mm=new CampeonatoMataMata();
    private Object[] colunas=new Object[]{"Time 1","x","Time 2"};
    private javax.swing.JTable tabelaconfrontos;
    // End of variables declaration//GEN-END:variables

    private void MudarLabel() {
        int l=mm.getTimes().size();
        switch(l){
            case 2:
                labelconfrontos.setText("Confronto da Grande Final");
                break;
            case 4:
                labelconfrontos.setText("Confrontos da semi-final");
                break;
            case 8:
                labelconfrontos.setText("Confrontos das quartas-de-final");
                break;
            case 16:
                labelconfrontos.setText("Confrontos das oitavas-de-final");
                break;
            default:
                labelconfrontos.setText("Confrontos desta fase");
                break;
        }
    }
    
    private void Redimensionar() {
        tabelaconfrontos.getColumnModel().getColumn(1).setMaxWidth(15);
        tabelaconfrontos.getColumnModel().getColumn(1).setMinWidth(15);
    }

    private void ehfinal(){
        if (mm.getTimes().size()==2){
            JOptionPane.showMessageDialog(null,"Agora é a hora da grande final!");
            JOptionPane.showMessageDialog(null, mm.MostrarConfrontosDaFase(), "Confronto da grande final", JOptionPane.INFORMATION_MESSAGE);
            String t1=((Time.TimeMataMata)mm.getTimes().get(0)).getNome();
            String t2=((Time.TimeMataMata)mm.getTimes().get(1)).getNome();
            mm.Confronto(t1,t2,0);
            String v=mm.DeterminarVencedorDoConfronto(0,t1,t2);
            JOptionPane.showMessageDialog(null, "O grande campeão é: "+v+"!!!!\nParabéns "+v+"!!!!!");
            System.exit(0);
        }else
            JOptionPane.showMessageDialog(null, mm.MostrarConfrontosDaFase(), "Confrontos da fase", JOptionPane.INFORMATION_MESSAGE);
        mm.GerarTabela(tabelaconfrontos.getModel(),colunas);
    }

    private void MudouDeFase() {
        mm.ZerarTimes();
        JOptionPane.showMessageDialog(null, "Esta fase acabou, e os classificados foram:\n"+mm.TimesClassificados(),"Times Classificados",JOptionPane.INFORMATION_MESSAGE);
        mm.GerarConfrontos();
        MudarLabel();
        ehfinal();
        Redimensionar();
    }
}
