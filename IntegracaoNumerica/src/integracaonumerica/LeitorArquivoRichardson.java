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

public class LeitorArquivoRichardson extends javax.swing.JFrame {
    
    private ArrayList<Double> xn = new ArrayList<>();
    private ArrayList<Double> yn = new ArrayList<>();
    private ArrayList<Double> xn2 = new ArrayList<>();
    private ArrayList<Double> yn2 = new ArrayList<>();

    public LeitorArquivoRichardson(String metodoSelecionado) {
        initComponents();
        
        // Adicione um ActionListener para o botão "Abrir".
        btnAbrir1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crie um objeto JFileChooser.
                JFileChooser fileChooser = new JFileChooser();

                // Exiba o diálogo de seleção de arquivo e aguarde até que o usuário selecione um arquivo ou cancele a ação.
                int result = fileChooser.showOpenDialog(null);

                // Se o usuário selecionar um arquivo, obtenha o caminho e exiba no campo de texto.
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    btnPath1.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        btnAbrir2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crie um objeto JFileChooser.
                JFileChooser fileChooser = new JFileChooser();

                // Exiba o diálogo de seleção de arquivo e aguarde até que o usuário selecione um arquivo ou cancele a ação.
                int result = fileChooser.showOpenDialog(null);

                // Se o usuário selecionar um arquivo, obtenha o caminho e exiba no campo de texto.
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    btnPath2.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        // Adicione um ActionListener para o botão "Executar".
        btnExecutar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String path = btnPath1.getText();
                if (!path.isEmpty()) {
                    File fileToExecute = new File(path);
                    if (fileToExecute.exists() && fileToExecute.isFile() && fileToExecute.getName().endsWith(".dat")) {
                        try {
                            int subIntervalos = Integer.parseInt(btnSubInter1.getText())+1;
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
                                System.out.println("Erro ao ler o arquivo: " + ex.getMessage());
                            }
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecione um arquivo de texto válido.", "Arquivo Inválido", JOptionPane.WARNING_MESSAGE);
                    }
                }

                String path2 = btnPath2.getText();
                 if (!path2.isEmpty()) {
                    File fileToExecute = new File(path2);
                    if (fileToExecute.exists() && fileToExecute.isFile() && fileToExecute.getName().endsWith(".dat")) {
                        try {
                            int subIntervalos = Integer.parseInt(btnSubInter2.getText())+1;
                            int counter = 0;

                            try(BufferedReader br = new BufferedReader(new FileReader(path2))) {
                                String linha = "";

                                while((linha = br.readLine()) != null) {
                                    String x = linha.split("\\s+")[0];
                                    String y = linha.split("\\s+")[1];
                                    counter++;

                                    if(counter <= subIntervalos) {
                                        xn2.add(Double.valueOf(x));
                                        yn2.add(Double.valueOf(y));
                                    }
                                }

                                if(metodoSelecionado == "Trapezio") {
                                    Trapezio m1 = new Trapezio(xn, yn);
                                    Trapezio m2 = new Trapezio(xn2, yn2);
                                    Richardson richas = new Richardson(m1, m2, metodoSelecionado);

                                    new ResultadoRichardson(m1.calculo(), m2.calculo(), richas.calculoRichardson()).setVisible(true);
                                }

                                if(metodoSelecionado == "SimpsonTresOitavos") {
                                    TresOitavosSimpson m1 = new TresOitavosSimpson(xn, yn);
                                    TresOitavosSimpson m2 = new TresOitavosSimpson(xn2, yn2);
                                    Richardson richas = new Richardson(m1, m2, metodoSelecionado);

                                    new ResultadoRichardson(m1.calculo(), m2.calculo(), richas.calculoRichardson()).setVisible(true);
                                }

                                if(metodoSelecionado == "SimpsonUmTerco") {
                                    UmTercoSimpson m1 = new UmTercoSimpson(xn, yn);
                                    UmTercoSimpson m2 = new UmTercoSimpson(xn2, yn2);
                                    Richardson richas = new Richardson(m1, m2, metodoSelecionado);

                                    new ResultadoRichardson(m1.calculo(), m2.calculo(), richas.calculoRichardson()).setVisible(true);
                                }

                                xn.clear();
                                yn.clear();
                                xn2.clear();
                                yn2.clear();
                            } 
                            catch (IOException ex) {
                                System.out.println("Erro ao ler o arquivo: " + ex.getMessage());
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
        btnPath1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnSubInter1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnAbrir2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSubInter2 = new javax.swing.JTextField();
        btnExecutar = new javax.swing.JButton();
        btnAbrir1 = new javax.swing.JButton();
        btnPath2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Caminho do primeiro arquivo selecionado:");

        btnPath1.setText("jTextField1");

        jLabel2.setText("Digite os subintervalos");

        btnSubInter1.setText("jTextField2");

        jLabel3.setText("Caminho do segundo arquivo selecionado:");

        btnAbrir2.setText("Abrir");

        jLabel4.setText("Digite os subintervalos");

        btnSubInter2.setText("jTextField4");

        btnExecutar.setText("Executar");

        btnAbrir1.setText("Abrir");

        btnPath2.setText("jTextField3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(45, 45, 45)
                                .addComponent(btnSubInter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnPath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel4)
                                .addGap(53, 53, 53)
                                .addComponent(btnSubInter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnPath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81)
                                .addComponent(btnAbrir2))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnAbrir1)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(btnExecutar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jLabel3)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPath1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAbrir1))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(btnSubInter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAbrir2)
                    .addComponent(btnPath2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(btnSubInter2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnExecutar)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir1;
    private javax.swing.JButton btnAbrir2;
    private javax.swing.JButton btnExecutar;
    private javax.swing.JTextField btnPath1;
    private javax.swing.JTextField btnPath2;
    private javax.swing.JTextField btnSubInter1;
    private javax.swing.JTextField btnSubInter2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
