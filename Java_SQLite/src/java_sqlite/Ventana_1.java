
package java_sqlite;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Ventana_1 extends javax.swing.JFrame {
    String[] equipos_L1 = {"Alumbrado", "Pasteurizado", "Posimat", "Rinser", "Robopack", "Via de botellas", "Via de cajas",
                        "Transporte de tapas", "Bulk", "Codificadores", "Etiquetado", "Inspectores", "Llenadora", "Ocme",
                        "Paletizado", "Paster flash"};
    
    Object[] s = {"", ""};
    String readTable = "Alumbrado";
    
    DefaultTableModel datos = new DefaultTableModel();
    Conector conector;

    public Ventana_1() {
        
        initComponents();
        tabla.setModel(datos);
        datos.addColumn("Codigo");
        datos.addColumn("Descripcion");
        
        setLocationRelativeTo(null);
        equipoCB.addActionListener(new onSelect(0));
        jButton1.addActionListener(new onSelect(1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        equipoCB = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(600, 500));

        java.awt.GridBagLayout jPanel1Layout = new java.awt.GridBagLayout();
        jPanel1Layout.rowWeights = new double[] {0.0, 1.0};
        jPanel1.setLayout(jPanel1Layout);

        equipoCB.setModel(new javax.swing.DefaultComboBoxModel<>(equipos_L1));
        equipoCB.setMinimumSize(new java.awt.Dimension(150, 25));
        equipoCB.setPreferredSize(new java.awt.Dimension(150, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 8, 11, 8);
        jPanel1.add(equipoCB, gridBagConstraints);

        jButton1.setText("Generar");
        jButton1.setMaximumSize(new java.awt.Dimension(75, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(75, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(75, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 1.1;
        gridBagConstraints.insets = new java.awt.Insets(11, 0, 11, 0);
        jPanel1.add(jButton1, gridBagConstraints);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Descripcion"
            }
        ));
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane2.setViewportView(tabla);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(jScrollPane2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
//-----------------------------------------------------------------------------
    public class onSelect implements ActionListener{
        private int id;

        public onSelect(int a) {
            id = a;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            switch (id){
                case 0:
                    int indxEqup = equipoCB.getSelectedIndex();
                    optionSelected(indxEqup);
                    break;
                    
                case 1:
                    deleteTable();
                    conector = new Conector();
                    conector.connect();
                    conector.buscarTodo(readTable);
                    
                    for (int i = 0; i < conector.getListaCodigo().size(); i++) {
                        s[0] = conector.getListaCodigo().get(i);
                        s[1] = conector.getListaDescripcion().get(i);
                        fillTable(s);
                    }
                    
                    conector.close();
                    System.out.println(tabla.getRowCount());
                    break;
            }
        }
        
//-----------------------------------------------------------------------------        
    }
    
    private void fillTable(Object[] cod){
        Object[] fila = cod;
        datos.addRow(fila);
    }
    
    private void deleteTable(){
        int elementosNum = datos.getRowCount();
        datos.setNumRows(0);
        /*if (elementosNum > 0) {
            for (int i = 0; i < elementosNum; i++) {
            datos.removeRow(i);
            }
        }*/
    }
    
    private void optionSelected(int indxSel){
        switch (indxSel){
            case 0:
                readTable = "Alumbrado";
                break;
            case 1:
                readTable = "Pasteurizado";
                break;
            case 2:
                readTable = "Posimat";
                break;
            case 3:
                readTable = "Rinser";
                break;
            case 4:
                readTable = "RoboPack";
                break;
            case 5:
                readTable = "ViaBotellas";
                break;
            case 6:
                readTable = "ViaCajas";
                break;
            case 7:
                readTable = "Transportedetapas";
                break;
            case 8:
                readTable = "Bulk";
                break;
            case 9:
                readTable = "Codificadores";
                break;
            case 10:
                readTable = "Etiquetado";
                break;
            case 11:
                readTable = "Inspectores";
                break;
            case 12:
                readTable = "Llenadoras";
                break;
            case 13:
                readTable = "Ocme";
                break;
            case 14:
                readTable = "Paletizado";
                break;
            case 15:
                readTable = "PasterFlash";
                break;
        }
    }
    
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
            java.util.logging.Logger.getLogger(Ventana_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> equipoCB;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
