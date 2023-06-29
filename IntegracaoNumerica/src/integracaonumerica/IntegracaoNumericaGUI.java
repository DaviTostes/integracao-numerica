import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class IntegracaoNumericaGUI extends JFrame {

    private JTextField fileTextField;
    private JTextField functionTextField;
    private JTextField kTextField;
    private JTextArea resultTextArea;

    public IntegracaoNumericaGUI() {
        setTitle("Numerical Integration");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new BorderLayout());

        // File selection panel
        JPanel filePanel = new JPanel(new BorderLayout());
        JLabel fileLabel = new JLabel("File:");
        fileTextField = new JTextField(20);
        JButton fileBrowseButton = new JButton("Browse");
        fileBrowseButton.addActionListener(new FileBrowseListener());

        filePanel.add(fileLabel, BorderLayout.WEST);
        filePanel.add(fileTextField, BorderLayout.CENTER);
        filePanel.add(fileBrowseButton, BorderLayout.EAST);

        // Function input panel
        JPanel functionPanel = new JPanel(new BorderLayout());
        JLabel functionLabel = new JLabel("F(x):");
        functionTextField = new JTextField(20);

        functionPanel.add(functionLabel, BorderLayout.WEST);
        functionPanel.add(functionTextField, BorderLayout.CENTER);

        // k input panel
        JPanel kPanel = new JPanel(new BorderLayout());
        JLabel kLabel = new JLabel("k:");
        kTextField = new JTextField(10);

        kPanel.add(kLabel, BorderLayout.WEST);
        kPanel.add(kTextField, BorderLayout.CENTER);

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateListener());

        // Result panel
        JPanel resultPanel = new JPanel(new BorderLayout());
        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultTextArea);

        resultPanel.add(scrollPane, BorderLayout.CENTER);

        // Add components to the main frame
        add(filePanel, BorderLayout.NORTH);
        add(functionPanel, BorderLayout.CENTER);
        add(kPanel, BorderLayout.SOUTH);
        add(calculateButton, BorderLayout.EAST);
        add(resultPanel, BorderLayout.WEST);
    }

    private class FileBrowseListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(IntegracaoNumericaGUI.this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                fileTextField.setText(selectedFile.getAbsolutePath());
            }
        }
    }

    private class CalculateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String filePath = fileTextField.getText();
            String function = functionTextField.getText();
            double k = Double.parseDouble(kTextField.getText());

            Path path = Paths.get(filePath);

            double a, b, numSubintervalos;

            try {
                String data = new String(Files.readAllBytes(path));
                String[] values = data.split("\n");

                StringBuilder resultBuilder = new StringBuilder();

                for (int i = 0; i < values.length; i += 3) {
                    a = Double.parseDouble(values[i]);
                    b = Double.parseDouble(values[i + 1]);
                    numSubintervalos = Double.parseDouble(values[i + 2]);

                    Calculo mainCalculo = new Calculo(function);
                    resultBuilder.append("Simpson: ").append(mainCalculo.CalculoSimpson(a, b, numSubintervalos)).append("\n");
                    resultBuilder.append("Trapezio: ").append(mainCalculo.CalculoTrapezio(a, b, numSubintervalos)).append("\n");
                    resultBuilder.append("Richardson: ").append(mainCalculo.CalculoRichardson(a, b, numSubintervalos, k)).append("\n");
                }

                resultTextArea.setText(resultBuilder.toString());
            } catch (IOException ex) {
                resultTextArea.setText("Error reading the file: " + ex.getMessage());
            }
        }
    }