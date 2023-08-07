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

public class SimpsonSelect extends JFrame{
    private JButton btnSimpsonOitavos;
    private JButton btnSimpsonTerco;

    public SimpsonSelect(){
        setTitle("Selecionar Metodo de Simpson");
        setSize(350, 250);
        setResizable(false); // Desabilita o redimensionamento da janela
        setLayout(new FlowLayout());

        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 300) / 2;
        int y = (tamanhoTela.height - 250) / 2;
        setLocation(x, y);

        JLabel label = new JLabel("Selecione o método desejado para Simpson\n");

        btnSimpsonOitavos = new JButton("Tres Oitavos");
        btnSimpsonOitavos.setFont(new Font("Arial", Font.BOLD, 14));

        btnSimpsonOitavos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeitorDeArquivo("SimpsonTresOitavos").setVisible(true);
            }
        });

        btnSimpsonTerco = new JButton("Um Terço");
        btnSimpsonTerco.setFont(new Font("Arial", Font.BOLD, 14));

        btnSimpsonTerco.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeitorDeArquivo("SimpsonUmTerco").setVisible(true);
            }
        });

        add(label);       
        add(btnSimpsonOitavos);
        add(btnSimpsonTerco);
    }
}