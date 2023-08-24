package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class funcaoInserir extends javax.swing.JFrame {

    public funcaoInserir(String metodoSelecionado) {
        initComponents();
        
        btnExecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int subIntervalos = Integer.parseInt(subTextField.getText())+1;

                Parser parser = new Parser(funcTextField.getText(), Double.parseDouble(infTextField.getText()), Double.parseDouble(supTextField.getText()), 
                subIntervalos);

                ArrayList<Double> xn = parser.getXn();
                ArrayList<Double> yn = parser.getYn();

                Derivada derivada = new Derivada(subIntervalos, xn, yn);

                if(metodoSelecionado == "Trapezio") {
                    Trapezio trap = new Trapezio(xn, yn);

                    new Resultado(subIntervalos, trap.calculo(), trap.erro(derivada.DerivadaSegunda()), xn, yn).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonTresOitavos") {
                    TresOitavosSimpson tresoit = new TresOitavosSimpson(xn, yn);

                    new Resultado(subIntervalos, tresoit.calculo(), tresoit.erro(derivada.DerivadaQuarta()), xn, yn).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonUmTerco") {
                    UmTercoSimpson umter = new UmTercoSimpson(xn, yn);

                    new Resultado(subIntervalos, umter.calculo(), umter.erro(derivada.DerivadaQuarta()), xn, yn).setVisible(true);
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
        subTextField = new javax.swing.JTextField();
        btnExecutar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Digite a função:");

        funcTextField.setText("jTextField1");

        jLabel2.setText("Dgiite o limite da integração inferior:");

        infTextField.setText("jTextField2");

        jLabel3.setText("Digite o limite da integração superior:");

        supTextField.setText("jTextField3");

        jLabel4.setText("Digite o numero de subintervalos:");

        subTextField.setText("jTextField4");

        btnExecutar.setText("Executar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(subTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnExecutar)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(funcTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(infTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(supTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(subTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(btnExecutar)
                .addContainerGap(42, Short.MAX_VALUE))
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
    private javax.swing.JTextField subTextField;
    private javax.swing.JTextField supTextField;
    // End of variables declaration//GEN-END:variables
}
