package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class simpsonSelecionar extends javax.swing.JFrame {

    public simpsonSelecionar() {
        initComponents();
        
        btnSimpsonOitavos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("SimpsonTresOitavos").setVisible(true);
                dispose();
            }
        });
        
        btnSimpsonTerco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("SimpsonUmTerco").setVisible(true);
                dispose();
            }
        });
        
        // Centraliza a janela na tela
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSimpsonTerco = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnSimpsonOitavos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(391, 243));

        btnSimpsonTerco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSimpsonTerco.setText("Um Terço");
        btnSimpsonTerco.setFocusPainted(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Selecione a regra de Simpson");

        btnSimpsonOitavos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSimpsonOitavos.setText("Três Oitavos");
        btnSimpsonOitavos.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSimpsonTerco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpsonOitavos))
                    .addComponent(jLabel1))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpsonOitavos, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpsonTerco, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpsonOitavos;
    private javax.swing.JButton btnSimpsonTerco;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}