import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase que contiene todas las responabilidades con respecto a hacer denuncia.
 * @author francisco.perdomo
 */
public class Denuncia extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();

    /**
     *
     */
    public Denuncia() throws SQLException {
        initComponents();
        fecha.setText(fecha());
        llenarComboBoxes2();
        System.out.println(fecha());
    }
    public String fecha(){
        Date now = new Date(System.currentTimeMillis());
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");

        return date.format(now);
    }
     /**
     * Metodo encargado de imprimir los resultados de las consultas a la base de datos.
     * @param rs 
     * @param tipocons 
     */
    public void imprimirResultados(ResultSet rs, int tipocons){
        try {
            String res="";
            if (tipocons ==0 && rs!=null){
                while (rs.next()) {
                    res += rs.getString(1)+ ", " 
                          +rs.getString(2)+ ", "
                          +rs.getString(3)+ ", "
                          +rs.getString(4)+ ", "
                          +rs.getString(5)+ ", "
                          +rs.getString(6)+ ", "
                          +rs.getString(7)+ ", "
                          +rs.getString(8)+ ", "
                          +rs.getString(9)+ "\n";
                }
            }else{
                res = "Listo" ;
            }
            resultado.setText(res);
        } catch (SQLException ex) {
            Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Clase encargada de chequear que todos los datos necesarios para hacer una denuncia,
     * esten en la base de dato.
     * @return True si es todo correcto, False si falta registrarse
     */
    public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try { 
            if("".equals(cidenunciante.getText()) && "".equals(idmascota.getText()) && "".equals(zona.getText())){
                JOptionPane.showMessageDialog(null, "Datos invalidos.");
                respuesta=false;
            }
            if(!isNumeric(cidenunciante.getText())){
                lerrorci.setText("CI debe contener solo numeros.");
                respuesta=false;
            }
            if(!isNumeric(rutvet.getText())){
                lerrorvet.setText("RUT debe contener solo numeros.");
                respuesta=false;
            }
            if(!isNumeric(idmascota.getText())){
                lerrormascota.setText("ID debe contener solo numeros.");
                respuesta=false;
            }
            ResultSet rs = bdd.enviarConsulta("SELECT ci FROM Persona WHERE ci="+cidenunciante.getText());
            if (!rs.next()) {
                lerrorci.setText("Ese usuario no está en el sistema");
                respuesta = false;
            }
            rs = bdd.enviarConsulta("SELECT idmascota FROM Mascota WHERE idmascota="+idmascota.getText());
            if (!rs.next()) {
                lerrormascota.setText("No existe una mascota con ese id");
                respuesta = false;
            }  
            rs = bdd.enviarConsulta("SELECT rut FROM Veterinaria WHERE rut="+rutvet.getText());
            if (!rs.next()) {
                lerrorvet.setText("No existe una veterinaria con ese RUT");
                respuesta = false;
            } 
            if(!isNumeric(zona.getText())){
                lerrorzona.setText("La zona debe contener solo numeros.");
                respuesta=false;
            }
            if(tipoDenuncia.getSelectedIndex() == (-1)){
                JOptionPane.showMessageDialog(null, "Debe ingresar el tipo de denuncia.");
                respuesta= false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException np){
            lerrorzona.setText("Rellenar todos los campos.");
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
        lerrorci.setText("     ");
        lerrormascota.setText("     ");
        lerrorvet.setText("     ");
        lerrorzona.setText("     ");
    }
private void llenarComboBoxes2() throws SQLException{
        tipoDenuncia.removeAllItems();
        ArrayList tipoanimal= new ArrayList();
        ResultSet rs= bdd.enviarConsulta("SELECT descripcion FROM tipodenuncia");
        while(rs.next()){
            tipoanimal.add(rs.getString(1));
        }
        for( int e=0; e< tipoanimal.size();e++){
            tipoDenuncia.insertItemAt((String) tipoanimal.get(e), e);
        }
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        Fondo = new javax.swing.JPanel();
        Titulo = new javax.swing.JLabel();
        lcidenunciante = new javax.swing.JLabel();
        fecha = new javax.swing.JFormattedTextField();
        rutvet = new javax.swing.JTextField();
        cidenunciante = new javax.swing.JTextField();
        lidmascota = new javax.swing.JLabel();
        lzona = new javax.swing.JLabel();
        insertar = new javax.swing.JButton();
        lfecha = new javax.swing.JLabel();
        zona = new javax.swing.JTextField();
        idmascota = new javax.swing.JTextField();
        lrut = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        listar = new javax.swing.JButton();
        tipoDenuncia = new javax.swing.JComboBox<>();
        lerrormascota = new javax.swing.JLabel();
        lerrorci = new javax.swing.JLabel();
        lerrorvet = new javax.swing.JLabel();
        lerrorzona = new javax.swing.JLabel();
        lfondo = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setLayout(null);

        Titulo.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 78, 150));
        Titulo.setText("Ingresar Denuncia");
        Fondo.add(Titulo);
        Titulo.setBounds(100, 0, 197, 29);

        lcidenunciante.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lcidenunciante.setForeground(new java.awt.Color(0, 78, 150));
        lcidenunciante.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lcidenunciante.setText("CI Denunciante");
        Fondo.add(lcidenunciante);
        lcidenunciante.setBounds(30, 90, 100, 20);

        fecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fecha.setText(fecha());
        fecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaActionPerformed(evt);
            }
        });
        Fondo.add(fecha);
        fecha.setBounds(480, 130, 90, 30);

        rutvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(rutvet);
        rutvet.setBounds(140, 170, 210, 30);

        cidenunciante.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cidenunciante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidenuncianteActionPerformed(evt);
            }
        });
        Fondo.add(cidenunciante);
        cidenunciante.setBounds(140, 90, 210, 30);

        lidmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lidmascota.setForeground(new java.awt.Color(0, 78, 150));
        lidmascota.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lidmascota.setText("ID Mascota");
        Fondo.add(lidmascota);
        lidmascota.setBounds(40, 40, 90, 20);

        lzona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lzona.setForeground(new java.awt.Color(0, 78, 150));
        lzona.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lzona.setText("Zona perdido");
        Fondo.add(lzona);
        lzona.setBounds(40, 230, 90, 20);

        insertar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        insertar.setText("Ingresar Denuncia");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        Fondo.add(insertar);
        insertar.setBounds(160, 280, 150, 23);

        lfecha.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lfecha.setForeground(new java.awt.Color(0, 78, 150));
        lfecha.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfecha.setText("Fecha Perdido");
        Fondo.add(lfecha);
        lfecha.setBounds(370, 140, 100, 14);

        zona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        zona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zonaActionPerformed(evt);
            }
        });
        Fondo.add(zona);
        zona.setBounds(140, 230, 210, 20);

        idmascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(idmascota);
        idmascota.setBounds(140, 40, 210, 30);

        lrut.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lrut.setForeground(new java.awt.Color(0, 78, 150));
        lrut.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lrut.setText("RUT Veterinaria");
        Fondo.add(lrut);
        lrut.setBounds(20, 170, 110, 20);

        resultado.setColumns(20);
        resultado.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 13)); // NOI18N
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        Fondo.add(jScrollPane1);
        jScrollPane1.setBounds(20, 310, 620, 86);

        listar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        listar.setText("Listar denuncias");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        Fondo.add(listar);
        listar.setBounds(250, 400, 150, 23);

        tipoDenuncia.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tipoDenuncia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perdí mi mascota", "Encontré una mascota" }));
        tipoDenuncia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                tipoDenunciaItemStateChanged(evt);
            }
        });
        tipoDenuncia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoDenunciaActionPerformed(evt);
            }
        });
        Fondo.add(tipoDenuncia);
        tipoDenuncia.setBounds(140, 140, 210, 20);

        lerrormascota.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrormascota.setForeground(new java.awt.Color(255, 0, 0));
        lerrormascota.setText("          ");
        Fondo.add(lerrormascota);
        lerrormascota.setBounds(140, 70, 270, 20);

        lerrorci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorci.setForeground(new java.awt.Color(255, 0, 0));
        lerrorci.setText("          ");
        Fondo.add(lerrorci);
        lerrorci.setBounds(140, 120, 270, 20);

        lerrorvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorvet.setForeground(new java.awt.Color(255, 0, 0));
        lerrorvet.setText("          ");
        Fondo.add(lerrorvet);
        lerrorvet.setBounds(140, 200, 280, 20);

        lerrorzona.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorzona.setForeground(new java.awt.Color(255, 0, 0));
        lerrorzona.setText("   ");
        Fondo.add(lerrorzona);
        lerrorzona.setBounds(134, 254, 220, 20);

        lfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoMasc.jpg"))); // NOI18N
        lfondo.setText("     ");
        Fondo.add(lfondo);
        lfondo.setBounds(0, 0, 660, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaActionPerformed

    private void cidenuncianteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidenuncianteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidenuncianteActionPerformed
    /**
     * Metodo encargado de registrar en la base de datos la denuncia hecha, siempre
     * y cuando pase por los chequepos pertinentes.
     * @param evt 
     */
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        boolean chequeo = chequeoDatos();
        System.out.println("..."+tipoDenuncia.getSelectedIndex());
        if (chequeo){
            ResultSet rs = bdd.enviarConsulta("INSERT INTO denuncia(cipersona, tipo_denuncia, id_mascota, rut_veterinaria, fechadenuncia, zona) VALUES ("               
                + cidenunciante.getText() + ","
                + (tipoDenuncia.getSelectedIndex()+1) + ","
                + idmascota.getText() + ","
                + rutvet.getText() + ","
                + "'"+ fecha.getText() + "',"
                + zona.getText() +");");
            limpiarErrores();
            imprimirResultados(rs, 1);
        }

    }//GEN-LAST:event_insertarActionPerformed

    private void zonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zonaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zonaActionPerformed
    /**
     * Mentodo encargado de listar y mostrar en pantalla todas las denuncias hechas
     * @param evt 
     */
    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        ResultSet rs = bdd.enviarConsulta("SELECT * FROM Denuncia;");
        imprimirResultados(rs, 0);
    }//GEN-LAST:event_listarActionPerformed

    private void tipoDenunciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoDenunciaActionPerformed
        
    }//GEN-LAST:event_tipoDenunciaActionPerformed

    private void tipoDenunciaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_tipoDenunciaItemStateChanged
        if (tipoDenuncia.getSelectedIndex()==0){
            lfecha.setText("Fecha Perdido");

        }else{
            lfecha.setText("Fecha Encontrado");
        }
    }//GEN-LAST:event_tipoDenunciaItemStateChanged

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
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Denuncia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Denuncia().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Denuncia.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JTextField cidenunciante;
    private javax.swing.JFormattedTextField fecha;
    private javax.swing.JTextField idmascota;
    private javax.swing.JButton insertar;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lcidenunciante;
    private javax.swing.JLabel lerrorci;
    private javax.swing.JLabel lerrormascota;
    private javax.swing.JLabel lerrorvet;
    private javax.swing.JLabel lerrorzona;
    private javax.swing.JLabel lfecha;
    private javax.swing.JLabel lfondo;
    private javax.swing.JLabel lidmascota;
    private javax.swing.JButton listar;
    private javax.swing.JLabel lrut;
    private javax.swing.JLabel lzona;
    private javax.swing.JTextArea resultado;
    private javax.swing.JTextField rutvet;
    private javax.swing.JComboBox<String> tipoDenuncia;
    private javax.swing.JTextField zona;
    // End of variables declaration//GEN-END:variables
}
