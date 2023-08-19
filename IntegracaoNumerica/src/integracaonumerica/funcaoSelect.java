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

public class funcaoSelect extends JFrame{
    private JButton btnFuncao;
    private JButton btnPontos;

    public funcaoSelect(String metodoSelecionado){
        setTitle("Selecione por qual forma eseja calcular esse metodo");
        setSize(350, 250);
        setResizable(false); // Desabilita o redimensionamento da janela
        setLayout(new FlowLayout());

        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 300) / 2;
        int y = (tamanhoTela.height - 250) / 2;
        setLocation(x, y);

        JLabel label = new JLabel("Selecione o meio desejado\n");

        btnFuncao = new JButton("Funcao");
        btnFuncao.setFont(new Font("Arial", Font.BOLD, 14));

        btnFuncao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new InserirFuncao(metodoSelecionado).setVisible(true);
                dispose();
            }
        });

        btnPontos = new JButton("Pontos");
        btnPontos.setFont(new Font("Arial", Font.BOLD, 14));

        btnPontos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LeitorDeArquivo(metodoSelecionado).setVisible(true);
                dispose();
            }
        });

        add(label);       
        add(btnFuncao);
        add(btnPontos);
    }
}