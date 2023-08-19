package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class InterfaceMain extends JFrame {
    private JButton btnTrapezio;
    private JButton btnSimpson;
    private JButton btnRichardson;

    public InterfaceMain(){
        setTitle("Seletor de metodo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setResizable(false); // Desabilita o redimensionamento da janela
        setLayout(new FlowLayout());
            
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 1000) / 2;
        int y = (tamanhoTela.height - 500) / 2;
        setLocation(x, y);

        String caminhoDoIcone = "/resources/logo.png";
        ImageIcon iconePersonalizado = new ImageIcon(getClass().getResource(caminhoDoIcone));
        Image imagemDoIcone = iconePersonalizado.getImage();
        setIconImage(imagemDoIcone);
        
        JLabel label = new JLabel("Selecione o método desejado");
        
        btnTrapezio = new JButton("Trapezio");
        btnTrapezio.setFont(new Font("Arial", Font.BOLD, 14));

        btnTrapezio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new funcaoSelect("Trapezio").setVisible(true);
            }
        });
        
        btnSimpson = new JButton("Simpson");
        btnSimpson.setFont(new Font("Arial", Font.BOLD, 14));

        btnSimpson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SimpsonSelect().setVisible(true);
            }
        });
        
        btnRichardson = new JButton("Richardson");
        btnRichardson.setFont(new Font("Arial", Font.BOLD, 14));

        btnRichardson.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RichardsonSelect().setVisible(true);
            }
        });
 
        add(label);
        add(btnTrapezio);                
        add(btnSimpson);
        add(btnRichardson);               
    }
    
    public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    new InterfaceMain().setVisible(true);
                }
        });
    }
}