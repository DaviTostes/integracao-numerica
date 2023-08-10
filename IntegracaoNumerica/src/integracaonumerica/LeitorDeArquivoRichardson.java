package integracaonumerica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeitorDeArquivoRichardson extends JFrame {

    private JTextField filePathTextField;
    private JTextField filePathTextField2;
    private JTextField numberTextField;
    private JTextField numberTextField2;
    private JButton openButton;
    private JButton openButton2;
    private JButton executeButton;
    private JCheckBox foldersOnlyCheckbox;
    private ArrayList<Double> xn = new ArrayList<>();
    private ArrayList<Double> yn = new ArrayList<>();
    private ArrayList<Double> xn2 = new ArrayList<>();
    private ArrayList<Double> yn2 = new ArrayList<>();
    private Trapezio trapezio1;
    private Trapezio trapezio2;

    public LeitorDeArquivoRichardson() {
        setTitle("Seletor de Arquivos e Pastas");
        setSize(500, 200);
        setResizable(false); // Desabilita o redimensionamento da janela
        setLayout(new FlowLayout());
        
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 500) / 2;
        int y = (tamanhoTela.height - 150) / 2;
        setLocation(x, y);

        // Adicione um rótulo explicativo
        JLabel label = new JLabel("Caminho do arquivo/pasta selecionado:");
        JLabel label2 = new JLabel("Caminho do arquivo/pasta selecionado:");

        // Crie o botão "Abrir" e o campo de texto para exibir o caminho do arquivo selecionado.
        filePathTextField = new JTextField(30);
        openButton = new JButton("Abrir");
        JLabel numberLabel2 = new JLabel("Digite a quantidade de subintervalos:");
        numberTextField2 = new JTextField(5);
        filePathTextField2 = new JTextField(30);
        openButton2 = new JButton("Abrir");
        JLabel numberLabel = new JLabel("Digite a quantidade de subintervalos:");
        numberTextField = new JTextField(5);
        executeButton = new JButton("Executar");

        // Defina o tamanho da fonte dos botões para torná-los mais proeminentes
        openButton.setFont(new Font("Arial", Font.BOLD, 14));
        openButton2.setFont(new Font("Arial", Font.BOLD, 14));

        executeButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Adicione uma caixa de seleção para permitir que o usuário escolha arquivos ou pastas
        foldersOnlyCheckbox = new JCheckBox("Selecionar apenas pastas");
        foldersOnlyCheckbox.setSelected(false); // Padrão é selecionar arquivos e pastas

        // Adicione um ActionListener para o botão "Abrir".
        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crie um objeto JFileChooser.
                JFileChooser fileChooser = new JFileChooser();

                // Configurar para selecionar apenas pastas, se a caixa de seleção estiver marcada
                fileChooser.setFileSelectionMode(foldersOnlyCheckbox.isSelected() ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_AND_DIRECTORIES);

                // Exiba o diálogo de seleção de arquivo e aguarde até que o usuário selecione um arquivo ou cancele a ação.
                int result = fileChooser.showOpenDialog(null);

                // Se o usuário selecionar um arquivo, obtenha o caminho e exiba no campo de texto.
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathTextField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        openButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Crie um objeto JFileChooser.
                JFileChooser fileChooser = new JFileChooser();

                // Configurar para selecionar apenas pastas, se a caixa de seleção estiver marcada
                fileChooser.setFileSelectionMode(foldersOnlyCheckbox.isSelected() ? JFileChooser.DIRECTORIES_ONLY : JFileChooser.FILES_AND_DIRECTORIES);

                // Exiba o diálogo de seleção de arquivo e aguarde até que o usuário selecione um arquivo ou cancele a ação.
                int result = fileChooser.showOpenDialog(null);

                // Se o usuário selecionar um arquivo, obtenha o caminho e exiba no campo de texto.
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    filePathTextField2.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        // Adicione um ActionListener para o botão "Executar".
        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String path = filePathTextField.getText();
                if (!path.isEmpty()) {
                    File fileToExecute = new File(path);
                    if (fileToExecute.exists() && fileToExecute.isFile() && fileToExecute.getName().endsWith(".dat")) {
                        try {
                            int subIntervalos = Integer.parseInt(numberTextField.getText())+1;
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

                                trapezio1 = new Trapezio(xn, yn);
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

                String path2 = filePathTextField2.getText();
                 if (!path2.isEmpty()) {
                    File fileToExecute = new File(path2);
                    if (fileToExecute.exists() && fileToExecute.isFile() && fileToExecute.getName().endsWith(".dat")) {
                        try {
                            int subIntervalos = Integer.parseInt(numberTextField2.getText())+1;
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

                                trapezio2 = new Trapezio(xn2, yn2);

                                Richardson richardson = new Richardson(trapezio1, trapezio2);

                                new Resultado(subIntervalos, richardson.calculoRichardson()).setVisible(true);;
                                
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

        // Adicione os componentes à janela.
        add(label);
        add(filePathTextField);
        add(openButton);
        add(numberLabel2);
        add(numberTextField2);
        add(label2);
        add(filePathTextField2);
        add(openButton2);
        add(numberLabel);
        add(numberTextField);
        add(executeButton);
        add(foldersOnlyCheckbox);
    }
}