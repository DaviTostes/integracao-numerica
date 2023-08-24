package integracaonumerica;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class InterfacePrincipal extends javax.swing.JFrame {

    public InterfacePrincipal() {
        
        initComponents();

        String caminhoDoIcone = "/resources/logo.png";
        ImageIcon iconePersonalizado = new ImageIcon(getClass().getResource(caminhoDoIcone));
        Image imagemDoIcone = iconePersonalizado.getImage();
        setIconImage(imagemDoIcone);

        btnTrapezio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelecionar("Trapezio").setVisible(true);
            }
        });
        
        btnSimpson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new simpsonSelecionar().setVisible(true);
            }
        });
        
        btnRichardson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new richardsonSelecionar().setVisible(true);
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
        btnTrapezio = new javax.swing.JButton();
        btnSimpson = new javax.swing.JButton();
        btnRichardson = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Selecionar Método");
        setBackground(new java.awt.Color(153, 153, 153));
        setName("InterfaceMain"); // NOI18N
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Selecione o Método desejado");

        btnTrapezio.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnTrapezio.setText("Trapezio");
        btnTrapezio.setFocusPainted(false);

        btnSimpson.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnSimpson.setText("Simpson");
        btnSimpson.setFocusPainted(false);

        btnRichardson.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btnRichardson.setText("Richardson");
        btnRichardson.setFocusPainted(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTrapezio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSimpson)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRichardson))
                    .addComponent(jLabel1))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrapezio)
                    .addComponent(btnSimpson)
                    .addComponent(btnRichardson))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfacePrincipal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRichardson;
    private javax.swing.JButton btnSimpson;
    private javax.swing.JButton btnTrapezio;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
