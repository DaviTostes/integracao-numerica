package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class funcaoInserirRichardson extends javax.swing.JFrame {

    public funcaoInserirRichardson(String metodoSelecionado) {
        initComponents();
        
        btnExecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int subIntervalos1 = Integer.parseInt(subTextField1.getText());
                int subIntervalos2 = Integer.parseInt(subTextField2.getText());

                Parser parser1 = new Parser(funcTextField.getText(), Double.parseDouble(infTextField.getText()), Double.parseDouble(supTextField.getText()), 
                subIntervalos1);

                Parser parser2 = new Parser(funcTextField.getText(), Double.parseDouble(infTextField.getText()), Double.parseDouble(supTextField.getText()), 
                subIntervalos2);

                ArrayList<Double> xn = parser1.getXn();
                ArrayList<Double> yn = parser1.getYn(xn);

                ArrayList<Double> xn2 = parser2.getXn();
                ArrayList<Double> yn2 = parser2.getYn(xn2);

                if(metodoSelecionado == "Trapezio-R") {
                    Trapezio trap1 = new Trapezio(xn, yn);
                    Trapezio trap2 = new Trapezio(xn2, yn2);

                    Richardson richas = new Richardson(trap1, trap2, metodoSelecionado);

                    new ResultRichardson(trap1.calculo(), trap2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonTresOitavos-R") {
                    TresOitavosSimpson tresoit1 = new TresOitavosSimpson(xn, yn);
                    TresOitavosSimpson tresoit2 = new TresOitavosSimpson(xn2, yn2);

                    Richardson richas = new Richardson(tresoit1, tresoit2, metodoSelecionado);

                    new ResultRichardson(tresoit1.calculo(), tresoit2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonUmTerco-R") {
                    UmTercoSimpson umter1 = new UmTercoSimpson(xn, yn);
                    UmTercoSimpson umter2 = new UmTercoSimpson(xn2, yn2);

                    Richardson richas = new Richardson(umter1, umter2, metodoSelecionado);

                    new ResultRichardson(umter1.calculo(), umter2.calculo(), richas.calculoRichardson()).setVisible(true);
                }
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
        funcTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        infTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        supTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        subTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnExecutar = new javax.swing.JButton();
        subTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(570, 330));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Digite a Função:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Limite Inferior:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Limite Superior:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Subintervalos do primeiro cálculo:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Subintervalos do segundo cálculo:");

        btnExecutar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExecutar.setText("Executar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(subTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                            .addComponent(subTextField2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(btnExecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(subTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(subTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnExecutar)
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExecutar;
    private javax.swing.JTextField funcTextField;
    private javax.swing.JTextField infTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField subTextField1;
    private javax.swing.JTextField subTextField2;
    private javax.swing.JTextField supTextField;
    // End of variables declaration//GEN-END:variables
}
