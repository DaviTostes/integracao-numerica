package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ResultadoRichardson extends JFrame {
    public ResultadoRichardson(double resultado1, double resultado2, double resultadoF) {
        setTitle("Seletor de metodo");
        setSize(1000, 500);
        setResizable(false);
        setLayout(new FlowLayout());
            
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 1000) / 2;
        int y = (tamanhoTela.height - 500) / 2;
        setLocation(x, y);

        JLabel labelResult1 = new JLabel("Resultado1: "+String.format("%.5f", resultado1));
        JLabel labelResult2 = new JLabel("Resultado2: "+String.format("%.5f", resultado2));
        JLabel labelResultF = new JLabel("Resultado Final: "+String.format("%.5f", resultadoF));

        add(labelResult1);
        add(labelResult2);
        add(labelResultF);
    }
}