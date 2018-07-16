/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.util.HashMap;

/**
 *
 * @author matthias.trennepohl
 */
public class JCompilador extends javax.swing.JFrame {

    HashMap<String, Integer> hashContadorPalavras = new HashMap<>();
    /**
     * Creates new form JCompilador
     */
    public JCompilador() {  
        initComponents();
        iniciarCodigo();
    }

    private void iniciarCodigo() {
        jTextArea_Codigo.setText("se ( A > B ) entao \n"
                + "temp := A \n"
                + "A := B \n"
                + "B := temp \n"
                + "fimse");
    }
    
   public void contarPalavrasCodigo(){
       String codigo = jTextArea_Codigo.getText();
       String[] palavras = codigo.replaceAll("\"", " ").split(" ");
       for (String palavra : palavras) {
           
           String[] semQuebreLinha = palavra.split("\n");
           for (String palav : semQuebreLinha) {
               palav = palav != null ? palav.trim() : null;
               if (palav != null && !palav.trim().isEmpty()) {
                   if (hashContadorPalavras.containsKey(palav)) {
                       Integer contador = hashContadorPalavras.get(palav);
                       hashContadorPalavras.put(palav, contador + 1);
                   } else {
                       hashContadorPalavras.put(palav, 1);
                   }
               }
           }
       }
       
       JExibicaoResultados resultados = new JExibicaoResultados(this, true, hashContadorPalavras);
       resultados.setVisible(true);
       hashContadorPalavras.clear();
   } 
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel_Content = new javax.swing.JPanel();
        jPanel_Codigo = new javax.swing.JPanel();
        jScrollPane_Codigo = new javax.swing.JScrollPane();
        jTextArea_Codigo = new javax.swing.JTextArea();
        jPanel_Buttons = new javax.swing.JPanel();
        jButton_Executar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel_Header.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 1));

        jLabel1.setText("Contador Palavras");
        jPanel_Header.add(jLabel1);

        getContentPane().add(jPanel_Header, java.awt.BorderLayout.NORTH);

        jPanel_Content.setLayout(new javax.swing.BoxLayout(jPanel_Content, javax.swing.BoxLayout.PAGE_AXIS));

        jPanel_Codigo.setLayout(new java.awt.BorderLayout());

        jTextArea_Codigo.setColumns(20);
        jTextArea_Codigo.setRows(5);
        jScrollPane_Codigo.setViewportView(jTextArea_Codigo);

        jPanel_Codigo.add(jScrollPane_Codigo, java.awt.BorderLayout.CENTER);

        jPanel_Content.add(jPanel_Codigo);

        getContentPane().add(jPanel_Content, java.awt.BorderLayout.CENTER);

        jPanel_Buttons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 1));

        jButton_Executar.setText("Executar");
        jButton_Executar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ExecutarActionPerformed(evt);
            }
        });
        jPanel_Buttons.add(jButton_Executar);

        getContentPane().add(jPanel_Buttons, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(416, 338));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_ExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ExecutarActionPerformed
        contarPalavrasCodigo();
    }//GEN-LAST:event_jButton_ExecutarActionPerformed

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
            java.util.logging.Logger.getLogger(JCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCompilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCompilador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Executar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel_Buttons;
    private javax.swing.JPanel jPanel_Codigo;
    private javax.swing.JPanel jPanel_Content;
    private javax.swing.JPanel jPanel_Header;
    private javax.swing.JScrollPane jScrollPane_Codigo;
    private javax.swing.JTextArea jTextArea_Codigo;
    // End of variables declaration//GEN-END:variables
}
