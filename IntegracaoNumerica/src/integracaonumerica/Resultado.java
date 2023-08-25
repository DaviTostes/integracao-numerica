package integracaonumerica;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Resultado extends JFrame {
    public Resultado(int subintervalos, double resultadoF, double erro, ArrayList<Double> xn, ArrayList<Double> yn) {
        setTitle("Seletor de metodo");
        setSize(1000, 500);
        setResizable(false);
        setLayout(new FlowLayout());
            
        Dimension tamanhoTela = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (tamanhoTela.width - 1000) / 2;
        int y = (tamanhoTela.height - 500) / 2;
        setLocation(x, y);

        JLabel labelResultF = new JLabel("Resultado Final: "+String.format("%.5f", resultadoF));
        JLabel labelSubintervalos = new JLabel("Subintervalos: "+subintervalos);
        JLabel labelErro = new JLabel("Erro: "+erro);

        Object[][] data = new Object[xn.size()][2];
        String[] columnNames = {"X", "Y"};
       
        for(int i=0; i <xn.size(); i++) {
            data[i][0] = xn.get(i);
            data[i][1] = yn.get(i);
        }

        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        JTable table = new JTable(model);

        add(labelResultF);
        add(labelSubintervalos);
        add(labelErro);
        add(table);
    }
}