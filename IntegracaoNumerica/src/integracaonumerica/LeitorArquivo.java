package integracaonumerica;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class LeitorArquivo extends javax.swing.JFrame {
    
    private ArrayList<Double> xn = new ArrayList<>();
    private ArrayList<Double> yn = new ArrayList<>();
    private Trapezio trapezio1;
    private TresOitavosSimpson tresOitavosSimpson;
    private UmTercoSimpson umTercoSimpson;

    public LeitorArquivo(String metodoSelecionado) {
        initComponents();
        
        // Adicione um ActionListener para o botão "Abrir".
        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crie um objeto JFileChooser.
                JFileChooser fileChooser = new JFileChooser();

                // Exiba o diálogo de seleção de arquivo e aguarde até que o usuário selecione um arquivo ou cancele a ação.
                int result = fileChooser.showOpenDialog(null);

                // Se o usuário selecionar um arquivo, obtenha o caminho e exiba no campo de texto.
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    fieldPath.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        // Adicione um ActionListener para o botão "Executar".
        btnExecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String path = fieldPath.getText();
                if (!path.isEmpty()) {
                    File fileToExecute = new File(path);
                    if (fileToExecute.exists() && fileToExecute.isFile() && fileToExecute.getName().endsWith(".dat")) {
                        try {
                            int subIntervalos = Integer.parseInt(fieldNum.getText())+1;
                            int counter = 0;

                            try(BufferedReader br = new BufferedReader(new FileReader(path))) {
                                String linha = "";

                                while((linha = br.readLine()) != null) {
                                    String x = linha.split("\\s+")[0];
                                    String y = linha.split("\\s+")[1];
                                    counter++;

                                    if(counter <= subIntervalos) {
                                        xn.add(Double.valueOf(x));
                                        yn.add(Double.valueOf(y));
                                    }
                                }
                            } 
                            catch (IOException ex) {
                                JOptionPane.showMessageDialog(null, "Erro ao ler o arquivo:"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                                dispose();
                            }

                            Derivada derivada = new Derivada(subIntervalos, xn, yn);

                            if(metodoSelecionado == "Trapezio"){
                                trapezio1 = new Trapezio(xn, yn);

                                //new Resultado(subIntervalos, trapezio1.calculo(), trapezio1.erro(derivada.DerivadaSegunda())).setVisible(true);
                                xn.clear();
                                yn.clear();
                            }
                            
                            if(metodoSelecionado == "SimpsonTresOitavos"){                                
                                tresOitavosSimpson = new TresOitavosSimpson(xn, yn);

                                //new Resultado(subIntervalos, tresOitavosSimpson.calculo(), tresOitavosSimpson.erro(derivada.DerivadaSegunda())).setVisible(true);
                                xn.clear();
                                yn.clear();
                            }
                            
                            if(metodoSelecionado == "SimpsonUmTerco"){                             
                                umTercoSimpson = new UmTercoSimpson(xn, yn);

                                //new Resultado(subIntervalos, umTercoSimpson.calculo(), umTercoSimpson.erro(derivada.DerivadaSegunda())).setVisible(true);
                                xn.clear();
                                yn.clear();
                            }

                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo de texto válido.", "Arquivo Inválido", JOptionPane.WARNING_MESSAGE);
                    }
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
        jLabel2 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        btnExecutar = new javax.swing.JButton();
        fieldPath = new javax.swing.JTextField();
        fieldNum = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 300));
        setResizable(false);

        jLabel1.setText("Caminho do arquivo selecionado:");

        jLabel2.setText("Digite o numero de subintervalos:");

        btnAbrir.setText("Abrir");

        btnExecutar.setText("Executar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(fieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnExecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(fieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAbrir)))
                .addContainerGap(87, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExecutar))
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnExecutar;
    private javax.swing.JTextField fieldNum;
    private javax.swing.JTextField fieldPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}