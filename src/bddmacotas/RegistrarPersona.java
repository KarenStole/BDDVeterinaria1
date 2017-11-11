
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase encargada de registrar a una persona si esta no se encuentra en el sistema.
 * @author francisco.perdomo
 */
public class RegistrarPersona extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();
    
    /**
     *
     */
    public RegistrarPersona() {
        initComponents();
    }
    /**
     * Metodo encargado de hacer todos los chequeos necesarios con los datos ingresados,
     * asi como tambien comprobar que la persona ya no este registrada.
     * @return True si los datos son validos. False de lo contrario.
     */
   public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try {  
            if (ci.getText().compareTo("")==0) {
                lerrci.setText("Este campo no puede ser vacío");
                respuesta = false;
            }
            if (!isNumeric(ci.getText())) {
                lerrci.setText("Solo pueden ser numeros");
                respuesta = false;
            }
            if (nom.getText().compareTo("")==0) {
                lerrnom.setText("Este campo no puede ser vacío");
                respuesta = false;
            }
            if (!isNumeric(tel.getText())) {
                lerrtel.setText("Solo pueden ser numeros");
                respuesta = false;
            }            
            if (tel.getText().compareTo("")==0) {
                lerrtel.setText("Este campo no puede ser vacío");
                respuesta = false;
            }
            if (telalt.getText().compareTo("")!=0){
                if (!isNumeric(telalt.getText())) {
                    JOptionPane.showMessageDialog(null, "Telefono solo debe ser numerico");
                    respuesta = false;
                } 
            }
            if (dir.getText().compareTo("")==0) {
                lerrdir.setText("Este campo no puede ser vacío");
                respuesta = false;
            } 
            if (respuesta){
                ResultSet rs = bdd.enviarConsulta("SELECT ci FROM Persona WHERE ci="+ci.getText());
                if (rs.next()) {
                    lerrci.setText("Ya existe un usuario con esa CI");
                    respuesta = false;
                }      
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    } 
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    
    /**
     *
     */
    public void limpiarErrores(){
        lerrci.setText("     ");
        lerrnom.setText("     ");
        lerrtel.setText("     ");
        lerrdir.setText("     ");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        Fondo = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        ci = new javax.swing.JTextField();
        nom = new javax.swing.JTextField();
        tel = new javax.swing.JTextField();
        telalt = new javax.swing.JTextField();
        dir = new javax.swing.JTextField();
        lci = new javax.swing.JLabel();
        lnom = new javax.swing.JLabel();
        ltel = new javax.swing.JLabel();
        ltelalt = new javax.swing.JLabel();
        ldir = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lerrci = new javax.swing.JLabel();
        lerrtel = new javax.swing.JLabel();
        lerrnom = new javax.swing.JLabel();
        lerrdir = new javax.swing.JLabel();
        ast = new javax.swing.JLabel();
        ast1 = new javax.swing.JLabel();
        ast2 = new javax.swing.JLabel();
        ast3 = new javax.swing.JLabel();
        lfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setLayout(null);

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 78, 150));
        titulo.setText("Registrar Persona");
        Fondo.add(titulo);
        titulo.setBounds(111, 11, 215, 29);

        ci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(ci);
        ci.setBounds(111, 51, 215, 20);

        nom.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        nom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomActionPerformed(evt);
            }
        });
        Fondo.add(nom);
        nom.setBounds(111, 77, 215, 20);

        tel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(tel);
        tel.setBounds(111, 103, 215, 20);

        telalt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(telalt);
        telalt.setBounds(111, 129, 215, 20);

        dir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dirActionPerformed(evt);
            }
        });
        Fondo.add(dir);
        dir.setBounds(111, 155, 215, 20);

        lci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lci.setForeground(new java.awt.Color(0, 78, 150));
        lci.setText("CI:");
        Fondo.add(lci);
        lci.setBounds(67, 54, 14, 14);

        lnom.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lnom.setForeground(new java.awt.Color(0, 78, 150));
        lnom.setText("Nombre:");
        Fondo.add(lnom);
        lnom.setBounds(34, 80, 47, 14);

        ltel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ltel.setForeground(new java.awt.Color(0, 78, 150));
        ltel.setText("Teléfono:");
        Fondo.add(ltel);
        ltel.setBounds(29, 106, 52, 14);

        ltelalt.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ltelalt.setForeground(new java.awt.Color(0, 78, 150));
        ltelalt.setText("Teléfono alt:");
        Fondo.add(ltelalt);
        ltelalt.setBounds(10, 132, 69, 14);

        ldir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ldir.setForeground(new java.awt.Color(0, 78, 150));
        ldir.setText("Dirección:");
        Fondo.add(ldir);
        ldir.setBounds(24, 158, 57, 14);

        jButton1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Fondo.add(jButton1);
        jButton1.setBounds(133, 181, 109, 23);

        lerrci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrci.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lerrci);
        lerrci.setBounds(332, 51, 174, 20);

        lerrtel.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrtel.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lerrtel);
        lerrtel.setBounds(332, 103, 174, 20);

        lerrnom.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrnom.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lerrnom);
        lerrnom.setBounds(332, 77, 174, 20);

        lerrdir.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrdir.setForeground(new java.awt.Color(255, 0, 0));
        Fondo.add(lerrdir);
        lerrdir.setBounds(332, 155, 174, 20);

        ast.setForeground(new java.awt.Color(255, 0, 0));
        ast.setText("*");
        Fondo.add(ast);
        ast.setBounds(87, 54, 6, 14);

        ast1.setForeground(new java.awt.Color(255, 0, 0));
        ast1.setText("*");
        Fondo.add(ast1);
        ast1.setBounds(87, 80, 6, 14);

        ast2.setForeground(new java.awt.Color(255, 0, 0));
        ast2.setText("*");
        Fondo.add(ast2);
        ast2.setBounds(87, 106, 6, 14);

        ast3.setForeground(new java.awt.Color(255, 0, 0));
        ast3.setText("*");
        Fondo.add(ast3);
        ast3.setBounds(87, 158, 6, 14);

        lfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoPersona.jpg"))); // NOI18N
        lfondo.setText("    ");
        Fondo.add(lfondo);
        lfondo.setBounds(-4, 1, 540, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomActionPerformed

    private void dirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dirActionPerformed
    /**
     * Metodo encargado de ingresar los datos de la persona en la base de datos.
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        chequeoDatos();
        if(telalt.getText().compareTo("")!=0){
            bdd.enviarConsulta("insert into persona (ci,nombre,telefono,telefonoalternativo,direccion) values("
                + ci.getText()+",'"
                + nom.getText()+"',"
                + tel.getText()+","
                + telalt.getText()+",'"
                + dir.getText()
                + "')");
        }else{
            bdd.enviarConsulta("insert into persona (ci,nombre,telefono,direccion) values("
                + ci.getText()+",'"
                + nom.getText()+"',"
                + tel.getText()+",'"
                + dir.getText()
                + "')");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     *
     * @param args
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
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarPersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarPersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel ast;
    private javax.swing.JLabel ast1;
    private javax.swing.JLabel ast2;
    private javax.swing.JLabel ast3;
    private javax.swing.JTextField ci;
    private javax.swing.JTextField dir;
    private javax.swing.JButton jButton1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lci;
    private javax.swing.JLabel ldir;
    private javax.swing.JLabel lerrci;
    private javax.swing.JLabel lerrdir;
    private javax.swing.JLabel lerrnom;
    private javax.swing.JLabel lerrtel;
    private javax.swing.JLabel lfondo;
    private javax.swing.JLabel lnom;
    private javax.swing.JLabel ltel;
    private javax.swing.JLabel ltelalt;
    private javax.swing.JTextField nom;
    private javax.swing.JTextField tel;
    private javax.swing.JTextField telalt;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
