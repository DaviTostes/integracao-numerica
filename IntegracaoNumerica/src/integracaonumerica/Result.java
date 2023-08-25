package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Result extends javax.swing.JFrame {

    public Result(int subintervalos, double resultadoF, double erro, ArrayList<Double> xn, ArrayList<Double> yn) {
        initComponents();
        
        labelResultF.setText("Resultado Final: " + String.format("%.5f", resultadoF));
        labelSubintervalos.setText("Subintervalos: " + (subintervalos-1));
        labelErro.setText("Erro: " + erro);
        
        Object[][] data = new Object[xn.size()][2];
        String[] columnNames = {"X", "Y"};
       
        for(int i=0; i <xn.size(); i++) {
            data[i][0] = xn.get(i);
            data[i][1] = yn.get(i);
        }

        jTable1.setModel(new DefaultTableModel(data, columnNames));
        
        // Centraliza a janela na tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelResultF = new javax.swing.JLabel();
        labelSubintervalos = new javax.swing.JLabel();
        labelErro = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(684, 462));
        setResizable(false);

        labelResultF.setText(null);

        labelSubintervalos.setText(null);

        labelErro.setText(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelErro)
                    .addComponent(labelSubintervalos)
                    .addComponent(labelResultF))
                .addGap(48, 48, 48)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(labelResultF)
                        .addGap(32, 32, 32)
                        .addComponent(labelSubintervalos)
                        .addGap(28, 28, 28)
                        .addComponent(labelErro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelErro;
    private javax.swing.JLabel labelResultF;
    private javax.swing.JLabel labelSubintervalos;
    // End of variables declaration//GEN-END:variables
}
