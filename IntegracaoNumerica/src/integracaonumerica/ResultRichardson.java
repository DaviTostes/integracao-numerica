package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ResultRichardson extends javax.swing.JFrame {

    public ResultRichardson(double resultado1, double resultado2, double resultadoF, ArrayList<Double> xn, ArrayList<Double> yn,
             ArrayList<Double> xn2, ArrayList<Double> yn2) {
        initComponents();
        
        labelResult1.setText("Valor Primeira Integral: " + String.format("%.5f", resultado1));
        labelResult2.setText("Valor Segunda Integral: " + String.format("%.5f", resultado2));
        labelResultF.setText("Valor Melhorado da Integral: " + String.format("%.5f", resultadoF));
        
        Object[][] data = new Object[xn.size()][2];
        Object[][] data2 = new Object[xn2.size()][2];
        String[] columnNames = {"X", "Y"};
       
        for(int i=0; i <xn.size(); i++) {
            data[i][0] = xn.get(i);
            data[i][1] = yn.get(i);
        }
        
        for(int i=0; i <xn2.size(); i++) {
            data2[i][0] = xn2.get(i);
            data2[i][1] = yn2.get(i);
        }

        jTable1.setModel(new DefaultTableModel(data, columnNames));
        jTable2.setModel(new DefaultTableModel(data2, columnNames));
        
        // Centraliza a janela na tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelResult1 = new javax.swing.JLabel();
        labelResult2 = new javax.swing.JLabel();
        labelResultF = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(700, 450));
        setPreferredSize(new java.awt.Dimension(900, 450));

        labelResult1.setText(null);

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
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelResultF)
                    .addComponent(labelResult1)
                    .addComponent(labelResult2))
                .addGap(66, 66, 66)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelResult1)
                        .addGap(38, 38, 38)
                        .addComponent(labelResult2)
                        .addGap(37, 37, 37)
                        .addComponent(labelResultF)))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel labelResult1;
    private javax.swing.JLabel labelResult2;
    private javax.swing.JLabel labelResultF;
    // End of variables declaration//GEN-END:variables
}
