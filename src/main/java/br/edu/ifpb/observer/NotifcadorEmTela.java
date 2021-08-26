/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.observer;

import br.edu.ifpb.domain.Compra;
import br.edu.ifpb.bridge.CompraAPrazo;
import br.edu.ifpb.domain.Entrega;
import br.edu.ifpb.domain.ItemDeVenda;
import br.edu.ifpb.domain.Notificacao;
import br.edu.ifpb.domain.Produto;
import br.edu.ifpb.strategy.EntregaPorSedex;

/**
 *
 * @author Ricardo Job
 */
public class NotifcadorEmTela extends javax.swing.JFrame implements Notificacao{

    public NotifcadorEmTela() {
        initComponents();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("concluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Produto arroz = new Produto(
            "arroz", 2.65
        );
        Produto leite = new Produto(
            "leite", 6.89
        );
        Entrega entrega = new EntregaPorSedex();
//        Compra compra = new CompraAPrazoEntregaCorreiros();
        Compra compra = new CompraAPrazo(entrega);
        compra.adicionar(new ItemDeVenda(
            3,arroz
        ));
        compra.adicionar(new ItemDeVenda(
            2,leite
        ));
        compra.addNotificador(new NotificacaoNoConsole()); //adicionando um observador
        compra.addNotificador(this);
//        compra.addNotificador(new NotificacaoNoConsole()); //adicionando um observador
        String codigo = compra.concluir();  
        System.out.println("codigo = " + codigo);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(NotifcadorEmTela.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NotifcadorEmTela.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NotifcadorEmTela.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NotifcadorEmTela.class.getName()).log(java.util.logging.Level.SEVERE,null,ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NotifcadorEmTela().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void concluida(Compra compra) {
        jLabel2.setText(
            "Valor da Compra:" + 
             String.valueOf(compra.valorTotal())
        );
    }


}
