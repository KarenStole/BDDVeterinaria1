package bddmacotas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bddmacotas.SubirImagen;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Clase responsable de implementar todos los metodos necesarios para registrar una mascota en 
 * la base de datos.
 * @author francisco.perdomo
 */
public class IngresoMascota extends javax.swing.JFrame {
    BaseDeDatos1 bdd = new BaseDeDatos1();

    /**
     *
     */
    public IngresoMascota() throws SQLException {
        initComponents();  
        llenarComboBoxes2();
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
                          +rs.getString(6)+ "\n";
                }
            }else{
                res = "Listo" ;
            }
            resultado.setText(res);
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       /**
     * Clase encargada de chequear que todos los datos necesarios para hacer el registro de la mascota,
     * esten en la base de dato.
     * @return True si es todo correcto, False si falta registrarse
     */
    public boolean chequeoDatos(){
        boolean respuesta = true;
        limpiarErrores();
        try {
            if("".equals(cidueño.getText()) && "".equals(nombre.getText()) && "".equals(rutvet.getText())){
                JOptionPane.showMessageDialog(null, "Datos invalidos.");
                respuesta= false;
                return respuesta;
            }
            if(!isNumeric(cidueño.getText()) && !isNumeric(rutvet.getText()) ){
                JOptionPane.showMessageDialog(null, "CI, RUT deben ser numericos");
                respuesta=false;
                return respuesta;
            }
            ResultSet rs = bdd.enviarConsulta("SELECT ci FROM Persona WHERE ci="+cidueño.getText());
            if (!rs.next()) {
                lerrorci.setText("Ese usuario no está en el sistema");
                respuesta = false;
                return respuesta;
            }
            rs = bdd.enviarConsulta("SELECT rut FROM Veterinaria WHERE rut="+rutvet.getText());
            if (!rs.next()) {
                lerrorvet.setText("No existe una veterinaria con ese RUT");
                respuesta = false;
                return respuesta;
            } 
            if( tipoAnimal.getSelectedIndex() == (-1)){
                JOptionPane.showMessageDialog(null, "Debe ingresar que animal es.");
                respuesta= false;
                return respuesta;
            }
            if( raza.getSelectedIndex() == (-1)){
                JOptionPane.showMessageDialog(null, "Debe una raza.");
                respuesta= false;
                return respuesta;
            }          
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex){
            JOptionPane.showMessageDialog(null, "Datos invalidos");
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
        lerrorvet.setText("     ");
    }
 /**
 * Metodo encargado de llenar el ComboBox de Razas.
 * La informacion es recolectada de la base de datos directamente, de la tabla Raza.
 * Dependiendo de que se elija en el comboBox de tipoAnimal, se presentaran las razas disponibles en la base de datos.
 * @param i
 * @throws SQLException 
 */    
    private void llenarComboBoxes(int i) throws SQLException{
        raza.removeAllItems();
        ArrayList razas= new ArrayList();
        ResultSet rs= bdd.enviarConsulta("SELECT NOMBRE FROM RAZA WHERE RAZA.IDraza IN "
                + "(SELECT RAZAtipoanimal.IDraza FROM RAZATIPOANIMAL WHERE RAZATIPOANIMAL.idtipo=" +(i+1)+")");
        while(rs.next()){
            razas.add(rs.getString(1));
        }
        for( int e=0; e< razas.size();e++){
            raza.insertItemAt((String) razas.get(e), e);
        }      
    }
    /**
 * Metodo encargado de llenar comboBox donde se presenta los ripos de animales.
 * Dichos datos son esctraidos directamente de la tabla TipoAnimal de la base de datos.
 * @throws SQLException 
 */
private void llenarComboBoxes2() throws SQLException{
        tipoAnimal.removeAllItems();
        ArrayList tipoanimal= new ArrayList();
        ResultSet rs= bdd.enviarConsulta("SELECT NOMBRE FROM tipoanimal");
        while(rs.next()){
            tipoanimal.add(rs.getString(1));
        }
        for( int e=0; e< tipoanimal.size();e++){
            tipoAnimal.insertItemAt((String) tipoanimal.get(e), e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Fondo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultado = new javax.swing.JTextArea();
        insertar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        descripcion = new javax.swing.JTextField();
        fechanac = new javax.swing.JFormattedTextField();
        rutvet = new javax.swing.JTextField();
        cidueño = new javax.swing.JTextField();
        lnombre = new javax.swing.JLabel();
        ldescripcion = new javax.swing.JLabel();
        lfechanac = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lcidueño = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        lerrorci = new javax.swing.JLabel();
        lerrorvet = new javax.swing.JLabel();
        tipoAnimal = new javax.swing.JComboBox<>();
        raza = new javax.swing.JComboBox<>();
        agregarImagen = new javax.swing.JCheckBox();
        lFondo = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Fondo.setLayout(null);

        resultado.setColumns(20);
        resultado.setRows(5);
        jScrollPane1.setViewportView(resultado);

        Fondo.add(jScrollPane1);
        jScrollPane1.setBounds(10, 360, 641, 120);

        insertar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        insertar.setText("Ingresar Mascota");
        insertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertarActionPerformed(evt);
            }
        });
        Fondo.add(insertar);
        insertar.setBounds(150, 310, 117, 23);

        listar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        listar.setText("Listar Mascotas");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        Fondo.add(listar);
        listar.setBounds(194, 486, 129, 23);

        nombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        Fondo.add(nombre);
        nombre.setBounds(140, 50, 200, 21);

        descripcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        descripcion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        Fondo.add(descripcion);
        descripcion.setBounds(140, 140, 200, 40);

        try {
            fechanac.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        fechanac.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        fechanac.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        fechanac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechanacActionPerformed(evt);
            }
        });
        Fondo.add(fechanac);
        fechanac.setBounds(140, 110, 79, 20);

        rutvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        Fondo.add(rutvet);
        rutvet.setBounds(140, 240, 200, 20);

        cidueño.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        cidueño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cidueñoActionPerformed(evt);
            }
        });
        Fondo.add(cidueño);
        cidueño.setBounds(140, 200, 200, 21);

        lnombre.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lnombre.setForeground(new java.awt.Color(0, 78, 150));
        lnombre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lnombre.setText("Nombre");
        Fondo.add(lnombre);
        lnombre.setBounds(52, 54, 78, 15);

        ldescripcion.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        ldescripcion.setForeground(new java.awt.Color(0, 78, 150));
        ldescripcion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ldescripcion.setText("Descripción");
        Fondo.add(ldescripcion);
        ldescripcion.setBounds(50, 150, 78, 15);

        lfechanac.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lfechanac.setForeground(new java.awt.Color(0, 78, 150));
        lfechanac.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lfechanac.setText("Fecha Nacimiento");
        Fondo.add(lfechanac);
        lfechanac.setBounds(10, 110, 120, 15);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 78, 150));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("RUT Veterinaria");
        Fondo.add(jLabel1);
        jLabel1.setBounds(40, 240, 94, 15);

        lcidueño.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lcidueño.setForeground(new java.awt.Color(0, 78, 150));
        lcidueño.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lcidueño.setText("CI Dueño");
        Fondo.add(lcidueño);
        lcidueño.setBounds(70, 200, 60, 15);

        Titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 78, 150));
        Titulo.setText("Ingresar Mascota");
        Fondo.add(Titulo);
        Titulo.setBounds(134, 11, 184, 32);

        lerrorci.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorci.setForeground(new java.awt.Color(255, 0, 0));
        lerrorci.setText("          ");
        Fondo.add(lerrorci);
        lerrorci.setBounds(140, 220, 230, 20);

        lerrorvet.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        lerrorvet.setForeground(new java.awt.Color(255, 0, 0));
        lerrorvet.setText("          ");
        Fondo.add(lerrorvet);
        lerrorvet.setBounds(140, 260, 210, 20);

        tipoAnimal.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        tipoAnimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Perro", "Gato" }));
        tipoAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoAnimalActionPerformed(evt);
            }
        });
        Fondo.add(tipoAnimal);
        tipoAnimal.setBounds(140, 80, 79, 21);

        raza.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        raza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Maltes", "Dalmata", "Cocker", "Caninche", "Husky", "No Definida" }));
        raza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                razaActionPerformed(evt);
            }
        });
        Fondo.add(raza);
        raza.setBounds(220, 80, 150, 21);

        agregarImagen.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 11)); // NOI18N
        agregarImagen.setText("Quiere agregar foto de la mascota?");
        Fondo.add(agregarImagen);
        agregarImagen.setBounds(130, 280, 197, 23);

        lFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoMasc.jpg"))); // NOI18N
        lFondo.setText("   ");
        Fondo.add(lFondo);
        lFondo.setBounds(0, 0, 660, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo encargado de listar todas las mascotas registradas.
     * @param evt 
     */
    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        ResultSet rs = bdd.enviarConsulta("SELECT * FROM mascota;");
        imprimirResultados(rs, 0);
    }//GEN-LAST:event_listarActionPerformed
    /**
     * Metodo encargado de regsitrar a las mascotas en la base de datos, 
     * siempre y cuando pasen los chequeos necesarios. En el caso de querer subir una
     * imagen de la mascota, se abre otra ventana para poder subirla.
     * @param evt 
     */
    private void insertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertarActionPerformed
        boolean chequeo = chequeoDatos();
        if (chequeo){
            try {
                int razas = (tipoAnimal.getSelectedIndex()*6)+(raza.getSelectedIndex()+1);
                ResultSet rs = bdd.enviarConsulta("INSERT INTO mascota (nombre, descripcion, fechanacimiento, id_raza, rut_veterinaria) VALUES "
                        + "('"+ nombre.getText() +"',"
                                + "'-"+ descripcion.getText() +"',"
                                        + "'"+ fechanac.getText() +"',"
                        +  razas +","
                        + rutvet.getText() +");");
                rs = bdd.enviarConsulta("SELECT max(idmascota) from mascota");
                rs.next();
                int idMascota = rs.getInt(1);
                rs = bdd.enviarConsulta("INSERT INTO dueniomascota(ci_dueño,id_mascota) VALUES ("
                        + cidueño.getText() + ","
                        + idMascota +");");
                limpiarErrores();
                imprimirResultados(rs, 1);
                if (agregarImagen.isSelected()){
                    System.out.println("Creando la ventana con el id: "+ idMascota);
                    new SubirImagen(idMascota).setVisible(true);
                }
                nombre.setText("");
                descripcion.setText("");
                cidueño.setText("");
                rutvet.setText("");
                JOptionPane.showMessageDialog(null, "Datos ingresados con exito.");
            } catch (SQLException ex) {
                Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        


    }//GEN-LAST:event_insertarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void fechanacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechanacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechanacActionPerformed

    private void cidueñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cidueñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cidueñoActionPerformed

    private void tipoAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoAnimalActionPerformed
        try {
            llenarComboBoxes(tipoAnimal.getSelectedIndex());
        } catch (SQLException ex) {
            Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_tipoAnimalActionPerformed

    private void razaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_razaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_razaActionPerformed

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
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IngresoMascota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new IngresoMascota().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(IngresoMascota.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Titulo;
    private javax.swing.JCheckBox agregarImagen;
    private javax.swing.JTextField cidueño;
    private javax.swing.JTextField descripcion;
    private javax.swing.JFormattedTextField fechanac;
    private javax.swing.JButton insertar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lFondo;
    private javax.swing.JLabel lcidueño;
    private javax.swing.JLabel ldescripcion;
    private javax.swing.JLabel lerrorci;
    private javax.swing.JLabel lerrorvet;
    private javax.swing.JLabel lfechanac;
    private javax.swing.JButton listar;
    private javax.swing.JLabel lnombre;
    private javax.swing.JTextField nombre;
    private javax.swing.JComboBox<String> raza;
    private javax.swing.JTextArea resultado;
    private javax.swing.JTextField rutvet;
    private javax.swing.JComboBox<String> tipoAnimal;
    // End of variables declaration//GEN-END:variables
}
