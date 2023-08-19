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

public class InserirFuncao extends JFrame {
    private JButton btnTrapezio;
    private JButton btnSimpson;
    private JButton btnRichardson;

    public InserirFuncao(String metodoSelecionado){
        setTitle("Funcao");
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
    }
}