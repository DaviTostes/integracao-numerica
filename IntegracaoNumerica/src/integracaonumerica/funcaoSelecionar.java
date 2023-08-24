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
                    new InserirFuncaoRichardson(metodoSelecionado).setVisible(true);
                } else {
                    new InserirFuncao(metodoSelecionado).setVisible(true);
                }
                dispose();
            }
        });
        
        btnPontos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeitorDeArquivo(metodoSelecionado).setVisible(true);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnFuncao.setText("Função");

        btnPontos.setText("Pontos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(btnFuncao)
                .addGap(33, 33, 33)
                .addComponent(btnPontos)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFuncao)
                    .addComponent(btnPontos))
                .addGap(122, 122, 122))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncao;
    private javax.swing.JButton btnPontos;
    // End of variables declaration//GEN-END:variables
}