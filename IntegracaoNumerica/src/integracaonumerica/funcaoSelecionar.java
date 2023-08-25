package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class funcaoSelecionar extends javax.swing.JFrame {

    public funcaoSelecionar(String metodoSelecionado) {
        initComponents();
        
        btnFuncao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(metodoSelecionado.contains("-R")) {
                    new funcaoInserirRichardson(metodoSelecionado).setVisible(true);
                } else {
                    new funcaoInserir(metodoSelecionado).setVisible(true);
                }
                dispose();
            }
        });
        
        btnPontos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(metodoSelecionado.contains("-R")) {
                    new LeitorArquivoRichardson(metodoSelecionado).setVisible(true);
                } else{
                    new LeitorArquivo(metodoSelecionado).setVisible(true);
                }  
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

        btnFuncao = new javax.swing.JButton();
        btnPontos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(316, 175));

        btnFuncao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnFuncao.setText("Função");
        btnFuncao.setFocusPainted(false);

        btnPontos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnPontos.setText("Pontos");
        btnPontos.setFocusPainted(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Selecione o meio a ser calculado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnFuncao)
                        .addGap(70, 70, 70)
                        .addComponent(btnPontos))
                    .addComponent(jLabel1))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncao)
                    .addComponent(btnPontos))
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncao;
    private javax.swing.JButton btnPontos;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}