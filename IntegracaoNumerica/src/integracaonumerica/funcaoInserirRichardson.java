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
                int subIntervalos1 = Integer.parseInt(subTextField1.getText())+1;
                int subIntervalos2 = Integer.parseInt(subTextField2.getText())+1;

                Parser parser1 = new Parser(funcTextField.getText(), Double.parseDouble(infTextField.getText()), Double.parseDouble(supTextField.getText()), 
                subIntervalos1);

                Parser parser2 = new Parser(funcTextField.getText(), Double.parseDouble(infTextField.getText()), Double.parseDouble(supTextField.getText()), 
                subIntervalos2);

                ArrayList<Double> xn = parser1.getXn();
                ArrayList<Double> yn = parser1.getYn();

                ArrayList<Double> xn2 = parser2.getXn();
                ArrayList<Double> yn2 = parser2.getYn();

                if(metodoSelecionado == "Trapezio-R") {
                    Trapezio trap1 = new Trapezio(xn, yn);
                    Trapezio trap2 = new Trapezio(xn2, yn2);

                    Richardson richas = new Richardson(trap1, trap2, metodoSelecionado);

                    new ResultadoRichardson(trap1.calculo(), trap2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonTresOitavos-R") {
                    TresOitavosSimpson tresoit1 = new TresOitavosSimpson(xn, yn);
                    TresOitavosSimpson tresoit2 = new TresOitavosSimpson(xn2, yn2);

                    Richardson richas = new Richardson(tresoit1, tresoit2, metodoSelecionado);

                    new ResultadoRichardson(tresoit1.calculo(), tresoit2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonUmTerco-R") {
                    UmTercoSimpson umter1 = new UmTercoSimpson(xn, yn);
                    UmTercoSimpson umter2 = new UmTercoSimpson(xn2, yn2);

                    Richardson richas = new Richardson(umter1, umter2, metodoSelecionado);

                    new ResultadoRichardson(umter1.calculo(), umter2.calculo(), richas.calculoRichardson()).setVisible(true);
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
        subTextField2 = new javax.swing.JTextField();
        btnExecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Digite a Função:");

        funcTextField.setText("jTextField1");

        jLabel2.setText("Digite o limite de integração inferior:");

        infTextField.setText("jTextField2");

        jLabel3.setText("Digite o limite de integração superior:");

        supTextField.setText("jTextField3");

        jLabel4.setText("Digite o número de subintervalos do primeiro cálculo");

        subTextField1.setText("jTextField4");

        jLabel5.setText("Digite o número de subintervalos do segundo cálculo");

        subTextField2.setText("jTextField5");

        btnExecutar.setText("Executar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(subTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(subTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExecutar)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(subTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(subTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExecutar)
                .addContainerGap(40, Short.MAX_VALUE))
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
