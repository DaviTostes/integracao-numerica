package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class richardsonSelecionar extends javax.swing.JFrame {

    public richardsonSelecionar() {
        initComponents();
        
        btnTrapezio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("Trapezio-R").setVisible(true);
                dispose();
            }
        });
        
        btnSimpsonOitavos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("SimpsonTresOitavos-R").setVisible(true);
                dispose();
            }
        });
        
        btnSimpsonTerco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("SimpsonUmTerco-R").setVisible(true);
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

        jLabel1 = new javax.swing.JLabel();
        btnSimpsonOitavos = new javax.swing.JButton();
        btnSimpsonTerco = new javax.swing.JButton();
        btnTrapezio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Selecione o método desejado para RIchardson");

        btnSimpsonOitavos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSimpsonOitavos.setText("Três Oitavos");
        btnSimpsonOitavos.setFocusPainted(false);

        btnSimpsonTerco.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSimpsonTerco.setText("Um Terço");
        btnSimpsonTerco.setFocusPainted(false);

        btnTrapezio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnTrapezio.setText("Trapézio");
        btnTrapezio.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTrapezio)
                        .addGap(24, 24, 24)
                        .addComponent(btnSimpsonTerco)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpsonOitavos)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jLabel1)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpsonOitavos)
                    .addComponent(btnTrapezio)
                    .addComponent(btnSimpsonTerco))
                .addContainerGap(99, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpsonOitavos;
    private javax.swing.JButton btnSimpsonTerco;
    private javax.swing.JButton btnTrapezio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
