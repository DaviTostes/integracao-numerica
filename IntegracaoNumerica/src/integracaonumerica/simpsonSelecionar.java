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

        btnSimpsonOitavos = new javax.swing.JButton();
        btnSimpsonTerco = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSimpsonOitavos.setText("Simpson Oitavos");

        btnSimpsonTerco.setText("Simpson Terco");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btnSimpsonOitavos)
                .addGap(43, 43, 43)
                .addComponent(btnSimpsonTerco)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(140, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpsonOitavos)
                    .addComponent(btnSimpsonTerco))
                .addGap(137, 137, 137))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpsonOitavos;
    private javax.swing.JButton btnSimpsonTerco;
    // End of variables declaration//GEN-END:variables
}