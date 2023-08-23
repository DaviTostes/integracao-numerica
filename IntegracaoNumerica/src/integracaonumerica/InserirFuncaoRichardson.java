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

public class InserirFuncaoRichardson extends JFrame {
    private JButton btnTrapezio;
    private JButton btnSimpson;
    private JButton btnRichardson;

    public InserirFuncaoRichardson(String metodoSelecionado){
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
        JLabel labelSub1 = new JLabel("Digite o numero de subintervalos do primeiro calculo ");
        JLabel labelSub2 = new JLabel("Digite o numero de subintervalos do segundo calculo ");

        JTextField funcTextField = new JTextField(30);
        JTextField InfTextField = new JTextField(10);
        JTextField SupTextField = new JTextField(10);
        JTextField SubTextField1 = new JTextField(10);
        JTextField SubTextField2 = new JTextField(10);

        JButton btn = new JButton("Executar");
        btn.setFont(new Font("Arial", Font.BOLD, 14));

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int subIntervalos1 = Integer.parseInt(SubTextField1.getText())+1;
                int subIntervalos2 = Integer.parseInt(SubTextField2.getText())+1;

                Parser parser1 = new Parser(funcTextField.getText(), Double.parseDouble(InfTextField.getText()), Double.parseDouble(SupTextField.getText()), 
                subIntervalos1);

                Parser parser2 = new Parser(funcTextField.getText(), Double.parseDouble(InfTextField.getText()), Double.parseDouble(SupTextField.getText()), 
                subIntervalos2);

                ArrayList<Double> xn = parser1.getXn();
                ArrayList<Double> yn = parser1.getYn();

                ArrayList<Double> xn2 = parser2.getXn();
                ArrayList<Double> yn2 = parser2.getYn();

                if(metodoSelecionado == "Trapezio-R") {
                    Trapezio trap1 = new Trapezio(xn, yn);
                    Trapezio trap2 = new Trapezio(xn2, yn2);

                    Richardson richas = new Richardson(trap1, trap2, metodoSelecionado);

                    new ResultadoRichardson(trap1.calculo(), trap2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonTresOitavos-R") {
                    TresOitavosSimpson tresoit1 = new TresOitavosSimpson(xn, yn);
                    TresOitavosSimpson tresoit2 = new TresOitavosSimpson(xn2, yn2);

                    Richardson richas = new Richardson(tresoit1, tresoit2, metodoSelecionado);

                    new ResultadoRichardson(tresoit1.calculo(), tresoit2.calculo(), richas.calculoRichardson()).setVisible(true);
                }

                if(metodoSelecionado == "SimpsonUmTerco-R") {
                    UmTercoSimpson umter1 = new UmTercoSimpson(xn, yn);
                    UmTercoSimpson umter2 = new UmTercoSimpson(xn2, yn2);

                    Richardson richas = new Richardson(umter1, umter2, metodoSelecionado);

                    new ResultadoRichardson(umter1.calculo(), umter2.calculo(), richas.calculoRichardson()).setVisible(true);
                }
            }
        });

        add(labelFunc);
        add(funcTextField);
        add(labelInf);
        add(InfTextField);
        add(labelSup);
        add(SupTextField);
        add(labelSub1);
        add(SubTextField1);
        add(labelSub2);
        add(SubTextField2);
        add(btn);
    }
}