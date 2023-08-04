package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class SeletorDeMetodo extends JFrame {
    private JButton openButton;

    public SeletorDeMetodo(){
        setTitle("Seletor de metodo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setResizable(false); // Desabilita o redimensionamento da janela
        setLayout(new FlowLayout());
            
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 1000) / 2;
        int y = (tamanhoTela.height - 500) / 2;
        setLocation(x, y);

        openButton = new JButton("Abrir");
        openButton.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel label = new JLabel("Caminho do arquivo/pasta selecionado:");

        openButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeitorDeArquivo().setVisible(true);
            }
        });
 
        add(openButton);
        add(label);
    }

    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new SeletorDeMetodo().setVisible(true);
                }
        });
    }
}
