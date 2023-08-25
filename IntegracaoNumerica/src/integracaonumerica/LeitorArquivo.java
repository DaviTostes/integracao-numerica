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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        fieldPath = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnAbrir = new javax.swing.JButton();
        fieldNum = new javax.swing.JTextField();
        btnExecutar = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 250, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Leitor de Arquivo");
        setMinimumSize(new java.awt.Dimension(559, 227));
        setResizable(false);
        setSize(new java.awt.Dimension(550, 250));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Caminho do arquivo selecionado:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
        getContentPane().add(fieldPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 320, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Digite o numero de subintervalos:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, -1, -1));

        btnAbrir.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnAbrir.setText("Abrir");
        btnAbrir.setFocusPainted(false);
        getContentPane().add(btnAbrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 60, -1, -1));
        getContentPane().add(fieldNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 72, -1));

        btnExecutar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExecutar.setText("Executar");
        btnExecutar.setFocusPainted(false);
        getContentPane().add(btnExecutar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrir;
    private javax.swing.JButton btnExecutar;
    private javax.swing.JTextField fieldNum;
    private javax.swing.JTextField fieldPath;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}