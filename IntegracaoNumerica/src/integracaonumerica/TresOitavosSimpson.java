package integracaonumerica;

import java.util.ArrayList;

public class TresOitavosSimpson extends Metodo {

    
    public TresOitavosSimpson(ArrayList<Double> xn, ArrayList<Double> yn) {
        super(xn, yn);
    }

    public double calculo() {
        double soma = 0;
        double h = xn.get(1) - xn.get(0);
      
        for (int i = 0; i < yn.size(); i++) {
            if (i == 0 || i == yn.size() - 1) {
                soma += yn.get(i);
            } else if (i % 3 != 0) {
                soma += yn.get(i) * 3;
            } else if (i % 3 == 0) {
                soma += yn.get(i) * 2;
            }
        }
        return soma * (h *  3/8);
    }
    
    public double erro(double dif_quarta) {
        double b = xn.get(xn.size()-1) - xn.get(0);
        double x =  Math.pow(b, 5) / (80 * Math.pow((xn.size()-1), 4));
        return x * dif_quarta;
    }
}
