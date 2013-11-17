
import CLIPSJNI.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.ComunidadUniversitaria;
import model.Person;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public class UI extends javax.swing.JFrame {
    ComunidadUniversitaria cu;
    /**
     * Creates new form UI
     */
    public UI() {
        initComponents();
        cu = ComunidadUniversitaria.getInstance();
        cu.loadCU();
        String[] persons = new String[cu.profesores.size()+cu.estudiantes.size()+cu.egresados.size()+cu.empleados.size()];
        int i = 0;
        for(Person p : cu.profesores){
            persons[i] = p.getId() + " - " + p.getName() + " - " + p.getType();
            ++i;
        }
        for(Person p : cu.estudiantes){
            persons[i] = p.getId() + " - " + p.getName() + " - " + p.getType();
            ++i;
        }
        for(Person p : cu.egresados){
            persons[i] = p.getId() + " - " + p.getName() + " - " + p.getType();
            ++i;
        }
        for(Person p : cu.empleados){
            persons[i] = p.getId() + " - " + p.getName() + " - " + p.getType();
            ++i;
        }
                
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(persons));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        ConvocarButton = new javax.swing.JButton();
        verRegistroButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton2 = new javax.swing.JButton();
        verPostuladosButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        salirButton = new javax.swing.JButton();
        reiniciarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jLabel1.setText("SBC Voting System");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Eleccion a Convocar"));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Rector", "Vicerrector", "Secretario", "Gobiernol de Nucleos", " " }));

        ConvocarButton.setText("Convocar Eleccion");
        ConvocarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConvocarButtonActionPerformed(evt);
            }
        });

        verRegistroButton.setText("Ver Registro Electoral");
        verRegistroButton.setEnabled(false);
        verRegistroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verRegistroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConvocarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(verRegistroButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConvocarButton)
                    .addComponent(verRegistroButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Postular Candidato"));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Candidato Apellido 1", "Candidato Apellido 2", "Candidato Apellido 3" }));

        jButton2.setText("Postular");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        verPostuladosButton.setText("Ver Candidatos Postulados");
        verPostuladosButton.setEnabled(false);
        verPostuladosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verPostuladosButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(verPostuladosButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2)
                    .addComponent(verPostuladosButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 12)); // NOI18N
        jLabel2.setText("De Freitas / Plessmann / López");

        salirButton.setText("Salir");

        reiniciarButton.setText("Reiniciar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(reiniciarButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(salirButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salirButton)
                    .addComponent(reiniciarButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConvocarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConvocarButtonActionPerformed
        // TODO add your handling code here:
        try {
            String eleccion = ((String)(jComboBox1.getSelectedItem()));
            if(loadCLIPS()){
                e.load("logic.clp");
                for(Person p : cu.profesores){
                    e.assertString(p.toString());
                    e.assertString("(eleccion (tipo "+eleccion+"))");
                    e.run();
                    //DIAGNOSTICO
                    MultifieldValue P = (MultifieldValue) e.eval("(find-all-facts ((?a candidato)) TRUE)");
                    List hec = P.multifieldValue();
                    //agregar al registro dependiendo de hec
                }
                
                for(Person p : cu.estudiantes){
                    e.assertString(p.toString());
                    e.assertString("(eleccion (tipo "+eleccion+"))");
                    e.run();
                    //DIAGNOSTICO
                    MultifieldValue P = (MultifieldValue) e.eval("(find-all-facts ((?a candidato)) TRUE)");
                    List hec = P.multifieldValue();
                    //agregar al registro dependiendo de hec
                }
                
                for(Person p : cu.egresados){
                    e.assertString(p.toString());
                    e.assertString("(eleccion (tipo "+eleccion+"))");
                    e.run();
                    //DIAGNOSTICO
                    MultifieldValue P = (MultifieldValue) e.eval("(find-all-facts ((?a candidato)) TRUE)");
                    List hec = P.multifieldValue();
                    //agregar al registro dependiendo de hec
                }
                
                for(Person p : cu.empleados){
                    e.assertString(p.toString());
                    e.assertString("(eleccion (tipo "+eleccion+"))");
                    e.run();
                    //DIAGNOSTICO
                    MultifieldValue P = (MultifieldValue) e.eval("(find-all-facts ((?a candidato)) TRUE)");
                    List hec = P.multifieldValue();
                    //agregar al registro dependiendo de hec
                }
            }
            verRegistroButton.setEnabled(true);
        } catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            e.reset();
        }
    }//GEN-LAST:event_ConvocarButtonActionPerformed
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            String[] params = ((String)(jComboBox2.getSelectedItem())).split(" - ");
            Person aux = cu.getPerson(params[0], params[2]);
            if(aux != null && loadCLIPS()){
                e.load("logic.clp");
                e.assertString(aux.toString());
                e.run();
                //DIAGNOSTICO
                MultifieldValue P = (MultifieldValue) e.eval("(find-all-facts ((?a candidato)) TRUE)");
                List hec = P.multifieldValue();
                if(hec.isEmpty()){
                    JOptionPane.showMessageDialog(this,"El " + aux.getType() + " " + aux.getName() + " puede ser candidato", "ERROR", JOptionPane.OK_OPTION);
                    cu.postulados.add(aux);
                    verPostuladosButton.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(this,"El " + aux.getType() + " " + aux.getName() + " no puede ser candidato", "ERROR", JOptionPane.OK_OPTION);
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(UI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            e.reset();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void verRegistroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verRegistroButtonActionPerformed
        StringBuilder list = new StringBuilder();
        if(!cu.registro.isEmpty()) {
            list.append("CI \t Nombre \t Tipo\n");
            for (Person p : cu.registro) {
                list.append(p.getId());
                list.append(" \t");
                list.append(p.getName());
                list.append(" \t");
                list.append(p.getType());
                list.append("\n");
            }
        }
        JOptionPane.showMessageDialog(this,list.length()!=0?list.toString():"No hay nadie habilitado para votar", "Alerta", JOptionPane.OK_OPTION);
        list.delete(0, list.length());
    }//GEN-LAST:event_verRegistroButtonActionPerformed

    private void verPostuladosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verPostuladosButtonActionPerformed
        StringBuilder list = new StringBuilder();
        if(!cu.postulados.isEmpty()) {
            list.append("CI \t Nombre \t Tipo\n");
            for (Person p : cu.postulados) {
                list.append(p.getId());
                list.append(" \t");
                list.append(p.getName());
                list.append(" \t");
                list.append(p.getType());
                list.append("\n");
            }
        }
        JOptionPane.showMessageDialog(this,list.length()!=0?list.toString():"No hay candidatos postulados", "Alerta", JOptionPane.OK_OPTION);
        list.delete(0, list.length());
    }//GEN-LAST:event_verPostuladosButtonActionPerformed
    
    private boolean loadCLIPS(){
        System.loadLibrary("CLIPSJNI");
        e = new Environment();
        if (e == null){
            System.out.println("Error al intanciar CLIPSJNI");
            JOptionPane.showMessageDialog(this,"Error al instanciar CLIPSJNI", "ERROR", JOptionPane.OK_OPTION);
            return false;
        }
        return true;
    }
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }
    static Environment e;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ConvocarButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton reiniciarButton;
    private javax.swing.JButton salirButton;
    private javax.swing.JButton verPostuladosButton;
    private javax.swing.JButton verRegistroButton;
    // End of variables declaration//GEN-END:variables
}
