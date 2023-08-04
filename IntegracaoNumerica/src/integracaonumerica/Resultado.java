package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Resultado extends JFrame {
    public Resultado(int subintervalos, double resultado) {
        System.out.println(resultado);
        setTitle("Seletor de metodo");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 500);
        setResizable(false);
        setLayout(new FlowLayout());
            
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 1000) / 2;
        int y = (tamanhoTela.height - 500) / 2;
        setLocation(x, y);

        JLabel label = new JLabel("Resultado: "+resultado);

        add(label);
    }
}
