package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
        
        
        JLabel labelFunc = new JLabel("Digite a função: "); 
        JLabel labelInf = new JLabel("Digite o limite de integração inferior: "); 
        JLabel labelSup = new JLabel("Digite o limite de integração superior: ");
        JLabel labelSub = new JLabel("Digite o numero de subintervalos ");

        JTextField funcTextField = new JTextField(30);
        JTextField InfTextField = new JTextField(10);
        JTextField SupTextField = new JTextField(10);
        JTextField SubTextField = new JTextField(10);

        JButton btn = new JButton("Executar");
        btn.setFont(new Font("Arial", Font.BOLD, 14));

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int subIntervalos = Integer.parseInt(SubTextField.getText())+1;

                Parser parser = new Parser(funcTextField.getText(), Double.parseDouble(InfTextField.getText()), Double.parseDouble(SupTextField.getText()), 
                subIntervalos);

                ArrayList<Double> xn = parser.getXn();
                ArrayList<Double> yn = parser.getYn();

                Derivada derivada = new Derivada(subIntervalos, xn, yn);

                if(metodoSelecionado == "Trapezio") {
                    Trapezio trap = new Trapezio(xn, yn);

                    new Resultado(subIntervalos, trap.calculo(), trap.erro(derivada.DerivadaSegunda()), xn, yn).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonTresOitavos") {
                    TresOitavosSimpson tresoit = new TresOitavosSimpson(xn, yn);

                    new Resultado(subIntervalos, tresoit.calculo(), tresoit.erro(derivada.DerivadaQuarta()), xn, yn).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonUmTerco") {
                    UmTercoSimpson umter = new UmTercoSimpson(xn, yn);

                    new Resultado(subIntervalos, umter.calculo(), umter.erro(derivada.DerivadaQuarta()), xn, yn).setVisible(true);
                }
            }
        });

        add(labelFunc);
        add(funcTextField);
        add(labelInf);
        add(InfTextField);
        add(labelSup);
        add(SupTextField);
        add(labelSub);
        add(SubTextField);
        add(btn);

    }
}