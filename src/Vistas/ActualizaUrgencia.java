/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Dao.UrgenciaDaoImpl;
import Idao.IUrgenciaDAO;
import Modelo.Urgencia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jair Velazquez
 */
public class ActualizaUrgencia extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form ActualizaUrgencia
     */
    public ActualizaUrgencia() {
        initComponents();
    }
    public ActualizaUrgencia(int id,int idPaciente,int idUrgenciologo,int idDiagnostico,String numeroCama,String fechaIngreso,String fechaSalida,String causa){
        initComponents();
        this.setDefaultCloseOperation(this.HIDE_ON_CLOSE);
        btnAddActualizar.addActionListener(this);
        btnClean.addActionListener(this);
        btnMarcaSalida.addActionListener(this);
        btnAddDiagnostico.addActionListener(this);
        txtID.setText(String.valueOf(id));
        txtIDPaciente.setText(String.valueOf(idPaciente));
        txtIDUrgenciologo.setText(String.valueOf(idUrgenciologo));
        txtIDDiagnostico.setText(String.valueOf(idDiagnostico));
        txtCamilla1.setText(numeroCama);
        txtIngreso.setText(fechaIngreso);
        txtIDFechaSalida.setText(fechaSalida);
        txtCausa.setText(causa);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnAddPacient2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtIngreso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        btnClean = new javax.swing.JButton();
        txtCausa = new javax.swing.JTextField();
        txtIDUrgenciologo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAddActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDPaciente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnAddDiagnostico = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtCamilla1 = new javax.swing.JTextField();
        btnMarcaSalida = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIDDiagnostico = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIDFechaSalida = new javax.swing.JTextField();

        btnAddPacient2.setText("Añadir diagnostico");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel9.setText("Numero de Cama");

        txtIngreso.setEnabled(false);
        txtIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIngresoActionPerformed(evt);
            }
        });

        jLabel10.setText("Causa");

        btnClean.setText("Limpiar");

        jLabel2.setText("ID Paciente:");

        btnAddActualizar.setText("Actualizar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setText("Actualizar Urgencia");

        jLabel4.setText("ID Urgenciólogo:");

        jLabel3.setText("ID:");

        txtID.setEnabled(false);

        btnAddDiagnostico.setText("Añadir diagnostico");

        jLabel11.setText("Ingreso");

        txtCamilla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCamilla1ActionPerformed(evt);
            }
        });

        btnMarcaSalida.setText("Marcar Salida");

        jLabel5.setText("ID Diagnostico");

        txtIDDiagnostico.setEnabled(false);

        jLabel6.setText("Fecha Salida");

        txtIDFechaSalida.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAddActualizar)
                                .addGap(18, 18, 18)
                                .addComponent(btnClean)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddDiagnostico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnMarcaSalida))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtIDUrgenciologo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtIDDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(91, 91, 91)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIDFechaSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtCausa, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                                        .addComponent(txtCamilla1)))))
                        .addGap(33, 33, 33))))
            .addGroup(layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                .addGap(37, 37, 37)
                .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCamilla1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtIDUrgenciologo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtCausa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIDDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtIDFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddActualizar)
                    .addComponent(btnClean)
                    .addComponent(btnAddDiagnostico)
                    .addComponent(btnMarcaSalida))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIngresoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIngresoActionPerformed

    private void txtCamilla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCamilla1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCamilla1ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizaUrgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizaUrgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizaUrgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizaUrgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ActualizaUrgencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddActualizar;
    private javax.swing.JButton btnAddDiagnostico;
    private javax.swing.JButton btnAddPacient2;
    private javax.swing.JButton btnClean;
    private javax.swing.JButton btnMarcaSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtCamilla1;
    private javax.swing.JTextField txtCausa;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDDiagnostico;
    private javax.swing.JTextField txtIDFechaSalida;
    private javax.swing.JTextField txtIDPaciente;
    private javax.swing.JTextField txtIDUrgenciologo;
    private javax.swing.JTextField txtIngreso;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
       Object entrada = ae.getSource();
       
       if(entrada.equals(btnAddDiagnostico)){
           FormAddDiagnostico agregaDiagnostico = new FormAddDiagnostico(Integer.valueOf(txtID.getText()));
           agregaDiagnostico.setVisible(true);
           txtIDDiagnostico.setText(String.valueOf(agregaDiagnostico.getIdDiagnostico()));
       }
       else if(entrada.equals(btnClean)){
           txtCamilla1.setText("");
           txtIDPaciente.setText("");
           txtIDUrgenciologo.setText("");
           txtCausa.setText("");
       }
       else if(entrada.equals(btnMarcaSalida)){
           Urgencia urgencia = new Urgencia();
           urgencia.setId(Integer.valueOf(txtID.getText()));
           urgencia.setDateTimeSalida(obtenFecha());
           IUrgenciaDAO dao = new UrgenciaDaoImpl();
           dao.actualizaFecha(urgencia);
       }
       else if(entrada.equals(btnAddActualizar)){
           int idPaciente = Integer.valueOf(txtIDPaciente.getText());
           int idUrgenciologo = Integer.valueOf(txtIDUrgenciologo.getText());
           String numero_cama = txtCamilla1.getText();
           String causa = txtCausa.getText();
           Urgencia urgencia = new Urgencia(idPaciente,idUrgenciologo,numero_cama,causa);
           IUrgenciaDAO dao = new UrgenciaDaoImpl();
           dao.actualizar(urgencia);
       }
    }
    public String obtenFecha(){
        String currentTime;
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        currentTime = sdf.format(dt);
        return currentTime;
    }
}